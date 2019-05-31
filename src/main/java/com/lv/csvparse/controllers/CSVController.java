package com.lv.csvparse.controllers;

import com.lv.csvparse.services.CsvUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class CSVController {

    @Autowired
    private CsvUploadService csvUploadService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        csvUploadService.uploadCsv(file);
        return "index";
    }

    @GetMapping("/top/forms")
    public String  getTopUsersData(ModelMap model) {
        model.addAttribute("mos",
                this.csvUploadService.getTopUserForms());
        return "top-forms";
    }

    @GetMapping("/top/forms/last-our")
    public String  getTopFormsInLastOur(ModelMap model) {
        model.addAttribute("mos",
                this.csvUploadService.getTopFormsInLastOur());
        return "top-forms-in-our";
    }
}
