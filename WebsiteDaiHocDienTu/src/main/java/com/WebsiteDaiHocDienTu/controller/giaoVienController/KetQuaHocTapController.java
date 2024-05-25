package com.WebsiteDaiHocDienTu.controller.giaoVienController;

import com.WebsiteDaiHocDienTu.model.entity.KetQuaHocTapEntity;
import com.WebsiteDaiHocDienTu.model.entity.LopMonHocEntity;
import com.WebsiteDaiHocDienTu.model.entity.QuaTrinhHocTapEntity;
import com.WebsiteDaiHocDienTu.service.GiangVienService;
import com.WebsiteDaiHocDienTu.service.LopMonHocService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("gv/quan-ly-ket-qua-hoc-tap")
public class KetQuaHocTapController {
    private GiangVienService giaoVienService;
    private LopMonHocService lopMonHocService;
    @GetMapping("")
    public String getLopMonHocList(Model model) {
        List<LopMonHocEntity> lopMonHocList =  giaoVienService.findAllByGiangVien();

        model.addAttribute("user", SecurityUtils.getPrinciple());
        model.addAttribute("lopMonHocList", lopMonHocList);
        return "giangvien/list-lopMonHoc";
    }

    @GetMapping("/{id}")
    public String getLopMonHoc(Model model,
                               @PathVariable("id") int lopMonHocId) {
        try {
            List<QuaTrinhHocTapEntity> quaTrinhHocTapList = lopMonHocService.findById(lopMonHocId).getQuaTrinhHocTapList();
            List<KetQuaHocTapEntity> ketQuaHocTapList = quaTrinhHocTapList.stream().map(q->q.getKetQuaHocTap()).toList();
            model.addAttribute("user", SecurityUtils.getPrinciple());
            model.addAttribute("lopMonHoc", lopMonHocService.findById(lopMonHocId));
            model.addAttribute("quaTrinhHocTapList", quaTrinhHocTapList);
            model.addAttribute("ketQuaHocTapList", ketQuaHocTapList);
        } catch (Exception e) {
            model.addAttribute("mes", e.getMessage());

        }


        return "giangvien/quanlydiem";
    }

    @PostMapping("/{id}/save")
    public String saveKetQuaHocTap(Model model,
                                   @PathVariable("id") int id,
                                   @ModelAttribute("lopMonHoc")LopMonHocEntity lopMonHoc) {
        lopMonHocService.saveKetQuaHocTap(lopMonHoc);
        return "redirect:/gv/quan-ly-ket-qua-hoc-tap/" + id;
    }
}
