package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.AbstractC0846i;
import androidx.lifecycle.C0851n;
import androidx.lifecycle.InterfaceC0844g;
import androidx.lifecycle.K;
import c0.AbstractC0870a;
import c0.C0871b;

/* JADX INFO: loaded from: classes.dex */
public class V implements InterfaceC0844g, o0.f, androidx.lifecycle.N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractComponentCallbacksC0828p f7405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.M f7406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f7407c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public C0851n f7408e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public o0.e f7409f = null;

    public V(AbstractComponentCallbacksC0828p abstractComponentCallbacksC0828p, androidx.lifecycle.M m4, Runnable runnable) {
        this.f7405a = abstractComponentCallbacksC0828p;
        this.f7406b = m4;
        this.f7407c = runnable;
    }

    public void a(AbstractC0846i.a aVar) {
        this.f7408e.h(aVar);
    }

    public void b() {
        if (this.f7408e == null) {
            this.f7408e = new C0851n(this);
            o0.e eVarA = o0.e.a(this);
            this.f7409f = eVarA;
            eVarA.c();
            this.f7407c.run();
        }
    }

    public boolean c() {
        return this.f7408e != null;
    }

    public void d(Bundle bundle) {
        this.f7409f.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f7409f.e(bundle);
    }

    public void f(AbstractC0846i.b bVar) {
        this.f7408e.m(bVar);
    }

    @Override // androidx.lifecycle.InterfaceC0844g
    public AbstractC0870a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f7405a.requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        C0871b c0871b = new C0871b();
        if (application != null) {
            c0871b.c(K.a.f7651h, application);
        }
        c0871b.c(androidx.lifecycle.D.f7627a, this.f7405a);
        c0871b.c(androidx.lifecycle.D.f7628b, this);
        if (this.f7405a.getArguments() != null) {
            c0871b.c(androidx.lifecycle.D.f7629c, this.f7405a.getArguments());
        }
        return c0871b;
    }

    @Override // androidx.lifecycle.InterfaceC0850m
    public AbstractC0846i getLifecycle() {
        b();
        return this.f7408e;
    }

    @Override // o0.f
    public o0.d getSavedStateRegistry() {
        b();
        return this.f7409f.b();
    }

    @Override // androidx.lifecycle.N
    public androidx.lifecycle.M getViewModelStore() {
        b();
        return this.f7406b;
    }
}
