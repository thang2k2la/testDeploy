package com.example.exe202backend.mapper;

import com.example.exe202backend.dto.OrderDetailDTO;
import com.example.exe202backend.models.OrderDetail;
import com.example.exe202backend.models.Payment;
import com.example.exe202backend.models.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userId", source = "userModel.id")
    @Mapping(target = "paymentId", source = "payment.id")
    OrderDetailDTO toDto(OrderDetail orderDetail);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userModel", source = "userId", qualifiedByName = "userModelFromId")
    @Mapping(target = "payment", source = "paymentId", qualifiedByName = "paymentFromId")
    OrderDetail toEntity(OrderDetailDTO orderDetailDTO);

    @Mapping(target = "status", source = "status")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "userModel", source = "userId", qualifiedByName = "userModelFromId")
    @Mapping(target = "payment", source = "paymentId", qualifiedByName = "paymentFromId")
    void updateOrderDetailFromDto(OrderDetailDTO orderDetailDTO, @MappingTarget OrderDetail orderDetail);

    @Named("userModelFromId")
    default UserModel userModelFromId(long id) {
        UserModel userModel = new UserModel();
        userModel.setId(id);
        return userModel;
    }

    @Named("paymentFromId")
    default Payment paymentFromId(long id) {
        Payment payment = new Payment();
        payment.setId(id);
        return payment;
    }
}
