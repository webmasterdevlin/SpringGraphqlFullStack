package com.example.springgraphqlfullstack.model;

import com.example.springgraphqlfullstack.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = true)
    private Client client;
    private String name;
    private String description;
    private Status status;
}
