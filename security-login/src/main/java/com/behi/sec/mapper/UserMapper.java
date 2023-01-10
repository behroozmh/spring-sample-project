package com.behi.sec.mapper;

import com.behi.sec.entity.UserEntity;
import com.behi.sec.model.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserModel ConvertToModel(UserEntity entity);
    UserEntity ConvertToEntity(UserModel model);
    List<UserModel> ConvertToModel(List<UserEntity> entity);
    List<UserEntity> ConvertToEntity(List<UserModel> model);
}
