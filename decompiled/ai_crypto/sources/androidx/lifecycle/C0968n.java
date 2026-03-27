package androidx.lifecycle;

import androidx.lifecycle.AbstractC0963i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;
import q.C2546c;
import r.C2570a;
import r.C2571b;

/* JADX INFO: renamed from: androidx.lifecycle.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0968n extends AbstractC0963i {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f7784k = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7785b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C2570a f7786c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbstractC0963i.b f7787d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakReference f7788e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ArrayList f7792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e6.o f7793j;

    /* JADX INFO: renamed from: androidx.lifecycle.n$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final AbstractC0963i.b a(AbstractC0963i.b state1, AbstractC0963i.b bVar) {
            kotlin.jvm.internal.r.f(state1, "state1");
            return (bVar == null || bVar.compareTo(state1) >= 0) ? state1 : bVar;
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: androidx.lifecycle.n$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AbstractC0963i.b f7794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public InterfaceC0965k f7795b;

        public b(InterfaceC0966l interfaceC0966l, AbstractC0963i.b initialState) {
            kotlin.jvm.internal.r.f(initialState, "initialState");
            kotlin.jvm.internal.r.c(interfaceC0966l);
            this.f7795b = C0969o.f(interfaceC0966l);
            this.f7794a = initialState;
        }

        public final void a(InterfaceC0967m interfaceC0967m, AbstractC0963i.a event) {
            kotlin.jvm.internal.r.f(event, "event");
            AbstractC0963i.b bVarB = event.b();
            this.f7794a = C0968n.f7784k.a(this.f7794a, bVarB);
            InterfaceC0965k interfaceC0965k = this.f7795b;
            kotlin.jvm.internal.r.c(interfaceC0967m);
            interfaceC0965k.a(interfaceC0967m, event);
            this.f7794a = bVarB;
        }

        public final AbstractC0963i.b b() {
            return this.f7794a;
        }
    }

    public C0968n(InterfaceC0967m interfaceC0967m, boolean z7) {
        this.f7785b = z7;
        this.f7786c = new C2570a();
        AbstractC0963i.b bVar = AbstractC0963i.b.INITIALIZED;
        this.f7787d = bVar;
        this.f7792i = new ArrayList();
        this.f7788e = new WeakReference(interfaceC0967m);
        this.f7793j = e6.u.a(bVar);
    }

    @Override // androidx.lifecycle.AbstractC0963i
    public void a(InterfaceC0966l observer) {
        InterfaceC0967m interfaceC0967m;
        kotlin.jvm.internal.r.f(observer, "observer");
        f("addObserver");
        AbstractC0963i.b bVar = this.f7787d;
        AbstractC0963i.b bVar2 = AbstractC0963i.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = AbstractC0963i.b.INITIALIZED;
        }
        b bVar3 = new b(observer, bVar2);
        if (((b) this.f7786c.j(observer, bVar3)) == null && (interfaceC0967m = (InterfaceC0967m) this.f7788e.get()) != null) {
            boolean z7 = this.f7789f != 0 || this.f7790g;
            AbstractC0963i.b bVarE = e(observer);
            this.f7789f++;
            while (bVar3.b().compareTo(bVarE) < 0 && this.f7786c.contains(observer)) {
                l(bVar3.b());
                AbstractC0963i.a aVarB = AbstractC0963i.a.Companion.b(bVar3.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(interfaceC0967m, aVarB);
                k();
                bVarE = e(observer);
            }
            if (!z7) {
                n();
            }
            this.f7789f--;
        }
    }

    @Override // androidx.lifecycle.AbstractC0963i
    public AbstractC0963i.b b() {
        return this.f7787d;
    }

    @Override // androidx.lifecycle.AbstractC0963i
    public void c(InterfaceC0966l observer) {
        kotlin.jvm.internal.r.f(observer, "observer");
        f("removeObserver");
        this.f7786c.k(observer);
    }

    public final void d(InterfaceC0967m interfaceC0967m) {
        Iterator itDescendingIterator = this.f7786c.descendingIterator();
        kotlin.jvm.internal.r.e(itDescendingIterator, "observerMap.descendingIterator()");
        while (itDescendingIterator.hasNext() && !this.f7791h) {
            Map.Entry entry = (Map.Entry) itDescendingIterator.next();
            kotlin.jvm.internal.r.e(entry, "next()");
            InterfaceC0966l interfaceC0966l = (InterfaceC0966l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f7787d) > 0 && !this.f7791h && this.f7786c.contains(interfaceC0966l)) {
                AbstractC0963i.a aVarA = AbstractC0963i.a.Companion.a(bVar.b());
                if (aVarA == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                l(aVarA.b());
                bVar.a(interfaceC0967m, aVarA);
                k();
            }
        }
    }

    public final AbstractC0963i.b e(InterfaceC0966l interfaceC0966l) {
        b bVar;
        Map.Entry entryL = this.f7786c.l(interfaceC0966l);
        AbstractC0963i.b bVar2 = null;
        AbstractC0963i.b bVarB = (entryL == null || (bVar = (b) entryL.getValue()) == null) ? null : bVar.b();
        if (!this.f7792i.isEmpty()) {
            bVar2 = (AbstractC0963i.b) this.f7792i.get(r0.size() - 1);
        }
        a aVar = f7784k;
        return aVar.a(aVar.a(this.f7787d, bVarB), bVar2);
    }

    public final void f(String str) {
        if (!this.f7785b || C2546c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    public final void g(InterfaceC0967m interfaceC0967m) {
        C2571b.d dVarC = this.f7786c.c();
        kotlin.jvm.internal.r.e(dVarC, "observerMap.iteratorWithAdditions()");
        while (dVarC.hasNext() && !this.f7791h) {
            Map.Entry entry = (Map.Entry) dVarC.next();
            InterfaceC0966l interfaceC0966l = (InterfaceC0966l) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f7787d) < 0 && !this.f7791h && this.f7786c.contains(interfaceC0966l)) {
                l(bVar.b());
                AbstractC0963i.a aVarB = AbstractC0963i.a.Companion.b(bVar.b());
                if (aVarB == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(interfaceC0967m, aVarB);
                k();
            }
        }
    }

    public void h(AbstractC0963i.a event) {
        kotlin.jvm.internal.r.f(event, "event");
        f("handleLifecycleEvent");
        j(event.b());
    }

    public final boolean i() {
        if (this.f7786c.size() == 0) {
            return true;
        }
        Map.Entry entryA = this.f7786c.a();
        kotlin.jvm.internal.r.c(entryA);
        AbstractC0963i.b bVarB = ((b) entryA.getValue()).b();
        Map.Entry entryG = this.f7786c.g();
        kotlin.jvm.internal.r.c(entryG);
        AbstractC0963i.b bVarB2 = ((b) entryG.getValue()).b();
        return bVarB == bVarB2 && this.f7787d == bVarB2;
    }

    public final void j(AbstractC0963i.b bVar) {
        AbstractC0963i.b bVar2 = this.f7787d;
        if (bVar2 == bVar) {
            return;
        }
        if (bVar2 == AbstractC0963i.b.INITIALIZED && bVar == AbstractC0963i.b.DESTROYED) {
            throw new IllegalStateException(("no event down from " + this.f7787d + " in component " + this.f7788e.get()).toString());
        }
        this.f7787d = bVar;
        if (this.f7790g || this.f7789f != 0) {
            this.f7791h = true;
            return;
        }
        this.f7790g = true;
        n();
        this.f7790g = false;
        if (this.f7787d == AbstractC0963i.b.DESTROYED) {
            this.f7786c = new C2570a();
        }
    }

    public final void k() {
        this.f7792i.remove(r0.size() - 1);
    }

    public final void l(AbstractC0963i.b bVar) {
        this.f7792i.add(bVar);
    }

    public void m(AbstractC0963i.b state) {
        kotlin.jvm.internal.r.f(state, "state");
        f("setCurrentState");
        j(state);
    }

    public final void n() {
        InterfaceC0967m interfaceC0967m = (InterfaceC0967m) this.f7788e.get();
        if (interfaceC0967m == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!i()) {
            this.f7791h = false;
            AbstractC0963i.b bVar = this.f7787d;
            Map.Entry entryA = this.f7786c.a();
            kotlin.jvm.internal.r.c(entryA);
            if (bVar.compareTo(((b) entryA.getValue()).b()) < 0) {
                d(interfaceC0967m);
            }
            Map.Entry entryG = this.f7786c.g();
            if (!this.f7791h && entryG != null && this.f7787d.compareTo(((b) entryG.getValue()).b()) > 0) {
                g(interfaceC0967m);
            }
        }
        this.f7791h = false;
        this.f7793j.setValue(b());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C0968n(InterfaceC0967m provider) {
        this(provider, true);
        kotlin.jvm.internal.r.f(provider, "provider");
    }
}
