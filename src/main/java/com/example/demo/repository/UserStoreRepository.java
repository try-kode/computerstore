package com.example.demo.repository;

import com.example.demo.model.UserStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStoreRepository extends JpaRepository<UserStore, Long> {
}
