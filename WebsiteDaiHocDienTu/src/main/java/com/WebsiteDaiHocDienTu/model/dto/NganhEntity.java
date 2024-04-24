package com.WebsiteDaiHocDienTu.model.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NganhEntity {
    private String id;
    private String ten;
    private  String moTa;
    private  Byte state;
}
