enum TYPE {
  CAR,
  BIKE,
  TRUCK
}

public class Vehicle {
  TYPE type;
  String registrationNumber;
  String color;
  public Vehicle(TYPE type, String registrationNumber, String color) {
    this.type = type;
    this.registrationNumber = registrationNumber;
    this.color = color;
  }
}

