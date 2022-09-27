# Buds Security Properties

Buds Security start with default value loaded, but it can be overridden inserting them  in dependent package application.yml or properties

```yaml
buds:
  realm: my-realm
  jwt:
    secret: Rn75JRy@spVfZIloZZlqv267@tPvS4Gq
    issuer: buds-security
    jwtRefreshHourDuration: 8760 # 1 year
    jwtBearerHourDuration: 1
```