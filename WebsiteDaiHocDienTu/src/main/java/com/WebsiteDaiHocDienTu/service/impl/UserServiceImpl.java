package com.WebsiteDaiHocDienTu.service.impl;

import com.WebsiteDaiHocDienTu.enums.RolesEnum;
import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.RoleEntity;
import com.WebsiteDaiHocDienTu.model.entity.UserEntity;
import com.WebsiteDaiHocDienTu.respository.RoleRepository;
import com.WebsiteDaiHocDienTu.respository.UserRepository;
import com.WebsiteDaiHocDienTu.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        user.setStatus(1);
        user = userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @Override
    public ResponseEntity<?> updateByUser(UserDTO userDTO) {
        return null;
    }

    /**
     * tối ưu truy vấn
     * custom transactional
     * @param ids
     * @return
     */
    @Transactional
    @Override
    public ResponseEntity<?> deleteByUserId(Long[] ids) {
        try {
            UserEntity user;
            for (Long id: ids){
                user = userRepository.findById(id).orElseThrow(()-> new NullPointerException("User not found"));
                user.setStatus(0);
                userRepository.save(user);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();//custom rollback
            //return ở đây
        }
        return ResponseEntity.ok("delete success!");
    }
}
