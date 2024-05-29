package com.example.exe202backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@SuperBuilder
public class UserAddress extends BaseModel{
    private String province;
    private String district;
    private String ward;
    private String address;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel userModel;
}
