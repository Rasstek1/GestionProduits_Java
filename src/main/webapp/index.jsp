<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>


<a href="<%=request.getContextPath()%>/listproduits">Allez a la liste de produits</a>


<img src="<%=request.getContextPath()%>/res/image/R.jpg" alt="produit" style="width:100px;">

</br>

</body>
</html>