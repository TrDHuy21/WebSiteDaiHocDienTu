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
@Table(name = "diemthuongxuyen")
public class DiemThuongXuyenEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "diem")
    private float diem;

    @Column(name = "loai")
    private byte loai;

    @ManyToOne
    @JoinColumn(name = "ketquahoctap_id")
    private KetQuaHocTapEntity ketQuaHocTapEntity;
}
