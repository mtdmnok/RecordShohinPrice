//参考サイト通りに記述しているが、エラーになってしまいます。

//<!DOCTYPE html>
//<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
//    <head>
//        <meta charset="UTF-8">
//        <title>Hello,SpringSecurity!</title>
//    </head>
//    <body>
//        <h2>Hello!</h2>
//        <h1 th:inline="text">Hello[[${#httpServletRequest.remoteUser}]]!</h1>
//        <form th:action="@{/logout}" method="post">
//            <input type="submit" value="ログアウト" />
//        </form>
//        <p></p>
//    </body>
//</html>