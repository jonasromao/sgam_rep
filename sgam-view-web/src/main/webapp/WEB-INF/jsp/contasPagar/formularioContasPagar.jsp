<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/headerMenu.jsp" %> 
<%@ include file="/fornecedorModal.jsp" %> 

    <link href="${pageContext.request.contextPath}/manual_install_components/eonasdan-bootstrap-datetimepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">


<div class="row wrapper border-bottom white-bg page-heading">
     <div class="col-lg-12">
         <h2>Contas a Pagar</h2>
         <ol class="breadcrumb">
             <li>
                 <a href="${linkTo[LoginController].paginaInicial}">Inicio</a>
             </li>
             <li>
                 <span>Financeiro</span>
             </li>
             <li class="active">
                 <a href="${linkTo[ContasPagarController].listagemContasPagar}"><strong>Contas a Pagar</strong></a>
             </li>

			<div class="pull-right">
            	<a class="label label-default" href="${linkTo[ContasPagarController].listagemContasPagar}"> <i class="fa fa-angle-left"></i><i class="fa fa-angle-left"></i> Voltar</a>
            </div>

         </ol>
     </div>
 </div>
 
 <div class="wrapper wrapper-content animated fadeInRight">
 	<div class="row">
 		<form id="contasPagarForm" method="post" class="form-horizontal" action="${linkTo[ContasPagarController].cadastraContasPagar}">
			<div class="col-lg-7">
		        <div class="ibox-content">
	         		<input type="hidden" name="contaPagar.id" value="${contaPagar.id }"/>
	         	
	             	<div class="form-group">
	             		<label class="col-sm-4 control-label">Número</label>
	                    <div class="col-sm-8">
	                    	<input type="text" id="txtNumeroCP" class="form-control" name="contaPagar.numero" value="${contaPagar.numero}">
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Nome</label>
	                    <div class="col-sm-8">
	                    	<input type="text" class="form-control" name="contaPagar.nome" value="${contaPagar.nome}" >
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Histórico</label>
	                    <div class="col-sm-8">
	                    	<textarea rows="2" cols="" class="form-control" name="contaPagar.historico">${contaPagar.historico}</textarea>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Data de Emissão</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group data">
	                    		<input type="text" class="form-control" name="contaPagar.dataEmissao" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contaPagar.dataEmissao}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Data de Vencimento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group data">
	                    		<input type="text" class="form-control" name="contaPagar.dataVencimento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contaPagar.dataVencimento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Data do Pagamento</label>
	                    <div class="col-sm-8">
	                    	<div class="input-group data">
	                    		<input type="text" class="form-control" name="contaPagar.dataPagamento" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${contaPagar.dataPagamento}" />"  data-mask="99/99/9999" >
	                    		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
	                    	</div>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	                	<label class="col-sm-4 control-label">Espécie</label>
	                    <div class="col-sm-8">
	                    	<select class="form-control m-b" name="contaPagar.especiePagamento">
	                         <option value="0">Selecione</option>
	                         <option value="1" <c:if test="${(not empty contaPagar.especiePagamento) and (contaPagar.especiePagamento eq '1')}">selected="selected"</c:if> >Dinheiro</option>
	                         <option value="2" <c:if test="${(not empty contaPagar.especiePagamento) and (contaPagar.especiePagamento eq '2')}">selected="selected"</c:if> >Débito</option>
	                         <option value="3" <c:if test="${(not empty contaPagar.especiePagamento) and (contaPagar.especiePagamento eq '3')}">selected="selected"</c:if> >Crédito</option>
	                         <option value="4" <c:if test="${(not empty contaPagar.especiePagamento) and (contaPagar.especiePagamento eq '4')}">selected="selected"</c:if> >Cheque</option>
	                    	</select>
	                    </div>
	                </div>
	                
	                <div class="form-group">
	             		<label class="col-sm-4 control-label">Valor</label>
	                    <div class="col-sm-8">
	                    	<input type="text" id="txtValorCP" class="form-control" name="contaPagar.valor" value="<fmt:formatNumber value="${contaPagar.valor}" type="number"  pattern="#,##0.00"/>" >
	                    </div>
	                </div>
	                
	                
				</div>
				
				<br/>
					
				<div class="row">
					<div class="col-lg-12">
						<div class="ibox-content">
							<div class="form-group">
			                    <div class="col-sm-12">
			                        <a class="btn btn-outline btn-default" href="${linkTo[ContasPagarController].listagemContasPagar}"> Cancelar</a>
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
	            		<div class="form-group">
			                <div class="col-sm-12">
			                	<div class="input-group">
			                		<input type="hidden" id="idFornecedorCP" name="contaPagar.fornecedor.id" value="${contaPagar.fornecedor.id}" />
			                		<input id="nomeFornecedorCP" type="text" placeholder="Fornecedor" class="form-control" name="contaPagar.fornecedor.nome" value="${contaPagar.fornecedor.nome}">
			                		<a class="input-group-addon" id="btnModalFornecedorCP" style="cursor: pointer;"><i class="fa fa-shopping-cart"></i></a>
			                	</div>
			            	</div>
			            </div>
	            		
						<div class="table-responsive">
		           	     	<table class="table table-striped table-hover">
		           	     		<tbody>
		           	     			<tr>
		           	     				<td> <i class="fa fa-envelope"> </i> </td>
		           	     				<td> <div id="txtEmailFornecedorCP">${contaPagar.fornecedor.email}</div>  </td>
		           	     			</tr>
		           	     			
		           	     			<tr>
		           	     				<td> <i class="fa fa-mobile-phone"> </i> </td>
		           	     				<td> <div id="txtCelularFornecedorCP">${contaPagar.fornecedor.celular}</div>  </td>
		           	     			</tr>
		           	     			
		           	     			<tr>
		           	     				<td> <i class="fa fa-phone"> </i> </td>
		           	     				<td> <div id="txtTelefoneFornecedorCP">${contaPagar.fornecedor.telefone}</div> </td>
		           	     			</tr>
		           	     			
		           	     			<c:choose>
										<c:when test="${not empty contaPagar.fornecedor.endereco}">
											<tr>
				           	     				<td> <i class="fa fa-home"> </i> </td>
				           	     				<td> <div id="txtEnderecoFornecedorCP">${contaPagar.fornecedor.endereco}</div> </td>
				           	     			</tr> 
										</c:when>
									</c:choose>
		           	     			
		           	     			
		           	     		</tbody>
		           	     	</table>
	           	     	</div>
	           	     	
	           	     	<strong>Detalhes</strong>

	                    <ul class="list-group clear-list">
	                         <li class="list-group-item">
	                         	<c:choose>
									<c:when test="${contaPagar.status eq 'Pago'}">
										<span class="pull-right label label-primary">${contaPagar.status}</span>
									</c:when>
									
									<c:when test="${contaPagar.status eq 'Pendente'}">
										<span class="pull-right label label-warning">${contaPagar.status}</span>
									</c:when>
									
									<c:otherwise>
										<span class="pull-right label label-danger">${contaPagar.status}</span>
									</c:otherwise>
								</c:choose>
								
	                             Status do pagamento
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

<script src="${pageContext.request.contextPath}/js/plugins/jquery-ui/jquery-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/js/plugins/validate/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-validation-messages.js"></script>
    
<script src="${pageContext.request.contextPath}/js/paginas/contasPagar/formularioContasPagar.js"></script>

﻿<%@ include file="/footer.jsp" %>

