package b6;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: renamed from: b6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1065e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9042b = AtomicIntegerFieldUpdater.newUpdater(C1065e.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T[] f9043a;
    private volatile int notCompletedCount;

    /* JADX INFO: renamed from: b6.e$a */
    public final class a extends D0 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final AtomicReferenceFieldUpdater f9044h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");
        private volatile Object _disposer;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InterfaceC1085o f9045e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public InterfaceC1062c0 f9046f;

        public a(InterfaceC1085o interfaceC1085o) {
            this.f9045e = interfaceC1085o;
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            s((Throwable) obj);
            return E5.E.f1657a;
        }

        @Override // b6.E
        public void s(Throwable th) {
            if (th != null) {
                Object objF = this.f9045e.f(th);
                if (objF != null) {
                    this.f9045e.n(objF);
                    b bVarV = v();
                    if (bVarV != null) {
                        bVarV.c();
                        return;
                    }
                    return;
                }
                return;
            }
            if (C1065e.f9042b.decrementAndGet(C1065e.this) == 0) {
                InterfaceC1085o interfaceC1085o = this.f9045e;
                T[] tArr = C1065e.this.f9043a;
                ArrayList arrayList = new ArrayList(tArr.length);
                for (T t7 : tArr) {
                    arrayList.add(t7.getCompleted());
                }
                interfaceC1085o.resumeWith(E5.p.b(arrayList));
            }
        }

        public final b v() {
            return (b) f9044h.get(this);
        }

        public final InterfaceC1062c0 w() {
            InterfaceC1062c0 interfaceC1062c0 = this.f9046f;
            if (interfaceC1062c0 != null) {
                return interfaceC1062c0;
            }
            kotlin.jvm.internal.r.s("handle");
            return null;
        }

        public final void x(b bVar) {
            f9044h.set(this, bVar);
        }

        public final void y(InterfaceC1062c0 interfaceC1062c0) {
            this.f9046f = interfaceC1062c0;
        }
    }

    /* JADX INFO: renamed from: b6.e$b */
    public final class b extends AbstractC1081m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a[] f9048a;

        public b(a[] aVarArr) {
            this.f9048a = aVarArr;
        }

        @Override // b6.AbstractC1083n
        public void a(Throwable th) {
            c();
        }

        public final void c() {
            for (a aVar : this.f9048a) {
                aVar.w().a();
            }
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return E5.E.f1657a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f9048a + ']';
        }
    }

    public C1065e(T[] tArr) {
        this.f9043a = tArr;
        this.notCompletedCount = tArr.length;
    }

    public final Object c(H5.d dVar) {
        C1087p c1087p = new C1087p(I5.b.c(dVar), 1);
        c1087p.A();
        int length = this.f9043a.length;
        a[] aVarArr = new a[length];
        for (int i7 = 0; i7 < length; i7++) {
            T t7 = this.f9043a[i7];
            t7.start();
            a aVar = new a(c1087p);
            aVar.y(t7.invokeOnCompletion(aVar));
            E5.E e7 = E5.E.f1657a;
            aVarArr[i7] = aVar;
        }
        b bVar = new b(aVarArr);
        for (int i8 = 0; i8 < length; i8++) {
            aVarArr[i8].x(bVar);
        }
        if (c1087p.isCompleted()) {
            bVar.c();
        } else {
            c1087p.g(bVar);
        }
        Object objX = c1087p.x();
        if (objX == I5.c.e()) {
            J5.h.c(dVar);
        }
        return objX;
    }
}
