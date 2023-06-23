# adrien

Two modules in this project, including adrien-sdk, adrien-mocker.

## adrien-sdk

A java development kit.
> ### How to use
> - Command `git clone https://github.com/Ezio2000/adrien.git` to install.
> - Command `mvn clean install -Dmaven.test.skip=true` to add adrien-sdk into local maven repository.
> - Import dependency in pom.xml.
> ### Expansion
> - If you want to use script runner on your code, add `adrien.sdk=enable` and `adrien.script=enable`
    in [application.yml](./adrien-mocker/src/main/resources/application.yml).
> - For more expansion, you can write a class implements script runner interface, then
    add [services](./adrien-sdk/src/main/resources/META-INF/services/org.adrien.sdk.runner.pojo.runner.scriptrunner.ScriptRunner)
    file under [META-INF](./adrien-sdk/src/main/resources/META-INF),
    write your class in the file.
> ### Version
> - 1.0.0 ***up-to-date!***

## adrien-mocker

A service for testers mocking response.
> ### How to use
> - Fill your project and mysql information in [application.yml](./adrien-mocker/src/main/resources/application.yml).
> - Run [DDL](./adrien-mocker/src/main/resources/DDL.sql) in your mysql.
> - Run AdrienMockerApplication.java.
