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
@Table(name = "giang_vien")
public class GiangVienEntity {

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

    @ManyToMany
    @JoinTable (
            name="monhoc_giangvien",
            joinColumns=@JoinColumn(name="giang_vien_id"),
            inverseJoinColumns=@JoinColumn(name="mon_hoc_id")
    )
    private List<MonHocEntity> monHocEntityList;

    @OneToMany(mappedBy = "giangVienEntity")
    private List<LopMonHocEntity> lopMonHocEntityList;
}
