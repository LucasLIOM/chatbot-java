Um chatbot criado com integração no banco de dados local, com mensagens programadas e permitindo:

- Cadastro de usuario
- Delete de usuario
- Atualizar usuario
- Listar os usuarios cadastrados
- Criação de mensagens
- Agrupamento de conversas

É uma simples aplicação que gerencia clientes, mensagens e conversas. Utiliza a classe JAVA.SWING com JOPTION para interface, ao inves do uso do Sysout
*Ainda em construção, faltam pequenos ajustes pra ficar rodando liso, mas já da pra ter uma ideia.
Modelagem de dados: Um cliente pode possuir várias conversas, e cada conversa pode conter várias mensagens. As mensagens podem ser enviadas pelo cliente ou pelo chatbot.

Exemplo:
QueryMYSQL

CLIENTE 
id_cliente (PK)
nome
telefone

CONVERSA
id_conversa (PK)
id_cliente (FK)

MENSAGEM
id_mensagem (PK)
id_conversa (FK)
texto
data_envio
tipo (cliente ou bot)

+------------------+
|     CLIENTE      |
+------------------+
| id_cliente (PK)  |
| nome             |
| telefone         |
+------------------+
          |
          | 1:N
          |
+------------------+
|    CONVERSA      |
+------------------+
| id_conversa (PK) |
| id_cliente (FK)  |
+------------------+
          |
          | 1:N
          |
+------------------+
|    MENSAGEM      |
+------------------+
| id_mensagem (PK) |
| id_conversa (FK) |
| conteudo         |
| data_envio       |
| tipo             |
+------------------+
