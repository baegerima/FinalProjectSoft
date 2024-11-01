package com.example.chyraistyle.repositories;

import com.example.chyraistyle.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity, Long> {
}
