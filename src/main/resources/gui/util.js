window.addEventListener("load", () => {
	var toast = document.createElement("div");
	toast.id = "error";
	toast.className = "toast toast-error";
	toast.style.display = "none";
	toast.style.position = "fixed";
	toast.style.bottom = "8px";
	toast.style.right = "8px";
	toast.style.width = "initial";
	document.body.appendChild(toast);
});

function $(id) {
	return document.getElementById(id);
}

function post(uri, params, onload) {
	event.preventDefault();
	var request = new XMLHttpRequest();
	request.onload = () => {
		var json = JSON.parse(request.responseText);
		if(onload) onload(json);
		else if(json.error) showError(json.message);
		else window.location.reload();
	};
	request.onerror = () => showError("Cannot reach the database");
	request.open("POST", location.origin + "/" + uri);
	request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	request.send(params);
}

function get(uri, callback) {
	var request = new XMLHttpRequest();
	request.onload = () => callback(JSON.parse(request.responseText));
	request.onerror = () => showError("Cannot reach the database");
	request.open("GET", location.origin + "/" + uri);
	request.send();
}

function select(element) {
	var values = [];
	for(var i=0; i<element.options.length; i++) {
		if(element.options[i].selected) values.push(element.options[i].value);
	}
	return values.join(",");
}

function selected(element, data) {
	var values = [];
	for(var i in data) values.push(data[i].id);
	for(var i=0; i<element.options.length; i++) {
		element.options[i].selected = values.indexOf(parseInt(element.options[i].value)) != -1;
	}
}

var timeout = 0;

function showError(message) {
	clearTimeout(timeout);
	document.getElementById("error").innerText = message;
	document.getElementById("error").style.display = "inline-block";
	timeout = setTimeout(() => document.getElementById("error").style.display = "none", 3000);
}
