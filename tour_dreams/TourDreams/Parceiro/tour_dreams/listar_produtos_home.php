<?php

	header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
    header("Cache-Control: post-check=0, pre-check=0", false);
    header("Pragma: no-cache");
	ini_set('default_charset','UTF-8');
	header("Content-Type: text/html; charset=ISO-8859-1", true);
	header("Content-Type: text/html; charset=UTF-8", true);

	include_once 'conexao.php';


	$sql = $dbcon->query("select * from view_produto where status = 'Aprovado'");

	if(mysqli_num_rows($sql) > 0){

		$lista = [];

		while($dados = $sql->fetch_array()){
		
			
			$obj = array("id_produto" => $dados['id_produto'] ,
      "nome" => $dados['nome_fantasia'],
      "status" => $dados['status'],
      "tipo_viagem" =>$dados['tipo_viagem'],
      "estilo_produto" => $dados['estilo_produto'],
      "qtd_milhas" => $dados['qtd_milhas'],
	  "preco" => number_format($dados['preco_diaria'], 2, "," , "."),
      "numero_cep" => $dados['numero_cep'],
      "logradouro" => $dados['logradouro'],
      "numero" => $dados['numero'],
      "complemento" => $dados['complemento'],
      "bairro" => $dados['bairro'],
      "local" => $dados['cidade'] . " - " .$dados['uf'],
      //"uf" => $dados['uf'],
      "img_produto" => $dados['foto_principal'],
      "descricao" => $dados['descricao_produto']); 
	  

			$lista[] = $obj;
		}
		

		echo json_encode($lista);


	}

?>
