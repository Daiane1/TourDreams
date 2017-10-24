<?php

session_start();

 include("conexao_banco.php");

?>

<?php
		$cor = "#fff";
		$sql = "select * from tbl_cores";
		$select = mysql_query($sql);
		if($rsConsulta=mysql_fetch_array($select)){
			$cores=$rsConsulta['cores'];
		}
?>

<?php
	if(isset($_POST['btnPublicar_Perfil'])){
		
		if(isset($_GET['id_cliente'])){
			$id_cliente = (int)$_GET['id_cliente'];
			$descricao_blog = $_POST ['comentario'];
			$diretorio="Arquivos_Conheca_Destino/";
			move_uploaded_file($_FILES['foto_blog']['tmp_name'], $diretorio.$foto_blog);	
		
			$sql="insert into tbl_blog(id_cliente, foto_blog, descricao_blog, data_publicacao, id_reserva)";
			$sql=$sql."values(".$id_cliente.",'".$foto_blog."', '".$descricao_blog."', 'now()','2')";
			
			mysql_query ($sql);
			
			
		}
	}
?>

	



<!DOCTYPE html>
<html class="no-js">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>TourDreams | Meu Perfil</title>

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

        <hr>
				<div class="container bootstrap snippet">
					<div class="row">
					</div>
					<div class="row">
						<div class="col-sm-3"><!--left col-->

						<ul class="list-group">
							<li class="list-group-item text-muted">Informações Pessoais</li>
							<?php
								if (isset ($_GET['id_cliente'])) {
								$id_cliente = (int)$_GET['id_cliente'];
								$sql = "select * from tbl_cliente where id_cliente=".$id_cliente;
								$select = mysql_query($sql);
								while($rs = mysql_fetch_array($select)){
							?>
							<li class="list-group-item text-right"><span class="pull-left"><strong>Nome</strong></span> <?php echo $rs['nome_cliente'];?></li>
							<li class="list-group-item text-right"><span class="pull-left"><strong>Email</strong></span> <?php echo $rs['email_cliente'];?></li>
							<li class="list-group-item text-right"><span class="pull-left"><strong>RG</strong></span> <?php echo $rs['rg_cliente'];?></li>
							<li class="list-group-item text-right"><span class="pull-left"><strong>CPF</strong></span> <?php echo $rs['cpf_cliente'];?></li>
							<li class="list-group-item text-right"><span class="pull-left"><strong>Celular</strong></span> <?php echo $rs['celular_cliente'];?></li>
							<?php
								}
							}
							?>
						</ul>
						</div><!--/col-3-->
						<div class="col-sm-9">

						  <ul class="nav nav-tabs" id="myTab">
							<li class="active"><a href="#home" data-toggle="tab">Reservas Finalizadas</a></li>
							<li><a href="#messages" data-toggle="tab">Acompanhamento da Reserva</a></li>
						  </ul>

						  <div class="tab-content">
							<div class="tab-pane active" id="home">
							  <div class="table-responsive">
								<table class="table table-hover">
								  <thead>
									<tr>
									  <th>Data</th>
									  <th>Milhas Ganhas</th>
									  <th>Local</th>
									  <th>Empresa Parceira</th>
									  <th>Sua Avaliação</th>
									  <th>Publicar</th>
									</tr>
								  </thead>
								  <tbody id="items">
									<tr data-toggle="collapse" data-target="#demo1" class="accordion-toggle ">
									  <td>10/10/2017</td>
									  <td>580</td>
									  <td>Hotel Maneiro</td>
									  <td>Maneiro Hotels</td>
									  <td>4,5</td>
									  <td><button type="button" class="btn btn-default btn-xs"><span class="glyphicon glyphicon-plus"></span></button></td>
									</tr>
						<tr>
							
							<td colspan="12" class="hiddenRow">
							
								<?php
									$sql="select tbl_blog.id_cliente, tbl_cliente from tbl_blog INNER JOIN tbl_cliente ON tbl_cliente.id_cliente = tbl_blog.id_cliente;";
									
									
			
								?>
								<form action="perfil.php" method="post">
								<div class="accordian-body collapse" id="demo1">
								  <table class="table table-striped">
									  <span>Obs: Essas publicações serão visíveis para outros clientes.</span>

										 <tbody>
											<tr id='addr0'>
												<td>

												</td>
												<td>
												<input type="text" name='comentario'  placeholder='Comentario' class="form-control"/>
												</td>
												<td>
												<input type="file" class="form-control"/>
												</td>
											</tr>
											<tr id='addr1'></tr>
										</tbody>

									</table>
									<button id="add_row" name="btnPublicar_Perfil" class="btn btn-default pull-left">Publicar</button>
								</div> 
							</form>
							</td>
						</tr>



									  </tbody>

								</table>
								<hr>
							   <div class="row">
								  <div class="col-md-6 col-md-offset-4 text-center">
									<ul class="pagination" id="myPager"></ul>
								  </div>
								</div>
							  </div><!--/table-resp-->


							  <hr>

							 </div><!--/tab-pane-->
							 <div class="tab-pane" id="messages">

							   <h2></h2>

							  <div class="table-responsive">
								<table class="table table-hover">
								  <thead>
									<tr>
									  <th>Data</th>
									  <th>Empresa Parceira</th>
									  <th>Local</th>
									  <th>Status</th>
									</tr>
								  </thead>
								  <tbody id="items">
									<tr>
									  <td>20/10/2017</td>
									  <td>Hotel Maneiro</td>
									  <td>Maneiro Hotels</td>
									  <td>Esperando Confirmação</td>
									</tr>
								  </tbody>
								</table>
								</div>

							 </div><!--/tab-pane-->
							  </div><!--/tab-pane-->
						  </div><!--/tab-content-->

						</div><!--/col-9-->
				</div><!--/row-->
                               </hr>















        <!-- Footer area-->
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

    </body>

	<script>

		$('.vote label i.fa').on('click mouseover',function(){
		// remove classe ativa de todas as estrelas
		$('.vote label i.fa').removeClass('active');
		// pegar o valor do input da estrela clicada
		var val = $(this).prev('input').val();
		//percorrer todas as estrelas
		$('.vote label i.fa').each(function(){
			/* checar de o valor clicado é menor ou igual do input atual
			*  se sim, adicionar classe active
			*/
			var $input = $(this).prev('input');
			if($input.val() <= val){
				$(this).addClass('active');
			}
		});
		$("#voto").html(val); // somente para teste
	});
	//Ao sair da div vote
	$('.vote').mouseleave(function(){
		//pegar o valor clicado
		var val = $(this).find('input:checked').val();
		//se nenhum foi clicado remover classe de todos
		if(val == undefined ){
			$('.vote label i.fa').removeClass('active');
		} else {
			//percorrer todas as estrelas
			$('.vote label i.fa').each(function(){
				/* Testar o input atual do laço com o valor clicado
				*  se maior, remover classe, senão adicionar classe
				*/
				var $input = $(this).prev('input');
				if($input.val() > val){
					$(this).removeClass('active');
				} else {
					$(this).addClass('active');
				}
			});
		}
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

</html>
