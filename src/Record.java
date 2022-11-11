class Record {
    public long id;
    public String phoneNumber;
    public String name;

    public Record(long id, String phoneNumber, String name) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
    }

    public Record(long id) throws RecordNotValid {
        throw new RecordNotValid("В новой записи не заполнено поле name и поле phoneNumber");
    }

    public Record(long id, String phoneNumber_or_name) throws RecordNotValid {
        throw new RecordNotValid("В новой записи не заполнено поле name или поле phoneNumber");
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.phoneNumber;
    }

    public long getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.phoneNumber = PhoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}