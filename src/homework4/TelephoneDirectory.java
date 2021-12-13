package homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TelephoneDirectory {

    private HashMap<String, List<Long>> list;

    public TelephoneDirectory() {
        this.list = new HashMap<String, List<Long>>();
    }

    public void add(String surname, Long phoneNumber) {
        List<Long> number = new ArrayList<Long>();

        if (this.list.containsKey(surname)) {
            number = this.list.get(surname);
        }
        number.add(phoneNumber);
        this.list.put(surname, number);
    }

    public String get(String surname){
        String s = "";
        if (this.list.containsKey(surname)) {
            s = "Фамилия: " + surname + ", номер телефона: " +
                    this.list.get(surname).toString()
                            .replace(" ", "")
                            .replace(",", "] или [");
        } else {
            s = "Сотрудник остутствует";
        } return s;
    }
}
