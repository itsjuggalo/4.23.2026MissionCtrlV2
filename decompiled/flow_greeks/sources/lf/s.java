package lf;

import ce.o;
import fe.h0;
import fe.l1;
import xf.a2;
import xf.c1;
import xf.c2;
import xf.m2;
import xf.q1;
import xf.r0;
import xf.u0;
import xf.v0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f15674b = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final g a(r0 argumentType) {
            kotlin.jvm.internal.t.f(argumentType, "argumentType");
            if (v0.a(argumentType)) {
                return null;
            }
            r0 type = argumentType;
            int i10 = 0;
            while (ce.i.d0(type)) {
                type = ((a2) dd.a0.v0(type.L0())).getType();
                i10++;
            }
            fe.h hVarB = type.N0().b();
            if (hVarB instanceof fe.e) {
                ef.b bVarN = nf.e.n(hVarB);
                return bVarN == null ? new s(new b.a(argumentType)) : new s(bVarN, i10);
            }
            if (hVarB instanceof l1) {
                return new s(ef.b.f8779d.c(o.a.f3975b.m()), 0);
            }
            return null;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final r0 f15675a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(r0 type) {
                super(null);
                kotlin.jvm.internal.t.f(type, "type");
                this.f15675a = type;
            }

            public final r0 a() {
                return this.f15675a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof a) && kotlin.jvm.internal.t.b(this.f15675a, ((a) obj).f15675a);
            }

            public int hashCode() {
                return this.f15675a.hashCode();
            }

            public String toString() {
                return "LocalClass(type=" + this.f15675a + ')';
            }
        }

        /* JADX INFO: renamed from: lf.s$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0281b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final f f15676a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0281b(f value) {
                super(null);
                kotlin.jvm.internal.t.f(value, "value");
                this.f15676a = value;
            }

            public final int a() {
                return this.f15676a.c();
            }

            public final ef.b b() {
                return this.f15676a.d();
            }

            public final f c() {
                return this.f15676a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof C0281b) && kotlin.jvm.internal.t.b(this.f15676a, ((C0281b) obj).f15676a);
            }

            public int hashCode() {
                return this.f15676a.hashCode();
            }

            public String toString() {
                return "NormalClass(value=" + this.f15676a + ')';
            }
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public b() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(b value) {
        super(value);
        kotlin.jvm.internal.t.f(value, "value");
    }

    @Override // lf.g
    public r0 a(h0 module) {
        kotlin.jvm.internal.t.f(module, "module");
        q1 q1VarK = q1.f25042b.k();
        fe.e eVarF = module.p().F();
        kotlin.jvm.internal.t.e(eVarF, "getKClass(...)");
        return u0.h(q1VarK, eVarF, dd.q.e(new c2(c(module))));
    }

    public final r0 c(h0 module) {
        kotlin.jvm.internal.t.f(module, "module");
        b bVar = (b) b();
        if (bVar instanceof b.a) {
            return ((b.a) b()).a();
        }
        if (!(bVar instanceof b.C0281b)) {
            throw new cd.o();
        }
        f fVarC = ((b.C0281b) b()).c();
        ef.b bVarA = fVarC.a();
        int iB = fVarC.b();
        fe.e eVarB = fe.y.b(module, bVarA);
        if (eVarB == null) {
            return zf.l.d(zf.k.f26512h, bVarA.toString(), String.valueOf(iB));
        }
        c1 c1VarS = eVarB.s();
        kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
        r0 r0VarD = cg.d.D(c1VarS);
        for (int i10 = 0; i10 < iB; i10++) {
            r0VarD = module.p().m(m2.f25015e, r0VarD);
        }
        return r0VarD;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(f value) {
        this(new b.C0281b(value));
        kotlin.jvm.internal.t.f(value, "value");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(ef.b classId, int i10) {
        this(new f(classId, i10));
        kotlin.jvm.internal.t.f(classId, "classId");
    }
}
