<?php
    $filename = "Auxiliar/ops.csv";
    $result = [];
    foreach(file($filename) as $line){
        $line = trim($line);
        $array_line = explode(",", $line); 
        $operation_result = operation($array_line);
        array_push($result, "$line,$operation_result\n");
    }
    $result = implode(',', $result);
    file_put_contents("Auxiliar/resultado.csv", $result);

    function operation(array $line): mixed{
        print_r($line);
        $number_1 = $line[0];
        $number_2 = $line[1];
        echo $line[2];
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
