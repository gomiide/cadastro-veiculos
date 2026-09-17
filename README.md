# Cadastro de Veículos OO

Sistema de Cadastro de Veículos em Java, utilizando Programação Orientada a Objetos, conforme especificação da atividade.

## Integrantes do Grupo

- Thiago Corrêa Medeiros — RA: 1134836
- Vitor Gomide — RA: 1140037
- Adrian Augusto Munaretti de Lemos — RA: 1139696

## Estrutura

- `src/Veiculo.java` — classe que representa um veículo (marca, modelo, ano, placa), com encapsulamento.
- `src/CadastroVeiculos.java` — classe principal, com o menu e as operações de cadastro, listagem e consulta. Os veículos são armazenados em memória em uma `List<Veiculo>`.

## Como compilar e executar

Pelo terminal, na raiz do projeto:

\`\`\`bash
javac -d bin src/Veiculo.java src/CadastroVeiculos.java
java -cp bin CadastroVeiculos
\`\`\`

## Funcionalidades

1. **Cadastrar Veículo** — valida placa duplicada e ano (entre 1900 e o ano atual + 1).
2. **Listar Veículos** — exibe todos os veículos cadastrados; informa caso não haja nenhum.
3. **Consultar Veículo** — busca por placa e exibe os dados, ou informa que não foi encontrado.
0. **Sair** — encerra o sistema.