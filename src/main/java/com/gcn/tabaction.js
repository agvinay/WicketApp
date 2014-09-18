

function tab_change(tab){ 
	if(tab == "offer"){
		document.getElementById("offer").style.background = "#336799";
		document.getElementById("offer").style.color = "#ffffff";
		
		document.getElementById("want").style.background = "#eef2f3";
		document.getElementById("want").style.color = "#336799";
	}
	else if(tab == "want"){
		document.getElementById("want").style.background = "#336799";
		document.getElementById("want").style.color = "#ffffff";
		
		document.getElementById("offer").style.background = "#eef2f3";
		document.getElementById("offer").style.color = "#336799";
	}
}

function sub_tab_change(subtab){
	if(subtab == "product"){
		document.getElementById("product").style.background = "#336799";
		document.getElementById("product").style.color = "#ffffff";
		
		document.getElementById("service").style.background = "#eef2f3";
		document.getElementById("service").style.color = "#336799";
		
		document.getElementById("job").style.background = "#eef2f3";
		document.getElementById("job").style.color = "#336799";
	}
	else if(subtab == "service"){
		document.getElementById("product").style.background = "#eef2f3";
		document.getElementById("product").style.color = "#336799";
		
		document.getElementById("service").style.background = "#336799";
		document.getElementById("service").style.color = "#ffffff";
		
		document.getElementById("job").style.background = "#eef2f3";
		document.getElementById("job").style.color = "#336799";
	}
	else if(subtab == "job"){
		document.getElementById("product").style.background = "#eef2f3";
		document.getElementById("product").style.color = "#336799";
		
		document.getElementById("service").style.background = "#eef2f3";
		document.getElementById("service").style.color = "#336799";
		
		document.getElementById("job").style.background = "#336799";
		document.getElementById("job").style.color = "#ffffff";
	}
}