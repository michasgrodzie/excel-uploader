package hm.projekty.kombajn.serwis;


import hm.projekty.kombajn.model.Karton;
import hm.projekty.kombajn.model.Paleta;
import hm.projekty.kombajn.repository.KartonRepo;
import hm.projekty.kombajn.repository.PalRepo;
import hm.projekty.kombajn.uploader.ExcelUploader;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;
@Slf4j
@Service
public class PalKartonService {

    @Autowired
    KartonRepo repo;

    @Autowired
    PalRepo palRepo;

    public void palHuUpload(MultipartFile file){

        log.info("serwis siema");

        try{




            ExcelUploader exelUploader = new ExcelUploader(file.getInputStream());
            List<Paleta>listaPalet = exelUploader.getFinalList().values().stream().toList();
            List<Karton>listaKartonow = exelUploader.getFinalList().keySet().stream().toList();



            palRepo.saveAll(listaPalet);
            log.info("palety w repo {}",palRepo.count());
            repo.saveAll(listaKartonow);
            log.info("kartony w repo {}",repo.count());


        }catch (Exception e){

            log.info("nie teges cos {}" ,e.getMessage());
        throw new RuntimeException(e.getMessage());


        }

    }



}
