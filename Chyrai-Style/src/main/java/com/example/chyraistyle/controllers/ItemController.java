package com.example.chyraistyle.controllers;

import com.example.chyraistyle.entities.ItemEntity;
import com.example.chyraistyle.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // Получение списка всех вещей
    @GetMapping
    public List<ItemEntity> getAllItems() {
        return itemRepository.findAll();
    }

    // Получение вещи по ID
    @GetMapping("/{id}")
    public ItemEntity getItemById(@PathVariable Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));
    }

    // Создание новой вещи
    @PostMapping
    public ItemEntity createItem(@RequestBody ItemEntity item) {
        return itemRepository.save(item);
    }

    // Обновление вещи
    @PutMapping("/{id}")
    public ItemEntity updateItem(@PathVariable Long id, @RequestBody ItemEntity updatedItem) {
        ItemEntity item = itemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with id " + id));
        item.setName(updatedItem.getName());
        item.setCategory(updatedItem.getCategory());
        item.setColor(updatedItem.getColor());
        item.setSeason(updatedItem.getSeason());
        item.setWeatherType(updatedItem.getWeatherType());
        return itemRepository.save(item);
    }

    // Удаление вещи
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemRepository.deleteById(id);
    }
}