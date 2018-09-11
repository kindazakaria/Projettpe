<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

             <!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>accueil adherent</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="styl/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME ICONS  -->
    <link href="styl/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="styl/assets/css/style.css" rel="stylesheet" />
     <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
    <header>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <strong>Email:</strong>savoirarme@gmail.com
                    &nbsp;&nbsp;
                    <strong>Support:</strong>+84-167-512-578-1
                </div>

            </div>
        </div>
    </header>
    <!-- HEADER END-->
    <div class="navbar navbar-inverse set-radius-zero">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">

                    <!--<img src="styl/assets/img/logo.png" />  -->
                </a>

            </div>

            <div class="left-div">
                <div class="user-settings-wrapper">
                    <ul class="nav">

                        <li class="dropdown">
                            <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                                <span class="glyphicon glyphicon-user" style="font-size: 25px;"></span>
                            </a>
                            <div class="dropdown-menu dropdown-settings">
                                <div class="media">
                                    <a class="media-left" href="#">
                                    	<span class="glyphicon glyphicon-user"></span>
                                        <!-- <img src="assets/img/64-64.jpg" alt="" class="img-rounded" /> --> 
                                    </a>
                                    <div class="media-body">
                                        <h4 class="media-heading"> profil </h4>
                                        <h5> Adherent</h5>
                                        <h5> votre abonnement s exprimera le:</h5>
											<i> <c:out value="${expr}"></c:out></i>
                                    </div>
                                </div>
                                <hr />
                                <h5><strong>information : </strong></h5>
                                		<i><c:out value="${profil.nom }"></c:out></i>.
                              			<i> <c:out value="${profil.prenom }"></c:out> </i>
                                <hr />
                                <a href="#" class="btn btn-info btn-sm">Reabonnement</a>&nbsp; <a href='<c:url value="/ServdeconAdh"></c:url>' class="btn btn-danger btn-sm">Se deconnecter</a> 
                            </div>
                        </li>


                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- LOGO HEADER END-->
    <section class="menu-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
                            <li><a  href="index.html"><!--  Dashboard--></a></li>
                            <li><a href="ui.html"> <!--  UI Elements--></a></li>
                            <li><a href="table.html"><!--  Data Tables--></a></li>
                            <li><a href="forms.html"><!-- Forms --></a></li>
                             <li><a href="login.html">Login Page</a></li>
                            <li><a class="menu-top-active" href="blank.html">user space</a></li>

                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- MENU SECTION END-->
    <div class="content-wrapper">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h4 class="page-head-line">user space</h4>

                </div>

            </div>
            <div class="row">
                <div class="col-md-12">
                    
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>

    <!-- Wrapper for slides -->

    <div class="carousel-inner">
      <div class="item active">
        <img src="styl/image/liv2.jpg" alt="Los Angeles" >
      </div>

      <div class="item">
        <img src="styl/image/liv1.jpg" alt="Chicago"  >
      </div>
    
      <div class="item">
        <img src="styl/image/liv3.jpg" alt="New york"  >
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
                </div>
                </div>
<br/>
<br/>
               
<div class="col-md-12">
                     <!--    Hover Rows  -->
                   <div class="panel panel-default">
                        <div class="panel-heading">
                            menu user
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-pills">
                                <li class=""><a href="#home-pills" data-toggle="tab"> CATALOGUE</a>
                                </li>
                                <li class=""><a href="#profile-pills" data-toggle="tab">HISTORIQUE</a>
                                </li>
                                <li class=""><a href="#messages-pills" data-toggle="tab"> DEMANDE EMP.</a>
                                </li>
                                <li class="active"><a href="#settings-pills" data-toggle="tab">MES EMPRUNTS</a>
                                </li>
                            </ul>

                            <div class="tab-content">
                                <div class="tab-pane fade" id="home-pills">
                                    <h4> <i>Historique des emprunts</i></h4>
                                    <p>
                                    	
                                    	
                                         <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                               <th>Ref. No.</th>
                                                                <th>Date</th>
                                                                <th>titre</th>
                                                                <th>isbn</th>
                                                                <th>Nom auteur </th>
                                                                <th>categorie</th>
                                                                <th>quantite</th>
                                                                <th> # #</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody>
                                                        		<c:forEach var="listliv" items="${lisemp}">
                                                  <form action="Servemprunt" method="Post"> 
                                                  
                                                  		
                                                                <tr> 
                                                                    <td>
                                                                        <c:out value="${listliv.idLivre }"></c:out>
                                                                       
                                                                    </td>
                                                                    <td>
                                                                        <c:out value="${listliv.dateEdit}"></c:out>
                                                                    </td>
                                                                    <td>
                                                                       <c:out value="${listliv.titre }"></c:out>
                                                                    </td>
                                                                    <td>        
                                                                    	<c:out value="${listliv.isbn }"></c:out>
                                                                   </td>
                                                                   <td>
                                                                        <c:out value="${listliv.nomAut }"></c:out>
                                                                        </td>
                                                                   <td>
                                                                       <c:out value="${listliv.categorie }"></c:out>
                                                                    </td>
                                                                    	  <td>
                                                                        <c:out value="${listliv.quantite }" />
                                                                    </td>
                                                                    
                                                                     <td>
                                                                          <input type="submit" class="btn btn-primary" value="emprunter">
                                                                        
                                                                    </td>
                                                                             <input type="hidden" name="idliv" value="<c:out value="${listliv.idLivre }"></c:out>"/>
                                                                   </tr> 
                                                                   
                                                                    </form>
                                                                          </c:forEach>
                                                          
                                                         </tbody>
                                                         </table> 
                                                             
                                    .</p>
                                </div>
                                <div class="tab-pane fade" id="profile-pills">
                                    <h4>catalogue</h4>
                                    <c:choose>
 								<c:when test="${not empty  erreur.date }"> ${erreur.date }</c:when>
 								<c:when test="${not empty  erreur.stock}"> ${erreur.stock }</c:when>
 								<c:when test="${ not empty erreur.quantite }"> ${erreur.quantite } </c:when>
 							</c:choose>
                                    
                                    <p>
                                    	<c:choose>
                                    		<c:when test="${not empty pret}">
                                    			<c:forEach var="livre" items="${pret}">
                                    			<c:out value="${livre.titreliv }"></c:out>
                                    			<c:out value="${livre.nomAut }"></c:out>
                                    			<c:out value="${livre.datesortie }"></c:out>
                                    			<c:out value="${livre.dateretour }"></c:out>
                                    			
                                    			</c:forEach>
                                    		</c:when>
                                    		<c:otherwise> <b> <c:out value="aucun pret n est effectue"></c:out></b> </c:otherwise>
                                    	</c:choose>
                                    	ghjkk
                                    .</p>
                                </div>
                                <div class="tab-pane fade" id="messages-pills">
                                    <h4>Emprunt encore</h4>
                                    <p>
                                    <c:choose>
                                    	<c:when test="${not empty pretenc}">
                                    	 <table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                               <th>Titre</th>
                                                                <th>Nom auteur</th>
                                                                <th> Date de la demande</th>
                                                                <th>observation</th>
                                                                
                                                            </tr>
                                                        </thead>
                                                        	<tbody>
                                                        			<c:forEach var="pretenc" items="${pretenc}">
                                                        		<tr>
                                                        			<td> <c:out value="${pretenc.titreliv }"></c:out> </td>
                                                        			<td> <c:out value="${pretenc.nomAut }"></c:out> </td>
                                                        			<td> <c:out value="${pretenc.datesortie }"></c:out> </td>
                                                        			<td> <c:out value="Demande en cours de validation"></c:out> </td>
                                                        		</tr>
                                                        	</c:forEach>	
                                                        	</tbody>
                                                        </table>	
                                    	</c:when>
                                    	<c:otherwise> <b> <c:out value="Aucune demande est encore de traitement">  </c:out> </b> </c:otherwise>
                                    </c:choose>
                                    
                                    .</p>
                                </div>
                                <div class="tab-pane fade active in" id="settings-pills">
                                    <h4> les livres en ma possession</h4>
                                    <p>  
                                    	
                                    			<table class="table table-striped table-bordered table-hover">
                                                        <thead>
                                                            <tr>
                                                               <th>Titre</th>
                                                                <th>Nom auteur</th>
                                                                <th> Date de la demande</th>
                                                                <th>observation</th>
                                                                
                                                            </tr>
                                                        </thead>
                                                        	<tbody>
                                                        		<c:forEach var="empr" items="${emprt}">
                                                        			<tr>
                                                        					<td> <c:out value="${empr.titreliv}"></c:out> </td>
                                                        					<td> <c:out value="${empr.nomAut}"></c:out> </td>
                                                        					<td> <c:out value="${empr.datesortie}"></c:out> </td>
                                                        					<td> <c:out value="${empr.dateretour}"></c:out> </td>
                                                        			</tr>
                                                        		
                                                        		</c:forEach>
                                                        	         
                                                        	</tbody>
                                    					</table>
                                    				
                                    		
                                    
                                    .</p>
                                </div>
                            </div>
                        </div>
                    </div>
        </div>
    </div>
    <!-- CONTENT-WRAPPER SECTION END-->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    &copy; 2015 YourCompany | By : <a href="http://www.designbootstrap.com/" target="_blank">DesignBootstrap</a>
                </div>

            </div>
        </div>
    </footer>
    <!-- FOOTER SECTION END-->
    <!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.11.1.js"></script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
</body>
</html>
