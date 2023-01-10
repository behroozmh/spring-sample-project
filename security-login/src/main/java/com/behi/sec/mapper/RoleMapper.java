package com.behi.sec.mapper;

import com.behi.sec.entity.RoleEntity;
import com.behi.sec.model.RoleModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleModel ConvertToModel(RoleEntity entity);
    RoleEntity ConvertToEntity(RoleModel model);
    List<RoleModel> ConvertToModel(List<RoleEntity> entity);
    List<RoleEntity> ConvertToEntity(List<RoleModel> model);
}
