package com.example.exe202backend.mapper;

import com.example.exe202backend.dto.OrderItemDTO;
import com.example.exe202backend.models.OrderDetail;
import com.example.exe202backend.models.OrderItem;
import com.example.exe202backend.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "orderDetailId", source = "orderDetail.id")
    OrderItemDTO toDto(OrderItem orderItem);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "product", source = "productId", qualifiedByName = "productFromId")
    @Mapping(target = "orderDetail", source = "orderDetailId", qualifiedByName = "orderDetailFromId")
    OrderItem toEntity(OrderItemDTO orderItemDTO);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "product", source = "productId", qualifiedByName = "productFromId")
    @Mapping(target = "orderDetail", source = "orderDetailId", qualifiedByName = "orderDetailFromId")
    void updateOrderItemFromDto(OrderItemDTO orderItemDTO, @MappingTarget OrderItem orderItem);

    @Named("productFromId")
    default Product productFromId(long id) {
        Product product = new Product();
        product.setId(id);
        return product;
    }

    @Named("orderDetailFromId")
    default OrderDetail orderDetailFromId(long id) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(id);
        return orderDetail;
    }
}
