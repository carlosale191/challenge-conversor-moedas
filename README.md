## Sobre o Projeto

Conversor de moedas que extrai informações das taxas de conversão em tempo real via api ExchangeRate e realiza o cálculo da conversão. 
Trabalha com as opções de converter Real (BRL) para Dólar (USD), Euro (EUR), Libra (GBP) e Iene (JPY). Também fazendo a conversão dessas moedas para o Real.

## Tecnologias

- Java JDK 17
- Gson 2.10.1
- [ExchangeRate API](https://www.exchangerate-api.com/)
- Intellij IDEA Community Edition 2024.2.1

## Utilização

O conversor é iniciado já mostrando o menu de opções de comandos a serem digitados para uso, sendo esses baseados em números inteiros de 1 a 9.
Cada número corresponde a uma conversão descrita no menu, o 9 é usado para finalizar.
Depois de inserido o comando, é requisitado o valor que o usuário deseja converter com base em sua escolha de conversão.
O valor de conversão irá aparecer, atualizado conforme informa o serviço da API, e logo o recomeça caso o usuário queira realizar outra conversão.
Comandos de escolha fora do previsto e valores abaixo de 0 não serão aceitos para utilização.
