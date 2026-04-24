package androidx.lifecycle;

import androidx.lifecycle.AbstractC0846i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import p.C1684c;
import q.C1717a;
import q.b;

/* JADX INFO: renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0851n extends AbstractC0846i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f7686k = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1717a f7688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbstractC0846i.b f7689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f7690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f7694i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final w3.o f7695j;

    /* JADX INFO: renamed from: androidx.lifecycle.n$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final AbstractC0846i.b a(AbstractC0846i.b state1, AbstractC0846i.b bVar) {
            kotlin.jvm.internal.r.f(state1, "state1");
            return (bVar == null || bVar.compareTo(state1) >= 0) ? state1 : bVar;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.n$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC0846i.b f7696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0848k f7697b;

        public b(InterfaceC0849l interfaceC0849l, AbstractC0846i.b initialState) {
            kotlin.jvm.internal.r.f(initialState, "initialState");
            kotlin.jvm.internal.r.c(interfaceC0849l);
            this.f7697b = C0852o.f(interfaceC0849l);
            this.f7696a = initialState;
        }

        public final void a(InterfaceC0850m interfaceC0850m, AbstractC0846i.a event) {
            kotlin.jvm.internal.r.f(event, "event");
            AbstractC0846i.b bVarG = event.g();
            this.f7696a = C0851n.f7686k.a(this.f7696a, bVarG);
            InterfaceC0848k interfaceC0848k = this.f7697b;
            kotlin.jvm.internal.r.c(interfaceC0850m);
            interfaceC0848k.a(interfaceC0850m, event);
            this.f7696a = bVarG;
        }

        public final AbstractC0846i.b b() {
            return this.f7696a;
        }
    }

    public C0851n(InterfaceC0850m interfaceC0850m, boolean z4) {
        this.f7687b = z4;
        this.f7688c = new C1717a();
        AbstractC0846i.b bVar = AbstractC0846i.b.INITIALIZED;
        this.f7689d = bVar;
        this.f7694i = new ArrayList();
        this.f7690e = new WeakReference(interfaceC0850m);
        this.f7695j = w3.u.a(bVar);
    }

    @Override // androidx.lifecycle.AbstractC0846i
    public void a(InterfaceC0849l observer) {
        InterfaceC0850m interfaceC0850m;
        kotlin.jvm.internal.r.f(observer, "observer");
        f("addObserver");
        AbstractC0846i.b bVar = this.f7689d;
        AbstractC0846i.b bVar2 = AbstractC0846i.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = AbstractC0846i.b.INITIALIZED;
        }
        b bVar3 = new b(observer, bVar2);
        if (((b) this.f7688c.m(observer, bVar3)) == null && (interfaceC0850m = (InterfaceC0850m) this.f7690e.get()) != null) {
            boolean z4 = this.f7691f != 0 || this.f7692g;
            AbstractC0846i.b bVarE = e(observer);
            this.f7691f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.f7688c.contains(observer)) {
                l(bVar3.b());
                AbstractC0846i.a aVarB = AbstractC0846i.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(interfaceC0850m, aVarB);
                k();
                bVarE = e(observer);
            }
            if (!z4) {
                n();
            }
            this.f7691f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0846i
    public AbstractC0846i.b b() {
        return this.f7689d;
    }

    @Override // androidx.lifecycle.AbstractC0846i
    public void c(InterfaceC0849l observer) {
        kotlin.jvm.internal.r.f(observer, "observer");
        f("removeObserver");
        this.f7688c.n(observer);
    }

    public final void d(InterfaceC0850m interfaceC0850m) {
        Iterator itDescendingIterator = this.f7688c.descendingIterator();
        kotlin.jvm.internal.r.e(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f7693h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            kotlin.jvm.internal.r.e(entry, "next()");
            InterfaceC0849l interfaceC0849l = (InterfaceC0849l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f7689d) > 0 && !this.f7693h && this.f7688c.contains(interfaceC0849l)) {
                AbstractC0846i.a aVarA = AbstractC0846i.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                l(aVarA.g());
                bVar.a(interfaceC0850m, aVarA);
                k();
            }
        }
    }

    public final AbstractC0846i.b e(InterfaceC0849l interfaceC0849l) {
        b bVar;
        Map.Entry entryO = this.f7688c.o(interfaceC0849l);
        AbstractC0846i.b bVar2 = null;
        AbstractC0846i.b bVarB = (entryO == null || (bVar = (b) entryO.getValue()) == null) ? null : bVar.b();
        if (!this.f7694i.isEmpty()) {
            bVar2 = (AbstractC0846i.b) this.f7694i.get(r0.size() - 1);
        }
        a aVar = f7686k;
        return aVar.a(aVar.a(this.f7689d, bVarB), bVar2);
    }

    public final void f(String str) {
        if (!this.f7687b || C1684c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void g(InterfaceC0850m interfaceC0850m) {
        b.d dVarI = this.f7688c.i();
        kotlin.jvm.internal.r.e(dVarI, "observerMap.iteratorWithAdditions()");
        while (dVarI.hasNext() && !this.f7693h) {
            Map.Entry entry = (Map.Entry) dVarI.next();
            InterfaceC0849l interfaceC0849l = (InterfaceC0849l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f7689d) < 0 && !this.f7693h && this.f7688c.contains(interfaceC0849l)) {
                l(bVar.b());
                AbstractC0846i.a aVarB = AbstractC0846i.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(interfaceC0850m, aVarB);
                k();
            }
        }
    }

    public void h(AbstractC0846i.a event) {
        kotlin.jvm.internal.r.f(event, "event");
        f("handleLifecycleEvent");
        j(event.g());
    }

    public final boolean i() {
        if (this.f7688c.size() == 0) {
            return true;
        }
        Map.Entry entryC = this.f7688c.c();
        kotlin.jvm.internal.r.c(entryC);
        AbstractC0846i.b bVarB = ((b) entryC.getValue()).b();
        Map.Entry entryK = this.f7688c.k();
        kotlin.jvm.internal.r.c(entryK);
        AbstractC0846i.b bVarB2 = ((b) entryK.getValue()).b();
        return bVarB == bVarB2 && this.f7689d == bVarB2;
    }

    public final void j(AbstractC0846i.b bVar) {
        AbstractC0846i.b bVar2 = this.f7689d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == AbstractC0846i.b.INITIALIZED && bVar == AbstractC0846i.b.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f7689d + " in component " + this.f7690e.get()).toString());
        }
        this.f7689d = bVar;
        if (this.f7692g || this.f7691f != 0) {
            this.f7693h = true;
            return;
        }
        this.f7692g = true;
        n();
        this.f7692g = false;
        if (this.f7689d == AbstractC0846i.b.DESTROYED) {
            this.f7688c = new C1717a();
        }
    }

    public final void k() {
        this.f7694i.remove(r0.size() - 1);
    }

    public final void l(AbstractC0846i.b bVar) {
        this.f7694i.add(bVar);
    }

    public void m(AbstractC0846i.b state) {
        kotlin.jvm.internal.r.f(state, "state");
        f("setCurrentState");
        j(state);
    }

    public final void n() {
        InterfaceC0850m interfaceC0850m = (InterfaceC0850m) this.f7690e.get();
        if (interfaceC0850m == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f7693h = false;
            AbstractC0846i.b bVar = this.f7689d;
            Map.Entry entryC = this.f7688c.c();
            kotlin.jvm.internal.r.c(entryC);
            if (bVar.compareTo(((b) entryC.getValue()).b()) < 0) {
                d(interfaceC0850m);
            }
            Map.Entry entryK = this.f7688c.k();
            if (!this.f7693h && entryK != null && this.f7689d.compareTo(((b) entryK.getValue()).b()) > 0) {
                g(interfaceC0850m);
            }
        }
        this.f7693h = false;
        this.f7695j.setValue(b());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0851n(InterfaceC0850m provider) {
        this(provider, true);
        kotlin.jvm.internal.r.f(provider, "provider");
    }
}
