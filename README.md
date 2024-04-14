A aplicação em questã se resume a uma biblioteca onde você pode alugar livros, fazer a devolução e ver o histórico dos mesmos. Além disso, a aplicação tem uma página de login para o usuário, além da implementação de CRUD, tanto para os usuários quanto os livros,
que podem ser alterados removido , adicionados e lidos. Falando sobre a estrutura do projeto, ele se resume a três camadas, a camada DAO, que é referente ao banco de dados, a service, onde a responsabilidade é executar de forma apropriada a camada DAO considerando informações
da camada acima, e por fim a camada de web services, onde estão as ações, que pegam dados das páginas web e trazem até a camada service.


Instalação do Projeto:

  Foi utilizado a versão 17 do java na criação desse projeto, além da IDE Apache NetBeans. Além disso utilizei do Apache TomCat para a execução do código, versão 10.1.15.
  Será nescessário instalar o PostgresSql, a versão utilizada foi a 16, e recomendo que a mesma seja utilizada no casos de outra aplicação.
Dentro do projeto foi utilizado para se conectar ao banco de dados o usuário e senha postgres para a DataBase Biblioteca , então no momento da configuração do postgres é recomendado colocar essa senha e esse usuário,
e colocar esse mesmo nome para a Database. Ou também pode-se trocar as informações no momento de instalar a aplicação, isso pode ser feito dentro da classe ConnectionFactory, presente dentro do pacote dao.
Agora a baixo será passado os comandos SQL, que devem ser executados dentro da database Biblioteca:

Create table pessoa (
	id_pessoa SERIAL primary key,
	nome varchar(40) not null,
	senhar varchar(15) not null,
	email varchar(40) Unique,
	cpf varchar(15) Unique,
	celular varchar(14) not null
);


Create table livro (
	id_livro SERIAL primary key,
	nome varchar(40) not null,
	paginas int,
              alugado boolean
);

create table aluguel(
	id_aluguel Serial primary key,
	data_inicial date,
	data_entrega date,
	id_pessoa int,
	id_livro int,
	FOREIGN KEY (id_pessoa) REFERENCES pessoa(id_pessoa),
	FOREIGN KEY (id_livro) REFERENCES livro(id_livro)
);




Trigger acionada ao retirar um livro

CREATE OR REPLACE FUNCTION fn_atualiza_status_livro()
RETURNS TRIGGER AS $$
BEGIN
    UPDATE livro SET alugado = true WHERE id_livro = NEW.id_livro;
    RETURN NEW;
END;
$$ LANGUAGE plpgsql;


CREATE TRIGGER trg_atualiza_status_livro
AFTER INSERT ON aluguel
FOR EACH ROW
EXECUTE FUNCTION fn_atualiza_status_livro();



Trigger acionada ao devolver um livro

CREATE OR REPLACE FUNCTION atualizar_status_livro_2()
RETURNS TRIGGER AS
$$
BEGIN
    IF NEW.data_entrega IS NOT NULL THEN
        UPDATE livro
        SET alugado = false
        WHERE id_livro = NEW.id_livro;
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER trigger_atualizar_status_livro_devolucao
AFTER UPDATE OF data_entrega ON aluguel
FOR EACH ROW
EXECUTE FUNCTION atualizar_status_livro_2();

Essas informações também estão arquivo no projeto, que se chamam sqlinfo.txt.
