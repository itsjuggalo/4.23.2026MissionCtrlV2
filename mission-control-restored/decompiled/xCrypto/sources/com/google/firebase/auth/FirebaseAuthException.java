package com.google.firebase.auth;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.FirebaseException;

/* JADX INFO: loaded from: classes.dex */
public class FirebaseAuthException extends FirebaseException {
    private final String zza;

    public FirebaseAuthException(String str, String str2) {
        super(str2);
        this.zza = AbstractC0940s.e(str);
    }

    public String getErrorCode() {
        return this.zza;
    }
}
