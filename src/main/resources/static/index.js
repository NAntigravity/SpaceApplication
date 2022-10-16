function switchImageByID(tile, ID) {
    switch (ID) {
        case "space.simulation.spaceapplication.game.model.Tile":
            tile.className = "tile";
            break;
        case "space.simulation.spaceapplication.game.model.celestial.bodies.Star":
            tile.className = "star";
            break;
    }
}

let tiles;
let w;
let h;
let map;

async function mapCreation() {
    let response = await fetch('http://localhost:8080/spaceAPI');
    let json = await response.json();

    w = json.map.width;
    h = json.map.height;
    tiles = json.map.tiles;
    ent = json.map.entities;

    map = document.getElementById("field");

    for (let i = 0; i < h; i++) {
        let col = document.createElement("div");
        col.classList.add("row");
        for (let j = 0; j < w; j++) {
            let img = document.createElement("img");
            switchImageByID(img, tiles[i][j].tileType);

            img.setAttribute('X', j);
            img.setAttribute('Y', i);

            col.appendChild(img);
        }
        map.appendChild(col);
    }
}

mapCreation().then(()=>{
    setInterval(()=>{console.log("I'm okay=(")},1000)
});