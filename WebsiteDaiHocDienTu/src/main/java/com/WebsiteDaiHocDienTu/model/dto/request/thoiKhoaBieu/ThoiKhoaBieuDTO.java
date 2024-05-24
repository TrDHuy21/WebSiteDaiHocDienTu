package com.WebsiteDaiHocDienTu.model.dto.request.thoiKhoaBieu;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ThoiKhoaBieuDTO {
    private LocalDate date;
    private Integer thu;
    private List<LichHocDTO> lichHocList;
}
