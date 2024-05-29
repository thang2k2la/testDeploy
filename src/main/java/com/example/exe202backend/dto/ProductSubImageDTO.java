package com.example.exe202backend.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductSubImageDTO {
    private long id;
    private String url;
    private boolean status;
    private long productId;
}
