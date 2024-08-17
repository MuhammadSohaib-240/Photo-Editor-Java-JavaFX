package com.example.photoeditor.menu_actions;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("All")
public class MenuItemsActions implements Action {
    private List<Action> actions;

    public MenuItemsActions() {
        this.actions = new ArrayList<>();
    }

    public void addAction(Action action) {
        actions.add(action);
    }

    public void removeAction(Action action) {
        actions.remove(action);
    }

    @Override
    public void execute() {
        // Execute only the last added action
        if (!actions.isEmpty()) {
            Action lastAction = actions.get(actions.size() - 1);
            lastAction.execute();
        }
    }
}
