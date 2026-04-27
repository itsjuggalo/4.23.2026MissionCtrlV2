package com.google.firebase.appcheck.ktx;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.AppCheckToken;
import com.google.firebase.appcheck.FirebaseAppCheck;
import com.google.firebase.ktx.Firebase;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseAppCheckKt {
    public static final FirebaseAppCheck appCheck(Firebase firebase, FirebaseApp app) {
        r.f(firebase, "<this>");
        r.f(app, "app");
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance(app);
        r.e(firebaseAppCheck, "getInstance(app)");
        return firebaseAppCheck;
    }

    public static final String component1(AppCheckToken appCheckToken) {
        r.f(appCheckToken, "<this>");
        String token = appCheckToken.getToken();
        r.e(token, "token");
        return token;
    }

    public static final long component2(AppCheckToken appCheckToken) {
        r.f(appCheckToken, "<this>");
        return appCheckToken.getExpireTimeMillis();
    }

    public static final FirebaseAppCheck getAppCheck(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseAppCheck firebaseAppCheck = FirebaseAppCheck.getInstance();
        r.e(firebaseAppCheck, "getInstance()");
        return firebaseAppCheck;
    }
}
