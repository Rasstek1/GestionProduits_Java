<%--
  Created by IntelliJ IDEA.
  User: nitra
  Date: 2023-08-29
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.rasstek.gestionproduits.mesModels.Produit" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste Produits</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
</head>
<body>
<h1>La list des produits</h1>
<table class="table">
    <tr><th>Numéro</th><th>Description</th><th>Prix</th><th>Commande</th>
            <% for(Produit p:(List<Produit>)request.getAttribute("listeproduits")){%><!--Recoit l'objet des produits du servlet request-->
    <tr><td><%= p.getNumero()%> </td><td><%= p.getDescription() %> </td>
        <td><%= p.getPrix()%> </td>

    <td>
        <a href="<%=request.getContextPath()%>/listproduits?numero=<%= p.getNumero()%>" >Supprimer</a>

        <form action="<%=request.getContextPath()%>/listproduits" method="post">
            <input type="hidden" name="numero" value="<%= p.getNumero()%>">
            <input type="submit" value="Supprimer" class="styled-button">
        </form>

    </td>
</tr>




    <%}%>
</table>
<style>
.styled-button {
background-color: #4CAF50; /* Couleur de fond */
color: white; /* Couleur du texte */
border: none; /* Pas de bordure */
padding: 10px 20px; /* Espacement intérieur */
text-align: center; /* Alignement du texte */
text-decoration: none; /* Pas de soulignement */
display: inline-block; /* Affichage en ligne */
font-size: 16px; /* Taille de la police */
margin: 4px 2px; /* Marge extérieure */
cursor: pointer; /* Curseur pointeur */
border-radius: 5px; /* Coins arrondis */
}

.styled-button:hover {
background-color: #45a049; /* Couleur de fond au survol */
}
</style>

</body>
</html>
