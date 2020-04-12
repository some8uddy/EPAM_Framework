# EPAM_Framework

Java WebDriver test automation framework project

### Run from command line: 

mvn -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\test-all.xml clean test

or

mvn -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\test-smoke.xml clean test

or

mvn -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src\test\resources\test-all.xml clean test

or

mvn -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src\test\resources\test-smoke.xml clean test

or

mvn -Dbrowser=firefox -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\test-all.xml clean test

or

mvn -Dbrowser=firefox -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\test-smoke.xml clean test

or

mvn -Dbrowser=firefox -Denvironment=qa -Dsurefire.suiteXmlFiles=src\test\resources\test-all.xml clean test

or

mvn -Dbrowser=firefox -Denvironment=qa -Dsurefire.suiteXmlFiles=src\test\resources\test-smoke.xml clean test