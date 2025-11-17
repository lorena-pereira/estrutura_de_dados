package main.java.com.model;

import java.time.LocalDateTime;

public class Car {
    private final String licensePlate;          
    private String mark;             
    private String model;
    private String color;
    private String ownerName;
    private LocalDateTime arrived;

    // construtor com campos obrigatórios
    public Car(String licensePlate, String mark, String model) {
        required(licensePlate);
        required(mark);
        required(model);
        this.licensePlate = licensePlate;
        this.mark = mark;
        this.model = model;
    }

    // construtor com todos os campos
    public Car(String licensePlate, String mark, String model, String color, String ownerName, LocalDateTime arrived) {
        this(licensePlate, mark, model);
        this.color = color;
        this.ownerName = ownerName;
        this.arrived = arrived;
    }

    // método auxiliar
    private void required(Object obj) {
        if (obj == null)
            throw new IllegalArgumentException("Campo obrigatório não pode ser nulo!");
    }

    // métodos getters e setters
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getMark() {
        return mark;
    }

    public String getModel() {
        return model;
    }
    
    public String getColor() {
        return color;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDateTime getArrived() {
        return arrived;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setArrived(LocalDateTime arrived) {
        this.arrived = arrived;
    }

    // método toString()
    @Override
    public String toString() {
        return "Car{" +
                "licensePlate='" + licensePlate + '\'' +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", arrived=" + arrived +
                '}';
    }
}