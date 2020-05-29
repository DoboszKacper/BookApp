<%--
  Created by IntelliJ IDEA.
  User: kacpe
  Date: 19.05.2020
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>The Book App</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <link rel="stylesheet" type="text/css" media="screen" href="style.css" />
</head>
<body>
<div id="container">
    <div id="header">
        <h1>THE BOOK APP</h1>
    </div>
    <div id="sideheader"></div>
    <div id="left_column">
        <div class="left_column_boxes">
            <h4>Menu</h4>
            <div id="navcontainer">
                <ul id="navlist">
                    <li id="active"><a href="index.jsp" id="current">Home</a></li>
                    <li><a href="search.jsp">Search</a></li>
                    <li><a href="http://localhost:8080/BookApp/random">Randomize</a></li>
                    <li><a href="http://localhost:8080/BookApp/allbooks">All Books</a></li>
                    <li><a href="guide.jsp">Guide</a></li>
                </ul>
            </div>
        </div>
        <p class="center">Created by <b>Kacper Dobosz</b></p>
    </div>
    <div id="content">

        <h3>Search Section</h3>
        <p>These are search mechanics, if you want to look up for a specific book, you can just type the book name that you are looking for and then press search button.<p/>
        <h3>Randomize Section</h3>
        <p>This section is only for fun purpose. Using button randomize you can see a random book from my gallery.<p/>
        <h3>All Books Section</h3>
        <p>This is gallery of all my books displayed in alphabetical order.<p/>
        <div id="empty"></div>
    </div>
    <div id="footer"></div>
</div>
<div align=center>I used this template from this site: <a href='http://all-free-download.com/free-website-templates/'>Site with cool templates :D</a></div></body>
</html>