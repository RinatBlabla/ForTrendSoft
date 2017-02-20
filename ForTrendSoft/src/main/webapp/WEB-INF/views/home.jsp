<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Your news catalog</title>
</head>
<body>
<form method = "POST" action="create-news">
<h1>
	News:   
</h1>

<div class="content" id="Div">
	
   <p>
   	<select id="categoryList" onchange=" selectByCategory(this.value)">
   		<option>All categories</option>
   	</select>
   </p>
	<ul class="main-ul" id="ul1"> 
	</ul>
</div>
<input type="submit" value="Create news"/>
</form>
<script  type="text/javascript">
document.body.onload = function() {
	myFunction();
	categoryListFunction();
	};
var fh1=[];
fh1 =JSON.parse('${getNewsList}');
var fh2=[];
fh2 =JSON.parse('${getCategoryList}');
function myFunction() 
{
	console.log(fh1.length);
	for(var i=0;i<fh1.length;i++)
	{
		var x=[];
		var liParam = document.createElement("LI");
		x = fh1[i];

		
		var date = document.createElement("A");
		var t1 = document.createTextNode(x[2]);     
		date.appendChild(t1);
		
		var newsTitle = document.createElement("A");
		var t2 = document.createTextNode(x[0]);      
		newsTitle.appendChild(t2);
		
		var category = document.createElement("A");
		var t3 = document.createTextNode(x[3]);     
		newsTitle.appendChild(t3);
		
		liParam.appendChild(date);
		liParam.appendChild(newsTitle);
		document.getElementById("ul1").appendChild(liParam);
	}
}
function categoryListFunction() 
{
	console.log(fh2.length);
	for(var i=0;i<fh2.length;i++)
	{
		var x=[];
		console.log(fh2[i]);
		x = fh2[i];
		var optParam = document.createElement("OPTION");
		var t1 = document.createTextNode(x[1]);      
		optParam.appendChild(t1);
		optParam.setAttribute("value", x[1]); 
		document.getElementById("categoryList").appendChild(optParam);
	}
}
function selectByCategory(selectedValue)
{
	console.log('selectedValue = ' + selectedValue);
	while (list.hasChildNodes())
 	{
        list.removeChild(list.firstChild);
  	}	
	if(selectedValue == 'All categories')
	{
		myFunction();
	}
	if(selectedValue != 'All categories')
	{
		var list = document.getElementById("ul1");
		console.log('test1');
		for(var i=0;i<fh1.length;i++)
		{
			console.log(fh1[i]);
			var x=[];
			x = fh1[i];
			console.log('x1 = ' + x);
			if(x[3] == selectedValue)
			{
				var date = document.createElement("A");
				var t1 = document.createTextNode(x[2]);    
				date.appendChild(t1);
				
				var newsTitle = document.createElement("A");
				var t2 = document.createTextNode(x[0]);    
				newsTitle.appendChild(t2);
				
				var category = document.createElement("A");
				var t3 = document.createTextNode(x[3]);   
				newsTitle.appendChild(t3);
				
				liParam.appendChild(date);
				liParam.appendChild(newsTitle);
				document.getElementById("ul1").appendChild(liParam);
			}
		}	
	}
}
</script>
</body>
</html>
