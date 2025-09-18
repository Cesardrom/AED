# Ejercicios de Creación y uso de elementos básicos en PHP
### Variables y Condicionales

- Mayor de dos números
Pide dos números y muestra cuál es mayor o si son iguales.

***Codigo***
```php
<?php
$random_number_1 = random_int(1, 10);
$random_number_2 = random_int(1, 10);
$result = 'Los numeros son iguales';
if ($random_number_1 > $random_number_2){
    $result = "$random_number_1 (numero 1) es mayor que $random_number_2 (numero 2)";
} 
elseif ($random_number_1 < $random_number_2){
    $result = "$random_number_2 (numero 2) es mayor que $random_number_1 (numero 1)";
}
echo $result
?>
```

***Salida***

```bash
7 (numero 1) es mayor que 2 (numero 2)
```

- Edad permitida
Pide la edad de una persona y muestra:
"Eres menor de edad" si es < 18.
"Eres mayor de edad" si es ≥ 18.

***Codigo***
```php
<?php
$random_number = random_int(1, 100);
$result = "Eres mayor de edad ($random_number) ";
if ($random_number < 18 ){
    $result = "Eres menor de edad ($random_number)";
} 
echo $result
?>
```

***Salida***

```bash
Eres menor de edad (8)
```

- Positivo, negativo o cero
Comprueba si un número almacenado en una variable es positivo, negativo o cero.

***Codigo***
```php
<?php
$random_number = random_int(-100, 100);
$result = "El numero ($random_number) es positivo";
if ($random_number < 0 ){
    $result = "El numero ($random_number) es negativo";
} 
elseif ($random_number == 0 ){
    $result = "El numero es 0";
} 
echo $result
?>
```

***Salida***

```bash
El numero (23) es positivo
```

- Nota final
Pide la nota de un alumno y muestra:
"Suspenso" (< 5), "Aprobado" (5–6), "Notable" (7–8), "Sobresaliente" (9–10).

***Codigo***
```php
<?php
$random_number = random_int(0, 10);
$result = "Suspendido ($random_number)";
if ($random_number >= 5 and $random_number <= 6 ){
    $result = "Aprobado ($random_number)";
}
elseif ($random_number >= 7 and $random_number <= 8 ){
    $result = "Notable ($random_number)";
}
elseif ($random_number >= 9 and $random_number <= 10 ){
    $result = "Sobresaliente ($random_number)";
}  

echo $result
?>
```

***Salida***

```bash
Notable (7)
```

### Bucles (for, while, foreach)

- Contar del 1 al 100
Muestra los números del 1 al 100 en pantalla.

***Codigo***
```php
<?php
$result = 1;
while ($result <= 100){
    echo "$result \n";
    $result++;
}
?>
```

***Salida***

```bash
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 
```

- Suma acumulada
Calcula la suma de los números del 1 al 50 usando un bucle.

***Codigo***
```php
<?php
$number = 1;
$result = 0;
while ($number <= 50){
    $result = $result + $number;
    $number++;
}

echo $result
?>
```

***Salida***

```bash
1275
```

- Tabla de multiplicar
Pide un número y genera su tabla de multiplicar del 1 al 10.

***Codigo***
```php
<?php
$number = random_int(1, 1000);
$result = [];
for ($multiply = 0; $multiply <= 10; $multiply++){
    array_push($result, $number*$multiply); 
}
print_r($result);
?>
```

***Salida***

```bash
Array ( [0] => 0 [1] => 10 [2] => 20 [3] => 30 [4] => 40 [5] => 50 [6] => 60 [7] => 70 [8] => 80 [9] => 90 [10] => 100 ) 
```

- Números pares
Muestra todos los números pares entre 1 y 50.

***Codigo***
```php
<?php
for ($number= 0; $number <= 50; $number++){
    if ($number % 2 == 0){
        echo "$number \n";
    };
}

?>
```

***Salida***

```bash
0 2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 
```

- Cuenta atrás
Haz un bucle que cuente de 10 a 1 y luego muestre "¡Fin!".

***Codigo***
```php
<?php
for ($number = 10; $number >= 1; $number--) {
    echo "$number \n";
}
echo "¡FIN!"
?>

```

***Salida***

```bash
10 9 8 7 6 5 4 3 2 1 ¡FIN!
```

- Factorial
Calcula el factorial de un número introducido (ejemplo: 5! = 120).

***Codigo***
```php
<?php
$number = random_int(1, 100);
function factorial($n) {
    if ($n == 0 || $n == 1) {
        return 1;
    } else {
        return $n * factorial($n - 1);
    }
}
$result = factorial($number);
echo "El numero $number en factorial es $result"
?>

```

***Salida***

```bash
El numero 10 en factorial es 3628800
```

### Combinando Condicionales y Bucles

- Números primos
Escribe un algoritmo que muestre los números primos entre 1 y 50.

***Codigo***
```php
<?php
function isPrime($num) {
    if ($num <= 3 or $num == 1) return true;
    if ($num % 2 == 0 || $num % 3 == 0) return false;
    for ($i = 5; $i * $i <= $num; $i += 6) {
        if ($num % $i == 0 || $num % ($i + 2) == 0) return false;
    }
    return true;
}

echo "Números primos del 1 al 50:\n";
for ($number = 1; $number <= 50; $number++) {
    if (isPrime($number)) {
        echo $number . "\n";
    }
}
?>

```

***Salida***

```bash
Números primos del 1 al 50: 1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 
```

- Fibonacci
Genera los primeros 20 términos de la secuencia de Fibonacci.

***Codigo***
```php
<?php
$number = random_int(1, 100);

function fibonacci_sequence($n) {
    $sequence = [0, 1];
    for ($i = 2; $i <= $n; $i++) {
        $sequence[$i] = $sequence[$i - 1] + $sequence[$i - 2];
    }
    return $sequence;
}

$sequence = fibonacci_sequence($number);
echo implode(' ', $sequence);
?>

```

***Salida***

```bash
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765

```

- Múltiplos de un número
Pide un número n y muestra sus múltiplos hasta 100.

***Codigo***
```php
<?php
$number = random_int(1, 100);
if ($number > 0) {
    $multiples = [];
    for ($i = $number; $i <= 100; $i += $number) {
        $multiples[] = $i;
    }
    echo "Los múltiplos de $number hasta 100 son: " . implode(', ', $multiples) . "\n";
} 
?>

```

***Salida***

```bash
Los múltiplos de 8 hasta 100 son: 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96 
```

- Suma de pares e impares
Calcula la suma de los números pares e impares entre 1 y 100 por separado.

***Codigo***
```php
<?php
$odd_result = 0;
$even_result = 0;
for ($number= 0; $number <= 100; $number++){
    if ($number % 2 == 0){
        $even_result += $number; 
    } else{
      $odd_result += $number;  
    }
}
echo "La suma de los pares es $even_result \n";
echo "La suma de los impares es $odd_result";
?>

```

***Salida***

```bash
La suma de los pares es 2550 La suma de los impares es 2500
```

- Adivinar número
Genera un número aleatorio entre 1 y 20.
Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: "Mayor" o "Menor".

***Codigo***
```php
<?php
session_start();

if (!isset($_SESSION['randomNumber'])) {
    $_SESSION['randomNumber'] = random_int(1, 20);
}

$message = '';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $guess = intval($_POST['guess']);
    $randomNumber = $_SESSION['randomNumber'];

    if ($guess === $randomNumber) {
        $message = "¡Correcto! El número era $randomNumber.";
        unset($_SESSION['randomNumber']);
    } elseif ($guess < $randomNumber) {
        $message = "Mayor";
    } else {
        $message = "Menor";
    }
}
?>
<!DOCTYPE html>
<html>
<head>
    <title>Adivina el Número</title>
</head>
<body>
    <h1>Adivina el número entre 1 y 20</h1>
    <p><?php echo $message; ?></p>
    <form method="post">
        Introduce tu intento: <input type="number" name="guess" min="1" max="20" required>
        <input type="submit" value="Adivinar">
    </form>
</body>
</html>

```

***Salida***

```bash
Adivina el número entre 1 y 20

¡Correcto! El número era 11.
Introduce tu intento: 
```

### Construcción de Algorítmicos

- Número perfecto
Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).

***Codigo***
```php
function esPerfecto($num) {
    $suma = 0;
    for ($i = 1; $i < $num; $i++) {
        if ($num % $i == 0) {
            $suma += $i;
        }
    }
    return $suma == $num;
}

$numero = 28;
echo "Número: $numero\n";
echo "¿Es perfecto? " . (esPerfecto($numero) ? "Sí" : "No") . "\n\n";
```

***Salida***

```bash
Número: 28 ¿Es perfecto? Sí 
```

- Invertir número
Escribe un algoritmo que invierta los dígitos de un número (ejemplo: 123 → 321).

***Codigo***
```php
function invertirNumero($num) {
    $invertido = 0;
    while ($num > 0) {
        $invertido = $invertido * 10 + $num % 10;
        $num = intdiv($num, 10);
    }
    return $invertido;
}

$numero = 123;
echo "Número original: $numero\n";
echo "Número invertido: " . invertirNumero($numero) . "\n\n";
```

***Salida***

```bash
Número original: 123 Número invertido: 321
```

- Palíndromo
Comprueba si una palabra almacenada en una variable es palíndroma.

***Codigo***
```php
function esPalindromo($palabra) {
    $palabra = strtolower($palabra);
    return $palabra == strrev($palabra);
}

$palabra = "Anilina";
echo "Palabra: $palabra\n";
echo "¿Es palíndroma? " . (esPalindromo($palabra) ? "Sí" : "No") . "\n\n";
```

***Salida***

```bash
Anilina ¿Es palíndroma? Sí 
```

- Máximo común divisor (MCD)
Escribe un algoritmo que calcule el MCD de dos números.

***Codigo***
```php
function mcd($a, $b) {
    while ($b != 0) {
        $temp = $b;
        $b = $a % $b;
        $a = $temp;
    }
    return $a;
}

$a = 48;
$b = 18;
echo "Números: $a y $b\n";
echo "MCD: " . mcd($a, $b) . "\n\n";
```

***Salida***

```bash
Números: 48 y 18 MCD: 6 
```

- Triángulo de asteriscos
Muestra en pantalla un triángulo de altura n usando *.
Ejemplo con n = 5:

***Codigo***
```php
function trianguloAsteriscos($n) {
    for ($i = 1; $i <= $n; $i++) {
        echo str_repeat("*", $i) . "\n";
    }
}

$n = 5;
echo "Triángulo de altura $n:\n";
trianguloAsteriscos($n);
```

***Salida***

```bash
Triángulo de altura 5: 
* 
** 
*** 
**** 
***** 
```