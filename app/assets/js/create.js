function substract(id){
    console.log(id);
    var patata = parseInt(document.getElementById(id.id).value);
    console.log(patata);
    if(patata > 1){
    patata -= parseInt(1);
    document.getElementById(id.id).value = patata;
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

function addToCart(id,route){
    console.log(id);
    var value = parseInt(document.getElementById("amount"+id).value);
    var xhr = new XMLHttpRequest();
    xhr.open("POST", route, true);
    xhr.setRequestHeader('Content-Type', 'application/json;charset=UTF-8');
    xhr.send(JSON.stringify({
        productId: id,
        value: value
    }));
}
