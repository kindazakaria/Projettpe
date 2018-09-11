<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
            <title>Le bibliotheque le savoir est une arme - fond documentaire</title>
            <!-- BOOTSTRAP CORE STYLE  -->
            <link href="styl/assets/css/bootstrap.css" rel="stylesheet" />
            <!-- FONT AWESOME ICONS  -->
            <link href="styl/assets/css/font-awesome.css" rel="stylesheet" />
            <!-- CUSTOM STYLE  -->
            <link href="styl/assets/css/style.css" rel="stylesheet" />
             <link href="styl/plugins/dataTables/dataTables.bootstrap.css/ rel="stylesheet" />
            <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
            <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
            <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
        </head>

        <body>
            <header>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <strong>Email: </strong>savoirarme@gmail.com &nbsp;&nbsp;
                            <strong>Support: </strong>+84-897-678-44
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

                    <!-- <img src="styl/assets/img/logo.png" />  -->
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
                                            	<span class="glyphicon glyphicon-user" style="font-size: 25px;"> </span>
                                        <!-- <img src="styl/assets/img/64-64.jpg" alt="" class="img-rounded" />  -->
                                    </a>
                                            <div class="media-body">
                                                <h4 class="media-heading">  </h4>
                                                <h5>Bibliothecaire</h5>

                                            </div>
                                        </div>
                                        <hr />
                                        <h5><strong>Personal Bio : </strong></h5>
                                        
                                        <hr />
                                       <!-- <a href="#" class="btn btn-info btn-sm">Full Profile</a>&nbsp; -->  <a href='<c:url value="/ServBiliodecon"></c:url>' class="btn btn-danger btn-sm">Se deconnecter</a>

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
                                    <li><a href="index.html">Login Page</a></li>
                                    <li><a class="menu-top-active" href="blank.html">fond documentaire</a></li>
                                  <!--   <li><a href="table.html"></a></li>
                                    <li><a href="forms.html"></a></li>
                                    <li><a href="login.html"></a></li>
                                    <li><a class="menu-top-active" href="blank.html"></a></li>  --> 

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
                            <h4 class="page-head-line">fond documentaire</h4>
                            <h3>
                                <c:out value="${message}"></c:out>
                                <c:if test="${not empty delete} "><i><c:out value="${delete}"></c:out></i></c:if>
                            </h3>

                        </div>

                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="col-md-12 col-sm-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        fond documentaire: le savoir est une arme
                                        <c:if test="${not empty messag }"> <div class="alert alert-danger" role="alert"><c:out value="${messag}"></c:out></div>    
                                        </c:if>
 							

                                    </div>
                                    <div class="panel-body">
                                        <ul class="nav nav-tabs">
                                            <li class="active"><a href="#home" data-toggle="tab">Ajouter un livre</a>
                                            </li>
                                            <li class=""><a href="#profile" data-toggle="tab">catalogue</a>
                                            </li>
                                            <li class=""><a href="#messages" data-toggle="tab">Demande des emprunts</a>
                                            </li>
                                            <li class=""><a href="#settings" data-toggle="tab">livres empruntes</a>
                                            </li>
                                        </ul>
		<c:choose> <c:when test="${not empty error}"><i> <c:out value="${error.vide }"/></i></c:when> <c:when test="${error.existence }"><i> <c:out value="${error.existence }"/></i></c:when>  <c:otherwise><c:out value="${message}"></c:out></c:otherwise></c:choose>
                                        <div class="tab-content">
                                            <div class="tab-pane fade active in" id="home">
                                                <h4>Ajouter un livre Tab</h4>
                                                <p>
                                                    <form class="we col-md-8" autocomplete="off" method="POST" action="ServLivre">

                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Titre</label>
                                                            <input id="Nom" type="text" class="form-control" placeholder="titre" name="titre" required="required">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="text">nombre exemplaire</label>
                                                            <input id="Nom" type="number" min="1" max="9" class="form-control" placeholder="titre" name="quantite" required="required">
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Categorie</label>
                                                            <select class="form-control" name="categorie">
                                                            <option value="informatique">informatique</option>
                                                            <option value="mathematique">mathematiques</option>
                                                            <option value="chimie" >chimie</option>
                                                            <option value"litterature">litterature afr</option>
                                                        </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Isbn</label>
                                                            <input id="Nom" type="text" class="form-control" placeholder="Isbn" name="isbn" required="required">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Date d edition</label>
                                                            <input id="Nom" type="Date" class="form-control" placeholder="Isbn" name="dat" required="required">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Nom auteur</label>
                                                            <input id="Nom" type="text" class="form-control" placeholder="auteur" name="nom" required="required">
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <button type="submit" name="envoyer" class=" form-control btn btn-primary pull-right"><span class="glyphicon glyphicon-floppy-disk"></span> Enregistrer</button>
                                                        </div>
                                                   </form> 
                                                 	.</p>                             
                                            </div>
                                            <div class="tab-pane fade" id="profile">
                                                <h4>Recherche... Tab</h4>
                                                <p>
                                                		
                                                    <form class="form-inline" method="post" action="#">  
                                                        <!-- <div class="container">  -->
                                                        <div class="row">
                                                            <div class="col-md-12 col-xs-offset-2">
                                                                <div class="form-group">
                                                                    <select class="form-control">
                                                                    <option >Filter by</option>
                                                                    <option value="Contains">Contains</option>
                                                                    <option value="equal">It's equal</option>
                                                                    <option value="Greather">Greather than</option>
                                                                </select>


                                                                    <input type="text" class="form-control" name="x" placeholder="Search term..." />
                                                                    <button class="btn btn-default"> 
                                                                 <span class="glyphicon glyphicon-search"></span>
                                                                </button>
                                                                </div>
                                                            </div>
                                                           // </div>
                                                    </form>  
                                                   <!--  </div> --> 
                                                    <br>

                                                    <table class="table table-striped table-bordered table-hover" id="dataTables-example">

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

                                                            <c:forEach var="liv" items="${listliv}">
                                                                <tr>
                                                                    <td>
                                                                        <c:out value="${liv.idLivre}" />
                                                                    </td>
                                                                    <td>
                                                                        <c:out value="${liv.dateEdit}"></c:out>
                                                                    </td>
                                                                    <td>
                                                                        <c:out value= "${liv.titre}"></c:out> 
                                                                    </td>
                                                                    <td>
                                                                         <c:out value="${liv.isbn}"/> </td>
                                                                    <td>
                                                                        <c:out value="${liv.nomAut}"></c:out>
                                                                    </td>
                                                                    <td>
                                                                        <c:out value="${liv.categorie }" /> </td>
                                                                    <td>
                                                                        <c:out value="${liv.quantite }" />
                                                                    </td>
                                                                    <td>
                                                                  
                                                                    	<div class="row">
                                                                    		<div class="col-md-4">
                                                                         <a href="<c:url value=" /Servmodification "><c:param name = "id " value="${liv.idLivre} "/> </c:url>" class="btn btn-default btn-xs" data-toggle="modal" data-target="#monModal<c:out value="${liv.idLivre}" />">
                                                    <i class=" fa fa-edit "></i>
                                                    </a>
                                                    </div>
                                                    
                                                    <div class="col-md-6">
                                                                         <a href="<c:url value=" /Servmodal "><c:param name = "id " value="${liv.idLivre} "/> </c:url>" class="btn btn-info btn-xs" data-toggle="modal" data-target="#myModal<c:out value="${liv.idLivre}" />">
                                                   empr
                                                    </a>
                                                    </div>
                                                    
                                                   
                                                    </div>
                                                               </td>
                                                                </tr>

                                                                <div class="row">
                                                                <form action="Servemprbi" method="Post">  
                                                                
                                                                    <div class="modal fade" id='myModal<c:out value="${liv.idLivre}" />' tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                                                        <div class="modal-dialog">
                                                                            <div class="modal-content">
                                                                                <div class="modal-header">
                                                                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                                                                    <h4 class="modal-title" id="myModalLabel">page d'emprunt</h4>
                                                                                </div>
                                                                                <div class="modal-body">
                                                                                    
                                                                                   
                                                                                     <div class="form-group">
      <label class="control-label" for="text">titre du livre</label>
      <input id="Nom" type="text" class="form-control" placeholder="nom" required="required" name="titre" value="<c:out value="${liv.titre}"/>">
      
  </div>
  
  <div class="form-group">
      <label class="control-label" for="text">nom emprunteur</label>
      <input id="Nom" type="text" class="form-control" placeholder="emprunteur" required="required" name="emprunteur" value=""/>
      
  </div>
  
  <div class="form-group">
      <label class="control-label" for="text">prenom emprunteur</label>
      <input id="Nom" type="text" class="form-control" placeholder="nom" required="required" name="prenom" value=""/>
      
  </div>
                                                                                    <input type="hidden" name="idliv" value="${liv.idLivre}"> 
                                                                                    
                                                                                   
                                                                                </div>
                                                                                <div class="modal-footer">
                                                                                    
                                                                                    <button type="submit" class="btn btn-primary"> <span class="glyphicon glyphicon-checkmark"></span>emprunter</button>
                                                                                     <button type="button" class="btn btn-default" data-dismiss="modal">Close</button> 
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                    </div>
                                                      
                                          </form>
                                                                </div>
                                                                
                                                                
                                                        
                                                        
                                                       <div class="modal fade" id='monModal<c:out value="${liv.idLivre}" />' tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                     <form class="we col-md-8" autocomplete="off" method="POST" action="Servmodification">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                            <h4 class="modal-title" id="myModalLabel">page de modification</h4>
                                        </div>
                                        <div class="modal-body">
                                        
                                       

                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Titre</label>
                                                            <input id="Nom" type="text" class="form-control" placeholder="titre" name="titre" required="required" value="${liv.titre}">
                                                            <input type="hidden" name="idliv" value="${liv.idLivre}">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="text">nombre exemplaire</label>
                                                            <input id="Nom" type="number" min="1" max="9" class="form-control" placeholder="titre" name="quantite" required="required" value="${liv.quantite }">
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Categorie</label>
                                                            <select class="form-control" name="categorie">
                                                            <option value="informatique">informatique</option>
                                                            <option value="mathematique">mathematiques</option>
                                                            <option value="chimie" >chimie</option>
                                                            <option value="litterature">litterature afr</option>
                                                        </select>
                                                        </div>

                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Isbn</label>
                                                            <input id="Nom" type="text" class="form-control" placeholder="Isbn" name="isbn" required="required" value="${liv.isbn}">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Date d edition</label>
                                                            <input id="Nom" type="Date" class="form-control" placeholder="Isbn" name="dat" required="required" value="${liv.dateEdit}">
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="control-label" for="text">Nom auteur</label>
                                                            <input id="Nom" type="text" class="form-control" placeholder="auteur" name="nom" required="required" value="${liv.nomAut}">
                                                        </div>
                                                        
                                            
                                        </div>
                                        <div class="modal-footer">
                                        	 <button type="submit" class="btn btn-default" name="modifer"><i class=" fa fa-edit "></i>modifier</button>	
                                        	<!--   <button type="submit" class="btn btn-danger" name="suppr"><span class="glyphicon glyphicon-trash"></span>Supprimer</button> -->
                                        	  <a href = "<c:url value="/Servmodification"><c:param name = "id" value="${liv.idLivre}"/> </c:url>" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span>Supprimer</a>
                                                    
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                           
                                        </div>
                                       </form>   
                                    </div>
                                </div>
                            </div>         

                                                            </c:forEach>


                                                        </tbody>
                                           
                                                    </table>

                                         .</p> 
                                            </div>
                                            
                                            <div class="tab-pane fade" id="messages">
                                                <h4>Demende en cours</h4>
                                                <p>
                                                	<c:choose>
                                                		<c:when test="${not empty listemp }">
                                                 <table class="table table-striped table-bordered table-hover" id="dataTables-example">

                                                        <thead>
                                                            <tr>
                                                                <th>nom emp.</th>
                                                                <th>prenom </th>
                                                                <th>titre du livre</th>
                                                                <th>auteur</th>
                                                                <th>Date de la demande </th>
                                                                
                                                                <th> # #</th>
                                                            </tr>
                                                        </thead>
                                                  
                                                        <tbody>
                                                        	<c:forEach var="list" items="${listemp}">
                                                        		 <form action="Servvalidemp" method="Post"> 
                                                        	<tr>
                                                        		<td> <c:out value="${list.nom }"></c:out></td>
                                                        		
                                                        		<td> <c:out value="${list.prenom }"></c:out> </td>
                                                        		
                                                        		<td> <c:out value="${list.titreliv }"></c:out></td>
                      
                                                        		<td> <c:out value="${list.datesor }"/>  </td>
                                                        		<td> <c:out value="${list.nomaut }"></c:out>
                                                        		<input type="hidden" name ="nomadh"  value="${list.nom}"/>
                                                        		<input type="hidden" value="${list.prenom}" name="prenoma"/>
                                                        		<input type="hidden" name="idliv" value="${list.idliv }"/>
                                                        		<td><button type="submit" class="btn btn-success" name="valide"><span ></span>Valider</button> </td>
                                                        	</tr>
                                                        	  </form>
                                                        	</c:forEach>
                                                        	
                                                        </tbody>
                                                     
                                                        </table>
                                                       
                                                        </c:when>
                                                        <c:otherwise><c:out value="aucune demande en cours de traitement"></c:out> </c:otherwise>
                                                      </c:choose>  
                                                     .</p>
                                            </div>
                                            
                                           
                                            	   <div class="tab-pane fade" id="settings">
                                                <h4>listes des documents empruntes</h4>
                                                <p>
                                                	<c:choose>
                                                		<c:when test="${not empty listaff}">
                                                			 <table class="table table-striped table-bordered table-hover" id="dataTable-example">

                                                        <thead>
                                                            <tr>
                                                                <th>nom emp.</th>
                                                                <th>prenom </th>
                                                                <th>titre du livre</th>
                                                                <th>auteur</th>
                                                                <th>Date de la demande </th>
                                                                <th> Date de retour</th>
                                                                <th> confirme retour</th>
                                                            </tr>
                                                        </thead>
                                                        	<tbody>
                                                        		<c:forEach var="affch" items="${ listaff}">
                                                        			<tr>
                                                        				<td> <c:out value="${affch.nom}"></c:out></td>
                                                        				<td> <c:out value="${affch.prenom}"></c:out></td>
                                                        				<td> <c:out value="${affch.titreliv}"></c:out></td>
                                                        				<td> <c:out value="${affch.nomaut}"></c:out></td>
                                                        				<td> <c:out value="${affch.datesor}"></c:out></td>
                                                        				<td> <c:out value="${affch.dateret}"></c:out></td>
                                                        				<td> <a href = "<c:url value="/Servretliv"><c:param name = "id" value="${affch.idliv}"/><c:param name = "nom" value="${affch.nom}"/><c:param name = "prenom" value="${affch.prenom}"/> </c:url>" class="btn btn-success"><span class="glyphicon glyphicon-ok"></span> retour</a></td>
                                                        			</tr>
                                                        		
                                                        		</c:forEach>
                                                        	
                                                        	</tbody>
                                                        	</table>
                                                		
                                                		</c:when>
                                                		<c:otherwise><c:out value="Aucn pret est effectue"></c:out> </c:otherwise>
                                                	
                                                	</c:choose>
                                                	
                                                </p>
                                                </div>
                                            
                                           
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                        // </div>
              ///<!-- </div> -->>  

                <!-- CONTENT-WRAPPER SECTION END-->
                <footer>
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12">
                                &copy; ifi_p22 projet genie logiciel | par : <a href="http://www.designbootstrap.com/" target="_blank">zacharie brahim adama bangadingar</a>
                            </div>

                        </div>
                    </div>
                </footer>
                <!-- FOOTER SECTION END-->
                <!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
                <!-- CORE JQUERY SCRIPTS -->
                <script src="styl/assets/js/jquery-1.11.1.js"></script>
                <!-- BOOTSTRAP SCRIPTS  -->
                <script src="styl/assets/js/bootstrap.js"></script>
                </div>
                
                
                <script src="styl/plugins/dataTables/jquery.dataTables.js"></script>
    <script src="styl/plugins/dataTables/dataTables.bootstrap.js"></script>
    <script>
        $(document).ready(function () {
            $('#dataTables-example').dataTable();
        });
    </script>
     <script>
        $(document).ready(function () {
            $('#dataTable-example').dataTable();
        });
    </script>
        </body>

        </html>