package org.realityforge.gwt.lognice;

import com.google.gwt.logging.client.DevelopmentModeLogHandler;

public class SimpleDevModeLogHandler
  extends DevelopmentModeLogHandler
{
  public SimpleDevModeLogHandler()
  {
    setFormatter( new SimpleFormatter() );
  }
}
