<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.configuracoes.perfil.consultar">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Perfil</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Configurações</span>
             </li>
             <li class="active">
                 <strong>Perfil</strong>
             </li>

			<shiro:hasPermission name="sgam.configuracoes.perfil.incluir">
				<div class="pull-right">
	            	<a class="label label-primary labelButton" href="${linkTo[PerfilController].formularioPerfil}">Novo</a>
	            </div>
			</shiro:hasPermission>
         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemPerfis" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Nome</th>
								<th>Descrição</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="perfil" items="${perfis}">
								<tr class="linhaPerfil">
									<td>${perfil.nome}</td>
									<td>${perfil.descricao}</td>
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<shiro:hasPermission name="sgam.configuracoes.perfil.editar">
											<a title="Editar" class="editar" href="${linkTo[PerfilController].editarPerfil(perfil.id)}"> <i class="fa fa-edit iconeDataTable"></i> </a> &nbsp;
										</shiro:hasPermission>
										
										<shiro:hasPermission name="sgam.configuracoes.perfil.excluir"> 
											<a title="Excluir" class="remover" href="${linkTo[PerfilController].removePerfil(perfil.id)}"> <i class="fa fa-trash-o iconeDataTable"></i> </a>
										</shiro:hasPermission> 
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
	    </div>            
    </div>
</div>


<script src="${pageContext.request.contextPath}/js/plugins/dataTables/datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/paginas/perfil/listagemPerfis.js"></script>

﻿<%@ include file="/footer.jsp" %>
</shiro:hasPermission>

<shiro:lacksPermission name="sgam.configuracoes.perfil.consultar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>