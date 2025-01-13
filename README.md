# Receptor GPS 🌎

O projeto trata-se de uma API que conta com os endpoints GET e POSTt. Ela permite que você adicione novos locais e pontos de interesse como academias, restaurantes e etc e, como base no limite de distância indicado pelo usuário na requisicão, indica os locais próximos a ele.

## Ferramentas

[![My Skills](https://skillicons.dev/icons?i=java,spring,vscode)](https://skillicons.dev)

## API ENDPOINTS

1. **POST**
```json
{
	"name": "Churrascaria",
	"x": 28,
	"y": 2
}

```
2. **GET /points-of-interests**
  (Retorna todos os locais cadastrados no nosso banco de dados)
   ```json
   [
	{
		"id": 1,
		"name": "Lanchonete",
		"x": 27,
		"y": 12
   }
   ]
   ```
   
3. **GET /near-me** (Retorna os locais dentro da ditância permitida)
   ```json
	[
	{
		"id": 1,
		"name": "Lanchonete",
		"x": 27,
		"y": 12
	},
	{
		"id": 3,
		"name": "Joalheria",
		"x": 15,
		"y": 12
   }
   ]
   ```

## Contribua

1. **Clone o repositório**: `https://github.com/BrendaBraganca/receptor-gps`
2. **Crie feature/branch**: `git checkout -b feature/main`

## License

This software is available under the following licenses:

- [MIT](https://rem.mit-license.org)
