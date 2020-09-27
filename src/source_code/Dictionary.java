package source_code;

import java.util.HashMap;

public class Dictionary {

    protected HashMap<String, String> dictionary = new HashMap<String, String>();
    public void setDictionary(Word word){
        String value = "\n" + word.getValues();
        this.dictionary.put(word.getKey(),value);
    }
}
