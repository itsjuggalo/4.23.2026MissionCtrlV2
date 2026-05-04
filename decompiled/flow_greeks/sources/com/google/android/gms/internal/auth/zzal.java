package com.google.android.gms.internal.auth;

import android.accounts.Account;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.h;
import z4.a;
import z4.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzal implements b {
    private static final Status zza = new Status(13);

    public final h addWorkAccount(g gVar, String str) {
        return gVar.b(new zzae(this, a.f25594a, gVar, str));
    }

    public final h removeWorkAccount(g gVar, Account account) {
        return gVar.b(new zzag(this, a.f25594a, gVar, account));
    }

    public final void setWorkAuthenticatorEnabled(g gVar, boolean z10) {
        setWorkAuthenticatorEnabledWithResult(gVar, z10);
    }

    public final h setWorkAuthenticatorEnabledWithResult(g gVar, boolean z10) {
        return gVar.b(new zzac(this, a.f25594a, gVar, z10));
    }
}
