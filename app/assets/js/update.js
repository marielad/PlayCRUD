function modificarCantidad(productInvoiceId, value, route) {
    console.log('Id: ' + productInvoiceId + ', Valor: ' + value);
    console.log('document.getElementById("total_price")');
    var xhr = new XMLHttpRequest();
    xhr.open("POST", route, true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.send(JSON.stringify({
        productInvoiceId: productInvoiceId,
        value: value
    }));
}

