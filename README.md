gwt-lognice
===========

[![Build Status](https://secure.travis-ci.org/realityforge/gwt-lognice.png?branch=master)](http://travis-ci.org/realityforge/gwt-lognice)

A super simple gwt library that makes the log messages nicer. The
library removes all the log prefix when emitting messages. It also
provides a replacement for the EventBus that logs the events as they
are fired.

Quick Start
===========

The simplest way to use the library is to add the following dependency
into the build system. i.e.

```xml
<dependency>
   <groupId>org.realityforge.gwt.lognice</groupId>
   <artifactId>gwt-lognice</artifactId>
   <version>0.1</version>
   <scope>provided</scope>
</dependency>
```

Then you add the following snippet into the .gwt.xml file.

```xml
<module rename-to='myapp'>
  ...

  <!-- Enable the lognice library -->
  <inherits name="org.realityforge.gwt.lognice.Lognice"/>
</module>
```

This should be sufficient to put together a simple application with nicer logging.
