# Egy API a kréta rendszerhez java nyelven
#### Még nagyon messze van a tökéletestől
## Használat
##### Még csak ennyi.....
```java
        School school = KretaTools.APITools.getSchool(InstituteId);

        KretaUser user = new KretaUser(USERNAME,PASSWORD,school);
        
        user.refreshTokens();
        
        UserData userData = user.getUserData();
        Test[] tests = user.getTests();
        Lesson[] lessons = user.getLessons(new Date(from),new Date(to));
```
## Remélem azt majd nem nekem kell megírnom....:D
### Köszi: https://github.com/boapps/e-kreta-api-docs sokat segített :D
#### Még a git/github-al még csak ismerkedem...
##### ha github fiókomon valami FUCK LOGIC akkor elnézést...
