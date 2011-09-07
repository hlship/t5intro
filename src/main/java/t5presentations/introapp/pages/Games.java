package t5presentations.introapp.pages;

import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import t5presentations.introapp.entities.BoardGame;

import java.util.List;

public class Games {
    @Inject
    private Session session;

    @Property
    private BoardGame game;


    @Inject
    private Block gameDetailContent;

    public List getGames() {
        return session.createCriteria(BoardGame.class).list();
    }

    Object onActionFromSelectGame(BoardGame selectedGame) {
        game = selectedGame;

        return gameDetailContent;
    }

}
