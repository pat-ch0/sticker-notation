
<#ftl encoding="utf-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<body xmlns="http://www.w3.org/1999/html">

<h1>Liste des gommettes</h1>
<ul>
    <#list goms as gom>
        <li>${gom}</li>
    </#list>
</ul>

<#if etats != -1 && etats != 0 && etats != -2>
    <h1>Ajout d'une gommette</h1>
    <form method='post' action="/goms" enctype='multipart/form-data'>
        <p>Couleur ("Rouge", "Blanc" ou "Vert")</p> <input type="text" name="Color">
        <p>Description</p> <input type="text" name="Desc">
        <input type="submit" value="Ajouter">
    </form>

    <h1>Suppression d'une gommette</h1>
    <p>Saisissez dans l'URL l'id de l'eleve tel que /goms/id-gom-a-saisir/delete</p>
    </body>

    <h1>Modifification d'une gommette</h1>
    <form method='post' action="/goms/edit" enctype='multipart/form-data'>
        <p>Id gommette</p> <input type="text" name="Id">
            <p>Nouvelle Couleur</p> <input type="text" name="NColor">
            <p>Nouvelle Description</p> <input type="text" name="NDesc">
        <input type="submit" value="Modifier">
    </form>
</#if>
