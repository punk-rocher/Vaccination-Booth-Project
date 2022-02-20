
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;

public class Vaccination {
    public static void main(String[] args) throws FileNotFoundException {

        String[] booth = new String[6];
        String patientName;
        Boolean programRun=true;
        int vaccine=2000;//vaccine count

        Scanner input=new Scanner(System.in);

        //initialise booth

        for (int i = 0; i < 6; i++) {
            booth[i] = "";
        }

        //control
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
                   ViewAllBooths(booth);
                   break;

               case "APB":
                   AddPatient(booth);
                   break;

               case "EXT":
                   programRun=false;
                   break;
               case "VEB":
                   ViewEmptyBooths(booth);
                   break;
               case "RPB":
                   RemovePatient(booth);
                   break;
               case "VPS":
                   PatientsSortedAlphabetical(booth);
                   break;
               case "VRV":
                 RemainingVaccinations(vaccine);
                 break;
               case "AVS":
                   vaccine=AddVaccinationsStock(vaccine);
                   break;
               case "SPD":
                   StoreData(booth,vaccine);
                   break;
               case "LPD":
                   LoadData(booth,vaccine);
                   break;

           }
       }




    }

    private static void LoadData(String[] booth, int vaccine) throws FileNotFoundException {
        Scanner read = new Scanner(new File("/Users/IdeaProjects/cw 2021/src/LoadData"));
        String boothNum;
        while (read.hasNext()) {

            boothNum = read.next();
             booth[Integer.parseInt(boothNum)]= read.next();

        }
    }

    private static void StoreData(String booth[],int vaccine) throws FileNotFoundException {
        Formatter file;
        file=new Formatter("src/saveData");
        for (int i = 0; i < booth.length; i++) {
            file.format("%s%s%s%s%n","Booth ",i," occupied by ",booth[i]);
        }
        file.format("%s%s%n","Remaining Vaccine Count : ",vaccine);
        file.close();

    }

    private static int AddVaccinationsStock(int vaccine) {

        Scanner input=new Scanner(System.in);
        System.out.println("Enter the size of new stock : ");
        int newVaccine=input.nextInt();
        System.out.println("Stock Updated..");
        return vaccine+newVaccine;



    }

    private  static void RemainingVaccinations(int vaccine){
        System.out.println(vaccine+" vaccines Remaining..");
    }

    private static void PatientsSortedAlphabetical(String[] booth) {
                Arrays.sort(booth);
                System.out.println(Arrays.toString(booth));

    }

    private static void RemovePatient(String[] booth) {
        Scanner input =new Scanner(System .in);
        int roomNum;
        System.out.println("Enter The room Number : ");
        roomNum=input.nextInt();
        System.out.println(booth[roomNum]+" has been romoved from Room Numner : "+roomNum);
        booth[roomNum]="";



    }

    private static void ViewEmptyBooths(String[] booth) {
        for (int i = 0; i <6 ; i++) {
            if(booth[i].equals("")){
                System.out.println("Room Number "+i+" is Empty");
            }
        }

    }

    private static  void ViewAllBooths (String booth[]) {
        for (int i = 0; i < 6; i++) {
            System.out.println("Booth " + i + " is Occupied by " + booth[i]);

        }
    }

    private static void AddPatient(String booth[]){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Booth Number:");
        int boothNum=input.nextInt();
        System.out.println("Enter Patient Name:");
        String patient;
        patient=input.next();
        booth[boothNum]=patient;
        System.out.println(patient+" is Added to Booth Number "+boothNum);
    }
}
