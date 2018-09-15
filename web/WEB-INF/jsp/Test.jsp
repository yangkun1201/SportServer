<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
</head>
<body>
	<button type="" onclick="postJson()">提交</button><br/>
	<h1 id="name">123</h1>
	<script>
		function postJson(){
    	var json = {"id" : "1", "name" : "yangkun","password" : "123456","sex" : "123456","school_name" : "123456","department_name" : "123456"
    	,"major_name" : "123456","classname" : "123456","enrolment_time" : "123456","tel" : "123456","identity" : "123456"};
   		$.ajax({  
               type: "POST",  
			   contentType : 'application/json;charset=utf-8',
               url:  'http://localhost:8080/SportServer/test',  
               dataType: "json",  
               data:JSON.stringify(json),
               success: function(data){  
                    console.log(data.name);
                    $('#name').html(data.name);
               }  
           });   
	}
	</script>
</body>
</html>