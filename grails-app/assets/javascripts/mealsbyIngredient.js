




//let XMLHttpRequest = require("xmlhttprequest").XMLHttpRequest;

let xhr= new XMLHttpRequest();

xhr.responseType='';
xhr.onreadystatechange=()=>{

    if(xhr.status==200 && xhr.readyState==4){
        console.log(JSON.parse(xhr.responseText));
    }

};

let url="https://jsonplaceholder.typicode.com/todos/1";

xhr.open('GET',url);
xhr.send();


function getMealsByIngredientName(nameStr) {
    const postpend = nameStr;
    let url = "https://www.themealdb.com/api/json/v1/1/filter.php?i=";
    url += postpend ;
    return document.write(url);
}
function getMealsByIngredientName(n){
    let ingredientName = n;
    var url ='https://www.themealdb.com/api/json/v1/1/filter.php?i= %d',ingredientName;




// Created a URL object using URL() method
var parser = new URL(url);

// Protocol used in URL
document.write(parser.protocol + "<br>");
//String url ='https://www.themealdb.com/api/json/v1/1/filter.php?i
}