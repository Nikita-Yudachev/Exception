public class RecordNotValid extends Exception {
    private Record person;
    public RecordNotValid(String message) {
        super(message);
    }
    public String getRecord() {
        return person.toString();
    }
}