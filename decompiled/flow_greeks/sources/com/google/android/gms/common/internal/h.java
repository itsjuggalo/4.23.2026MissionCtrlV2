package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h extends c implements a.f {
    private static volatile Executor zaa;
    private final e zab;
    private final Set zac;
    private final Account zad;

    public h(Context context, Looper looper, int i10, e eVar, g.b bVar, g.c cVar) {
        this(context, looper, i10, eVar, (com.google.android.gms.common.api.internal.f) bVar, (com.google.android.gms.common.api.internal.n) cVar);
    }

    public static void zag(Executor executor) {
        zaa = executor;
    }

    public final Set d(Set set) {
        Set<Scope> setValidateScopes = validateScopes(set);
        Iterator<Scope> it = setValidateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setValidateScopes;
    }

    @Override // com.google.android.gms.common.internal.c
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.c
    public Executor getBindServiceExecutor() {
        return zaa;
    }

    public final e getClientSettings() {
        return this.zab;
    }

    public m5.d[] getRequiredFeatures() {
        return new m5.d[0];
    }

    @Override // com.google.android.gms.common.internal.c
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.EMPTY_SET;
    }

    public h(Context context, Looper looper, int i10, e eVar, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.n nVar) {
        this(context, looper, i.a(context), m5.e.n(), i10, eVar, (com.google.android.gms.common.api.internal.f) s.k(fVar), (com.google.android.gms.common.api.internal.n) s.k(nVar));
    }

    public h(Context context, Looper looper, i iVar, m5.e eVar, int i10, e eVar2, com.google.android.gms.common.api.internal.f fVar, com.google.android.gms.common.api.internal.n nVar) {
        super(context, looper, iVar, eVar, i10, fVar == null ? null : new g0(fVar), nVar != null ? new h0(nVar) : null, eVar2.i());
        this.zab = eVar2;
        this.zad = eVar2.b();
        this.zac = d(eVar2.e());
    }

    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
