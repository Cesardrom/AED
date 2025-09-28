# Ejercicios de Acceso a Datos: "Operaciones matemáticas con CSV y estadísticas de palabras"

## 1) Operaciones matemáticas desde CSV

Enunciado: Lee un archivo CSV con operaciones matemáticas (número1, número2, operación), calcula el resultado y guarda en otro CSV.

Funciones/Comandos sugeridos: file, explode, file_put_contents

### Código:

```php
<?php
    $filename = "Auxiliar/ops.csv";
    $result = [];
    foreach(file($filename) as $line){
        $line = trim($line);
        $array_line = explode(",", $line);
        $operation_result = operation($array_line);
        array_push($result, "$line,$operation_result");
    }
    $result = implode("\n", $result);
    file_put_contents("Auxiliar/resultado.csv", $result);

    function operation(array $line): mixed{
        $number_1 = $line[0];
        $number_2 = $line[1];
        switch ($line[2]) {
            case "suma":
                return $number_1 + $number_2;
            case "resta":
                return $number_1 - $number_2;
            case "producto":
                return $number_1 * $number_2;
            case "division":
                if ($number_1 != 0 and $number_2 != 0){
                    return $number_1 / $number_2;
                }
                return "ERROR no se puede dividir por 0";
            default:
                return "Esta operacion no esta permitida";
        }
    }
?>
```

### Salida:

(No hay salida explícita, el resultado se guarda en resultado.csv)

### Fichero inicial:

ops.csv
3,1,suma
10,4,resta
2,8,resta
5,2,producto
7,0,producto
9,3,division
10,3,division
8,0,division

### Fichero generado:

resultado.csv
3,1,suma,4
10,4,resta,6
2,8,resta,-6
5,2,producto,10
7,0,producto,0
9,3,division,3
10,3,division,3.3333333333333
8,0,division,ERROR no se puede dividir por 0

## 2) Estadísticas de palabras en un texto

Enunciado: Lee un archivo de texto, cuenta la frecuencia de cada palabra y guarda las estadísticas en un CSV.

Funciones/Comandos sugeridos: file_get_contents, str_word_count, array_count_values, fopen, fwrite

### Código:

```php
<?php

countWords();

function countWords(){
    $filename = "Auxiliar/texto.txt";
    $filename2 = "Auxiliar/estadisticas.csv";


    $text = file_get_contents($filename);
    $text = strtolower($text);
    $words = str_word_count($text, 1);

    $frecuency = array_count_values($words);

    $file = fopen($filename2,"w");

    foreach ($frecuency as $word => $cuantity) {
        fwrite($file,  "$word,$cuantity\n");
    }
    fclose($file);
}



?>
```

### Salida:

(No hay salida explícita, el resultado se guarda en estadisticas.csv)

### Fichero inicial:

texto.txt
PHP es muy divertido y potente

### Fichero generado:

estadisticas.csv
php, 1
es, 1
muy, 1
divertido, 1
y, 1
potente, 1

#### Ejercicio realizado por César Domínguez Romero
