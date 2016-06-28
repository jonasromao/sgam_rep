<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>

<%@ page import="org.apache.shiro.session.Session" %>
<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page import="br.com.setaprox.sgam.model.Usuario" %>
    
<%
Session sessao = SecurityUtils.getSubject().getSession();
Usuario usuario = (Usuario) sessao.getAttribute("usuarioLogado");

request.setAttribute("nomeUsuario", usuario.getNome().split(" ")[0]);
request.setAttribute("cargoUsuario", usuario.getCargo());
%>

<html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>SGAM | Associação de Moradores</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/font-awesome/css/font-awesome.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">

    <!-- Toastr style -->
    <link href="${pageContext.request.contextPath}/css/plugins/toastr/toastr.min.css" rel="stylesheet">

	<!-- SweetAlert -->
	<link href="${pageContext.request.contextPath}/css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
	
	<!-- Mainly scripts -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    
    <!-- Custom and plugin javascript -->
    <script src="${pageContext.request.contextPath}/js/inspinia.js"></script>
    <script src="${pageContext.request.contextPath}/js/plugins/pace/pace.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/menu.js"></script>
    <script src="${pageContext.request.contextPath}/js/util.js"></script>

    <!-- Toastr -->
   <script src="${pageContext.request.contextPath}/js/plugins/toastr/toastr.min.js"></script>
   <script src="${pageContext.request.contextPath}/js/plugins/sweetalert/sweetalert.min.js"></script>
	
</head>

<body onload="loadMarcacaoMenu()">
    <div id="wrapper">
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav metismenu" id="side-menu">
                    
                    <li class="nav-header">
                        <div class="dropdown profile-element"> <span>
                            <img alt="image" class="img-circle" src="${pageContext.request.contextPath}/img/profile_small.jpg" />
                             </span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                            <span class="clear"> <span class="block m-t-xs"> <strong class="font-bold"> ${nomeUsuario} </strong>
                             </span> <span class="text-muted text-xs block">${cargoUsuario} <b class="caret"></b></span> </span> </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                                <li><a href="${linkTo[UsuarioController].editarUsuarioLogado}">Cadastro</a></li>
                                <li class="divider"></li>
                                <li><a href="${linkTo[LoginController].logout}">Sair</a></li>
                            </ul>
                        </div>
                        <div class="logo-element">
                            <!-- IN+ -->
                        </div>
                    </li>
                    <li id="menuInicio">
		                <a onclick="marcarMenuAtivo('menuInicio', '', '')" href="${linkTo[LoginController].paginaInicial}">
		                <i class="fa fa-th-large"></i> <span class="nav-label">Inicio</span></a>
		            </li>
		            
		            <shiro:hasPermission name="sgam.ocorrencia.consultar">
			            <li id="menuOcorrencias"> 
	                    	<a onclick="marcarMenuAtivo('menuOcorrencias', '', '')" href="${linkTo[OcorrenciaController].listagemOcorrencias}">
	                    	<i class="fa fa-warning"></i> <span class="nav-label">Ocorrências</span></a>
	                    </li>
		            </shiro:hasPermission>
		            
		            
		            <shiro:hasPermission name="sgam.cadastros">
	                    <li id="menuCadastros">
	                        <a href=""><i class="fa fa-edit"></i> <span class="nav-label">Cadastros</span> <span class="fa arrow"></span></a>
	                        <ul id="collapseCadastros" class="nav nav-second-level collapse">
	                            
	                            <shiro:hasPermission name="sgam.cadastros.morador.consultar">
		                            <li id="submenuMoradores"> 
		                            	<a id="linkMoradorListagem" onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].listagemMoradores}">Moradores</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                            <shiro:hasPermission name="sgam.cadastros.fornecedor.consultar">
		                            <li id="submenuFornecedores"> 
		                            	<a onclick="marcarMenuAtivo('menuCadastros', 'submenuFornecedores', 'collapseCadastros')" href="${linkTo[FornecedorController].listagemFornecedores}">Fornecedores</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                            <shiro:hasPermission name="sgam.cadastros.recurso.consultar">
		                            <li id="submenuRecursos"> 
		                            	<a onclick="marcarMenuAtivo('menuCadastros', 'submenuRecursos', 'collapseCadastros')" href="${linkTo[RecursoController].listagemRecursos}">Recursos</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                        </ul>
	                    </li>
                    </shiro:hasPermission>
                    
                    <shiro:hasPermission name="sgam.faturamento">
	                    <li id="menuFaturamento">
	                        <a href=""><i class="fa fa-dollar"></i> <span class="nav-label">Faturamento</span> <span class="fa arrow"></span></a>
	                        <ul id="collapseFaturamento" class="nav nav-second-level collapse">
	                            
	                            <shiro:hasPermission name="sgam.faturamento.aluguel.consultar">
		                            <li id="submenuReservaEspaco"> 
		                            	<a onclick="marcarMenuAtivo('menuFaturamento', 'submenuReservaEspaco', 'collapseFaturamento')" href="${linkTo[AluguelController].listagemAluguel}">Reserva de espaços</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                            <shiro:hasPermission name="sgam.faturamento.aluguel_comercio.consultar">
		                            <li id="submenuComercios"> 
		                            	<a onclick="marcarMenuAtivo('menuFaturamento', 'submenuComercios', 'collapseFaturamento')" href="${linkTo[AluguelComercioController].listagemAluguelComercio}">Comércios Informais</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                        </ul>
	                    </li>
                    </shiro:hasPermission>
 
 					<shiro:hasPermission name="sgam.financeiro">
	                    <li id="menuFinanceiro">
	                        <a href="#"><i class="fa fa-bank"></i> <span class="nav-label">Financeiro</span><span class="fa arrow"></span></a>
	                        <ul id="collapseFinanceiro" class="nav nav-second-level collapse">
	                            
	                            <shiro:hasPermission name="sgam.financeiro.fluxo_caixa.consultar">
		                            <li id="submenuFluxoCaixa">
		                            	<a onclick="marcarMenuAtivo('menuFinanceiro', 'submenuFluxoCaixa', 'collapseFinanceiro')" href="${linkTo[MetricasController].listagemMetricas}">Fluxo de Caixa</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                            <shiro:hasPermission name="sgam.financeiro.contas_pagar.consultar">
		                            <li id="submenuContasPagar">
		                            	<a onclick="marcarMenuAtivo('menuFinanceiro', 'submenuContasPagar', 'collapseFinanceiro')" href="${linkTo[ContasPagarController].listagemContasPagar}">Contas a Pagar</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                            <shiro:hasPermission name="sgam.financeiro.contas_receber.consultar">
		                            <li id="submenuContasReceber">
		                            	<a onclick="marcarMenuAtivo('menuFinanceiro', 'submenuContasReceber', 'collapseFinanceiro')" href="${linkTo[ContasReceberController].listagemContasReceber}">Contas a Receber</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                        </ul>
	                    </li>
                    </shiro:hasPermission>
                    
                    <%-- <li id="menuMetricas">
	                    <a onclick="marcarMenuAtivo('menuMetricas', '', '')" href="${linkTo[MetricasController].listagemMetricas}">
	                    <i class="fa fa-pie-chart"></i> <span class="nav-label">Métricas</span> </a>
	                </li> --%>
                    
                    <shiro:hasPermission name="sgam.configuracoes">
	                    <li id="menuConfiguracao">
	                        <a href="#"><i class="fa fa fa-cogs"></i> <span class="nav-label">Configurações </span><span class="fa arrow"></span></a>
	                        <ul id="collapseConfiguracao" class="nav nav-second-level collapse">
	                            
	                            <shiro:hasPermission name="sgam.configuracoes.categoria_contas_receber.consultar">
		                            <li id="submenuCategoriasReceber">
		                            	<a onclick="marcarMenuAtivo('menuConfiguracao', 'submenuCategoriasReceber', 'collapseConfiguracao')" href="${linkTo[CategoriaContasReceberController].listagemCategoriasContasReceber}">Categorias de recebimento</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                            <shiro:hasPermission name="sgam.configuracoes.usuario.consultar">
		                            <li id="submenuUsuario">
		                            	<a onclick="marcarMenuAtivo('menuConfiguracao', 'submenuUsuario', 'collapseConfiguracao')" href="${linkTo[UsuarioController].listagemUsuario}">Usuário</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                            <shiro:hasPermission name="sgam.configuracoes.perfil.consultar">
		                            <li id="submenuPerfil">
		                            	<a onclick="marcarMenuAtivo('menuConfiguracao', 'submenuPerfil', 'collapseConfiguracao')" href="${linkTo[PerfilController].listagemPerfis}">Perfil</a>
		                            </li>
	                            </shiro:hasPermission>
	                            
	                        </ul>
	                    </li>
                    </shiro:hasPermission>

            </div>
        </nav>

        <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
        <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
        <div class="navbar-header">
            <a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
        </div>
            <ul class="nav navbar-top-links navbar-right">
                <li>
                    <span class="m-r-sm text-muted welcome-message">Bem vindo <shiro:principal /> </span>
                </li>
                
                <li class="dropdown">
                    <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell"></i>  <span class="label label-primary"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Nenhuma mensagem
                                    <span class="pull-right text-muted small"></span>
                                </div>
                            </a>
                        </li>
                    </ul>
                </li>


                <li>
                    <a href="${linkTo[LoginController].logout}">
                        <i class="fa fa-sign-out"></i> Sair
                    </a>
                </li>
            </ul>

        </nav>
        </div>
        