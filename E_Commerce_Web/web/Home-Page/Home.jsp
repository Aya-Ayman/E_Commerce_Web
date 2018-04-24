<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Elite Shoppy an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Home :: w3layouts</title>
        <!--/tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template,
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--//tags -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
        <link href="css/font-awesome.css" rel="stylesheet">
        <link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
        <!-- //for bootstrap working -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
        <script src="js/validation.js"></script>
    </head>
    <body>
        <!-- header -->
        <div class="header" id="home">
            <div class="container">
                <ul>
                    <li> <a style="${visitorStyle}" href="#" data-toggle="modal" data-target="#myModal"><i class="fa fa-unlock-alt" aria-hidden="true"></i>Sign In </a></li>
                    <li> <a style="${visitorStyle}" href="#" data-toggle="modal" data-target="#myModal2"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Sign Up </a></li>
                    <li><a style="${userStyle}" href="RedirectProfile"><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Profile </a></li>
                    <li><a style="${userStyle}" href="Logout"><i class="fa fa-envelope-o" aria-hidden="true"></i>Sign Out</a></li>
                </ul>
            </div>
        </div>
        <!-- //header -->
        <!-- header-bot -->
        <div class="header-bot">
            <div class="header-bot_inner_wthreeinfo_header_mid">
                <div class="col-md-4 header-middle">
                    <form action="SearchProductServlet" method="post">
                        <b> Price</b></br>
                        <table>
                            <tr>
                                <td>From</td>
                                <td>To</td>
                            </tr>
                            <tr>
                                <td><input type="number" name="from"></td>
                                <td><input type="number" name="to"></td>
                            </tr>
                        </table>
                        <input type="search" name="search"  placeholder="Search here..."  >
                        <input type="submit" value=" ">
                        <div class="clearfix"></div>
                    </form>
                </div>
                <!-- header-bot -->
                <div class="col-md-4 logo_agile">
                    <h1><a href="Start"><span>E</span>lite Shoppy <i class="fa fa-shopping-bag top_logo_agile_bag" aria-hidden="true"></i></a></h1>
                </div>
                <!-- header-bot -->
                <div class="col-md-4 agileits-social top_content">
                    <ul class="social-nav model-3d-0 footer-social w3_agile_social">
                        <li class="share">Our Social Media : </li>
                        <li><a href="https://www.facebook.com/groups/1109789889152360/" class="facebook">
                                <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                                <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
                        <li><a href="https://www.facebook.com/groups/1109789889152360/" class="twitter">
                                <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                                <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
                        <li><a href="https://www.facebook.com/groups/1109789889152360/" class="instagram">
                                <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                                <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
                        <!--                        <li><a href="https://www.facebook.com/groups/1109789889152360/" class="pinterest">
                                                        <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                                                        <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>-->
                    </ul>



                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //header-bot -->
        <!-- banner -->
        <div class="ban-top">
            <div class="container">
                <div class="top_nav_left">
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <!-- Brand and toggle get grouped for better mobile display -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                            </div>
                            <!-- Collect the nav links, forms, and other content for toggling -->
                            <div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
                                <ul class="nav navbar-nav menu__list">
                                    <li class="active menu__item menu__item--current"><a class="menu__link" href="Start">Home <span class="sr-only">(current)</span></a></li>
                                    <li class=" menu__item"><a class="menu__link" href="RedirectAbout">About</a></li>
                                    <li class=" menu__item"><a class="menu__link" href="contact.jsp">Contact</a></li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                </div>
                <div class="top_nav_right">
                    <div class="wthreecartaits wthreecartaits2 cart cart box_1">
                        <form action="#" method="post" class="last">
                            <input type="hidden" name="cmd" value="_cart">
                            <input type="hidden" name="display" value="1">
                            <button class="w3view-cart" type="submit" name="submit" value=""><i class="fa fa-cart-arrow-down" aria-hidden="true"></i></button>
                        </form>

                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <!-- //banner-top -->
        <!-- Modal1 -->
        <div class="${classAttr}" id="myModal" tabindex="-1" role="dialog" aria-hidden="${aria-hidden}" style="${style}">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" onclick="window.location.href = 'CloseServlet';
                                return false;"  data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body modal-body-sub_agile">
                        <div class="col-md-8 modal_body_left modal_body_left1">
                            <h3 class="agileinfo_sign">Sign In <span>Now</span></h3>
                            <form action="Login" method="post" onsubmit="return validEmail2();">
                                <div class="styled-input agile-styled-input-top">
                                    <div><label id="vvemail" style="color: red" ></label></div><br/>
                                    <input type="text" name="email" id="emailIn"   onchange="validEmail2()">
                                    <label>Email</label>
                                    <span></span>
                                </div>
                                <div class="styled-input">
                                    <br/>
                                    <input type="password" name="password"  > 
                                    <label>Password</label>

                                    <span></span>
                                </div>
                                <input type="submit" value="Sign In">
                                <br/><br/>
                                <label style="color: red" >${unvalid}</label>
                            </form>

                            <div class="clearfix"></div>
                            <p><a href="#" data-toggle="modal" data-target="#myModal2" > Don't have an account?</a></p>

                        </div>
                        <div class="col-md-4 modal_body_right modal_body_right1">
                            <img src="images/log_pic.jpg" alt=" "/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!-- //Modal content-->
            </div>
        </div>
        <!-- //Modal1 -->
        <!-- Modal2 -->
        <div class="modal fade" id="myModal2" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body modal-body-sub_agile">
                        <div class="col-md-8 modal_body_left modal_body_left1">
                            <h3 class="agileinfo_sign">Sign Up <span>Now</span></h3>
                            <form action="Registeration" method="post" onsubmit="return validForm();" enctype="multipart/form-data">
                                <div class="styled-input agile-styled-input-top">

                                    <div><label id="vname" style="color: red"></label></div><br/> 
                                    <input type="text" name="name"  id="name" onChange="validName()">
                                    <label>Name</label>


                                </div>


                                <div class="styled-input">
                                    <div><label id="vemail" style="color: red" ></label></div><br/>

                                    <input type="text" name="email"   id="emailReg" onChange="validEmail()">

                                    <label>Email</label>


                                </div> 


                                <div class="styled-input">
                                    <div><label id="vpass" style="color: red" ></label></div><br/>
                                    <input type="password" name="password" id="password"   > 
                                    <label>Password</label>

                                </div> 
                                <div class="styled-input">
                                    <input type="password" name="Confirm Password" id="confirm password"   onChange="validPassword()"> 
                                    <label>Confirm Password</label>

                                </div> 


                                <div class="styled-input">
                                    <div><label id="vbdate" style="color: red"></label></div><br/>
                                    <input type="text" name="Birth Date"   id="Birth Date" value="" onChange="validDate()" /> 

                                    <label>Birth Date</label>

                                </div>


                                <div class="styled-input">
                                    <input type="text" name="Address"  >

                                    <label>Address</label>
                                    <span></span>
                                </div>


                                <div class="styled-input">
                                    <div><label id="vjob" style="color: red"></label></div><br/>
                                    <input type="text" name="Job"   id="job" value="" onChange="validJob()">
                                    <label>Job</label>
                                    <span></span>
                                </div>




                                <div class="styled-input">
                                    <label>Interests</label>
                                    <br/><br/>
                                    <input type="checkbox" name="interest" value="Casual wear">Casual wear<br>
                                    <input type="checkbox" name="interest" value="Electronics">Electronics<br>
                                    <input type="checkbox" name="interest" value="Shoes">Shoes<br>
                                    <input type="checkbox" name="interest" value="Sports">Sports<br>
                                </div> 

                                <br/>
                                <!--                                <div class="col-md-4 modal_body_right modal_body_right1">-->
                                <input type="file" name="image2" size="50"/>
                                <!--</div>-->
                                <br/>
                                <br/>
                                <br/>
                                <input type="submit" value="Sign Up">


                            </form>
                            
                                                            <div class="styled-input"  style="display:none;"> 
                                    <div><label id="vcredit" style="color: red"></label></div><br/> 
                                    <input type="Text" name="Credit Limit" id="credit"   > 
                                    <label>Credit Limit</label>
                                </div>

                            <div class="clearfix"></div>
                            <p><a href="#">By clicking register, I agree to your terms</a></p>

                        </div>
                        <div class="col-md-4 modal_body_right modal_body_right1">
                            <img src="images/log_pic.jpg" alt=" "/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!-- //Modal content-->
            </div>
        </div>
        <!-- //Modal2 -->

        <!-- banner -->
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1" class=""></li>
                <li data-target="#myCarousel" data-slide-to="2" class=""></li>
                <li data-target="#myCarousel" data-slide-to="3" class=""></li>
                <li data-target="#myCarousel" data-slide-to="4" class=""></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>The Biggest <span>Sale</span></h3>
                            <p>Special for today</p>
                            <a class="hvr-outline-out button2" href="#">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item2">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Summer <span>Collection</span></h3>
                            <p>New Arrivals On Sale</p>
                            <a class="hvr-outline-out button2" href="#">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item3">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>The Biggest <span>Sale</span></h3>
                            <p>Special for today</p>
                            <a class="hvr-outline-out button2" href="#">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item4">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>Summer <span>Collection</span></h3>
                            <p>New Arrivals On Sale</p>
                            <a class="hvr-outline-out button2" href="#">Shop Now </a>
                        </div>
                    </div>
                </div>
                <div class="item item5">
                    <div class="container">
                        <div class="carousel-caption">
                            <h3>The Biggest <span>Sale</span></h3>
                            <p>Special for today</p>
                            <a class="hvr-outline-out button2" href="#">Shop Now </a>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
            <!-- The Modal -->
        </div>

        <!--/grids-->
        <!-- /new_arrivals -->
        <div class="new_arrivals_agile_w3ls_info">
            <div class="container">
                <h3 class="wthree_text_info">New <span>Arrivals</span></h3>
                <div id="horizontalTab">
                    <ul class="resp-tabs-list">
                        <li> All</li>
                        <li> Men</li>
                        <li> Women</li>
                        <li> Bags</li>
                    </ul>
                    <div class="resp-tabs-container">
                        <!--/tab_one-->
                        <div class="tab1">
                            <c:forEach var="tempProduct" items ="${productName}">
                                <c:url var="productLink" value="SingleServlet">
                        <c:param name="singleee" value="${tempProduct.id}" />
                    </c:url>
                                <c:if test="${tempProduct.quantity > '0'}">
                                    <div class="col-md-3 product-men">
                                        <div class="men-pro-item simpleCart_shelfItem">
                                            <div class="men-thumb-item">
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProduct.getId()}" onerror="this.src='images/default_product.png'"   alt="" class="pro-image-front" width="250" height="250" >
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProduct.getId()}" onerror="this.src='images/default_product.png'"  alt="" class="pro-image-back"  width="250" height="250"  >
                                                <div class="men-cart-pro">
                                                    <div class="inner-men-cart-pro">
                                                        <a href="${productLink}" class="link-product-add-cart">Quick View</a>
                                                    </div>
                                                </div>
                                                <span class="product-new-top">New</span>

                                            </div>
                                            <div class="item-info-product ">
                                                <h4><a href="#">${tempProduct.name}</a></h4>
                                                <div class="info-product-price">
                                                    <span class="item_price">${tempProduct.price}</span>
                                                    <!--<del>$69.71</del>-->
                                                </div>
                                                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                                    <form action="CartServlet" method="post">
                                                        <fieldset>
                                                            <input type="hidden" name="cmd" value="_cart" />
                                                            <input type="hidden" name="add" value="1" />
                                                            <input type="hidden" name="business" value=" " />
                                                            <input type="hidden" name="item_name" value="${tempProduct.name}"/>
                                                            <input type="hidden" name="amount" value="${tempProduct.price}"/>
                                                            <input type="hidden" name="discount_amount" value="0.00" />
                                                            <input type="hidden" name="cart_code" value="70000000" />
                                                            <input type="hidden" name="currency_code" value="USD" />
                                                            <input type="hidden" name="return" value=" " />
                                                            <input type="hidden" name="cancel_return" value=" " />
                                                            <input type="submit" name="submit" value="Add to cart" class="button" />
                                                        </fieldset>
                                                    </form>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                            <div class="clearfix"></div>
                        </div>
                        <!--//tab_one-->
                        <!--/tab_two-->
                        <div class="tab2">
                            <c:forEach var="tempProductMan" items ="${productNameMan}">
                                 <c:url var="productLink" value="SingleServlet">
                        <c:param name="singleee" value="${tempProductMan.id}" />
                    </c:url>
                                <c:if test="${tempProductMan.quantity > '0'}">
                                    <div class="col-md-3 product-men">
                                        <div class="men-pro-item simpleCart_shelfItem">
                                            <div class="men-thumb-item">
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProductMan.id}" onerror="this.src='images/default_product.png'"   alt="" class="pro-image-front" width="250" height="250" >
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProductMan.id}" onerror="this.src='images/default_product.png'"  alt="" class="pro-image-back"  width="250" height="250"  >
                                                <div class="men-cart-pro">
                                                    <div class="inner-men-cart-pro">
                                                        <a href="${productLink}" class="link-product-add-cart">Quick View</a>
                                                    </div>
                                                </div>
                                                <span class="product-new-top">New</span>

                                            </div>
                                            <div class="item-info-product ">
                                                <h4><a href="#">${tempProductMan.name}</a></h4>
                                                <div class="info-product-price">
                                                    <span class="item_price">${tempProductMan.price}</span>
                                                    <!--<del>$69.71</del>-->
                                                </div>
                                                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                                    <form action="CartServlet" method="post">
                                                        <fieldset>
                                                            <input type="hidden" name="cmd" value="_cart" />
                                                            <input type="hidden" name="add" value="1" />
                                                            <input type="hidden" name="business" value=" " />
                                                            <input type="hidden" name="item_name" value="${tempProductMan.name}"/>
                                                            <input type="hidden" name="amount" value="${tempProductMan.price}"/>
                                                            <input type="hidden" name="discount_amount" value="0.00" />
                                                            <input type="hidden" name="cart_code" value="70000000" />
                                                            <input type="hidden" name="currency_code" value="USD" />
                                                            <input type="hidden" name="return" value=" " />
                                                            <input type="hidden" name="cancel_return" value=" " />
                                                            <input type="submit" name="submit" value="Add to cart" class="button" />
                                                        </fieldset>
                                                    </form>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                            <div class="clearfix"></div>
                        </div>
                        <!--//tab_two-->
                        <div class="tab3">
                            <c:forEach var="tempProductWomen" items ="${productNameWomen}">
                                  <c:url var="productLink" value="SingleServlet">
                        <c:param name="singleee" value="${tempProductWomen.id}" />
                    </c:url>
                                <c:if test="${tempProductWomen.quantity > '0'}">
                                    <div class="col-md-3 product-men">
                                        <div class="men-pro-item simpleCart_shelfItem">
                                            <div class="men-thumb-item">
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProductWomen.id}"onerror="this.src='images/default_product.png'"   alt="" class="pro-image-front" width="250" height="250" >
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProductWomen.id}" onerror="this.src='images/default_product.png'"  alt="" class="pro-image-back"  width="250" height="250"  >
                                                <div class="men-cart-pro">
                                                    <div class="inner-men-cart-pro">
                                                        <a href="${productLink}" class="link-product-add-cart">Quick View</a>
                                                    </div>
                                                </div>
                                                <span class="product-new-top">New</span>

                                            </div>
                                            <div class="item-info-product ">
                                                <h4><a href="#">${tempProductWomen.name}</a></h4>
                                                <div class="info-product-price">
                                                    <span class="item_price">${tempProductWomen.price}</span>
                                                    <!--<del>$69.71</del>-->
                                                </div>
                                                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                                    <form action="CartServlet" method="post">
                                                        <fieldset>
                                                            <input type="hidden" name="cmd" value="_cart" />
                                                            <input type="hidden" name="add" value="1" />
                                                            <input type="hidden" name="business" value=" " />
                                                            <input type="hidden" name="item_name" value="${tempProductWomen.name}"/>
                                                            <input type="hidden" name="amount" value="${tempProductWomen.price}"/>
                                                            <input type="hidden" name="discount_amount" value="0.00" />
                                                            <input type="hidden" name="cart_code" value="70000000" />
                                                            <input type="hidden" name="currency_code" value="USD" />
                                                            <input type="hidden" name="return" value=" " />
                                                            <input type="hidden" name="cancel_return" value=" " />
                                                            <input type="submit" name="submit" value="Add to cart" class="button" />
                                                        </fieldset>
                                                    </form>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                            <div class="clearfix"></div>
                        </div>
                        <div class="tab4">
                            <c:forEach var="tempProductBag" items ="${productNameBag}">
                                 <c:url var="productLink" value="SingleServlet">
                        <c:param name="singleee" value="${tempProductBag.id}" />
                    </c:url>
                                <c:if test="${tempProductBag.quantity > '0'}">
                                    <div class="col-md-3 product-men">
                                        <div class="men-pro-item simpleCart_shelfItem">
                                            <div class="men-thumb-item">
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProductBag.getId()}"onerror="this.src='images/default_product.png'"   alt="" class="pro-image-front" width="250" height="250" >
                                                <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${tempProductBag.getId()}" onerror="this.src='images/default_product.png'"  alt="" class="pro-image-back"  width="250" height="250"  >
                                                <div class="men-cart-pro">
                                                    <div class="inner-men-cart-pro">
                                                        <a href="${productLink}" class="link-product-add-cart">Quick View</a>
                                                    </div>
                                                </div>
                                                <span class="product-new-top">New</span>

                                            </div>
                                            <div class="item-info-product ">
                                                <h4><a href="#">${tempProductBag.name}</a></h4>
                                                <div class="info-product-price">
                                                    <span class="item_price">${tempProduct.price}</span>
                                                    <!--<del>$69.71</del>-->
                                                </div>
                                                <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                                                    <form action="CartServlet" method="post">
                                                        <fieldset>
                                                            <input type="hidden" name="cmd" value="_cart" />
                                                            <input type="hidden" name="add" value="1" />
                                                            <input type="hidden" name="business" value=" " />
                                                            <input type="hidden" name="item_name" value="${tempProductBag.name}"/>
                                                            <input type="hidden" name="amount" value="${tempProductBag.price}"/>
                                                            <input type="hidden" name="discount_amount" value="0.00" />
                                                            <input type="hidden" name="cart_code" value="70000000" />
                                                            <input type="hidden" name="currency_code" value="USD" />
                                                            <input type="hidden" name="return" value=" " />
                                                            <input type="hidden" name="cancel_return" value=" " />
                                                            <input type="submit" name="submit" value="Add to cart" class="button" />
                                                        </fieldset>
                                                    </form>
                                                </div>

                                            </div>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- //new_arrivals -->
        <!-- /we-offer -->
        <div class="sale-w3ls">
            <div class="container">
                <h6>We Offer Flat <span>40%</span> Discount</h6>

                <a class="hvr-outline-out button2" href="#">Shop Now </a>
            </div>
        </div>
        <!-- //we-offer -->
        <!--/grids-->

        <!--grids-->
        <!-- footer -->
        <div class="footer">
            <div class="footer_agile_inner_info_w3l">
                <div class="col-md-3 footer-left">
                    <h2><a href="Start"><span>E</span>lite Shoppy </a></h2>
                    <p>Lorem ipsum quia dolor
                        sit amet, consectetur, adipisci velit, sed quia non
                        numquam eius modi tempora.</p>

                </div>
                <div class="col-md-9 footer-right">
                    <div class="sign-grds">
                        <div class="col-md-4 sign-gd">
                            <h4>Our <span>Information</span> </h4>
                            <ul>
                                <li><a href="Start">Home</a></li>
                                <li><a href="RedirectAbout">About</a></li>
                                <li><a href="contact.jsp">Contact</a></li>
                            </ul>
                        </div>

                        <!-- //footer -->

                        <!-- login -->
                        <div class="modal fade" id="myModal4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content modal-info">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    </div>
                                    <div class="modal-body modal-spa">
                                        <div class="login-grids">
                                            <div class="login">
                                                <div class="login-bottom">
                                                    <h3>Sign up for free</h3>
                                                    <form>
                                                        <div class="sign-up">
                                                            <h4>Email :</h4>
                                                            <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                        this.value = 'Type here';
                                                                    }"  >
                                                        </div>
                                                        <div class="sign-up">
                                                            <h4>Password :</h4>
                                                            <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                        this.value = 'Password';
                                                                    }"  >

                                                        </div>
                                                        <div class="sign-up">
                                                            <h4>Re-type Password :</h4>
                                                            <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                        this.value = 'Password';
                                                                    }"  >

                                                        </div>
                                                        <div class="sign-up">
                                                            <input type="submit" value="REGISTER NOW" >
                                                        </div>

                                                    </form>
                                                </div>
                                                <div class="login-right">
                                                    <h3>Sign in with your account</h3>
                                                    <form>
                                                        <div class="sign-in">
                                                            <h4>Email :</h4>
                                                            <input type="text" value="Type here" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                        this.value = 'Type here';
                                                                    }"  >
                                                        </div>
                                                        <div class="sign-in">
                                                            <h4>Password :</h4>
                                                            <input type="password" value="Password" onfocus="this.value = '';" onblur="if (this.value == '') {
                                                                        this.value = 'Password';
                                                                    }"  >
                                                            <a href="#">Forgot password?</a>
                                                        </div>
                                                        <div class="single-bottom">
                                                            <input type="checkbox"  id="brand" value="">
                                                            <label for="brand"><span></span>Remember Me.</label>
                                                        </div>
                                                        <div class="sign-in">
                                                            <input type="submit" value="SIGNIN" >
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                            <p>By logging in you agree to our <a href="#">Terms and Conditions</a> and <a href="#">Privacy Policy</a></p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- //login -->
                        <a href="#home" class="scroll" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>

                        <!-- js -->
                        <script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
                        <!-- //js -->
                        <script src="js/modernizr.custom.js"></script>
                        <!-- Custom-JavaScript-File-Links -->
                        <!-- cart-js -->
                        <script src="js/minicart.min.js"></script>
                        <script>
                                                                // Mini Cart
                                                                paypal.minicart.render({
                                                                    action: '#'
                                                                });

                                                                if (~window.location.search.indexOf('reset=true')) {
                                                                    paypal.minicart.reset();
                                                                }
                        </script>

                        <!-- //cart-js -->
                        <!-- script for responsive tabs -->
                        <script src="js/easy-responsive-tabs.js"></script>
                        <script>
                                                                $(document).ready(function () {
                                                                    $('#horizontalTab').easyResponsiveTabs({
                                                                        type: 'default', //Types: default, vertical, accordion
                                                                        width: 'auto', //auto or any width like 600px
                                                                        fit: true, // 100% fit in a container
                                                                        closed: 'accordion', // Start closed if in accordion view
                                                                        activate: function (event) { // Callback function if tab is switched
                                                                            var $tab = $(this);
                                                                            var $info = $('#tabInfo');
                                                                            var $name = $('span', $info);
                                                                            $name.text($tab.text());
                                                                            $info.show();
                                                                        }
                                                                    });
                                                                    $('#verticalTab').easyResponsiveTabs({
                                                                        type: 'vertical',
                                                                        width: 'auto',
                                                                        fit: true
                                                                    });
                                                                });
                        </script>
                        <!-- //script for responsive tabs -->
                        <!-- stats -->
                        <script src="js/jquery.waypoints.min.js"></script>
                        <script src="js/jquery.countup.js"></script>
                        <script>
                                                                $('.counter').countUp();
                        </script>
                        <!-- //stats -->
                        <!-- start-smoth-scrolling -->
                        <script type="text/javascript" src="js/move-top.js"></script>
                        <script type="text/javascript" src="js/jquery.easing.min.js"></script>
                        <script type="text/javascript">
                                                                jQuery(document).ready(function ($) {
                                                                    $(".scroll").click(function (event) {
                                                                        event.preventDefault();
                                                                        $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1000);
                                                                    });
                                                                });
                        </script>
                        <!-- here stars scrolling icon -->
                        <script type="text/javascript">
                            $(document).ready(function () {
                                /*
                                 var defaults = {
                                 containerID: 'toTop', // fading element id
                                 containerHoverID: 'toTopHover', // fading element hover id
                                 scrollSpeed: 1200,
                                 easingType: 'linear'
                                 };
                                 */

                                $().UItoTop({easingType: 'easeOutQuart'});

                            });
                        </script>
                        <!-- //here ends scrolling icon -->


                        <!-- for bootstrap working -->
                        <script type="text/javascript" src="js/bootstrap.js"></script>
                        </body>
                        </html>
