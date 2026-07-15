const API_URL = "http://localhost:8080/products";

window.onload = function () {
    getProducts();
};

async function getProducts() {

    const response = await fetch(API_URL);
    const products = await response.json();

    const productList = document.getElementById("productList");
    productList.innerHTML = "";

    products.forEach(product => {

        productList.innerHTML += `
            <div class="product-card">

                <h3>${product.productName}</h3>

                <p><strong>Description:</strong> ${product.description}</p>

                <p><strong>Stock:</strong> ${product.currentStock}</p>

                <div class="actions">

                    <button onclick="editProduct(${product.id})">
                        Edit
                    </button>

                    <button class="delete-btn"
                            onclick="deleteProduct(${product.id})">
                        Delete
                    </button>

                </div>

            </div>
        `;

    });

}

async function addProduct() {

    const product = {

        productName: document.getElementById("productName").value,
        description: document.getElementById("description").value,
        currentStock: document.getElementById("quantity").value

    };

    await fetch(API_URL, {

        method: "POST",

        headers: {
            "Content-Type": "application/json"
        },

        body: JSON.stringify(product)

    });

    document.getElementById("productName").value = "";
    document.getElementById("description").value = "";
    document.getElementById("quantity").value = "";

    getProducts();

}

document.getElementById("productForm").addEventListener("submit", function (event) {
    event.preventDefault();
    addProduct();
});

function editProduct(id) {
    alert("Edit functionality coming soon!");
}

function deleteProduct(id) {
    alert("Delete functionality coming soon!");
}