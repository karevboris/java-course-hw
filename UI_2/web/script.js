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

function addCell(row, value) {
    var newCell = row.insertCell();
    var newText = document.createTextNode(value);
    newCell.appendChild(newText);
}

function addRow(msg) {
    var json = JSON.parse(msg);
    var tableRef = document.getElementById("Row");
    var newRow = tableRef.insertRow(0);

    addCell(newRow, coefA.value);
    addCell(newRow, coefB.value);
    addCell(newRow, coefC.value);
    addCell(newRow, json.x1);
    addCell(newRow, json.x2);
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
    ajaxRequest.open('GET', 'http://localhost:8080/myServlet'+msg, true);
    ajaxRequest.send(null);
}

function processRequest() {
    if (ajaxRequest.readyState == 4) {
        if (ajaxRequest.status == 200) {
            addRow(ajaxRequest.responseText)
        }
        else {
            alert("WARNING: " + ajaxRequest.status);
        }
    }
}