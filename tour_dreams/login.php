<?php

	header("Cache-Control: no-store, no-cache, must-revalidate, max-age=0");
    header("Cache-Control: post-check=0, pre-check=0", false);
    header("Pragma: no-cache");
	ini_set('default_charset','UTF-8');
	header("Content-Type: text/html; charset=ISO-8859-1", true);
	header("Content-Type: text/html; charset=UTF-8", true);

	$email = "";
	$senha = "";

	include_once 'conexao.php';

	$email=$_POST['email'];
	$senha=$_POST['senha'];

	$sql = $dbcon->query("select * from tbl_cliente WHERE email_cliente ='$email' and senha_cliente='$senha';");

	if(mysqli_num_rows($sql) > 0){
		session_start();
		echo"login_ok";
		echo",";
		while($dados = $sql->fetch_array()){

			
				echo utf8_encode ($dados['id_cliente']);
				echo",";
				echo utf8_encode ($dados['milhas']);
				echo",";
				echo utf8_encode ($dados['nome_cliente']);
				echo",";
				echo utf8_encode ($dados['rg_cliente']);
				echo",";
				echo utf8_encode ($dados['cpf_cliente']);
				echo",";
				echo utf8_encode ($dados['email_cliente']);
				echo",";
				echo utf8_encode ($dados['senha_cliente']);
				echo",";
				echo utf8_encode ($dados['celular_cliente']);
				echo",";
				echo utf8_encode ($dados['foto_cliente']);
		}
	}else{
		echo"login_erro";
	}




?>
