package com.example.chyraistyle.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Column(length = 50) // Цвет вещи
    private String color;

    @Column(length = 50) // Сезон
    private String season;

    @Column(name = "weather_type", length = 50) // Тип погоды
    private String weatherType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "created_at", nullable = false, updatable = false) // Дата создания
    private LocalDateTime createdAt;
    @PrePersist
    private void init() {
        this.createdAt = LocalDateTime.now();
    }
}
