package com.yokall.daythirteen;

import java.util.ArrayList;
import java.util.List;

public class BusFinder {
    public static int findEarliestBus(int earliestDepartTime, String buses) {
        int shortestWait = Integer.MAX_VALUE;
        int shortestWaitBusNumber = 0;

        String[] listOfBuses = buses.split(",");
        for (String bus : listOfBuses) {
            if ("x".equals(bus)) {
                continue;
            }

            int busNumber = Integer.parseInt(bus);

            int departInterval = earliestDepartTime / busNumber;

            if (earliestDepartTime % busNumber > 0) {
                departInterval += 1;
            }

            int minutesToWait = (busNumber * departInterval) - earliestDepartTime;

            if(minutesToWait < shortestWait) {
                shortestWait = minutesToWait;
                shortestWaitBusNumber = busNumber;
            }
        }

        return shortestWait * shortestWaitBusNumber;
    }

    public static long findSyncTimestamp(String input) {
        List<Bus> buses = new ArrayList<>();

        String[] busesInput = input.split(",");
        for (int i = 0; i < busesInput.length; i++) {
            if ("x".equals(busesInput[i])) {
                continue;
            }

            buses.add(new Bus(Integer.parseInt(busesInput[i]), i));
        }

        long timestamp = buses.get(0).getNumber();
        boolean synced = false;

        while (!synced) {
            boolean currentSync = true;

            for (int i = 1; i < buses.size(); i++) {
                if ((timestamp + buses.get(i).getPosition()) % buses.get(i).getNumber() != 0) {
                    currentSync = false;
                    break;
                }
            }

            if (currentSync) {
                synced = true;
            }
            else {
                timestamp += buses.get(0).getNumber();
            }
        }

        return timestamp;
    }
}
