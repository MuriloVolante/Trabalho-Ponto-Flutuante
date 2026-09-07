O que a atividade pede: receber expressao infixa, converter pra RPN e calcular o resultado usando pilha. Numeros inteiros e decimais, operadores + - * /, parenteses, double.

Como funciona: tokenizar separa a expressao em tokens. paraRPN converte pra RPN. calcularRPN resolve a RPN com pilha. main roda os 5 testes.

Resultado esperado:

```
=========================
Expressão 1: (2 + 3) * 4
--------------------------
Infixa: (2 + 3) * 4
RPN: 2 3 + 4 *
Resultado: 20.0
=========================
=========================
Expressão 2: 10 / 2 - 3
--------------------------
Infixa: 10 / 2 - 3
RPN: 10 2 / 3 -
Resultado: 2.0
=========================
=========================
Expressão 3: 3.5 * (2 + 1.5)
--------------------------
Infixa: 3.5 * (2 + 1.5)
RPN: 3.5 2 1.5 + *
Resultado: 12.25
=========================
=========================
Expressão 4: 8 + 2 * (3 - 1) / 4
--------------------------
Infixa: 8 + 2 * (3 - 1) / 4
RPN: 8 2 3 1 - * 4 / +
Resultado: 9.0
=========================
=========================
Expressão 5: ((1 + 2) * (3 + 4)) / 7
--------------------------
Infixa: ((1 + 2) * (3 + 4)) / 7
RPN: 1 2 + 3 4 + * 7 /
Resultado: 3.0
=========================
```

O que a atividade pede (parte 3): investigar o comportamento do double em ponto flutuante, executando 5 expressoes que evidenciam diferenca entre resultado matematico esperado e resultado obtido.

Como funciona: main agora pergunta se quer rodar os testes da parte 2 ou da parte 3. A parte 3 usa o mesmo tokenizar, paraRPN e calcularRPN, só troca as expressoes testadas.

Resultado esperado:

```
=========================
Expressão 1: 0.1 + 0.2
--------------------------
Infixa: 0.1 + 0.2
RPN: 0.1 0.2 +
Resultado: 0.30000000000000004
=========================
=========================
Expressão 2: 0.1 + 0.1 + 0.1
--------------------------
Infixa: 0.1 + 0.1 + 0.1
RPN: 0.1 0.1 + 0.1 +
Resultado: 0.30000000000000004
=========================
=========================
Expressão 3: (0.1 + 0.2) - 0.3
--------------------------
Infixa: (0.1 + 0.2) - 0.3
RPN: 0.1 0.2 + 0.3 -
Resultado: 5.551115123125783E-17
=========================
=========================
Expressão 4: 1.0 / 3.0
--------------------------
Infixa: 1.0 / 3.0
RPN: 1.0 3.0 /
Resultado: 0.3333333333333333
=========================
=========================
Expressão 5: 10000000000000000.0 + 1.0
--------------------------
Infixa: 10000000000000000.0 + 1.0
RPN: 10000000000000000.0 1.0 +
Resultado: 1.0E16
=========================
```
