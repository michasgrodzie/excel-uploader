package hm.projekty.kombajn;

import hm.projekty.kombajn.model.Paleta;
import hm.projekty.kombajn.repository.PalRepo;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PaletaTest {

    @Autowired
    private PalRepo palRepo;

    @Test
    public void  testCreatePaleta(){

        Paleta paleta = new Paleta();
        palRepo.save(paleta);

    }
}

