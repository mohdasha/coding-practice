package design.usecase.rover.parser;

import design.usecase.rover.command.ICommand;
import design.usecase.rover.command.MoveCommand;
import design.usecase.rover.command.RotateLeftCommand;
import design.usecase.rover.command.RotateRightCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class StringCommandParser {
    private final String commandString;
    private static Map<String, Supplier<ICommand>> commandMap = new HashMap<>();

    static {
        commandMap.put("L", RotateLeftCommand::new);
        commandMap.put("R", RotateRightCommand::new);
        commandMap.put("M", MoveCommand::new);
    }

    public StringCommandParser(String commandString) {
        this.commandString = commandString;
    }

    public List<ICommand> parse() {
        List<ICommand> commands = new ArrayList<>();
        for(char c: this.commandString.toCharArray()) {
            commandMap.get(c+"").get();
        }
        return commands;
    }
}
