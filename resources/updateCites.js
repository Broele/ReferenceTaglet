var refs = {};

function updateCites() {

    var elements = document.getElementsByClassName("cite");
    for (var i = 0; i < elements.length; ++i) {
        var element = elements[i];
        var id = element.href;
        var p = id.indexOf("#");
        id = id.substr(p + 1);
        element.innerHTML = '['+getRefIndex(id)+']';
	}
}

function getRefIndex(id) {
    if (!refs[id]) {
        var element = document.getElementById(id);
        if (element) {
        var i = 1;

            while ( element.previousElementSibling ) {
                element = element.previousElementSibling;
                i += 1;
            }

            refs[id] = i;
        } else
            refs[id] = '?';
    }

    return refs[id];
}

window.addEventListener("load", updateCites, false);
