import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Please provide your input here.");
    ParkingLot pl = null;
    while (true) {
      String inputString = sc.nextLine();
      if (inputString.equals("exit")) {
        break;
      }
      String[] inputs = inputString.split(" ");
      // System.out.println(inputs);
      
      if (pl == null && !inputs[0].equals("createParkingLot")) {
        System.out.println("Please create parking lot first");
        continue;
      }
      switch (inputs[0]) {
        case "createParkingLot":
          pl = new ParkingLot(inputs[1], Integer.parseInt(inputs[2]), Integer.parseInt(inputs[3]));
          break;
        case "displayFreeSlotCountPerFloor":
          TYPE type = inputs[1].equals("TRUCK") ? TYPE.TRUCK : (inputs[1].equals("BIKE") ? TYPE.BIKE : TYPE.CAR);
          pl.displayFreeSlotCountPerFloor(type);
          break;
        case "displayFreeSlotsPerFloor":
          type = inputs[1].equals("TRUCK") ? TYPE.TRUCK : (inputs[1].equals("BIKE") ? TYPE.BIKE : TYPE.CAR);
          pl.displayFreeSlotsPerFloor(type);
          break;
        case "displayOccupiedSlotsPerFloor":
          type = inputs[1].equals("TRUCK") ? TYPE.TRUCK : (inputs[1].equals("BIKE") ? TYPE.BIKE : TYPE.CAR);
          pl.displayOccupiedSlotsPerFloor(type);
          break;
        case "parkVehicle":
          type = inputs[1].equals("TRUCK") ? TYPE.TRUCK : (inputs[1].equals("BIKE") ? TYPE.BIKE : TYPE.CAR);
          pl.parkVehicle(new Vehicle(type, inputs[2], inputs[3]));
          break;
        case "unparkVehicle":
          pl.unparkVehicle(inputs[1]);
          break;
        default:
          System.out.println("Invalid Input. Please provide correct input");
          break;
      }
      // ParkingLot pl = new ParkingLot("PR12345", 2, 5);
      // pl.displayFreeSlotCountPerFloor(TYPE.BIKE);
      // pl.displayFreeSlotsPerFloor(TYPE.BIKE);
      // pl.displayOccupiedSlotsPerFloor(TYPE.BIKE);
      // pl.parkVehicle(new Vehicle(TYPE.BIKE, "MH38H1743", "red"));
      // pl.displayFreeSlotCountPerFloor(TYPE.BIKE);
      // pl.displayFreeSlotsPerFloor(TYPE.BIKE);
      // pl.displayOccupiedSlotsPerFloor(TYPE.BIKE);
      // pl.unparkVehicle("PR12345_1_2");
      // pl.displayFreeSlotCountPerFloor(TYPE.BIKE);
      // pl.displayFreeSlotsPerFloor(TYPE.BIKE);
      // pl.displayOccupiedSlotsPerFloor(TYPE.BIKE);
    }
    sc.close();

  }
}
