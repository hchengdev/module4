<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Currency Converter</title>
</head>
<body>
<h2>Currency Converter</h2>
<form method="post">

    <label for="usdAmount">Amount in USD:</label><br>
    <input type="text" id="usdAmount" name="usdAmount" required><br><br>

    <c:if test="${vndAmount != null}" >
        <div class="error-message">${vndAmount}</div>
    </c:if>

    <input type="submit" value="Convert">
</form>
</body>
</html>
