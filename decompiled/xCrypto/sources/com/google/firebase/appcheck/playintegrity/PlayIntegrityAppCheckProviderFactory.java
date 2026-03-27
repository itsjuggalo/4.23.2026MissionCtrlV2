package com.google.firebase.appcheck.playintegrity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckProvider;
import com.google.firebase.appcheck.AppCheckProviderFactory;
import com.google.firebase.appcheck.playintegrity.internal.PlayIntegrityAppCheckProvider;

/* JADX INFO: loaded from: classes.dex */
public class PlayIntegrityAppCheckProviderFactory implements AppCheckProviderFactory {
    private static final PlayIntegrityAppCheckProviderFactory instance = new PlayIntegrityAppCheckProviderFactory();

    public static PlayIntegrityAppCheckProviderFactory getInstance() {
        return instance;
    }

    @Override // com.google.firebase.appcheck.AppCheckProviderFactory
    public AppCheckProvider create(FirebaseApp firebaseApp) {
        return (AppCheckProvider) firebaseApp.get(PlayIntegrityAppCheckProvider.class);
    }
}
