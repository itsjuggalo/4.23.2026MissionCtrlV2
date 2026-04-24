package com.google.android.gms.internal.auth;

import F1.a;
import F1.b;
import android.accounts.Account;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;

/* JADX INFO: loaded from: classes.dex */
public final class zzal implements b {
    private static final Status zza = new Status(13);

    public final h addWorkAccount(f fVar, String str) {
        return fVar.b(new zzae(this, a.f1892a, fVar, str));
    }

    public final h removeWorkAccount(f fVar, Account account) {
        return fVar.b(new zzag(this, a.f1892a, fVar, account));
    }

    public final void setWorkAuthenticatorEnabled(f fVar, boolean z7) {
        setWorkAuthenticatorEnabledWithResult(fVar, z7);
    }

    public final h setWorkAuthenticatorEnabledWithResult(f fVar, boolean z7) {
        return fVar.b(new zzac(this, a.f1892a, fVar, z7));
    }
}
