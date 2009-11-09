package t5presentations.introapp.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import t5presentations.introapp.entities.BoardGame;

/**
 * Start page of application introapp.
 */
public class Index
{
  @Property
  private BoardGame game;

  @Property
  @Persist(PersistenceConstants.FLASH)
  private String message;

  @Inject
  private Session session;

  @Inject
  private Messages messages;

  @CommitAfter
  void onSuccess()
  {
    session.save(game);

    message = messages.format("game-added", game.getTitle());
  }
}
