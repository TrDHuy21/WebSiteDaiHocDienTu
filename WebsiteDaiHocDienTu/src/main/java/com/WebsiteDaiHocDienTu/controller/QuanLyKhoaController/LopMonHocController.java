package com.WebsiteDaiHocDienTu.controller.QuanLyKhoaController;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.ThoiKhoaBieuEntity;
import com.WebsiteDaiHocDienTu.service.LopMonHocService;
import com.WebsiteDaiHocDienTu.service.SinhVienService;
import com.WebsiteDaiHocDienTu.service.ThoiKhoaBieuService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/qlk/lop-mon-hoc")
@AllArgsConstructor
public class LopMonHocController {
    private LopMonHocService lopMonHocService;
    private ThoiKhoaBieuService thoiKhoaBieuService;


    @GetMapping("")
    public String listLopMonHoc(Model model) {
        List<LopMonHocEntity> lopMonHocEntityList = lopMonHocService.getAllByQLK();

        model.addAttribute("user", SecurityUtils.getPrinciple());
        model.addAttribute("lopMonHocList", lopMonHocEntityList);
        return "admin/lopmonhoc/list-lopMonHoc";
    }
    @GetMapping("/formCreate")
    public String formCreate(Model model) {
        model.addAttribute("user", SecurityUtils.getPrinciple());
        model.addAttribute("lopMonHoc", new LopMonHocEntity());
        return "admin/lopmonhoc/lopMonHoc-form";
    }
    @GetMapping("/formUpdate")
    public String formUpdate(@RequestParam("lopMonHocId") int lopMonHocId, Model model) {

        LopMonHocEntity lopMonHocEntity = lopMonHocService.findById(lopMonHocId);

        model.addAttribute("user", SecurityUtils.getPrinciple());
        model.addAttribute("lopMonHoc", lopMonHocEntity);
        model.addAttribute("giangVienMonHocList", lopMonHocEntity.getMonHoc().getGiangVienList());
        return "admin/lopmonhoc/lopMonHoc-form";
    }

    @PostMapping(value = "/save", params = {"save"})
    public String save(@ModelAttribute("lopMonhoc") LopMonHocEntity lopMonHoc, Model model) {
        if(lopMonHoc.getId()==null) {
            lopMonHocService.create(lopMonHoc);
        } else {
            lopMonHocService.save(lopMonHoc);
        }
        model.addAttribute("user", SecurityUtils.getPrinciple());
        return "redirect:/qlk/lop-mon-hoc";
    }

    @GetMapping("/thoi-khoa-bieu/add")
    public String addThoiKhoaBieu(Model model,
                                  @RequestParam("lopMonHocId") int lopMonHocid) {

        lopMonHocService.addThoiKhoaBieu(lopMonHocid);

        model.addAttribute("user", SecurityUtils.getPrinciple());
        return "redirect:/qlk/lop-mon-hoc/formUpdate?lopMonHocId=" + lopMonHocid;
    }

    @GetMapping("/thoi-khoa-bieu/delete")
    public String deleteThoiKhoaBieu(Model model,
                                     @RequestParam("thoiKhoaBieuId") int thoiKhoaBieuId,
                                     @RequestParam("lopMonHocId") int lopMonHocid) {

        thoiKhoaBieuService.deleteById(thoiKhoaBieuId);

        model.addAttribute("user", SecurityUtils.getPrinciple());
        return "redirect:/qlk/lop-mon-hoc/formUpdate?lopMonHocId=" + lopMonHocid;
    }

    @PostMapping(value = "/save", params = {"changeGiangVien"})
    public String changeGiangVien(Model model,
                                  @RequestParam("newGiangVienId") String newGiangVienId,
                                  @ModelAttribute("lopMonHoc") LopMonHocEntity lopMonHocEntity) {
        lopMonHocService.changeGiangVien(lopMonHocEntity, newGiangVienId);
        model.addAttribute("user", SecurityUtils.getPrinciple());
        return "redirect:/qlk/lop-mon-hoc/formUpdate?lopMonHocId=" + lopMonHocEntity.getId();
    }
    @PostMapping(value = "/save", params = {"addSinhVien"})
    public String addSinhVien(Model model,
                                  @RequestParam("newSinhVienId") String newSinhVienId,
                                  @ModelAttribute("lopMonHoc") LopMonHocEntity lopMonHocEntity) {
        lopMonHocService.addSinhVien(lopMonHocEntity, newSinhVienId);
        model.addAttribute("user", SecurityUtils.getPrinciple());
        return "redirect:/qlk/lop-mon-hoc/formUpdate?lopMonHocId=" + lopMonHocEntity.getId();
    }

    @GetMapping("/delete")
    public String deleteLopMonHoc(Model model,
                                  @RequestParam("lopMonHocId") int id) {
        lopMonHocService.deleteById(id);
        return "redirect:/qlk/lop-mon-hoc";
    }
    @GetMapping("/qua-trinh-hoc-tap/delete")
    public String deleteSinhVien(Model model,
                                 @RequestParam("quaTrinhHocTapId") int quaTrinhHocTapId,
                                 @ModelAttribute("lopMonHocId") int lopMonHocId) {

        lopMonHocService.deleteQuaTrinhHocTapById(quaTrinhHocTapId);

        model.addAttribute("user", SecurityUtils.getPrinciple());
        return "redirect:/qlk/lop-mon-hoc/formUpdate?lopMonHocId=" + lopMonHocId;
    }
    @GetMapping(value = "/save", params = {"changeMonHoc"})
    public String changeMonHoc(Model model,
                               @RequestParam("newMonHocId") int newMonHocId,
                               @ModelAttribute("lopMonHoc") LopMonHocEntity lopMonHocEntity){
        lopMonHocService.addMonHoc(lopMonHocEntity, newMonHocId);
        return "redirect:/qlk/lop-mon-hoc/formUpdate?lopMonHocId=" + lopMonHocEntity.getId();
    }
}
