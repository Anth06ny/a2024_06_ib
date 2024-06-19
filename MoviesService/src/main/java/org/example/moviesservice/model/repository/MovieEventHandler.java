package org.example.moviesservice.model.repository;

import org.example.moviesservice.model.MovieBean;
import org.springframework.data.rest.core.annotation.*;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class MovieEventHandler {

    // Intercepte les événements avant la création d'une nouvelle entité
    @HandleBeforeCreate
    public void handleBeforeCreate(MovieBean movieBean) {
        System.out.println("Before creating entity: " + movieBean);
    }

    // Intercepte les événements après la création d'une nouvelle entité
    @HandleAfterCreate
    public void handleAfterCreate(MovieBean movieBean) {
        System.out.println("After creating entity: " + movieBean);
    }

    // Intercepte les événements avant la mise à jour d'une entité existante
    @HandleBeforeSave
    public void handleBeforeSave(MovieBean movieBean) {
        System.out.println("Before saving entity: " + movieBean);
    }

    // Intercepte les événements après la mise à jour d'une entité existante
    @HandleAfterSave
    public void handleAfterSave(MovieBean movieBean) {
        System.out.println("After saving entity: " + movieBean);
    }

    // Intercepte les événements avant la suppression d'une entité
    @HandleBeforeDelete
    public void handleBeforeDelete(MovieBean movieBean) {
        System.out.println("Before deleting entity: " + movieBean);
    }

    // Intercepte les événements après la suppression d'une entité
    @HandleAfterDelete
    public void handleAfterDelete(MovieBean movieBean) {
        System.out.println("After deleting entity: " + movieBean);
    }
}
