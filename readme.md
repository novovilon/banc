#Test Framework in java

- Selenium 4.0.0-alpha-5
- Testng 7.1.0
- Log4j-core 2.11.1
- Allure-testng 2.13.3

##building a project using __maven__

For allure, add a new file to the  `resources` folder `allure.properties`

```
allure.results.directory=target/allure-results
allure.link.issue.pattern=https://exemple.org/browse/{}
allure.link.tms.pattern=https://exemple.org/browse/{}
```
For Log4j, add a new file to the `resources` folder `log4j2.xml`

```
<?xml version="1.0" encoding="UTF-8" ?>
<Configuration>
    <Appenders>
        <Console name="Console">
           <PatternLayout >
               <Pattern>%d %p %c{2} [%t] %l %m%n</Pattern>
           </PatternLayout>
        </Console>
        <File name="File" fileName="target/logs/ANDTM-automation.log">
            <PatternLayout>
                <Pattern>%d %p [%t] %m%n</Pattern>
            </PatternLayout>
        </File>
    </Appenders>
    <Loggers>
        <Root level="info">

            <AppenderRef ref="File"/>
        </Root>
    </Loggers>
</Configuration>
```



