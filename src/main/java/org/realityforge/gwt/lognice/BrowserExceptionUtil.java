package org.realityforge.gwt.lognice;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.UmbrellaException;
import javax.annotation.Nonnull;

public final class BrowserExceptionUtil
{
  private BrowserExceptionUtil()
  {
  }

  public static void log( @Nonnull final Throwable t )
  {
    if ( GWT.isScript() && GWT.isProdMode() )
    {
      log( t, false );
    }
  }

  private static void log( @Nonnull final Throwable t, final boolean isCause )
  {
    final String msg = ( isCause ? "caused by: " : "" ) + t;
    _groupStart( msg );
    _log( t );
    if ( t instanceof UmbrellaException )
    {
      final UmbrellaException umbrella = (UmbrellaException) t;
      for ( final Throwable cause : umbrella.getCauses() )
      {
        log( cause, true );
      }
    }
    else if ( null != t.getCause() )
    {
      log( t.getCause(), true );
    }
    _groupEnd();
  }

  private static native void _groupStart( @Nonnull final String message ) /*-{
    var groupStart = console.groupCollapsed || console.group || console.error || console.log;
    groupStart.call( console, message );
  }-*/;

  private static native void _groupEnd() /*-{
    var groupEnd = console.groupEnd || function() {
      };
    groupEnd.call( console );
  }-*/;

  private static native void _log( @Nonnull final Throwable throwable ) /*-{
    var logError = console.error || console.log;
    var backingError = throwable.__gwt$backingJsError;
    logError.call( console, backingError && backingError.stack );
  }-*/;
}
