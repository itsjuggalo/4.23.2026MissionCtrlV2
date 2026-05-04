package tf;

import fe.g1;
import ze.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bf.c f22014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bf.g f22015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g1 f22016c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends n0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ze.c f22017d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a f22018e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ef.b f22019f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final c.EnumC0494c f22020g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f22021h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f22022i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ze.c classProto, bf.c nameResolver, bf.g typeTable, g1 g1Var, a aVar) {
            super(nameResolver, typeTable, g1Var, null);
            kotlin.jvm.internal.t.f(classProto, "classProto");
            kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.t.f(typeTable, "typeTable");
            this.f22017d = classProto;
            this.f22018e = aVar;
            this.f22019f = l0.a(nameResolver, classProto.E0());
            c.EnumC0494c enumC0494c = (c.EnumC0494c) bf.b.f3320f.d(classProto.D0());
            this.f22020g = enumC0494c == null ? c.EnumC0494c.CLASS : enumC0494c;
            Boolean boolD = bf.b.f3321g.d(classProto.D0());
            kotlin.jvm.internal.t.e(boolD, "get(...)");
            this.f22021h = boolD.booleanValue();
            Boolean boolD2 = bf.b.f3322h.d(classProto.D0());
            kotlin.jvm.internal.t.e(boolD2, "get(...)");
            this.f22022i = boolD2.booleanValue();
        }

        @Override // tf.n0
        public ef.c a() {
            return this.f22019f.a();
        }

        public final ef.b e() {
            return this.f22019f;
        }

        public final ze.c f() {
            return this.f22017d;
        }

        public final c.EnumC0494c g() {
            return this.f22020g;
        }

        public final a h() {
            return this.f22018e;
        }

        public final boolean i() {
            return this.f22021h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends n0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ef.c f22023d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ef.c fqName, bf.c nameResolver, bf.g typeTable, g1 g1Var) {
            super(nameResolver, typeTable, g1Var, null);
            kotlin.jvm.internal.t.f(fqName, "fqName");
            kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
            kotlin.jvm.internal.t.f(typeTable, "typeTable");
            this.f22023d = fqName;
        }

        @Override // tf.n0
        public ef.c a() {
            return this.f22023d;
        }
    }

    public /* synthetic */ n0(bf.c cVar, bf.g gVar, g1 g1Var, kotlin.jvm.internal.k kVar) {
        this(cVar, gVar, g1Var);
    }

    public abstract ef.c a();

    public final bf.c b() {
        return this.f22014a;
    }

    public final g1 c() {
        return this.f22016c;
    }

    public final bf.g d() {
        return this.f22015b;
    }

    public String toString() {
        return getClass().getSimpleName() + ": " + a();
    }

    public n0(bf.c cVar, bf.g gVar, g1 g1Var) {
        this.f22014a = cVar;
        this.f22015b = gVar;
        this.f22016c = g1Var;
    }
}
