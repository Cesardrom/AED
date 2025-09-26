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