Options for testing:
-Dbrowser : chrome / edge / firefox
-Denvironment : dev / qa / user.test 
suiteXmlFiles : testing-all.xml / testing-smoke.xml 
for positive test enter in command line: mvn -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\testing-all.xml clean test 
for negative test enter in command line: mvn -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src\test\resources\testing-all.xml clean test
