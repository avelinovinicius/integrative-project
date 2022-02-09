# Integrative Project

Integrative Project é um projeto de conclusão de curso da Digital House em parceria com o Mercado Livre.

## Projeto

O projeto consiste em um e-commerce do Meli com o adicional de produtos CONGELADOS, REFRIGERADOS e FRESCOS.

## Endpoint

Existem diversos endpoints nesta aplicação, desde cadastramento de produtos até a realização do carrinho de compras. O endpoint aqui abordado é o de paginação.

Este endpoint consiste em trazer todos os produtos cadastrados em uma página, podendo ser ordenados por nome, data de validade e temperatura devido o contexto da API.

## findAlIPaged

```java
 @GetMapping("/list/page")
    public ResponseEntity<Page<ProductResponseDTO>> findAllPaged(Pageable pageable)
    {
    	Page<ProductResponseDTO> list = service.findAllPaged(pageable);
    	return ResponseEntity.ok().body(list);
    }
```

## Rota no postman

A rota consiste da seguinte forma:

```
localhost:8080/api/v1/fresh-products/list/page?page=0&size=2&sort=name,asc
```
Para que a paginação ocorra de maneira correta, se atentar aos seguintes parametros:

page - é por onde você navegará, as páginas começam no 0.

size - é a quantidade de itens que deverá aparecer por página.

sort - é a ordenação que a página seguirá - (name,asc) - será ordenada por nome, de forma ascendente.

## License
API developed by Group 5 (Everton de Souza Silva, Henrique Fernandes Yoshida, Lemuel Zara, Lucca Gabriel Dias Barbosa e Vinícius
Avelino).
