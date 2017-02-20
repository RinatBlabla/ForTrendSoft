<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>admin</title>
</head>
<body>
<p>Hello </p>
<form method = "POST" action="test">
			<p>Title<input type = "text" name ="title"/> </p>
			
			<p>Content<input type = "text" name ="content"/></p>
   <p>
   	<select name ="category" id="categoryList">
   	</select>
   </p>
<input type="submit" value="Create"/>
</form>
<script  type="text/javascript">
document.body.onload = function() {
	categoryListFunction();
	};
	console.log('test1');
	var fh1=[];
	fh1 =JSON.parse('${getCategoryList}');
function categoryListFunction() 
{
	for(var i=0;i<fh1.length;i++)
	{
		var x=[];
		console.log(fh1[i]);
		x = fh1[i];
		var optParam = document.createElement("OPTION");
		var t1 = document.createTextNode(x[1]);     
		optParam.appendChild(t1);
		optParam.setAttribute("value", x); 
		document.getElementById("categoryList").appendChild(optParam);
	}
}
</script>
</body>
</html>