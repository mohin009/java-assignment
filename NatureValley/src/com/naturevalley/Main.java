package com.naturevalley;

public class Main {

    public static void main(String[] args) {
        // create a RoomDetails object with appropriate values
        RoomDetails room = new RoomDetails("John Doe", "Delux", 5, 0);

        // calculate the total bill
        double totalBill = room.calculateBill();

        // display the details on console
        System.out.println("BillId: " + room.getBillId());
        System.out.println("Customer Name: " + room.getCustomerName());
        System.out.println("No. of days of Stay: " + room.getNoOfDaysOfStay());
        System.out.println("Total Bill: " + totalBill);
    }
}
