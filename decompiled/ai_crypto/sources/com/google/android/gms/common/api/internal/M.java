package com.google.android.gms.common.api.internal;

import P1.C0648b;
import P1.C0650d;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.C1175l;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import u.C2736a;

/* JADX INFO: loaded from: classes.dex */
public final class M implements f.b, f.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.f f10894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1165b f10895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C f10896d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f10899g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final f0 f10900h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10901i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C1170g f10905o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f10893a = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f10897e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f10898f = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f10902j = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C0648b f10903m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10904n = 0;

    public M(C1170g c1170g, com.google.android.gms.common.api.e eVar) {
        this.f10905o = c1170g;
        a.f fVarZab = eVar.zab(c1170g.f10971n.getLooper(), this);
        this.f10894b = fVarZab;
        this.f10895c = eVar.getApiKey();
        this.f10896d = new C();
        this.f10899g = eVar.zaa();
        if (fVarZab.requiresSignIn()) {
            this.f10900h = eVar.zac(c1170g.f10962e, c1170g.f10971n);
        } else {
            this.f10900h = null;
        }
    }

    public static /* bridge */ /* synthetic */ void B(M m7, O o7) {
        if (m7.f10902j.contains(o7) && !m7.f10901i) {
            if (m7.f10894b.isConnected()) {
                m7.j();
            } else {
                m7.E();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void C(M m7, O o7) {
        C0650d[] c0650dArrG;
        if (m7.f10902j.remove(o7)) {
            m7.f10905o.f10971n.removeMessages(15, o7);
            m7.f10905o.f10971n.removeMessages(16, o7);
            C0650d c0650d = o7.f10907b;
            ArrayList arrayList = new ArrayList(m7.f10893a.size());
            for (p0 p0Var : m7.f10893a) {
                if ((p0Var instanceof W) && (c0650dArrG = ((W) p0Var).g(m7)) != null && W1.b.b(c0650dArrG, c0650d)) {
                    arrayList.add(p0Var);
                }
            }
            int size = arrayList.size();
            for (int i7 = 0; i7 < size; i7++) {
                p0 p0Var2 = (p0) arrayList.get(i7);
                m7.f10893a.remove(p0Var2);
                p0Var2.b(new com.google.android.gms.common.api.o(c0650d));
            }
        }
    }

    public final void D() {
        AbstractC1207s.d(this.f10905o.f10971n);
        this.f10903m = null;
    }

    public final void E() {
        AbstractC1207s.d(this.f10905o.f10971n);
        if (this.f10894b.isConnected() || this.f10894b.isConnecting()) {
            return;
        }
        try {
            C1170g c1170g = this.f10905o;
            int iB = c1170g.f10964g.b(c1170g.f10962e, this.f10894b);
            if (iB == 0) {
                C1170g c1170g2 = this.f10905o;
                a.f fVar = this.f10894b;
                Q q7 = new Q(c1170g2, fVar, this.f10895c);
                if (fVar.requiresSignIn()) {
                    ((f0) AbstractC1207s.k(this.f10900h)).c0(q7);
                }
                try {
                    this.f10894b.connect(q7);
                    return;
                } catch (SecurityException e7) {
                    H(new C0648b(10), e7);
                    return;
                }
            }
            C0648b c0648b = new C0648b(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.f10894b.getClass().getName() + " is not available: " + c0648b.toString());
            H(c0648b, null);
        } catch (IllegalStateException e8) {
            H(new C0648b(10), e8);
        }
    }

    public final void F(p0 p0Var) {
        AbstractC1207s.d(this.f10905o.f10971n);
        if (this.f10894b.isConnected()) {
            if (p(p0Var)) {
                m();
                return;
            } else {
                this.f10893a.add(p0Var);
                return;
            }
        }
        this.f10893a.add(p0Var);
        C0648b c0648b = this.f10903m;
        if (c0648b == null || !c0648b.D()) {
            E();
        } else {
            H(this.f10903m, null);
        }
    }

    public final void G() {
        this.f10904n++;
    }

    public final void H(C0648b c0648b, Exception exc) {
        AbstractC1207s.d(this.f10905o.f10971n);
        f0 f0Var = this.f10900h;
        if (f0Var != null) {
            f0Var.d0();
        }
        D();
        this.f10905o.f10964g.c();
        g(c0648b);
        if ((this.f10894b instanceof R1.e) && c0648b.A() != 24) {
            this.f10905o.f10959b = true;
            C1170g c1170g = this.f10905o;
            c1170g.f10971n.sendMessageDelayed(c1170g.f10971n.obtainMessage(19), 300000L);
        }
        if (c0648b.A() == 4) {
            h(C1170g.f10955q);
            return;
        }
        if (this.f10893a.isEmpty()) {
            this.f10903m = c0648b;
            return;
        }
        if (exc != null) {
            AbstractC1207s.d(this.f10905o.f10971n);
            i(null, exc, false);
            return;
        }
        if (!this.f10905o.f10972o) {
            h(C1170g.g(this.f10895c, c0648b));
            return;
        }
        i(C1170g.g(this.f10895c, c0648b), null, true);
        if (this.f10893a.isEmpty() || q(c0648b) || this.f10905o.f(c0648b, this.f10899g)) {
            return;
        }
        if (c0648b.A() == 18) {
            this.f10901i = true;
        }
        if (!this.f10901i) {
            h(C1170g.g(this.f10895c, c0648b));
            return;
        }
        C1170g c1170g2 = this.f10905o;
        c1170g2.f10971n.sendMessageDelayed(Message.obtain(c1170g2.f10971n, 9, this.f10895c), 5000L);
    }

    public final void I(C0648b c0648b) {
        AbstractC1207s.d(this.f10905o.f10971n);
        a.f fVar = this.f10894b;
        fVar.disconnect("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(c0648b));
        H(c0648b, null);
    }

    public final void J() {
        AbstractC1207s.d(this.f10905o.f10971n);
        if (this.f10901i) {
            E();
        }
    }

    public final void K() {
        AbstractC1207s.d(this.f10905o.f10971n);
        h(C1170g.f10954p);
        this.f10896d.f();
        for (C1175l.a aVar : (C1175l.a[]) this.f10898f.keySet().toArray(new C1175l.a[0])) {
            F(new o0(aVar, new TaskCompletionSource()));
        }
        g(new C0648b(4));
        if (this.f10894b.isConnected()) {
            this.f10894b.onUserSignOut(new L(this));
        }
    }

    public final void L() {
        AbstractC1207s.d(this.f10905o.f10971n);
        if (this.f10901i) {
            o();
            C1170g c1170g = this.f10905o;
            h(c1170g.f10963f.g(c1170g.f10962e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f10894b.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean a() {
        return this.f10894b.requiresSignIn();
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1169f
    public final void b(int i7) {
        if (Looper.myLooper() == this.f10905o.f10971n.getLooper()) {
            l(i7);
        } else {
            this.f10905o.f10971n.post(new J(this, i7));
        }
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1178o
    public final void c(C0648b c0648b) {
        H(c0648b, null);
    }

    public final boolean d() {
        return r(true);
    }

    public final C0650d e(C0650d[] c0650dArr) {
        if (c0650dArr != null && c0650dArr.length != 0) {
            C0650d[] availableFeatures = this.f10894b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new C0650d[0];
            }
            C2736a c2736a = new C2736a(availableFeatures.length);
            for (C0650d c0650d : availableFeatures) {
                c2736a.put(c0650d.getName(), Long.valueOf(c0650d.A()));
            }
            for (C0650d c0650d2 : c0650dArr) {
                Long l7 = (Long) c2736a.get(c0650d2.getName());
                if (l7 == null || l7.longValue() < c0650d2.A()) {
                    return c0650d2;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC1169f
    public final void f(Bundle bundle) {
        if (Looper.myLooper() == this.f10905o.f10971n.getLooper()) {
            k();
        } else {
            this.f10905o.f10971n.post(new I(this));
        }
    }

    public final void g(C0648b c0648b) {
        Iterator it = this.f10897e.iterator();
        if (!it.hasNext()) {
            this.f10897e.clear();
            return;
        }
        android.support.v4.media.session.b.a(it.next());
        if (AbstractC1206q.b(c0648b, C0648b.f4284e)) {
            this.f10894b.getEndpointPackageName();
        }
        throw null;
    }

    public final void h(Status status) {
        AbstractC1207s.d(this.f10905o.f10971n);
        i(status, null, false);
    }

    public final void i(Status status, Exception exc, boolean z7) {
        AbstractC1207s.d(this.f10905o.f10971n);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f10893a.iterator();
        while (it.hasNext()) {
            p0 p0Var = (p0) it.next();
            if (!z7 || p0Var.f10995a == 2) {
                if (status != null) {
                    p0Var.a(status);
                } else {
                    p0Var.b(exc);
                }
                it.remove();
            }
        }
    }

    public final void j() {
        ArrayList arrayList = new ArrayList(this.f10893a);
        int size = arrayList.size();
        for (int i7 = 0; i7 < size; i7++) {
            p0 p0Var = (p0) arrayList.get(i7);
            if (!this.f10894b.isConnected()) {
                return;
            }
            if (p(p0Var)) {
                this.f10893a.remove(p0Var);
            }
        }
    }

    public final void k() {
        D();
        g(C0648b.f4284e);
        o();
        Iterator it = this.f10898f.values().iterator();
        if (it.hasNext()) {
            ((b0) it.next()).getClass();
            throw null;
        }
        j();
        m();
    }

    public final void l(int i7) {
        D();
        this.f10901i = true;
        this.f10896d.e(i7, this.f10894b.getLastDisconnectMessage());
        C1165b c1165b = this.f10895c;
        C1170g c1170g = this.f10905o;
        c1170g.f10971n.sendMessageDelayed(Message.obtain(c1170g.f10971n, 9, c1165b), 5000L);
        C1165b c1165b2 = this.f10895c;
        C1170g c1170g2 = this.f10905o;
        c1170g2.f10971n.sendMessageDelayed(Message.obtain(c1170g2.f10971n, 11, c1165b2), 120000L);
        this.f10905o.f10964g.c();
        Iterator it = this.f10898f.values().iterator();
        while (it.hasNext()) {
            ((b0) it.next()).f10937a.run();
        }
    }

    public final void m() {
        this.f10905o.f10971n.removeMessages(12, this.f10895c);
        C1165b c1165b = this.f10895c;
        C1170g c1170g = this.f10905o;
        c1170g.f10971n.sendMessageDelayed(c1170g.f10971n.obtainMessage(12, c1165b), this.f10905o.f10958a);
    }

    public final void n(p0 p0Var) {
        p0Var.d(this.f10896d, a());
        try {
            p0Var.c(this);
        } catch (DeadObjectException unused) {
            b(1);
            this.f10894b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    public final void o() {
        if (this.f10901i) {
            C1170g c1170g = this.f10905o;
            c1170g.f10971n.removeMessages(11, this.f10895c);
            C1170g c1170g2 = this.f10905o;
            c1170g2.f10971n.removeMessages(9, this.f10895c);
            this.f10901i = false;
        }
    }

    public final boolean p(p0 p0Var) {
        if (!(p0Var instanceof W)) {
            n(p0Var);
            return true;
        }
        W w7 = (W) p0Var;
        C0650d c0650dE = e(w7.g(this));
        if (c0650dE == null) {
            n(p0Var);
            return true;
        }
        Log.w("GoogleApiManager", this.f10894b.getClass().getName() + " could not execute call because it requires feature (" + c0650dE.getName() + ", " + c0650dE.A() + ").");
        if (!this.f10905o.f10972o || !w7.f(this)) {
            w7.b(new com.google.android.gms.common.api.o(c0650dE));
            return true;
        }
        O o7 = new O(this.f10895c, c0650dE, null);
        int iIndexOf = this.f10902j.indexOf(o7);
        if (iIndexOf >= 0) {
            O o8 = (O) this.f10902j.get(iIndexOf);
            this.f10905o.f10971n.removeMessages(15, o8);
            C1170g c1170g = this.f10905o;
            c1170g.f10971n.sendMessageDelayed(Message.obtain(c1170g.f10971n, 15, o8), 5000L);
            return false;
        }
        this.f10902j.add(o7);
        C1170g c1170g2 = this.f10905o;
        c1170g2.f10971n.sendMessageDelayed(Message.obtain(c1170g2.f10971n, 15, o7), 5000L);
        C1170g c1170g3 = this.f10905o;
        c1170g3.f10971n.sendMessageDelayed(Message.obtain(c1170g3.f10971n, 16, o7), 120000L);
        C0648b c0648b = new C0648b(2, null);
        if (q(c0648b)) {
            return false;
        }
        this.f10905o.f(c0648b, this.f10899g);
        return false;
    }

    public final boolean q(C0648b c0648b) {
        synchronized (C1170g.f10956r) {
            try {
                C1170g c1170g = this.f10905o;
                if (c1170g.f10968k == null || !c1170g.f10969l.contains(this.f10895c)) {
                    return false;
                }
                this.f10905o.f10968k.h(c0648b, this.f10899g);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean r(boolean z7) {
        AbstractC1207s.d(this.f10905o.f10971n);
        if (!this.f10894b.isConnected() || !this.f10898f.isEmpty()) {
            return false;
        }
        if (!this.f10896d.g()) {
            this.f10894b.disconnect("Timing out service connection.");
            return true;
        }
        if (!z7) {
            return false;
        }
        m();
        return false;
    }

    public final int s() {
        return this.f10899g;
    }

    public final int t() {
        return this.f10904n;
    }

    public final a.f v() {
        return this.f10894b;
    }

    public final Map x() {
        return this.f10898f;
    }
}
