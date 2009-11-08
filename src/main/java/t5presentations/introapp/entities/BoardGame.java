package t5presentations.introapp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.tapestry5.beaneditor.DataType;
import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.Validate;

@Entity
public class BoardGame
{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @NonVisual
  private long id;

  @Validate("required")
  private String title;

  private String creator;

  private String publisher;

  private Date published;

  private boolean inPrint;

  @Validate("required")
  @Column(nullable = false)
  private Genre genre;

  @Validate("required")
  @Column(nullable = false)
  private Theme theme;

  @Validate("min=1")
  private Integer minPlayers;

  @Validate("min=1")
  private Integer maxPlayers;

  @Validate("min=1,max=5")
  private Integer rating;

  @DataType("longtext")
  private String notes;

  public String getTitle()
  {
    return title;
  }

  public void setTitle(String title)
  {
    this.title = title;
  }

  public String getCreator()
  {
    return creator;
  }

  public void setCreator(String creator)
  {
    this.creator = creator;
  }

  public String getPublisher()
  {
    return publisher;
  }

  public void setPublisher(String publisher)
  {
    this.publisher = publisher;
  }

  public Date getPublished()
  {
    return published;
  }

  public void setPublished(Date published)
  {
    this.published = published;
  }

  public boolean isInPrint()
  {
    return inPrint;
  }

  public void setInPrint(boolean inPrint)
  {
    this.inPrint = inPrint;
  }

  public Genre getGenre()
  {
    return genre;
  }

  public void setGenre(Genre genre)
  {
    this.genre = genre;
  }

  public Theme getTheme()
  {
    return theme;
  }

  public void setTheme(Theme theme)
  {
    this.theme = theme;
  }

  public Integer getMinPlayers()
  {
    return minPlayers;
  }

  public void setMinPlayers(Integer minPlayers)
  {
    this.minPlayers = minPlayers;
  }

  public Integer getMaxPlayers()
  {
    return maxPlayers;
  }

  public void setMaxPlayers(Integer maxPlayers)
  {
    this.maxPlayers = maxPlayers;
  }

  public Integer getRating()
  {
    return rating;
  }

  public void setRating(Integer rating)
  {
    this.rating = rating;
  }

  public String getNotes()
  {
    return notes;
  }

  public void setNotes(String notes)
  {
    this.notes = notes;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

}
