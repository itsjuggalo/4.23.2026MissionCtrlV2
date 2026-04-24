package com.google.android.gms.common.internal;

import P1.C0650d;
import P1.C0652f;
import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.InterfaceC1169f;
import com.google.android.gms.common.api.internal.InterfaceC1178o;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1197h extends AbstractC1192c implements a.f {
    private static volatile Executor zaa;
    private final C1194e zab;
    private final Set zac;
    private final Account zad;

    public AbstractC1197h(Context context, Looper looper, int i7, C1194e c1194e, f.b bVar, f.c cVar) {
        this(context, looper, i7, c1194e, (InterfaceC1169f) bVar, (InterfaceC1178o) cVar);
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

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public Executor getBindServiceExecutor() {
        return null;
    }

    public final C1194e getClientSettings() {
        return this.zab;
    }

    public C0650d[] getRequiredFeatures() {
        return new C0650d[0];
    }

    @Override // com.google.android.gms.common.internal.AbstractC1192c
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.emptySet();
    }

    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }

    public AbstractC1197h(Context context, Looper looper, int i7, C1194e c1194e, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        this(context, looper, AbstractC1198i.b(context), C0652f.n(), i7, c1194e, (InterfaceC1169f) AbstractC1207s.k(interfaceC1169f), (InterfaceC1178o) AbstractC1207s.k(interfaceC1178o));
    }

    public AbstractC1197h(Context context, Looper looper, AbstractC1198i abstractC1198i, C0652f c0652f, int i7, C1194e c1194e, InterfaceC1169f interfaceC1169f, InterfaceC1178o interfaceC1178o) {
        super(context, looper, abstractC1198i, c0652f, i7, interfaceC1169f == null ? null : new I(interfaceC1169f), interfaceC1178o == null ? null : new J(interfaceC1178o), c1194e.k());
        this.zab = c1194e;
        this.zad = c1194e.b();
        this.zac = d(c1194e.e());
    }
}
