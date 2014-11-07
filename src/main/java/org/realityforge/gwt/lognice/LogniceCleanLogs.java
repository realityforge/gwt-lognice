package org.realityforge.gwt.lognice;

import com.google.gwt.core.client.EntryPoint;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogniceCleanLogs
  implements EntryPoint
{
  public void onModuleLoad()
  {
    final Logger logger = Logger.getLogger( "" );
    //In GWT 2.7 it is necessary to remove the old handlers
    for ( final Handler h : logger.getHandlers() )
    {
      logger.removeHandler( h );
    }
    final SimpleLogger handler = new SimpleLogger();
    handler.setLevel( Level.ALL );
    logger.addHandler( handler );
  }
}
