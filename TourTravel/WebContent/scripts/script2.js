(function(){
	
	button1 = document.getElementById("button1");
	
	button1.addEventListener('click', function(){
		document.getElementById("div1").style.display = "block";
		document.getElementById("div2").style.display = "none";
		document.getElementById("div3").style.display = "none";
		document.getElementById("div4").style.display = "none";
	});
	
	button2 = document.getElementById("button2");
	
	button2.addEventListener('click', function(){
		document.getElementById("div1").style.display = "none";
		document.getElementById("div2").style.display = "block";
		document.getElementById("div3").style.display = "none";
		document.getElementById("div4").style.display = "none";
	});
	
	button3 = document.getElementById("button3");
	
	button3.addEventListener('click', function(){
		document.getElementById("div1").style.display = "none";
		document.getElementById("div2").style.display = "none";
		document.getElementById("div3").style.display = "block";
		document.getElementById("div4").style.display = "none";
	});
	
})();
