package com.ltp.contacts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.repository.ContactRepository;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

@SpringBootTest
@AutoConfigureMockMvc
class ContactsApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ContactRepository contactRepository;

	@Autowired
	private ObjectMapper objectMapper;

	private Contact[] contacts = new Contact[] {
			new Contact("1", "Jon Snow", "6135342524"),
			new Contact("2", "Tyrion Lannister", "4145433332"),
			new Contact("3", "The Hound", "3452125631"),
	};

	@BeforeEach
	void setup() {
		for (int i = 0; i < contacts.length; i++) {
			contactRepository.saveContact(contacts[i]);
		}
	}

	@AfterEach
	void clear() {
		contactRepository.getContacts().clear();
	}

	@Test
	public void getContactByIdTest() throws Exception {

		RequestBuilder getRequest = MockMvcRequestBuilders.get("/contact/1");
		mockMvc.perform(getRequest)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value(contacts[0].getName()));

	}

	@Test
	public void getAllContactsTest() throws Exception {
		RequestBuilder getRequest = MockMvcRequestBuilders.get("/contact/all");
		mockMvc.perform(getRequest)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.size()").value(contacts.length))
				.andExpect(
						jsonPath("$.[?(@.id == \"2\" && @.name == \"Tyrion Lannister\" && @.phoneNumber == \"4145433332\")]")
								.exists());

	}

	@Test
	public void validContactCreation() throws Exception {
		Contact newContact = new Contact(null, "Jon", "88855");
		String mapper = objectMapper.writeValueAsString(newContact);
		RequestBuilder postRequest = MockMvcRequestBuilders.post("/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper);

		mockMvc.perform(postRequest)
				.andExpect(status().isCreated());
	}

	@Test
	public void invalidContactCreation() throws Exception {
		Contact newContact = new Contact(null, "  ", "  ");
		String mapper = objectMapper.writeValueAsString(newContact);
		RequestBuilder postRequest = MockMvcRequestBuilders.post("/contact")
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper);

		mockMvc.perform(postRequest)
				.andExpect(status().isBadRequest());

	}

	@Test
	public void contactNotFoundTest() throws Exception {
		RequestBuilder getRequest = MockMvcRequestBuilders.get("/contact/4");
		mockMvc.perform(getRequest)
				.andExpect(status().isNotFound());
	}

}
