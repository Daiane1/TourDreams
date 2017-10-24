<?php

session_start();

include("conexao_banco.php");



if(isset($_POST['btnRegistrar']))
{

  $nome = $_POST['nome'];
  $email = $_POST['email'];
  $celular = $_POST['celular'];
  $cpf = $_POST['cpf'];
  $rg = $_POST['rg'];
  $senha = $_POST['senha'];
  $dt_nasc = $_POST['dt_nasc'];

  $dt_nasc = explode("/", $dt_nasc);

	$dia = $dt_nasc[0];
	$mes = $dt_nasc[1];
	$ano = $dt_nasc[2];

	$dt_banco = $ano."-".$mes."-".$dia;


  $sql="insert into tbl_cliente(nome_cliente, email_cliente, celular_cliente, cpf_cliente, rg_cliente, senha_cliente, dt_nasc)";
  $sql=$sql."values('".$nome."', '".$email."', '".$celular."', '".$cpf."', '".$rg."', '".$senha."', '".$dt_banco."')";

  mysql_query($sql);

  echo "<script type='text/javascript'>
  window.alert('Cadastrado com Sucesso')
  </script>";

}



 ?>
<?php



	if(isset($_POST['btn_logar_cliente']))
	{
		$cpf=$_POST['cpf'];
		$senha=$_POST['senha'];


		include("conexao_banco.php");

		$sql = "SELECT * FROM tbl_cliente where cpf_cliente = '".$cpf."' AND senha_cliente= '".$senha."'";
		$sqlResult = mysql_query($sql);

		if(mysql_num_rows ($sqlResult) > 0){
			$_SESSION['cpf_cliente'] = $cpf;
			$_SESSION['senha_cliente'] = $senha;

			if($consulta=mysql_fetch_array($sqlResult)){
				$id_cliente = $consulta['id_cliente'];
				$nome_cliente = $consulta['nome_cliente'];
				header("location:index.php?id_cliente=".$id_cliente."&nome_cliente=".$nome_cliente."");
			}

		}else{
			echo "<script type='text/javascript'>
			window.alert('Login ou Senha inválidos')
			</script>";
		}
	}


?>

<?php


if(isset($_POST['btnRegistrar_parceiro']))
{
  $empresa = $_POST['empresa'];
  $nome_parceiro = $_POST['nome_parceiro'];
  $cnpj = $_POST['cnpj'];
  $senha = $_POST['senha'];
  $gerente = $_POST['gerente'];
  $telefone = $_POST['telefone'];
  $celular = $_POST['celular'];
  $email = $_POST['email'];



  $sql="insert into tbl_parceiros(nome_empresa, nome_fantasia, cnpj, senha, nome_gerente, telefone, celular, email)";
  $sql=$sql."values('".$empresa."', '".$nome_parceiro."', '".$cnpj."', '".$senha."', '".$gerente."', '".$celular."', '".$telefone."', '".$email."')";
  mysql_query($sql);

	$id_parceiro=mysql_insert_id();

	$sql = "SELECT * FROM tbl_parceiros where id_parceiro='".$id_parceiro."'";
	$sqlResult = mysql_query($sql);

  if($consulta=mysql_fetch_array($sqlResult)){
		$id = $consulta['id_parceiro'];
		$nome_empresa = $consulta['nome_empresa'];
		header("location:Parceiro/cadastro_parceiro.php?nome_empresa=".$nome_empresa."&id_parceiro=".$id);
	}
}

 ?>

<?php



	if(isset($_POST['btn_logar_parceiro']))
	{
		$cnpj=$_POST['cnpj'];
		$senha=$_POST['senha'];


		include("conexao_banco.php");

		$sql = "SELECT * FROM tbl_parceiros where cnpj = '".$cnpj."' AND senha= '".$senha."'";
		$sqlResult = mysql_query($sql);

		if(mysql_num_rows ($sqlResult) > 0){
			$_SESSION['cnpj'] = $cnpj;
			$_SESSION['senha'] = $senha;

			if($consulta=mysql_fetch_array($sqlResult)){
				header("location:Parceiro/index.php");
			}

		}else{
			echo "<script type='text/javascript'>
			window.alert('Login ou Senha inválidos')
			</script>";
		}
	}
?>

<?php
		$cor = "#fff";
		$sql = "select * from tbl_cores";
		$select = mysql_query($sql);
		if($rsConsulta=mysql_fetch_array($select)){
			$cores=$rsConsulta['cores'];
		}
?>



<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>TourDreams | Cadastro User</title>

        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link  rel='stylesheet' type='text/css'>



        <link rel="stylesheet" href="assets/css/normalize.css">
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/fontello.css">
        <link href="assets/fonts/icon-7-stroke/css/pe-icon-7-stroke.css" rel="stylesheet">
        <link href="assets/fonts/icon-7-stroke/css/helper.css" rel="stylesheet">
        <link href="assets/css/animate.css" rel="stylesheet" media="screen">
        <link rel="stylesheet" href="assets/css/bootstrap-select.min.css">
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/icheck.min_all.css">
        <link rel="stylesheet" href="assets/css/price-range.css">
        <link rel="stylesheet" href="assets/css/owl.carousel.css">
        <link rel="stylesheet" href="assets/css/owl.theme.css">
        <link rel="stylesheet" href="assets/css/owl.transitions.css">
        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/css/responsive.css">
        <script type="text/javascript">

                  function mascaraData( campo, e )
          {
          	var kC = (document.all) ? event.keyCode : e.keyCode;
          	var data = campo.value;

          	if( kC!=8 && kC!=46 )
          	{
          		if( data.length==2 )
          		{
          			campo.value = data += '/';
          		}
          		else if( data.length==5 )
          		{
          			campo.value = data += '/';
          		}
          		else
          			campo.value = data;
          	}
          }
        </script>

		<style type="text/css">
		.header-connect{
			padding-top: 10px;
			background-color:<?php switch ($cores) {case "": echo $cor;break; default: echo $cores;break;}?>;
		}
		</style>

    </head>
    <body>


        <div class="header-connect">
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-8  col-xs-12">
                        <div class="header-half header-call">
                            <p>
                                <span><i class="pe-7s-call"></i> (11) 4222-2020</span>
                                <span><i class="pe-7s-mail"></i> tour_dreams@tour.com</span>
                            </p>
                        </div>
                    </div>
                    <div class="col-md-2 col-md-offset-5  col-sm-3 col-sm-offset-1  col-xs-12">
                        <div class="header-half header-social">
                            <ul class="list-inline">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <?php
        @$id_cliente = $_GET['id_cliente'];

         if ($id_cliente) {
           include('menu_logado.php');
         }else {
           include('menu_nLogado.php');
         }
        ?>





        <div class="register-area" style="background-color:#FFF;">
            <div class="container">

                <div class="col-md-6">
                    <div class="box-for overflow">
                        <div class="col-md-12 col-xs-12 register-blocks">
                            <h2>Registrar</h2>
                            <form action="registrar_user.php" method="post">
                                <div class="form-group">
                                    <label>Nome</label>
                                    <input type="text" class="form-control" placeholder="Digite seu nome" name="nome">
                                </div>
								<div class="form-group">
                                    <label>E-mail</label>
                                    <input type="text" class="form-control" placeholder="Digite seu E-mail" name="email">
                                </div>
								<div class="form-group">
                                    <label>Celular</label>
                                    <input type="text" class="form-control" placeholder="Digite seu celular" name="celular" onkeyup="mascaraCelular( this, mtel );"  onkeypress='return SomenteNumero(event)' maxlength="15">
                                </div>

								<div class="form-group">
                                    <label>CPF</label>
                                    <input type="text" class="form-control" placeholder="Digite seu cpf" name="cpf" onblur='clearTimeout()' onkeypress='return SomenteNumero(event)' maxlength="14">
                                </div>


								<div class="form-group">
                                    <label>RG</label>
                                    <input type="text" class="form-control" placeholder="Digite seu rg" name="rg" onkeypress='return SomenteNumero(event)' maxlength="9" >
                                </div>

								<div class="form-group">
                                    <label>Senha</label>
                                    <input type="password" class="form-control" name="senha"  placeholder="Digite sua senha">
                                </div>
                <div class="form-group">
                                    <label>Data de Nascimento</label>
                                    <input type="text" class="form-control" placeholder="Digite sua data de nascimento"  onkeypress="mascaraData( this, event )" name="dt_nasc" maxlength="10" >
                                </div>

                                <div class="text-center">
                                    <button name="btnRegistrar" type="submit" class="btn btn-default">Registrar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="box-for overflow">
                        <div class="col-md-12 col-xs-12 login-blocks">
                            <h2>Entrar</h2>
                            <form action="registrar_user.php" method="post">
                               <div class="form-group">
                                    <label>CPF</label>
                                    <input type="text" class="form-control" placeholder="Digite seu cpf" name="cpf" onblur='clearTimeout()' onkeypress='return SomenteNumero(event)' maxlength="14">
                                </div>
                                <div class="form-group">
                                    <label>Senha</label>
                                    <input type="password" class="form-control" name="senha"  placeholder="Digite sua senha">
                                </div>
                                <div class="text-center">
                                    <button name="btn_logar_cliente" type="submit" class="btn btn-default"> Logar</button>
                                </div>
                            </form>
                            <br>
                        </div>

                    </div>
                </div>

            </div>
        </div>
        <?php
          @$id_cliente = $_GET['id_cliente'];

           if ($id_cliente) {
             include('rodape_logado.php');
           }else {
             include('rodape_nLogado.php');
           }
        ?>



         <script src="assets/js/modernizr-2.6.2.min.js"></script>

        <script src="assets/js/jquery-1.10.2.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/bootstrap-select.min.js"></script>
        <script src="assets/js/bootstrap-hover-dropdown.js"></script>

        <script src="assets/js/easypiechart.min.js"></script>
        <script src="assets/js/jquery.easypiechart.min.js"></script>

        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/wow.js"></script>

        <script src="assets/js/icheck.min.js"></script>
        <script src="assets/js/price-range.js"></script>

        <script src="assets/js/main.js"></script>




		</script>


		<script>
			function mascaraMutuario(o,f){
				v_obj=o
				v_fun=f
				setTimeout('execmascara()',1)
			}

			function execmascara(){
				v_obj.value=v_fun(v_obj.value)
			}

			function cpfCnpj(v){

				//Remove tudo o que não é dígito
				v=v.replace(/\D/g,"")

				if (v.length <= 14) { //CPF

					//Coloca um ponto entre o terceiro e o quarto dígitos
					v=v.replace(/(\d{3})(\d)/,"$1.$2")

					//Coloca um ponto entre o terceiro e o quarto dígitos
					//de novo (para o segundo bloco de números)
					v=v.replace(/(\d{3})(\d)/,"$1.$2")

					//Coloca um hífen entre o terceiro e o quarto dígitos
					v=v.replace(/(\d{3})(\d{1,2})$/,"$1-$2")

				} else { //CNPJ

					//Coloca ponto entre o segundo e o terceiro dígitos
					v=v.replace(/^(\d{2})(\d)/,"$1.$2")

					//Coloca ponto entre o quinto e o sexto dígitos
					v=v.replace(/^(\d{2})\.(\d{3})(\d)/,"$1.$2.$3")

					//Coloca uma barra entre o oitavo e o nono dígitos
					v=v.replace(/\.(\d{3})(\d)/,".$1/$2")

					//Coloca um hífen depois do bloco de quatro dígitos
					v=v.replace(/(\d{4})(\d)/,"$1-$2")

				}

				return v

			}
		</script>




	<script>
		function mascaraCelular(o,f){
		v_obj=o
		v_fun=f
		setTimeout("execmascara()",1)
		}
		function execmascara(){
			v_obj.value=v_fun(v_obj.value)
		}
		function mtel(v){
			v=v.replace(/\D/g,"");
			v=v.replace(/^(\d{2})(\d)/g,"($1) $2");
			v=v.replace(/(\d)(\d{4})$/,"$1-$2");
			return v;
		}

		</script>


		 <script>
		 function somenteNumeros(num) {
			var er = /[^0-9.]/;
			er.lastIndex = 0;
			var campo = num;
			if (er.test(campo.value)) {
			  campo.value = "";
			}
		}
	</script>


    </body>
</html>
