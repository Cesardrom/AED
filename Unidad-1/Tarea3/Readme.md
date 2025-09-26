# Ejercicios de Acceso a Datos: "Ficheros"

## 1) Hola fichero (crear y leer)

Enunciado: Crea un fichero datos.txt con el texto "Hola Mundo desde PHP" y, a continuación, léelo y muestra su contenido por pantalla.

Funciones/Comandos sugeridos: file_put_contents, file_get_contents

### Código:

```php
<?php
    $filename = "Auxiliar/datos.txt";
    file_put_contents($filename, "Hola Mundo desde PHP");
    echo file_get_contents($filename);
?>
```

### Salida:

Hola Mundo desde PHP

### Fichero generado:

datos.txt
Hola Mundo desde PHP

## 2) Guardar números en un fichero

Enunciado: Almacena en numeros.txt los números del 1 al 10 (cada número en una línea). Luego léelo y muestra todos los números.

Funciones sugeridas: fopen, fwrite, fclose, file

### Código:

```php
<?php
    $filename = "Auxiliar/numeros.txt";
    $file = fopen($filename, 'w');
    for($i = 1; $i <= 10; $i++){
        fwrite($file, "$i \n");
    }
    fclose($file);
    echo file_get_contents($filename);
?>
```

### Salida:

1
2
3
4
5
6
7
8
9
10

### Fichero generado:

numeros.txt
1
2
3
...
10

## 3) Contar palabras en un fichero

Enunciado: Escribe un texto en texto.txt, luego haz que tu programa cuente cuántas palabras contiene ese archivo.

Funciones sugeridas: file_get_contents, str_word_count

### Código:

```php
<?php
    $filename = "Auxiliar/texto.txt";
    file_put_contents($filename, "PHP es muy divertido y potente");
    $text = file_get_contents($filename);
    echo str_word_count($text);
?>
```

### Salida:

5

### Fichero generado:

texto.txt
PHP es muy divertido y potente.

## 4) Escribir y leer array en fichero

Enunciado: Guarda un array de nombres en nombres.txt (uno por línea). Después, léelo y muéstralos en lista numerada.

Funciones sugeridas: fopen, fwrite, fgets

### Código:

```php
<?php
    $filename = "Auxiliar/nombres.txt";
    $file = fopen($filename, "r");

?>
```

*Nota: El código parece incompleto, falta la parte de escritura.*

### Salida:

1. Ana
2. Luis
3. Marta
4. Carlos
5. Julia

### Fichero generado:

nombres.txt
Ana
Luis
Marta
Carlos
Julia

## 5) Copiar contenido de un fichero a otro

Enunciado: Copia el contenido de origen.txt en un archivo copia.txt.

Funciones sugeridas: copy, file_get_contents, file_put_contents

### Código:

```php
<?php
    $filename_1 = "Auxiliar/origen.txt";
    $filename_2 = "Auxiliar/copia.txt";
    file_put_contents($filename_1, "Hola PHP");
    $text = file_get_contents($filename_1);
    $copy = file_put_contents($filename_2, $text);
?>
```

### Salida:

(No hay salida explícita)

### Fichero inicial:

origen.txt
Este es el archivo original.

### Fichero resultante:

copia.txt
Este es el archivo original.

## 6) Invertir el contenido de un fichero

Enunciado: Lee frase.txt, invierte el texto y guarda el resultado en frase_invertida.txt.

Funciones sugeridas: file_get_contents, strrev, file_put_contents

### Código:

```php
<?php
    $filename_1 = "Auxiliar/frase.txt";
    $filename_2 = "Auxiliar/frase_invertida.txt";
    file_put_contents($filename_1, "Holiwi");
    $text = file_get_contents($filename_1);
    $inverted_text = strrev($text);
    $file = file_put_contents($filename_2, $inverted_text);
?>
```

### Salida:

(No hay salida explícita)

### Fichero inicial:

frase.txt
Hola PHP

### Fichero resultante:

frase_invertida.txt
PHP aloH

## 7) Calcular suma desde fichero

Enunciado: Guarda números separados por comas en datos_numericos.txt. Léelos y calcula su suma.

Funciones sugeridas: file_get_contents, explode, array_sum

### Código:

```php
<?php
    $filename = "Auxiliar/datos_numericos.txt";
    file_put_contents($filename, "10,20");
    $numbers = file_get_contents($filename);
    $numbers = explode(',', $numbers);
    echo array_sum($numbers);
?>
```

### Salida:

30

### Fichero:

datos_numericos.txt
10,20,30,40

## 8) Crear fichero de multiplicaciones

Enunciado: Genera la tabla del 5 y guárdala en tabla5.txt. Luego muéstrala.

Funciones sugeridas: fopen, fwrite, file

### Código:

```php
<?php
    $filename = "Auxiliar/tabla5.txt";
    $file = fopen($filename, 'w');
    $number = 5;
    for ($multiply = 1; $multiply <=10; $multiply++){
        $result = $number * $multiply;
        fwrite($file, "$number x $multiply = $result \n");
    }
    fclose($file)
?>
```

### Salida:

5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50

### Fichero:

tabla5.txt
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50

## 9) Registrar entradas de usuario

Enunciado: Guarda los nombres recibidos en un formulario dentro de usuarios.txt (cada nombre en una línea). Luego muéstralos.

Funciones sugeridas: fopen, fwrite, file

### Código:

```php
<?php
    $names = ["Ana", "Pedro", "Lucía"];
    $filename = "Auxiliar/usuarios.txt";
    $file = fopen($filename, "w");
    foreach ($names as $name) {
        fwrite($file, "$name \n");
    }
    fclose($file);

    $users = file($filename, FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
    echo "Lista de usuarios:\n";
    foreach ($users as $index => $user) {
        echo "$user \n";
    }
?>
```

### Salida:

Lista de usuarios:
Ana
Pedro
Lucía

### Fichero:

usuarios.txt
Ana
Pedro
Lucía

## 10) Leer JSON desde fichero

Enunciado: Crea datos.json con información de personas (nombre y edad). Haz que el programa lo lea y muestre los datos.

Funciones sugeridas: file_get_contents, json_decode

### Código:

```php
<?php
    $filename = "Auxiliar/datos.json";
    $data = file_get_contents($filename);
    $decoded_data = json_decode($data);
    print_r($decoded_data);
?>
```

### Salida:

Array
(
    [0] => stdClass Object
        (
            [nombre] => Ana
            [edad] => 25
        )

    [1] => stdClass Object
        (
            [nombre] => Luis
            [edad] => 30
        )

)

### Fichero:

datos.json
[
  {"nombre": "Ana", "edad": 25},
  {"nombre": "Luis", "edad": 30}
]

## 11) Diario personal secreto

Enunciado: Guarda entradas con fecha y hora en diario.txt. Luego muéstralas todas.

### Código:

```php
<?php
    $entry_1 = "He Saludado a mi vecino.";
    $entry_2 = "He comido pizza.";

    escribirEntrada($entry_1);
    sleep(5);
    escribirEntrada($entry_2);
    leerEntradas();

    function escribirEntrada($entrada) : void {
        $filename = "Auxiliar/diario.txt";

        $file = fopen($filename, "a");


        $datetime = date('[Y-m-d H:i:s]');
        $entry_date = "$datetime $entrada";

        fwrite($file, "$entry_date\n");
        fclose($file);
    }

    function leerEntradas() {
        $filename = "Auxiliar/diario.txt";

        $result = file_get_contents($filename);
        echo $result;
    }
?>
```

### Salida:

[2025-09-24 10:00] Hoy aprendí PHP con ficheros 😄
[2025-09-24 12:00] Almorcé pizza mientras programaba.

### Fichero:

diario.txt
[2025-09-24 10:00] Hoy aprendí PHP con ficheros 😄
[2025-09-24 12:00] Almorcé pizza mientras programaba.

## 12) Ranking de videojuegos

Enunciado: Guarda juegos con puntuaciones en ranking.txt, ordénalos y muestra el top 3.

### Código:

```php
<?php
$archivo = 'Auxiliar/ranking.txt';
$ranking = [];

$lineas = file($archivo);
foreach ($lineas as $linea) {
    $partes = explode(': ', $linea);
    if (count($partes) == 2) {
        $juego = $partes[0];
        $puntuacion = (int)$partes[1];
        $ranking[] = [$juego, $puntuacion];
    }
}

usort($ranking, function($a, $b) {
    return $b[1] <=> $a[1];
});

echo "Top 3 juegos:\n";
for ($i = 0; $i < min(3, count($ranking)); $i++) {
    echo ($i + 1) . ". " . $ranking[$i][0] . ": " . $ranking[$i][1] . "\n";
}
?>
```

### Salida:

Top 3 juegos:
1. Zelda: 10
2. Mario: 9
3. Sonic: 8

### Fichero:

ranking.txt
Zelda: 10
Mario: 9
Sonic: 8

## 13) Canción aleatoria

Enunciado: Guarda títulos en canciones.txt y muestra uno al azar.

### Código:

```php
<?php

$canciones = file('Auxiliar/canciones.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($canciones)) {
    $indiceAleatorio = array_rand($canciones);
    echo "Canción aleatoria: " . trim($canciones[$indiceAleatorio]) . "\n";
} else {
    echo "No se encontraron canciones en el archivo.\n";
}
?>
```

### Salida:

Canción aleatoria: Bohemian Rhapsody

### Fichero:

canciones.txt
Hysteria
Bohemian Rhapsody
Africa

## 14) Generador de excusas divertidas

Enunciado: Lee excusas desde excusas.txt y muestra una aleatoria.

### Código:

```php
<?php

$excusas = file('Auxiliar/excusas.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($excusas)) {
    $indiceAleatorio = array_rand($excusas);
    echo "Excusa aleatoria: " . trim($excusas[$indiceAleatorio]) . "\n";
} else {
    echo "No se encontraron excusas en el archivo.\n";
}
?>
```

### Salida:

Excusa aleatoria: Mi perro se comió la tarea.

### Fichero:

excusas.txt
Mi perro se comió la tarea.
El Wi-Fi decidió tomarse el día libre.
Me abdujeron los marcianos.

## 15) Lista de chistes (rotativos)

Enunciado: Muestra un chiste distinto en cada ejecución desde chistes.txt.

### Código:

```php
<?php

$chistes = file('Auxiliar/chistes.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($chistes)) {
    $ultimo = (int)file_get_contents('Auxiliar/ultimo_chiste.txt');
    $indice = $ultimo % count($chistes);
    echo "Chiste: " . trim($chistes[$indice]) . "\n";
    file_put_contents('Auxiliar/ultimo_chiste.txt', ($indice + 1) % count($chistes));
} else {
    echo "No se encontraron chistes en el archivo.\n";
}
?>
```

### Salida:

Chiste: ¿Sabes cuál es el colmo de un programador? Tener mala RAM-oria.

### Fichero:

chistes.txt
¿Sabes cuál es el colmo de un programador? Tener mala RAM-oria.
Ayer vi un bit triste… estaba des-bit-ido.
Yo no sudo, compilo.

## 16) Adivina la palabra

Enunciado: Elige una palabra de palabras.txt y muestra solo 2 letras, el usuario debe adivinarla.

### Código:

```php
<?php

$palabras = file('Auxiliar/palabras.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($palabras)) {
    $palabra = trim($palabras[array_rand($palabras)]);
    $longitud = strlen($palabra);
    if ($longitud > 2) {
        $pista = $palabra[0] . str_repeat('.', $longitud - 2) . $palabra[$longitud - 1];
    } else {
    }
    echo "Adivina la palabra: $pista\n";

    while (true) {
        $adivinanza = readline("Tu adivinanza: ");
        if (strtolower(trim($adivinanza)) === strtolower($palabra)) {
            echo "¡Correcto! La palabra era: $palabra\n";
            break;
        } else {
            echo "Incorrecto, intenta de nuevo.\n";
        }
    }
} else {
    echo "No se encontraron palabras en el archivo.\n";
}
?>
```

### Salida:

Adivina la palabra: m....a
Tu adivinanza: manzana
¡Correcto! La palabra era: manzana

### Fichero:

palabras.txt
manzana
platano
cereza

## 17) Generador de nombres para superhéroes

Enunciado: Combina palabras de adjetivos.txt y animales.txt.

### Código:

```php
<?php

$adjetivos = file('Auxiliar/adjetivos.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$animales = file('Auxiliar/animales.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($adjetivos) && !empty($animales)) {
    $adj = trim($adjetivos[array_rand($adjetivos)]);
    $animal = trim($animales[array_rand($animales)]);
    echo "Nombre de superhéroe: $adj $animal\n";
} else {
    echo "No se encontraron adjetivos o animales en los archivos.\n";
}
?>
```

### Salida:

Nombre de superhéroe: Increíble Tigre

### Ficheros:

adjetivos.txt
Increíble
Rápido
Misterioso

animales.txt
Tigre
Águila
Lobo

## 18) Encuesta de comidas favoritas

Enunciado: Guarda respuestas de usuarios en comidas.txt y genera ranking.

### Código:

```php
<?php

$comida = readline("¿Cuál es tu comida favorita? ");
file_put_contents('Auxiliar/comidas.txt', $comida . "\n", FILE_APPEND);

$comidas = file('Auxiliar/comidas.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$conteos = array_count_values($comidas);
arsort($conteos);

echo "Ranking de comidas favoritas:\n";
foreach ($conteos as $comida => $count) {
    echo "$comida: $count\n";
}
?>
```

### Salida:

¿Cuál es tu comida favorita? pizza
Ranking de comidas favoritas:
pizza: 2
sushi: 1
pasta: 1

### Fichero:

comidas.txt
pizza
sushi
pizza
pasta

## 19) Simulador de tweets

Enunciado: Guarda tweets en tweets.txt con fecha y hora, muestra los últimos 5.

### Código:

```php
<?php

$tweet = readline("Escribe tu tweet: ");
$fechaHora = date("Y-m-d H:i");
file_put_contents('Auxiliar/tweets.txt', "[$fechaHora] $tweet\n", FILE_APPEND);

$tweets = file('Auxiliar/tweets.txt', FILE_IGNORE_NEW_LINES);
$ultimos = array_slice($tweets, -5);

echo "Últimos 5 tweets:\n";
foreach ($ultimos as $t) {
    echo $t . "\n";
}
?>
```

### Salida:

Escribe tu tweet: Aprendiendo PHP con ejercicios divertidos #php
Últimos 5 tweets:
[2025-09-24 09:30] Aprendiendo PHP con ejercicios divertidos #php
[2025-09-24 10:00] Otro día más programando 🚀

### Fichero:

tweets.txt
[2025-09-24 09:30] Aprendiendo PHP con ejercicios divertidos #php
[2025-09-24 10:00] Otro día más programando 🚀

## 20) Historias locas (Mad Libs)

Enunciado: Reemplaza placeholders en plantilla.txt con palabras aleatorias de otros ficheros.

### Código:

```php
<?php

$plantilla = file_get_contents('Auxiliar/plantilla.txt');

$animales = file('Auxiliar/animales.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$lugares = file('Auxiliar/lugares.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
$comidas = file('Auxiliar/comidas.txt', FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);

if (!empty($animales) && !empty($lugares) && !empty($comidas)) {
    $animal = trim($animales[array_rand($animales)]);
    $lugar = trim($lugares[array_rand($lugares)]);
    $comida = trim($comidas[array_rand($comidas)]);

    $historia = str_replace(['[animal]', '[lugar]', '[comida]'], [$animal, $lugar, $comida], $plantilla);
    echo "Historia loca: $historia\n";
} else {
    echo "Faltan palabras en los archivos.\n";
}
?>
```

### Salida:

Historia loca: Un gato viajó a la Luna para comer tacos.

### Ficheros:

plantilla.txt
Un [animal] viajó a [lugar] para comer [comida].

animales.txt
gato
dragón
perro

lugares.txt
la Luna
Tokio
la playa

comidas.txt
tacos
ramen
helado.

#### Ejercicio realizado por César Domínguez Romero
