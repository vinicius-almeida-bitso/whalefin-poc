# Whalefin API Test - POC

A POC to check authentication and responses form Whalefin's APIs on test environment.

# Requirements

``java 17`` ``gradle 7.4``

# Getting Start

```bash
gradle build

java -jar gradle/wrapper/gradle-wrapper.jar
```

After the application started go to: <http://localhost:8080/swagger-ui/>.

# Whalefin Authentication

For test requests its necessary to register to <https://pro-alpha.whalefin.com/>
and create credentials: ``access-key`` ``access-secret``. 
(See API Management options on the profile page).

The class ``WhalefinPoCDefaultClient`` exemplify a way to create a signature: 

```java
new HmacUtils("HmacSHA256", accessSecret).hmacHex(signStr);
```

> dependency: commons-codec

# Whalefin API Reference

Check it out: <https://pro.whalefin.com/apidoc>.