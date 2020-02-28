<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="lib/css/gestclients.css" rel="stylesheet" type="text/css"/>
        <link href="lib/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="lib/bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <title>Convertisseur</title>
    </head>
    <body class="body">
        
        <div class="container">
            <form class="form-horizontal" role="form" name="frmConv" action="convertir.cf" method="post">   
                <h1 style="text-align: center">Convertisseur de températures</h1>
                <div class="form-group">
                    <label class="col-md-3 control-label">Sens : </label>
                    <div class="col-md-3">
                        <select class='form-control' name='cbChoix' required>
                            <option value="cf">Celsius => Fahrenheit</option>
                            <option value="fc">Fahrenheit => Celsius</option>
                        </select>
                    </div>
                </div> 
                <div class="form-group">
                    <label class="col-md-3 control-label">Valeur : </label>
                    <div class="col-md-2">
                        <input type="text" name="degre" value="${degre}" class="form-control" placeholder="Degré ?" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-md-3 control-label">Résultat : </label>
                    <div class="col-md-2">
                        <input type="text" name="resultat" value="${resultat}" class="form-control" readonly="true">
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-md-4 col-md-offset-4">
                        <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span> Valider</button>
                    </div>           
                </div>
                <div class="form-group" >
                    <div class="col-md-5  col-md-offset-3">
                        <div class="alert-danger" role="alert">
                            <c:if test="${erreur != null}">                    
                                <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                                <c:out value="${erreur}"/>                            
                            </c:if>
                        </div>
                    </div>
                </div>

            </form>
    </body>
</html>
