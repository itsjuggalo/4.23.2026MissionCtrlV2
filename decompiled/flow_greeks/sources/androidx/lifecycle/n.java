package androidx.lifecycle;

import androidx.lifecycle.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import q.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n extends i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f2447k = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q.a f2449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i.b f2450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f2451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f2452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f2453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f2454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f2455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final qg.o f2456j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final i.b a(i.b state1, i.b bVar) {
            kotlin.jvm.internal.t.f(state1, "state1");
            return (bVar == null || bVar.compareTo(state1) >= 0) ? state1 : bVar;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i.b f2457a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public k f2458b;

        public b(l lVar, i.b initialState) {
            kotlin.jvm.internal.t.f(initialState, "initialState");
            kotlin.jvm.internal.t.c(lVar);
            this.f2458b = o.f(lVar);
            this.f2457a = initialState;
        }

        public final void a(m mVar, i.a event) {
            kotlin.jvm.internal.t.f(event, "event");
            i.b bVarC = event.c();
            this.f2457a = n.f2447k.a(this.f2457a, bVarC);
            k kVar = this.f2458b;
            kotlin.jvm.internal.t.c(mVar);
            kVar.b(mVar, event);
            this.f2457a = bVarC;
        }

        public final i.b b() {
            return this.f2457a;
        }
    }

    public n(m mVar, boolean z10) {
        this.f2448b = z10;
        this.f2449c = new q.a();
        i.b bVar = i.b.INITIALIZED;
        this.f2450d = bVar;
        this.f2455i = new ArrayList();
        this.f2451e = new WeakReference(mVar);
        this.f2456j = qg.u.a(bVar);
    }

    @Override // androidx.lifecycle.i
    public void a(l observer) {
        m mVar;
        kotlin.jvm.internal.t.f(observer, "observer");
        f("addObserver");
        i.b bVar = this.f2450d;
        i.b bVar2 = i.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = i.b.INITIALIZED;
        }
        b bVar3 = new b(observer, bVar2);
        if (((b) this.f2449c.g(observer, bVar3)) == null && (mVar = (m) this.f2451e.get()) != null) {
            boolean z10 = this.f2452f != 0 || this.f2453g;
            i.b bVarE = e(observer);
            this.f2452f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.f2449c.contains(observer)) {
                l(bVar3.b());
                i.a aVarB = i.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(mVar, aVarB);
                k();
                bVarE = e(observer);
            }
            if (!z10) {
                n();
            }
            this.f2452f--;
        }
    }

    @Override // androidx.lifecycle.i
    public i.b b() {
        return this.f2450d;
    }

    @Override // androidx.lifecycle.i
    public void c(l observer) {
        kotlin.jvm.internal.t.f(observer, "observer");
        f("removeObserver");
        this.f2449c.p(observer);
    }

    public final void d(m mVar) {
        Iterator itDescendingIterator = this.f2449c.descendingIterator();
        kotlin.jvm.internal.t.e(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f2454h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            kotlin.jvm.internal.t.e(entry, "next()");
            l lVar = (l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f2450d) > 0 && !this.f2454h && this.f2449c.contains(lVar)) {
                i.a aVarA = i.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                l(aVarA.c());
                bVar.a(mVar, aVarA);
                k();
            }
        }
    }

    public final i.b e(l lVar) {
        b bVar;
        Map.Entry entryQ = this.f2449c.q(lVar);
        i.b bVar2 = null;
        i.b bVarB = (entryQ == null || (bVar = (b) entryQ.getValue()) == null) ? null : bVar.b();
        if (!this.f2455i.isEmpty()) {
            bVar2 = (i.b) this.f2455i.get(r0.size() - 1);
        }
        a aVar = f2447k;
        return aVar.a(aVar.a(this.f2450d, bVarB), bVar2);
    }

    public final void f(String str) {
        if (!this.f2448b || p.c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void g(m mVar) {
        b.d dVarD = this.f2449c.d();
        kotlin.jvm.internal.t.e(dVarD, "observerMap.iteratorWithAdditions()");
        while (dVarD.hasNext() && !this.f2454h) {
            Map.Entry entry = (Map.Entry) dVarD.next();
            l lVar = (l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f2450d) < 0 && !this.f2454h && this.f2449c.contains(lVar)) {
                l(bVar.b());
                i.a aVarB = i.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(mVar, aVarB);
                k();
            }
        }
    }

    public void h(i.a event) {
        kotlin.jvm.internal.t.f(event, "event");
        f("handleLifecycleEvent");
        j(event.c());
    }

    public final boolean i() {
        if (this.f2449c.size() == 0) {
            return true;
        }
        Map.Entry entryA = this.f2449c.a();
        kotlin.jvm.internal.t.c(entryA);
        i.b bVarB = ((b) entryA.getValue()).b();
        Map.Entry entryE = this.f2449c.e();
        kotlin.jvm.internal.t.c(entryE);
        i.b bVarB2 = ((b) entryE.getValue()).b();
        return bVarB == bVarB2 && this.f2450d == bVarB2;
    }

    public final void j(i.b bVar) {
        i.b bVar2 = this.f2450d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == i.b.INITIALIZED && bVar == i.b.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f2450d + " in component " + this.f2451e.get()).toString());
        }
        this.f2450d = bVar;
        if (this.f2453g || this.f2452f != 0) {
            this.f2454h = true;
            return;
        }
        this.f2453g = true;
        n();
        this.f2453g = false;
        if (this.f2450d == i.b.DESTROYED) {
            this.f2449c = new q.a();
        }
    }

    public final void k() {
        this.f2455i.remove(r0.size() - 1);
    }

    public final void l(i.b bVar) {
        this.f2455i.add(bVar);
    }

    public void m(i.b state) {
        kotlin.jvm.internal.t.f(state, "state");
        f("setCurrentState");
        j(state);
    }

    public final void n() {
        m mVar = (m) this.f2451e.get();
        if (mVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f2454h = false;
            i.b bVar = this.f2450d;
            Map.Entry entryA = this.f2449c.a();
            kotlin.jvm.internal.t.c(entryA);
            if (bVar.compareTo(((b) entryA.getValue()).b()) < 0) {
                d(mVar);
            }
            Map.Entry entryE = this.f2449c.e();
            if (!this.f2454h && entryE != null && this.f2450d.compareTo(((b) entryE.getValue()).b()) > 0) {
                g(mVar);
            }
        }
        this.f2454h = false;
        this.f2456j.setValue(b());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(m provider) {
        this(provider, true);
        kotlin.jvm.internal.t.f(provider, "provider");
    }
}
