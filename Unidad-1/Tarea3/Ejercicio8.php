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

