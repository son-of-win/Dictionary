package source_code;

import java.io.*;
import java.util.Scanner;
import java.util.Set;

public class DictionaryManagement {

    private Dictionary dict = new Dictionary();
    private Word newWord = new Word();

    public void insertFromCommandline() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap so tu can them: ");
        int numOfWord = scan.nextInt();

        for (int i = 0; i < numOfWord; i++) {
            System.out.print("Nhap vao tu tieng Anh va nghia tieng viet: \n");
            String key = scan.nextLine();
            String value = scan.nextLine();
            newWord.setKey(key);
            newWord.setValues(value);
            dict.setDictionary(newWord);
        }
    }

    public void showAllWords() {
        Set<String> keySet = dict.dictionary.keySet();
        System.out.print("No\t|English\t\t\t|Vietnamese\n");
        int index = 1;
        for (String key : keySet) {
            System.out.printf("%d\t|%s\t\t\t\t|%s\n\n",index,key,dict.dictionary.get(key));
            System.out.println(key);
           index ++;
        }
        System.out.println(index);
    }

    public void insertFromFile() throws IOException {

            File  file = new File("D:\\Dictionary\\src\\resource\\database.txt");
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            fis.close();
            String result = new String(data,"UTF-8");
            String[] word = new String[200000];
            word = result.split("@");
            int n = word.length;
            for (int i = 1; i < n; i++) {


                int pos = word[i].indexOf('/');
                if (pos < 0) pos = word[i].indexOf('\n') + 1;
                String key = word[i].substring(0,pos - 1);
                String value = word[i].substring(pos, word[i].length());
                newWord.setKey(key.strip());
                newWord.setValues(value);
                dict.setDictionary(newWord);

            }
    }

    public String dictionaryLookup(String key) {
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Nhap tu ban muon tra: ");
//        String key = scan.nextLine();
        //Set<String> keySet = dict.dictionary.keySet();

        if (dict.dictionary.containsKey(key)) {
            String value = dict.dictionary.get(key);

//            System.out.println(key +": "+ value);
            return key + ": " + value;
        } else {
            System.out.print("tu nay chua co trong tu dien, please update database\n");
            return "Not Found";
        }
    }

    public void exportDictionarytoFile() {
        try {
            File file = new File("D:\\Dictionary\\src\\resource\\output.txt");
            OutputStream outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            Set<String> keySet = dict.dictionary.keySet();
            for (String key : keySet) {
                outputStreamWriter.write(key + " : " + dict.dictionary.get(key));
                //dung de xuong hang
                outputStreamWriter.write("\n");
            }

            outputStreamWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public String dictionarySeacher(String word) {
//        System.out.print("Type your suggest word: ");
//        Scanner scan = new Scanner(System.in);
//        String word = scan.next();
        String result = "";
        Set<String> keySet = dict.dictionary.keySet();
        for (String key : keySet) {
           if (key.length() >= word.length() && key.substring(0,word.length()).equals(word)) {
                result = result + key + '/';
           }
        }
        return result;
    }

    public void editDict(){
        Scanner scan = new Scanner(System.in);
        System.out.print("nhap tu ban muon sua: ");
        String key = scan.nextLine();
        Set<String> keySet = dict.dictionary.keySet();
        if(dict.dictionary.containsKey(key)){
            System.out.print("nhap noi dung value: ");
            String value = scan.nextLine();
            dict.dictionary.remove(key);
            newWord.setKey(key);
            newWord.setValues(value);
            dict.setDictionary(newWord);
        }else {
            System.out.println("Tu nay chua co trong tu dien , them tu nay vao trong tu dien");
            insertFromCommandline();
        }
    }
}
