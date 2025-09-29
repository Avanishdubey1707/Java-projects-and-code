package com.api.book.bookrestbook.helper;

import java.io.File;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR="C:\\Users\\LENOVO\\Documents\\spring boot\\bookrestbook\\src\\main\\resources\\static";
    
    public boolean uploadFile(MultipartFile multi){
        boolean f=false;

        try {
            // InputStream is = multi.getInputStream();
            // byte data[] =new byte[is.available()];
            // is.read(data);

            // // write
            // FileOutputStream fos=new 
            
            Files.copy(multi.getInputStream(),Paths.get(UPLOAD_DIR+File.separator+multi.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING );
            f=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
