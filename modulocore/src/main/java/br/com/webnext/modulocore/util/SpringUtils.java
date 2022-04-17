package br.com.webnext.modulocore.util;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import antlr.StringUtils;
import br.com.webnext.modulocore.enuns.ModuloEnum;
import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;


@Component
public class SpringUtils {
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private MavenProperties mavenProperties;

	@Autowired
	private ApplicationContext applicationContext;
	
	

	public List<String> obterClassesPorPacotes() {
		
		String NOME_PACOTE = obterNomeCompletoPacote(
				obterPacoteBaseMaven(), 
				ModuloEnum.MODULO_API.getDescricao(), 
				Constantes.PACOTE_CONTROLLER);
		
		try (ScanResult scanResult = new ClassGraph().whitelistPackages(NOME_PACOTE)
				.enableClassInfo()
				.scan()) {
			
			return scanResult.getAllClasses().getNames().stream()
					.map(item -> item.substring(item.lastIndexOf(".") + 1).trim())
					.collect(Collectors.toList());
		}
	}

	public String obterPacoteBaseMaven() {
		return mavenProperties.getProperties().getPackageBase();
	}
	
	public String obterNomeCompletoPacote(String pacoteBase, String nomeModulo, String pacoteModulo) {
		return pacoteBase.concat(".").concat(nomeModulo).concat(".").concat(pacoteModulo);
	}

	public List<String> obterBeansContexto() {
		return new ArrayList<String>(Arrays.asList(applicationContext.getBeanDefinitionNames()));

	}

	public void obterControllersContexto() {
		
		List<String> controllers = obterClassesPorPacotes();
		List<String> beanNames = obterBeansContexto();

		for (String controller : controllers) {
			
			for (String beanName : beanNames) {
				if(controller.equalsIgnoreCase(beanName)) {
					LOG.info("O EndPoint:" + controller +" " + "foi inicializado no contexto do Spring");	
				}
			}
		}

	}

}
