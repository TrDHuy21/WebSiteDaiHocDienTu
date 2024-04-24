package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quan_ly_khoa")
public class QuanLyKhoaEntity {


    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "state")
    private Byte state;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "khoa_id")
    private KhoaEntity khoaEntity;


}
