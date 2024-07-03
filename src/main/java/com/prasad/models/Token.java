package com.prasad.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Token extends BaseModel{

    private String token;
    @ManyToOne
    private User user;
    private Date expiryAt;
}
