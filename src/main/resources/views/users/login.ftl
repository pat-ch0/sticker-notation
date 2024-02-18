
<#ftl encoding="utf-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<body xmlns="http://www.w3.org/1999/html">

<h1>Connexion</h1>
<form method='post' action="/login" enctype='multipart/form-data'>
    <p>Nom d'utilisateur</p> <input type="text" name="Username">
    <p>Mot de passe</p> <input type="text" name="Password">
    <input type="submit" value="Se connecter">
</form>

<ul>
    <#list msgs as msg>
        <p>${msg}</p>
    </#list>
</ul>



<form method='post' action="/login/invite" enctype='multipart/form-data'>
    <input type="submit" value="Mode invité">
</form>

</body>