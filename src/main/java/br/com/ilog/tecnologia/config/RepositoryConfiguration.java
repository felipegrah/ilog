package br.com.ilog.tecnologia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import br.com.ilog.tecnologia.event.UsuarioEventHandler;

@Configuration
public class RepositoryConfiguration {

    @Bean
    UsuarioEventHandler usuarioEventHandler () {
        return new UsuarioEventHandler();
    }

    
    
}
