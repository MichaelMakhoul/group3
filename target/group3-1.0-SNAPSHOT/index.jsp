<%-- 
    Document   : index
    Created on : 24-Jan-2023, 4:48:40 PM
    Author     : Aiman, Antonella, Micheal, Monte, Shilpa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">        
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/w3.css" rel="stylesheet">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet">  
        <link href="css/flexslider.css" rel="stylesheet">
        <link href="css/templatemo-style.css" rel="stylesheet">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Nunito+Sans:wght@200&display=swap" rel="stylesheet">    
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="css/style.css" rel="stylesheet">
    </head>
    <body class="tm-gray-bg">
        <div class="tm-header">
            <div class="nav-container">
                <div class="row">
                    <div class="col-lg-6 col-md-4 col-sm-3 tm-site-name-container">
                        <p class="tm-site-name" >The Grand Serene</p>
                    </div>
                    <div class="col-lg-6 col-md-8 col-sm-9">
                        <div class="mobile-menu-icon">
                            <i class="fa fa-bars"></i>
                        </div>
                        <nav class="tm-nav">
                            <ul>
                                <li><a href="index.jsp" class="active">Home</a></li>
                                <li><a href="register.jsp">Register</a></li>                                
                                <li><a href="login.jsp">Login</a></li>
                                <li><a href="team.jsp">Our Team</a></li>
                            </ul>
                        </nav>		
                    </div>				
                </div>
            </div>	  	
        </div>

        <!-- Banner -->
        <section class="tm-banner">
            <!-- Flexslider -->
            <div class="flexslider flexslider-banner">
                <ul class="slides">
                    <li>
                        <div class="tm-banner-inner">
                            <h1 class="tm-banner-title">Find Your <span class="tm-yellow-text">Serene</span></h1>
                            <p class="tm-banner-subtitle">Experience the Luxury</p>
                            <a href="register.jsp" class="tm-banner-link">Sign Up Now</a>	
                        </div>
                        <img src="img/banner-3.jpg" alt="Image" />	
                    </li>
                    <li>
                        <div class="tm-banner-inner">
                            <h1 class="tm-banner-title">Beautiful Inviting<span class="tm-yellow-text"> Destinations</span></h1>
                            <p class="tm-banner-subtitle">Our Wonderful Locations</p>
                            <a href="register.jsp" class="tm-banner-link">Sign Up Now</a>	
                        </div>
                        <img src="img/banner-2.jpg" alt="Image" />
                    </li>
                    <li>
                        <div class="tm-banner-inner">
                            <h1 class="tm-banner-title">Exclusive Member<span class="tm-yellow-text"> Benefits</span></h1>
                            <p class="tm-banner-subtitle">Already a Member?</p>
                            <a href="login.jsp" class="tm-banner-link">Sign In Now</a>	
                        </div>
                        <img src="img/banner-1.jpg" alt="Image" />
                    </li>
                </ul>
            </div>	
        </section>	
        <div id="id01" class="w3-modal" style="display: none;">
            <div class="w3-modal-content w3-card-4 w3-animate-zoom" >
                <div class="w3-center"><br>
                    <span onclick="document.getElementById('id01').style.display = 'none'" class="w3-button w3-xlarge w3-hover-red w3-display-topright" title="Close Modal">&times;</span>      
                </div>
                <div class="popup-div w3-container">
                    <div class="w3-section">
                        <h2 id="popup-h2" class="popup-h2">You have successfully logged out</h2>
                        <h4 id="popup-h3" style="margin-top: 20px; margin-bottom: -5px;" class="popup-h2">Hope you enjoyed your experience, see you soon</h4>
                        <button class="w3-button w3-red w3-right w3-margin w3-round" onclick="document.getElementById('id01').style.display = 'none'">close</button>
                    </div>
                </div>
            </div>
        </div>
        <section class="container tm-home-section-1" id="more">
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="tm-home-box-1">
                        <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
                            <img src="img/deluxe.jpg" alt="image" class="img-responsive">
                            <a href="login.jsp">
                                <div class="tm-green-gradient-bg tm-city-price-container">
                                    <span>Deluxe Room</span>
                                    <span><b>$150</b></span>
                                </div>	
                            </a>			
                        </div>		
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-center">
                        <img src="img/family.jpg" alt="image" class="img-responsive">
                        <a href="login.jsp">
                            <div class="tm-green-gradient-bg tm-city-price-container">
                                <span>Family Room</span>
                                <span><b>$250</b></span>
                            </div>	
                        </a>			
                    </div>				
                </div>
                <div class="col-lg-4 col-md-4 col-sm-6">
                    <div class="tm-home-box-1 tm-home-box-1-2 tm-home-box-1-right">
                        <img src="img/suite.jpg" alt="image" class="img-responsive">
                        <a href="login.jsp">
                            <div class="tm-green-gradient-bg tm-city-price-container">
                                <span>Executive Suite</span>
                                <span><b>$500</b></span>
                            </div>	
                        </a>					
                    </div>				
                </div>
            </div>
            <div class="section-margin-top">
                <div class="row">				
                    <div class="tm-section-header">
                        <div class="col-lg-3 col-md-3 col-sm-3"><hr></div>
                        <div class="col-lg-6 col-md-6 col-sm-6"><h2 class="tm-section-title">Our Reviews</h2></div>
                        <div class="col-lg-3 col-md-3 col-sm-3"><hr></div>	
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                        <div class="tm-home-box-2">						
                            <img src="img/Marcia.jpg" alt="image" class="img-responsive">
                            <h3>This is the most luxurious of the big hotels. There is a lot of attention paid to details both in the experience, service and rooms.</h3>
                            <p class="tm-date">Marcia H</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                        <div class="tm-home-box-2">						
                            <img src="img/geoffG.jpg" alt="image" class="img-responsive">
                            <h3>Everything about this hotel was five star. Staff. Rooms. Location has got to be the best. Would definitely stay here again!</h3>
                            <p class="tm-date">Geoff G</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                        <div class="tm-home-box-2">						
                            <img src="img/Vince.jpg" alt="image" class="img-responsive">
                            <h3>An amazing level of service from the moment we arrived to the moment we left, best way of celebrating our anniversary.</h3>
                            <p class="tm-date">Vince O</p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-6 col-xs-6 col-xxs-12">
                        <div class="tm-home-box-2 tm-home-box-2-right">						
                            <img src="img/hellna.jpg" alt="image" class="img-responsive">
                            <h3>Great hotel, restaurants - the Living Room, the Dining Room, the Bar. Beautiful Spa. Could not go past the buffet.</h3>
                            <p class="tm-date">Helena P</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>		
        <section class="tm-white-bg section-padding-bottom">
            <div class="container">
                <div class="row">
                    <div class="tm-section-header section-margin-top">
                        <div class="col-lg-4 col-md-3 col-sm-3"><hr></div>
                        <div class="col-lg-4 col-md-6 col-sm-6"><h2 class="tm-section-title">Hotel Organized Events</h2></div>
                        <div class="col-lg-4 col-md-3 col-sm-3"><hr></div>	
                    </div>
                    <div class="col-lg-6">
                        <div class="tm-home-box-3">
                            <div class="tm-home-box-3-img-container">
                                <img src="img/Parasailing.jpg" alt="image" class="img-responsive">	
                            </div>						
                            <div class="tm-home-box-3-info">
                                <p class="tm-home-box-3-description">Parasailing offers a completely unique and adrenaline-pumping way to take on the waves, which makes it one of the most exciting water sports you can do. 
                                    Ask our friendly staff about our Parasailing organized events at our lobby</p>
                            </div>					
                        </div>					
                    </div>
                    <div class="col-lg-6">
                        <div class="tm-home-box-3">
                            <div class="tm-home-box-3-img-container">
                                <img src="img/kayaking.jpg" alt="image" class="img-responsive">	
                            </div>						
                            <div class="tm-home-box-3-info">
                                <p class="tm-home-box-3-description">There's no better way to tour our beaches and coastlines than by kayak. These streamlined vessels have the versatility to both glide silently past 
                                    skittish wildlife and cut through strong currents with agility. Ask our friendly staff about our Kayaking organized events at our lobby
                                </p>
                            </div>						
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="tm-home-box-3">
                            <div class="tm-home-box-3-img-container">
                                <img src="img/scuba.jpg" alt="image" class="img-responsive">	
                            </div>						
                            <div class="tm-home-box-3-info">
                                <p class="tm-home-box-3-description">Scuba diving courses and snorkeling tours are a wonderful way to explore the magic of the ocean. Go deep beneath the waves with a scuba diving 
                                    course or paddle around amongst the rocks with snorkelling. Ask our friendly staff about our Scuba Diving organized events at our lobby</p>
                            </div>						
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="tm-home-box-3">
                            <div class="tm-home-box-3-img-container">
                                <img src="img/jetski.jpg" alt="image" class="img-responsive">	
                            </div>						
                            <div class="tm-home-box-3-info">
                                <p class="tm-home-box-3-description">Explore our awesome range of jet ski hire and jet ski tour experiences at our stunning location. Watersports lovers will be in their element 
                                    zooming across waterways and taking in some of the best coastal views. Ask our friendly staff about our Jet Skiing organized events at our lobby</p>
                            </div>						
                        </div>
                    </div>
                </div>		
            </div>
        </section>
        <footer class="tm-black-bg">
            <div class="container">
                <div class="row">
                    <p class="tm-copyright-text">Copyright &copy; 2022 TGS 

                        | Designed by AAMMS</p>
                </div>
            </div>		
        </footer>
        <script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
        <script type="text/javascript" src="js/moment.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/bootstrap-datetimepicker.min.js"></script>
        <script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="js/templatemo-script.js"></script>
        <script>
                            // HTML document is loaded. DOM is ready.
                            $(function () {

                                $('#hotelCarTabs a').click(function (e) {
                                    e.preventDefault()
                                    $(this).tab('show')
                                })

                                $('.date').datetimepicker({
                                    format: 'MM/DD/YYYY'
                                });
                                $('.date-time').datetimepicker();

                                // https://css-tricks.com/snippets/jquery/smooth-scrolling/
                                $('a[href*=#]:not([href=#])').click(function () {
                                    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
                                        var target = $(this.hash);
                                        target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                                        if (target.length) {
                                            $('html,body').animate({
                                                scrollTop: target.offset().top
                                            }, 1000);
                                            return false;
                                        }
                                    }
                                });
                            });

                            // Load Flexslider when everything is loaded.
                            $(window).load(function () {

//	For images only
                                $('.flexslider').flexslider({
                                    controlNav: false
                                });
                            });
                            
                            function showLogoutMessage() {
                                window.history.pushState({prevUrl: window.location.href}, null, "index.jsp");
                                let prev = window.history.state.prevUrl;
                                if (prev === "http://localhost:8080/group3/LogoutServlet") {
                                    document.getElementById('id01').style.display = 'flex';
                                } else if (prev === "http://localhost:8080/group3/UserDeleteServlet" || prev === "http://localhost:8080/group3/UserDeleteServlet?") {
                                    document.getElementById('id01').style.display = 'flex';
                                    document.getElementById('popup-h2').innerHTML = 'Your account has been successfully deleted';
                                    document.getElementById('popup-h3').innerHTML = 'Arrivederci from the TGS team';
                                }
                            }
                            showLogoutMessage();
        </script>
    </body>
    <jsp:include page="/InitServlet" flush="true"/>
</html>
