package com.WebsiteDaiHocDienTu.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LopChinhQuyDTO {
    private Integer id;
    private int khoa;
    private  Byte state;
}
