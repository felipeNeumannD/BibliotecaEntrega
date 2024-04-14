/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function alterarPessoa() {
    
    var nome = document.getElementById('nome').value;
    var email = document.getElementById('email').value;
    var cpf = document.getElementById('cpf').value;
    var celular = document.getElementById('celular').value;
    var senhar = document.getElementById('senhar').value;
    
    
    
    
    
    
    let array = {nome, email, cpf, celular, senhar};
    
 
    if(arrayVerify(array)){
        if(validatorCpf(cpf) && validarCelular(celular)){
            post('/Trabalho/AlterarPessoa', {nome: nome, email: email, senhar: senhar, cpf: desformatarParaNum(cpf), celular: desformatarParaNum(celular)});
        } else{
            alert('Informação incorreta');
            return;
        }
    } else{
        alert('Informação deixada em branco');
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



function arrayVerify(array){
    
    let noNull = true;
    
    for (let key in array){
        if(!array[key].trim()){
            noNull = false;
        }
    }
    return noNull;
}


function validatorCpf(cpf) {
    let cpf1 = cpf.replace(/\D/g,'');

    if (cpf1.length !== 11 || /^(\d)\1{10}$/.test(cpf1)) {
        alert("CPF inválido");
        return false;
    }

    let soma = 0;
    let resto;

    // Cálculo do primeiro dígito verificador
    for (let i = 1; i <= 9; i++) {
        soma += parseInt(cpf1.charAt(i - 1)) * (11 - i);
    }
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    if (resto !== parseInt(cpf1.charAt(9))) {
        alert("CPF inválido");
        return false;
    }

    soma = 0;
    // Cálculo do segundo dígito verificador
    for (let i = 1; i <= 10; i++) {
        soma += parseInt(cpf1.charAt(i - 1)) * (12 - i);
    }
    resto = (soma * 10) % 11;
    if (resto === 10 || resto === 11) resto = 0;
    if (resto !== parseInt(cpf1.charAt(10))) {
        alert("CPF inválido");
        return false;
    }
    return true;
}


function validarCelular(numero) {
    const numeroLimpo = numero.replace(/\D/g, '');
    
    const padraoCelular = /^[1-9][1-9]9\d{8}$/;

    if (padraoCelular.test(numeroLimpo)) {
        return true;
    } else {
        console.log("Número de celular inválido.");
        return false;
    }
}




function apenasNumeros(str) {
    return /^\d+$/.test(str);
}

function formatarCelular(celular) {
  return celular.replace(/(\d{2})(\d{5})(\d{4})/, "($1)$2-$3");
}

function formatarCPF(cpf) {
  return cpf.replace(/(\d{3})(\d{3})(\d{3})(\d{2})/, "$1.$2.$3-$4");
}

function desformatarParaNum(format){
    return format.replace(/\D/g, '');
}
