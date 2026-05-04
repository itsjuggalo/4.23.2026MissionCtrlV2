package rg;

import cd.h0;
import dd.a0;
import java.util.ArrayList;
import ng.n0;
import ng.o0;
import ng.p0;
import ng.r0;
import pg.v;
import pg.w;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd.i f19886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19887b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pg.a f19888c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ qg.e f19891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f19892d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qg.e eVar, e eVar2, gd.e eVar3) {
            super(2, eVar3);
            this.f19891c = eVar;
            this.f19892d = eVar2;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = new a(this.f19891c, this.f19892d, eVar);
            aVar.f19890b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f19889a;
            if (i10 == 0) {
                cd.s.b(obj);
                n0 n0Var = (n0) this.f19890b;
                qg.e eVar = this.f19891c;
                w wVarI = this.f19892d.i(n0Var);
                this.f19889a = 1;
                if (qg.f.i(eVar, wVarI, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((a) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19894b;

        public b(gd.e eVar) {
            super(2, eVar);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(v vVar, gd.e eVar) {
            return ((b) create(vVar, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            b bVar = e.this.new b(eVar);
            bVar.f19894b = obj;
            return bVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f19893a;
            if (i10 == 0) {
                cd.s.b(obj);
                v vVar = (v) this.f19894b;
                e eVar = e.this;
                this.f19893a = 1;
                if (eVar.e(vVar, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }
    }

    public e(gd.i iVar, int i10, pg.a aVar) {
        this.f19886a = iVar;
        this.f19887b = i10;
        this.f19888c = aVar;
    }

    public static /* synthetic */ Object d(e eVar, qg.e eVar2, gd.e eVar3) {
        Object objC = o0.c(new a(eVar2, eVar, null), eVar3);
        return objC == hd.c.f() ? objC : h0.f3852a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // rg.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public qg.d a(gd.i r2, int r3, pg.a r4) {
        /*
            r1 = this;
            gd.i r0 = r1.f19886a
            gd.i r2 = r2.plus(r0)
            pg.a r0 = pg.a.f18621a
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.f19887b
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
            pg.a r4 = r1.f19888c
        L25:
            gd.i r0 = r1.f19886a
            boolean r0 = kotlin.jvm.internal.t.b(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.f19887b
            if (r3 != r0) goto L36
            pg.a r0 = r1.f19888c
            if (r4 != r0) goto L36
            return r1
        L36:
            rg.e r2 = r1.f(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: rg.e.a(gd.i, int, pg.a):qg.d");
    }

    public String c() {
        return null;
    }

    @Override // qg.d
    public Object collect(qg.e eVar, gd.e eVar2) {
        return d(this, eVar, eVar2);
    }

    public abstract Object e(v vVar, gd.e eVar);

    public abstract e f(gd.i iVar, int i10, pg.a aVar);

    public final pd.o g() {
        return new b(null);
    }

    public final int h() {
        int i10 = this.f19887b;
        if (i10 == -3) {
            return -2;
        }
        return i10;
    }

    public w i(n0 n0Var) {
        return pg.t.c(n0Var, this.f19886a, h(), this.f19888c, p0.f17169c, null, g(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strC = c();
        if (strC != null) {
            arrayList.add(strC);
        }
        if (this.f19886a != gd.j.f10531a) {
            arrayList.add("context=" + this.f19886a);
        }
        if (this.f19887b != -3) {
            arrayList.add("capacity=" + this.f19887b);
        }
        if (this.f19888c != pg.a.f18621a) {
            arrayList.add("onBufferOverflow=" + this.f19888c);
        }
        return r0.a(this) + '[' + a0.i0(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
