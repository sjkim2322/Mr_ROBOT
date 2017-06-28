chrome.browserAction.onClicked.addListener(function(tab) {
  chrome.tabs.insertCSS(tab.id, { file: "combined.css" });
  chrome.tabs.executeScript(tab.id, { file: "combined.js" });
  //body에 들어갈 combined.js 추가시킴
});
