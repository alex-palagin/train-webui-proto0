$("#nav-content").load("navigation/tags.html");

var caption = "TAGS";

function loadTagValues(tagId) {
    $("#nav-content").load("navigation/values.html?tagId=" + tagId);
    caption += "&nbsp;&gt;&nbsp;" + tagId;
    updateCaption(caption);
}

function loadTags(query) {
    $("#nav-content").load("navigation/tags.html?q=query");
    caption += "&nbsp;&gt;&nbsp;" + query;
    updateCaption(caption);
}

function updateCaption(caption) {
    caption = addRefs(caption);
    $("#nav-caption").html(caption);
}

function addRefs(caption) {
    return caption;
}