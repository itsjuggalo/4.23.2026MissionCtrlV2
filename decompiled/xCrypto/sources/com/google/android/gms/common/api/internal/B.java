package com.google.android.gms.common.api.internal;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class B extends AbstractC0907k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f9693a;

    public B(InterfaceC0908l interfaceC0908l) {
        super(interfaceC0908l);
        this.f9693a = new ArrayList();
        this.mLifecycleFragment.a("LifecycleObserverOnStop", this);
    }

    public static /* bridge */ /* synthetic */ B a(Activity activity) {
        B b4;
        synchronized (activity) {
            try {
                InterfaceC0908l fragment = AbstractC0907k.getFragment(activity);
                b4 = (B) fragment.b("LifecycleObserverOnStop", B.class);
                if (b4 == null) {
                    b4 = new B(fragment);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b4;
    }

    public final synchronized void c(Runnable runnable) {
        this.f9693a.add(runnable);
    }

    @Override // com.google.android.gms.common.api.internal.AbstractC0907k
    public final void onStop() {
        List list;
        synchronized (this) {
            list = this.f9693a;
            this.f9693a = new ArrayList();
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
