package com.google.firebase.installations.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallations;
import com.google.firebase.ktx.Firebase;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class InstallationsKt {
    public static final FirebaseInstallations getInstallations(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance();
        r.e(firebaseInstallations, "getInstance()");
        return firebaseInstallations;
    }

    public static final FirebaseInstallations installations(Firebase firebase, FirebaseApp app) {
        r.f(firebase, "<this>");
        r.f(app, "app");
        FirebaseInstallations firebaseInstallations = FirebaseInstallations.getInstance(app);
        r.e(firebaseInstallations, "getInstance(app)");
        return firebaseInstallations;
    }
}
