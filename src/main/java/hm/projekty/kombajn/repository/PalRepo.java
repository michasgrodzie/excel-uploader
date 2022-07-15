package hm.projekty.kombajn.repository;

import hm.projekty.kombajn.model.Paleta;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource(path = "pal",collectionResourceRel = "palety")
public interface PalRepo extends JpaRepository<Paleta,String> {






}
