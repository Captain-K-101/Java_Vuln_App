<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Profile

<div id="inserted"></div>

<button onClick="GETDAILYREWARD()">Daily Reward</button>

<button onClick="Serializeable()">Serialize</button>


<script>
async function runner(){	
await fetch("./Auth", {
    method: "POST",
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    }
}).then(function (a) {
	 if (a.redirected) {
		 window.location='./memberreg.jsp';
	 }
        return a.json(); // call the json method on the response to get JSON
    }).then(function (json) {
        var data=json.data.names.split(':')
        const para = document.createElement("p");
		para.innerHTML = "Name:"+data[0]+"<br>Email:"+data[1];
		localStorage.setItem("Name",data[0]);
		document.body.appendChild(para);
    })
}
runner();

async function GETDAILYREWARD(){

	const data="name="+localStorage.getItem('Name')+"&type=dailyreward"
	await fetch('./ProfileStuff',{
		method:"POST",
	    headers: {
	    	"Content-Type": "application/x-www-form-urlencoded"
	    },
	    body:data
	}).then((res)=>{
		console.log("YEET")
	})

}

async function Serializeable(){

	const data="name="+localStorage.getItem('Name')+"&type=serialize"
	await fetch('./ProfileStuff',{
		method:"POST",
	    headers: {
	    	"Content-Type": "application/x-www-form-urlencoded"
	    },
	    body:data
	}).then((res)=>{
		console.log("YEET")
	})

}
</script>
</body>
</html>