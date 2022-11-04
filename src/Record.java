class Record{
    long id;
    String phoneNumber;
    String name;
    public Record(long id, String phoneNumber, String name){
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
    public Record (long id) throws RecordNotValid{
        throw new RecordNotValid("В новой записи не заполнено поле name и поле phoneNumber");
    }
    public Record(long id, String phoneNumber_or_name) throws RecordNotValid {
        throw new RecordNotValid("В новой записи не заполнено поле name или поле phoneNumber");
    }
    @Override
    public String toString() {
        return this.id + " " + this.name+ " " + this.phoneNumber;
    }
}