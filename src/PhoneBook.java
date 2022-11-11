import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private String number;

    public PhoneBook(String number) {
        this.number = number;
    }

    static ArrayList<Record> group = new ArrayList<>();

    public List<Record> getAllRecords() {
        return group;
    }

    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        for (Record i : group) {
            if (i.getPhoneNumber() == record.getPhoneNumber()) {
                throw new PhoneNumberAlreadyExists("Данный номер уже существует.", record.getPhoneNumber());
            }
        }
        group.add(record);
    }

    public void updateRecord(Record record) throws RecordNotFound, PhoneNumberAlreadyExists {
        long k = 0;
        for (Record i : group) {
            if (i.getId() == record.getId()) {
                k += 1;
                if (i.getPhoneNumber() == record.getPhoneNumber()) {
                    i.setName(record.getName());
                }
                if (i.getPhoneNumber() != record.getPhoneNumber()) {
                    for (Record j : group) {
                        if (j.getPhoneNumber() == record.getPhoneNumber()) {
                            throw new PhoneNumberAlreadyExists("Невозможно обновить запись. Данный номер уже существует.", record.getPhoneNumber());
                        }
                    }
                    i.setName(record.getName());
                    i.setPhoneNumber(record.getPhoneNumber());
                }
            }
        }
        if (k == 0) {
            throw new RecordNotFound("Невозможно обновить запись. Данный id не найден.", record.getId());
        }
    }

    public void deleteRecord(long id) throws RecordNotFound {
        long k = 0;
        for (int i = 0; i < group.size(); i++) {
            if (group.get(i).getId() == id) {
                k += 1;
                group.remove(i);
            }
        }
        if (k == 0) {
            throw new RecordNotFound("Невозможно удалить запись. В справочнике нет записи с id: ", id);
        }
    }
}