import java.util.Scanner;
import java.lang.Math;

import static java.lang.Math.*;

public class TripPlanner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        getting(input);
        timeTravelAndBudget(input);
        timeDifference(input);
        countryArea(input);
        distanceBetweenHomeAndDestination(input);
    }

    public static void getting(Scanner input) {
        System.out.println("Welcome to Vacation Planner");
        System.out.print("What is your name? ");
        String userName = input.nextLine();
        System.out.print("Nice to meet you " + userName + ", where are you travelling to? ");
        String destination = input.nextLine();
        System.out.println("Great! " + destination + " sounds like a great trip.");
        System.out.println("****************** \n");
    }

    public static void timeTravelAndBudget(Scanner input) {
        System.out.print("How many days are you going to spend travelling? ");
        int daysTravell = input.nextInt();
        System.out.print("How much noney, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String letterMoney = input.next();
        System.out.print("How many " + letterMoney + " are there in 1 USD? ");
        double inUsd = input.nextDouble();
        System.out.println("");
        int hours = daysTravell * 24;
        int minutes = hours * 60;
        System.out.println("If you are travelling for " + daysTravell + " days that is the same as " + hours + " hours or " + minutes + " minutes");
        double usdPerDay = (double) money / daysTravell;
        System.out.println("If you are going to spend $" + money + " USD that means per day you can spend up to $" + round(usdPerDay, 100) + " USD");
        double newMoney = money * inUsd;
        double newMoneyPerDay = newMoney / daysTravell;
        System.out.println("Your total budget in " + letterMoney + " is " + round(newMoney, 10) + " " + letterMoney + ", which per day is " + round(newMoneyPerDay, 100) + " " + letterMoney);
        System.out.println("****************** \n");
    }

    public static void timeDifference(Scanner input) {
        System.out.print("What is the time difference, in hours, between your home and your destination? ");
        int timeDifference = input.nextInt();
        while (Math.abs(timeDifference) > 23) {
            System.out.println("The time difference can't be more than 23 or -23!");
            System.out.print("What is the time difference, in hours, between your home and your destination? ");
            timeDifference = input.nextInt();
        }
        int timedifferenceWithMidnight = 0;
        int timeDifferenceWithNoon = 0;
        if (timeDifference < 0) {
            timedifferenceWithMidnight = 24 + timeDifference;
            timeDifferenceWithNoon = 24 + timeDifference % 12;
        } else {
            timedifferenceWithMidnight = timeDifference;
            timeDifferenceWithNoon = timeDifference + 12;
        }
        System.out.println("That means that when it is midnight at home it will be " + (timedifferenceWithMidnight % 24) + ":00 in your travel destination");
        System.out.println("and when it is noon at home it will be " + (timeDifferenceWithNoon % 24) + ":00");
        System.out.println("****************** \n");
    }

    public static void countryArea(Scanner input) {
        System.out.print("What is the square area of your destination country in km2? ");
        int countryArea = input.nextInt();
        double areaInMiles2 = countryArea / 2.56;
        System.out.println("In miles2 that is " + round(areaInMiles2, 10));
        System.out.println("****************** \n");
    }

    public static void distanceBetweenHomeAndDestination(Scanner input) {
        System.out.println("Enter the latitude and longitude for your home:");
        double latitudeHome = input.nextDouble();
        double longitudeHome = input.nextDouble();
        System.out.println("Enter the latitude and longitude for you travel destination:");
        double latitudeDestination = input.nextDouble();
        double longitudeDestination = input.nextDouble();
        double latitudeHomeInRad = latitudeHome * PI / 180;
        double longitudeHomeInRad = longitudeHome * PI / 180;
        double latitudeDestinationInRad = latitudeDestination * PI / 180;
        double longitudeDestinationInRad = longitudeDestination * PI / 180;
        double x1 = pow(cos(latitudeDestinationInRad) * sin(longitudeDestinationInRad - longitudeHomeInRad), 2);
        double x2 = pow(cos(latitudeHomeInRad) * sin(latitudeDestinationInRad) - sin(latitudeHomeInRad) * cos(latitudeDestinationInRad) * cos(longitudeDestinationInRad - longitudeHomeInRad), 2);
        double x = sqrt(x1 + x2);
        double y = sin(latitudeHomeInRad) * sin(latitudeDestinationInRad) + cos(latitudeHomeInRad) * cos(latitudeDestinationInRad) * cos(longitudeDestinationInRad - longitudeHomeInRad);
        double z = atan(x / y);
        double distance = z * 6371.008;
        System.out.println("The distance between you home and your travel destination is " + round(distance, 1000) + " km");
    }

    public static double round(double value, int exp) {
        double temp = 0;
        value = value * exp;
        temp = Math.round(value);
        return temp / exp;
    }
}
