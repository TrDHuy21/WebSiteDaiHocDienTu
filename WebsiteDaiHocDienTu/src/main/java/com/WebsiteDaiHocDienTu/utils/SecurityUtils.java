package com.WebsiteDaiHocDienTu.utils;

import com.WebsiteDaiHocDienTu.auth.userDetials.CustomUserDetails;
import com.WebsiteDaiHocDienTu.mapper.DataMapper;
import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.UserEntity;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static UserDTO getPrinciple(){
        SecurityContextHolder.getContext();
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        CustomUserDetails userDetails =(CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity user = userDetails.getUser();
        return DataMapper.toDTO(user,UserDTO.class);
    }

}
