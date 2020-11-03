package br.com.ilog.tecnologia.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import br.com.ilog.tecnologia.model.Usuario;


@RepositoryEventHandler
public class UsuarioEventHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    
    @HandleBeforeCreate
    @HandleBeforeSave
    public void handleAuthorBeforeCreate(Usuario author){
        System.out.println("CRIAR");
        logger.info("Inside Author Before Create....");
        author.getNome();
    }
 
    @HandleAfterCreate
    public void handleAuthorAfterCreate(Usuario author){
        logger.info("Inside Author After Create ....");
        System.out.println("CRIAR");
        author.getNome();
    }
 
    @HandleBeforeDelete
    public void handleAuthorBeforeDelete(Usuario author){
        logger.info("Inside Author Before Delete ....");
    }
 
    @HandleAfterDelete
    public void handleAuthorAfterDelete(Usuario author){
        logger.info("Inside Author After Delete ....");
    }
}
