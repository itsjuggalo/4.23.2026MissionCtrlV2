package com.google.firebase.appcheck.debug;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckProvider;
import com.google.firebase.appcheck.AppCheckProviderFactory;
import com.google.firebase.appcheck.debug.internal.DebugAppCheckProvider;

/* JADX INFO: loaded from: classes.dex */
public class DebugAppCheckProviderFactory implements AppCheckProviderFactory {
    private static final DebugAppCheckProviderFactory instance = new DebugAppCheckProviderFactory();

    private DebugAppCheckProviderFactory() {
    }

    public static DebugAppCheckProviderFactory getInstance() {
        return instance;
    }

    @Override // com.google.firebase.appcheck.AppCheckProviderFactory
    public AppCheckProvider create(FirebaseApp firebaseApp) {
        return (AppCheckProvider) firebaseApp.get(DebugAppCheckProvider.class);
    }
}
