document.getElementById('type_input_id').addEventListener("change", e => {
    document.getElementById('name_input_id').value = "";
    const children = document.getElementById('name_input_id').children;
    Array.from(children).forEach(node => {
        if (node.getAttribute("data-game") !== e.target.value) {
            node.style.display = "none";
        } else {
            node.style.display = "block";
        }
    })
})