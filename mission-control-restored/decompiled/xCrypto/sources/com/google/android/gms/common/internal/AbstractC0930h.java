package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.InterfaceC0903g;
import com.google.android.gms.common.api.internal.InterfaceC0912p;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import z1.C1986d;
import z1.C1988f;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0930h extends AbstractC0925c implements a.f {
    private static volatile Executor zaa;
    private final C0927e zab;
    private final Set zac;
    private final Account zad;

    public AbstractC0930h(Context context, Looper looper, int i4, C0927e c0927e, f.b bVar, f.c cVar) {
        this(context, looper, i4, c0927e, (InterfaceC0903g) bVar, (InterfaceC0912p) cVar);
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

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public Executor getBindServiceExecutor() {
        return null;
    }

    public final C0927e getClientSettings() {
        return this.zab;
    }

    public C1986d[] getRequiredFeatures() {
        return new C1986d[0];
    }

    @Override // com.google.android.gms.common.internal.AbstractC0925c
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.a.f
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.EMPTY_SET;
    }

    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }

    public AbstractC0930h(Context context, Looper looper, int i4, C0927e c0927e, InterfaceC0903g interfaceC0903g, InterfaceC0912p interfaceC0912p) {
        this(context, looper, AbstractC0931i.b(context), C1988f.n(), i4, c0927e, (InterfaceC0903g) AbstractC0940s.k(interfaceC0903g), (InterfaceC0912p) AbstractC0940s.k(interfaceC0912p));
    }

    public AbstractC0930h(Context context, Looper looper, AbstractC0931i abstractC0931i, C1988f c1988f, int i4, C0927e c0927e, InterfaceC0903g interfaceC0903g, InterfaceC0912p interfaceC0912p) {
        super(context, looper, abstractC0931i, c1988f, i4, interfaceC0903g == null ? null : new I(interfaceC0903g), interfaceC0912p != null ? new J(interfaceC0912p) : null, c0927e.k());
        this.zab = c0927e;
        this.zad = c0927e.b();
        this.zac = d(c0927e.e());
    }
}
