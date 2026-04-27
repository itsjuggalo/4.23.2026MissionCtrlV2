package f6;

import E5.E;
import F5.v;
import b6.L;
import b6.M;
import b6.N;
import b6.P;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H5.g f14191a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14192b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d6.a f14193c;

    public static final class a extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e6.e f14196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f14197d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e6.e eVar, e eVar2, H5.d dVar) {
            super(2, dVar);
            this.f14196c = eVar;
            this.f14197d = eVar2;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            a aVar = new a(this.f14196c, this.f14197d, dVar);
            aVar.f14195b = obj;
            return aVar;
        }

        @Override // Q5.o
        public final Object invoke(L l7, H5.d dVar) {
            return ((a) create(l7, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f14194a;
            if (i7 == 0) {
                E5.q.b(obj);
                L l7 = (L) this.f14195b;
                e6.e eVar = this.f14196c;
                d6.s sVarJ = this.f14197d.j(l7);
                this.f14194a = 1;
                if (e6.f.h(eVar, sVarJ, this) == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
            }
            return E.f1657a;
        }
    }

    public static final class b extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14198a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14199b;

        public b(H5.d dVar) {
            super(2, dVar);
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            b bVar = e.this.new b(dVar);
            bVar.f14199b = obj;
            return bVar;
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(d6.r rVar, H5.d dVar) {
            return ((b) create(rVar, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f14198a;
            if (i7 == 0) {
                E5.q.b(obj);
                d6.r rVar = (d6.r) this.f14199b;
                e eVar = e.this;
                this.f14198a = 1;
                if (eVar.f(rVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
            }
            return E.f1657a;
        }
    }

    public e(H5.g gVar, int i7, d6.a aVar) {
        this.f14191a = gVar;
        this.f14192b = i7;
        this.f14193c = aVar;
    }

    public static /* synthetic */ Object e(e eVar, e6.e eVar2, H5.d dVar) {
        Object objC = M.c(new a(eVar2, eVar, null), dVar);
        return objC == I5.c.e() ? objC : E.f1657a;
    }

    @Override // e6.d
    public Object b(e6.e eVar, H5.d dVar) {
        return e(this, eVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // f6.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e6.d c(H5.g r2, int r3, d6.a r4) {
        /*
            r1 = this;
            H5.g r0 = r1.f14191a
            H5.g r2 = r2.plus(r0)
            d6.a r0 = d6.a.SUSPEND
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.f14192b
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r3 = r3 + r4
            if (r3 < 0) goto L20
            goto L23
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            d6.a r4 = r1.f14193c
        L25:
            H5.g r0 = r1.f14191a
            boolean r0 = kotlin.jvm.internal.r.b(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.f14192b
            if (r3 != r0) goto L36
            d6.a r0 = r1.f14193c
            if (r4 != r0) goto L36
            return r1
        L36:
            f6.e r2 = r1.g(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.e.c(H5.g, int, d6.a):e6.d");
    }

    public String d() {
        return null;
    }

    public abstract Object f(d6.r rVar, H5.d dVar);

    public abstract e g(H5.g gVar, int i7, d6.a aVar);

    public final Q5.o h() {
        return new b(null);
    }

    public final int i() {
        int i7 = this.f14192b;
        if (i7 == -3) {
            return -2;
        }
        return i7;
    }

    public d6.s j(L l7) {
        return d6.p.c(l7, this.f14191a, i(), this.f14193c, N.ATOMIC, null, h(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strD = d();
        if (strD != null) {
            arrayList.add(strD);
        }
        if (this.f14191a != H5.h.f2671a) {
            arrayList.add("context=" + this.f14191a);
        }
        if (this.f14192b != -3) {
            arrayList.add("capacity=" + this.f14192b);
        }
        if (this.f14193c != d6.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f14193c);
        }
        return P.a(this) + '[' + v.R(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
