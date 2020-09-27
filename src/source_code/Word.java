package source_code;

public class Word {

    private String Key;
    private String Values;
    private String Pronounce;

    public void setKey(String key) {
        this.Key = key;
    }

    public String getKey(){
        return this.Key;
    }

    public void setValues(String values) {
        this.Values = values;
    }

    public String getValues(){
        return this.Values;
    }

    public void setPronounce(String pronounce) { this.Pronounce = pronounce;};

    public String getPronounce() {
        return Pronounce;
    }
}
