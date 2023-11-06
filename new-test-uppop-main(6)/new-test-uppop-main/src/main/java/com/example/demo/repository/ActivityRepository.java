package com.example.demo.repository;


import com.example.demo.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
    // คุณสามารถเพิ่มเมธอดเพิ่มเติมตามต้องการ
}
