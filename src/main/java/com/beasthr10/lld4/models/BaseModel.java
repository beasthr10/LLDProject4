package com.beasthr10.lld4.models;

import jakarta.persistence.MappedSuperclass;

import java.util.Date;
@MappedSuperclass
public class BaseModel {
    private final Long id;
    private final Date createdAt;
    private final Date updatedAt;
}
