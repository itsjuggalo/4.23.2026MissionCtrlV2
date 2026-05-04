package pc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import pc.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends cc.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.n[] f18571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f18572b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements ic.e {
        public a() {
        }

        @Override // ic.e
        public Object apply(Object obj) {
            return kc.b.d(u.this.f18572b.apply(new Object[]{obj}), "The zipper returned a null value");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends AtomicInteger implements fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f18575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c[] f18576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object[] f18577d;

        public b(cc.l lVar, int i10, ic.e eVar) {
            super(i10);
            this.f18574a = lVar;
            this.f18575b = eVar;
            c[] cVarArr = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cVarArr[i11] = new c(this, i11);
            }
            this.f18576c = cVarArr;
            this.f18577d = new Object[i10];
        }

        public void a(int i10) {
            c[] cVarArr = this.f18576c;
            int length = cVarArr.length;
            for (int i11 = 0; i11 < i10; i11++) {
                cVarArr[i11].b();
            }
            while (true) {
                i10++;
                if (i10 >= length) {
                    return;
                } else {
                    cVarArr[i10].b();
                }
            }
        }

        public void b(int i10) {
            if (getAndSet(0) > 0) {
                a(i10);
                this.f18574a.onComplete();
            }
        }

        @Override // fc.b
        public boolean c() {
            return get() <= 0;
        }

        public void d(Throwable th, int i10) {
            if (getAndSet(0) <= 0) {
                yc.a.q(th);
            } else {
                a(i10);
                this.f18574a.onError(th);
            }
        }

        @Override // fc.b
        public void dispose() {
            if (getAndSet(0) > 0) {
                for (c cVar : this.f18576c) {
                    cVar.b();
                }
            }
        }

        public void e(Object obj, int i10) {
            this.f18577d[i10] = obj;
            if (decrementAndGet() == 0) {
                try {
                    this.f18574a.onSuccess(kc.b.d(this.f18575b.apply(this.f18577d), "The zipper returned a null value"));
                } catch (Throwable th) {
                    gc.b.b(th);
                    this.f18574a.onError(th);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends AtomicReference implements cc.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f18578a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18579b;

        public c(b bVar, int i10) {
            this.f18578a = bVar;
            this.f18579b = i10;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            jc.b.l(this, bVar);
        }

        public void b() {
            jc.b.a(this);
        }

        @Override // cc.l
        public void onComplete() {
            this.f18578a.b(this.f18579b);
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18578a.d(th, this.f18579b);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            this.f18578a.e(obj, this.f18579b);
        }
    }

    public u(cc.n[] nVarArr, ic.e eVar) {
        this.f18571a = nVarArr;
        this.f18572b = eVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        cc.n[] nVarArr = this.f18571a;
        int length = nVarArr.length;
        if (length == 1) {
            nVarArr[0].a(new n.a(lVar, new a()));
            return;
        }
        b bVar = new b(lVar, length, this.f18572b);
        lVar.a(bVar);
        for (int i10 = 0; i10 < length && !bVar.c(); i10++) {
            cc.n nVar = nVarArr[i10];
            if (nVar == null) {
                bVar.d(new NullPointerException("One of the sources is null"), i10);
                return;
            }
            nVar.a(bVar.f18576c[i10]);
        }
    }
}
