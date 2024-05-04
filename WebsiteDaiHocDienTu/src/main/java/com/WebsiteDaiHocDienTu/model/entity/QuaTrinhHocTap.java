package com.WebsiteDaiHocDienTu.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quatrinhhoctap")
public class QuaTrinhHocTap {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "sotietnghi")
    private int soTietNghi;

    @ManyToOne
    @JoinColumn(name = "lopmonhoc_id")
    private LopMonHocEntity lopMonHocEntity;
//
//    @ManyToOne
//    @JoinColumn(name = "lopmonhoc_id")
//    private LopMonHocEntity lopMonHocEntity;

}
