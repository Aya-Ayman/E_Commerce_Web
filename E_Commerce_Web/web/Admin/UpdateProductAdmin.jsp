<%-- 
    Document   : UpdateProductAdmin
    Created on : Feb 9, 2018, 8:26:51 PM
    Author     : abdalla
--%>
<script src ="js/UpdateProductAdmin.js" ></script>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
        <link rel="stylesheet" href="css/annie.css">
    </head>
    <body>
        <div class="annie-main">
            <div id="conanier">
                <h3>Update  Product</h3> 
                <form action="ProductControllerServlet"  method="POST"  enctype="multipart/form-data">

                    <input type="hidden" name="command" value="UPDATE" />
                    <input type="hidden" name="productId" value="${theProduct.id}" />
                    <table>
                        <tbody>
                            <tr>
                                <td><label>Name :</label></td>
                                <td><input id="nameProductUp" type="text" name="productName" 
                                           value="${theProduct.name}" onchange="getErrorMsg('errorNameUp', 'string', 'Enter valid name')">
                                    <span id="errorNameUp" style="color: red" ></span>

                                </td>   
                            </tr>

                            <tr>
                                <td><label>Quantity :</label></td>
                                <td><input id="quantityProductUp" type="text" name="quantity" 
                                           value="${theProduct.quantity}" onchange="getErrorMsg('errorQuantityUp', 'int', 'Enter valid quantity')">
                                    <span id="errorQuantityUp" style="color: red" ></span>
                                </td>   
                            </tr>

                            <tr>
                                <td><label>Price :</label></td>
                                <td><input id="priceProductUp" type="text" name="price" 
                                           value="${theProduct.price}" onchange="getErrorMsg('errorPriceUp', 'float', 'Enter valid price')">
                                    <span id="errorPriceUp" style="color: red" ></span>
                                </td>   
                            </tr>

                            <tr>
                                <td><label>Category :</label></td>


                                <td>
                            
                                    <span><input readonly id="currentCategory" name = "category" value="${theProduct.category}"></span>
                          <select id="categoryProductUp" name="categoryList" onchange="changeCategory()">
                           
                              <option value="choose the category">choose the category</option>  
                            <option value="bag">bag</option>
                            <option value="man">man</option>
                            <option value="women">women</option>
                           
                            </select>
                            <span id="errorCategoryUp" style="color: red"></span>
                            </td>

                            </tr>
                            
                            <tr>
                                <td><label>Description :</label></td>
                                <td><input id="descProduct" name="desc" type="text" value ="${theProduct.description}",name="desc" >
                                    <span id="errordesc" style="color: red"></span></td>   
                            </tr>
                            <tr>
                        <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${theProduct.id}"  onerror="this.src='images/default_product.png'"width="128" height="128" ></div><br/>
                        <input type="file" name="imageProduct" size="50"/>
                        </tr>
                        <tr>
                            <td><label></label></td>
                            <td><input type="submit" name="Save" onclick="return valid();" /></td>   
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
