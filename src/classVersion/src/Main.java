import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Boolean programRun=true;
        Booth boothArry[]=new Booth[6];
        VacinationCenter center=new VacinationCenter();
        Scanner input=new Scanner(System.in);

        center.Initialise(boothArry);

        while(programRun){

            System.out.println();
            System.out.println("Type VVB for View all Vaccination Booths");
            System.out.println("Type APB for Add Patient to a Booth");
            System.out.println("Type EXT for Exit the Program");
            System.out.println("Type VEB for View all Empty Booths");
            System.out.println("Type RPB For Remove Patient from a Booth");
            System.out.println("Type VPS for View Patients Sorted in alphabetical order");
            System.out.println("Type VRV for View Remaining Vaccinations");
            System.out.println("Type AVS for Add Vaccinations to the Stock");
            System.out.println("Type SPD for Store Program Data into file");
            System.out.println("Type LPD for Load Program Data from file");
            String control=input.nextLine().toUpperCase(Locale.ROOT);

            switch (control){

                case "VVB":
                    center.ViewAllBooths(boothArry);
                    break;

                case "APB":
                    center.AddPatient(boothArry);
                    break;

                case "EXT":
                    programRun=false;
                    break;
                case "VEB":
                    center.ViewEmptyBooths(boothArry);
                    break;
                case "RPB":
                    center.RemovePatient(boothArry);
                    break;
                case "VPS":
                    center.PatientsSortedAlphabetical(boothArry);
                    break;
                case "VRV":
                    center.RemainingVaccinations(boothArry);
                    break;
                case "AVS":
                    center.AddVaccinationsStock(boothArry);
                    break;
                case "SPD":
                    center.StoreData(boothArry);
                    break;
                case "LPD":
                    center.LoadData(boothArry);
                    break;

            }
        }
    }
}
