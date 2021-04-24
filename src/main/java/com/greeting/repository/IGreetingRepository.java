package com.greeting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greeting.model.Greeting;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}
