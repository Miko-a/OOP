public class CommandWords {
    private static final String validCommand[] = {
        "go", "quit", "help", "look"
    };

    public CommandWords() {

    }

    public boolean isCommand(String aString) {
        for (int i = 0; i < validCommand.length; i++) {
            if (validCommand[i].equals(aString)) {
                return true;
            }
        }

        return false;
    }
}
