<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC - Index</title>
</head>
<body>
    Welcome to Spring MVC

    <form action = "addAlien">
        Enter your ID : <input type = "text" name = "aid"><br>
        Enter your name : <input type = "text" name = "aname"><br>
        <input type = "submit">
    </form>
    <hr>
    <form action = "getAlien">
        Enter your ID : <input type = "text" name = "aid"><br>
        <input type = "submit">
    </form>
    <hr>

    <form action = "removeAlien">
        Enter ID to remove : <input type = "text" name = "aid"><br>
        <input type = "submit">
    </form>
    <hr>
    <form action = "getAlienByAname">
            Enter Aname : <input type = "text" name = "aname"><br>
            <input type = "submit">
        </form>

</body>
</html>
