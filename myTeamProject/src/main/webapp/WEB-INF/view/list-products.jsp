<%-- 
    Document   : list-products
    Created on : Apr 16, 2020, 9:29:48 PM
    Author     : netri
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Products</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="theme-color" content="#000000">
        <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/semantic-ui@2.4.2/dist/semantic.min.css">
        <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/index.css"/>">  
        <link rel="stylesheet" href="<c:url value="/static/css/style.css"/>"> 
        <link type="text/css" rel="stylesheet" href="<c:url value="/static/css/style_1.css" />">
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
            <div id="content">
                
                <!--put new button: Add Customer-->
                <input type="button" value="Add Product"
                       onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button"/>
                
                <!--add out html table here-->
                <table>
                    <tr>
                        <th>Product Name</th>
                        <th>Description</th>
                        <th>Quantity In Stock</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                    <!--loop over and print our products-->
                    <c:forEach var="tempProduct" items="${products}">
                    
                        <!--construct an "update" link with customer id-->
                        <c:url var="updateLink" value="/product/showFormForUpdate">
                            <c:param name="productId" value="${tempProduct.productId}"/>
                        </c:url>
                        
                        <!--construct a "delete" link with customer id-->
                        <c:url var="deleteLink" value="/product/delete">
                            <c:param name="productId" value="${tempProduct.productId}"/>
                        </c:url>
                   
                    
                        <tr>
                            <td>${tempProduct.productName}</td>
                            <td>${tempProduct.description}</td>
                            <td>${tempProduct.quantityInStock}</td>         
                            <td>${tempProduct.price}</td>  
                            
                            <td>
                                <!--display the update link-->
                                <a href="${updateLink}">Update</a>
                                |
                                <!--display the delete link-->
                                <a href="${deleteLink}"
                                   onclick="if(!(confirm('Are you sure you want to delete this product?'))) return false">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </body>
</html>

