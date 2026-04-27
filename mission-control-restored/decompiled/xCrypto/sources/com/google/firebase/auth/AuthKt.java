package com.google.firebase.auth;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.OAuthProvider;
import com.google.firebase.auth.UserProfileChangeRequest;
import i3.k;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class AuthKt {
    public static final ActionCodeSettings actionCodeSettings(k init) {
        r.f(init, "init");
        ActionCodeSettings.Builder builderNewBuilder = ActionCodeSettings.newBuilder();
        r.e(builderNewBuilder, "newBuilder(...)");
        init.invoke(builderNewBuilder);
        ActionCodeSettings actionCodeSettingsBuild = builderNewBuilder.build();
        r.e(actionCodeSettingsBuild, "build(...)");
        return actionCodeSettingsBuild;
    }

    public static final FirebaseAuth auth(Firebase firebase, FirebaseApp app) {
        r.f(firebase, "<this>");
        r.f(app, "app");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(app);
        r.e(firebaseAuth, "getInstance(...)");
        return firebaseAuth;
    }

    public static final FirebaseAuth getAuth(Firebase firebase) {
        r.f(firebase, "<this>");
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        r.e(firebaseAuth, "getInstance(...)");
        return firebaseAuth;
    }

    public static final AuthCredential oAuthCredential(String providerId, k init) {
        r.f(providerId, "providerId");
        r.f(init, "init");
        OAuthProvider.CredentialBuilder credentialBuilderNewCredentialBuilder = OAuthProvider.newCredentialBuilder(providerId);
        r.e(credentialBuilderNewCredentialBuilder, "newCredentialBuilder(...)");
        init.invoke(credentialBuilderNewCredentialBuilder);
        AuthCredential authCredentialBuild = credentialBuilderNewCredentialBuilder.build();
        r.e(authCredentialBuild, "build(...)");
        return authCredentialBuild;
    }

    public static final OAuthProvider oAuthProvider(String providerId, k init) {
        r.f(providerId, "providerId");
        r.f(init, "init");
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(providerId);
        r.e(builderNewBuilder, "newBuilder(...)");
        init.invoke(builderNewBuilder);
        OAuthProvider oAuthProviderBuild = builderNewBuilder.build();
        r.e(oAuthProviderBuild, "build(...)");
        return oAuthProviderBuild;
    }

    public static final UserProfileChangeRequest userProfileChangeRequest(k init) {
        r.f(init, "init");
        UserProfileChangeRequest.Builder builder = new UserProfileChangeRequest.Builder();
        init.invoke(builder);
        UserProfileChangeRequest userProfileChangeRequestBuild = builder.build();
        r.e(userProfileChangeRequestBuild, "build(...)");
        return userProfileChangeRequestBuild;
    }

    public static final OAuthProvider oAuthProvider(String providerId, FirebaseAuth firebaseAuth, k init) {
        r.f(providerId, "providerId");
        r.f(firebaseAuth, "firebaseAuth");
        r.f(init, "init");
        OAuthProvider.Builder builderNewBuilder = OAuthProvider.newBuilder(providerId, firebaseAuth);
        r.e(builderNewBuilder, "newBuilder(...)");
        init.invoke(builderNewBuilder);
        OAuthProvider oAuthProviderBuild = builderNewBuilder.build();
        r.e(oAuthProviderBuild, "build(...)");
        return oAuthProviderBuild;
    }
}
