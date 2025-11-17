package main.java.com.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import main.java.com.model.Car;
import main.java.com.util.Stackable;
import main.java.com.util.LinkedStack;

/**
 * Implementação do DAO (Data Access Object) para gerenciamento de carros
 * utilizando uma estrutura de dados do tipo pilha (stack) baseada em lista encadeada.
 * @author Lorena Pereira Oliveira
 * @version 1.1
 * @since 2025-11-02
 */
public class CarDAOLinkedStack implements CarDAO { 
    private Stackable<Car> cars = new LinkedStack<>(20);
    private final int capacity = 20; 

  
    // Operações básicas CRUD

    @Override
    public void addCar(Car car) {
        if (car == null) {
            throw new IllegalArgumentException("O carro não pode ser nulo.");
        }
        if (cars.isFull()) {
            throw new IllegalStateException("O estacionamento está lotado.");
        }
        cars.push(car);
    }

    @Override
    public Car getCar(String plateLicense) {
        if (plateLicense == null) return null;

        Stackable<Car> temp = new LinkedStack<>(capacity);
        Car resultCar = null;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            if (resultCar == null && car.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                resultCar = car;
            }
            temp.push(car);
        }
        restoreStack(temp);
        return resultCar;
    }

    @Override
    public Car[] getAllCars() {
        return stackToArray(cars);
    }

    @Override
    public void updateCar(Car newCar) {
        if (newCar == null) return;

        Stackable<Car> temp = new LinkedStack<>(capacity);
        boolean updated = false;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            if (!updated && car.getPlateLicense().equalsIgnoreCase(newCar.getPlateLicense())) {
                temp.push(newCar); 
                updated = true;
            } else {
                temp.push(car); 
            }
        }
        restoreStack(temp);

        if (!updated) {
            throw new IllegalArgumentException("Carro não encontrado para atualização.");
        }
    }

    @Override
    public Car deleteCar(String plateLicense) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        Car resultCar = null;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            if (resultCar == null && car.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                resultCar = car;
            } else {
                temp.push(car);
            }
        }
        restoreStack(temp);
        return resultCar;
    }


    // Operações de consulta específicas

    @Override
    public Car getCarByLicensePlate(String plateLicense) {
        return getCar(plateLicense);
    }

    @Override
    public Car[] getCarsByMark(String mark) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>(); 

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car); 

            if (car.getMark() != null && car.getMark().equalsIgnoreCase(mark)) {
                resultList.add(car);
            }
        }
        restoreStack(temp); 
        
        return resultList.toArray(new Car[0]);
    }

    @Override
    public Car[] getCarsByModel(String model) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>();

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getModel() != null && car.getModel().equalsIgnoreCase(model)) {
                resultList.add(car);
            }
        }
        restoreStack(temp);
        
        return resultList.toArray(new Car[0]);
    }

    @Override
    public Car[] getCarsByColor(String color) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>();

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getColor() != null && car.getColor().equalsIgnoreCase(color)) {
                resultList.add(car);
            }
        }
        restoreStack(temp);
        
        return resultList.toArray(new Car[0]);
    }

    @Override
    public Car[] getCarsByOwner(String owner) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>();

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getOwnerName() != null && car.getOwnerName().equalsIgnoreCase(owner)) {
                resultList.add(car);
            }
        }
        restoreStack(temp);
        
        return resultList.toArray(new Car[0]);
    }

    @Override
    public Car[] getCarsByMomentArrival(LocalDateTime initialMoment, LocalDateTime finalMoment) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>();

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getArrived() != null && 
                !car.getArrived().isBefore(initialMoment) && 
                !car.getArrived().isAfter(finalMoment)) {
                
                resultList.add(car);
            }
        }
        restoreStack(temp);

        return resultList.toArray(new Car[0]);
    }


    // Operações de análise e estatísticas 

    @Override
    public Car getCarByNewestArrival() {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        Car newestCar = null;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getArrived() != null) {
                if (newestCar == null || car.getArrived().isAfter(newestCar.getArrived())) {
                    newestCar = car;
                }
            }
        }
        restoreStack(temp);
        return newestCar;
    }

    @Override
    public Car getCarByOldestArrival() {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        Car oldestCar = null;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getArrived() != null) {
                if (oldestCar == null || car.getArrived().isBefore(oldestCar.getArrived())) {
                    oldestCar = car;
                }
            }
        }
        restoreStack(temp);
        return oldestCar;
    }


    // Operações de relatório e contagem

    @Override
    public String printCars() {
        return cars.toString();
    }

    @Override
    public int getTotalCars() {
        return countElements(cars);
    }


    @Override
    public String getMostPopularMark() {
        Car[] allCars = stackToArray(cars); 
        if (allCars.length == 0) return null;

        String mostPopular = null;
        int maxCount = 0;

        for (int i = 0; i < allCars.length; i++) {
            String currentMark = allCars[i].getMark();
            if (currentMark == null) continue;
            
            int currentCount = 0;
            for (int j = 0; j < allCars.length; j++) {
                if (currentMark.equalsIgnoreCase(allCars[j].getMark())) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostPopular = currentMark;
            }
        }
        return mostPopular;
    }

    @Override
    public String getMostPopularModel() {
        Car[] allCars = stackToArray(cars);
        if (allCars.length == 0) return null;

        String mostPopular = null;
        int maxCount = 0;

        for (int i = 0; i < allCars.length; i++) {
            String currentModel = allCars[i].getModel();
            if (currentModel == null) continue;

            int currentCount = 0;
            for (int j = 0; j < allCars.length; j++) {
                if (currentModel.equalsIgnoreCase(allCars[j].getModel())) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostPopular = currentModel;
            }
        }
        return mostPopular;
    }

    @Override
    public String getMostPopularColor() {
        Car[] allCars = stackToArray(cars);
        if (allCars.length == 0) return null;

        String mostPopular = null;
        int maxCount = 0;

        for (int i = 0; i < allCars.length; i++) {
            String currentColor = allCars[i].getColor(); 
            if (currentColor == null) continue;

            int currentCount = 0;
            for (int j = 0; j < allCars.length; j++) {
                if (currentColor.equalsIgnoreCase(allCars[j].getColor())) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostPopular = currentColor;
            }
        }
        return mostPopular;
    }


    // Operações de gerenciamento

    @Override
    public boolean isCarInPlaced(String plateLicense) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        boolean found = false;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);
            if (car.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                found = true;
            }
        }
        restoreStack(temp);
        return found;
    }

    @Override
    public void clearAllCars() {
        while (!cars.isEmpty()) {
            cars.pop();
        }
    }

    @Override
    public void removeCarsOlderThan(LocalDateTime date) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        while (!cars.isEmpty()) {
            Car car = cars.pop();

            if (car.getArrived() != null && !car.getArrived().isBefore(date)) {
                temp.push(car);
            }
        }
        restoreStack(temp);
    }

    @Override
    public Car[] getCarsByParkingDuration(long minHours, long maxHours) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);
            
            if (car.getArrived() != null) {
                long duration = Duration.between(car.getArrived(), now).toHours();
                if (duration >= minHours && duration <= maxHours) {
                    resultList.add(car);
                }
            }
        }
        restoreStack(temp);
        return resultList.toArray(new Car[0]);
    }

    @Override
    public int getAvailableSpaces() {
        return capacity - countElements(cars);
    }

    @Override
    public boolean isParkingEmpty() {
        return cars.isEmpty();
    }

    @Override
    public int getMaxcapacity() {
        return capacity; 
    }

    @Override
    public int getOccupancyRate() {
        int current = countElements(cars);
        if (capacity == 0) return 0;
        return (current * 100) / capacity;
    }

    @Override
    public boolean isParkingFull() {
        return cars.isFull();
    }

    @Override
    public long getParkingDuration(String plateLicense) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        LocalDateTime now = LocalDateTime.now();
        long duration = 0;
        boolean found = false;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (!found && car.getPlateLicense().equalsIgnoreCase(plateLicense)) {
                if (car.getArrived() != null) {
                    duration = Duration.between(car.getArrived(), now).toHours();
                }
                found = true;
            }
        }
        restoreStack(temp);
        return duration;
    }

    @Override
    public void removeCarsByOwner(String owner) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        
        while (!cars.isEmpty()) {
            Car car = cars.pop();
            if (car.getOwnerName() == null || !car.getOwnerName().equalsIgnoreCase(owner)) {
                temp.push(car);
            }
        }
        restoreStack(temp);
    }

    @Override
    public long getAverageArrivalTime() {
        if (cars.isEmpty()) return 0;

        Stackable<Car> temp = new LinkedStack<>(capacity);
        long sumMillis = 0;
        int count = 0;

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getArrived() != null) {
                sumMillis += car.getArrived().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                count++;
            }
        }
        restoreStack(temp);

        return (count == 0) ? 0 : (sumMillis / count);
    }

    @Override
    public Car[] getCarsWithLongParking(long thresholdHours) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);

            if (car.getArrived() != null) {
                long hours = Duration.between(car.getArrived(), now).toHours();
                if (hours >= thresholdHours) {
                    resultList.add(car);
                }
            }
        }
        restoreStack(temp);
        return resultList.toArray(new Car[0]);
    }


    // Métodos Auxiliares

    private void restoreStack(Stackable<Car> tempStack) {
        while (!tempStack.isEmpty()) {
            cars.push(tempStack.pop());
        }
    }

    private Car[] stackToArray(Stackable<Car> stack) {
        Stackable<Car> tempStack = new LinkedStack<>(capacity);
        List<Car> list = new ArrayList<>();

        while (!stack.isEmpty()) {
            Car c = stack.pop();
            list.add(c);
            tempStack.push(c);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return list.toArray(new Car[0]);
    }

    private int countElements(Stackable<Car> stack) {
        int count = 0;
        Stackable<Car> tempStack = new LinkedStack<>(capacity);

        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
            count++;
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return count;
    }
    
    private interface CarPredicate {
        boolean test(Car c);
    }

    private Car[] filterCars(CarPredicate predicate) {
        Stackable<Car> temp = new LinkedStack<>(capacity);
        List<Car> resultList = new ArrayList<>();

        while (!cars.isEmpty()) {
            Car car = cars.pop();
            temp.push(car);
            if (predicate.test(car)) {
                resultList.add(car);
            }
        }
        restoreStack(temp);
        return resultList.toArray(new Car[0]);
    }
}