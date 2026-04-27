package androidx.lifecycle;

import androidx.lifecycle.AbstractC1157i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p.C2536c;
import q.C2615a;
import q.C2616b;

/* JADX INFO: renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1162n extends AbstractC1157i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f11982k = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f11983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C2615a f11984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbstractC1157i.b f11985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f11986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11988g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f11989h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f11990i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final b7.o f11991j;

    /* JADX INFO: renamed from: androidx.lifecycle.n$a */
    public static final class a {
        public a() {
        }

        public final AbstractC1157i.b a(AbstractC1157i.b state1, AbstractC1157i.b bVar) {
            AbstractC2304t.f(state1, "state1");
            return (bVar == null || bVar.compareTo(state1) >= 0) ? state1 : bVar;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.n$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC1157i.b f11992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC1159k f11993b;

        public b(InterfaceC1160l interfaceC1160l, AbstractC1157i.b initialState) {
            AbstractC2304t.f(initialState, "initialState");
            AbstractC2304t.c(interfaceC1160l);
            this.f11993b = C1163o.f(interfaceC1160l);
            this.f11992a = initialState;
        }

        public final void a(InterfaceC1161m interfaceC1161m, AbstractC1157i.a event) {
            AbstractC2304t.f(event, "event");
            AbstractC1157i.b bVarG = event.g();
            this.f11992a = C1162n.f11982k.a(this.f11992a, bVarG);
            InterfaceC1159k interfaceC1159k = this.f11993b;
            AbstractC2304t.c(interfaceC1161m);
            interfaceC1159k.b(interfaceC1161m, event);
            this.f11992a = bVarG;
        }

        public final AbstractC1157i.b b() {
            return this.f11992a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C1162n(InterfaceC1161m provider) {
        this(provider, true);
        AbstractC2304t.f(provider, "provider");
    }

    @Override // androidx.lifecycle.AbstractC1157i
    public void a(InterfaceC1160l observer) {
        InterfaceC1161m interfaceC1161m;
        AbstractC2304t.f(observer, "observer");
        f("addObserver");
        AbstractC1157i.b bVar = this.f11985d;
        AbstractC1157i.b bVar2 = AbstractC1157i.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = AbstractC1157i.b.INITIALIZED;
        }
        b bVar3 = new b(observer, bVar2);
        if (((b) this.f11984c.n(observer, bVar3)) == null && (interfaceC1161m = (InterfaceC1161m) this.f11986e.get()) != null) {
            boolean z7 = this.f11987f != 0 || this.f11988g;
            AbstractC1157i.b bVarE = e(observer);
            this.f11987f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.f11984c.contains(observer)) {
                l(bVar3.b());
                AbstractC1157i.a aVarB = AbstractC1157i.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(interfaceC1161m, aVarB);
                k();
                bVarE = e(observer);
            }
            if (!z7) {
                n();
            }
            this.f11987f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC1157i
    public AbstractC1157i.b b() {
        return this.f11985d;
    }

    @Override // androidx.lifecycle.AbstractC1157i
    public void c(InterfaceC1160l observer) {
        AbstractC2304t.f(observer, "observer");
        f("removeObserver");
        this.f11984c.C(observer);
    }

    public final void d(InterfaceC1161m interfaceC1161m) {
        Iterator itDescendingIterator = this.f11984c.descendingIterator();
        AbstractC2304t.e(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f11989h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            AbstractC2304t.e(entry, "next()");
            InterfaceC1160l interfaceC1160l = (InterfaceC1160l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f11985d) > 0 && !this.f11989h && this.f11984c.contains(interfaceC1160l)) {
                AbstractC1157i.a aVarA = AbstractC1157i.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                l(aVarA.g());
                bVar.a(interfaceC1161m, aVarA);
                k();
            }
        }
    }

    public final AbstractC1157i.b e(InterfaceC1160l interfaceC1160l) {
        b bVar;
        Map.Entry entryF = this.f11984c.F(interfaceC1160l);
        AbstractC1157i.b bVar2 = null;
        AbstractC1157i.b bVarB = (entryF == null || (bVar = (b) entryF.getValue()) == null) ? null : bVar.b();
        if (!this.f11990i.isEmpty()) {
            bVar2 = (AbstractC1157i.b) this.f11990i.get(r0.size() - 1);
        }
        a aVar = f11982k;
        return aVar.a(aVar.a(this.f11985d, bVarB), bVar2);
    }

    public final void f(String str) {
        if (!this.f11983b || C2536c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void g(InterfaceC1161m interfaceC1161m) {
        C2616b.d dVarE = this.f11984c.e();
        AbstractC2304t.e(dVarE, "observerMap.iteratorWithAdditions()");
        while (dVarE.hasNext() && !this.f11989h) {
            Map.Entry entry = (Map.Entry) dVarE.next();
            InterfaceC1160l interfaceC1160l = (InterfaceC1160l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f11985d) < 0 && !this.f11989h && this.f11984c.contains(interfaceC1160l)) {
                l(bVar.b());
                AbstractC1157i.a aVarB = AbstractC1157i.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(interfaceC1161m, aVarB);
                k();
            }
        }
    }

    public void h(AbstractC1157i.a event) {
        AbstractC2304t.f(event, "event");
        f("handleLifecycleEvent");
        j(event.g());
    }

    public final boolean i() {
        if (this.f11984c.size() == 0) {
            return true;
        }
        Map.Entry entryA = this.f11984c.a();
        AbstractC2304t.c(entryA);
        AbstractC1157i.b bVarB = ((b) entryA.getValue()).b();
        Map.Entry entryF = this.f11984c.f();
        AbstractC2304t.c(entryF);
        AbstractC1157i.b bVarB2 = ((b) entryF.getValue()).b();
        return bVarB == bVarB2 && this.f11985d == bVarB2;
    }

    public final void j(AbstractC1157i.b bVar) {
        AbstractC1157i.b bVar2 = this.f11985d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == AbstractC1157i.b.INITIALIZED && bVar == AbstractC1157i.b.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f11985d + " in component " + this.f11986e.get()).toString());
        }
        this.f11985d = bVar;
        if (this.f11988g || this.f11987f != 0) {
            this.f11989h = true;
            return;
        }
        this.f11988g = true;
        n();
        this.f11988g = false;
        if (this.f11985d == AbstractC1157i.b.DESTROYED) {
            this.f11984c = new C2615a();
        }
    }

    public final void k() {
        this.f11990i.remove(r0.size() - 1);
    }

    public final void l(AbstractC1157i.b bVar) {
        this.f11990i.add(bVar);
    }

    public void m(AbstractC1157i.b state) {
        AbstractC2304t.f(state, "state");
        f("setCurrentState");
        j(state);
    }

    public final void n() {
        InterfaceC1161m interfaceC1161m = (InterfaceC1161m) this.f11986e.get();
        if (interfaceC1161m == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean zI = i();
            this.f11989h = false;
            if (zI) {
                this.f11991j.setValue(b());
                return;
            }
            AbstractC1157i.b bVar = this.f11985d;
            Map.Entry entryA = this.f11984c.a();
            AbstractC2304t.c(entryA);
            if (bVar.compareTo(((b) entryA.getValue()).b()) < 0) {
                d(interfaceC1161m);
            }
            Map.Entry entryF = this.f11984c.f();
            if (!this.f11989h && entryF != null && this.f11985d.compareTo(((b) entryF.getValue()).b()) > 0) {
                g(interfaceC1161m);
            }
        }
    }

    public C1162n(InterfaceC1161m interfaceC1161m, boolean z7) {
        this.f11983b = z7;
        this.f11984c = new C2615a();
        AbstractC1157i.b bVar = AbstractC1157i.b.INITIALIZED;
        this.f11985d = bVar;
        this.f11990i = new ArrayList();
        this.f11986e = new WeakReference(interfaceC1161m);
        this.f11991j = b7.u.a(bVar);
    }
}
