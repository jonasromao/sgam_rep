<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="/headerMenu.jsp" %> 

<div class="wrapper wrapper-content">
        <div class="row">
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-success pull-right">Geral</span>
                                <shiro:hasPermission name="sgam.cadastros.morador.consultar">
                                	<h5><a id="linkMoradorListagem" onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].listagemMoradores}">Moradores</a></h5>
                                </shiro:hasPermission>
                                
                                <shiro:lacksPermission name="sgam.cadastros.morador.consultar">
                                	<h5>Moradores</h5>
                                </shiro:lacksPermission>
                                
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${totalMoradores}</h1>
                                <div class="stat-percent font-bold text-success"><i class="fa fa-group"></i></div>
                                <small>Total de Moradores</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-info pull-right">Geral</span>
                                
                                <shiro:hasPermission name="sgam.cadastros.morador.consultar">
                                	<h5><a id="linkMoradorListagem" onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].listagemMoradores}">Associados</a></h5>
                                </shiro:hasPermission>
                                
                                <shiro:lacksPermission name="sgam.cadastros.morador.consultar">
                                	<h5>Associados</h5>
                                </shiro:lacksPermission>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${totalAssociados}</h1>
                                <div class="stat-percent font-bold text-info"><fmt:formatNumber value="${porcentSocios}" type="number" pattern="#,##0.00"/>% <i class="fa fa-group"></i></div>
                                <small>Total de Associados</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-primary pull-right">Mês</span>
                                <shiro:hasPermission name="sgam.cadastros.morador.consultar">
                                	<h5><a id="linkMoradorListagem" onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].listagemMoradores}">Associados</a></h5>
                                </shiro:hasPermission>
                                
                                <shiro:lacksPermission name="sgam.cadastros.morador.consultar">
                                	<h5>Associados</h5>
                                </shiro:lacksPermission>
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${totalAssociadosMes}</h1>
                                <div class="stat-percent font-bold text-navy"><fmt:formatNumber value="${porcentSociosMes}" type="number" pattern="#,##0.00"/>% <i class="fa fa-group"></i></div>
                                <small>Novos Associados</small>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <span class="label label-danger pull-right">Abertas</span>
                                
                                <shiro:hasPermission name="sgam.ocorrencia.consultar">
                                	<h5><a onclick="marcarMenuAtivo('menuOcorrencias', '', '')" href="${linkTo[OcorrenciaController].listagemOcorrencias}">Ocorrências</a></h5>
                                </shiro:hasPermission>
                                
                                <shiro:lacksPermission name="sgam.ocorrencia.consultar">
                                	<h5>Ocorrências</h5>
                                </shiro:lacksPermission>
                                
                            </div>
                            <div class="ibox-content">
                                <h1 class="no-margins">${qtdOcorrencias}</h1>
                                <div class="stat-percent font-bold text-danger"> <i class="fa fa-warning"></i></div>
                                <small>Ocorrências Abertas</small>
                            </div>
                        </div>
            		</div>
        </div>
        <div class="row">
                    <div class="col-lg-12">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>Pagamentos recebidos</h5>
                                <div class="pull-right">
                                    <div class="btn-group">
                                        <button type="button" id="btnGraficoDiario" class="btn btn-xs btn-white">Diário</button>
                                        <button type="button" id="btnGraficoMensal" class="btn btn-xs btn-white">Mensal</button>
                                    </div>
                                </div>
                            </div>
                            <div class="ibox-content">
                                <div class="row">
                                <div class="col-lg-9">                                
                                	<canvas height="100px" id="grafico"></canvas>
                                </div>
                                <div class="col-lg-3">
                                    <ul class="stat-list">

                                        <li>
                                            <h2 class="no-margins "><span id="valorTotal"></span></h2>
                                            <small>Valor Total</small>
                                            <div class="progress progress-mini">
                                                <div style="width: 100%;" class="progress-bar"></div>
                                            </div>
                                        </li>
                                        </ul>
                                    </div>
                                </div>
                                </div>

                            </div>
                        </div>
                    </div>


                <div class="row">
                    <div class="col-lg-4">
                        <div class="ibox float-e-margins">
                            <div class="ibox-title">
                                <h5>Ocorrências</h5>
                                <div class="ibox-tools">
                                    <a class="collapse-link">
                                        <i class="fa fa-chevron-up"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="ibox-content ibox-heading">
                            	<shiro:hasPermission name="sgam.ocorrencia.consultar">
                                	<h3><a onclick="marcarMenuAtivo('menuOcorrencias', '', '')" href="${linkTo[OcorrenciaController].listagemOcorrencias}"><i class="fa fa-envelope-o"></i> Novas ocorrências</a></h3>
                                </shiro:hasPermission>
                                
                                <shiro:lacksPermission name="sgam.ocorrencia.consultar">
                                	<h3><i class="fa fa-envelope-o"></i> Novas ocorrências</h3>
                                </shiro:lacksPermission>
                                
                                <small><i class="fa fa-tim"></i> Existem ${qtdOcorrencias} ocorrências abertas.</small>
                            </div>
                            <div class="ibox-content">
                                <div class="feed-activity-list">
									<c:forEach var="ocorrencia" items="${ocorrencias}">
										<div class="feed-element">
	                                        <div>
	                                        
		                                        <c:choose>
													<c:when test="${ocorrencia.prioridade eq 'Baixa'}">
														<small class="pull-right text-navy"><span class="label label-primary">${ocorrencia.prioridade}</span></small>
													</c:when>
													
													<c:when test="${ocorrencia.prioridade eq 'Média'}">
														<small class="pull-right text-navy"><span class="label label-warning">${ocorrencia.prioridade}</span></small>
													</c:when>
													
													<c:otherwise>
														<small class="pull-right text-navy"><span class="label label-danger">${ocorrencia.prioridade}</span></small>
													</c:otherwise>
												</c:choose>
	                                        
	                                            
	                                            <shiro:hasPermission name="sgam.cadastros.morador.editar">
				                                	<strong><a onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" href="${linkTo[MoradorController].editarMorador(ocorrencia.morador.id)}">${ocorrencia.morador.nome}</a></strong>
				                                </shiro:hasPermission>
				                                <shiro:lacksPermission name="sgam.cadastros.morador.consultar">
				                                	<strong>${ocorrencia.morador.nome}</strong>
				                                </shiro:lacksPermission>

	                                            <shiro:hasPermission name="sgam.ocorrencia.editar">
				                                	<div><a onclick="marcarMenuAtivo('menuOcorrencias', '', '')" href="${linkTo[OcorrenciaController].editarOcorrencia(ocorrencia.id)}">${ocorrencia.titulo}</a></div>
				                                </shiro:hasPermission>
				                                <shiro:lacksPermission name="sgam.ocorrencia.editar">
				                                	<div>${ocorrencia.titulo}</div>
				                                </shiro:lacksPermission>
	                                            
	                                            <small class="text-muted">Aberta desde <fmt:formatDate pattern="dd/MM/yyyy" value="${ocorrencia.dataInicio}" /></small>
	                                        </div>
	                                    </div>
									</c:forEach>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-8">

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Agendamentos de hoje - <fmt:formatDate pattern="dd/MM/yyyy" value="${dataAtual}" /></h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="table-responsive">
	                                        <table class="table table-hover no-margins">
	                                            <thead>
	                                            <tr>
	                                                <th>Recurso</th>
	                                                <th>Morador</th>
	                                                <th>Inicio</th>
	                                                <th>Fim</th>
	                                                <th>Até</th>
	                                                <th>Valor</th>
	                                                <th>Pagamento</th>
	                                            </tr>
	                                            </thead>
	                                            <tbody>
		                                            <c:forEach var="aluguel" items="${alugueis}">
														<tr>
															<shiro:hasPermission name="sgam.faturamento.aluguel.editar">
																<td><a onclick="marcarMenuAtivo('menuFaturamento', 'submenuReservaEspaco', 'collapseFaturamento')" title="Link para acessar cadastro do aluguel do espaço" class="editar" href="${linkTo[AluguelController].editarAluguel(aluguel.id)}">${aluguel.recurso.nome}</a></td>
															</shiro:hasPermission>
															<shiro:lacksPermission name="sgam.faturamento.aluguel.editar">
																<td>${aluguel.recurso.nome}</td>
															</shiro:lacksPermission>
															
															<shiro:hasPermission name="sgam.cadastros.morador.editar">
																<td><a onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" title="Link para acessar cadastro do morador" href="${linkTo[MoradorController].editarMorador(aluguel.morador.id)}">${aluguel.morador.nome}</a></td>
															</shiro:hasPermission>
															<shiro:lacksPermission name="sgam.cadastros.morador.editar">
																<td>${aluguel.morador.nome}</td>
															</shiro:lacksPermission>
															
															
															<td><i class="fa fa-clock-o"></i> <fmt:formatDate pattern="HH:mm" value="${aluguel.dataInicial}" /></td>
															<td><i class="fa fa-clock-o"></i> <fmt:formatDate pattern="HH:mm" value="${aluguel.dataFinal}" /></td>
															<td><i class="fa fa-calendar"></i> <fmt:formatDate pattern="dd/MM/yyyy" value="${aluguel.dataFinal}" /></td>
															<td><fmt:formatNumber value="${aluguel.contaReceber.valor}" type="currency"/></td>
															<c:choose>
																<c:when test="${aluguel.contaReceber.status eq 'Recebida'}">
																	<td><span class="label label-primary">${aluguel.contaReceber.status}</span></td>
																</c:when>
																
																<c:when test="${aluguel.contaReceber.status eq 'Pendente'}">
																	<td><span class="label label-warning">${aluguel.contaReceber.status}</span></td>
																</c:when>
																
																<c:otherwise>
																	<td><span class="label label-danger">${aluguel.contaReceber.status}</span></td>
																</c:otherwise>
															</c:choose>
														</tr>
													</c:forEach>
	                                            </tbody>
	                                        </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Comerciantes atuando hoje - <fmt:formatDate pattern="dd/MM/yyyy" value="${dataAtual}" /></h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="table-responsive">
	                                        <table class="table table-hover no-margins">
	                                            <thead>
	                                            <tr>
	                                                <th>Atividade</th>
	                                                <th>Morador</th>
	                                                <th>Inicio</th>
	                                                <th>Fim</th>
	                                                <th>Validade Alvará</th>
	                                                <th>Status Alvará</th>
	                                            </tr>
	                                            </thead>
	                                            <tbody>
		                                            <c:forEach var="comercio" items="${alugueisComercio}">
														<tr>
															<shiro:hasPermission name="sgam.faturamento.aluguel_comercio.editar">
																<td><a onclick="marcarMenuAtivo('menuFaturamento', 'submenuComercios', 'collapseFaturamento')" title="Link para acessar cadastro de comércio informal" href="${linkTo[AluguelComercioController].editarAluguelComercio(comercio.id)}">${comercio.nome}</a></td>
															</shiro:hasPermission>
															<shiro:lacksPermission name="sgam.faturamento.aluguel_comercio.editar">
																<td>${comercio.nome}</td>
															</shiro:lacksPermission>
															
															<shiro:hasPermission name="sgam.cadastros.morador.editar">
																<td><a onclick="marcarMenuAtivo('menuCadastros', 'submenuMoradores', 'collapseCadastros')" title="Link para acessar cadastro do morador" href="${linkTo[MoradorController].editarMorador(comercio.aluguel.morador.id)}">${comercio.aluguel.morador.nome}</a></td>
															</shiro:hasPermission>
															<shiro:lacksPermission name="sgam.cadastros.morador.editar">
																${comercio.aluguel.morador.nome}
															</shiro:lacksPermission>
															
															<td><i class="fa fa-clock-o"></i> <fmt:formatDate pattern="HH:mm" value="${comercio.aluguel.dataInicial}" /></td>
															<td><i class="fa fa-clock-o"></i> <fmt:formatDate pattern="HH:mm" value="${comercio.aluguel.dataFinal}" /></td>
															<td> <fmt:formatDate pattern="dd/MM/yyyy" value="${comercio.dataVencimento}" /> </td>
															<c:choose>
																<c:when test="${comercio.statusAlvara eq 'Ativo'}">
																	<td><span class="label label-primary">${comercio.statusAlvara}</span></td>
																</c:when>
						
																<c:otherwise>
																	<td><span class="label label-danger">${comercio.statusAlvara}</span></td>
																</c:otherwise>
															</c:choose>
														</tr>
													</c:forEach>
	                                            </tbody>
	                                        </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <div class="ibox float-e-margins">
                                    <div class="ibox-title">
                                        <h5>Contas a pagar do mês de ${mesCorrente}</h5>
                                        <div class="ibox-tools">
                                            <a class="collapse-link">
                                                <i class="fa fa-chevron-up"></i>
                                            </a>
                                        </div>
                                    </div>
                                    <div class="ibox-content">
                                        <div class="table-responsive">
	                                        <table class="table table-hover no-margins">
	                                            <thead>
	                                            <tr>
	                                                <th>Nome</th>
	                                                <th>Fornecedor</th>
	                                                <th>Vencimento</th>
	                                                <th>Valor</th>
	                                                <th>Status</th>
	                                            </tr>
	                                            </thead>
	                                            <tbody>
	                                            	<c:forEach var="conta" items="${contas}">
														<tr>
															<shiro:hasPermission name="sgam.financeiro.contas_pagar.editar">
																<td><a onclick="marcarMenuAtivo('menuFinanceiro', 'submenuContasPagar', 'collapseFinanceiro')" title="Link para acessar o cadastro da conta a pagar" href="${linkTo[ContasPagarController].editarConta(conta.id)}">${conta.nome}</a></td>
															</shiro:hasPermission>
															<shiro:lacksPermission name="sgam.financeiro.contas_pagar.editar">
																<td>${conta.nome}</td>
															</shiro:lacksPermission>
															
															<shiro:hasPermission name="sgam.cadastros.fornecedor.editar">
																<td><a onclick="marcarMenuAtivo('menuCadastros', 'submenuFornecedores', 'collapseCadastros')" title="Link para acessar cadastro do fornecedor" href="${linkTo[FornecedorController].editarFornecedor(conta.fornecedor.id)}">${conta.fornecedor.nome}</a></td>
															</shiro:hasPermission>
															<shiro:lacksPermission name="sgam.cadastros.fornecedor.editar">
																<td>${conta.fornecedor.nome}</td>
															</shiro:lacksPermission>
	
															<td><fmt:formatDate pattern="dd/MM/yyyy" value="${conta.dataVencimento}" /></td>
															<td><fmt:formatNumber value="${conta.valor}" type="currency"/></td>
															<c:choose>
																<c:when test="${conta.status eq 'Paga'}">
																	<td><span class="label label-primary">${conta.status}</span></td>
																</c:when>
																
																<c:when test="${conta.status eq 'Pendente'}">
																	<td><span class="label label-warning">${conta.status}</span></td>
																</c:when>
																
																<c:otherwise>
																	<td><span class="label label-danger">${conta.status}</span></td>
																</c:otherwise>
															</c:choose>
														</tr>
													</c:forEach>
	                                            </tbody>
	                                        </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
  

    <script src="${pageContext.request.contextPath}/manual_install_components/moment/moment-with-locales.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/plugins/chartJs/Chart.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/paginas/login/paginaInicial.js"></script>

  ﻿<%@ include file="/footer.jsp" %>               