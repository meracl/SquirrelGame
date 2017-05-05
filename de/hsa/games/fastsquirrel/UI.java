package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.console.Command;
import de.hsa.games.fastsquirrel.core.BoardView;

public interface UI {
    Command getCommand();

    void render(BoardView view);
}
