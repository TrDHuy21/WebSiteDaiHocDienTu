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
    private String id;
    private int khoa;
    private  Byte state;
}
