Sys.WebForms.PageRequestManager.getInstance().add_beginRequest(BeginRequestHandler);
Sys.WebForms.PageRequestManager.getInstance().add_endRequest(EndRequestHandler);

function BeginRequestHandler(sender, args) {
    ActivateAlertDiv('visible', 'modalDiv');
}

function EndRequestHandler(sender, args) {
    ActivateAlertDiv('hidden', 'modalDiv');
}

function ActivateAlertDiv(visstring, elem) {
    //var adiv = parent.$get(elem);
    ////console.log(adiv);
    //var adiv2 = parent.$get('modalDiv2');
    //var h = $(document).height()  ;//document.body.offsetHeight + document.body.scrollTop;
    ////console.log(h);
    ////var hh = $(document).height() + 100;;

    //var w = document.body.offsetWidth + document.body.scrollLeft - 25;
    //adiv.style.height = h;

    //adiv2.style.top = parseInt(h / 2) - 20;
    //adiv2.style.left = parseInt(w / 2) - 50;
    //adiv2.style["left"] = (document.documentElement.clientWidth - 260) / 2;
    //adiv2.style.visibility = visstring;
    //adiv.style.visibility = visstring;
}

function page_beforesubmit() {
    ActivateAlertDiv('visible', 'modalDiv');
    return true;
}

document.onreadystatechange = fnStartInit;

function fnStartInit() {
    if (document.readyState == "complete" || document.readyState == "interactive") {
        ActivateAlertDiv('hidden', 'modalDiv');
    }
}