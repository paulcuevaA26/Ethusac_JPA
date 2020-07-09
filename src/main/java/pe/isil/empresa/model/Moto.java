package pe.isil.empresa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_moto")
@Entity
public class Moto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer moto_id;
    @Column
    private String placa;
    @Column
    private String chasis;
    @Column
    private String color;
    @Column
    private String marca;
    @Column
    private String soat;

    @ManyToMany
    private Set<Chofer> chofer;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paradero_id")
    private Paradero paradero;



}
