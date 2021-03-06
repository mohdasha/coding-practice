package design.usecase.rover.command;

import design.usecase.rover.MarsRover;

public class RotateRightCommand implements ICommand {
    @Override
    public void execute(MarsRover marsRover) {
        marsRover.turnRight();
    }
}
