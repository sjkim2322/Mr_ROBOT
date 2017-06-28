function get_source(document_body){
    return document_body.name;
}
function get_element(mydocument)
{
  chrome.extension.sendMessage({
      action: "getSource",
      source: get_source(mydocument)
  });
}
function injection(){
  alert("!");
var body = document.getElementsByTagName("body")[0];
var script = document.createElement("script");
body.appendChild(script);
script.onload = function() {
  alert("!!");
  };
}
$("*").mouseover(function(){
  $(this).css("background-color", "yellow")
});
$("*").mouseout(function(){
  $(this).css("background-color", "blue")
});

<<<<<<< HEAD
injection();
=======
console.log($("*"));
>>>>>>> 3c5dfbd0419d2943d25d5749b6d5b681e9bf559a
