package t5presentations.introapp.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import t5presentations.introapp.entities.BoardGame;

import java.util.List;

public class Games {
    @Inject
    private Session session;

    @Property
    private BoardGame game, selectedGame;

    @InjectComponent
    private Zone gameDetail;

    @SuppressWarnings("rawtypes")
    public List getGames() {
        return session.createCriteria(BoardGame.class).list();
    }

    Object onActionFromSelectGame(BoardGame game) {
        selectedGame = game;

        return gameDetail.getBody();
    }
}
