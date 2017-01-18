package org.realityforge.gwt.lognice;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.logging.client.ConsoleLogHandler;
import com.google.gwt.logging.client.DevelopmentModeLogHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogniceCleanLogs
  implements EntryPoint
{
  public void onModuleLoad()
  {
    final Logger logger = Logger.getLogger( "" );
    boolean addConsoleLogHandler = false;
    boolean addDevModeLogHandler = false;
    for ( final Handler h : logger.getHandlers() )
    {
      logger.removeHandler( h );
      if ( h instanceof ConsoleLogHandler ||
           h.getClass().getName().equals( "java.util.logging.SimpleConsoleLogHandler" ) )
      {
        addConsoleLogHandler = true;
      }
      if ( h instanceof DevelopmentModeLogHandler )
      {
        addDevModeLogHandler = true;
      }
    }
    if ( addConsoleLogHandler )
    {
      final SimpleConsoleLogHandler handler = new SimpleConsoleLogHandler();
      handler.setLevel( Level.ALL );
      logger.addHandler( handler );
    }
    if ( addDevModeLogHandler )
    {
      final SimpleDevModeLogHandler handler = new SimpleDevModeLogHandler();
      handler.setLevel( Level.ALL );
      logger.addHandler( handler );
    }
  }
}
