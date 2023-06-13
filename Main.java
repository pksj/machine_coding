
public class Main {
  public static void main(String[] args) {
    ParkingLot pl = new ParkingLot("PR12345", 2, 5);
    pl.displayFreeSlotCountPerFloor(TYPE.BIKE);
    pl.displayFreeSlotsPerFloor(TYPE.BIKE);
    pl.displayOccupiedSlotsPerFloor(TYPE.BIKE);
    pl.parkVehicle(new Vehicle(TYPE.BIKE, "MH38H1743", "red"));
    pl.displayFreeSlotCountPerFloor(TYPE.BIKE);
    pl.displayFreeSlotsPerFloor(TYPE.BIKE);
    pl.displayOccupiedSlotsPerFloor(TYPE.BIKE);
    pl.unparkVehicle("PR12345_1_2");
    pl.displayFreeSlotCountPerFloor(TYPE.BIKE);
    pl.displayFreeSlotsPerFloor(TYPE.BIKE);
    pl.displayOccupiedSlotsPerFloor(TYPE.BIKE);
  }
}
