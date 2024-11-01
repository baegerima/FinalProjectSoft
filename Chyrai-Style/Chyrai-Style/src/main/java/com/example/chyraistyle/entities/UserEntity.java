package com.example.chyraistyle.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email"}) // Уникальный email
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, unique = true, length = 50) // Логин пользователя
    String username;

    @Column(nullable = false, unique = true, length = 100) // Email пользователя
    String email;

    @Column(nullable = false) // Пароль пользователя
    String password;

    @Column(name = "created_at", nullable = false, updatable = false) // Дата создания
    LocalDateTime createdAt;

    @PrePersist
    private void init() {
        this.createdAt = LocalDateTime.now(); // Инициализация даты создания
    }
}
