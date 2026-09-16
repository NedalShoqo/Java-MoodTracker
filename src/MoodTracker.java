import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;

public class MoodTracker {
    
    public static void main(String[] args) {
        ArrayList<Mood> moodArrayList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);


        Boolean condition = true;
        while (condition) {
            System.out.println("Please choose an option:\n" + //
                    "\n" + //
                    "a - Add Mood\n" + //
                    "d - Delete Mood\n" + //
                    "e - Edit Mood Notes\n" + //
                    "s - Search Mood\n" + //
                    "w - Write Moods to File\n" + //
                    "x - Exit\n" + //
                    "\n" + //
                    "Enter your choice:");

            char choice = scanner.nextLine().charAt(0);

            switch (choice) {
                case 'a':
                case 'A':
                    Mood mood = null;
                    System.out.println("Enter The Name \n");
                    String name = (scanner.nextLine());
                    System.out.println("Enter The Date \n");
                    LocalDate localDate = (LocalDate.parse(scanner.nextLine()));
                    System.out.println("Enter The Time \n");
                    LocalTime localTime = (LocalTime.parse(scanner.nextLine()));
                    System.out.println("Enter The Notes \n");
                    String notes = (scanner.nextLine());

                    mood = new Mood(name, localDate, localTime, notes);

                    Boolean checkValidaty = false;

                    for (Mood mood2 : moodArrayList) {

                        try {
                            if (mood2.getTime().equals(mood.getTime()) && mood2.getDate().equals(mood.getDate())) {
                                checkValidaty = true;
                                throw new InvalidMoodException();
                            }
                        } catch (Exception e) {
                            System.out.println("Exception =" + e.getMessage());
                        }

                    }

                    if (!checkValidaty) {
                        moodArrayList.add(mood);
                    }

                    break;

                case 'd':
                case 'D':
                    System.out.println("Please Enter The Date Of The Mood To Delete");
                    LocalDate moodToDelete = LocalDate.parse(scanner.nextLine());

                    for (Mood mood3 : moodArrayList) {
                        if (mood3.getDate().equals(moodToDelete)) {
                            moodArrayList.remove(mood3);
                        }
                    }
                    break;

                case 'e':
                case 'E':
                    try {
                        System.out.println("Enter the mood name");
                        String moodName = scanner.nextLine();
                        System.out.println("Input the date in MM/dd/yyyy format:");
                        LocalDate moodDateStr = LocalDate.parse(scanner.nextLine());
                        System.out.println("Input the time in HH:mm:ss format:");
                        LocalTime moodTimeStr = LocalTime.parse(scanner.nextLine());
                        System.out.println("Add new notes about this mood");
                        String moodNotes = scanner.nextLine();

                        for (Mood mood4 : moodArrayList) {
                            if (mood4.getName().equals(moodName) || mood4.getDate().equals(moodDateStr)
                                    || mood4.getTime().equals(moodTimeStr)) {
                                mood4.setNotes(moodNotes);
                            }
                        }
                    } catch (DateTimeParseException e) {
                        System.out
                                .println("Incorrect format of date or time. Cannot create mood. \n " + e.getMessage());
                    }
                    break;

                case 's':
                case 'S':
                    System.out.println("Please Enter The Date Of The Mood To Search");
                    LocalDate moodToSearch = LocalDate.parse(scanner.nextLine());

                    for (Mood mood3 : moodArrayList) {
                        if (mood3.getDate().equals(moodToSearch)) {
                            System.out.println(mood3.toString());
                        }
                    }
                    break;

                case 'w':
                case 'W':
                    try (PrintWriter writer = new PrintWriter(new FileWriter("Moods.txt"))) {
                        for (Mood mood5 : moodArrayList) {
                            writer.println(mood5 + "\n\n");
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                case 'x':
                case 'X':
                    condition = false;

                default:
                    break;
            }
        }
        scanner.close();
    }
}
