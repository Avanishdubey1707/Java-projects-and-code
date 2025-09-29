package com.api.book.bookrestbook.Controller;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.book.bookrestbook.helper.FileUploadHelper;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;
    
    @PostMapping("/upload-file")   
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        // System.out.println(file.getName());

        try {
            
       

     
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("upload should not be empty");

        }
        boolean f= fileUploadHelper.uploadFile(file);
        if(f){
            return ResponseEntity.ok("File is uploaded Succesfully");
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("some thing got wrong");

       
    }
     
}
