package com.metsoft.erpapp.model.dbModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name="roles")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
}
