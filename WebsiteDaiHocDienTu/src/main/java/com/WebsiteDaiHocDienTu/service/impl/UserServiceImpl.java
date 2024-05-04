package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.enums.RolesEnum;
import com.WebsiteDaiHocDienTu.mapper.DataMapper;
import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.RoleEntity;
import com.WebsiteDaiHocDienTu.model.entity.UserEntity;
import com.WebsiteDaiHocDienTu.respository.RoleRepository;
import com.WebsiteDaiHocDienTu.respository.UserRepository;
import com.WebsiteDaiHocDienTu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<?> save(UserDTO userDTO) {
        UserEntity user = DataMapper.toEntity(userDTO,UserEntity.class);
        RoleEntity role = roleRepository.findByTen(RolesEnum.USER.name()).orElseThrow(()->new NullPointerException("role not found"));
        user.setRoles(List.of(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setState((byte)1);
        user = userRepository.save(user);
        return ResponseEntity.ok(DataMapper.toDTO(user,UserDTO.class));


//        UserEntity user = new UserEntity();
//        user.setUserName(userDTO.getUserName());
//        user.setPassword(userDTO.getPassword());
//        user = userRepository.save(user);
//        return ResponseEntity.ok(user);
    }
}
