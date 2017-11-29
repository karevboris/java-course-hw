function validateComponents() {
    var coefA = document.getElementById("coefA");
    var coefB = document.getElementById("coefB");
    var coefC = document.getElementById("coefC");
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

var d = document;

function ajaxFunction() {

    var coefA = document.getElementById("coefA").value;
    var coefB = document.getElementById("coefB").value;
    var coefC = document.getElementById("coefC").value;

    var ajaxRequest;
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

    ajaxRequest.onreadystatechange = function () {
        if (ajaxRequest.readyState == 4) {
            if (ajaxRequest.status == 200) {

                var json = JSON.parse(ajaxRequest.responseText);
                var tableRef = document.getElementById("Row");
                var newRow = tableRef.insertRow(0);
                newRow.onclick = function () {
                    newRow.parentNode.removeChild(newRow);
                };

                var newCell = newRow.insertCell();
                var newText = document.createTextNode(coefA);
                newCell.appendChild(newText);

                newCell = newRow.insertCell();
                newText = document.createTextNode(coefB);
                newCell.appendChild(newText);

                newCell = newRow.insertCell();
                newText = document.createTextNode(coefC);
                newCell.appendChild(newText);


                newCell = newRow.insertCell();
                newText = document.createTextNode(json.x1);
                newCell.appendChild(newText);

                newCell = newRow.insertCell();
                newText = document.createTextNode(json.x2);
                newCell.appendChild(newText);
            }
            else {
                alert("WARNING: " + ajaxRequest.status);
            }
        }
    };

    var msg = "?coefA="+coefA+"&coefB="+coefB+"&coefC="+coefC;
    ajaxRequest.open('GET', 'http://localhost:8080/myServlet'+msg, true);
    ajaxRequest.send(null);
}