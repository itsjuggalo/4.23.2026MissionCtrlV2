package S1;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.measurement.zzcu;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.revenuecat.purchases.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.e6, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0565e6 extends AbstractC0593i2 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Y5 f4483c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public InterfaceC0601j2 f4484d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Boolean f4485e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A f4486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledExecutorService f4487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final A6 f4488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List f4489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final A f4490j;

    public C0565e6(C0658q3 c0658q3) {
        super(c0658q3);
        this.f4489i = new ArrayList();
        this.f4488h = new A6(c0658q3.f());
        this.f4483c = new Y5(this);
        this.f4486f = new E5(this, c0658q3);
        this.f4490j = new I5(this, c0658q3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public final void J() {
        h();
        this.f4488h.a();
        this.f4245a.w();
        this.f4486f.b(((Long) AbstractC0569f2.f4552Z.b(null)).longValue());
    }

    public final void A() {
        h();
        j();
        Y5 y5 = this.f4483c;
        y5.d();
        try {
            F1.b.b().c(this.f4245a.e(), y5);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f4484d = null;
    }

    public final void B(zzcu zzcuVar, J j4, String str) {
        h();
        j();
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.C().X(12451000) == 0) {
            T(new H5(this, j4, str, zzcuVar));
        } else {
            c0658q3.a().r().a("Not bundling data. Service unavailable or out of date");
            c0658q3.C().d0(zzcuVar, new byte[0]);
        }
    }

    public final boolean C() {
        h();
        j();
        return !y() || this.f4245a.C().W() >= ((Integer) AbstractC0569f2.f4523K0.b(null)).intValue();
    }

    public final boolean D() {
        h();
        j();
        return !y() || this.f4245a.C().W() >= 241200;
    }

    public final /* synthetic */ void E() {
        InterfaceC0601j2 interfaceC0601j2 = this.f4484d;
        if (interfaceC0601j2 == null) {
            this.f4245a.a().o().a("Failed to send storage consent settings to service");
            return;
        }
        try {
            n7 n7VarV = V(false);
            AbstractC0940s.k(n7VarV);
            interfaceC0601j2.M(n7VarV);
            J();
        } catch (RemoteException e4) {
            this.f4245a.a().o().b("Failed to send storage consent settings to the service", e4);
        }
    }

    public final /* synthetic */ void F() {
        InterfaceC0601j2 interfaceC0601j2 = this.f4484d;
        if (interfaceC0601j2 == null) {
            this.f4245a.a().o().a("Failed to send Dma consent settings to service");
            return;
        }
        try {
            n7 n7VarV = V(false);
            AbstractC0940s.k(n7VarV);
            interfaceC0601j2.W(n7VarV);
            J();
        } catch (RemoteException e4) {
            this.f4245a.a().o().b("Failed to send Dma consent settings to the service", e4);
        }
    }

    public final /* synthetic */ void G(AtomicReference atomicReference, n7 n7Var, Bundle bundle) {
        InterfaceC0601j2 interfaceC0601j2;
        synchronized (atomicReference) {
            try {
                interfaceC0601j2 = this.f4484d;
            } catch (RemoteException e4) {
                this.f4245a.a().o().b("Failed to request trigger URIs; remote exception", e4);
                atomicReference.notifyAll();
            }
            if (interfaceC0601j2 == null) {
                this.f4245a.a().o().a("Failed to request trigger URIs; not connected to service");
                return;
            }
            AbstractC0940s.k(n7Var);
            interfaceC0601j2.p(n7Var, bundle, new BinderC0707w5(this, atomicReference));
            J();
        }
    }

    public final /* synthetic */ void H(AtomicReference atomicReference, n7 n7Var, I6 i6) {
        InterfaceC0601j2 interfaceC0601j2;
        synchronized (atomicReference) {
            try {
                interfaceC0601j2 = this.f4484d;
            } catch (RemoteException e4) {
                this.f4245a.a().o().b("[sgtm] Failed to get upload batches; remote exception", e4);
                atomicReference.notifyAll();
            }
            if (interfaceC0601j2 == null) {
                this.f4245a.a().o().a("[sgtm] Failed to get upload batches; not connected to service");
                return;
            }
            AbstractC0940s.k(n7Var);
            interfaceC0601j2.Y(n7Var, i6, new BinderC0715x5(this, atomicReference));
            J();
        }
    }

    public final /* synthetic */ void I(n7 n7Var, C0574g c0574g) {
        InterfaceC0601j2 interfaceC0601j2 = this.f4484d;
        if (interfaceC0601j2 == null) {
            this.f4245a.a().o().a("[sgtm] Discarding data. Failed to update batch upload status.");
            return;
        }
        try {
            interfaceC0601j2.I(n7Var, c0574g);
            J();
        } catch (RemoteException e4) {
            this.f4245a.a().o().c("[sgtm] Failed to update batch upload status, rowId, exception", Long.valueOf(c0574g.f4628a), e4);
        }
    }

    public final /* synthetic */ void K(ComponentName componentName) {
        h();
        if (this.f4484d != null) {
            this.f4484d = null;
            this.f4245a.a().w().b("Disconnected from device MeasurementService", componentName);
            h();
            w();
        }
    }

    public final /* synthetic */ Y5 M() {
        return this.f4483c;
    }

    public final /* synthetic */ InterfaceC0601j2 N() {
        return this.f4484d;
    }

    public final /* synthetic */ void O(InterfaceC0601j2 interfaceC0601j2) {
        this.f4484d = null;
    }

    public final /* synthetic */ ScheduledExecutorService P() {
        return this.f4487g;
    }

    public final /* synthetic */ void Q(ScheduledExecutorService scheduledExecutorService) {
        this.f4487g = scheduledExecutorService;
    }

    public final boolean R() {
        this.f4245a.c();
        return true;
    }

    public final void T(Runnable runnable) {
        h();
        if (W()) {
            runnable.run();
            return;
        }
        List list = this.f4489i;
        long size = list.size();
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.w();
        if (size >= 1000) {
            c0658q3.a().o().a("Discarding data. Max runnable queue size reached");
            return;
        }
        list.add(runnable);
        this.f4490j.b(ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS);
        w();
    }

    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public final void L() {
        h();
        A2 a2W = this.f4245a.a().w();
        List list = this.f4489i;
        a2W.b("Processing queued up service tasks", Integer.valueOf(list.size()));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e4) {
                this.f4245a.a().o().b("Task exception while flushing queue", e4);
            }
        }
        this.f4489i.clear();
        this.f4490j.d();
    }

    public final n7 V(boolean z4) {
        Pair pairB;
        C0658q3 c0658q3 = this.f4245a;
        c0658q3.c();
        C0657q2 c0657q2L = this.f4245a.L();
        String string = null;
        if (z4) {
            C0658q3 c0658q32 = c0658q3.a().f4245a;
            if (c0658q32.x().f4183e != null && (pairB = c0658q32.x().f4183e.b()) != null && pairB != Q2.f4180A) {
                String strValueOf = String.valueOf(pairB.second);
                String str = (String) pairB.first;
                StringBuilder sb = new StringBuilder(strValueOf.length() + 1 + String.valueOf(str).length());
                sb.append(strValueOf);
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(str);
                string = sb.toString();
            }
        }
        return c0657q2L.o(string);
    }

    public final boolean W() {
        h();
        j();
        return this.f4484d != null;
    }

    public final void X() {
        h();
        j();
        T(new J5(this, V(true)));
    }

    public final void Y(boolean z4) {
        h();
        j();
        if (C()) {
            T(new K5(this, V(false)));
        }
    }

    public final void Z(boolean z4) {
        h();
        j();
        T(new Runnable() { // from class: S1.d6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4453a.E();
            }
        });
    }

    public final void a0() {
        h();
        j();
        T(new Runnable() { // from class: S1.Z5
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4324a.F();
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b0(S1.InterfaceC0601j2 r59, A1.a r60, S1.n7 r61) {
        /*
            Method dump skipped, instruction units count: 551
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0565e6.b0(S1.j2, A1.a, S1.n7):void");
    }

    public final void c0(J j4, String str) {
        AbstractC0940s.k(j4);
        h();
        j();
        R();
        T(new L5(this, true, V(true), this.f4245a.E().p(j4), j4, str));
    }

    public final void d0(C0590i c0590i) {
        AbstractC0940s.k(c0590i);
        h();
        j();
        this.f4245a.c();
        T(new M5(this, true, V(true), this.f4245a.E().r(c0590i), new C0590i(c0590i), c0590i));
    }

    public final void e0(AtomicReference atomicReference, String str, String str2, String str3) {
        h();
        j();
        T(new N5(this, atomicReference, null, str2, str3, V(false)));
    }

    public final void f0(zzcu zzcuVar, String str, String str2) {
        h();
        j();
        T(new O5(this, str, str2, V(false), zzcuVar));
    }

    public final void g0(AtomicReference atomicReference, String str, String str2, String str3, boolean z4) {
        h();
        j();
        T(new P5(this, atomicReference, null, str2, str3, V(false), z4));
    }

    public final void h0(zzcu zzcuVar, String str, String str2, boolean z4) {
        h();
        j();
        T(new RunnableC0699v5(this, str, str2, V(false), z4, zzcuVar));
    }

    public final void i0(final AtomicReference atomicReference, final Bundle bundle) {
        h();
        j();
        final n7 n7VarV = V(false);
        T(new Runnable() { // from class: S1.a6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4338a.G(atomicReference, n7VarV, bundle);
            }
        });
    }

    public final void j0(final AtomicReference atomicReference, final I6 i6) {
        h();
        j();
        final n7 n7VarV = V(false);
        T(new Runnable() { // from class: S1.b6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4375a.H(atomicReference, n7VarV, i6);
            }
        });
    }

    public final void k0(final C0574g c0574g) {
        h();
        j();
        final n7 n7VarV = V(true);
        AbstractC0940s.k(n7VarV);
        T(new Runnable() { // from class: S1.c6
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.f4431a.I(n7VarV, c0574g);
            }
        });
    }

    public final C0646p l0() {
        h();
        j();
        InterfaceC0601j2 interfaceC0601j2 = this.f4484d;
        if (interfaceC0601j2 == null) {
            w();
            this.f4245a.a().v().a("Failed to get consents; not connected to service yet.");
            return null;
        }
        n7 n7VarV = V(false);
        AbstractC0940s.k(n7VarV);
        try {
            C0646p c0646pX = interfaceC0601j2.x(n7VarV);
            J();
            return c0646pX;
        } catch (RemoteException e4) {
            this.f4245a.a().o().b("Failed to get consents; remote exception", e4);
            return null;
        }
    }

    @Override // S1.AbstractC0593i2
    public final boolean m() {
        return false;
    }

    public final void o(h7 h7Var) {
        h();
        j();
        R();
        T(new RunnableC0723y5(this, V(true), this.f4245a.E().q(h7Var), h7Var));
    }

    public final void p() {
        h();
        j();
        n7 n7VarV = V(false);
        R();
        this.f4245a.E().o();
        T(new RunnableC0731z5(this, n7VarV));
    }

    public final void q(AtomicReference atomicReference) {
        h();
        j();
        T(new A5(this, atomicReference, V(false)));
    }

    public final void r(zzcu zzcuVar) {
        h();
        j();
        T(new B5(this, V(false), zzcuVar));
    }

    public final void s() {
        h();
        j();
        n7 n7VarV = V(true);
        R();
        this.f4245a.w().H(null, AbstractC0569f2.f4565d1);
        this.f4245a.E().u();
        T(new C5(this, n7VarV, true));
    }

    public final void t() {
        h();
        j();
        T(new D5(this, V(true)));
    }

    public final void u(C0628m5 c0628m5) {
        h();
        j();
        T(new F5(this, c0628m5));
    }

    public final void v(Bundle bundle) {
        h();
        j();
        H h4 = new H(bundle);
        R();
        T(new G5(this, true, V(false), this.f4245a.w().H(null, AbstractC0569f2.f4565d1) && this.f4245a.E().s(h4), h4, bundle));
    }

    public final void w() {
        h();
        j();
        if (W()) {
            return;
        }
        if (y()) {
            this.f4483c.e();
            return;
        }
        C0658q3 c0658q3 = this.f4245a;
        if (c0658q3.w().m()) {
            return;
        }
        c0658q3.c();
        List<ResolveInfo> listQueryIntentServices = c0658q3.e().getPackageManager().queryIntentServices(new Intent().setClassName(c0658q3.e(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            c0658q3.a().o().a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        Context contextE = c0658q3.e();
        c0658q3.c();
        intent.setComponent(new ComponentName(contextE, "com.google.android.gms.measurement.AppMeasurementService"));
        this.f4483c.a(intent);
    }

    public final Boolean x() {
        return this.f4485e;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y() {
        /*
            Method dump skipped, instruction units count: 311
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S1.C0565e6.y():boolean");
    }

    public final void z(InterfaceC0601j2 interfaceC0601j2) {
        h();
        AbstractC0940s.k(interfaceC0601j2);
        this.f4484d = interfaceC0601j2;
        J();
        L();
    }
}
