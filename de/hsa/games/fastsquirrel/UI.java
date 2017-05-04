package de.hsa.games.fastsquirrel;

import de.hsa.games.fastsquirrel.core.BoardView;

public interface UI {
    MoveCommand getCommand();

    void render(BoardView view);
}
