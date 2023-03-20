package com.naturevalley;
interface RoomBillComponent {
    double TAX = 0.12;
    double EXTRA_PERSON_CHARGE = 500.00;
    double FOOD_CHARGE = 800.00;
}

class RoomDetails implements RoomBillComponent {
    private static int counter = 101;
    private int billId;
    private String customerName;
    private String typeOfRoom;
    private int noOfDaysOfStay;
    private int noOfExtraPerson;

    public RoomDetails(String customerName, String typeOfRoom, int noOfDaysOfStay, int noOfExtraPerson) {
        this.billId = counter++;
        this.customerName = customerName;
        this.typeOfRoom = typeOfRoom;
        this.noOfDaysOfStay = noOfDaysOfStay;
        this.noOfExtraPerson = noOfExtraPerson;
    }

    public void validateNoOfExtraPerson() {
        if (noOfExtraPerson > 2) {
            System.out.println("Error: Only 0-2 extra persons are allowed per room.");
        }
    }

    public void validateTypeOfRoom() {
        if (!typeOfRoom.equals("Standard") && !typeOfRoom.equals("Delux") && !typeOfRoom.equals("Cottage")) {
            System.out.println("Error: Invalid room type. Valid room types are: Standard, Delux, Cottage.");
        }
    }

    public void validateNoOfDaysOfStay() {
        if (noOfDaysOfStay < 1 || noOfDaysOfStay > 15) {
            System.out.println("Error: Number of days of stay should be between 1 and 15 (inclusive).");
        }
    }

    public double calculateBill() {
        validateTypeOfRoom();
        validateNoOfDaysOfStay();
        validateNoOfExtraPerson();

        double baseRoomFare = 0.0;

        switch (typeOfRoom) {
            case "Standard":
                baseRoomFare = 2500;
                break;
            case "Delux":
                baseRoomFare = 3500;
                break;
            case "Cottage":
                baseRoomFare = 5500;
                break;
        }

        double totalBill = (noOfDaysOfStay * baseRoomFare) + (noOfDaysOfStay * FOOD_CHARGE)
                + (noOfExtraPerson * EXTRA_PERSON_CHARGE);
        totalBill = totalBill + (TAX * totalBill);

        return totalBill;
    }

    public int getBillId() {
        return billId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getNoOfDaysOfStay() {
        return noOfDaysOfStay;
    }
}
