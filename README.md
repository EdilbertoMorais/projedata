# Projeto de Gestão de Funcionários

Este projeto em Java foi desenvolvido como parte de um teste prático de programação. Ele gerencia informações sobre funcionários de uma indústria, incluindo nome, data de nascimento, salário e função.
### Abaixo os requisítos para a conclusão do teste:

#### TESTE PRÁTICO DE PROGRAMAÇÃO.

Considerando que uma indústria possui as pessoas / funcionários abaixo:

//<img src="https://github.com/EdilbertoMorais/projedata/blob/main/imagens/tabelaFuncionarios.png" alt="Texto Alternativo" width="600"/>

Diante disso, você deve desenvolver um projeto java, com os seguintes requisitos:

1. Classe Pessoa com os atributos: nome (String) e data nascimento (LocalDate).

2. Classe Funcionário que estenda a classe Pessoa, com os atributos: salário (BigDecimal) e função (String).

3. Deve conter uma classe Principal para executar as seguintes ações:  
3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.  
3.2 – Remover o funcionário “João” da lista.  
3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:  
• informação de data deve ser exibido no formato dd/mm/aaaa;  
• informação de valor numérico deve ser exibida no formatado com separador de milhar como ponto e decimal como vírgula.  
3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.  
3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.  
3.6 – Imprimir os funcionários, agrupados por função.  
3.7 – Não aparece no teste enviado.  
3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.  
3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.  
3.10 – Imprimir a lista de funcionários por ordem alfabética.  
3.11 – Imprimir o total dos salários dos funcionários.  
3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.  

#### Orientações gerais:  
• você poderá utilizar a ferramenta que tem maior domínio (exemplos: eclipse, netbeans etc);  
• após finalizado o desenvolvimento, exportar o projeto e encaminhar o link do seu teste aqui mesmo na etapa Mão na Massa 🖐. 

• Assim que recebermos seu projeto desenvolvido, será agendada uma entrevista com nosso time técnico para avaliação.  

Esperamos que você use todo seu conhecimento e criatividade nesse teste.

Caso você não souber resolver determinado requisito comente no código que aquele item você não sabe como desenvolver, e vá para o próximo. Avaliaremos o que você conseguiu desenvolver e como foi desenvolvido.

Boa sorte!

## Tecnologias Utilizadas
- Java
- Maven

## Como Usar o Projeto

### Configuração do Ambiente
- Certifique-se de ter o Java instalado em sua máquina.
- Recomenda-se utilizar uma IDE Java, como Eclipse ou IntelliJ, para facilitar o desenvolvimento.

### Clonar o Repositório
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
cd nome-do-repositorio
```
### Importar o Projeto
- Abra a IDE e importe o projeto como um projeto Maven.

### Executar o Projeto
- Execute a classe Principal como um aplicativo Java.

### Ações Disponíveis
O programa executará uma série de ações conforme descrito nos requisitos do teste. 
Com exceção do 3.7 que não foi solicitado no link enviado, pulando direto para o 3.8

### Funcionalidades Implementadas
1. Inserir todos os funcionários na mesma ordem descrita na imagem enviada no teste.
2. Remover o funcionário "João".
3. Imprimir a lista de todos os funcionários com informações formatadas (Ex: Data de nascimento e salário).
4. Aumentar os salários de todos os funcionarios em 10% (este valor é flexível).
5. Agrupar os funcionários por função (Ex: Operador / Recepcionista) em um Map.
6. Imprimir a lista de funcionários agrupados por função.
7. Imprimir a lista de funcionários que fazem aniversário nos meses 10 e 12. (na lista de funcionários nenhum faz aniversário no mês 12)
8. Imprimir o funcionário com a maior idade.
9. Imprimir a lista de funcionários por ordem alfabética.
10. Imprimir o valor total da soma dos salários dos funcionários.
11. Imprimir quantos salários mínimos cada funcionário recebe.

### Observações
- Para testar uma ação específica, basta comentar as demais ações deixando apenas a linha correspondente desejada.
- Caso algum requisito não tenha sido implementado, estará comentado no código com um aviso.
- O projeto foi criado diretamente pela IDE IntelliJ.
