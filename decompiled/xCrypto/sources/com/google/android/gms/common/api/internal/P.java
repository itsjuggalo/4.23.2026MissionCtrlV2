package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.C0909m;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
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
import u.C1853a;
import z1.C1984b;
import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class P implements f.b, f.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.f f9719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0898c f9720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final E f9721d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f9724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i0 f9725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9726i;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ C0904h f9730o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f9718a = new LinkedList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f9722e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f9723f = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f9727j = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public C1984b f9728m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9729n = 0;

    public P(C0904h c0904h, com.google.android.gms.common.api.e eVar) {
        this.f9730o = c0904h;
        a.f fVarZab = eVar.zab(c0904h.f9788n.getLooper(), this);
        this.f9719b = fVarZab;
        this.f9720c = eVar.getApiKey();
        this.f9721d = new E();
        this.f9724g = eVar.zaa();
        if (fVarZab.requiresSignIn()) {
            this.f9725h = eVar.zac(c0904h.f9779e, c0904h.f9788n);
        } else {
            this.f9725h = null;
        }
    }

    public static /* bridge */ /* synthetic */ void B(P p4, S s4) {
        if (p4.f9727j.contains(s4) && !p4.f9726i) {
            if (p4.f9719b.isConnected()) {
                p4.j();
            } else {
                p4.E();
            }
        }
    }

    public static /* bridge */ /* synthetic */ void C(P p4, S s4) {
        C1986d[] c1986dArrG;
        if (p4.f9727j.remove(s4)) {
            p4.f9730o.f9788n.removeMessages(15, s4);
            p4.f9730o.f9788n.removeMessages(16, s4);
            C1986d c1986d = s4.f9732b;
            ArrayList arrayList = new ArrayList(p4.f9718a.size());
            for (s0 s0Var : p4.f9718a) {
                if ((s0Var instanceof Z) && (c1986dArrG = ((Z) s0Var).g(p4)) != null && G1.b.b(c1986dArrG, c1986d)) {
                    arrayList.add(s0Var);
                }
            }
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                s0 s0Var2 = (s0) arrayList.get(i4);
                p4.f9718a.remove(s0Var2);
                s0Var2.b(new com.google.android.gms.common.api.o(c1986d));
            }
        }
    }

    public final void D() {
        AbstractC0940s.d(this.f9730o.f9788n);
        this.f9728m = null;
    }

    public final void E() {
        AbstractC0940s.d(this.f9730o.f9788n);
        if (this.f9719b.isConnected() || this.f9719b.isConnecting()) {
            return;
        }
        try {
            C0904h c0904h = this.f9730o;
            int iB = c0904h.f9781g.b(c0904h.f9779e, this.f9719b);
            if (iB == 0) {
                C0904h c0904h2 = this.f9730o;
                a.f fVar = this.f9719b;
                U u4 = new U(c0904h2, fVar, this.f9720c);
                if (fVar.requiresSignIn()) {
                    ((i0) AbstractC0940s.k(this.f9725h)).c0(u4);
                }
                try {
                    this.f9719b.connect(u4);
                    return;
                } catch (SecurityException e4) {
                    H(new C1984b(10), e4);
                    return;
                }
            }
            C1984b c1984b = new C1984b(iB, null);
            Log.w("GoogleApiManager", "The service for " + this.f9719b.getClass().getName() + " is not available: " + c1984b.toString());
            H(c1984b, null);
        } catch (IllegalStateException e5) {
            H(new C1984b(10), e5);
        }
    }

    public final void F(s0 s0Var) {
        AbstractC0940s.d(this.f9730o.f9788n);
        if (this.f9719b.isConnected()) {
            if (p(s0Var)) {
                m();
                return;
            } else {
                this.f9718a.add(s0Var);
                return;
            }
        }
        this.f9718a.add(s0Var);
        C1984b c1984b = this.f9728m;
        if (c1984b == null || !c1984b.m()) {
            E();
        } else {
            H(this.f9728m, null);
        }
    }

    public final void G() {
        this.f9729n++;
    }

    public final void H(C1984b c1984b, Exception exc) {
        AbstractC0940s.d(this.f9730o.f9788n);
        i0 i0Var = this.f9725h;
        if (i0Var != null) {
            i0Var.d0();
        }
        D();
        this.f9730o.f9781g.c();
        g(c1984b);
        if ((this.f9719b instanceof B1.e) && c1984b.i() != 24) {
            this.f9730o.f9776b = true;
            C0904h c0904h = this.f9730o;
            c0904h.f9788n.sendMessageDelayed(c0904h.f9788n.obtainMessage(19), 300000L);
        }
        if (c1984b.i() == 4) {
            h(C0904h.f9772q);
            return;
        }
        if (this.f9718a.isEmpty()) {
            this.f9728m = c1984b;
            return;
        }
        if (exc != null) {
            AbstractC0940s.d(this.f9730o.f9788n);
            i(null, exc, false);
            return;
        }
        if (!this.f9730o.f9789o) {
            h(C0904h.g(this.f9720c, c1984b));
            return;
        }
        i(C0904h.g(this.f9720c, c1984b), null, true);
        if (this.f9718a.isEmpty() || q(c1984b) || this.f9730o.f(c1984b, this.f9724g)) {
            return;
        }
        if (c1984b.i() == 18) {
            this.f9726i = true;
        }
        if (!this.f9726i) {
            h(C0904h.g(this.f9720c, c1984b));
            return;
        }
        C0904h c0904h2 = this.f9730o;
        c0904h2.f9788n.sendMessageDelayed(Message.obtain(c0904h2.f9788n, 9, this.f9720c), 5000L);
    }

    public final void I(C1984b c1984b) {
        AbstractC0940s.d(this.f9730o.f9788n);
        a.f fVar = this.f9719b;
        fVar.disconnect("onSignInFailed for " + fVar.getClass().getName() + " with " + String.valueOf(c1984b));
        H(c1984b, null);
    }

    public final void J() {
        AbstractC0940s.d(this.f9730o.f9788n);
        if (this.f9726i) {
            E();
        }
    }

    public final void K() {
        AbstractC0940s.d(this.f9730o.f9788n);
        h(C0904h.f9771p);
        this.f9721d.f();
        for (C0909m.a aVar : (C0909m.a[]) this.f9723f.keySet().toArray(new C0909m.a[0])) {
            F(new r0(aVar, new TaskCompletionSource()));
        }
        g(new C1984b(4));
        if (this.f9719b.isConnected()) {
            this.f9719b.onUserSignOut(new O(this));
        }
    }

    public final void L() {
        AbstractC0940s.d(this.f9730o.f9788n);
        if (this.f9726i) {
            o();
            C0904h c0904h = this.f9730o;
            h(c0904h.f9780f.g(c0904h.f9779e) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f9719b.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean a() {
        return this.f9719b.requiresSignIn();
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0912p
    public final void b(C1984b c1984b) {
        H(c1984b, null);
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0903g
    public final void c(int i4) {
        if (Looper.myLooper() == this.f9730o.f9788n.getLooper()) {
            l(i4);
        } else {
            this.f9730o.f9788n.post(new M(this, i4));
        }
    }

    public final boolean d() {
        return r(true);
    }

    public final C1986d e(C1986d[] c1986dArr) {
        if (c1986dArr != null && c1986dArr.length != 0) {
            C1986d[] availableFeatures = this.f9719b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new C1986d[0];
            }
            C1853a c1853a = new C1853a(availableFeatures.length);
            for (C1986d c1986d : availableFeatures) {
                c1853a.put(c1986d.getName(), Long.valueOf(c1986d.i()));
            }
            for (C1986d c1986d2 : c1986dArr) {
                Long l4 = (Long) c1853a.get(c1986d2.getName());
                if (l4 == null || l4.longValue() < c1986d2.i()) {
                    return c1986d2;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.InterfaceC0903g
    public final void f(Bundle bundle) {
        if (Looper.myLooper() == this.f9730o.f9788n.getLooper()) {
            k();
        } else {
            this.f9730o.f9788n.post(new L(this));
        }
    }

    public final void g(C1984b c1984b) {
        Iterator it = this.f9722e.iterator();
        if (!it.hasNext()) {
            this.f9722e.clear();
            return;
        }
        android.support.v4.media.session.b.a(it.next());
        if (AbstractC0939q.b(c1984b, C1984b.f16081e)) {
            this.f9719b.getEndpointPackageName();
        }
        throw null;
    }

    public final void h(Status status) {
        AbstractC0940s.d(this.f9730o.f9788n);
        i(status, null, false);
    }

    public final void i(Status status, Exception exc, boolean z4) {
        AbstractC0940s.d(this.f9730o.f9788n);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f9718a.iterator();
        while (it.hasNext()) {
            s0 s0Var = (s0) it.next();
            if (!z4 || s0Var.f9820a == 2) {
                if (status != null) {
                    s0Var.a(status);
                } else {
                    s0Var.b(exc);
                }
                it.remove();
            }
        }
    }

    public final void j() {
        ArrayList arrayList = new ArrayList(this.f9718a);
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            s0 s0Var = (s0) arrayList.get(i4);
            if (!this.f9719b.isConnected()) {
                return;
            }
            if (p(s0Var)) {
                this.f9718a.remove(s0Var);
            }
        }
    }

    public final void k() {
        D();
        g(C1984b.f16081e);
        o();
        Iterator it = this.f9723f.values().iterator();
        if (it.hasNext()) {
            ((e0) it.next()).getClass();
            throw null;
        }
        j();
        m();
    }

    public final void l(int i4) {
        D();
        this.f9726i = true;
        this.f9721d.e(i4, this.f9719b.getLastDisconnectMessage());
        C0898c c0898c = this.f9720c;
        C0904h c0904h = this.f9730o;
        c0904h.f9788n.sendMessageDelayed(Message.obtain(c0904h.f9788n, 9, c0898c), 5000L);
        C0898c c0898c2 = this.f9720c;
        C0904h c0904h2 = this.f9730o;
        c0904h2.f9788n.sendMessageDelayed(Message.obtain(c0904h2.f9788n, 11, c0898c2), 120000L);
        this.f9730o.f9781g.c();
        Iterator it = this.f9723f.values().iterator();
        while (it.hasNext()) {
            ((e0) it.next()).f9767a.run();
        }
    }

    public final void m() {
        this.f9730o.f9788n.removeMessages(12, this.f9720c);
        C0898c c0898c = this.f9720c;
        C0904h c0904h = this.f9730o;
        c0904h.f9788n.sendMessageDelayed(c0904h.f9788n.obtainMessage(12, c0898c), this.f9730o.f9775a);
    }

    public final void n(s0 s0Var) {
        s0Var.d(this.f9721d, a());
        try {
            s0Var.c(this);
        } catch (DeadObjectException unused) {
            c(1);
            this.f9719b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    public final void o() {
        if (this.f9726i) {
            C0904h c0904h = this.f9730o;
            c0904h.f9788n.removeMessages(11, this.f9720c);
            C0904h c0904h2 = this.f9730o;
            c0904h2.f9788n.removeMessages(9, this.f9720c);
            this.f9726i = false;
        }
    }

    public final boolean p(s0 s0Var) {
        if (!(s0Var instanceof Z)) {
            n(s0Var);
            return true;
        }
        Z z4 = (Z) s0Var;
        C1986d c1986dE = e(z4.g(this));
        if (c1986dE == null) {
            n(s0Var);
            return true;
        }
        Log.w("GoogleApiManager", this.f9719b.getClass().getName() + " could not execute call because it requires feature (" + c1986dE.getName() + ", " + c1986dE.i() + ").");
        if (!this.f9730o.f9789o || !z4.f(this)) {
            z4.b(new com.google.android.gms.common.api.o(c1986dE));
            return true;
        }
        S s4 = new S(this.f9720c, c1986dE, null);
        int iIndexOf = this.f9727j.indexOf(s4);
        if (iIndexOf >= 0) {
            S s5 = (S) this.f9727j.get(iIndexOf);
            this.f9730o.f9788n.removeMessages(15, s5);
            C0904h c0904h = this.f9730o;
            c0904h.f9788n.sendMessageDelayed(Message.obtain(c0904h.f9788n, 15, s5), 5000L);
            return false;
        }
        this.f9727j.add(s4);
        C0904h c0904h2 = this.f9730o;
        c0904h2.f9788n.sendMessageDelayed(Message.obtain(c0904h2.f9788n, 15, s4), 5000L);
        C0904h c0904h3 = this.f9730o;
        c0904h3.f9788n.sendMessageDelayed(Message.obtain(c0904h3.f9788n, 16, s4), 120000L);
        C1984b c1984b = new C1984b(2, null);
        if (q(c1984b)) {
            return false;
        }
        this.f9730o.f(c1984b, this.f9724g);
        return false;
    }

    public final boolean q(C1984b c1984b) {
        synchronized (C0904h.f9773r) {
            try {
                C0904h c0904h = this.f9730o;
                if (c0904h.f9785k == null || !c0904h.f9786l.contains(this.f9720c)) {
                    return false;
                }
                this.f9730o.f9785k.h(c1984b, this.f9724g);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean r(boolean z4) {
        AbstractC0940s.d(this.f9730o.f9788n);
        if (!this.f9719b.isConnected() || !this.f9723f.isEmpty()) {
            return false;
        }
        if (!this.f9721d.g()) {
            this.f9719b.disconnect("Timing out service connection.");
            return true;
        }
        if (!z4) {
            return false;
        }
        m();
        return false;
    }

    public final int s() {
        return this.f9724g;
    }

    public final int t() {
        return this.f9729n;
    }

    public final a.f v() {
        return this.f9719b;
    }

    public final Map x() {
        return this.f9723f;
    }
}
