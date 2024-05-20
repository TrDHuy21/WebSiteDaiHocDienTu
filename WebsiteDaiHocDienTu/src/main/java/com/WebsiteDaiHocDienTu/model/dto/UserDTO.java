package com.WebsiteDaiHocDienTu.model.dto;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String userName;
    private String password;
    private String ho;
    private String ten;
    private String email;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private Byte state;
}
