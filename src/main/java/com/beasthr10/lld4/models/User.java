package com.beasthr10.lld4.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
public class User extends BaseModel{
    private final String name;
    private final String email;
    private final String password;
    @ManyToOne
    private final List<Group> groups;
}
