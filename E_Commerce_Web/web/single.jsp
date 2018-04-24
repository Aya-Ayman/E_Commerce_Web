<%-- 
    Document   : single
    Created on : Feb 12, 2018, 11:12:01 PM
    Author     : Hesham
    Author     : asmaa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Elite Shoppy an Ecommerce Online Shopping Category Flat Bootstrap Responsive Website Template | Single :: w3layouts</title>
        <!--/tags -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Elite Shoppy Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //tags -->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
        <link href="css/font-awesome.css" rel="stylesheet"> 
        <link href="css/easy-responsive-tabs.css" rel='stylesheet' type='text/css'/>
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />

        <!-- //for bootstrap working -->
        <link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800" rel="stylesheet">
        <link href='//fonts.googleapis.com/css?family=Lato:400,100,100italic,300,300italic,400italic,700,900,900italic,700italic' rel='stylesheet' type='text/css'>
    </head>
    <body>
        <!-- header -->
        <div class="header" id="home">
            <div class="container">
                <ul>

                </ul>
            </div>
        </div>
        <!-- //header -->
        <!-- header-bot -->
        <div class="header-bot">
            <div class="header-bot_inner_wthreeinfo_header_mid">
                <div class="col-md-4 header-middle">

                </div>
                <!-- header-bot -->
                <div class="col-md-4 logo_agile">
                    <h1><a href="Start"><span>E</span>lite Shoppy <i class="fa fa-shopping-bag top_logo_agile_bag" aria-hidden="true"></i></a></h1>
                </div>
                <!-- header-bot -->
                <div class="col-md-4 agileits-social top_content">
                    <ul class="social-nav model-3d-0 footer-social w3_agile_social">
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
                                    <li class="active menu__item"><a class="menu__link" href="Start">Home <span class="sr-only">(current)</span></a></li>
                                    <!--<li class=" menu__item"><a class="menu__link" href="RedirectAbout">About</a></li>-->
                                    <li class="dropdown menu__item">
                                        <!--<a href="#" class="dropdown-toggle menu__link" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Men's wear <span class="caret"></span></a>-->
                                        <ul class="dropdown-menu multi-column columns-3">
                                            <div class="agile_inner_drop_nav_info">
                                                <div class="col-sm-6 multi-gd-img1 multi-gd-text ">
                                                    <a href="mens.html"><img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${obj.id}" alt=" " onerror="this.src='images/default_product.png'"/></a>
                                                </div>
                                                <div class="col-sm-3 multi-gd-img">

                                                </div>
                                                <div class="col-sm-3 multi-gd-img">
                                                    <ul class="multi-column-dropdown">
                                                        <li><a href="mens.html">Jewellery</a></li>
                                                        <li><a href="mens.html">Sunglasses</a></li>
                                                        <li><a href="mens.html">Perfumes</a></li>
                                                        <li><a href="mens.html">Beauty</a></li>
                                                        <li><a href="mens.html">Shirts</a></li>
                                                        <li><a href="mens.html">Sunglasses</a></li>
                                                        <li><a href="mens.html">Swimwear</a></li>
                                                    </ul>
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </ul>
                                    </li>
                                    <li class="dropdown menu__item">
                                        <ul class="dropdown-menu multi-column columns-3">
                                            <div class="agile_inner_drop_nav_info">
                                                <div class="col-sm-3 multi-gd-img">

                                                </div>
                                                <div class="col-sm-3 multi-gd-img">

                                                </div>
                                                <div class="col-sm-6 multi-gd-img multi-gd-text ">
                                                </div>
                                                <div class="clearfix"></div>
                                            </div>
                                        </ul>
                                    </li>
                                    <li class="menu__item dropdown">
                                        <ul class="dropdown-menu agile_short_dropdown">

                                        </ul>
                                    </li>
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
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog">
                <!-- Modal content-->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                    </div>
                    <div class="modal-body modal-body-sub_agile">
                        <div class="col-md-8 modal_body_left modal_body_left1">
                            <h3 class="agileinfo_sign">Sign In <span>Now</span></h3>
                            <form action="#" method="post">
                                <div class="styled-input agile-styled-input-top">
                                    <input type="text" name="Name"  >
                                    <label>Name</label>
                                    <span></span>
                                </div>
                                <div class="styled-input">
                                    <input type="email" name="Email"  > 
                                    <label>Email</label>
                                    <span></span>
                                </div> 
                                <input type="submit" value="Sign In">
                            </form>
                            <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
                                <li><a href="#" class="facebook">
                                        <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="twitter"> 
                                        <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="instagram">
                                        <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="pinterest">
                                        <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
                            </ul>
                            <div class="clearfix"></div>
                            <p><a href="#" data-toggle="modal" data-target="#myModal2" > Don't have an account?</a></p>

                        </div>
                        <div class="col-md-4 modal_body_right modal_body_right1">
                            <!--<img src="images/log_pic.jpg" alt=" "/>-->
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
                            <form action="#" method="post">
                                <div class="styled-input agile-styled-input-top">
                                    <input type="text" name="Name"  >
                                    <label>Name</label>
                                    <span></span>
                                </div>
                                <div class="styled-input">
                                    <input type="email" name="Email"  > 
                                    <label>Email</label>
                                    <span></span>
                                </div> 
                                <div class="styled-input">
                                    <input type="password" name="password"  > 
                                    <label>Password</label>
                                    <span></span>
                                </div> 
                                <div class="styled-input">
                                    <input type="password" name="Confirm Password"  > 
                                    <label>Confirm Password</label>
                                    <span></span>
                                </div> 
                                <input type="submit" value="Sign Up">
                            </form>
                            <ul class="social-nav model-3d-0 footer-social w3_agile_social top_agile_third">
                                <li><a href="#" class="facebook">
                                        <div class="front"><i class="fa fa-facebook" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-facebook" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="twitter"> 
                                        <div class="front"><i class="fa fa-twitter" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-twitter" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="instagram">
                                        <div class="front"><i class="fa fa-instagram" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-instagram" aria-hidden="true"></i></div></a></li>
                                <li><a href="#" class="pinterest">
                                        <div class="front"><i class="fa fa-linkedin" aria-hidden="true"></i></div>
                                        <div class="back"><i class="fa fa-linkedin" aria-hidden="true"></i></div></a></li>
                            </ul>
                            <div class="clearfix"></div>
                            <p><a href="#">By clicking register, I agree to your terms</a></p>

                        </div>
                        <div class="col-md-4 modal_body_right modal_body_right1">
                            <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${obj.id}" onerror="this.src='images/default_product.png'" alt=" "/>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <!-- //Modal content-->
            </div>
        </div>
        <!-- //Modal2 -->
        <!--/single_page-->
        <!-- /banner_bottom_agile_info -->
        <div class="page-head_agile_info_w3l">
            <div class="container">
                <h3>Single <span>Page </span></h3>
                <!--/w3_short-->
                <div class="services-breadcrumb">
                    <div class="agile_inner_breadcrumb">

                        <ul class="w3_short">
                            <li><a href="Start">Home</a><i>|</i></li>
                            <li>Single Page</li>
                        </ul>
                    </div>
                </div>
                <!--//w3_short-->
            </div>
        </div>

        <!-- banner-bootom-w3-agileits -->
        <div class="banner-bootom-w3-agileits">
            <div class="container">
                <div class="col-md-4 single-right-left ">
                    <div class="grid images_3_of_2">
                        <div class="flexslider">

                            <ul class="slides">
                                    <div class="thumb-image"> <img src="${pageContext.servletContext.contextPath }/DisplayPhotoServlet?id=${obj.id}" onerror="this.src='images/default_product.png'" data-imagezoom="true" class="img-responsive"> </div>
                           
                            </ul>
                            <div class="clearfix"></div>
                        </div>	
                    </div>
                </div>
                <div class="col-md-8 single-right-left simpleCart_shelfItem">
                    <h3>${obj.name}</h3></br></br>
                    <div class="color-quality">
                        <div class="color-quality-right">
                            <h5>${obj.price}</h5>

                        </div>
                    </div>
                    <div class="occasional">

                        <div class="clearfix"> </div>
                    </div>
                    <div class="occasion-cart">
                        <div class="snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2">
                        </div>

                    </div>
<div class="col-md-4 agileits-social top_content">
                    <ul class="social-nav model-3d-0 footer-social w3_agile_social single_page_w3ls">
                       <li class="share">Our Social Media : </li>
                       </br>
                       </br>
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

                </div>
                <div class="clearfix"> </div>
                <!-- /new_arrivals --> 
                <div class="responsive_tabs_agileits"> 
                    <div id="horizontalTab">
                        <ul class="resp-tabs-list">
                            <li>Description</li>
                            <!--<li>Reviews</li>-->
                            <li>Information</li>
                        </ul>
                        <div class="resp-tabs-container">
                            <!--/tab_one-->
                            <div class="tab1">

                                <div class="single_page_agile_its_w3ls">
                                    <h6>about ${obj.name}</h6>
                                    <p>${obj.description}</p>
                                </div>
                            </div>
                            <!--//tab_one-->
             
                            <div class="tab3">

                                <div class="single_page_agile_its_w3ls">
                                    <h6>${obj.name}</h6>
                                    <p>the best product</p>
                                </div>
                            </div>
                        </div>
                    </div>	
                </div>
                <!-- //new_arrivals --> 
                <!--/slider_owl-->

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
        <!-- single -->
        <script src="js/imagezoom.js"></script>
        <!-- single -->
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
        <!-- FlexSlider -->
        <script src="js/jquery.flexslider.js"></script>
        <script>
                                                // Can also be used with $(document).ready()
                                                $(window).load(function () {
                                                    $('.flexslider').flexslider({
                                                        animation: "slide",
                                                        controlNav: "thumbnails"
                                                    });
                                                });
        </script>
        <!-- //FlexSlider-->
        <!-- //script for responsive tabs -->		
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
        <!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
    </body>
</html>
