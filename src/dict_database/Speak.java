package dict_database;

import com.sun.speech.freetts.VoiceManager;

public class Speak {
    public static void SpeakWord(String text){
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        VoiceManager voiceManager = VoiceManager.getInstance();
        com.sun.speech.freetts.Voice newVoice = voiceManager.getVoice("kevin16");
        newVoice.allocate();
        newVoice.speak(text);
        newVoice.deallocate();
    }
}
