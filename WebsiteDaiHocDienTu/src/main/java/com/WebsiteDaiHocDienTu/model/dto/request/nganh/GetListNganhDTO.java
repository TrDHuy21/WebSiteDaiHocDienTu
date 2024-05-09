package com.WebsiteDaiHocDienTu.model.dto.request.nganh;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetListNganhDTO {
    private Integer id;
    private String ten;
    private  String moTa;
    private  Byte state;
}
