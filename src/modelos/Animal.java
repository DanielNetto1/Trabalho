/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.util.Date;

/**
 *
 * @author conta
 */
public class Animal {
    private int idAnimal;
    private int especieAnimal; //Isto é um de animal 1: Cachorro, 2: Gato...
    private double alturaAnimal; 
    private double pesoAnimal;
    private Tutor tutorAnimal;
    private int sexoAnimal; // 1: Masculino, 2: Feminino
    private int racaAnimal; 
    private Date nascimentoAnimal;
    
    
    public int getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(int idAnimal) {
        this.idAnimal = idAnimal;
    }

    public int getEspecieAnimal() {
        return especieAnimal;
    }

    public void setEspecieAnimal(int especieAnimal) {
        this.especieAnimal = especieAnimal;
    }

    public double getAlturaAnimal() {
        return alturaAnimal;
    }

    public void setAlturaAnimal(double alturaAnimal) {
        this.alturaAnimal = alturaAnimal;
    }

    public double getPesoAnimal() {
        return pesoAnimal;
    }

    public void setPesoAnimal(double pesoAnimal) {
        this.pesoAnimal = pesoAnimal;
    }

    public Tutor getTutorAnimal() {
        return tutorAnimal;
    }

    public void setTutorAnimal(Tutor tutorAnimal) {
        this.tutorAnimal = tutorAnimal;
    }


    public int getSexoAnimal() {
        return sexoAnimal;
    }

    public void setSexoAnimal(int sexoAnimal) {
        this.sexoAnimal = sexoAnimal;
    }

    public int getRacaAnimal() {
        return racaAnimal;
    }

    public void setRacaAnimal(int racaAnimal) {
        this.racaAnimal = racaAnimal;
    }

    public Date getNascimentoAnimal() {
        return nascimentoAnimal;
    }

    public void setNascimentoAnimal(Date nascimentoAnimal) {
        this.nascimentoAnimal = nascimentoAnimal;
    }
    
    
}


