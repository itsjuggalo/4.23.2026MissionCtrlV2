package com.google.firebase.internal;

import com.google.android.gms.common.internal.AbstractC0939q;

/* JADX INFO: loaded from: classes.dex */
public class InternalTokenResult {
    private String zza;

    public InternalTokenResult(String str) {
        this.zza = str;
    }

    public boolean equals(Object obj) {
        if (obj instanceof InternalTokenResult) {
            return AbstractC0939q.b(this.zza, ((InternalTokenResult) obj).zza);
        }
        return false;
    }

    public String getToken() {
        return this.zza;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.zza);
    }

    public String toString() {
        return AbstractC0939q.d(this).a("token", this.zza).toString();
    }
}
