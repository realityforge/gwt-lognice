package org.realityforge.gwt.lognice;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
* Created by peter on 18/11/14.
*/
final class SimpleFormatter
  extends Formatter
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
}
