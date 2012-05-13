<%-- 
    Document   : search
    Created on : Apr 4, 2012, 7:35:14 PM
    Author     : mtnauha
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wadharkka</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- Le styles -->
        <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
        <style type="text/css">
            body {
                padding-top: 60px;
                padding-bottom: 40px;
            }
        </style>
        <link href="http://twitter.github.com/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">

        <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <!-- Le fav and touch icons -->
        <link rel="shortcut icon" href="../assets/ico/favicon.ico">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
    </head>

    <body>

        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </a>
                    <a class="brand" href="#">Wadharkka</a>
                    <div class="nav-collapse">
                        <ul class="nav">
                            <li><a href="${pageContext.request.contextPath}/user/home">Home</a></li>
                            <li><a href="${pageContext.request.contextPath}/user/search">Search</a></li>
                            <li><a href="${pageContext.request.contextPath}/user/userlist">List all users</a></li>

                            <li class="divider-vertical"></li>

                            <li class="active"><a href="${pageContext.request.contextPath}/user/profile/${principalName}">${principalName}</a></li>
                            <li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container">

            <!-- Example row of columns -->
            <div class="row">
                <div class="span4">
                    <h2>&lt;${user.username}&gt;</h2>
                    <ul class="thumbnails">
                        <li class="span4">
                            <a href="#" class="thumbnail">
                                <img src="${pageContext.request.contextPath}/image/${user.profileId}" />
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="span8">
                    <h2>Pictures</h2>
                    <ul class="thumbnails" id="pictures">
                        <c:forEach var="image" items="${images}">
                            <li class="span2">
                                <a href="${pageContext.request.contextPath}/user/profile/${user.username}/${image.id}" class="thumbnail" style="text-align:center">
                                    <img src="${pageContext.request.contextPath}/image/${image.id}">
                                    ${image.description}
                                </a>
                                <sec:authorize access="hasRole('${user.username}')">
                                    <div class="btn-group">
                                        <a class="btn btn-mini dropdown-toggle" data-toggle="dropdown" href="#">
                                            Select action
                                            <span class="caret"></span>
                                        </a>
                                        <ul class="dropdown-menu">
                                            <li>
                                                <a class="setprofile" id="${image.id}" href="#">Set as profile</a>
                                            </li>
                                            <li>
                                                <a class="delete" id="${image.id}" href="#">Delete</a>
                                            </li>
                                        </ul>
                                    </div>
                                </sec:authorize>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>

            <sec:authorize access="hasRole('${user.username}')">
                <div class="row">
                    <div class="span8">
                        <h2>Add images</h2>
                        <form class="form-horizontal" id="form2" enctype="multipart/form-data">
                            <fieldset>
                                <legend>Upload one or more images</legend>
                                <div class="control-group">
                                    <label class="control-label" for="files">Select images</label>
                                    <div class="controls">
                                        <input type="file" name="files[]" id="files" multiple />
                                    </div>
                                </div>

                                <div class="control-group">
                                    <label class="control-label" id="progressLabel" for="files">Progress</label>
                                    <div class="controls">
                                        <div class="progress">
                                            <div id="progressbar" class="bar" style="width: 0%;"></div>
                                        </div>
                                    </div>
                                </div>

                                <div id="descs"></div>

                                <div class="control-group">
                                    <div class="controls">
                                        <input type="button" id="uploadButton" value="Upload" onclick="startRead()"/>
                                    </div>
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </sec:authorize>

            <div id="progressNumber"></div>

            <hr>

            <footer>
                <p>&copy; Matti Nauha 2012</p>
            </footer>

        </div> <!-- /container -->

        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="http://twitter.github.com/bootstrap/assets/js/jquery.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-transition.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-alert.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-modal.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-dropdown.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-scrollspy.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-tab.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-tooltip.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-popover.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-button.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-collapse.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-carousel.js"></script>
        <script src="http://twitter.github.com/bootstrap/assets/js/bootstrap-typeahead.js"></script>
        <script>
            $(".delete").click(function() {
                var target = $(this).attr("id");
                
                $.ajax({
                    url: '${pageContext.request.contextPath}/image/' + target,
                    type: 'DELETE',
                    success: function(result) {
                        location.reload();
                    }
                });
            });
            
            $(".setprofile").click(function() {
                var target = $(this).attr("id");
                
                $.ajax({
                    url: '${pageContext.request.contextPath}/image/setprofile/' + target,
                    type: 'POST',
                    success: function(result) {
                        location.reload();
                    }
                });
            });
            
            var filesTotalSize = 0;
            var percentComplete = 0;
            
            //Create description input boxes for selected image files
            $('#files').change(function() {
                var files = document.getElementById('files').files;
                filesTotalSize = 0;
                
                var len = files.length;
                for (var i = 0; i < len; i++) {
                    var f = files[i];
                    
                    // Only process image files.
                    if (!f.type.match('image.*')) {
                        continue;
                    }
                    
                    var text = f.name + " Description";
                    filesTotalSize = filesTotalSize + f.size;
                    
                    $('#descs').append('<div class="control-group">\n\
                                            <label class="control-label" for="description">' + text + '</label>\n\
                                                <div class="controls">\n\
                                                    <input type="text" id="description' + i + '" name="description">\n\
                                                </div>\n\
                                         </div>');
                    
                }
            });
            
            $('#uploadButton').click(function() {
                //FileList object
                var files = document.getElementById('files').files;
                if(files){
                    getAsDataURL(files);
                }
            });
            
            var filesReady = 0;
            var filesTotal = 0;
            
            function getAsDataURL(files) {
                
                filesReady = 0;
                
                // Loop through the FileList
                filesTotal = files.length;
                
                for (var i = 0; i < filesTotal; i++) {
                    var f = files[i];
                    
                    // Only process image files.
                    if (!f.type.match('image.*')) {
                        continue;
                    }
                    
                    var reader = new FileReader();
                    
                    // Read in the image file as a data URL.
                    reader.readAsDataURL(f);
                    
                    var descriptionId = "#" + "description" + i;
                    var description = $(descriptionId).val();
                    
                    //reader.onprogress = updateProgress;
                    
                    reader.onload = sendData(f, description);
                    
                    //reader.onloadend = refreshPage;
                    
                    //refresh page after changes
                    //location.reload();
                    
                }
            }
            
            function updateProgress(evt) {
                if (evt.lengthComputable) {

                    var percentLoaded = Math.round((evt.loaded / evt.total) * 100);

                    if (percentLoaded <= 100) {
                        // Increase the prog bar length
                        $("#progressbar").css({width: percentLoaded + "%"});
                    }
                }
            }
            
            function sendData(theFile, description) {
                var data = new FormData();
                data.append("description", description);
                data.append("filu", theFile);
                
                var xhr = new XMLHttpRequest();
                xhr.upload.addEventListener("progress", uploadProgress, false);
                xhr.addEventListener("load", uploadComplete, false);
                xhr.addEventListener("error", uploadFailed, false);
                xhr.addEventListener("abort", uploadCanceled, false);
                
                xhr.open('POST', '${pageContext.request.contextPath}/image');
                
                filez = theFile.name;
                
                xhr.send(data);
                
            }
            
            function uploadProgress(evt) {
                if (evt.lengthComputable) {
                    percentComplete = percentComplete + (evt.loaded / filesTotalSize);
                    filesTotalSize = filesTotalSize + evt.loaded;
                    var totalComplete = Math.round(percentComplete * 100);
                    
                    $("#progressbar").css({width: totalComplete + "%"});
                    //document.getElementById('progressNumber').innerHTML = totalComplete.toString() + '%';
                }
                else {
                    $("#progressbar").append("unable to compute");
                }
            }

            function uploadComplete(evt) {
                //This event is raised when the server send back a response
                filesReady++;
                
                //Reload page after sending all images
                if(filesReady >= (filesTotal-1))
                    location.reload();
            }

            function uploadFailed(evt) {
                alert("There was an error attempting to upload the file.");
            }

            function uploadCanceled(evt) {
                alert("The upload has been canceled by the user or the browser dropped the connection.");
            } 
        </script>

    </body>
</html>