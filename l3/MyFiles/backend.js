/**
 * Created by Dan on 19-Apr-17.
 */
//Problem: We need a simple way to look at a user's badge count and JavaScript point from a web browser
//Solution: Use Node.js to perform the profile look ups and server our template via HTTP

//1. Create a web server

var http = require('http');
http.createServer(function (request, response) {
    homeRoute(request,response);

}).listen(3000);
console.log('Server running at local http');



//2. Handle HTTP route GET / and POST / i.e. Home
function homeRoute(request, response) {
    if(request.url === "/"){
        if(request.method.toLowerCase() === "get"){
            response.writeHead(200, {'Content-Type' : 'text/plain'});
            //setInterval(function () {
            response.write("1 \n");
            response.write("2 \n");
            response.write("3 \n");
            response.end('end get');
        } else{
           response.writeHead(200, {'Content-Type' : 'text/plain'});
           request.on("data", function(postBody){
              console.log(postBody.toString());
           });
            response.end('end post');
            //console.log(response.head);//
            
        }


    }

}
