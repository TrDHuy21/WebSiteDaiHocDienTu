package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "sinh_vien")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SinhVienEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "state")
    private Byte state;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "lop_chinh_quy_id")
    private LopChinhQuyEntity lopChinhQuyEntity;

    @ManyToMany
    @JoinTable (
            name="lopmonhoc_sinhvien",
            joinColumns=@JoinColumn(name="sinhvien_id"),
            inverseJoinColumns=@JoinColumn(name="lopmonhoc_id")
    )
    private List<LopMonHocEntity> lopMonHocEntityList;

    @OneToMany(mappedBy = "sinhVienEntity")
    private List<QuaTrinhHocTapEntity> quaTrinhHocTapEntityList;
}
