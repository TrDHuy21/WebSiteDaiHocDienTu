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
@Table(name = "lopchinhquy")
public class LopChinhQuyEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "khoa")
    private int khoa;

    @ManyToOne
    @JoinColumn(name = "chuongtrinhhoc_id")
    private ChuongTrinhHocEntity chuongTrinhHocEntity;

    @OneToMany(mappedBy = "lopChinhQuyEntity")
    private List<UserEntity> userEntityList;
}
