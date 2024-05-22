package com.WebsiteDaiHocDienTu.controller.QuanLyKhoaController;

import com.WebsiteDaiHocDienTu.model.dto.UserDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.CreateAndUpdateNganhDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.GetListNganhDTO;
import com.WebsiteDaiHocDienTu.model.dto.request.nganh.GetNganhManagerChuongTrinhHocDTO;
import com.WebsiteDaiHocDienTu.service.NganhService;
import com.WebsiteDaiHocDienTu.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller(value = "qlk")
@RequestMapping("/qlk")
public class NganhController {

    @Autowired
    private NganhService nganhService;


    @GetMapping("/quan-ly-nganh")
    public String getList(Model model){
        Long userId = SecurityUtils.getPrinciple().getId();
        List<GetListNganhDTO> nganhs = nganhService.findAllByQLK(userId);
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);
        model.addAttribute("nganhs",nganhs);
        return "/admin/nganh/ListNganh";
    }

    @GetMapping("/nganh/them-nganh")
    public String viewThemNganh(Model model){
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);
        return "/admin/nganh/createNganh";
    }

    @PostMapping("/nganh/them-nganh")
    public String themNganh(Model model, @ModelAttribute CreateAndUpdateNganhDTO nganhDTO){
        Long userId = SecurityUtils.getPrinciple().getId();
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);
        CreateAndUpdateNganhDTO nganh = null;
        try {
            nganh = nganhService.createNganh(userId,nganhDTO);
            model.addAttribute("message","Thêm ngành thành công");
        }catch (Exception e){
            model.addAttribute("message","Thêm ngành thất bại");
        }
        return "/admin/nganh/createNganh";
    }

    @GetMapping("/quan-ly-nganh/{id}/sua-nganh")
    private String viewSuaNganh(Model model,@PathVariable Integer id){
        try {
            Long userId = SecurityUtils.getPrinciple().getId();
            CreateAndUpdateNganhDTO nganhDTO = nganhService.findById(userId,id);
            UserDTO userDTO = SecurityUtils.getPrinciple();

            model.addAttribute("user", userDTO);
            model.addAttribute("nganh",nganhDTO);
        }catch (Exception e){

        }
        return "/admin/nganh/UpdateNganh";
    }

    @PostMapping("/quan-ly-nganh/sua-nganh")
    public String suaNganh(Model model, @ModelAttribute CreateAndUpdateNganhDTO nganhDTO){
            Long userId = SecurityUtils.getPrinciple().getId();
           UserDTO userDTO = SecurityUtils.getPrinciple();
           model.addAttribute("user", userDTO);
        try {
            nganhDTO = nganhService.updateNganh(userId,nganhDTO);
            model.addAttribute("message","Sửa ngành thành công");
        }catch (Exception e){
            model.addAttribute("message","Sửa ngành thất bại");
        }
            model.addAttribute("nganh",nganhDTO);
        return "/admin/nganh/UpdateNganh";
    }

    @GetMapping("/nganh")
    public String getNganhToManageChuongTrinhHoc(Model model){
        UserDTO userDTO = SecurityUtils.getPrinciple();
        model.addAttribute("user", userDTO);
        List<GetNganhManagerChuongTrinhHocDTO> nganhs = nganhService.findAllNganhByQLK(userDTO.getId());
        model.addAttribute("nganhs",nganhs);
        return "/admin/nganh/ListNganhManageChuongTrinhHoc";
    }


}
