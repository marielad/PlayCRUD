function modificarCantidad(productInvoiceId, initialPrice, initialValue, route) {
    var totalPrice = document.getElementById("totalPrice");
    var price = document.getElementById("price"+ productInvoiceId);
    var amount = document.getElementById("amount"+productInvoiceId);

    console.log(initialValue);
    console.log(initialPrice);
    console.log(amount.value);
    console.log(totalPrice.value);
    console.log('Id: ' + productInvoiceId + ', Valor: ' + amount.value);

    if (amount.value < 0) {
        alert('Inserte una cantidad válida.');
    }
    if(amount.value >= 999999){
         amount.value =  999999;
    }

    if(amount.value <= 999999 && amount.value > 0){
        var productPrice = parseFloat(initialPrice / initialValue);
        var newPrice = productPrice * amount.value;

        console.log(productPrice);
        console.log(newPrice);
        console.log((parseFloat(totalPrice.value) - parseFloat(price.value)) + parseFloat(newPrice));

        totalPrice.value = (parseFloat(totalPrice.value) - parseFloat(price.value)) + parseFloat(newPrice);
        price.value = parseFloat(newPrice);
    
   }

     var xhr = new XMLHttpRequest();
        xhr.open("POST", route, true);
        xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
        xhr.send(JSON.stringify({
            productInvoiceId: productInvoiceId,
            value: amount.value
        }));

}