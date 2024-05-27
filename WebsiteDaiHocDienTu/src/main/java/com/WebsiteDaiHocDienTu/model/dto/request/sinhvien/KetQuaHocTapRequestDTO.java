package com.WebsiteDaiHocDienTu.model.dto.request.sinhvien;

import lombok.Data;

@Data
public class KetQuaHocTapRequestDTO {
    private Integer id;
    private Float tx1;
    private Float tx2;
    private Float tx3;
    private Float giuaKi1;
    private Float giuaKi2;
    private Float giuaKi3;
    private Float thi1;
    private Float thi2;
    private Float phucKhao1;
    private Float phucKhao2;
    private MonHocRequestSinhVienDTO monHoc;

}
