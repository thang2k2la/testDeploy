package com.example.exe202backend.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDTO {
    private long id;
    private int quantity;
    private long productId;
    private long cartId;
    private boolean status;
}
