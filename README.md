# email-service

Examplo de arquitetura:

![it_diag drawio](https://user-images.githubusercontent.com/74393908/217628459-fd624e9f-156d-4c78-95ba-8bca95187232.png)


- Mapear as api's necessárias para cada funcionalidade identificada.
- Separar essas funcionalidades em microserviços

### Melhorias para a funcionalidade enviar email:

- Uma tabela para salvar os emails que foram enviados com sucesso;
- E outra para os emails que tiveram falha no envio;
- Agendar uma tarefa para buscar todos esses emails que falharam e tentar reenviar;
