import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class VacinationCenter {

    public void Initialise( Booth boothArry[]){
            for (int i = 0; i < boothArry.length; i++) {
                Booth tempBooth=new Booth();
                tempBooth.setCustomerName("");
                tempBooth.setVaccineStock(200);
                tempBooth.setSurName("");
                tempBooth.setAge("");
                tempBooth.setCity("");
                tempBooth.setNic("");
                tempBooth.setVaccinationType("");
                boothArry[i]=tempBooth;

        }
            System.out.println("initialised...");

    } //initialise booth
    public static void AddPatient(Booth bootharry[]){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Booth Number:");
        int boothNum=input.nextInt();
        System.out.println("Enter Patient First Name:");
        String patient;
        patient=input.next();
        bootharry[boothNum].setCustomerName(patient);
        System.out.println("Enter Patient Surname: ");
        bootharry[boothNum].setSurName(input.next());
        System.out.println("Enter the Age : ");
        bootharry[boothNum].setAge(input.next());
        System.out.println("Enter The City : ");
        bootharry[boothNum].setCity(input.next());
        System.out.println("Enter The NIC number : ");
        bootharry[boothNum].setNic(input.next());
        System.out.println("Enter The Type of Vaccine (AstraZeneca,Sinopharm,Pfizer)");
        bootharry[boothNum].setVaccinationType(input.next());

        System.out.println(patient+" is Added to Booth Number "+boothNum);
    }
    public static  void ViewAllBooths (Booth bootharry[]) {
        for (int i = 0; i < 6; i++) {
            System.out.println("Booth " + i + " is Occupied by " + bootharry[i].getCustomerName());

        }
    }
    public static void ViewEmptyBooths(Booth bootharry[]) {
        for (int i = 0; i <6 ; i++) {
            if(bootharry[i].getCustomerName().equals("")){
                System.out.println("Room Number "+i+" is Empty");
            }
        }

    }
    public static void RemovePatient(Booth bootharry[]) {
        Scanner input =new Scanner(System .in);
        int roomNum;
        System.out.println("Enter The room Number : ");
        roomNum=input.nextInt();
        System.out.println(bootharry[roomNum].getCustomerName()+" has been romoved from Room Numner : "+roomNum);
        bootharry[roomNum].setCustomerName("");



    }
    public static void PatientsSortedAlphabetical(Booth bootharry[]) {
            String nameList[]=new String[6];
        for (int i = 0; i < nameList.length; i++) {
            nameList[i]=bootharry[i].getCustomerName();
        }
        Arrays.sort(nameList);
        System.out.println(Arrays.toString(nameList));

    }
    public static void AddVaccinationsStock(Booth bootharry[]) {

        Scanner input=new Scanner(System.in);
        System.out.println("Which Room Do You need to re-stock :");
        int boothNum=input.nextInt();
        System.out.println("Enter the size of new stock : ");
        int newVaccine=input.nextInt();
        bootharry[boothNum].setVaccineStock(newVaccine+bootharry[boothNum].getVaccineStock());
        System.out.println("Stock Updated..");




    }
    public static void RemainingVaccinations(Booth bootharry[]){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter Booth Number : ");
        int boothNum=input.nextInt();
        System.out.println(bootharry[boothNum].getVaccineStock()+" vaccines Remaining..");
    }
    public static void StoreData(Booth bootharry[]) throws FileNotFoundException {
        Formatter file;
        file=new Formatter("/Users/IdeaProjects/cw 2021/classVersion/src/storeData");
        for (int i = 0; i < bootharry.length; i++) {
            file.format("%s%s%s%s%n","Booth ",i," occupied by ",bootharry[i].getCustomerName());
            file.format("%s%s%n","Surname : ",bootharry[i].getSurName());
            file.format("%s%s%n","Age     : ",bootharry[i].getAge());
            file.format("%s%s%n","City    : ",bootharry[i].getCity());
            file.format("%s%s%n","NIC     : ",bootharry[i].getNic());
            file.format("%s%s%n","Vaccine Type : ",bootharry[i].getVaccinationType());
            file.format("%s%n","-------------------------------");
        }
        file.format("%s%n","-------------------------------");
        for (int i = 0; i < bootharry.length; i++) {
            file.format("%s%s%s%s%n","Remaining Vaccine Count in Booth Number ",i," : ",bootharry[i].getVaccineStock());
        }

        file.close();

    }
    public static void LoadData(Booth bootharry[]) throws FileNotFoundException {
        Scanner read = new Scanner(new File("/Users/IdeaProjects/cw 2021/classVersion/src/programData"));
        String boothNum;
        while (read.hasNext()) {

            boothNum = read.next();
            bootharry[Integer.parseInt(boothNum)].setCustomerName(read.next());

        }
    }


}
