<%-- 
    Document   : AddNewProductAdmin
    Created on : Feb 9, 2018, 8:26:51 PM
    Author     : abdalla
--%>
<script src ="js/AddNewProductAdmin.js" ></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
        <link rel="stylesheet" href="css/adminPage.css">
        <link rel="stylesheet" href="css/annie.css">
    </head>
    <body>
        <div class="annie-main">
            <div id="conanier">
                <h3>Add  Product</h3> 
                <form action="ProductControllerServlet" method="POST" name="form" enctype="multipart/form-data"> 

                    <input type="hidden" name="command" value="ADD" />
                    <table>
                        <tbody>
                            <tr>
                                <td><label>Name :</label></td>
                                <td><input id="nameProduct" type="text" name="Name" onchange="getErrorMsg('errorName', 'string', 'Enter valid name')">
                                    <span id="errorName" style="color: red" ></span>
                                </td>   
                            </tr>
                            <tr>
                                <td><label>Quantity :</label></td>
                                <td><input id="quantityProduct" type="text" name="Quantity" onchange="getErrorMsg('errorQuantity', 'int', 'Enter valid quantity')">
                                    <span id="errorQuantity" style="color: red"></span></td>   
                            </tr>

                            <tr>
                                <td><label>Price :</label></td>
                                <td><input id="priceProduct" type="text" name="Price" onchange="getErrorMsg('errorPrice', 'float', 'Enter valid price')">
                                    <span id="errorPrice" style="color: red"></span></td>   
                            </tr>

                            <tr>
                                <td><label>Category :</label></td>
                                <td>

                                    <select id="categoryProduct" name="Category" onblur="getErrorMsg('errorCategory', 'category', 'choose the category')">
                                        <option value="choose" >Choose the category</option>
                                        <option value="man">man</option>
                                        <option value="women">women</option>
                                        <option value="bag">bag</option>
                                    </select>
                                    <span id="errorCategory" style="color: red"></span>
                                </td>  

                            </tr>
                            
                                <tr>
                                <td><label>Description :</label></td>
                                <td><input id="descProduct" type="text" name="desc" >
                                    <span id="errordesc" style="color: red"></span></td>   
                            </tr>
                            <tr>
                        <input type="file" name="imageUploading" size="50"/>
                        </tr>
                        <tr>
                            <td><label></label></td>
                            <td><input onclick="return valid();"  type="submit" name="Save"  /></td>   
                        </tr>



                        </tbody>
                    </table>

                </form>


                <div style="clear: both ;"></div>
                <p>
                    <a href="AdminServlet">Back to Home</a>
                </p>
            </div>
        </div>
    </body>
</html>
