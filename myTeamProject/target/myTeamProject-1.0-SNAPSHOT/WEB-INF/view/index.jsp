<%-- 
    Document   : index
    Created on : Apr 13, 2020, 1:47:07 PM
    Author     : netri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="theme-color" content="#000000">
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/index.css"/>">  
        <script src = "faker.js" type = "text/javascript"></script>
        <script>
        var randomName = faker.name.findName(); // Caitlyn Kerluke
        var randomEmail = faker.internet.email(); // Rusty@arne.info
        var randomCard = faker.helpers.createCard(); // random contact card containing many properties
        </script>        
        <title>Welcome Page</title>
    </head>
    <body>
        <div id="root">
            <div class="ui inverted menu">
                <div class="ui container">
                    <div class="header item">
                        <img src="static/images/logo.png" alt="logo">Re-vents
                    </div>
                    <div class="item">Events                    
                    </div>
                    <div class="item">
                        <button class="ui inverted positive right floated button">Create Event                        
                        </button>
                    </div>
                    <div class="right item">
                        <button class="ui basic inverted button">Login                        
                        </button>
                        <button class="ui basic inverted button" style="margin-left: 0.5em;">Sign Out
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <h1>This is our first page!.../<h1>
                <a href="product/list">Customer-List</a>
                
    </body>
</html>
