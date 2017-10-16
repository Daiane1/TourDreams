<?php

session_start();

include("conexao_banco.php");

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

<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>TourDreams | Detalhes</title>


        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel='stylesheet' type='text/css'>



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
        <link rel="stylesheet" href="assets/css/lightslider.min.css">
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
    										<form role="form" class="form-horizontal" action="detalhes_produto.php" method="post">
    										<div class="form-group">
    											<label for="email" class="col-sm-2 control-label">
    												CNPJ</label>
    											<div class="col-sm-10">
    												<input name="cnpj" type="text" class="form-control" id="email1" placeholder="CNPJ" maxlength="8" />
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
    										<form method="post" role="form" class="form-horizontal" action="detalhes_produto.php">
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





        <div class="content-area single-property" style="background-color: #FCFCFC;">&nbsp;
            <div class="container">

            <div class="clearfix padding-top-40" >

                <div class="col-md-8 single-property-content prp-style-2">
                        <div class="">
                            <div class="row">
                                <div class="light-slide-item">
                                    <div class="clearfix">
                                        <ul id="image-gallery" class="gallery list-unstyled cS-hidden">
										<?php
										if (isset ($_GET['id_produto'])) {
												$id_produto = (int)$_GET['id_produto'];
												$sql = "select * from view_fotos_produtos where id_produto =".$id_produto;
												$select = mysql_query($sql);
												while($rs = mysql_fetch_array($select)){
									
										?>							
											<?php echo "<li data-thumb='Parceiro/Arquivos/".$rs['foto_detalhes']."'>"?>
                                                <?php echo "<img src='Parceiro/Arquivos/".$rs['foto_detalhes']."'>"?>
                                            </li>
										<?php
											}
										}
										?>
                                        </ul>
                                    </div>
                                </div>
                            </div>

						<div class="single-property-wrapper">
                            <div class="single-property-header">
                                <h1 class="property-title pull-left">Características</h1>
                            </div>

                            <div class="property-meta entry-meta clearfix ">

								<?php
								if (isset ($_GET['id_produto'])) {
									$id_produto = (int)$_GET['id_produto'];
									$sql = "select * from view_caracteristica where id_produto =".$id_produto;
									$select = mysql_query($sql);
									while($rs = mysql_fetch_array($select)){	
								?>		
                                <div class="col-xs-3 col-sm-3 col-md-3 p-b-15">
                                    <span class="property-info-icon icon-garage">
                                        <i class="fa <?php echo($rs['foto_caracteristica']);?>"></i>
                                    </span>
                                    <span class="property-info-entry">
                                        <span class="property-info-label"><?php echo($rs['nome_caracteristica']);?></span>
                                    </span>
                                </div>
								<?php
									}
								}
								?>


                            </div>

                            <div class="single-property-wrapper">

                                <div class="section">
                                    <h4 class="s-property-title">Descrição</h4>
									<?php
									if (isset ($_GET['id_produto'])) {
										$id_produto = (int)$_GET['id_produto'];
										$sql = "select * from view_produto where id_produto =".$id_produto;
										$select = mysql_query($sql);
										while($rs = mysql_fetch_array($select)){	
									?>	
                                    <div class="s-property-content">
                                        <p><?php echo($rs['descricao_produto']);?></p>
                                    </div>
									<?php
										}
									}
									?>
                                </div>


                            </div>



                        </div>


						<section id="comments" class="comments wow fadeInRight animated">
                            <h4 class="text-uppercase wow fadeInLeft animated">2 Comentários</h4>


                            <div class="row comment">
                                <div class="col-sm-3 col-md-2 text-center-xs">
                                    <p>
                                        <img src="assets/img/client-face1.png" class="img-responsive img-circle" alt="">
                                    </p>
                                </div>
                                <div class="col-sm-9 col-md-10">
                                    <h5 class="text-uppercase">Nome Pessoa</h5>
                                    <p class="posted"><i class="fa fa-clock-o"></i> 31 de Agosto de 2017 às 14:30</p>
                                    <p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos.</p>
                                </div>
                            </div>



                            <div class="row comment last">

                                <div class="col-sm-3 col-md-2 text-center-xs">
                                    <p>
                                        <img src="assets/img/client-face1.png" class="img-responsive img-circle" alt="">
                                    </p>
                                </div>

                                <div class="col-sm-9 col-md-10">
                                   <h5 class="text-uppercase">Nome Pessoa</h5>
                                    <p class="posted"><i class="fa fa-clock-o"></i> 31 de Agosto de 2017 às 14:30</p>
                                    <p>Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos.</p>
                                </div>

                            </div>

                        </section>
						
						


                    </div>





                </div>

				<div class="col-md-4 p0">
                        <aside class="sidebar sidebar-property blog-asside-right property-style2">
                            <div class="dealer-widget">
                                <div class="dealer-content">
                                    <div class="inner-wrapper">
									<?php
									if (isset ($_GET['id_produto'])) {
										$id_produto = (int)$_GET['id_produto'];
										$sql = "select * from view_produto where id_produto =".$id_produto;
										$select = mysql_query($sql);
										while($rs = mysql_fetch_array($select)){
											$preco_diaria=$rs['preco_diaria'];
									?>	
                                        <div class="single-property-header">
                                            <h1 class="property-title"><?php echo($rs['nome_fantasia']);?></h1>
                                            <span class="property-price">R$ <?php echo number_format($preco_diaria, 2, ',', '');?></span>
                                        </div>
									<?php
										}
									}
									?>
                                    </div>
                                </div>
                            </div>

							


							<div class="col-sm-6">
                                <div class="form-group">
									<i class="fa fa-calendar"></i>   <label>Entrada</label>
                                    <input type="date" class="form-control">
                                </div>
                            </div>


							<div class="col-sm-6">
                                <div class="form-group">
									<i class="fa fa-calendar"></i>   <label>Saída</label>
                                    <input type="date" class="form-control">
                                </div>
                            </div>


							<div class="col-sm-12 text-center">
							<a href="reserva.php">
                                <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane" name="btn_enviar_mensagem"></i>  Reservar</button>
							</a>
                            </div>


                        </aside>
                </div>





			</div>
            </div>
        </div>

        <!-- Footer area-->
        <div class="footer-area">

            <div class=" footer">
                <div class="container">
                    <div class="row">


					</div>

				</div>
			</div>
		</div>


        <script src="assets/js/vendor/modernizr-2.6.2.min.js"></script>
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
        <script type="text/javascript" src="assets/js/lightslider.min.js"></script>
        <script src="assets/js/main.js"></script>

        <script>
                            $(document).ready(function () {

                                $('#image-gallery').lightSlider({
                                    gallery: true,
                                    item: 1,
                                    thumbItem: 9,
                                    slideMargin: 0,
                                    speed: 500,
                                    auto: true,
                                    loop: true,
                                    onSliderLoad: function () {
                                        $('#image-gallery').removeClass('cS-hidden');
                                    }
                                });
                            });
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

    </body>
</html>
