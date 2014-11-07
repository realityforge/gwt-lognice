package org.realityforge.gwt.lognice;

public final class ExceptionUtil
{
  private ExceptionUtil()
  {
  }

  public static String getStackTrace( final Throwable throwable )
  {
    final StringBuilder result = new StringBuilder();
    result.append( throwable.toString() );
    result.append( '\n' );

    for ( final StackTraceElement element : throwable.getStackTrace() )
    {
      result.append( "\tat " );
      result.append( element );
      result.append( '\n' );
    }

    final Throwable cause = throwable.getCause();
    if ( cause != null && cause != throwable )
    {
      result.append( "Caused by: " );
      result.append( getStackTrace( cause ) );
    }

    return result.toString();
  }
}
