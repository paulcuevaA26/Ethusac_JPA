package pe.isil.empresa.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_chofer")
@Entity
public class Chofer {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer chofer_id;
    @Column
    private String nombres;
    @Column
    private String apellidos;
    @Column
    private String direccion;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fec_ingreso;
    @Column
    private Integer telefono;

    @ManyToMany(mappedBy = "chofer")
    private Set<Moto> motoSet;


}
