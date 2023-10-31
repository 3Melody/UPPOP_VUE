package com.example.demo.repository;


import com.example.demo.model.PersonActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonActivityRepository extends JpaRepository<PersonActivity, Long> {
    // คุณสามารถเพิ่มเมธอดเพิ่มเติมตามต้องการ
}
