package t3;

import a3.AbstractC0786b;
import a3.AbstractC0787c;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: t3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1810e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f14984b = AtomicIntegerFieldUpdater.newUpdater(C1810e.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f14985a;
    private volatile int notCompletedCount;

    /* JADX INFO: renamed from: t3.e$a */
    public final class a extends D0 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f14986h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        private volatile Object _disposer;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC1830o f14987e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public InterfaceC1807c0 f14988f;

        public a(InterfaceC1830o interfaceC1830o) {
            this.f14987e = interfaceC1830o;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            q((Throwable) obj);
            return W2.E.f5463a;
        }

        @Override // t3.E
        public void q(Throwable th) {
            if (th != null) {
                Object objI = this.f14987e.i(th);
                if (objI != null) {
                    this.f14987e.p(objI);
                    b bVarT = t();
                    if (bVarT != null) {
                        bVarT.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (C1810e.f14984b.decrementAndGet(C1810e.this) == 0) {
                InterfaceC1830o interfaceC1830o = this.f14987e;
                T[] tArr = C1810e.this.f14985a;
                ArrayList arrayList = new ArrayList(tArr.length);
                for (T t4 : tArr) {
                    arrayList.add(t4.getCompleted());
                }
                interfaceC1830o.resumeWith(W2.p.b(arrayList));
            }
        }

        public final b t() {
            return (b) f14986h.get(this);
        }

        public final InterfaceC1807c0 u() {
            InterfaceC1807c0 interfaceC1807c0 = this.f14988f;
            if (interfaceC1807c0 != null) {
                return interfaceC1807c0;
            }
            kotlin.jvm.internal.r.t("handle");
            return null;
        }

        public final void v(b bVar) {
            f14986h.set(this, bVar);
        }

        public final void w(InterfaceC1807c0 interfaceC1807c0) {
            this.f14988f = interfaceC1807c0;
        }
    }

    /* JADX INFO: renamed from: t3.e$b */
    public final class b extends AbstractC1826m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a[] f14990a;

        public b(a[] aVarArr) {
            this.f14990a = aVarArr;
        }

        @Override // t3.AbstractC1828n
        public void a(Throwable th) {
            b();
        }

        public final void b() {
            for (a aVar : this.f14990a) {
                aVar.u().dispose();
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return W2.E.f5463a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f14990a + ']';
        }
    }

    public C1810e(T[] tArr) {
        this.f14985a = tArr;
        this.notCompletedCount = tArr.length;
    }

    public final Object c(Z2.e eVar) {
        C1832p c1832p = new C1832p(AbstractC0786b.c(eVar), 1);
        c1832p.A();
        int length = this.f14985a.length;
        a[] aVarArr = new a[length];
        for (int i4 = 0; i4 < length; i4++) {
            T t4 = this.f14985a[i4];
            t4.start();
            a aVar = new a(c1832p);
            aVar.w(t4.invokeOnCompletion(aVar));
            W2.E e4 = W2.E.f5463a;
            aVarArr[i4] = aVar;
        }
        b bVar = new b(aVarArr);
        for (int i5 = 0; i5 < length; i5++) {
            aVarArr[i5].v(bVar);
        }
        if (c1832p.isCompleted()) {
            bVar.b();
        } else {
            c1832p.g(bVar);
        }
        Object objX = c1832p.x();
        if (objX == AbstractC0787c.e()) {
            b3.h.c(eVar);
        }
        return objX;
    }
}
