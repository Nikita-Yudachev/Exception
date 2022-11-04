public class Starter {
    public static void main(String[] args) {
        PhoneBook myBook = new PhoneBook("1");
        try {
            myBook.createRecord(new Record(90000));
            myBook.createRecord(new Record(90001, "89829381506", "Никита Ю"));
            myBook.createRecord(new Record(90002, "89529381507", "Alina К"));
            myBook.createRecord(new Record(90003, "89529381508"));
            myBook.createRecord(new Record(90004, "Sveta К"));
            myBook.createRecord(new Record(90005, "89059274003", "Никита Юдачев"));

        } catch(PhoneNumberAlreadyExists e) {
            System.out.print(e.getMessage());
            System.out.println(e.getPhoneNumber());
        }
        catch (RecordNotValid e) {
            System.out.print(e.getMessage());
            System.out.println(e.getRecord());
        }
        System.out.println(myBook.getAllRecords());
        try {
            myBook.updateRecord(new Record(90002, "89529383507", "Alina U"));
            myBook.updateRecord(new Record(90004, "Sveta U"));
        } catch(PhoneNumberAlreadyExists e) {
            System.out.print(e.getMessage());
            System.out.println(e.getPhoneNumber());
        } catch (RecordNotValid e){
            System.out.print(e.getMessage());
            System.out.println(e.getRecord());
        }
        System.out.println(myBook.getAllRecords());
        myBook.deleteRecord(90005);
        System.out.println(myBook.getAllRecords());
    }
}