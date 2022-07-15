package hm.projekty.kombajn.model;



import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

@Entity
@Table(name = "Palety")
@Getter
@Setter
public class Paleta {

    @Id

    private String palNo;



    @Column(name = "InDate")
    private LocalDateTime dateTime;

    @Column(name = "OutDate")
    private LocalDateTime dateTimeOut;

    @Column(name="mezz_inn")
    LocalDateTime mezzInn;

    @OneToMany(mappedBy = "paleta", orphanRemoval = true)
    private List<Karton> kartons = new ArrayList<>();













}


