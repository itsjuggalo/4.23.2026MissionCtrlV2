package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.ActionCodeMultiFactorInfo;
import com.google.firebase.auth.MultiFactorInfo;

/* JADX INFO: loaded from: classes.dex */
public final class zzv extends ActionCodeMultiFactorInfo {
    private final MultiFactorInfo zza;

    public zzv(String str, MultiFactorInfo multiFactorInfo) {
        this.email = AbstractC0940s.e(str);
        this.zza = (MultiFactorInfo) AbstractC0940s.k(multiFactorInfo);
    }

    @Override // com.google.firebase.auth.ActionCodeMultiFactorInfo
    public final MultiFactorInfo getMultiFactorInfo() {
        return this.zza;
    }
}
