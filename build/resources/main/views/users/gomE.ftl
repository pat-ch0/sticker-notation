
<#ftl encoding="utf-8">
<body xmlns="http://www.w3.org/1999/html">

<h1>Liste des gommettes attribuées</h1>
<ul>
    <#list gomE as gome>
        <li>${gome}</li>
    </#list>
</ul>

<h1>Affichage de la liste d'un eleve en particulier</h1>
<p>Saisissez dans l'URL l'id de l'eleve tel que /eleves/id-a-saisir/goms</p>

    <#if etats != -1 && etats != 0 && etats != -2>
            <h1>Ajout d'une gommette à un(e) eleve</h1>
            <form method='post' action="/eleves/goms/add" enctype='multipart/form-data'>
                <p>Id eleve</p> <input type="text" name="IdEleve">
                <p>Id gommette</p> <input type="text" name="IdGom">
                <p>Raison</p> <input type="text" name="Raison">
                <input type="submit" value="Ajouter">
            </form>

            <h1>Suppression d'une gommette d'un(e) eleve</h1>
            <p>Saisissez dans l'URL l'id de l'eleve tel que /eleves/goms/id-gomatt-a-saisir/delete</p>
    </#if>

</body>
