<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.configuracoes.categoria_contas_receber.consultar">

<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/css/plugins/dataTables/datatables.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Categorias de recebimento</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Configurações</span>
             </li>
             <li class="active">
                 <strong>Categoria das Contas a Receber</strong>
             </li>
         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
		<div class="col-lg-12">
        	<div class="ibox-content">
        		<div class="table-responsive">
					<table id="tableListagemCategorias" class="table table-striped table-bordered table-hover"> 
						<thead>
							<tr>
								<th>Nome</th>
								<th>Descrição</th>
								<th>Valor</th>
								<th>Opções</th>
							</tr>
						</thead>
						
						<tbody>
							<c:forEach var="categoria" items="${categorias}">
								<tr>
									<td>${categoria.nome}</td>
									<td>${categoria.descricao}</td>
									<td><fmt:formatNumber value="${categoria.valor}" type="currency"/></td>
									
									<td style="text-align: center; margin: 20px 0; padding: 10px;"> 
										<shiro:hasPermission name="sgam.configuracoes.categoria_contas_receber.editar">
											<a title="Editar" class="editar" href="${linkTo[CategoriaContasReceberController].editar(categoria.id)}"> <i class="fa fa-edit"></i> </a>
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
<script src="${pageContext.request.contextPath}/js/paginas/categoriaContasReceber/listagemCategoriasContasReceber.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.configuracoes.categoria_contas_receber.consultar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>