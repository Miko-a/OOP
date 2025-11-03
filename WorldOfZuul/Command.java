public class Command {
    private String commandWord;
    private String secondWord;

    public Command(String firstWord, String secondWord) {
        commandWord = firstWord;
        this.secondWord = secondWord;
    }

    // return the command word, or null if unknown 
    public String getCommandWord() { return commandWord; }

    // return the second word of the command, or null if none 
    public String getSecondWord() { return secondWord; }

    // return true if this command is unknown (no command word) 
    public boolean isUnknown() { return commandWord == null; }

    // return true if the command has a second word 
    public boolean hasSecondWord() { return secondWord != null; }
}