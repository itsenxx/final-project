package org.juice_project.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.juice_project.domain.ComVO;
import org.juice_project.service.ComService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/com")
public class ComController {
    private final ComService comService; // ComService를 주입합니다.

    public ComController(ComService comService) {
        this.comService = comService;
    }

    @GetMapping("/com") // 이 URL로 요청이 오면 아래의 메소드가 실행됩니다.
    public String showComPage(Model model) {
        // 서비스에서 데이터 가져오기
        List<ComVO> comList = comService.getJoinCompanyList();

        // com.jsp로 데이터 전달
        model.addAttribute("comList", comList);

        // com.jsp 페이지로 이동
        return "com/com"; // com.jsp 파일 이름과 일치해야 합니다.
    }

    @GetMapping("/download/{file}")
    public void download(@PathVariable String file,
                         HttpServletResponse response) throws IOException {
        File f = new File("C:\\Users\\human-28\\Desktop\\파이널프로젝트\\juice_project_20240416 통합본\\juice_project_hyunbin22\\src\\main\\resources\\static\\upload-files", file);
        response.setContentType("application/download");
        response.setContentLength((int)f.length());
        response.setHeader("Content-disposition", "attachment; filename=\"" + file + "\"");
        OutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(f);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();
    }
}
