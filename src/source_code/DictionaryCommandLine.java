package source_code;

import javax.imageio.IIOException;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryCommandLine {


        public DictionaryManagement manageDict = new DictionaryManagement();
        public DictionaryCommandLine() {
            try {
                manageDict.insertFromFile();
            } catch (IIOException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    public String searcher(String word){
        return manageDict.dictionarySeacher(word);
    }

    public String lookUp(String key){
        return manageDict.dictionaryLookup(key);
    }
    public void editDictionary(String key){
            manageDict.editDict();
    }

    public void showDict(){
            manageDict.showAllWords();
    }
}
