import exceptions.CommandException;
import impl.HelpCommand;
import interfaces.Command;
import org.springframework.beans.BeansException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ramon on 06.10.2016.
 */
public class App {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = new GenericXmlApplicationContext("context.xml")) {
            context.registerShutdownHook();

            List<String> arguments = Arrays.asList(args);
            if (arguments.isEmpty()){
                executeCommand(context.getBean("help", HelpCommand.class), arguments);
                return;
            }

            try {
                Command command = context.getBean(arguments.get(0), Command.class);
                executeCommand(command, arguments.subList(1, arguments.size()));
            } catch (BeansException e) {
                System.out.println(String.format("Ошибка в имени команды %1$", arguments.get(0)));
            }
        }
    }

    private static void executeCommand(Command command, List<String> arguments) {
        try {
            command.setArguments(arguments);
            command.execute();
        } catch (CommandException e) {
            System.out.println(String.format("Ошибка во время исполнения команды %1$S: %2$S", command.getCommandName(), e.getMessage()));
        }
    }
}
