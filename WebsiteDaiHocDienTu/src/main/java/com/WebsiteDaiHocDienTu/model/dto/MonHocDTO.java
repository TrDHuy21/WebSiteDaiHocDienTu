package com.WebsiteDaiHocDienTu.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MonHocDTO {

    private Integer id;

    private String ten;

    private int soTin;

    private Float heSoTx1;

    private Float heSoTx2;

    private Float heSoTx3;

    private Float heSoGiuaKi1;

    private Float heSoGiuaKi2;

    private Float heSoGiuaKi3;

    private Float heSoThi;

    private  Byte state;
}
