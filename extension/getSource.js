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
