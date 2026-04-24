package S1;

import Q1.C0790b;
import Q1.C0792d;
import R1.a;
import R1.f;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.AbstractC1293m;
import com.google.android.gms.common.internal.AbstractC1294n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import l2.C2329m;
import w.C2882a;

/* JADX INFO: renamed from: S1.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0892y implements f.a, f.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.f f7448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0870b f7449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0884p f7450d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final N f7454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7455i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0873e f7459o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f7447a = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f7451e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f7452f = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f7456j = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0790b f7457m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f7458n = 0;

    public C0892y(C0873e c0873e, R1.e eVar) {
        this.f7459o = c0873e;
        a.f fVarH = eVar.h(c0873e.f7422n.getLooper(), this);
        this.f7448b = fVarH;
        this.f7449c = eVar.e();
        this.f7450d = new C0884p();
        this.f7453g = eVar.g();
        if (fVarH.requiresSignIn()) {
            this.f7454h = eVar.i(c0873e.f7413e, c0873e.f7422n);
        } else {
            this.f7454h = null;
        }
    }

    public static /* bridge */ /* synthetic */ void y(C0892y c0892y, A a8) {
        if (c0892y.f7456j.contains(a8) && !c0892y.f7455i) {
            if (c0892y.f7448b.isConnected()) {
                c0892y.g();
            } else {
                c0892y.B();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void z(C0892y c0892y, A a8) {
        C0792d[] c0792dArrG;
        if (c0892y.f7456j.remove(a8)) {
            c0892y.f7459o.f7422n.removeMessages(15, a8);
            c0892y.f7459o.f7422n.removeMessages(16, a8);
            C0792d c0792d = a8.f7335b;
            ArrayList arrayList = new ArrayList(c0892y.f7447a.size());
            for (U u8 : c0892y.f7447a) {
                if ((u8 instanceof G) && (c0792dArrG = ((G) u8).g(c0892y)) != null && W1.b.b(c0792dArrG, c0792d)) {
                    arrayList.add(u8);
                }
            }
            int size = arrayList.size();
            for (int i8 = 0; i8 < size; i8++) {
                U u9 = (U) arrayList.get(i8);
                c0892y.f7447a.remove(u9);
                u9.b(new R1.h(c0792d));
            }
        }
    }

    public final void A() {
        AbstractC1294n.c(this.f7459o.f7422n);
        this.f7457m = null;
    }

    public final void B() {
        C0790b c0790b;
        AbstractC1294n.c(this.f7459o.f7422n);
        if (this.f7448b.isConnected() || this.f7448b.isConnecting()) {
            return;
        }
        try {
            C0873e c0873e = this.f7459o;
            int iB = c0873e.f7415g.b(c0873e.f7413e, this.f7448b);
            if (iB != 0) {
                C0790b c0790b2 = new C0790b(iB, null);
                Log.w("GoogleApiManager", "The service for " + this.f7448b.getClass().getName() + " is not available: " + c0790b2.toString());
                E(c0790b2, null);
                return;
            }
            C0873e c0873e2 = this.f7459o;
            a.f fVar = this.f7448b;
            C c8 = new C(c0873e2, fVar, this.f7449c);
            if (fVar.requiresSignIn()) {
                ((N) AbstractC1294n.j(this.f7454h)).G(c8);
            }
            try {
                this.f7448b.connect(c8);
                return;
            } catch (SecurityException e8) {
                e = e8;
                c0790b = new C0790b(10);
            }
        } catch (IllegalStateException e9) {
            e = e9;
            c0790b = new C0790b(10);
        }
        E(c0790b, e);
    }

    public final void C(U u8) {
        AbstractC1294n.c(this.f7459o.f7422n);
        if (this.f7448b.isConnected()) {
            if (m(u8)) {
                j();
                return;
            } else {
                this.f7447a.add(u8);
                return;
            }
        }
        this.f7447a.add(u8);
        C0790b c0790b = this.f7457m;
        if (c0790b == null || !c0790b.f()) {
            B();
        } else {
            E(this.f7457m, null);
        }
    }

    public final void D() {
        this.f7458n++;
    }

    public final void E(C0790b c0790b, Exception exc) {
        AbstractC1294n.c(this.f7459o.f7422n);
        N n8 = this.f7454h;
        if (n8 != null) {
            n8.H();
        }
        A();
        this.f7459o.f7415g.c();
        d(c0790b);
        if ((this.f7448b instanceof U1.e) && c0790b.a() != 24) {
            this.f7459o.f7410b = true;
            C0873e c0873e = this.f7459o;
            c0873e.f7422n.sendMessageDelayed(c0873e.f7422n.obtainMessage(19), 300000L);
        }
        if (c0790b.a() == 4) {
            e(C0873e.f7406q);
            return;
        }
        if (this.f7447a.isEmpty()) {
            this.f7457m = c0790b;
            return;
        }
        if (exc != null) {
            AbstractC1294n.c(this.f7459o.f7422n);
            f(null, exc, false);
            return;
        }
        if (!this.f7459o.f7423o) {
            e(C0873e.f(this.f7449c, c0790b));
            return;
        }
        f(C0873e.f(this.f7449c, c0790b), null, true);
        if (this.f7447a.isEmpty() || n(c0790b) || this.f7459o.e(c0790b, this.f7453g)) {
            return;
        }
        if (c0790b.a() == 18) {
            this.f7455i = true;
        }
        if (!this.f7455i) {
            e(C0873e.f(this.f7449c, c0790b));
            return;
        }
        C0873e c0873e2 = this.f7459o;
        c0873e2.f7422n.sendMessageDelayed(Message.obtain(c0873e2.f7422n, 9, this.f7449c), 5000L);
    }

    public final void F(C0790b c0790b) {
        AbstractC1294n.c(this.f7459o.f7422n);
        a.f fVar = this.f7448b;
        fVar.disconnect("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(c0790b));
        E(c0790b, null);
    }

    public final void G() {
        AbstractC1294n.c(this.f7459o.f7422n);
        if (this.f7455i) {
            B();
        }
    }

    public final void H() {
        AbstractC1294n.c(this.f7459o.f7422n);
        e(C0873e.f7405p);
        this.f7450d.d();
        for (AbstractC0877i abstractC0877i : (AbstractC0877i[]) this.f7452f.keySet().toArray(new AbstractC0877i[0])) {
            C(new T(null, new C2329m()));
        }
        d(new C0790b(4));
        if (this.f7448b.isConnected()) {
            this.f7448b.onUserSignOut(new C0891x(this));
        }
    }

    public final void I() {
        AbstractC1294n.c(this.f7459o.f7422n);
        if (this.f7455i) {
            l();
            C0873e c0873e = this.f7459o;
            e(c0873e.f7414f.g(c0873e.f7413e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f7448b.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean a() {
        return this.f7448b.requiresSignIn();
    }

    public final boolean b() {
        return o(true);
    }

    public final C0792d c(C0792d[] c0792dArr) {
        if (c0792dArr != null && c0792dArr.length != 0) {
            C0792d[] availableFeatures = this.f7448b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new C0792d[0];
            }
            C2882a c2882a = new C2882a(availableFeatures.length);
            for (C0792d c0792d : availableFeatures) {
                c2882a.put(c0792d.getName(), Long.valueOf(c0792d.a()));
            }
            for (C0792d c0792d2 : c0792dArr) {
                Long l8 = (Long) c2882a.get(c0792d2.getName());
                if (l8 == null || l8.longValue() < c0792d2.a()) {
                    return c0792d2;
                }
            }
        }
        return null;
    }

    public final void d(C0790b c0790b) {
        Iterator it = this.f7451e.iterator();
        if (!it.hasNext()) {
            this.f7451e.clear();
            return;
        }
        android.support.v4.media.session.b.a(it.next());
        if (AbstractC1293m.a(c0790b, C0790b.f6678e)) {
            this.f7448b.getEndpointPackageName();
        }
        throw null;
    }

    public final void e(Status status) {
        AbstractC1294n.c(this.f7459o.f7422n);
        f(status, null, false);
    }

    public final void f(Status status, Exception exc, boolean z7) {
        AbstractC1294n.c(this.f7459o.f7422n);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f7447a.iterator();
        while (it.hasNext()) {
            U u8 = (U) it.next();
            if (!z7 || u8.f7375a == 2) {
                if (status != null) {
                    u8.a(status);
                } else {
                    u8.b(exc);
                }
                it.remove();
            }
        }
    }

    public final void g() {
        ArrayList arrayList = new ArrayList(this.f7447a);
        int size = arrayList.size();
        for (int i8 = 0; i8 < size; i8++) {
            U u8 = (U) arrayList.get(i8);
            if (!this.f7448b.isConnected()) {
                return;
            }
            if (m(u8)) {
                this.f7447a.remove(u8);
            }
        }
    }

    public final void h() {
        A();
        d(C0790b.f6678e);
        l();
        Iterator it = this.f7452f.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
        g();
        j();
    }

    public final void i(int i8) {
        A();
        this.f7455i = true;
        this.f7450d.c(i8, this.f7448b.getLastDisconnectMessage());
        C0870b c0870b = this.f7449c;
        C0873e c0873e = this.f7459o;
        c0873e.f7422n.sendMessageDelayed(Message.obtain(c0873e.f7422n, 9, c0870b), 5000L);
        C0870b c0870b2 = this.f7449c;
        C0873e c0873e2 = this.f7459o;
        c0873e2.f7422n.sendMessageDelayed(Message.obtain(c0873e2.f7422n, 11, c0870b2), 120000L);
        this.f7459o.f7415g.c();
        Iterator it = this.f7452f.values().iterator();
        if (it.hasNext()) {
            android.support.v4.media.session.b.a(it.next());
            throw null;
        }
    }

    public final void j() {
        this.f7459o.f7422n.removeMessages(12, this.f7449c);
        C0870b c0870b = this.f7449c;
        C0873e c0873e = this.f7459o;
        c0873e.f7422n.sendMessageDelayed(c0873e.f7422n.obtainMessage(12, c0870b), this.f7459o.f7409a);
    }

    public final void k(U u8) {
        u8.d(this.f7450d, a());
        try {
            u8.c(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f7448b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    public final void l() {
        if (this.f7455i) {
            C0873e c0873e = this.f7459o;
            c0873e.f7422n.removeMessages(11, this.f7449c);
            C0873e c0873e2 = this.f7459o;
            c0873e2.f7422n.removeMessages(9, this.f7449c);
            this.f7455i = false;
        }
    }

    public final boolean m(U u8) {
        if (!(u8 instanceof G)) {
            k(u8);
            return true;
        }
        G g8 = (G) u8;
        C0792d c0792dC = c(g8.g(this));
        if (c0792dC == null) {
            k(u8);
            return true;
        }
        Log.w("GoogleApiManager", this.f7448b.getClass().getName() + " could not execute call because it requires feature (" + c0792dC.getName() + ", " + c0792dC.a() + ").");
        if (!this.f7459o.f7423o || !g8.f(this)) {
            g8.b(new R1.h(c0792dC));
            return true;
        }
        A a8 = new A(this.f7449c, c0792dC, null);
        int iIndexOf = this.f7456j.indexOf(a8);
        if (iIndexOf >= 0) {
            A a9 = (A) this.f7456j.get(iIndexOf);
            this.f7459o.f7422n.removeMessages(15, a9);
            C0873e c0873e = this.f7459o;
            c0873e.f7422n.sendMessageDelayed(Message.obtain(c0873e.f7422n, 15, a9), 5000L);
            return false;
        }
        this.f7456j.add(a8);
        C0873e c0873e2 = this.f7459o;
        c0873e2.f7422n.sendMessageDelayed(Message.obtain(c0873e2.f7422n, 15, a8), 5000L);
        C0873e c0873e3 = this.f7459o;
        c0873e3.f7422n.sendMessageDelayed(Message.obtain(c0873e3.f7422n, 16, a8), 120000L);
        C0790b c0790b = new C0790b(2, null);
        if (n(c0790b)) {
            return false;
        }
        this.f7459o.e(c0790b, this.f7453g);
        return false;
    }

    public final boolean n(C0790b c0790b) {
        synchronized (C0873e.f7407r) {
            try {
                C0873e c0873e = this.f7459o;
                if (c0873e.f7419k == null || !c0873e.f7420l.contains(this.f7449c)) {
                    return false;
                }
                this.f7459o.f7419k.s(c0790b, this.f7453g);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean o(boolean z7) {
        AbstractC1294n.c(this.f7459o.f7422n);
        if (!this.f7448b.isConnected() || !this.f7452f.isEmpty()) {
            return false;
        }
        if (!this.f7450d.e()) {
            this.f7448b.disconnect("Timing out service connection.");
            return true;
        }
        if (!z7) {
            return false;
        }
        j();
        return false;
    }

    @Override // S1.InterfaceC0872d
    public final void onConnected(Bundle bundle) {
        if (Looper.myLooper() == this.f7459o.f7422n.getLooper()) {
            h();
        } else {
            this.f7459o.f7422n.post(new RunnableC0888u(this));
        }
    }

    @Override // S1.InterfaceC0879k
    public final void onConnectionFailed(C0790b c0790b) {
        E(c0790b, null);
    }

    @Override // S1.InterfaceC0872d
    public final void onConnectionSuspended(int i8) {
        if (Looper.myLooper() == this.f7459o.f7422n.getLooper()) {
            i(i8);
        } else {
            this.f7459o.f7422n.post(new RunnableC0889v(this, i8));
        }
    }

    public final int p() {
        return this.f7453g;
    }

    public final int q() {
        return this.f7458n;
    }

    public final a.f s() {
        return this.f7448b;
    }

    public final Map u() {
        return this.f7452f;
    }
}
