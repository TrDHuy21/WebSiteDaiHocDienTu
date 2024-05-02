package com.WebsiteDaiHocDienTu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChuongTrinhHocDTO {
    private Integer id;
    private String ten;
    private String moTa;
    private  Byte state;

}
