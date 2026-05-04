package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.l;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements g.b, g.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Queue f5565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a.f f5566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f5567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y f5568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f5569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f5570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f5571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a1 f5572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List f5574j;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public m5.b f5575m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f5576n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ g f5577o;

    public h0(g gVar, com.google.android.gms.common.api.f fVar) {
        Objects.requireNonNull(gVar);
        this.f5577o = gVar;
        this.f5565a = new LinkedList();
        this.f5569e = new HashSet();
        this.f5570f = new HashMap();
        this.f5574j = new ArrayList();
        this.f5575m = null;
        this.f5576n = 0;
        a.f fVarZaa = fVar.zaa(gVar.g().getLooper(), this);
        this.f5566b = fVarZaa;
        this.f5567c = fVar.getApiKey();
        this.f5568d = new y();
        this.f5571g = fVar.zab();
        if (fVarZaa.requiresSignIn()) {
            this.f5572h = fVar.zac(gVar.H(), gVar.g());
        } else {
            this.f5572h = null;
        }
    }

    public final boolean A() {
        return this.f5566b.requiresSignIn();
    }

    public final int B() {
        return this.f5571g;
    }

    public final int C() {
        return this.f5576n;
    }

    public final void D() {
        this.f5576n++;
    }

    public final /* synthetic */ boolean H(boolean z10) {
        return m(false);
    }

    public final /* synthetic */ void I(i0 i0Var) {
        if (this.f5574j.contains(i0Var) && !this.f5573i) {
            if (this.f5566b.isConnected()) {
                f();
            } else {
                z();
            }
        }
    }

    public final /* synthetic */ void J(i0 i0Var) {
        m5.d[] dVarArrF;
        if (this.f5574j.remove(i0Var)) {
            g gVar = this.f5577o;
            gVar.g().removeMessages(15, i0Var);
            gVar.g().removeMessages(16, i0Var);
            m5.d dVarB = i0Var.b();
            Queue<j1> queue = this.f5565a;
            ArrayList arrayList = new ArrayList(queue.size());
            for (j1 j1Var : queue) {
                if ((j1Var instanceof u0) && (dVarArrF = ((u0) j1Var).f(this)) != null && t5.b.b(dVarArrF, dVarB)) {
                    arrayList.add(j1Var);
                }
            }
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                j1 j1Var2 = (j1) arrayList.get(i10);
                queue.remove(j1Var2);
                j1Var2.b(new com.google.android.gms.common.api.o(dVarB));
            }
        }
    }

    public final /* synthetic */ a.f K() {
        return this.f5566b;
    }

    public final /* synthetic */ b a() {
        return this.f5567c;
    }

    public final /* synthetic */ boolean b() {
        return this.f5573i;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void E() {
        v();
        n(m5.b.f15883e);
        k();
        Iterator it = this.f5570f.values().iterator();
        if (it.hasNext()) {
            ((w0) it.next()).getClass();
            throw null;
        }
        f();
        l();
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final void F(int i10) {
        v();
        this.f5573i = true;
        this.f5568d.e(i10, this.f5566b.getLastDisconnectMessage());
        b bVar = this.f5567c;
        g gVar = this.f5577o;
        gVar.g().sendMessageDelayed(Message.obtain(gVar.g(), 9, bVar), 5000L);
        gVar.g().sendMessageDelayed(Message.obtain(gVar.g(), 11, bVar), 120000L);
        gVar.c().c();
        Iterator it = this.f5570f.values().iterator();
        while (it.hasNext()) {
            ((w0) it.next()).f5650a.run();
        }
    }

    public final boolean e(m5.b bVar) {
        synchronized (g.f5545r) {
            try {
                g gVar = this.f5577o;
                if (gVar.e() == null || !gVar.f().contains(this.f5567c)) {
                    return false;
                }
                gVar.e().f(bVar, this.f5571g);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f() {
        Queue queue = this.f5565a;
        ArrayList arrayList = new ArrayList(queue);
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            j1 j1Var = (j1) arrayList.get(i10);
            if (!this.f5566b.isConnected()) {
                return;
            }
            if (g(j1Var)) {
                queue.remove(j1Var);
            }
        }
    }

    public final boolean g(j1 j1Var) {
        if (!(j1Var instanceof u0)) {
            h(j1Var);
            return true;
        }
        u0 u0Var = (u0) j1Var;
        m5.d dVarO = o(u0Var.f(this));
        if (dVarO == null) {
            h(j1Var);
            return true;
        }
        String name = this.f5566b.getClass().getName();
        String name2 = dVarO.getName();
        long jR = dVarO.R();
        int length = name.length();
        StringBuilder sb2 = new StringBuilder(length + 53 + String.valueOf(name2).length() + 2 + String.valueOf(jR).length() + 2);
        sb2.append(name);
        sb2.append(" could not execute call because it requires feature (");
        sb2.append(name2);
        sb2.append(", ");
        sb2.append(jR);
        sb2.append(").");
        Log.w("GoogleApiManager", sb2.toString());
        g gVar = this.f5577o;
        if (!gVar.h() || !u0Var.g(this)) {
            u0Var.b(new com.google.android.gms.common.api.o(dVarO));
            return true;
        }
        i0 i0Var = new i0(this.f5567c, dVarO, null);
        List list = this.f5574j;
        int iIndexOf = list.indexOf(i0Var);
        if (iIndexOf >= 0) {
            i0 i0Var2 = (i0) list.get(iIndexOf);
            gVar.g().removeMessages(15, i0Var2);
            gVar.g().sendMessageDelayed(Message.obtain(gVar.g(), 15, i0Var2), 5000L);
            return false;
        }
        list.add(i0Var);
        gVar.g().sendMessageDelayed(Message.obtain(gVar.g(), 15, i0Var), 5000L);
        gVar.g().sendMessageDelayed(Message.obtain(gVar.g(), 16, i0Var), 120000L);
        m5.b bVar = new m5.b(2, null);
        if (e(bVar)) {
            String name3 = dVarO.getName();
            long jR2 = dVarO.R();
            StringBuilder sb3 = new StringBuilder(String.valueOf(name3).length() + 61 + String.valueOf(jR2).length());
            sb3.append("A dialog should be displayed for missing feature: ");
            sb3.append(name3);
            sb3.append(", version: ");
            sb3.append(jR2);
            Log.w("GoogleApiManager", sb3.toString());
            return false;
        }
        if (!gVar.z(bVar, this.f5571g)) {
            return false;
        }
        String name4 = dVarO.getName();
        long jR3 = dVarO.R();
        StringBuilder sb4 = new StringBuilder(String.valueOf(name4).length() + 55 + String.valueOf(jR3).length());
        sb4.append("Notification displayed for missing feature: ");
        sb4.append(name4);
        sb4.append(", version: ");
        sb4.append(jR3);
        Log.w("GoogleApiManager", sb4.toString());
        return false;
    }

    public final void h(j1 j1Var) {
        j1Var.c(this.f5568d, A());
        try {
            j1Var.d(this);
        } catch (DeadObjectException unused) {
            onConnectionSuspended(1);
            this.f5566b.disconnect("DeadObjectException thrown while running ApiCallRunner.");
        }
    }

    public final void i(Status status, Exception exc, boolean z10) {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f5565a.iterator();
        while (it.hasNext()) {
            j1 j1Var = (j1) it.next();
            if (!z10 || j1Var.f5587a == 2) {
                if (status != null) {
                    j1Var.a(status);
                } else {
                    j1Var.b(exc);
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void G(Status status) {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        i(status, null, false);
    }

    public final void k() {
        if (this.f5573i) {
            g gVar = this.f5577o;
            b bVar = this.f5567c;
            gVar.g().removeMessages(11, bVar);
            gVar.g().removeMessages(9, bVar);
            this.f5573i = false;
        }
    }

    public final void l() {
        b bVar = this.f5567c;
        g gVar = this.f5577o;
        gVar.g().removeMessages(12, bVar);
        gVar.g().sendMessageDelayed(gVar.g().obtainMessage(12, bVar), gVar.E());
    }

    public final boolean m(boolean z10) {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        a.f fVar = this.f5566b;
        if (!fVar.isConnected() || !this.f5570f.isEmpty()) {
            return false;
        }
        if (!this.f5568d.c()) {
            fVar.disconnect("Timing out service connection.");
            return true;
        }
        if (!z10) {
            return false;
        }
        l();
        return false;
    }

    public final void n(m5.b bVar) {
        Set set = this.f5569e;
        Iterator it = set.iterator();
        if (!it.hasNext()) {
            set.clear();
            return;
        }
        android.support.v4.media.session.b.a(it.next());
        if (com.google.android.gms.common.internal.q.b(bVar, m5.b.f15883e)) {
            this.f5566b.getEndpointPackageName();
        }
        throw null;
    }

    public final m5.d o(m5.d[] dVarArr) {
        if (dVarArr != null && dVarArr.length != 0) {
            m5.d[] availableFeatures = this.f5566b.getAvailableFeatures();
            if (availableFeatures == null) {
                availableFeatures = new m5.d[0];
            }
            w.a aVar = new w.a(availableFeatures.length);
            for (m5.d dVar : availableFeatures) {
                aVar.put(dVar.getName(), Long.valueOf(dVar.R()));
            }
            for (m5.d dVar2 : dVarArr) {
                Long l10 = (Long) aVar.get(dVar2.getName());
                if (l10 == null || l10.longValue() < dVar2.R()) {
                    return dVar2;
                }
            }
        }
        return null;
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void onConnected(Bundle bundle) {
        g gVar = this.f5577o;
        if (Looper.myLooper() == gVar.g().getLooper()) {
            E();
        } else {
            gVar.g().post(new d0(this));
        }
    }

    @Override // com.google.android.gms.common.api.internal.n
    public final void onConnectionFailed(m5.b bVar) {
        q(bVar, null);
    }

    @Override // com.google.android.gms.common.api.internal.f
    public final void onConnectionSuspended(int i10) {
        g gVar = this.f5577o;
        if (Looper.myLooper() == gVar.g().getLooper()) {
            F(i10);
        } else {
            gVar.g().post(new e0(this, i10));
        }
    }

    public final void p(m5.b bVar) {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        a.f fVar = this.f5566b;
        String name = fVar.getClass().getName();
        String strValueOf = String.valueOf(bVar);
        StringBuilder sb2 = new StringBuilder(name.length() + 25 + strValueOf.length());
        sb2.append("onSignInFailed for ");
        sb2.append(name);
        sb2.append(" with ");
        sb2.append(strValueOf);
        fVar.disconnect(sb2.toString());
        q(bVar, null);
    }

    public final void q(m5.b bVar, Exception exc) {
        g gVar = this.f5577o;
        com.google.android.gms.common.internal.s.d(gVar.g());
        a1 a1Var = this.f5572h;
        if (a1Var != null) {
            a1Var.I();
        }
        v();
        gVar.c().c();
        n(bVar);
        if ((this.f5566b instanceof o5.e) && bVar.R() != 24) {
            gVar.F(true);
            gVar.g().sendMessageDelayed(gVar.g().obtainMessage(19), 300000L);
        }
        if (bVar.R() == 4) {
            G(g.f5544q);
            return;
        }
        if (bVar.R() == 25) {
            G(g.k(this.f5567c, bVar));
            return;
        }
        Queue queue = this.f5565a;
        if (queue.isEmpty()) {
            this.f5575m = bVar;
            return;
        }
        if (exc != null) {
            com.google.android.gms.common.internal.s.d(gVar.g());
            i(null, exc, false);
            return;
        }
        if (!gVar.h()) {
            G(g.k(this.f5567c, bVar));
            return;
        }
        b bVar2 = this.f5567c;
        i(g.k(bVar2, bVar), null, true);
        if (queue.isEmpty() || e(bVar) || gVar.z(bVar, this.f5571g)) {
            return;
        }
        if (bVar.R() == 18) {
            this.f5573i = true;
        }
        if (this.f5573i) {
            gVar.g().sendMessageDelayed(Message.obtain(gVar.g(), 9, bVar2), 5000L);
        } else {
            G(g.k(bVar2, bVar));
        }
    }

    public final void r(j1 j1Var) {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        if (this.f5566b.isConnected()) {
            if (g(j1Var)) {
                l();
                return;
            } else {
                this.f5565a.add(j1Var);
                return;
            }
        }
        this.f5565a.add(j1Var);
        m5.b bVar = this.f5575m;
        if (bVar == null || !bVar.U()) {
            z();
        } else {
            q(this.f5575m, null);
        }
    }

    public final void s() {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        G(g.f5543p);
        this.f5568d.d();
        for (l.a aVar : (l.a[]) this.f5570f.keySet().toArray(new l.a[0])) {
            r(new i1(aVar, new TaskCompletionSource()));
        }
        n(new m5.b(4));
        a.f fVar = this.f5566b;
        if (fVar.isConnected()) {
            fVar.onUserSignOut(new g0(this));
        }
    }

    public final a.f t() {
        return this.f5566b;
    }

    public final Map u() {
        return this.f5570f;
    }

    public final void v() {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        this.f5575m = null;
    }

    public final void w() {
        com.google.android.gms.common.internal.s.d(this.f5577o.g());
        if (this.f5573i) {
            z();
        }
    }

    public final void x() {
        g gVar = this.f5577o;
        com.google.android.gms.common.internal.s.d(gVar.g());
        if (this.f5573i) {
            k();
            G(gVar.b().g(gVar.H()) == 18 ? new Status(21, "Connection timed out waiting for Google Play services update to complete.") : new Status(22, "API failed to connect while resuming due to an unknown error."));
            this.f5566b.disconnect("Timing out connection while resuming.");
        }
    }

    public final boolean y() {
        return m(true);
    }

    public final void z() {
        g gVar = this.f5577o;
        com.google.android.gms.common.internal.s.d(gVar.g());
        a.f fVar = this.f5566b;
        if (fVar.isConnected() || fVar.isConnecting()) {
            return;
        }
        try {
            int iA = gVar.c().a(gVar.H(), fVar);
            if (iA == 0) {
                k0 k0Var = new k0(gVar, fVar, this.f5567c);
                if (fVar.requiresSignIn()) {
                    ((a1) com.google.android.gms.common.internal.s.k(this.f5572h)).H(k0Var);
                }
                try {
                    fVar.connect(k0Var);
                    return;
                } catch (SecurityException e10) {
                    q(new m5.b(10), e10);
                    return;
                }
            }
            m5.b bVar = new m5.b(iA, null);
            String name = this.f5566b.getClass().getName();
            String string = bVar.toString();
            StringBuilder sb2 = new StringBuilder(name.length() + 35 + string.length());
            sb2.append("The service for ");
            sb2.append(name);
            sb2.append(" is not available: ");
            sb2.append(string);
            Log.w("GoogleApiManager", sb2.toString());
            q(bVar, null);
        } catch (IllegalStateException e11) {
            q(new m5.b(10), e11);
        }
    }
}
