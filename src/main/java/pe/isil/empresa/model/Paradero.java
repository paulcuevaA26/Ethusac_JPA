package pe.isil.empresa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_paradero")
@Entity
public class Paradero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paradero_id;

    @Column
    private String nombreParadero;

    @Column
    private Integer capacidadMotos;

    @Column
    private String direccion;

    @Column
    private String distrito;


    @OneToMany(mappedBy = "paradero")
    private Set<Moto> moto;



}
