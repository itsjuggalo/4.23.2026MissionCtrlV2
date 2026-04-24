package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.ActionCodeEmailInfo;

/* JADX INFO: loaded from: classes.dex */
public final class zzt extends ActionCodeEmailInfo {
    private final String zza;

    public zzt(String str, String str2) {
        this.email = AbstractC0940s.e(str);
        this.zza = AbstractC0940s.e(str2);
    }

    @Override // com.google.firebase.auth.ActionCodeEmailInfo
    public final String getPreviousEmail() {
        return this.zza;
    }
}
