package interfaces;

import java.util.List;

/**
 * Created by ramon on 06.10.2016.
 */
public abstract class AbstractCommand implements Command {
    private List<String> arguments;
    private String helpText;
    private String commandName;

    public List<String> getArguments() {
        return arguments;
    }

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }

    public String getHelpText() {
        return helpText;
    }

    public void setHelpText(String helpText) {
        this.helpText = helpText;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public void setBeanName(String s) {
    }
}
