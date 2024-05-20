package com.WebsiteDaiHocDienTu.model.dto.request.chuongtrinhhoc;

import lombok.Data;

@Data
public class GetListChuongTrinhHocDTO {
    private Integer id;
    private String ten;
    private String moTa;
    private  Byte state;
}
