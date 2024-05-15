package com.infnet.tp2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Produto {
    private int id;
    private String nome;
    private double valor;
    private String categoria;
}
