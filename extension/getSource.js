function get_source(document_body){
    return document_body.name;
}
function get_element(mydocument)
{
  console.log("!!!");
  chrome.extension.sendMessage({
      action: "getSource",
      source: get_source(mydocument)
  });
}

var body = document.getElementsByTagName('body');
body[0].innerHTML = body[0].innerHTML + '<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>';
body[0].innerHTML = body[0].innerHTML + '<script>$("*").on("mouseover",function(){console.log($(this))});</script>';
