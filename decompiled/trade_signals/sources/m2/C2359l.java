package m2;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import l2.AbstractC2328l;
import o2.InterfaceC2457a;
import p2.InterfaceC2545b;

/* JADX INFO: renamed from: m2.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2359l implements InterfaceC2349b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2370w f21366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2356i f21367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f21368c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f21369d = new Handler(Looper.getMainLooper());

    public C2359l(C2370w c2370w, C2356i c2356i, Context context) {
        this.f21366a = c2370w;
        this.f21367b = c2356i;
        this.f21368c = context;
    }

    @Override // m2.InterfaceC2349b
    public final AbstractC2328l a() {
        return this.f21366a.d(this.f21368c.getPackageName());
    }

    @Override // m2.InterfaceC2349b
    public final boolean b(C2348a c2348a, Activity activity, AbstractC2351d abstractC2351d, int i8) {
        if (activity == null) {
            return false;
        }
        return g(c2348a, new C2358k(this, activity), abstractC2351d, i8);
    }

    @Override // m2.InterfaceC2349b
    public final AbstractC2328l c() {
        return this.f21366a.e(this.f21368c.getPackageName());
    }

    @Override // m2.InterfaceC2349b
    public final synchronized void d(InterfaceC2545b interfaceC2545b) {
        this.f21367b.c(interfaceC2545b);
    }

    @Override // m2.InterfaceC2349b
    public final boolean e(C2348a c2348a, int i8, Activity activity, int i9) {
        AbstractC2351d abstractC2351dC = AbstractC2351d.c(i8);
        if (activity == null) {
            return false;
        }
        return g(c2348a, new C2358k(this, activity), abstractC2351dC, i9);
    }

    @Override // m2.InterfaceC2349b
    public final synchronized void f(InterfaceC2545b interfaceC2545b) {
        this.f21367b.b(interfaceC2545b);
    }

    public final boolean g(C2348a c2348a, InterfaceC2457a interfaceC2457a, AbstractC2351d abstractC2351d, int i8) {
        if (c2348a == null || interfaceC2457a == null || abstractC2351d == null || !c2348a.f(abstractC2351d) || c2348a.m()) {
            return false;
        }
        c2348a.l();
        interfaceC2457a.a(c2348a.j(abstractC2351d).getIntentSender(), i8, null, 0, 0, 0, null);
        return true;
    }
}
