public class InvalidMoodException extends Exception {

    public InvalidMoodException(){
        super("A mood already exists at this date and time.");
    }
    
}
