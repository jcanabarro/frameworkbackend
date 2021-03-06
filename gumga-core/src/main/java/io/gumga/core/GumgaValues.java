package io.gumga.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Interface que deve ser implementada para alterar comportamentos padrão do
 * framework.
 *
 * @author munif
 */
public interface GumgaValues {

    static final Logger log = LoggerFactory.getLogger(GumgaValues.class);

    /**
     * @return Pacote onde se encontram as classes utilizadas no NLP
     */
    default String getGumgaNLPBasePackage() {
        return "io.gumga";
    };

    /**
     * @return Tempo padrão de expiração do ticket para troca de senha.
     */
    default long getDefaultExpirationForChangePassword() {
        return 3600l * 1000 * 6;
    }

    /**
     * @return URL do sistema de segurança
     */
    default String getGumgaSecurityPage() {
        return "http://www.gumga.com.br/security";
    }

    /**
     * @return URL da api do sistema de segurança
     */
    default String getGumgaSecurityUrl() {
        return "http://www.gumga.com.br/security-api/publicoperations";
    }

    /**
     * @return Tempo padrão de expiração do token curto neste software em
     * segundos.
     */
    default long getDefaultTokenDuration() {
        return 30l * 60l * 1000l;
    }

    /**
     * @return se o log está ativo
     */
    default boolean isLogActive() {
        return true;
    }

    /**
     * @return Log da requisições aparece no console
     */
    default boolean isLogRequestOnConsole() {
        return false;
    }

    /**
     * @return Lista de paths de urls que serão ignoradas do log
     */
    default Set<String> getUrlsToNotLog() {
        return new HashSet<>();
    }

    /**
     * @return diretório para armazenar aquivos vindos do upload
     */

    default String getUploadTempDir() {
        return System.getProperty("user.home").concat("/gumgafiles/tempupload");
    }

    /**
     * @return diretório para armazenar aquivos de log
     */

    default String getLogDir() {
        return System.getProperty("user.home").concat("/gumgafiles/logs");
    }

    /**
     * @return diretório para armazenar templates como email
     */

    default String getTemplatesFolder() {
        return System.getProperty("user.home").concat("/gumgafiles/templates");
    }
    /**
     * @return propeties de configuração do usuario
     */

    default Properties getCustomFileProperties() {
        Properties toReturn = new Properties();
        try {
            InputStream input = new FileInputStream(System.getProperty("user.home") + "/gumgafiles/" + getCustomPropertiesFileName());
            toReturn.load(input);
        } catch (IOException e) {
            log.info("Utilizando properties padrão");
        }
        return toReturn;
    }

    /**
     * @return arquivo de configuração da applicação
     */
    default String getCustomPropertiesFileName() {
        return "gumga-security.properties";
    }

    /**
     * @return nome do software
     */
    default String getSoftwareName() {
        return "";
    }

}
