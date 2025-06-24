// -------------------- CLIENTES --------------------
const modalCliente = new bootstrap.Modal(document.getElementById("modalCliente"));
document.getElementById("formCliente").addEventListener("submit", guardarCliente);
const URL_CLIENTES = "/api/clientes";

function listarClientes() {
    fetch(URL_CLIENTES)
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector("#tablaClientes tbody");
            tbody.innerHTML = "";
            data.forEach(cliente => {
                tbody.innerHTML += `
          <tr>
            <td>${cliente.nombre}</td>
            <td>${cliente.cedula}</td>
            <td>${cliente.telefono}</td>
            <td>${cliente.direccion}</td>
            <td>
              <button class="btn btn-sm btn-warning" onclick='abrirModalCliente(${JSON.stringify(cliente)})'>Editar</button>
              <button class="btn btn-sm btn-danger" onclick="eliminarCliente(${cliente.id})">Eliminar</button>
            </td>
          </tr>`;
            });
        });
}

function abrirModalCliente(cliente = null) {
    document.getElementById("formCliente").reset();
    document.getElementById("clienteId").value = cliente?.id || "";
    document.getElementById("clienteNombre").value = cliente?.nombre || "";
    document.getElementById("clienteCedula").value = cliente?.cedula || "";
    document.getElementById("clienteTelefono").value = cliente?.telefono || "";
    document.getElementById("clienteDireccion").value = cliente?.direccion || "";
    modalCliente.show();
}

function guardarCliente(e) {
    e.preventDefault();
    const id = document.getElementById("clienteId").value;
    const cliente = {
        nombre: document.getElementById("clienteNombre").value,
        cedula: document.getElementById("clienteCedula").value,
        telefono: document.getElementById("clienteTelefono").value,
        direccion: document.getElementById("clienteDireccion").value
    };
    const metodo = id ? "PUT" : "POST";
    const url = id ? `${URL_CLIENTES}/${id}` : URL_CLIENTES;

    fetch(url, {
        method: metodo,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(cliente)
    }).then(() => {
        modalCliente.hide();
        listarClientes();
    });
}

function eliminarCliente(id) {
    if (confirm("¿Eliminar cliente?")) {
        fetch(`${URL_CLIENTES}/${id}`, { method: "DELETE" }).then(listarClientes);
    }
}

// -------------------- PRODUCTOS --------------------
const modalProducto = new bootstrap.Modal(document.getElementById("modalProducto"));
document.getElementById("formProducto").addEventListener("submit", guardarProducto);
const URL_PRODUCTOS = "/api/productos";

function listarProductos() {
    fetch(URL_PRODUCTOS)
        .then(res => res.json())
        .then(data => {
            const tbody = document.querySelector("#tablaProductos tbody");
            tbody.innerHTML = "";
            data.forEach(producto => {
                tbody.innerHTML += `
          <tr>
            <td>${producto.nombre}</td>
            <td>$${producto.precio}</td>
            <td>${producto.stock}</td>
            <td>
              <button class="btn btn-sm btn-warning" onclick='abrirModalProducto(${JSON.stringify(producto)})'>Editar</button>
              <button class="btn btn-sm btn-danger" onclick="eliminarProducto(${producto.id})">Eliminar</button>
            </td>
          </tr>`;
            });
        });
}

function abrirModalProducto(producto = null) {
    document.getElementById("formProducto").reset();
    document.getElementById("productoId").value = producto?.id || "";
    document.getElementById("productoNombre").value = producto?.nombre || "";
    document.getElementById("productoPrecio").value = producto?.precio || "";
    document.getElementById("productoStock").value = producto?.stock || "";
    modalProducto.show();
}

function guardarProducto(e) {
    e.preventDefault();
    const id = document.getElementById("productoId").value;
    const producto = {
        nombre: document.getElementById("productoNombre").value,
        precio: document.getElementById("productoPrecio").value,
        stock: document.getElementById("productoStock").value
    };
    const metodo = id ? "PUT" : "POST";
    const url = id ? `${URL_PRODUCTOS}/${id}` : URL_PRODUCTOS;

    fetch(url, {
        method: metodo,
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(producto)
    }).then(() => {
        modalProducto.hide();
        listarProductos();
    });
}

function eliminarProducto(id) {
    if (confirm("¿Eliminar producto?")) {
        fetch(`${URL_PRODUCTOS}/${id}`, { method: "DELETE" }).then(listarProductos);
    }
}

// -------------------- CARGA INICIAL --------------------
listarClientes();
listarProductos();
