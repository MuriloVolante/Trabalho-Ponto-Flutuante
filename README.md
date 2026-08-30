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
