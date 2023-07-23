# Java - Caixa de mercado

![image](https://github.com/giansb/ProjetoCaixaMercado/assets/107221898/173b1bda-504e-43d1-a0d1-aa224ada5c0b)


<p>Sistema de CRUD de um caixa de mercado, feito com Java Swing e com implementação de banco de dados MySQL. Projeto feito para fechar a UC de implementação de banco de dados do Técnico em Desenvolvimento 
  de Sistemas.</p>
  
  #

  <p>  O sistema conta com as funcões de: Adicionar produto; Atualizar produto; Deletar produto.</p>

  <img width="50%" src="https://github.com/giansb/ProjetoCaixaMercado/assets/107221898/72c5e180-59f3-4347-b1fb-5d8de4ceb867"/>

  #

  <p>Com o produto já adicionado ao banco de dados, ele poderá ser puxado para o pedido através do seu codigo:</p>
  

<img width="80%" src="https://github.com/giansb/ProjetoCaixaMercado/assets/107221898/9b0e5d67-0b0f-4b1a-961f-ee068e60c745"/>


A cada item puxado, ele o adiciona ao pedido atual automaticamente. Sempre atualizando quando necessário, como por exemplo quando a quantidade do mesmo é alterada.

obs: para adicionar mais um item é só escrever o codigo dele no campo novamente.

#

Ao fechar o pedido, ele altera os dados do pedido atual, atualizando o total, a forma de pagamento, e cpf(se for informado).

Também podemos acompanhar o histórico dos pedidos pela aba histórico:

<img width="80%" src="https://github.com/giansb/ProjetoCaixaMercado/assets/107221898/7f8e456b-48fb-48ef-b128-47dc5eca23c5"/>


## Para rodar o programa

Além de baixar, é recomendavel checar se o conector MySQL está dentro da pasta "bibliotecas":

<img width="80%" src="https://github.com/giansb/ProjetoCaixaMercado/assets/107221898/0e380379-c19a-4e0b-b40a-156971809f1b"/>

caso não esteja, baixe-o junto ao projeto na pasta dependências e em seguida adicione como arquivo jar.

## Banco de dados

O banco de dados pode ser baixado junto ao projeto na pasta dependências, e exportado para o MySQL Workbench ou pelo Apache localhost, vai de sua preferencia.

Além disso, temos que abrir o XAMPP e checar se a porta do MySQL está em 3306.









