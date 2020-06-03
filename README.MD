# LifeBank Ticket's Challange!

Esta API é responsável por gerar boletos para o pagamento das faturas dos clientes do LifeBank.
Infelizmente temos um sério problema que está aborrecendo bastante nossos clientes e precisamos da sua ajuda para resolver.


# O problema...

Nosso serviço é novo e alguns clientes estão reportando erro ao tentar gerar o boleto para pagar a sua fatura, o que está gerando impacto na nossa receita de arrecadação.
Tanto nosso App mobile como nosso site consomem esta API para geração do boleto e em ambas as plataformas estamos tendo erro e mesmo analisando o tratamento das respostas da API não identificamos o problema.

## Tratamento de Respostas

As aplicações que consomem a API esperam determinadas respostas da API, entendendo da seguinte forma:

|                |Response                |Treatment                    |
|----------------|------------------------|-----------------------------|
|APP			 |HTTP Status: `200`      |Sucesso na chamada           |
|APP			 |HTTP Status: `404`      |Nenhum boleto encontrado     |
|Site			 |HTTP Status: `200`      |Sucesso na chamada           |
|Site			 |HTTP Status: `404`      |Nenhum boleto encontrado     |

## The challange...

Sua tarefa é descobrir o que pode estar acontecendo com nossa API para que nosso App e Site estejam quebrando ao tentar exibir alguns boletos, afinal o problema deve mesmo ser na API, seria coincidência demais um problema no APP e Site ao mesmo tempo, certo?

## Development

Para rodar o projeto você pode executa-lo em sua IDE de preferência ou executando o comando `mvn spring-boot:run` em seu terminal.
No caminho `src/main/resources` você encontrará o arquivo `database.sql` com uma base de dados pronta para você trabalhar.