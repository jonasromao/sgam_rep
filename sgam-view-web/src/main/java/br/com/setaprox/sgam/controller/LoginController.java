package br.com.setaprox.sgam.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.joda.time.LocalDate;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.setaprox.sgam.constante.Status;
import br.com.setaprox.sgam.facade.AluguelComercioFacade;
import br.com.setaprox.sgam.facade.AluguelFacade;
import br.com.setaprox.sgam.facade.ContasPagarFacade;
import br.com.setaprox.sgam.facade.MoradorFacade;
import br.com.setaprox.sgam.facade.OcorrenciaFacade;
import br.com.setaprox.sgam.model.Aluguel;
import br.com.setaprox.sgam.model.AluguelComercio;
import br.com.setaprox.sgam.model.ContasPagar;
import br.com.setaprox.sgam.model.Ocorrencia;
import br.com.setaprox.sgam.model.Usuario;
import br.com.setaprox.sgam.utils.CipherUtil;

@Controller
public class LoginController {
	private Result result;
	
	@Inject
	private AluguelFacade aluguelFacade;
	
	@Inject
	private AluguelComercioFacade aluguelComercioFacade;
	
	@Inject
	private ContasPagarFacade contasPagarFacade;
	
	@Inject
	private OcorrenciaFacade ocorrenciaFacade;
	
	@Inject
	private MoradorFacade moradorFacade;

	/**
	 * @deprecated CDI eyes only
	 */
	protected LoginController() {
		this(null);
	}
	
	@Inject
	public LoginController(Result result) {
		this.result = result;
	}
	
	@Path("/")
	public void login() {
		
	}

	@Post("/login")
	public void logar(Usuario usuario){
		try {
			Subject currentUser = SecurityUtils.getSubject();
			
			usuario.setSenha(CipherUtil.encodeSHA256(usuario.getSenha()));
			
			if (!currentUser.isAuthenticated()) {
				currentUser.login(new UsernamePasswordToken(usuario.getLogin(), usuario.getSenha()));

				result.redirectTo(this).paginaInicial();	
			} 
			else {
				result.redirectTo(this).paginaInicial();
			}
		}
		catch (UnknownAccountException e) {
			result.redirectTo(this).login();
		}
		catch (IncorrectCredentialsException e) {
			
		}
		catch (LockedAccountException e) {
			result.redirectTo(this).login();
		}
		catch (ExcessiveAttemptsException e) {
			result.redirectTo(this).login();
		}
		catch (AuthenticationException e) {
			result.redirectTo(this).login();
		} catch (Exception e) {
			result.redirectTo(this).login();
			e.printStackTrace();
		}
	}
	
	@Get("/logout")
	public void logout() {
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		result.redirectTo(this).login();
	}

	@Path("/home")
	public void paginaInicial(){
		LocalDate dataAtual = LocalDate.now();
		
		List<Aluguel> alugueis = null;
		List<AluguelComercio> alugueisComercio = null;
		List<ContasPagar> contas = null;
		List<Ocorrencia> ocorrencias = null;
		
		long totalMoradores = 0l;
		long totalAssociados = 0l;
		long totalAssociadosMes = 0l;
		
		long porcentSocios = 0l;
		long porcentSociosMes = 0l;
		
		
		try{
			alugueis = aluguelFacade.reservasPorDia(dataAtual.toDate());
			alugueisComercio = aluguelComercioFacade.reservasPorDia(dataAtual.toDate());
			contas = contasPagarFacade.contasVencimentoMensal(dataAtual.toDate());
			ocorrencias = ocorrenciaFacade.ocorrenciasPorStatus(Status.ABERTA.getCodigo());
			
			totalMoradores = moradorFacade.totalMoradores();
			totalAssociados = moradorFacade.totalAssociados(null, null);
			totalAssociadosMes = moradorFacade.totalAssociados(dataAtual.toDate(), dataAtual.toDate());
			
			porcentSocios = (totalAssociados * 100) / totalMoradores;
			porcentSociosMes = (totalAssociadosMes * 100) / totalMoradores;
			
		} catch(ArithmeticException e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}
		
		result.include("mesCorrente", dataAtual.toString("MMMM",new Locale("pt", "BR")));
		result.include("dataAtual", dataAtual.toDate());
		result.include("alugueis", alugueis);
		result.include("alugueisComercio", alugueisComercio);
		result.include("contas", contas);
		result.include("ocorrencias", ocorrencias);
		result.include("qtdOcorrencias", ocorrencias.size());
		
		result.include("totalMoradores", totalMoradores);
		result.include("totalAssociados", totalAssociados);
		result.include("totalAssociadosMes", totalAssociadosMes);
		
		result.include("porcentSocios", porcentSocios);
		result.include("porcentSociosMes", porcentSociosMes);
	}

}
