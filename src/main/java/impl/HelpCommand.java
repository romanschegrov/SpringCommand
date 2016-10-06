package impl;

import exceptions.CommandException;
import interfaces.AbstractCommand;
import interfaces.Command;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import java.util.Map;

/**
 * Created by ramon on 06.10.2016.
 */
public class HelpCommand extends AbstractCommand implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    @Override
    public void execute() throws CommandException {
        Map<String, Command> allBeans = context.getBeansOfType(Command.class);
        for (Command command : allBeans.values()) {
            System.out.println(command.getHelpText());
        }
    }
}