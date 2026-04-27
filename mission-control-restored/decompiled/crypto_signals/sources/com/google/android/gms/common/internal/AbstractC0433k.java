package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.InterfaceC0403f;
import com.google.android.gms.common.api.internal.InterfaceC0413p;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import u1.C1202d;
import u1.C1203e;

/* JADX INFO: renamed from: com.google.android.gms.common.internal.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0433k extends AbstractC0428f implements com.google.android.gms.common.api.g {
    private static volatile Executor zaa;
    private final C0430h zab;
    private final Set zac;
    private final Account zad;

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC0433k(Context context, Looper looper, int i, C0430h c0430h, InterfaceC0403f interfaceC0403f, InterfaceC0413p interfaceC0413p) {
        V vA = AbstractC0434l.a(context);
        C1203e c1203e = C1203e.f10284d;
        I.g(interfaceC0403f);
        I.g(interfaceC0413p);
        super(context, looper, vA, c1203e, i, new C0441t(interfaceC0403f), new C0441t(interfaceC0413p), c0430h.e);
        this.zab = c0430h;
        this.zad = null;
        Set<Scope> set = c0430h.f5238b;
        Set<Scope> setValidateScopes = validateScopes(set);
        Iterator<Scope> it = setValidateScopes.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.zac = setValidateScopes;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final Account getAccount() {
        return this.zad;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public Executor getBindServiceExecutor() {
        return null;
    }

    public final C0430h getClientSettings() {
        return this.zab;
    }

    public C1202d[] getRequiredFeatures() {
        return new C1202d[0];
    }

    @Override // com.google.android.gms.common.internal.AbstractC0428f
    public final Set<Scope> getScopes() {
        return this.zac;
    }

    @Override // com.google.android.gms.common.api.g
    public Set<Scope> getScopesForConnectionlessNonSignIn() {
        return requiresSignIn() ? this.zac : Collections.EMPTY_SET;
    }

    public Set<Scope> validateScopes(Set<Scope> set) {
        return set;
    }
}
