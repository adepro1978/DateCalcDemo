import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class DateCalcRunner {


    public static void main(String[] args) {
        out.println("********* THIS IS A DATE CALCULATOR **********");

        Scanner scanner = new Scanner(in);


        while (true) {
            out.print("Please enter your  first name: ");
            String fName = scanner.nextLine();

            out.print("your last name: ");
            String lName = scanner.nextLine();

            out.print("Enter your age: ");
            int age = scanner.nextInt();


            String opr, doMore;

            //creating object of DateCalcDemo
            DateCalcDemo dateCalcDemo = new DateCalcDemo();

            //calling method setName and setAge through object
            dateCalcDemo.setName(fName, lName);
            dateCalcDemo.setAge(age);

            //interacting with the user and prompting the user to verify entries.
            out.print(" Hello user!!! Your Username is " + dateCalcDemo.getName() + " and you are " + dateCalcDemo.getAge() +
                              " years old, hope this is correct? \npress 'y' to verify, " +
                              "or 'n' to edit the entry. Pressing other key will quit the program :");

            String verify = scanner.nextLine();
            verify = scanner.nextLine();

            //condition to verify user entry
            if (verify.equals("y".toLowerCase())) {
                out.println(" ");
                out.println("VERIFIED! NOW YOU CAN ADD TO DATE, SUBTRACT FROM DATE AND CONVERT DATE.");
                out.println(" ");

                out.print("Enter a date as '(yyyy/MM/dd HH:mm ): ");
                String date = scanner.nextLine();
                LocalDateTime dateTime = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));


                out.println("chose operation to do 'press + to add and _ to sub");
                opr = scanner.nextLine();

                switch (opr) {
                    case "+":
                        // Add years, months, weeks, days, hours, minutes, seconds to LocalDateTime
                        dateCalcDemo.dateAddMethod(scanner, dateTime);
                        out.println(" ");
                        break;

                    case "-":
                        // Subtract years, months, weeks, days, hours, minutes, seconds to LocalDateTime
                        dateCalcDemo.dateSubMethod(scanner, dateTime);
                        out.println(" ");
                        break;

                    default:
                        out.println("The operation is invalid");
                        out.println(" ");
                        continue;
                }
                out.print("Press E to exit or press any key to continue : ");
                //doMore = scanner.nextLine();
                doMore = scanner.nextLine();

                if (Objects.equals(doMore, "e".toLowerCase())) {
                    out.println("Oops! You quit....Bye for now.....");
                    break;
                } else if (doMore.equals("c")) {
                    out.println("*********  Ok... lets do more  *********");
                }
            } else if (verify.equals("n")) {
                out.println("Please enter a valid name and age.");
            } else {
                out.println("Please try again next time");
                break;
            }
        }
    }
}


//Date calculator class
class DateCalcDemo {

    private String firstName, lastName;
    private int age;

    public String getName() {
        return firstName + " " + lastName;
    }

    public void setName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;


    }

    public void dateAddMethod(Scanner scanner, LocalDateTime dateTime) {

        out.println("Enter date to add");

        out.print("YEAR : ");
        String yearToAdd = scanner.nextLine();

        out.print("MONTH : ");
        String monthToAdd = scanner.nextLine();

        out.print("WEEK : ");
        String weekToAdd = scanner.nextLine();

        out.print("DAY : ");
        String dayToAdd = scanner.nextLine();

        out.print("HOUR : ");
        String hourToAdd = scanner.nextLine();

        out.print("MINUTE : ");
        String minuteToAdd = scanner.nextLine();

        LocalDateTime newDateTime = dateTime.plusYears(Long.parseLong(yearToAdd))
                .plusMonths(Long.parseLong(monthToAdd)).plusWeeks(Long.parseLong(weekToAdd))
                .plusDays(Long.parseLong(dayToAdd)).plusHours(Long.parseLong(hourToAdd))
                .plusMinutes(Long.parseLong(minuteToAdd));
        out.println(newDateTime);
    }


    public void dateSubMethod(Scanner scanner, LocalDateTime dateTime) {

        LocalDateTime newDateTime;
        out.print("Enter date to subtract : ");
        out.println(" ");

        out.print("YEAR : ");
        String yearToMinus = scanner.nextLine();

        out.print("MONTH : ");
        String monthToMinus = scanner.nextLine();

        out.print("WEEK : ");
        String weekToMinus = scanner.nextLine();

        out.print("DAY : ");
        String dayToAMinus = scanner.nextLine();

        out.print("HOUR : ");
        String hourToMinus = scanner.nextLine();

        out.print("MINUTE : ");
        String minuteToMinus = scanner.nextLine();

        newDateTime = dateTime.minusYears(Long.parseLong(yearToMinus))
                .minusMonths(Long.parseLong(monthToMinus)).minusWeeks(Long.parseLong(weekToMinus))
                .minusDays(Long.parseLong(dayToAMinus)).minusHours(Long.parseLong(hourToMinus))
                .minusMinutes(Long.parseLong(minuteToMinus));
        out.println(newDateTime);
    }
}