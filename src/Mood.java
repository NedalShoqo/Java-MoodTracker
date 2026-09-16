import java.time.LocalTime;
import java.time.LocalDate;


public class Mood{
    private String name;
    private LocalDate date;
    private LocalTime time;
    private String notes;

    // 1. Mood(String name)
    public Mood(String name) {
        this.name = name;
    }

    // 2. Mood(String name, LocalDate date)
    public Mood(String name, LocalDate date) {
        this.name = name;
        this.date = date;
    }

    // 3. Mood(String name, LocalDate date, LocalTime time)
    public Mood(String name, LocalDate date, LocalTime time) {
        this.name = name;
        this.date = date;
        this.time = time;
    }

    // 4. Mood(String name, String notes)
    public Mood(String name, String notes) {
        this.name = name;
        this.notes = notes;
    }

    // 5. Mood(String name, LocalDate date, String notes)
    public Mood(String name, LocalDate date, String notes) {
        this.name = name;
        this.date = date;
        this.notes = notes;
    }

    // 6. Mood(String name, LocalDate date, LocalTime time, String notes)
    public Mood(String name, LocalDate date, LocalTime time, String notes) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.notes = notes;
    }
// Setters \\

public void setName(String name){this.name = name;}
public void setDate(LocalDate date){this.date=date;}
public void setTime(LocalTime time){this.time = time;}
public void setNotes(String notes){this.notes=notes;}

// Getters \\

public String getName(){return this.name;}
public LocalDate getDate(){return this.date;}
public LocalTime getTime(){return this.time;}
public String getNotes(){return this.notes;}


// toSting() \\
@Override 
public String toString(){
    return "Name =" + this.name + "\n Date ="+this.date + " \n Time = " + this.time + "\n"+ this.notes;
}
}