var currentQuery = "";

var tagsTable;
var valueTable;

$(document).ready(function () {
    tagsTable = $("#tags-table").DataTable(
        {
            "paging": false,
            "searching": false,
            "info": false,
            ajax: {
                url: "navigation/tags.json",
                dataSrc: ""
            },
            columns: [
                { data: "id" },
                { data: "id" },
                { data: "id" },
                { data: "id" },
                { data: "id" },
                { data: "id" },
                { data: "id" },
                { data: "id" }
            ],
            columnDefs: [
                {
                    render: function (data, type, row) {
                        return "<button onclick='loadValues(\"" + data + "\")' type='button' class='btn btn-primary btn-xs'>Values</button>";
                    },
                    targets: 7
                }
            ]
        }
    );
});

function loadValues(tagId) {
    $("#tags-table").hide();
    $("#values-table").show();

    if (tagId)
        currentQuery += "&" + tagId;

    if (valueTable) {
        valueTable.ajax.url("navigation/values.json?q=" + encodeURIComponent(currentQuery)).load();
    } else {
        valueTable = $("#values-table").DataTable(
            {
                paging: false,
                searching: false,
                info: false,
                ajax: {
                    url: "navigation/values.json?q=" + encodeURIComponent(currentQuery),
                    dataSrc: ""
                },
                columns: [
                    { data: "value" },
                    { data: "documentsTagged" },
                    { data: "value" }
                ],
                columnDefs: [
                    {
                        render: function (data, type, row) {
                            return "<button onclick='loadTags(\"" + data + "\")' type='button' class='btn btn-primary btn-xs'>Tags</button>";
                        },
                        targets: 2
                    }
                ]
            }
        );
    }

    updateCaption(currentQuery);
}

function loadTags(value) {
    $("#values-table").hide();
    $("#tags-table").show();

    if (value)
        currentQuery += "=" + value;

    tagsTable.ajax.url("navigation/tags.json?q=" + encodeURIComponent(currentQuery)).load();
    updateCaption(currentQuery);
}

function updateCaption(currentQuery) {
    var caption = "<a href='navigation.html'>TAGS</a>";
    var parts = currentQuery.split("&");
    var subQuery = "";
    for (var i = 0; i < parts.length - 1; i++) {
        if (parts[i] != "") {
            caption += "&nbsp;&gt;&nbsp;" + addRefs(parts[i], subQuery);
            subQuery += "&" + parts[i];
        }
    }

    // Last item goes w/o link
    var lastLink = parts[parts.length - 1].split("=");
    if (lastLink.length > 1) {
        caption += "&nbsp;&gt;&nbsp;" + addRefs(lastLink[0], subQuery);
        caption += "&nbsp;=&nbsp;" + lastLink[1];
    }  else {
        caption += "&nbsp;&gt;&nbsp;" + lastLink[0];
    }

    $("#nav-caption").html(caption);
}

function addRefs(linkName, query, ignoreValue) {
    var parts = linkName.split("=");
    var result = "<a href='#' onclick='goBack(\"" + query + "&" + parts[0] + "\")'>" + parts[0] + "</a>";
    if (parts.length > 1)
        result += "<a href='#' onclick='goBack(\"" + query + "&" + linkName + "\")'>&nbsp;=&nbsp;" + parts[1] + "</a>";
    return result;
}

function goBack(query) {
    currentQuery = query;
    var parts = query.split("&");
    if (parts[parts.length - 1].indexOf("=") > 0) {
        loadTags();
    } else {
        loadValues();
    }
}
