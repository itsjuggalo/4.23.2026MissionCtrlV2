package x3;

import W2.E;
import X2.x;
import a3.AbstractC0787c;
import java.util.ArrayList;
import t3.L;
import t3.M;
import t3.N;
import t3.P;
import v3.t;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2.i f15757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f15758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v3.a f15759c;

    public static final class a extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w3.e f15762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f15763d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w3.e eVar, e eVar2, Z2.e eVar3) {
            super(2, eVar3);
            this.f15762c = eVar;
            this.f15763d = eVar2;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = new a(this.f15762c, this.f15763d, eVar);
            aVar.f15761b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f15760a;
            if (i4 == 0) {
                W2.q.b(obj);
                L l4 = (L) this.f15761b;
                w3.e eVar = this.f15762c;
                t tVarI = this.f15763d.i(l4);
                this.f15760a = 1;
                if (w3.f.h(eVar, tVarI, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((a) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public static final class b extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15765b;

        public b(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            b bVar = e.this.new b(eVar);
            bVar.f15765b = obj;
            return bVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f15764a;
            if (i4 == 0) {
                W2.q.b(obj);
                v3.s sVar = (v3.s) this.f15765b;
                e eVar = e.this;
                this.f15764a = 1;
                if (eVar.e(sVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(v3.s sVar, Z2.e eVar) {
            return ((b) create(sVar, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public e(Z2.i iVar, int i4, v3.a aVar) {
        this.f15757a = iVar;
        this.f15758b = i4;
        this.f15759c = aVar;
    }

    public static /* synthetic */ Object d(e eVar, w3.e eVar2, Z2.e eVar3) {
        Object objE = M.e(new a(eVar2, eVar, null), eVar3);
        return objE == AbstractC0787c.e() ? objE : E.f5463a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // x3.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public w3.d b(Z2.i r2, int r3, v3.a r4) {
        /*
            r1 = this;
            Z2.i r0 = r1.f15757a
            Z2.i r2 = r2.plus(r0)
            v3.a r0 = v3.a.SUSPEND
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.f15758b
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
            v3.a r4 = r1.f15759c
        L25:
            Z2.i r0 = r1.f15757a
            boolean r0 = kotlin.jvm.internal.r.b(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.f15758b
            if (r3 != r0) goto L36
            v3.a r0 = r1.f15759c
            if (r4 != r0) goto L36
            return r1
        L36:
            x3.e r2 = r1.f(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.e.b(Z2.i, int, v3.a):w3.d");
    }

    public String c() {
        return null;
    }

    @Override // w3.d
    public Object collect(w3.e eVar, Z2.e eVar2) {
        return d(this, eVar, eVar2);
    }

    public abstract Object e(v3.s sVar, Z2.e eVar);

    public abstract e f(Z2.i iVar, int i4, v3.a aVar);

    public final i3.o g() {
        return new b(null);
    }

    public final int h() {
        int i4 = this.f15758b;
        if (i4 == -3) {
            return -2;
        }
        return i4;
    }

    public t i(L l4) {
        return v3.q.c(l4, this.f15757a, h(), this.f15759c, N.ATOMIC, null, g(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strC = c();
        if (strC != null) {
            arrayList.add(strC);
        }
        if (this.f15757a != Z2.j.f6012a) {
            arrayList.add("context=" + this.f15757a);
        }
        if (this.f15758b != -3) {
            arrayList.add("capacity=" + this.f15758b);
        }
        if (this.f15759c != v3.a.SUSPEND) {
            arrayList.add("onBufferOverflow=" + this.f15759c);
        }
        return P.a(this) + '[' + x.Q(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
