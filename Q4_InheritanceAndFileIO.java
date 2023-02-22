package HvLLAssignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

class ResidencialSociety{
    String societyName;
    String location;
    String secoratoryName;
    public void showDetails(){
        System.out.println("society name is:"+this.societyName);
        System.out.println("Location is:"+this.location);
        System.out.println("Secoratory name is:"+this.secoratoryName);
    }

}
class Building extends ResidencialSociety
{
    String bulidingName;
    int totalApartments;

    public Building(int totalApartments) {
        this.totalApartments = totalApartments;
    }

    public Building(String bulidingName) {
        this.bulidingName = bulidingName;
    }


}
class ApartMent extends Building
{
    int apartmentNumber;
    String ownerName;
    String electricMeter;

    public ApartMent(int apartmentNumber,String bulidingName, String ownerName, String electricMeter) {
        super(bulidingName);
        this.apartmentNumber = apartmentNumber;
        this.ownerName = ownerName;
        this.electricMeter = electricMeter;
    }
}


public class Q4_InheritanceAndFileIO {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ResidencialSociety societyObj = new ResidencialSociety();
        societyObj.societyName = "Galaxy-Apartment";
        societyObj.location ="Banjara Hills, Hyderabad";
        societyObj.secoratoryName = "mavin";
        Building buildingA = new Building(10);
        Building buildingB = new Building(10);
        Building buildingC = new Building(10);
        ApartMent[] A = new ApartMent[10];
        ApartMent[] B = new ApartMent[10];
        ApartMent[] C = new ApartMent[10];
        try {
            BufferedReader br = new BufferedReader(new FileReader("DemoText.csv"));
            String line ="";

            int count =0;
            int index = 0;
            while ((line = br.readLine())!=null ){
                String[] arr = line.split(",");
                if(count%10==0) index=0;
                if(count<10) {
                        A[index] = new ApartMent(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);

                }
                else if(count<20) {

                        B[index] = new ApartMent(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);

                }
                else if(count<30) {
                        C[index] = new ApartMent(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3]);

                }
                index++;
                count++;

            }
            while (true){
                mainMessage();
                int n = sc.nextInt();
                sc.nextLine();
                if(n==1){
                    for (int i = 0; i < 10; i++) {
                        System.out.println(A[i].apartmentNumber+" "+A[i].bulidingName+" "+A[i].ownerName+" "+A[i].electricMeter);
                    }
                    for (int i = 0; i < 10; i++) {
                        System.out.println(B[i].apartmentNumber+" "+B[i].bulidingName+" "+B[i].ownerName+" "+B[i].electricMeter);
                    }
                    for (int i = 0; i < 10; i++) {
                        System.out.println(C[i].apartmentNumber+" "+C[i].bulidingName+" "+C[i].ownerName+" "+C[i].electricMeter);
                    }
                }
                else if(n==2){
                    System.out.println("1.Building A");
                    System.out.println("2.Building B");
                    System.out.println("3.Building C");
                }
                else if (n==3) {
                    societyObj.showDetails();
                }
                    System.out.println("enter y to continue");
                    char ch = sc.nextLine().charAt(0);
                    if(ch=='y'|| ch=='Y'){
                        continue;
                    }
                    else System.exit(0);
                }



        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    private static void mainMessage() {
        System.out.println("1. View Apartment details");

        System.out.println("2. View Building Details");

        System.out.println("3. View Society Details");
        System.out.println("enter your choice");

    }

}
