function modificarCantidad(productInvoiceId, value, route) {
    console.log('Id: ' + productInvoiceId + ', Valor: ' + value);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", route, true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.send(JSON.stringify({
        productInvoiceId: productInvoiceId,
        value: value
    }));
}

function update(route) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", route, true);
    xhttp.send();
}

