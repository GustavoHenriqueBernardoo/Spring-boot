package com.ltp.globalsuperstore.repository.service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.ltp.globalsuperstore.Constants;
import com.ltp.globalsuperstore.Item;
import com.ltp.globalsuperstore.repository.ItemRepository;

public class ItemService {

  ItemRepository itemRepository = new ItemRepository();
  private String status = "";

  public Item getItem(int index) {
    return itemRepository.getItem(index);
  }

  public void addItem(Item item) {
    itemRepository.addItem(item);
  }

  public void updateItem(Item item, int index) {
    itemRepository.updateItem(item, index);
  }

  public List<Item> getItems() {
    return itemRepository.getItems();
  }

  public int getIndexFromId(String id) {
    for (int i = 0; i < getItems().size(); i++) {
      if (getItem(i).getId().equals(id))
        return i;
    }
    return Constants.NOT_FOUND;
  }

  public boolean within5Days(Date newDate, Date oldDate) {
    long diff = Math.abs(newDate.getTime() - oldDate.getTime());
    return (int) (TimeUnit.MILLISECONDS.toDays(diff)) <= 5;
  }

  public Item getGradeById(String id) {
    int index = getIndexFromId(id);

    return index == Constants.NOT_FOUND ? new Item() : getItem(index);

  }

  public void submitItem(Item item) {
    setStatus(Constants.SUCCESS_STATUS);

    int index = getIndexFromId(item.getId());
    if (index == Constants.NOT_FOUND) {
      addItem(item);
    } else if (within5Days(item.getDate(), getItem(index).getDate())) {
      updateItem(item, index);
    } else {
      setStatus(Constants.FAILED_STATUS);
    }

  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

}
