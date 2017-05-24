require 'buildr/git_auto_version'
require 'buildr/gpg'
require 'buildr/gwt'

PROVIDED_DEPS = [:javax_annotation, :gwt_user]

desc 'GWT Lognice: Makes log output nicer'
define 'gwt-lognice' do
  project.group = 'org.realityforge.gwt.lognice'
  compile.options.source = '1.7'
  compile.options.target = '1.7'
  compile.options.lint = 'all'

  project.version = ENV['PRODUCT_VERSION'] if ENV['PRODUCT_VERSION']

  pom.add_apache_v2_license
  pom.add_github_project('realityforge/gwt-lognice')
  pom.add_developer('realityforge', 'Peter Donald')
  pom.provided_dependencies.concat PROVIDED_DEPS

  compile.with PROVIDED_DEPS

  gwt(['org.realityforge.gwt.lognice.Lognice'],
                :java_args => ['-Xms512M', '-Xmx1024M', '-XX:PermSize=128M', '-XX:MaxPermSize=256M'],
                :draft_compile => (ENV['FAST_GWT'] == 'true'),
                :dependencies => [:javax_validation, :javax_validation_sources] + project.compile.dependencies)

  test.using :testng

  package(:jar).include("#{_(:source, :main, :java)}/*")
  package(:sources)
  package(:javadoc)

  iml.add_jruby_facet
  iml.add_gwt_facet({'org.realityforge.gwt.lognice.Lognice' => true},
                    :settings => {:compilerMaxHeapSize => '1024'},
                    :gwt_dev_artifact => :gwt_dev)
end
