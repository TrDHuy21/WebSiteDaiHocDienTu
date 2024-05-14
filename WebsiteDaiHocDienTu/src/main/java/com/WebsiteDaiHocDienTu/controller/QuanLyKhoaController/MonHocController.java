package com.WebsiteDaiHocDienTu.controller.QuanLyKhoaController;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.MonHocEntity;
import com.WebsiteDaiHocDienTu.service.MonHocService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/qlk/mon-hoc")
public class MonHocController {
    @Autowired
    MonHocService monHocService;

    @GetMapping("")
    public String listMonHoc(Model model) {
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);

        List<MonHocEntity> monHocDTOList = monHocService.findAllByQLK();
        model.addAttribute("monHocList", monHocDTOList);

        return "admin/monhoc/list-monHoc";
    }

    @GetMapping("/formCreate")
    public String formCreate(Model model) {
        UserDTO userDTO = SecurityUtils.getPrinciple();

        model.addAttribute("user", userDTO);
        model.addAttribute("monHoc", monHocService.getNewMonHocWithKhoa());
        return "admin/monhoc/monHoc-form";
    }

    @PostMapping("/save")
    public String saveMonHoc(@ModelAttribute("monHoc") MonHocEntity monHocEntity, Model model) {
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);
        System.out.println(monHocEntity.getKhoa().getId());
        try {
            monHocService.save(monHocEntity);
            model.addAttribute("mes","Thêm môn học thành công");
        }catch (Exception e) {
            model.addAttribute("mes","Thêm ngành thất bại\n" +
                    "nguyên nhân: " + e.getMessage() );
            model.addAttribute("monHoc", monHocEntity);
            return "admin/monhoc/monHoc-form";
        }

        return "redirect:/qlk/mon-hoc";
    }

    @GetMapping("/formUpdate")
    public String formUpdate(@RequestParam("monHocId") int id, Model model) {
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);

        MonHocEntity monHocEntity = monHocService.findByIdAndKhoaId(id);
        System.out.println(monHocEntity.getKhoa());
        model.addAttribute("monHoc", monHocEntity);
        return "admin/monhoc/monHoc-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("monHocId") int id) {
        monHocService.deleteById(id);
        return "redirect:/qlk/mon-hoc";
    }
}
