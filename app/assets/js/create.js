(function ($) {
    $(function () { 
        $('.modal').modal();
        $('.trigger-modal').modal();
    });
})(jQuery);

var cart = sessionStorage.setItem("cart", "0");
document.getElementById("cartNumber").innerHTML = cart;

function substract(id){
    console.log(id);
    var amount = parseInt(document.getElementById(id.id).value);
    console.log(amount);
    if(amount > 1){
    amount -= parseInt(1);
    document.getElementById(id.id).value = amount;
    }else{
        alert("La cantidad mínima es 1");
    }
}
function add(id){
    var patata = parseInt(document.getElementById(id.id).value);
    console.log(patata);
    patata += parseInt(1);
    document.getElementById(id.id).value = patata;
}

function addToCart(id, name ,route){
    console.log(id);
    var value = parseInt(document.getElementById("amount"+id).value);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", route, true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.send(JSON.stringify({
        productId: id,
        value: value
    }));
    
    cartNumber += value;

    console.log("Cart: " + cart+ "CartNumber: " + cartNumber);

    var message = "A añadido " + value + " " + name;
    document.getElementById("message").innerHTML = message;
    $('#modal1').modal('open');
}

function create(route) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", route, true);
    xhttp.send();
}

function cancel(route) {
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", route, true);
    xhttp.send();
}

