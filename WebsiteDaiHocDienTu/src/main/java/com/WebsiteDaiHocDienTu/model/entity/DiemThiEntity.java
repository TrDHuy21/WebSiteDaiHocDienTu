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
@Table(name = "diemthi")
public class DiemThiEntity {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "thilan1")
    private float thiLan1;

    @Column(name = "thilan2")
    private float thiLan2;

    @Column(name = "phuckhao1")
    private float phucKhao1;

    @Column(name = "phuckhao2")
    private float phucKhao2;

    @ManyToOne
    @JoinColumn(name = "ketquahoctap_id")
    private KetQuaHocTapEntity ketQuaHocTapEntity;
}
