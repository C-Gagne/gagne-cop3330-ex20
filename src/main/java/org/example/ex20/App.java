/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solutions
 *  Copyright 2021 Crystal Gagne
 */

/*
Create a tax calculator that handles multiple states and multiple counties within each state. The program prompts the user for the order amount and the state where the order will be shipped.

    Wisconsin residents must be changed 5% sales tax with an additional county-level charge. For Wisconsin residents, prompt for the county of residence.
        For Eau Claire county residents, add an additional 0.005 tax.
        For Dunn county residents, add an additional 0.004 tax.
    Illinois residents must be charged 8% sales tax with no additional county-level charge.
    All other states are not charged tax.
 */

package org.example.ex20;

import java.util.Scanner;

public class App {
    Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        App mainApp = new App();

        String county = "";
        double subTotal = mainApp.getAmount();
        String state = mainApp.getState();
        if (state.equalsIgnoreCase("Wisconsin") || state.equalsIgnoreCase("WI"))
        {
            county = mainApp.getCounty();
        }

        double taxRate = mainApp.getTaxRate(state, county);
        double taxAmount = mainApp.calculateTaxAmount(taxRate, subTotal);
        double total = subTotal + taxAmount;


        String outputString = genOutputString(taxAmount, total);
        System.out.println(outputString);
    }
    public Double getAmount()
    {
        System.out.println("Enter the amount: ");
        double userAmount = in.nextDouble();
        in.nextLine();
        return userAmount;
    }

    public String getState()
    {
        System.out.println("What state do you live in?");

        return in.nextLine();
    }

    public String getCounty()
    {
        System.out.println("What county do you live in?");

        return in.nextLine();
    }

    public Double getTaxRate(String state, String county)
    {
        double calculatedBaseTax = 0.000;

        if ((state.equalsIgnoreCase("WI") || state.equalsIgnoreCase("Wisconsin")))
        {
            calculatedBaseTax = 0.050;

            if (county.equalsIgnoreCase("Eau Claire"))
            {
                calculatedBaseTax += 0.005;
            }

            if (county.equalsIgnoreCase("Dunn"))
            {
                calculatedBaseTax += 0.004;
            }
        }
        if ((state.equalsIgnoreCase("IL") || state.equalsIgnoreCase("Illinois")))
        {
            calculatedBaseTax = 0.080;
        }
        return calculatedBaseTax;
    }

    public double calculateTaxAmount(double taxRate, double subTotal)
    {
        return taxRate * subTotal;
    }

    public static String genOutputString(double taxAmount, double total)
    {
        return String.format("The tax is %.2f.\nThe total is %.2f", taxAmount, total);
    }
}
