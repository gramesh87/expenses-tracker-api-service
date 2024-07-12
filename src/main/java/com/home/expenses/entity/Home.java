package com.home.expenses.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

//@Entity
//@Table(name = "home")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Home {

//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;


    @CreationTimestamp
    private LocalDateTime createdTime;

    @UpdateTimestamp
    private LocalDateTime updatedTime;
}
