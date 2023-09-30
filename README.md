# Desafio SpringBoot API de Pagamento

Esta é uma API Spring Boot para gerenciar pagamentos, com suporte a várias funcionalidades, incluindo criação, atualização, exclusão e consulta de pagamentos. Este README fornece uma visão geral do projeto, instruções de configuração e uso, bem como informações importantes para os desenvolvedores.

## Índice

- Requisitos
- Configuração do Ambiente
- Execução do Projeto
- Documentação da API
- Contribuição
- Licença

## Requisitos

Antes de começar a usar a API de Pagamento, certifique-se de ter as seguintes ferramentas e recursos instalados:

- Java JDK 8 ou superior
- Spring Boot
- Banco de Dados (por exemplo, PostgreSQL, MySQL, H2, etc.)

## Configuração do Ambiente

1. Clone este repositório em sua máquina local:

   git clone https://github.com/seu-usuario/seu-projeto.git

2. O banco de dados está configurado como H2 com as configurações no arquivo `application.properties`

3. Execute o projeto Spring Boot:

   ./mvnw spring-boot:run

A API estará acessível em http://localhost:8080 por padrão.

## Execução do Projeto

Agora que o projeto está em execução, você pode começar a usar a API de Pagamento. Aqui estão alguns exemplos de como interagir com a API:

- Criação de Pagamento: Use um cliente HTTP (como o Postman, Thunder Client no VSCode ou qualquer outro de sua preferência) para criar pagamentos enviando uma solicitação POST para /api/pagamentos.

- Atualização de Status: Use uma solicitação PUT para /api/pagamentos/{id} para atualizar o status de um pagamento existente.

- Consulta de Pagamentos: Use solicitações GET para /api/pagamentos para listar pagamentos e aplique parâmetros de consulta para filtrar resultados.

- Exclusão de Pagamento: Use uma solicitação DELETE para /api/pagamentos/{id} para excluir um pagamento.
