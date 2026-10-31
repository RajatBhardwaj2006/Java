import java.util.ArrayList;

public class arraylist {

    public static void main(String[] args) {

        ArrayList<String> medicines = new ArrayList<>();

        medicines.add("Paracetamol");
        medicines.add("Crocin");
        medicines.add("Vitamin C");
        medicines.add("Aspirin");

        String searchMedicine = "Aspirin";

        for (int i = 0; i < medicines.size(); i++) {

            if (medicines.get(i).equals(searchMedicine)) {

                System.out.println("Medicine found at index: " + i);
                break;
            }
        }
    }
}
