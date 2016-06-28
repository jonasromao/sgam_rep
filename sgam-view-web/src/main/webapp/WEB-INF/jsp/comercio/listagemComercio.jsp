<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.cadastros.morador.consultar">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Comércios</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Cadastros</span>
             </li>
             <li class="active">
                 <strong>Comércios</strong>
             </li>
			
			<shiro:hasPermission name="sgam.cadastros.morador.incluir">
				<div class="pull-right">
	            	<a class="label label-primary labelButton" href="${linkTo[ComercioController].formularioComercio}">Novo</a>
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
					<table id="tableListagemMoradores" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Nome fantasia</th>
								<th>Razão social</th>
								<th>Segmento</th>
								<th>Inicio Atividade</th>
								<th>Telefone</th>
								<th>Responsável</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="comercio" items="${comercios}">
								<tr class="linhaComercio">
									<td>${comercio.nomeFantasia}</td>
									<td>${comercio.razaoSocial}</td>
									<td>${comercio.segmento.nome}</td>
									<td>${comercio.inicioAtividade}</td>
									<td>${comercio.telefone}</td>
									<td>${comercio.responsavel}</td>
									
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<shiro:hasPermission name="sgam.cadastros.morador.editar">
											<a title="Editar" class="editar" href="${linkTo[ComercioController].edita(comercio.id)}"> <i class="fa fa-edit"></i> </a> &nbsp;
										</shiro:hasPermission>
										
										<shiro:hasPermission name="sgam.cadastros.morador.excluir">
											<a title="Excluir" class="remover" href="${linkTo[ComercioController].remove(comercio.id)}"> <i class="fa fa-trash-o"></i> </a>
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
<script src="${pageContext.request.contextPath}/js/paginas/comercio/listagemComercio.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.cadastros.morador.consultar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>