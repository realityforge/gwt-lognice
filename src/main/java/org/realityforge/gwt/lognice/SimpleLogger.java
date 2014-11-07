package org.realityforge.gwt.lognice;

import com.google.gwt.logging.client.ConsoleLogHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public final class SimpleLogger
  extends ConsoleLogHandler
{
  public SimpleLogger()
  {
    setFormatter( new Formatter()
    {
      @Override
      public String format( final LogRecord record )
      {
        final Throwable throwable = record.getThrown();
        if ( null != throwable )
        {
          return record.getMessage() + ": " + ExceptionUtil.getStackTrace( throwable );
        }
        else
        {
          return record.getMessage();
        }
      }
    } );
  }
}
