import java.util.*;   

public class ContactList {

    HashMap<String, Person> contactMap = new HashMap<String, Person>();

    public boolean createContact(Person person) {
        if (contactMap.containsKey(person.getName())) {
            return false;
        } else {
            contactMap.put(person.getName(), person);
            return true;
        }
    }

    public boolean lookupContact(String name) {
        return contactMap.containsKey(name);
    }

    public Person getContact(String name) {

        return contactMap.get(name);
    }

    public Person[] getContactByRange(String start, String end) {

        if (start.compareTo(end) >= 0) {
            throw new IllegalArgumentException();
        } else {
            ArrayList<String> names = new ArrayList<>(contactMap.keySet());
            ArrayList<Person> persons = new  ArrayList<>();

            for (String name : names) {
                if (name.compareTo(start)>=0 && name.compareTo(end)<0) {
                    persons.add(contactMap.get(name));
                }
            }
            return persons.toArray(new Person[persons.size()]);
        }


    }

    public boolean deleteContact(String name) {

        if (contactMap.containsKey(name)) {
            contactMap.remove(name);
            return true;
        }
        return false;
    }

    public int size() {
        return this.contactMap.size();
    }

    public String[] fetchAllNames() {
        Set<String> names = contactMap.keySet();
        String[] allNames = names.toArray(new String[names.size()]);
        return allNames;
    }

    public String[] fetchAllPhoneNumbers() {
        Set<String> numbers = new HashSet<>();
        ArrayList<String> names =  new ArrayList<>(contactMap.keySet());

        for (String name : names) {
            numbers.addAll(contactMap.get(name).getPhoneNumbers());
        }
        List<String> sortedPns = new ArrayList<>(numbers);
        Collections.sort(sortedPns);
        return sortedPns.toArray(new String[sortedPns.size()]);
    }
}
