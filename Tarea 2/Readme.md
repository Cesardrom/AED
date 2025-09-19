## Introducción a Php, uso de funciones

### Número capicúa (palíndromo numérico)

Implementa una función esCapicua(int $n): bool que determine si un número entero positivo es capicúa.

Un número es capicúa si se lee igual de izquierda a derecha que de derecha a izquierda.

Ejemplo: 12321 → true

***Codigo***
```php
function esCapicua(int $number):bool{
        $reversed_number = strrev($number);
        if ($reversed_number == "$number"){
            echo "El numero $number es capicua <br>";
            return true;
        }
        echo "El numero $number no es capicua <br>";
        return false;
    }


    esCapicua(123321);
    esCapicua(111222);
```

***Salida***

```bash
El numero 123321 es capicua
El numero 111222 no es capicua 
```

### Escalera de asteriscos

Implementa una función montañaAsteriscos(int $n, $m): void que imprima una escalera de asteriscos de altura Ny el tamaño M.

La primera fila contiene 1 asterisco, la segunda 2, y así hasta N, M veces.

Ejemplo con entrada 4,2:

```bash
*.     *
**.   **
***  ***
********
```

***Codigo***
```php

```

***Salida***

```bash

```

### Suma de dígitos

Implementa una función sumaDigitos(int $n): int que calcule la suma de los dígitos de un número entero positivo.

Descompón el número en dígitos y súmalos.

Ejemplo: 2025 → 9 (2+0+2+5)

Número secreto (múltiplos de 3 o 5)

***Codigo***
```php
function sumaDigitos(int $number): int{
        $result = 0;
        $number_in_text = "$number";
        for($i=0;$i<strlen($number_in_text);$i++){
            $digit = $number_in_text[$i];
            $result += $digit;
        }
        echo "El resultado de sumar los digitos de $number es $result <br>";
        return $result;
    }
    sumaDigitos(3452);
    sumaDigitos(1212);
```

***Salida***

```bash
El resultado de sumar los digitos de 3452 es 14
El resultado de sumar los digitos de 1212 es 6 
```

### Implementa una función multiplosTresOCinco(int $n): array que devuelva todos los múltiplos de 3 o 5 menores que N.

Además, calcula la suma de dichos múltiplos.

Ejemplo con entrada 10:

3, 5, 6, 9
Suma = 23

***Codigo***
```php
function multiplosTresOCinco(int $n): array{
        $result = [];
        for ($number = 3; $number < $n; $number++){
            if ($number % 3 == 0 or $number % 5 == 0){
                array_push($result, $number);
            }

        }
        $suma = array_sum($result);
        $result_string = implode(", ", $result);
        echo "$result_string <br>";
        echo "Suma = $suma <br>";
        return $result;
    }

    multiplosTresOCinco(10);
    multiplosTresOCinco(20);
```

***Salida***

```bash
El resultado de sumar los digitos de 3452 es 14
El resultado de sumar los digitos de 1212 es 6 
```

### Secuencia de Collatz

Implementa una función secuenciaCollatz(int $n): array que genere la secuencia de Collatz a partir de un entero positivo.

Si el número es par → dividir entre 2.
Si es impar → multiplicar por 3 y sumar 1.
Repetir hasta llegar a 1.

Ejemplo con entrada 6:

6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1

***Codigo***
```php
function secuenciaCollatz(int $n): array{
        $result = [];
        while ($n > 1){
            if ($n % 2 == 0){
                $n = $n / 2;
                array_push($result,$n ); 
            } else {
                $n = $n * 3 + 1;
                array_push($result, $n);
            }
        }
        $result_string = implode(",", $result);
        echo $result_string;
        return $result;
    }

    secuenciaCollatz(23);
    
```

***Salida***

```bash
70,35,106,53,160,80,40,20,10,5,16,8,4,2,1
```


