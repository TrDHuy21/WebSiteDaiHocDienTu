package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "nganh")
public class NganhEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private  String moTa;

    @Column(name = "state")
    private  Byte state;

    @ManyToOne()
    @JoinColumn(name = "khoa_id")
    private KhoaEntity khoa;

    @OneToMany(mappedBy = "nganh")
    private List<ChuongTrinhHocEntity> chuongTrinhHocList;


}
