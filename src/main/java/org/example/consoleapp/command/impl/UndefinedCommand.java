package org.example.consoleapp.command.impl;

import org.example.consoleapp.command.Command;

public class UndefinedCommand implements Command {
    @Override
    public void execute() {
        System.out.println("There is not such a command, try again");
    }

    @Override
    public String toString() {
        return "UndefinedCommand";
    }
}