import java.util.*;   

public class Person {
	
    // Add instance variables here
	public String name;
    public ArrayList<String> pnArr;


	public Person(String name, ArrayList<String> pnArray) {
        this.name = name;
        this.pnArr = pnArray;
	}
	
    public String getName() {
        return this.name;
    }

    public boolean addPhoneNumber(String pn) {

        if (this.pnArr.contains(pn)) {
            return false;
        } else {
            pnArr.add(pn);
            return true;
        }

    }

    public ArrayList<String> getPhoneNumbers() {
        Collections.sort(this.pnArr);
        return this.pnArr;
    }

    public boolean deletePhoneNumber(String pn) {
        if (this.pnArr.contains(pn)) {
            if (this.pnArr.size() == 1) {
                throw new IllegalArgumentException();
            }
            pnArr.remove(pn);
            return true;
        }

        return false;
    }
}
