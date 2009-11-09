package t5presentations.introapp.pages;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
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
  
  void onSuccess()
  {
    session.save(game);
    
    message = "Added board game: " + game.getTitle();
  }
}
