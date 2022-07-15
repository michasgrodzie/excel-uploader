package hm.projekty.kombajn.repository;

import hm.projekty.kombajn.model.Karton;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;




@RepositoryRestResource(path = "karton",collectionResourceRel = "kartony")
public interface KartonRepo extends JpaRepository<Karton,String> {

    long countByPaleta_PalNo(String palNo);







}
