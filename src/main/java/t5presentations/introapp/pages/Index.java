package t5presentations.introapp.pages;

import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import t5presentations.introapp.entities.BoardGame;

/**
 * Start page of application introapp.
 */
public class Index {
    @Property
    private BoardGame game;

    @Inject
    private AlertManager alertManager;

    @Inject
    private Session session;

    @Inject
    private Messages messages;

    @CommitAfter
    void onSuccess() {
        session.save(game);

        alertManager.info(messages.format("game-added", game.getTitle()));
    }
}
