package hm.projekty.kombajn.controller;
import hm.projekty.kombajn.serwis.PalKartonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j

public class PalKartController {

    @Autowired
    PalKartonService service;

    @PostMapping(path = "/upload")
    public ResponseEntity<String>uploadKartony(@RequestParam ("file") MultipartFile file){
        String message = "";

        log.info("siema");

            try{
                service.palHuUpload(file);
                message = "zaladowano plik " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(message);

            }catch (Exception e){
                message = "nie moglem zaladowac pliku " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
            }

    }





    }






