package javademo.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

//ArrayList
public class Bai34_ArrayList {

    public static void main(String[] args) {
        ProcessDictionary34 pd = new ProcessDictionary34();
        ArrayList<Dictionary34> adic1, adic2;
        adic1 = pd.create();
        pd.write(adic1);
        adic2 = pd.read();
        pd.show(adic2);
    }
}

@SuppressWarnings("serial")
class Dictionary34 implements Serializable {

    private String word, mean;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Dictionary34() {

    }

    public Dictionary34(String word, String mean) {
        this.word = word;
        this.mean = mean;
    }

}

class ProcessDictionary34 {

    ArrayList<Dictionary34> adic = new ArrayList<>();
    Scanner k = new Scanner(System.in);
    Dictionary34 dic;

    public ArrayList<Dictionary34> create() {
        System.out.print("Enter number of words : ");
        int n = Integer.parseInt(k.nextLine());
        for (int i = 0; i < n; i++) {
            Dictionary34 dic = new Dictionary34();

            System.out.print("Enter word [" + i + "]: ");
            String word = k.nextLine();
            System.out.print("Enter mean [" + i + "]: ");
            String mean = k.nextLine();

            dic = new Dictionary34(word, mean);
            adic.add(dic);
        }
        return adic;
    }

    public void write(ArrayList<Dictionary34> adic) {
        try {
            FileOutputStream fos = new FileOutputStream("example.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(adic);
            fos.close();
            oos.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    @SuppressWarnings("unchecked")
    public ArrayList<Dictionary34> read() {
        try {
            FileInputStream fis = new FileInputStream("example.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            adic = (ArrayList<Dictionary34>) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
        } catch (IOException | ClassNotFoundException e) {
        }
        return adic;
    }

    public void show(ArrayList<Dictionary34> adic) {
        for (int i = 0; i < adic.size(); i++) {
            System.out.println("Word [" + i + "] : " + adic.get(i).getWord()
                    + "\nMean [" + i + "] : " + adic.get(i).getMean());
        }
    }

    public void search() {
        System.out.print("Enter word if you want to search : ");
        String word = k.nextLine();
        for (int i = 0; i < adic.size(); i++) {
            if (adic.get(i).getWord().equals(word)) {
                System.out.println("Results for " + word + " : " + "\nWord : "
                        + adic.get(i).getWord() + "\nMean : "
                        + adic.get(i).getMean());
            }
        }
    }

    public void add() {
        System.out.println("Enter word and mean that you want to add : ");
        System.out.print("Word : ");
        String word = k.nextLine();
        System.out.print("Mean : ");
        String mean = k.nextLine();
        Dictionary34 dic = new Dictionary34(word, mean);
        adic.add(dic);
        System.out.println("Done !");
    }

    public void menu() {
        boolean continueLoop = true;
        do {

        } while (!continueLoop);
    }
}
