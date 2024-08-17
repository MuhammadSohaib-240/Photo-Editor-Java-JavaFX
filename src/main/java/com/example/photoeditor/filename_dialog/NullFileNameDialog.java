package com.example.photoeditor.filename_dialog;

import java.util.Optional;

public class NullFileNameDialog implements FileNameDialog{
    @Override
    public Optional<String> showAndWait() {
        return Optional.empty();
    }
}
