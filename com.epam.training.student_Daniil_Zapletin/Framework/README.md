Options for testing: \n
-Dbrowser : chrome / edge / firefox \n
-Denvironment : dev / qa / user.test \n
suiteXmlFiles : testing-all.xml / testing-smoke.xml \n

for positive test enter in command line: mvn -Dbrowser=chrome -Denvironment=dev -Dsurefire.suiteXmlFiles=src\test\resources\testing-all.xml clean test
for negative test enter in command line: mvn -Dbrowser=chrome -Denvironment=qa -Dsurefire.suiteXmlFiles=src\test\resources\testing-all.xml clean test
