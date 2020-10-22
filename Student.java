import java.util.Scanner;  
import java.util.Calendar;
import java.util.Date;

public class Student {
    public static void main (String[]args) {

        String [] names = new String[3];  
        int [][] notes = new int [3][2];
        Scanner myObj = new Scanner(System.in);
        int flag1 = 0;

        System.out.println("Please enter the names of your students : ");
        while (flag1 < 3){
            names[flag1] = myObj.nextLine();
            flag1++;
        }

        System.out.println("\nPlease now enter the notes of those students in Maths");
        flag1 = 0;
        while (flag1 <  3){
            System.out.println(" Maths note of " + names[flag1] + " : ");
            notes[flag1][0] = myObj.nextInt();
            flag1++;
        }

        System.out.println("\nPlease now enter the notes of your students in Java");
        flag1 = 0;
        while (flag1 <  3){
            System.out.println(" Java note of " + names[flag1] + " : ");
            notes[flag1][1] = myObj.nextInt();
            flag1++;
        }

        //Exchange of notes

        String usefullName = names[0];
        names[0] = names[2];
        names[2] = usefullName;

        //Display

        for(int i = 0 ; i < 3 ; i++){
            
            System.out.println("Student name : " + names[i] + " ; Maths note : " + notes[i][0] + " ; Java note : " + notes[i][1]);
        }
    }
}