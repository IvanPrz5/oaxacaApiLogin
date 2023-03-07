package com.example.oaxacaApi.Entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Timbrado")
public class TimbradoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nomina;
    @Column
    private String archivo;
    @Column
    private String archivoTimbrar;
    @Column
    private Long totalEmpleados;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPago;
    @Column
    private Double importeIsr;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaSubida;
    @Column
    private Double neto;
    @Column 
    private Long numEjecuciones;
    @Column /* (length = 500) */
    private String observaciones;
    @Column
    private String documentoContable;
    @Column
    private Long numero;
    @Column 
    private Boolean status;
    
    @ManyToOne
    @JoinColumn(name="idCapitalHumano")
    private CapitalHEntity capitalHEntity;

    @ManyToOne
    @JoinColumn(name="idSnfc")
    private CatalogoSNFCEntity catalogoSNFCEntity;

    @ManyToOne
    @JoinColumn(name="idStatus")
    private CatalogoStatusEntity catalogoStatusEntity;
}
