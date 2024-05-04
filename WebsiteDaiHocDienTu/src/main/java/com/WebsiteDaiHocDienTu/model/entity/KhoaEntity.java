package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "khoa")
public class KhoaEntity {

    @Id
    @GeneratedValue(generator = "KHOA")
    @GenericGenerator(name="KHOA",strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "ten")
    private String ten;

    @Column(name = "mo_ta")
    private  String moTa;

    @OneToMany(mappedBy = "khoaEntity")
    private List<NganhEntity> nganhEntityList;

    @OneToMany(mappedBy = "khoaEntity")
    private List<MonHocEntity> monHocEntityList;


}
