var ajaxRequest;
var coefA;
var coefB;
var coefC;

function init() {
    coefA = document.getElementById("coefA");
    coefB = document.getElementById("coefB");
    coefC = document.getElementById("coefC");

    var el = document.getElementById("Row");
    el.addEventListener("click", function(event){deleteRow(event);}, false);
}

function validateComponents() {

    var pattern = /^-?\d+([\.,]\d+)?$/;
    var flag = false;

    if (!pattern.test(coefA.value)) {
        flag = true;
        coefA.setCustomValidity("Введено некорректное число");
    } else {
        coefA.setCustomValidity("");
    }

    if (!pattern.test(coefB.value)) {
        flag = true;
        coefB.setCustomValidity("Введено некорректное число");
    } else {
        coefB.setCustomValidity("");
    }

    if (!pattern.test(coefC.value)) {
        flag = true;
        coefC.setCustomValidity("Введено некорректное число");
    } else {
        coefC.setCustomValidity("");
    }
    document.getElementById("sub").disabled = flag;
}

function deleteRow(event) {
    event.target.parentNode.parentNode.removeChild(event.target.parentNode);
}

function Table(name) {
    this.name=name;
    this.addRow=function (row) {
        var newRow = this.name.insertRow(0);
        newRow.insertCell().appendChild(row.cfA);
        newRow.insertCell().appendChild(row.cfB);
        newRow.insertCell().appendChild(row.cfC);
        newRow.insertCell().appendChild(row.x1);
        newRow.insertCell().appendChild(row.x2);
    };
}

function Row(x1, x2) {
    this.cfA=document.createTextNode(coefA.value);
    this.cfB=document.createTextNode(coefB.value);
    this.cfC=document.createTextNode(coefC.value);
    this.x1=document.createTextNode(x1);
    this.x2=document.createTextNode(x2);
}

function ajaxFunction() {

    var msg = "?coefA="+coefA.value+"&coefB="+coefB.value+"&coefC="+coefC.value;

    try {
        ajaxRequest = new XMLHttpRequest();
    } catch (e) {
        try {
            ajaxRequest = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                ajaxRequest = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
                alert("You browser broke!");
                return false;
            }
        }
    }

    ajaxRequest.onreadystatechange = processRequest;
    ajaxRequest.open('GET', '/myServlet'+msg, true);
    ajaxRequest.send(null);
}

function processRequest() {
    if (ajaxRequest.readyState == 4) {
        if (ajaxRequest.status == 200) {
            var json = JSON.parse(ajaxRequest.responseText);
            var table = new Table(document.getElementById("Row"));
            var newRow = new Row(json.x1, json.x2);
            table.addRow(newRow);
        }
        else {
            alert("WARNING: " + ajaxRequest.status);
        }
    }
}