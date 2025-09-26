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
