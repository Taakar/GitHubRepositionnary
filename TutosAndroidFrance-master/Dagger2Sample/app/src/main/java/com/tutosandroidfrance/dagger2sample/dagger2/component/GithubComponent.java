package com.tutosandroidfrance.dagger2sample.dagger2.component;

import com.tutosandroidfrance.dagger2sample.MainActivity;
import com.tutosandroidfrance.dagger2sample.dagger2.module.ContextModule;
import com.tutosandroidfrance.dagger2sample.dagger2.module.GithubModule;
import com.tutosandroidfrance.dagger2sample.storage.Storage;
import com.tutosandroidfrance.dagger2sample.webservice.GithubService;

import java.util.Objects;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Composant principale de ce tutoriel, GithubComponent va utiliser Dagger2 afin de créer le GithubService et le Storage
 * Ce composant est un singleton, c'est à dire qu'il n'existe qu'un fois lors de l'éxécution de l'application
 *
 * dependencies = {AppComponent.class} indique que ce Component dépend de AppComponent afin
 * qu'il lui @Provide un objet, dans notre cas, le Context
 *
 * modules = {StorageModule.class, RestModule.class} indique que ce Component utilisera
 * les fonctions indiquées en @Provide de StorageModule et RestModule afin de générer les GithubService et Storage
 */
@Singleton
@Component(modules = {ContextModule.class, GithubModule.class})

public interface GithubComponent {

    GithubService githubService();
    Storage storage();

    void inject(MainActivity mainActivity);
}
