package com.WebsiteDaiHocDienTu.controller.QuanLyKhoaController;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.service.LopMonHocService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/qlk/lop-mon-hoc")
public class LopMonHocController {
    @Autowired
    private LopMonHocService lopMonHocService;

    @GetMapping("")
    public String listLopMonHoc(Model model) {
        List<LopMonHocEntity> lopMonHocEntityList = lopMonHocService.getAllByQLK();

        model.addAttribute("user", SecurityUtils.getPrinciple());
        model.addAttribute("lopMonHocList", lopMonHocEntityList);
        return "admin/lopmonhoc/list-lopMonHoc";
    }
    @GetMapping("/formCreate")
    public String formCreate(@RequestParam("lopMonHocId") int lopMonHocId, Model model) {
        return "admin/lopmonhoc/lopMonHoc-form";
    }
}
