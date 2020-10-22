import java.util.Scanner;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Student {
    static int nbStudents;
    static int nbNotes;

    private static int[] getMarksBySentence() {
        Scanner input = new Scanner(System.in);

        // if (error)
        //     System.out.println("Error in format of the string, please retry ");
        // else
        System.out.println("Marks :");

        int[] sentenceSplitted = Arrays.stream(input.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();

        // +++++++++input.close(); // must be here or at the end of the function , before return ?

        // if (!(sentenceSplitted.length == 0 || sentenceSplitted.length >= nbNotes) {
        //     getMarksBySentence(true);
        // }

        return sentenceSplitted;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Hi, please enter the number students and how many marks you will give them");
        System.out.println("Number of students:");
        nbStudents = Integer.parseInt(input.nextLine());
        System.out.println("Number of notes:");
        nbNotes = Integer.parseInt(input.nextLine());
        System.out.println("Enter the name of Each students");

        String []names = new String [nbStudents];

        for (int i = 0 ; i < nbStudents ; i++) {
            System.out.println("Student - " + (i + 1) + " : ");
            names[i] = input.nextLine();
        }

        System.out.println("You want to enter theyr marks by a list (separate by \",\") or one by one ?\nEnter 1 for the first choice 2 for the other)");
        int selectedBy = Integer.parseInt(input.nextLine());
        int [][]marks = new int [nbStudents][nbNotes];

        if (selectedBy == 1 || selectedBy == 2) {
            System.out.println("Enter the list of students");

            for (int student = 0 ; student < nbStudents ; student++) {
                System.out.println("Student : " + names[student]);
                if (selectedBy == 1) marks[student] = getMarksBySentence();
                else {
                    for (int mark = 0 ; mark < nbNotes ; mark++) {
                        System.out.println("Mark - " + mark + 1 + ": ");
                        marks[student][mark] = input.nextInt(); 
                    } 
                }
            }
        } else {
            System.out.println("Please enter 1 or 2");
            return;
        }
       
        int succeedCount = 0;
        int succeedAvergageSum = 0;
        int failsCount = 0;
        int failsAvergageSum = 0;
    
        for(int student = 0 ; student < marks.length ; student++) {
            int sumOfOneStudent = Arrays.stream(marks[student]).reduce(0, Integer::sum);
            int average = (sumOfOneStudent / nbNotes);

            System.out.print("Student " + names[student] + " - ");
            if (average < 10) {
                System.out.println("FAIL");
                failsCount++;
                failsAvergageSum += average;
            }
            else {
                System.out.println("SUCEED");
                succeedCount++;
                succeedAvergageSum += average;
            }
            
        }

        int successAverage = succeedAvergageSum / succeedCount;
        int failsAvergae = failsAvergageSum / failsCount;

        System.out.println("Number of students suceed : " + succeedCount);
        System.out.println("Success average : " + successAverage);
        System.out.println("Number of students fail : " + (nbStudents - succeedCount));
        System.out.println("Fails average : " + failsAvergae);
        System.out.println("Globale average : " + (successAverage + failsAvergae) / 2);

        input.close();
    }
}