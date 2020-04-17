<%-- 
    Document   : product-form
    Created on : Apr 16, 2020, 11:16:09 PM
    Author     : netri
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Save Product</title>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="theme-color" content="#000000">
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/index.css"/>">  
        <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>"> 
        <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style_1.css" />">
        <link type="text/css" rel="stylesheet" href="${pageContent.request.contextPath}/static/css/style_1.css">
        <link type="text/css" rel="stylesheet" href="${pageContent.request.contextPath}/static/css/add-customer-style.css">

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
        <div id="wrapper">
            <div id="header">
                <h2>PRM - Product Relationship Manager</h2>
            </div>
        </div>
        
        <div id="container">
            <h3>Save Customer</h3>
            <form class="ui form"><form:form action="saveProduct" modelAttribute="product" method="POST">
                
                <!--need to associate this data with product id-->
                <form:hidden path="productId" />
                <table>
                    <tbody>
                        <tr>
                            <td><label>Product Name: </label></td>
                            <td><form:input path="productName" placeholder="Product_Name"/></td>
                        </tr>
                        <tr>
                            <td><label>Description: </label></td>
                            <td><form:textarea path="description" /></td>
                        </tr>
                        <tr>
                            <td><label>Quantity: </label></td>
                            <td><form:input path="quantityInStock"/></td>
                        </tr>
                        <tr>
                            <td><label>Price: </label></td>
                            <td><form:input path="price"/></td>
                        </tr>
                        <tr>
                            <td><label></label></td>
                            <td><input type="submit" value="Save" class="save"/></td>
                        </tr>
                    </tbody>
                    
                </table>
                
                </form:form></form>
            <div style="clear; both;"></div>
            <p>
                <a href="${pageContext.request.contextPath}/product/list">Back to List</a>
            </p>            
        </div>                        
    </body>
</html>

