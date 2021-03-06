package design.usecase.parkinglot;

import design.usecase.parkinglot.vehicle.Vehicle;

public class Customer {

    private String name;
    private String email;
    private String phone;
    private Vehicle vehicle;

    public Customer(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
