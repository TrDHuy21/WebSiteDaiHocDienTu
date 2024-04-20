package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.enums.RolesEnum;
import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.RoleEntity;
import com.WebsiteDaiHocDienTu.model.entity.UserEntity;
import com.WebsiteDaiHocDienTu.respository.RoleRepository;
import com.WebsiteDaiHocDienTu.respository.UserRepository;
import com.WebsiteDaiHocDienTu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<?> save(UserDTO userDTO) {
        RoleEntity role = roleRepository.findByName(RolesEnum.USER.name()).orElseThrow(()-> new NullPointerException("Role not null"));
        UserEntity test = userRepository.findOneByUserName("user").orElseThrow();
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(role);
        UserEntity user = new UserEntity();
        user.setRoles(roles);
        user.setUserName(userDTO.getUserName());
        user.setFullName(userDTO.getUserName());
        user.setPassword(userDTO.getPassword());
        user = userRepository.save(user);
        return ResponseEntity.ok(user);
    }
}
