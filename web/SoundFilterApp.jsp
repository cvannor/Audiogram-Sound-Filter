<%-- 
    Document   : SoundFilterApp
    Created on : Mar 7, 2018, 11:40:51 PM
    Author     : Curtis Vannor <cvannor@uab.edu>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Style.css" />
        <link href="${pageContext.request.contextPath}/bootstrap-4.3.1-dist/css/bootstrap.css" rel="stylesheet">
        <title>AUDIOGRAM SOUND FILTER</title>
    </head>
    <body class="text-center body-main">
        <div class="cover-container d-flex h-100 p-3 mx-auto flex-column">
          <main role="main" class="inner cover">
            <h1 class="cover-heading">The Audiogram Sound Filter App</h1>
            <p class="lead">This app allows you  simulate hearing disabilities based on medical
            audiogram parameters.</p>
            <p class="lead">
                <h2>Choose audio file below:</h2>
                <form method="POST" action="FileUploadServlet" enctype="multipart/form-data" >
                    <input class="file-btn btn btn-lg btn-secondary" type="file" name="file" accept=".wav" /> <br/>
                    <input class="btn btn-lg btn-secondary" type="submit" value="Upload" name="upload" id="upload" />
                </form>
            </p>
          </main>
        </div>
    
        
    </body>
    
</html>
