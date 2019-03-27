<%-- 
    Document   : InputParams
    Created on : Feb 18, 2019, 3:44:27 AM
    Author     : Curtis Vannor <cvannor@uab.edu>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/Style.css" />
        <link href="${pageContext.request.contextPath}/bootstrap-4.3.1-dist/css/bootstrap.css" rel="stylesheet">
        <title>Input Parameters</title>
    </head>
    <body class="text-center body-second">
        <form method="POST" action="FormExecute" enctype="multipart/form-data">
            <textarea class="hide-this" name="homepath">${filePath}</textarea>
            <div class="form-group">
            <h4>Choose Frequency(Pitch) in Hz: </h4>
            <label class="container">125 (lowest)
              <input type="radio" checked="checked" name="radio">
              <span class="checkmark"></span>
            </label>
            <label class="container">250
              <input type="radio" name="radio">
              <span class="checkmark"></span>
            </label>
            <label class="container">500
              <input type="radio" name="radio">
              <span class="checkmark"></span>
            </label>
            <label class="container">1000
              <input type="radio" name="radio">
              <span class="checkmark"></span>
            </label>
            <label class="container">2000
              <input type="radio" name="radio">
              <span class="checkmark"></span>
            </label>
            <label class="container">3000
              <input type="radio" name="radio">
              <span class="checkmark"></span>
            </label>
            <label class="container">4000
              <input type="radio" name="radio">
              <span class="checkmark"></span>
            </label>
            <label class="container">8000 (highest)
              <input type="radio" name="radio">
              <span class="checkmark"></span>
            </label>
            </div>
            <div class="slidecontainer">
                <h4>Drag green block to set hearing level(dB): </h4>
                <input type="range" min="0" max="120" value="0" class="slider" id="myRange">
            </div>
            <p id="value"></p>
            <h3 id="classification"></h3>
            <script>
                var slider = document.getElementById("myRange");
                var output = document.getElementById("classification");
                var valueBox = document.getElementById("value");
                output.innerHTML = "Normal Hearing";
                valueBox.innerHTML = "0 dB";
                // Update the current slider value (each time you drag the slider handle)
                slider.oninput = function() {
                    valueBox.innerHTML = this.value + "dB";
                    if(slider.value <= 15){
                        output.innerHTML = "Normal Hearing";
                    }else if(slider.value >15 && slider.value <= 25 ){
                        output.innerHTML = "Slight Hearing Loss";  
                    }else if(slider.value >25 && slider.value <= 40 ){
                        output.innerHTML = "Mild Hearing Loss";  
                    }else if(slider.value >40 && slider.value <= 55 ){
                        output.innerHTML = "Moderate Hearing Loss";  
                    }else if(slider.value >55 && slider.value <= 70 ){
                        output.innerHTML = "Moderately Severe Hearing Loss";  
                    }else if(slider.value >70 && slider.value <= 90 ){
                        output.innerHTML = "Severe Hearing Loss";  
                    }else if (slider.value >90){
                        output.innerHTML = "Profound Hearing Loss";  
                    }
                }
            </script>
            <input class="btn btn-primary" type="submit" value="Process Audio" name="process" />
        </form>
        
    </body>
</html>
