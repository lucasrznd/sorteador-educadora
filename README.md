# Aplicação de Sorteios

A Aplicação de Sorteios é uma aplicação desktop desenvolvida em Java Swing para realizar sorteios simples. Permite adicionar participantes, escolher brindes, selecionar o locutor e realizar sorteios de forma fácil e rápida.

## Funcionalidades

- **Cadastro de Participantes**: Adicione nomes e bairros dos participantes em uma tabela.
- **Escolha de Brindes**: Selecione entre os brindes disponíveis para o sorteio.
- **Seleção de Locutor**: Escolha quem será o locutor responsável pelo sorteio.
- **Realização de Sorteios**: Execute o sorteio dos participantes e visualize o nome do ganhador na tela.
- **Geração de Vale-Brinde**: Crie um relatório utilizando o JasperReports contendo informações sobre o sorteio realizado.

## Tecnologias Utilizadas

- **Java Swing**: Biblioteca gráfica para a criação de interfaces de usuário em Java.
- **MySQL**: Banco de dados utilizado para armazenar os dados dos participantes e dos sorteios.
- **JasperReports**: Ferramenta de geração de relatórios para Java.

## Pré-requisitos

- Java Development Kit 20 (JDK) instalado
- MySQL Server instalado e configurado
- Bibliotecas JasperReports adicionadas ao projeto

## Instalação e Configuração

1. Clone este repositório: `git clone https://github.com/lucasrznd/sorteador-educadora.git`
2. Importe o projeto em sua IDE Java (Recomendo NetBeans).
3. Configure as credenciais do banco de dados no arquivo de conexão.
4. Certifique-se de que as bibliotecas JasperReports estão configuradas corretamente.

## Uso

1. Execute a aplicação.
2. Adicione participantes à tabela.
3. Escolha o brinde e o locutor.
4. Realize o sorteio clicando no botão correspondente.
5. Gere o Vale-Brinde quando necessário.

## Contribuindo

Contribuições são bem-vindas! Se deseja contribuir com o projeto, siga estes passos:

1. Faça um fork do repositório.
2. Crie uma branch para sua feature: `git checkout -b feature-nova`.
3. Faça commit das suas mudanças: `git commit -am 'Adiciona nova feature'`.
4. Faça push para a branch: `git push origin feature-nova`.
5. Abra um Pull Request.

## Telas

<div>
  <img src="https://github.com/lucasrznd/sorteador-educadora/blob/main/src/main/resources/images/readme/1.%20view-principal.png" width="500px" />
  <img src="https://github.com/lucasrznd/sorteador-educadora/blob/main/src/main/resources/images/readme/3.%20view-valebrinde.png" width="500px" height="375px" />
</div>
