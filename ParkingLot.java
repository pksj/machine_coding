import java.util.HashMap;
import java.util.Map;


public class ParkingLot {
  String id;
  int numberOfFloors;
  int numberOfSlotsPerFloor;
  Map<Integer, String[]> floors = new HashMap<>();

  public ParkingLot(String id, int numberOfFloors, int numberOfSlotsPerFloor) {
    this.id = id;
    this.numberOfFloors = numberOfFloors;
    this.numberOfSlotsPerFloor = numberOfSlotsPerFloor;
    for (int i = 1; i <= numberOfFloors; i++){
      this.floors.put(i, new String[numberOfSlotsPerFloor]);
    }
  }

  void displayFreeSlotCountPerFloor(TYPE type) {
    int[] slotRanges = getSlotRangeByVehicleType(type);
    int start = slotRanges[0];
    int end = slotRanges[1];
    for (Map.Entry<Integer, String[]> entry : floors.entrySet()) {
      Integer floor = entry.getKey();
      String[] slots = entry.getValue();
      int count = 0;
      for (int i = start; i <= end; i++) {
        count += slots[i] == null ? 1 : 0;
      }
      System.out.println("No. of free slots for " + type + " on Floor " + floor + " : " + count);
    }
  }

  void displayFreeSlotsPerFloor(TYPE type) {
    int[] slotRanges = getSlotRangeByVehicleType(type);
    int start = slotRanges[0];
    int end = slotRanges[1];
    for (Map.Entry<Integer, String[]> entry : floors.entrySet()) {
      Integer floor = entry.getKey();
      String[] slots = entry.getValue();
      System.out.print("Free slots for " + type + " on Floor " + floor + " : ");
      for (int i = start; i <= end; i++) {
        if (slots[i] == null) {
          System.out.print(i+1 + ",");
        }
      }
      System.out.println("");
    }
  }

  void displayOccupiedSlotsPerFloor(TYPE type) {
    int[] slotRanges = getSlotRangeByVehicleType(type);
    int start = slotRanges[0];
    int end = slotRanges[1];
    for (Map.Entry<Integer, String[]> entry : floors.entrySet()) {
      Integer floor = entry.getKey();
      String[] slots = entry.getValue();
      System.out.print("Occupied slots for " + type + " on Floor " + floor + " : ");
      for (int i = start; i <= end; i++) {
        if (slots[i] != null) {
          System.out.print(i+1 + ",");
        }
      }
      System.out.println("");
    }
  }

  int[] getSlotRangeByVehicleType(TYPE type) {
    int start = 0;
    int end = 0;
    if (type == TYPE.TRUCK) {
      start = 0;
      end = 0;
    } else if (type == TYPE.BIKE) {
      start = 1;
      end = 2;
    } else if (type == TYPE.CAR) {
      start = 3;
      end = numberOfSlotsPerFloor-1;
    }
    return new int[] { start, end };
  }
  
  void parkVehicle(Vehicle vehicle) {
    int[] slotRanges = getSlotRangeByVehicleType(vehicle.type);
    int start = slotRanges[0];
    int end = slotRanges[1];
    for (Map.Entry<Integer, String[]> entry : floors.entrySet()) {
      Integer floor = entry.getKey();
      String[] slots = entry.getValue();
      for (int i = start; i <= end; i++) {
        if (slots[i] == null) {
          System.out.println("Parked Vehicle. Ticket ID: " + this.id + "_" + floor + "_" + (i + 1));
          slots[i] = vehicle.registrationNumber + "_" + vehicle.color;
          return;
        }
      }
      System.out.println("");
    }
    System.out.println("Parking Full.");
  }
  
  void unparkVehicle(String ticketId) {
    //check if ticket is invalid
    String[] ticketDetails = ticketId.split("_");
    if (ticketDetails.length != 3){
      System.out.println("Invalid Ticket");
      return;
    }
    String parkingId = ticketDetails[0];
    int floor = Integer.parseInt(ticketDetails[1]);
    int slot = Integer.parseInt(ticketDetails[2]);
    if (!parkingId.equals(this.id) ||
        floor <= 0 ||
        floor > this.numberOfFloors ||
        slot <= 0 ||
        slot > this.numberOfSlotsPerFloor) {
      System.out.println("Invalid Ticket");
      return;
    }
    String[] slots = this.floors.get(floor);
    if (slots[slot - 1] == null) {
      System.out.println("Invalid Ticket");
    }else{
      slots[slot-1] = null;
      this.floors.put(floor, slots);
      System.out.println("Unparked Successfully.");
    }
  }
}
