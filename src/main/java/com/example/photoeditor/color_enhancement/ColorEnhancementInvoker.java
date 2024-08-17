package com.example.photoeditor.color_enhancement;

@SuppressWarnings("All")
public class ColorEnhancementInvoker {
    private ColorEnhancement command;

    public void setCommand(ColorEnhancement command) {
        this.command = command;
    }

    public void execute(double value) {
        if (command != null) {
            command.execute(value);
        }
    }
}
