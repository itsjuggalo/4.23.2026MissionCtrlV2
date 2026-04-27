package com.google.firebase.auth;

import A1.d;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface AdditionalUserInfo extends d {
    Map<String, Object> getProfile();

    String getProviderId();

    String getUsername();

    boolean isNewUser();
}
