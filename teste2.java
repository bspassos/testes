List<List<String>> pagamentos = new ArrayList<>();

// Exemplo de pagamentos
pagamentos.add(Arrays.asList("Produto A", "Produto B", "Produto C"));
pagamentos.add(Arrays.asList("Produto A", "Produto C", "Produto C"));
pagamentos.add(Arrays.asList("Produto B", "Produto B", "Produto D"));

Map<String, Long> quantidadeProdutos = pagamentos.stream()
        .flatMap(List::stream)
        .collect(Collectors.groupingBy(produto -> produto, Collectors.counting()));

// Exibe a quantidade de cada produto
quantidadeProdutos.forEach((produto, quantidade) ->
        System.out.println(produto + ": " + quantidade));
