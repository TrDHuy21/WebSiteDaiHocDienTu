package com.WebsiteDaiHocDienTu.controller.QuanLyKhoaController;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.GiangVienEntity;
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
    private MonHocService monHocService;

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
        model.addAttribute("user", SecurityUtils.getPrinciple());
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
        model.addAttribute("user", SecurityUtils.getPrinciple());

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

    @GetMapping("/giang-vien")
    public String listGiangVien(@RequestParam("monHocId") int id, Model model) {
        MonHocEntity monHoc = monHocService.findByIdAndKhoaId(id);
        List<GiangVienEntity> listGiangVienOfMonHoc = monHoc.getGiangVienList();
        List<GiangVienEntity> listGiangVienOfKhoa = monHoc.getKhoa().getGiangVienList();

        model.addAttribute("user", SecurityUtils.getPrinciple());
        model.addAttribute("monHoc", monHoc);
        model.addAttribute("listGiangVienOfMonHoc", listGiangVienOfMonHoc);
        model.addAttribute("listGiangVienOfKhoa", listGiangVienOfKhoa);
        return "admin/monhoc/list-giangVien";
    }

    @PostMapping("/giang-vien/add")
    public String addGiangVien(@RequestParam("monHocId") int monHocId,
                               @RequestParam("giangVienId") String giangVienId,
                               Model model) {
        monHocService.addGiangVien(monHocId, giangVienId);

        return "redirect:/qlk/mon-hoc/giang-vien?monHocId=" + monHocId;
    }

    @GetMapping("/giang-vien/delete")
    public String deleteGiangVien(@RequestParam("monHocId") int monHocId,
                                  @RequestParam("giangVienId") String giangVienId) {

        monHocService.deleteGiangVien(monHocId, giangVienId);
        return "redirect:/qlk/mon-hoc/giang-vien?monHocId=" + monHocId;
    }
}
