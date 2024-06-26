package com.WebsiteDaiHocDienTu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LopMonHocDTO {
    private Integer id;
    private String ten;
    private Date ngayBatDau;
    private Byte state;
}
