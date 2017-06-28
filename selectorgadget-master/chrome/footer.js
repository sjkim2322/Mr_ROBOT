
  }

  var interval = setInterval(function() {
    if (typeof SelectorGadget != 'undefined') {
      clearInterval(interval);
      SelectorGadget.toggle();
    }
  }, 50);
})();