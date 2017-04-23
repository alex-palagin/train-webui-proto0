$("#nav-content").load("navigation/tags.html");

var currentQuery = "";

function loadTagValues(tagId) {
    currentQuery += "&" + tagId;
    $("#nav-content").load("navigation/values.html?q=" + encodeURIComponent(currentQuery));
    updateCaption(currentQuery);
}

function loadTagsForValue(value) {
    currentQuery += "=" + value;
    $("#nav-content").load("navigation/tags.html?q=" + encodeURIComponent(currentQuery));
    updateCaption(currentQuery);
}

function updateCaption(currentQuery) {
    var caption = "TAGS";
    var parts = currentQuery.split("&");
    parts.forEach(function(str) {
        caption += "&nbsp;&gt;&nbsp;" + addRefs(str);
    });

    $("#nav-caption").html(caption);
}

function addRefs(str) {
    return str;
}