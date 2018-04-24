<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<script src ="js/Admin.js" ></script>
<!DOCTYPE html>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/annie.css">
        <link rel="stylesheet" href="css/adminPage.css">
    </head>
    <body>
        <div class="annie-main">
            <h2>Admin Page</h2> 
            <span><a style="position: fixed ; right: 20px; top: 15px;" href="Logout"<i class="fa fa-envelope-o" aria-hidden="true"></i>Sign Out</a></span> 
            <br/><br/>
            <p>Add Promo Code:</p>
            <form class="example" action="PromoCodeServlet" method="post">
                <input type="number"  placeholder="enter cedit limit" name="credit" required="10000">
                <input type="text" autocomplete="off" placeholder="enter promo code"
                       name="promoAdmin" pattern=".{6,6}" required title="6 to 6 characters" ></br></br>

                <input type="submit" value="add" name="AddPromo"  />
            </form>
            <br/><br/>
            <!--            <p>edit Promo Code:</p>
                        <form class="example" action="AdminServlet" method="post">
                            <input type="number" autocomplete="off" placeholder="enter cedit limit" name="credit">
                            <input type="text" autocomplete="off" placeholder="enter promo code" name="promoAdmin"></br></br>
                            <input type="submit"  value="Edit" name="Edit" />
                        </form>-->

            <br/><br/>
            <p>user table:</p>
            <!--            <form class="example" action="AdminServlet" method="post">
                             
                            <input type="text" autocomplete="off" placeholder="Search user by email" name="searchbyName" id="UserInput"  onkeyup="userSearchFunction()">
                        </form>-->
            <form class="example" action="AdminServlet" method="post">
                <input type="text" autocomplete="off" placeholder="Search user by email" name="searchbyName" id="UserInput"  onkeyup="userSearchFunction()">
            </form>
            <br/>
            <table id="t01">
                <tr>
                    <th>Email</th>
                    <!--  <th>image</th> -->
                    <th>Name</th> 
                    <th>Birth Date</th>
                    <th>job</th>
                    <th>credit </th> 
                    <th>address</th>
                    <th>images</th>


                </tr> 
                <c:forEach items="${searchOutputUser}" var="ailment">
                    <tr >  
                        <td>${ailment.email}</td>
                        <td>${ailment.first_name}  </td>
                        <!--<td>${ailment.image} -->
                        <td>${ailment.date} </td>   
                        <td>${ailment.job} </td>
                        <td>${ailment.credit_limit}</td>     
                        <td>${ailment.address}</td>
                        <td>  <img src="${pageContext.servletContext.contextPath }/ProfilePhotoServlet?email=${ailment.email}" onerror="this.src='images/profile.png'" alt="" class="pro-image-front" width="80" height="80">
                        </td>


                    </tr>
                </c:forEach>
            </table>
            </br>
            <p>product table :</p>
            <form class="example" action="/action_page.php">
                <input type="text" autocomplete="off" placeholder="Search by name" name="search" id="ProductInput" onkeyup="ProductSearchFunction()">
            </form>

            <input type="button" value="Add Product" 
                   onclick="window.location.href = '/Final_Project_Web/RedirectAdd';
                           return false;"
                   class="add-student-button">

            <table id="t02">
                <tr>
                    <th>Name</th>
                    <th>Quantity</th>
                    <th>Price</th> 
                    <th>description</th> 
                    <th>Image</th>
                    <th>Action</th> 
                </tr>

                <c:forEach items="${searchOutputProduct}" var="ailment">

                    <c:url var="productLink" value="ProductControllerServlet">
                        <c:param name="command" value="LOAD" />
                        <c:param name="productName" value="${ailment.name}" />
                    </c:url>

                    <c:url var="deleteLink" value="ProductControllerServlet">
                        <c:param name="command" value="DELETE" />
                        <c:param name="productName" value="${ailment.name}" />
                    </c:url>
                    <tr >   
                        <td>${ailment.name}</td>
                        <td>${ailment.quantity}</td>
                        <td>${ailment.price}</td>  
                        <td>${ailment.description}</td>  

                        <td>                                          
                            <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${ailment.id}" alt="" class="pro-image-front" onerror="this.src='images/default_product.png'" width="80" height="80">
                        </td> 

                        <td> <a href="${productLink}">Update</a>
                            |
                            <a href="${deleteLink}" 
                               onclick="if (!(confirm('Are you sure you want to delete this item ?')))
                                           return false">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
