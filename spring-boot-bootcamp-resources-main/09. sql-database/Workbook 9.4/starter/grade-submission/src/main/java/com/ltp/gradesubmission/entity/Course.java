package com.ltp.gradesubmission.entity;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "subject", nullable = false)
    @NotBlank(message = "Subject cannot be Blank")
    private String subject;

    @NonNull
    @Column(name = "code", nullable = false, unique = true)
    @NotBlank(message = "The course code cannot be blank")
    private String code;

    @NonNull
    @Column(name = "description", nullable = false)
    @NotBlank(message = "Course description cannot be blank")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;

}
