package com.fm.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LifestyleDets", schema = "dbo", catalog = "Java1_Hospital")
public class LifestyleDetsEntity {
    private int idLifestyle;
    private Boolean vegetarian;
    private Boolean smoker;
    private Integer averageNoOfCigarettesPerDay;
    private Boolean consumeAlcohol;
    private Integer averageNoOfDrinksPerDay;
    private Boolean useStimulants;
    private String stimulants;
    private Integer coffeePerDay;
    private Integer softDrinksPerDay;
    private Boolean regularMeals;
    private Boolean eatHome;

    public LifestyleDetsEntity(){

    }
    public LifestyleDetsEntity(boolean vegetarian, boolean smoker, int averageNoOfCigarettesPerDay, boolean consumeAlcohol, int averageNoOfDrinksPerDay,
                               boolean useStimulants, int coffeePerDay, int softDrinksPerDay, boolean regularMeals, boolean eatHome){
        this.vegetarian = vegetarian;
        this.smoker = smoker;
        this.averageNoOfCigarettesPerDay = averageNoOfCigarettesPerDay;
        this.consumeAlcohol = consumeAlcohol;
        this.averageNoOfCigarettesPerDay = averageNoOfCigarettesPerDay;
        this.averageNoOfDrinksPerDay =averageNoOfDrinksPerDay;
        this.useStimulants = useStimulants;
        this.coffeePerDay = coffeePerDay;
        this.softDrinksPerDay = softDrinksPerDay;
        this.regularMeals = regularMeals;
        this.eatHome = eatHome;
    }

    @Id
    @GeneratedValue
    @Column(name = "IDLifestyle", nullable = false)
    public int getIdLifestyle() {
        return idLifestyle;
    }

    public void setIdLifestyle(int idLifestyle) {
        this.idLifestyle = idLifestyle;
    }

    @Basic
    @Column(name = "Vegetarian")
    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Basic
    @Column(name = "Smoker")
    public Boolean getSmoker() {
        return smoker;
    }

    public void setSmoker(Boolean smoker) {
        this.smoker = smoker;
    }

    @Basic
    @Column(name = "AverageNoOfCigarettesPerDay")
    public Integer getAverageNoOfCigarettesPerDay() {
        return averageNoOfCigarettesPerDay;
    }

    public void setAverageNoOfCigarettesPerDay(Integer averageNoOfCigarettesPerDay) {
        this.averageNoOfCigarettesPerDay = averageNoOfCigarettesPerDay;
    }

    @Basic
    @Column(name = "ConsumeAlcohol")
    public Boolean getConsumeAlcohol() {
        return consumeAlcohol;
    }

    public void setConsumeAlcohol(Boolean consumeAlcohol) {
        this.consumeAlcohol = consumeAlcohol;
    }

    @Basic
    @Column(name = "AverageNoOfDrinksPerDay")
    public Integer getAverageNoOfDrinksPerDay() {
        return averageNoOfDrinksPerDay;
    }

    public void setAverageNoOfDrinksPerDay(Integer averageNoOfDrinksPerDay) {
        this.averageNoOfDrinksPerDay = averageNoOfDrinksPerDay;
    }

    @Basic
    @Column(name = "UseStimulants")
    public Boolean getUseStimulants() {
        return useStimulants;
    }

    public void setUseStimulants(Boolean useStimulants) {
        this.useStimulants = useStimulants;
    }

    @Basic
    @Column(name = "Stimulants", length = 200)
    public String getStimulants() {
        return stimulants;
    }

    public void setStimulants(String stimulants) {
        this.stimulants = stimulants;
    }

    @Basic
    @Column(name = "CoffeePerDay")
    public Integer getCoffeePerDay() {
        return coffeePerDay;
    }

    public void setCoffeePerDay(Integer coffeePerDay) {
        this.coffeePerDay = coffeePerDay;
    }

    @Basic
    @Column(name = "SoftDrinksPerDay")
    public Integer getSoftDrinksPerDay() {
        return softDrinksPerDay;
    }

    public void setSoftDrinksPerDay(Integer softDrinksPerDay) {
        this.softDrinksPerDay = softDrinksPerDay;
    }

    @Basic
    @Column(name = "RegularMeals")
    public Boolean getRegularMeals() {
        return regularMeals;
    }

    public void setRegularMeals(Boolean regularMeals) {
        this.regularMeals = regularMeals;
    }

    @Basic
    @Column(name = "EatHome")
    public Boolean getEatHome() {
        return eatHome;
    }

    public void setEatHome(Boolean eatHome) {
        this.eatHome = eatHome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LifestyleDetsEntity that = (LifestyleDetsEntity) o;
        return idLifestyle == that.idLifestyle &&
                Objects.equals(vegetarian, that.vegetarian) &&
                Objects.equals(smoker, that.smoker) &&
                Objects.equals(averageNoOfCigarettesPerDay, that.averageNoOfCigarettesPerDay) &&
                Objects.equals(consumeAlcohol, that.consumeAlcohol) &&
                Objects.equals(averageNoOfDrinksPerDay, that.averageNoOfDrinksPerDay) &&
                Objects.equals(useStimulants, that.useStimulants) &&
                Objects.equals(stimulants, that.stimulants) &&
                Objects.equals(coffeePerDay, that.coffeePerDay) &&
                Objects.equals(softDrinksPerDay, that.softDrinksPerDay) &&
                Objects.equals(regularMeals, that.regularMeals) &&
                Objects.equals(eatHome, that.eatHome);
    }

    @Override
    public String toString() {
        return "LifestyleDetsEntity{" +
                "idLifestyle=" + idLifestyle +
                ", vegetarian=" + vegetarian +
                ", smoker=" + smoker +
                ", averageNoOfCigarettesPerDay=" + averageNoOfCigarettesPerDay +
                ", consumeAlcohol=" + consumeAlcohol +
                ", averageNoOfDrinksPerDay=" + averageNoOfDrinksPerDay +
                ", useStimulants=" + useStimulants +
                ", stimulants='" + stimulants + '\'' +
                ", coffeePerDay=" + coffeePerDay +
                ", softDrinksPerDay=" + softDrinksPerDay +
                ", regularMeals=" + regularMeals +
                ", eatHome=" + eatHome +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLifestyle, vegetarian, smoker, averageNoOfCigarettesPerDay, consumeAlcohol, averageNoOfDrinksPerDay, useStimulants, stimulants, coffeePerDay, softDrinksPerDay, regularMeals, eatHome);
    }
}
