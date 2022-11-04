import java.util.ArrayList;
public class PhoneBook {
    String number;
    public PhoneBook(String number){
        this.number = number;
    }
    static ArrayList<Record> group = new ArrayList<>();
    public ArrayList<Record> getAllRecords(){
        return group;
    }
    public void createRecord(Record record) throws PhoneNumberAlreadyExists {
        for(Record i: group){
            if(i.phoneNumber == record.phoneNumber){
                throw new PhoneNumberAlreadyExists("Данный номер уже существует.", record.phoneNumber);
            }
        }
        group.add(record);
    }
    public void updateRecord(Record record) throws RecordNotFound, PhoneNumberAlreadyExists {
        long k = 0;
        for(Record i: group){
            if(i.id == record.id){
                k+=1;
                if(i.phoneNumber == record.phoneNumber) {
                    i.name = record.name;
                }
                if(i.phoneNumber != record.phoneNumber){
                    for(Record j: group){
                        if(j.phoneNumber == record.phoneNumber){
                            throw new PhoneNumberAlreadyExists("Невозможно обновить запись. Данный номер уже существует.", record.phoneNumber);
                        }
                    }
                    i.name = record.name;
                    i.phoneNumber = record.phoneNumber;
                }
            }
        }
        if(k==0){
            throw new RecordNotFound("Невозможно обновить запись. Данный id не найден.", record.id);
        }
    }
    public void deleteRecord(long id) throws RecordNotFound {
        long k = 0;
        for(int i = 0; i<group.size(); i++){
            if(group.get(i).id == id){
                k+=1;
                group.remove(i);
            }
        }
        if(k==0){
            throw new RecordNotFound("Невозможно удалить запись. В справочнике нет записи с id: ", id);
        }
    }
}