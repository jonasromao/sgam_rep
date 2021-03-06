<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<shiro:hasPermission name="sgam.financeiro.contas_receber.editar">
<%@ include file="/headerMenu.jsp" %> 

<link href="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">

<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Contas a Receber</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Financeiro</span>
             </li>
             <li class="active">
                 <a href="${linkTo[ContasReceberController].listagemContasReceber}"><strong>Contas a Receber</strong></a>
             </li>

			<div class="pull-right">
            	<a onclick="marcarMenuAtivo('menuFaturamento', 'submenuReservaEspaco', 'collapseFaturamento')" class="label label-default" href="${linkTo[ContasReceberController].listagemContasReceber}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form method="post" class="form-horizontal" action="${linkTo[ContasReceberController].cadastraContasReceber}">
			<div class="col-lg-7">
		        <div class="ibox-content">
	         		<input type="hidden" name="contaReceber.id" value="${contaReceber.id}" />
	         		<input type="hidden" name="contaReceber.status" value="${contaReceber.status}" />
	         		<input type="hidden" name="contaReceber.morador.id" value="${contaReceber.morador.id}" />
	         		<input type="hidden" name="contaReceber.categoria.id" value="${contaReceber.categoria.id}" />
	         		
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Número</label>
	                    <div class="col-sm-8">
	                    	<input type="text" id="txtNumeroCR" class="form-control" name="contaReceber.numero" value="${contaReceber.numero}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="contaReceber.nome" value="${contaReceber.nome}" >
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Histórico</label>
	                    <div class="col-sm-8">
	                    	<textarea class="form-control" rows="2" cols="" name="contaReceber.historico">${contaReceber.historico}</textarea>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Data de Emissão</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="contaReceber.dataEmissao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contaReceber.dataEmissao}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Data de Vencimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="contaReceber.dataVencimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contaReceber.dataVencimento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Data de Recebimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group date">
	                    		<input type="text" class="form-control" name="contaReceber.dataPagamento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contaReceber.dataPagamento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Espécie</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="contaReceber.especiePagamento">
	                        	<option value="0">Selecione</option>
	                         	<option value="1" <c:if test="${(not empty contaReceber.especiePagamento) and (contaReceber.especiePagamento eq '1')}">selected="selected"</c:if> >Dinheiro</option>
	                         	<option value="2" <c:if test="${(not empty contaReceber.especiePagamento) and (contaReceber.especiePagamento eq '2')}">selected="selected"</c:if> >Débito</option>
	                         	<option value="3" <c:if test="${(not empty contaReceber.especiePagamento) and (contaReceber.especiePagamento eq '3')}">selected="selected"</c:if> >Crédito</option>
	                         	<option value="4" <c:if test="${(not empty contaReceber.especiePagamento) and (contaReceber.especiePagamento eq '4')}">selected="selected"</c:if> >Cheque</option>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Valor</label>
	                    <div class="col-sm-8">
	                    	<input type="text" id="txtValorCR" class="form-control" name="contaReceber.valor" value="<fmt:formatNumber value="${contaReceber.valor}" type="number"  pattern="#,##0.00"/>" >
	                    </div>
	                </div>
	                
	                
				</div>
				
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a onclick="marcarMenuAtivo('menuFaturamento', 'submenuReservaEspaco', 'collapseFaturamento')" class="btn btn-outline btn-default" href="${linkTo[ContasReceberController].listagemContasReceber}"> Cancelar</a>
			                        <button class="btn btn-primary" type="submit"> <i class="fa fa-check"></i> Salvar</button>
			                    </div>
			                </div>			
						</div>
					</div>
				</div>	
				
				<ul class="errors">
					<c:forEach items="${errors}" var="error">
						<li>
							${error.category}: ${error.message}
						</li>
					</c:forEach>
				</ul>
				
		    </div>
		    
		    <div class="col-sm-5">
				<div class="ibox">
	            	<div class="ibox-content">
	            		<a title="Visualizar cadastro do morador" onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].editarMorador(contaReceber.morador.id)}"> <h2>${contaReceber.morador.nome}</h2>  </a>
	            		
						<div class="table-responsive">
		           	     	<table class="table table-striped table-hover">
		           	     		<tbody>
		           	     			<tr>
		           	     				<td> <i class="fa fa-envelope"> </i> </td>
		           	     				<td> ${contaReceber.morador.email}  </td>
		           	     			</tr>
		           	     			
		           	     			<tr>
		           	     				<td> <i class="fa fa-mobile-phone"> </i> </td>
		           	     				<td> ${contaReceber.morador.telefoneCelular}  </td>
		           	     			</tr>
		           	     			
		           	     			<tr>
		           	     				<td> <i class="fa fa-phone"> </i> </td>
		           	     				<td> ${contaReceber.morador.telefoneResidencial} </td>
		           	     			</tr>
		           	     			
		           	     			<tr>
		           	     				<td> <i class="fa fa-home"> </i> </td>
		           	     				<td> ${contaReceber.morador.endereco.bairro} - ${contaReceber.morador.endereco.rua}, ${contaReceber.morador.endereco.numero} </td>
		           	     			</tr>
		           	     		</tbody>
		           	     	</table>
	           	     	</div>
	           	     	
	           	     	<strong>Detalhes</strong>

	                    <ul class="list-group clear-list">
	                     
	                     	 <li class="list-group-item fist-item">
	                             <span class="pull-right"> ${contaReceber.historico} </span>
	                             Referente
	                         </li>
	                         
	                         <li class="list-group-item">
	                         	<c:choose>
									<c:when test="${contaReceber.status eq 'Recebida'}">
										<span class="pull-right label label-primary">${contaReceber.status}</span>
									</c:when>
									
									<c:when test="${contaReceber.status eq 'Pendente'}">
										<span class="pull-right label label-warning">${contaReceber.status}</span>
									</c:when>
									
									<c:otherwise>
										<span class="pull-right label label-danger">${contaReceber.status}</span>
									</c:otherwise>
								</c:choose>
								
	                             Status do recebimento
	                         </li>
	                     </ul>
	                </div>
	          	</div>
	     	</div>

	   	</form>         
    </div>
</div>


<script src="${pageContext.request.contextPath}/js/plugins/jasny/jasny-bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="${pageContext.request.contextPath}/manual_install_components/jquery-maskmoney/jquery.maskMoney.min.js"></script>
    
<script src="${pageContext.request.contextPath}/js/paginas/contasReceber/formularioContasReceberAssociado.js"></script>

﻿<%@ include file="/footer.jsp" %>

</shiro:hasPermission>

<shiro:lacksPermission name="sgam.financeiro.contas_receber.editar">
	<jsp:include page="/semPermissaoAcesso.jsp" flush="true"/>
</shiro:lacksPermission>