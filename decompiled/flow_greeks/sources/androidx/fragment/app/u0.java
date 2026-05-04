package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.i;
import androidx.lifecycle.j0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u0 implements androidx.lifecycle.g, k2.f, androidx.lifecycle.m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f2325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.l0 f2326b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f2327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.n f2328d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public k2.e f2329e = null;

    public u0(p pVar, androidx.lifecycle.l0 l0Var, Runnable runnable) {
        this.f2325a = pVar;
        this.f2326b = l0Var;
        this.f2327c = runnable;
    }

    public void a(i.a aVar) {
        this.f2328d.h(aVar);
    }

    public void b() {
        if (this.f2328d == null) {
            this.f2328d = new androidx.lifecycle.n(this);
            k2.e eVarA = k2.e.a(this);
            this.f2329e = eVarA;
            eVarA.c();
            this.f2327c.run();
        }
    }

    public boolean c() {
        return this.f2328d != null;
    }

    public void d(Bundle bundle) {
        this.f2329e.d(bundle);
    }

    public void e(Bundle bundle) {
        this.f2329e.e(bundle);
    }

    public void f(i.b bVar) {
        this.f2328d.m(bVar);
    }

    @Override // androidx.lifecycle.g
    public y1.a getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = this.f2325a.requireContext().getApplicationContext();
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
        y1.b bVar = new y1.b();
        if (application != null) {
            bVar.c(j0.a.f2437h, application);
        }
        bVar.c(androidx.lifecycle.c0.f2396a, this.f2325a);
        bVar.c(androidx.lifecycle.c0.f2397b, this);
        if (this.f2325a.getArguments() != null) {
            bVar.c(androidx.lifecycle.c0.f2398c, this.f2325a.getArguments());
        }
        return bVar;
    }

    @Override // androidx.lifecycle.m
    public androidx.lifecycle.i getLifecycle() {
        b();
        return this.f2328d;
    }

    @Override // k2.f
    public k2.d getSavedStateRegistry() {
        b();
        return this.f2329e.b();
    }

    @Override // androidx.lifecycle.m0
    public androidx.lifecycle.l0 getViewModelStore() {
        b();
        return this.f2326b;
    }
}
