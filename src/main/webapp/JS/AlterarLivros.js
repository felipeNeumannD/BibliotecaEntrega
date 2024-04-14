/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function adicionar() {
    var nome = document.getElementById('textoNome').value;
    var paginas = document.getElementById('textoPaginas').value;
    
     if (!nome || !paginas) {
        alert('Nome e páginas não podem estar em branco.');
        return; 
    }
    

    var paginasNumero = parseFloat(paginas);
    if (!Number.isInteger(paginasNumero)) {
        alert('Páginas devem ter um número inteiro.');
        return;
    }

    post('/Trabalho/AdicionaLivro', {nome: nome, paginas: paginas});
}


function post(path, params, method = 'post') {

    // The rest of this code assumes you are not using a library.
    // It can be made less verbose if you use one.
    
    const form = document.createElement('form');
    form.method = method;
    form.action = path;
    

    for (const key in params) {
        if (params.hasOwnProperty(key) && key.valueOf() !== 'null') {
            const hiddenField = document.createElement('input');
            hiddenField.type = 'hidden';
            hiddenField.name = key;
            hiddenField.value = params[key];
            
            form.appendChild(hiddenField);
        }
    }

    document.body.appendChild(form);
    form.submit();
}

