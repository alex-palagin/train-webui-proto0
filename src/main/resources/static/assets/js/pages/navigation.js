$("#nav-content").load("navigation/tags.html");

function loadTagValues(tagId) {
$("#nav-content").load("navigation/values.html?tagId=" + tagId);
$("#nav-caption").text(tagId);
}

function loadTags(query) {
$("#nav-content").load("navigation/tags.html?q=query");
$("#nav-caption").text(query);
}