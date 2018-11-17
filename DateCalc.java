import javax.swing.*;
import java.util.*;
import javax.swing.JOptionPane;



public class DateCalc {
  //test comment bla bla bla
  //test 2 does it work?
  public static Boolean LeapYear(int currentYear) {
    /* Class that determines if an inputyear is a leapyear or not, returns a Boolean */
    if(currentYear % 100 == 0&& currentYear % 400 != 0){
      return false;
    }
    if(currentYear % 4 == 0 && currentYear % 100 != 0 || currentYear % 400 == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  public static int DaysInFinalYear(int intYear, int intDays, int intMonths){
    /* Class determines total amount of days in the inputed year, returns an integer of
    said value*/
    int totalDays = 0;
    int sum = 0;
    int i = 0;
    int totalDaysInMonths = 0;
    int[] daysInMonths = new int[12];
      daysInMonths[0] = 31;
      daysInMonths[1] = 28;
      daysInMonths[2] = 31;
      daysInMonths[3] = 30;
      daysInMonths[4] = 31;
      daysInMonths[5] = 30;
      daysInMonths[6] = 31;
      daysInMonths[7] = 31;
      daysInMonths[8] = 30;
      daysInMonths[9] = 31;
      daysInMonths[10] = 30;
      daysInMonths[11] = 31;

      Boolean leapYear = LeapYear(intYear);

      while (i < intMonths - 1) {
        totalDaysInMonths += daysInMonths[i];
        i++;
      }
      if (intMonths < 3) {
        totalDays = intDays + 31 * (intMonths - 1);
      }
      else {
        if (leapYear == true){
          totalDays = intDays + totalDaysInMonths + 1;
        }
        else{
          totalDays = intDays + totalDaysInMonths;
        }
      }
      return totalDays;
  }


  public static int DaysInPriorYears(int intYear){
    /* Determines the amount of days in all the years from 1754 until the year prior
    to inputed year, returns an integer */
    int totalDaysInCurrentYear = 0;
    int totalDaysTillLastYear = 0;
    Boolean leapYear = false;
    int i = 1754;

    while (i < intYear) {
      leapYear = LeapYear(i);
      if (leapYear == true) {
        totalDaysInCurrentYear = 366;
      }
      else {totalDaysInCurrentYear = 365;}

      totalDaysTillLastYear += totalDaysInCurrentYear;
      i++;
    }
    return totalDaysTillLastYear;
  }


    public static void main(String[] args) {
      while (true) {
        String day = "test";
        int intYear = 0;
        int intMonths = 0;
        int intDays = 0;
        int dayTotal = 0;
        Boolean leapYear = LeapYear(intYear);

      JFrame frame = new JFrame("Input");
      String input = JOptionPane.showInputDialog(
        frame,
        "Enter a date in the format YYYY-MM-DD",
        "Input",
        JOptionPane.QUESTION_MESSAGE
      );

      if(input == null) {
        break;
      }
      /* Following code handels errors with input*/
      if (input.length() == 0){
        JOptionPane.showMessageDialog(frame,
        "No input is written");
        continue;
      }

      String substringYear = input.substring(0, 4);
      String substringMonths = input.substring(5, 7);
      String substringDays = input.substring(8);

      try {
        intYear = Integer.parseInt(substringYear);
        intMonths = Integer.parseInt(substringMonths);
        intDays = Integer.parseInt(substringDays);
      }
      catch(NumberFormatException e) {
        JOptionPane.showMessageDialog(frame,
        "Input is written in wrong format");
        continue;
      }
        intYear = Integer.parseInt(substringYear);
        intMonths = Integer.parseInt(substringMonths);
        intDays = Integer.parseInt(substringDays);

        if (
          intMonths > 12 ||
          intMonths == 2 && leapYear == true && intDays > 29 ||
          intMonths == 2 && leapYear == false && intDays > 28 ||
          intMonths == 1 && intDays > 31 ||
          intMonths == 3 && intDays > 31 ||
          intMonths == 4 && intDays > 30 ||
          intMonths == 5 && intDays > 31 ||
          intMonths == 6 && intDays > 30 ||
          intMonths == 7 && intDays > 31 ||
          intMonths == 8 && intDays > 31 ||
          intMonths == 9 && intDays > 30 ||
          intMonths == 10 && intDays > 31 ||
          intMonths == 11 && intDays > 30 ||
          intMonths == 12 && intDays > 31)
          { JOptionPane.showMessageDialog(frame,
          "Wrong date format, or non existing date");
          continue;
        }
          if (intYear < 1754) {
            JOptionPane.showMessageDialog(frame,
            "Year is to early");
          }
          /* Calculates total amounts of days from 1754 01 01 until inputed date*/
          else {
            dayTotal = DaysInPriorYears(intYear)+DaysInFinalYear(intYear,intDays,intMonths);
          }
          /* Uses remainder to calculate which day of the week the inputed date is*/
          if (dayTotal % 7 == 1) {
            day = "Tuesday";
          }
          if (dayTotal % 7 == 2) {
            day = "Wednesday";
          }
          if (dayTotal % 7 == 3) {
            day = "Thursday";
          }
          if (dayTotal % 7 == 4) {
            day = "Friday";
          }
          if (dayTotal % 7 == 5) {
            day = "Saturday";
          }
          if (dayTotal % 7 == 6) {
            day = "Sunday";
          }
          if (dayTotal % 7 == 0) {
            day = "Monday";
          }

          JOptionPane.showMessageDialog(null,
          "Day is/was a " + day);
    }//whiletror jag
    System.exit(0);
  }
}
