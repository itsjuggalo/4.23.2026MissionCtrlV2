package C3;

import W2.E;
import Z2.i;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import b3.h;
import i3.k;
import i3.p;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.s;
import t3.C1832p;
import t3.I;
import t3.InterfaceC1830o;
import t3.P;
import t3.b1;
import t3.r;
import y3.C;

/* JADX INFO: loaded from: classes3.dex */
public class b extends d implements C3.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f256i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "owner");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final p f257h;
    private volatile Object owner;

    public final class a implements InterfaceC1830o, b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1832p f258a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f259b;

        /* JADX INFO: renamed from: C3.b$a$a, reason: collision with other inner class name */
        public static final class C0009a extends s implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f262b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0009a(b bVar, a aVar) {
                super(1);
                this.f261a = bVar;
                this.f262b = aVar;
            }

            public final void a(Throwable th) {
                this.f261a.c(this.f262b.f259b);
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return E.f5463a;
            }
        }

        /* JADX INFO: renamed from: C3.b$a$b, reason: collision with other inner class name */
        public static final class C0010b extends s implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f263a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f264b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0010b(b bVar, a aVar) {
                super(1);
                this.f263a = bVar;
                this.f264b = aVar;
            }

            public final void a(Throwable th) {
                b.f256i.set(this.f263a, this.f264b.f259b);
                this.f263a.c(this.f264b.f259b);
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return E.f5463a;
            }
        }

        public a(C1832p c1832p, Object obj) {
            this.f258a = c1832p;
            this.f259b = obj;
        }

        @Override // t3.InterfaceC1830o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void h(E e4, k kVar) {
            b.f256i.set(b.this, this.f259b);
            this.f258a.h(e4, new C0009a(b.this, this));
        }

        @Override // t3.b1
        public void b(C c4, int i4) {
            this.f258a.b(c4, i4);
        }

        @Override // t3.InterfaceC1830o
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void j(I i4, E e4) {
            this.f258a.j(i4, e4);
        }

        @Override // t3.InterfaceC1830o
        public boolean cancel(Throwable th) {
            return this.f258a.cancel(th);
        }

        @Override // t3.InterfaceC1830o
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Object o(E e4, Object obj, k kVar) {
            Object objO = this.f258a.o(e4, obj, new C0010b(b.this, this));
            if (objO != null) {
                b.f256i.set(b.this, this.f259b);
            }
            return objO;
        }

        @Override // t3.InterfaceC1830o
        public void g(k kVar) {
            this.f258a.g(kVar);
        }

        @Override // Z2.e
        public i getContext() {
            return this.f258a.getContext();
        }

        @Override // t3.InterfaceC1830o
        public Object i(Throwable th) {
            return this.f258a.i(th);
        }

        @Override // t3.InterfaceC1830o
        public boolean isCompleted() {
            return this.f258a.isCompleted();
        }

        @Override // t3.InterfaceC1830o
        public void p(Object obj) {
            this.f258a.p(obj);
        }

        @Override // Z2.e
        public void resumeWith(Object obj) {
            this.f258a.resumeWith(obj);
        }
    }

    /* JADX INFO: renamed from: C3.b$b, reason: collision with other inner class name */
    public static final class C0011b extends s implements p {

        /* JADX INFO: renamed from: C3.b$b$a */
        public static final class a extends s implements k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b f266a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f267b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(b bVar, Object obj) {
                super(1);
                this.f266a = bVar;
                this.f267b = obj;
            }

            public final void a(Throwable th) {
                this.f266a.c(this.f267b);
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((Throwable) obj);
                return E.f5463a;
            }
        }

        public C0011b() {
            super(3);
        }

        public final k a(B3.e eVar, Object obj, Object obj2) {
            return new a(b.this, obj);
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            android.support.v4.media.session.b.a(obj);
            return a(null, obj2, obj3);
        }
    }

    public b(boolean z4) {
        super(1, z4 ? 1 : 0);
        this.owner = z4 ? null : c.f268a;
        this.f257h = new C0011b();
    }

    public static /* synthetic */ Object p(b bVar, Object obj, Z2.e eVar) {
        if (bVar.a(obj)) {
            return E.f5463a;
        }
        Object objQ = bVar.q(obj, eVar);
        return objQ == AbstractC0787c.e() ? objQ : E.f5463a;
    }

    @Override // C3.a
    public boolean a(Object obj) {
        int iR = r(obj);
        if (iR == 0) {
            return true;
        }
        if (iR == 1) {
            return false;
        }
        if (iR != 2) {
            throw new IllegalStateException("unexpected");
        }
        throw new IllegalStateException(("This mutex is already locked by the specified owner: " + obj).toString());
    }

    @Override // C3.a
    public boolean b() {
        return i() == 0;
    }

    @Override // C3.a
    public void c(Object obj) {
        while (b()) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f256i;
            Object obj2 = atomicReferenceFieldUpdater.get(this);
            if (obj2 != c.f268a) {
                if (obj2 != obj && obj != null) {
                    throw new IllegalStateException(("This mutex is locked by " + obj2 + ", but " + obj + " is expected").toString());
                }
                if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj2, c.f268a)) {
                    j();
                    return;
                }
            }
        }
        throw new IllegalStateException("This mutex is not locked");
    }

    @Override // C3.a
    public Object d(Object obj, Z2.e eVar) {
        return p(this, obj, eVar);
    }

    public final int o(Object obj) {
        while (b()) {
            Object obj2 = f256i.get(this);
            if (obj2 != c.f268a) {
                return obj2 == obj ? 1 : 2;
            }
        }
        return 0;
    }

    public final Object q(Object obj, Z2.e eVar) {
        C1832p c1832pB = r.b(AbstractC0786b.c(eVar));
        try {
            e(new a(c1832pB, obj));
            Object objX = c1832pB.x();
            if (objX == AbstractC0787c.e()) {
                h.c(eVar);
            }
            return objX == AbstractC0787c.e() ? objX : E.f5463a;
        } catch (Throwable th) {
            c1832pB.I();
            throw th;
        }
    }

    public final int r(Object obj) {
        while (!k()) {
            if (obj == null) {
                return 1;
            }
            int iO = o(obj);
            if (iO == 1) {
                return 2;
            }
            if (iO == 2) {
                return 1;
            }
        }
        f256i.set(this, obj);
        return 0;
    }

    public String toString() {
        return "Mutex@" + P.b(this) + "[isLocked=" + b() + ",owner=" + f256i.get(this) + ']';
    }
}
