package interfaces;

import exceptions.CommandException;
import org.springframework.beans.factory.BeanNameAware;

import java.util.List;

/**
 * Created by ramon on 06.10.2016.
 */
public interface Command extends BeanNameAware {
    String getHelpText();
    void execute() throws CommandException;
    void setArguments(List<String> commandArgs);
    String getCommandName();
}
