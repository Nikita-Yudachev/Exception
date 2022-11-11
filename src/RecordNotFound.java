public class RecordNotFound extends RuntimeException {
    private long iD;

    public long getId() {
        return this.iD;
    }

    public RecordNotFound(String message, long id) {
        super(message + id);
        this.iD = id;
    }
}