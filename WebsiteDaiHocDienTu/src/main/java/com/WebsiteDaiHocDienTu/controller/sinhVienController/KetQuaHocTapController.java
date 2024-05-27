package com.WebsiteDaiHocDienTu.controller.sinhVienController;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.service.KetQuaHocTapService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("sinhvien")
@RequestMapping("/sv")
public class KetQuaHocTapController {

    @Autowired
    private KetQuaHocTapService ketQuaHocTapService;
    @GetMapping("/ket-qua-hoc-tap")
    public String getKetQuaHocTap(Model model){
        UserDTO userDTO =  SecurityUtils.getPrinciple();
        model.addAttribute("user",userDTO);
        model.addAttribute("ketquahoctap",ketQuaHocTapService.findAllBySinhVienId(userDTO.getId()));
        return "/sinhvien/ketquahoctap";
    }
}
