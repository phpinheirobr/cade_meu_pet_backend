package br.com.webnext.modulocore.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "maven")
public class MavenProperties {

	private final Properties properties = new Properties();

	public static class Properties {
		private String packageBase;

		public String getPackageBase(){
			return packageBase;
		}

		public void setPackageBase(String packageBase){
			this.packageBase = packageBase;
		}
	}

	public Properties getProperties() {
		return properties;
	}

}
