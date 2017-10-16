<?php

	session_start();

	include("conexao_banco.php");

	if(isset($_POST['btn_enviar_mensagem'])){
		$nome=$_POST['nome'];
		$celular=$_POST['celular'];
		$email=$_POST['email'];
		$observacao=$_POST['observacao'];

		$sql="insert into tbl_fale_conosco (nome, email, celular, observacao)";
		$sql =$sql."values('".$nome."' , '".$email."' , '".$celular."' , '".$observacao."')";

		mysql_query($sql);
		header('location:index.php');
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

  echo "<script type='text/javascript'>
	window.alert('Obrigado pela preferencia')
	</script>";

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

<html class="no-js">
	<head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>TourDreams | Fale Conosco</title>

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

		<nav class="navbar navbar-default ">
            <div class="container">

                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navigation">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.php"><img src="assets/img/logo_tourdreams.png" alt=""></a>
                </div>


                <div class="collapse navbar-collapse yamm" id="navigation">
                    <div class="button navbar-right">
                        <a class="navbar-brand" href="registrar_user.php"><button class="navbar-btn nav-button wow bounceInRight login" data-wow-delay="0.45s">Cliente</button></a>
                    </div>
					<div class="button navbar-right" data-toggle="modal" data-target="#myModal">
                        <a class="navbar-brand" href="#"><button class="navbar-btn nav-button wow bounceInRight login" data-wow-delay="0.45s">Parceiro</button></a>
                    </div>
                    <ul class="main-nav nav navbar-nav navbar-right">
					    <li class="wow fadeInDown" data-wow-delay="0.1s"><a class="" href="index.php">Home</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="melhores_destinos.php">Destinos</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="blog.php">Blog</a></li>
                        <li class="wow fadeInDown" data-wow-delay="0.5s"><a href="fale_conosco.php">Fale Conosco</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="sobre.php">Sobre</a></li>
						<li class="wow fadeInDown" data-wow-delay="0.5s"><a href="promocao.php">Promoções</a></li>
                    </ul>
                </div>
            </div>
        </nav>

				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">Seja nosso Parceiro</h4>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-md-8" style="border-right: 1px dotted #C2C2C2;padding-right: 30px;">
										<ul class="nav nav-tabs">
											<li class="active"><a href="#Login" data-toggle="tab">Parceiro</a></li>
											<li><a href="#Registration" data-toggle="tab">Registrar</a></li>
										</ul>
										<div class="tab-content">
											<div class="tab-pane active" id="Login">
												<form role="form" class="form-horizontal" action="fale_conosco.php" method="post">
												<div class="form-group">
													<label for="email" class="col-sm-2 control-label">
														CNPJ</label>
													<div class="col-sm-10">
														<input name="cnpj" type="text" class="form-control" id="email1"  placeholder="CNPJ" maxlength="8" />
													</div>
												</div>
												<div class="form-group">
													<label for="exampleInputPassword1" class="col-sm-2 control-label">Senha</label>
													<div class="col-sm-10">
														<input name="senha" type="password" class="form-control" id="exampleInputPassword1" placeholder="Senha" />
													</div>
												</div>
												<div class="row">
													<div class="col-sm-2">
													</div>
													<div class="col-sm-10">
														<button name="btn_logar_parceiro" type="submit" class="btn btn-primary btn-sm">Logar como Parceiro</button>
													</div>
												</div>
												</form>
											</div>

											<div class="tab-pane" id="Registration">
												<form method="post" role="form" class="form-horizontal" action="fale_conosco.php">
												<div class="form-group">
													<label for="email" class="col-sm-2 control-label">Empresa</label>
													<div class="col-sm-10">
														<input name="empresa" type="text" class="form-control" id="email" placeholder="Empresa" />
													</div>
												</div>
												<div class="form-group">
													<label for="email" class="col-sm-2 control-label">Nome</label>
													<div class="col-sm-10">
														<input name="nome_parceiro" type="text" class="form-control" id="email" placeholder="Nome Fantasia" />
													</div>
												</div>
												<div class="form-group">
													<label for="mobile" class="col-sm-2 control-label">CNPJ</label>
													<div class="col-sm-10">
														<input name="cnpj" type="text" class="form-control" id="mobile" placeholder="CNPJ da empresa" />
													</div>
												</div>
												<div class="form-group">
													<label for="password" class="col-sm-2 control-label">Senha</label>
													<div class="col-sm-10">
														<input name="senha" type="password" class="form-control" id="password" placeholder="Senha de acesso" />
													</div>
												</div>
												<div class="form-group">
													<label for="password" class="col-sm-2 control-label">Gerente</label>
													<div class="col-sm-10">
														<input name="gerente" type="text" class="form-control" id="password" placeholder="Gerente do hotel/pousada/resort"/>
													</div>
												</div>
												<div class="form-group">
    											<label for="password" class="col-sm-2 control-label">Celular</label>
    											<div class="col-sm-10">
    												<input name="celular" type="text" class="form-control" id="password" onkeyup="mascaraCelular( this, mtel );" placeholder="Celular do gerente" maxlength="15" />
    											</div>
    										</div>
    										<div class="form-group">
    											<label for="password" class="col-sm-2 control-label">Telefone</label>
    											<div class="col-sm-10">
    												<input name="telefone" type="text" class="form-control" onkeyup="mascaraCelular( this, mtel );"  id="password" placeholder="Telefone da empresa" maxlength="14" />
    											</div>
    										</div>
												<div class="form-group">
													<label for="password" class="col-sm-2 control-label">Email</label>
													<div class="col-sm-10">
														<input name="email" type="email" class="form-control" id="password" placeholder="Email do gerente" />
													</div>
												</div>
												<div class="row">
													<div class="col-sm-2">
													</div>
													<div class="col-sm-10">
														<button name="btnRegistrar_parceiro" type="submit" class="btn btn-primary btn-sm">Quero ser um parceiro</button>
													</div>
												</div>
												</form>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>



        <div class="content-area recent-property padding-top-40" style="background-color: #FFF;">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <div class="" id="contact1">
                            <div class="row">
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-map-marker"></i> Endereço</h3>
                                    <p>
                                        Av. Luiz Carlos Berrini
                                    </p>
                                </div>
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-phone"></i> Telefone</h3>
                                    <p>(11) 4222-2020</p>
                                </div>
                                <div class="col-sm-4">
                                    <h3><i class="fa fa-envelope"></i> E-mail</h3>
                                    <p>tour_dreams@tour.com</p>
                                </div>
                            </div>
                            <hr>

                            <hr>
                            <h2>Contato</h2>
                            <form action="fale_conosco.php" name="frmfale" method="post">
                                <div class="row">
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Nome</label>
                                            <input type="text" class="form-control"  placeholder="Digite seu nome" name="nome">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>E-mail</label>
                                            <input type="email" class="form-control"  placeholder="Digite seu E-mail" name="email">
                                        </div>
                                    </div>
                                    <div class="col-sm-6">
                                        <div class="form-group">
                                            <label>Celular</label>
                                            <input type="text" class="form-control" placeholder="Digite seu celular" name="celular" onkeyup="mascaraCelular( this, mtel );"  onkeypress='return SomenteNumero(event)' maxlength="15">
                                        </div>
                                    </div>




                                    <div class="col-sm-12">
                                        <div class="form-group">
                                            <label>Observação</label>
                                            <textarea  class="form-control" rows="8" placeholder="Sugestão/Criticas" name="observacao" style="resize:none;"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-sm-12 text-center">
                                        <button type="submit" class="btn btn-primary" name="btn_enviar_mensagem"><i class="fa fa-envelope-o"></i> Enviar</button>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <div class="footer-area">

            <div class=" footer">
                <div class="container">
                    <div class="row">





                    </div>
                </div>
            </div>



        </div>

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


        <script src="assets/js/gmaps.js"></script>
        <script src="assets/js/gmaps.init.js"></script>

        <script src="assets/js/main.js"></script>


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
