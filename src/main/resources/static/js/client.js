console.debug("Client scripts loaded");

function handleRequest(sortType) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if(this.readyState === 4 && this.status === 200) {
            console.log(this.responseText);
            refreshList(JSON.parse(this.responseText));
        }
    }
    xhttp.open("GET", `/sort/${sortType}`, true);
    xhttp.send();
}

function refreshList(displayed) {
    const books = document.getElementById("libraryList").children;
    const displayedIds = displayed.map( (elem) => elem.id )

    for (let book of books) {
        if(displayedIds.indexOf(getBookId(book)) === -1) {
            book.hidden = true;
        }
        else {
            book.hidden = false;
        }
    }
}

function getBookId(bookDOMElement) {
    const link = bookDOMElement.children[1].href;
    const tokens = link.split("/");
    let id = parseInt(tokens[tokens.length - 1])
    if(isNaN(id)) {
        throw new Error(`Failed to get book id on the page: broken link '${link}'`);
    }
    return id;
}