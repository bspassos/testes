// Exemplo de pagamentos
pagamentos.add(Arrays.asList("Produto A", "Produto B", "Produto C"));
pagamentos.add(Arrays.asList("Produto A", "Produto C", "Produto C"));
pagamentos.add(Arrays.asList("Produto B", "Produto B", "Produto D"));

Map<String, Integer> quantidadeProdutos = pagamentos.stream()
        .flatMap(List::stream)
        .reduce(new HashMap<>(),
                (map, produto) -> {
                    map.put(produto, map.getOrDefault(produto, 0) + 1);
                    return map;
                },
                (map1, map2) -> {
                    map2.forEach((produto, quantidade) ->
                            map1.put(produto, map1.getOrDefault(produto, 0) + quantidade));
                    return map1;
                });

// Exibe a quantidade de cada produto
quantidadeProdutos.forEach((produto, quantidade) ->
        System.out.println(produto + ": " + quantidade));
