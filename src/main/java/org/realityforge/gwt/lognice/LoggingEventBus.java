package org.realityforge.gwt.lognice;

import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import com.google.web.bindery.event.shared.Event;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingEventBus
  extends SimpleEventBus
{
  private static final Logger LOG = Logger.getLogger( LoggingEventBus.class.getName() );
  private static final Level LEVEL = Level.WARNING;

  @Override
  public void fireEvent( final Event<?> event )
  {
    if ( LOG.isLoggable( LEVEL ) )
    {
      LOG.log( LEVEL, "Event: " + debugOutput( event ) );
    }
    super.fireEvent( event );
  }

  @Override
  public void fireEventFromSource( final Event<?> event, final Object source )
  {
    if ( LOG.isLoggable( LEVEL ) )
    {
      LOG.log( LEVEL, "Event: " + debugOutput( event ) );
    }
    super.fireEventFromSource( event, source );
  }

  private String debugOutput( final Event<?> event )
  {
    if ( event instanceof PlaceChangeRequestEvent )
    {
      return "PlaceChangeRequestEvent[Place=" + ( (PlaceChangeRequestEvent) event ).getNewPlace() + "]";
    }
    else if ( event instanceof PlaceChangeEvent )
    {
      return "PlaceChangeEvent[Place=" + ( (PlaceChangeEvent) event ).getNewPlace() + "]";
    }
    else
    {
      return event.toDebugString();
    }
  }
}
