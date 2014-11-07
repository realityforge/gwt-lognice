package org.realityforge.gwt.lognice;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class ExceptionUtilTest
{
  @Test
  public void getStackTrace()
  {
    final String stackTrace =
      ExceptionUtil.getStackTrace( new Throwable( "X", new IllegalStateException() ) );
    assertContains( stackTrace, "java.lang.Throwable: X\n" );
    assertContains( stackTrace,
                    "\tat org.realityforge.gwt.lognice.ExceptionUtilTest.getStackTrace(ExceptionUtilTest.java:" );
    assertContains( stackTrace, "Caused by: java.lang.IllegalStateException\n" );
  }

  private void assertContains( final String stackTrace, final String text )
  {
    assertTrue( stackTrace.contains( text ), "Contains text: " + text + " on \n" + stackTrace );
  }
}
