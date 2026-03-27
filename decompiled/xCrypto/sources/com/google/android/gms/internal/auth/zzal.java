package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.h;
import o1.AbstractC1661a;
import o1.InterfaceC1662b;

/* JADX INFO: loaded from: classes.dex */
public final class zzal implements InterfaceC1662b {
    private static final Status zza = new Status(13);

    public final h addWorkAccount(f fVar, String str) {
        return fVar.b(new zzae(this, AbstractC1661a.f13913a, fVar, str));
    }

    public final h removeWorkAccount(f fVar, Account account) {
        return fVar.b(new zzag(this, AbstractC1661a.f13913a, fVar, account));
    }

    public final void setWorkAuthenticatorEnabled(f fVar, boolean z4) {
        setWorkAuthenticatorEnabledWithResult(fVar, z4);
    }

    public final h setWorkAuthenticatorEnabledWithResult(f fVar, boolean z4) {
        return fVar.b(new zzac(this, AbstractC1661a.f13913a, fVar, z4));
    }
}
