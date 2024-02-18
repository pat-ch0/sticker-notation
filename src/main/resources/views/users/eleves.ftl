
<#ftl encoding="utf-8">
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<body xmlns="http://www.w3.org/1999/html">

<h1>Liste des eleves</h1>

<ul>
    <#list eleves as eleve>
        <li>${eleve}</li>
    </#list>
</ul>

    
        <#if etats != -1 && etats != 0 && etats != -2>
                <h1>Ajout d'un(e) eleve</h1>
                <form method='post' action="/eleves" enctype='multipart/form-data'>
                    <p>Nom</p> <input type="text" name="LastName">
                    <p>Prenom</p> <input type="text" name="FirstName">
                    <input type="submit" value="Ajouter">
                </form>
                <h1>Suppression d'un(e) eleve</h1>
                <p>Saisissez dans l'URL l'id de l'eleve tel que /eleves/id-eleve-a-saisir/delete</p>
                <h1>Modifier un eleve</h1>
                <form method='post' action="/eleves/edit" enctype='multipart/form-data'>
                    <p>Id de l'eleve</p> <input type="text" name="Id">
                    <p>Nouveau Nom</p> <input type="text" name="NLastName">
                    <p>Nouveau Prenom</p> <input type="text" name="NFirstName">
                    <input type="submit" value="Modifier">
                </form>
        </#if>

</body>





