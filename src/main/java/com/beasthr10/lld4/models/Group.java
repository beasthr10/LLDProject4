package com.beasthr10.lld4.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Entity
public class Group extends BaseModel{
    private final String name;
    private final List<User> participants;
    private final List<User> admins;

}
