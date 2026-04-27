package com.google.firebase.auth;

import A1.d;

/* JADX INFO: loaded from: classes.dex */
public interface AuthResult extends d {
    AdditionalUserInfo getAdditionalUserInfo();

    AuthCredential getCredential();

    FirebaseUser getUser();
}
