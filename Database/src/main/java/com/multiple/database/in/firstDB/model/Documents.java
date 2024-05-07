package com.multiple.database.in.firstDB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "document")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fileName;
    private String fileDetails;
    private String fileWorks;

}
