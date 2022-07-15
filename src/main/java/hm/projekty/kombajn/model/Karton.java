package hm.projekty.kombajn.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "kartony")
@Getter
@Setter
public class Karton {

    @Id
    @JsonProperty(value = "numer_kartonu")
    private String huNo;

    @ManyToOne
    @JoinColumn(name = "Pal_Id")
    private Paleta paleta;

    @Column(name = "mezzOut")
    LocalDateTime mezzOut;














}
