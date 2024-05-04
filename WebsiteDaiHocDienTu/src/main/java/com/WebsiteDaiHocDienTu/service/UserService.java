package com.WebsiteDaiHocDienTu.service;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<?> save(UserDTO userDTO);
    ResponseEntity<?>updateByUser(UserDTO userDTO);
    ResponseEntity<?> deleteByUserId(Long[] ids);

}
