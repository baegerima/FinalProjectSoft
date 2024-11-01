package com.example.chyraistyle.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

/**
 * Модель пользователя с уникальным именем и адресом электронной почты.
 */
@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    /**
     * Уникальный ID, создается автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Логин пользователя, не повторяется, максимум 50 символов.
     */
    @Column(nullable = false, unique = true, length = 50)
    String username;

    /**
     * Электронная почта пользователя, тоже уникальна.
     */
    @Column(nullable = false, unique = true, length = 100)
    String email;

    /**
     * Пароль пользователя.
     */
    @Column(nullable = false)
    String password;

    /**
     * Когда пользователь был создан, автоматически ставится текущая дата.
     */
    @Column(name = "created_at", nullable = false, updatable = false)
    LocalDateTime createdAt;

    /**
     * Устанавливает createdAt перед сохранением.
     */
    @PrePersist
    private void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}