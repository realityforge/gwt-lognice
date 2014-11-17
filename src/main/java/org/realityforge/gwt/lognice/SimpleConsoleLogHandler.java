package org.realityforge.gwt.lognice;

import com.google.gwt.logging.client.ConsoleLogHandler;

public final class SimpleConsoleLogHandler
  extends ConsoleLogHandler
{
  public SimpleConsoleLogHandler()
  {
    setFormatter( new SimpleFormatter() );
  }
}
