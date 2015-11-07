<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <c:url value="/api/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <input type="hidden" name="_spring_security_remember_me" value="true">
        <p>
            <label for="email">E-mail:</label>
            <input type="text" id="email" name="j_username">
        </p>
        <p>
            <label for="password">Password:</label>
            <input type="password" id="password" name="j_password">
        </p>
        <p>
            <input type="submit" value="Login">
        </p>
    </form>
</body>
</html>