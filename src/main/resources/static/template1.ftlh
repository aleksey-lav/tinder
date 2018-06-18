<html>
<head>
    <title>Welcome page</title>
    <style>
        input{
            width: 60px;
            text-align: center;
            background: #008884;
            color: #fff;
            box-shadow: 1px 1.7px 4.8px 2.2px rgba(0, 0, 0, 0.08);
            float: left;
            display: block;
            border-radius: 10px;
            height: 30px;
            display: block;
            position: relative;
            border: 1px solid #b1bbba;
            margin: 0 auto;
            margin: 10px;
        }
    </style>
</head>
<body>
<h3>Welcome, ${user}!</h3>
<h2>${name}</h2>
<img src="${link}">
<form action = "users" method="post">
    <#--<input type="submit" name="direction" value="back">-->
    <input type="submit" name="answer" value="yes">
    <input type="submit" name="answer" value="no">
   <#-- <input type="submit" name="direction" value="next">-->
</form>

</body>
</html>