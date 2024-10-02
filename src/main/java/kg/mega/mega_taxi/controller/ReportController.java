package kg.mega.mega_taxi.controller;

import kg.mega.mega_taxi.service.ReportService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;

@RequestMapping("/report")
@RestController
@AllArgsConstructor
public class ReportController {

    @Autowired
    ReportService reportService;


    @GetMapping("/file")
    public ResponseEntity<?> getFile() throws IOException {

        String filename = "File.xlsx";



        byte[] file = reportService.getExcelFile();

        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("application", "force-download"));
        header.setContentLength(file.length);
        header.set("Content-Disposition", "attachment; filename=" + filename);
        if (file.length == 0) {
            return new ResponseEntity<>(file, header, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(file, header, HttpStatus.OK);
        }
    }
}
