/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function modificar() {
    var nomeEl = document.getElementById('textoNome');
    var paginasEl = document.getElementById('textoPaginas');
    var nome = nomeEl ? nomeEl.value.trim() : "";
    var paginas = paginasEl ? paginasEl.value.trim() : "";
    
    if(nome){
        post('/Trabalho/ModificarLivro', {textoNome: nome});
    } else if(paginas){
        
        var paginasNumero = parseFloat(paginas);
        if (!Number.isInteger(paginasNumero)) {
            alert('Páginas devem ter um número inteiro.');
            return;
        }
        post('/Trabalho/ModificarLivro', {textoPaginas: paginas});
    } else{
        alert('Nome e páginas não podem estar em branco.');
        return; 
    }
}


function post(path, params, method = 'post') {

    // The rest of this code assumes you are not using a library.
    // It can be made less verbose if you use one.
    
    const form = document.createElement('form');
    form.method = method;
    form.action = path;
    

    for (const key in params) {
        if (params.hasOwnProperty(key)) {
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

