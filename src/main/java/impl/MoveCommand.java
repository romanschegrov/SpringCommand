package impl;

import exceptions.CommandException;
import interfaces.AbstractCommand;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ramon on 06.10.2016.
 */
public class MoveCommand extends AbstractCommand {
    @Override
    public void execute() throws CommandException {
        if (getArguments().isEmpty()){
            throw new CommandException(String.format("Пуст список параметров команды %1$S", getCommandName()));
        }

        File from = new File(getArguments().get(0));
        if (!from.exists()) {
            throw new CommandException(String.format("Файл %1$S не найден", from));
        }

        Path to = null;
        try {
            to = Paths.get(getArguments().get(1));
        } catch (InvalidPathException e) {
            throw new CommandException(String.format("Ошибка в файле назначения %1$S", to));
        }

        try {
            Files.move(from.toPath(), to);
        } catch (IOException e) {
            throw new CommandException(String.format("Ошибка при перемещении файла: %1$S", e.getMessage()));
        }
    }
}
