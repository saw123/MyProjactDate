import java.util.Scanner;
import java.util.Date;
import java.util.Locale;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Created by IntelliJ IDEA.
 * User: saw
 * Date: 03.08.11
 * Time: 12:40
 * To change this template use File | Settings | File Templates.
 */
public class Lesson1Date {

    public static Calendar parseTime (String timest)
        throws Exception{
        /**
        * Convert date received input from the keyboard in the format Calendar
        *                                                                                *
         */
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ROOT);
        Date d = sdf.parse(timest);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        return cal;
    }

    public static void main (String[] arge) throws Exception {
        /**
         * Enter the name, surname and date of birth
         */
        Scanner in = new Scanner(System.in);

        System.out.print("Enter First name : ");
        String FirstName = in.nextLine();

        System.out.print("Enter Last name : ");
        String LastName = in.nextLine();

        System.out.print("Enter your date of birth (form dd/mm/yyyy):");
        String age = in.nextLine();
//        String age ="11/11/1973";
        /**
         * Output the variables FirstName, LastName, and a formatted date of birth
         */
        System.out.println("First name : " + FirstName);
        System.out.println("Last name : " + LastName);

        /**
         * Format date of birth for the withdrawal
         * and derive the date of birth
         */
        SimpleDateFormat sfd = new SimpleDateFormat("dd MM yyyy");
        System.out.println("Date of Birth : " + sfd.format(parseTime(age).getTime()));

        /**
        * We make calculations connected with the birth date
        * Decompose on the date of manufacture components and calculation
        * after doing validations of months and days
         */
        Calendar c1, c2;

        c1 = parseTime(age);
        c2 = Calendar.getInstance();

        int year1, year2, mon1, mon2, day1, day2 ;
        year1 = c1.get(Calendar.YEAR);
        mon1 = c1.get(Calendar.MONTH);
        day1 = c1.get(Calendar.DAY_OF_MONTH);

        /**
         * Clone the current date to calculate from it
         */
        Calendar gc2 = (Calendar)c2.clone();

        int bryear, brday, brmon;
        gc2.add(Calendar.DAY_OF_MONTH, -day1);
        gc2.add(Calendar.MONTH, -mon1);
        gc2.add(Calendar.YEAR, - year1);

        bryear = gc2.get(Calendar.YEAR);
        brmon = gc2.get(Calendar.MONTH);
        brday = gc2.get(Calendar.DAY_OF_MONTH);

        /**
         * Produce a validation of days and months and transfer days per month and months per year
         */
        if (brday == 31)
        {
            brmon++;
            brday = 0;
        }
        if (brmon == 12)
        {
            bryear++;
            brmon = 0;
        }

//        System.out.println("Первый месяц " + ++mon1);
        System.out.println("From the date of birth was : " + bryear + " year, " + brmon + " months and " + brday + " day" );

    }

}
