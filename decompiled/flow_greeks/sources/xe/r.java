package xe;

import fe.h1;
import gf.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements vf.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final of.d f24905b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final of.d f24906c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final tf.y f24907d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24908e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final vf.r f24909f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final x f24910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f24911h;

    public r(of.d className, of.d dVar, ze.l packageProto, bf.c nameResolver, tf.y yVar, boolean z10, vf.r abiStability, x xVar) {
        String string;
        kotlin.jvm.internal.t.f(className, "className");
        kotlin.jvm.internal.t.f(packageProto, "packageProto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(abiStability, "abiStability");
        this.f24905b = className;
        this.f24906c = dVar;
        this.f24907d = yVar;
        this.f24908e = z10;
        this.f24909f = abiStability;
        this.f24910g = xVar;
        i.f packageModuleName = cf.a.f4062m;
        kotlin.jvm.internal.t.e(packageModuleName, "packageModuleName");
        Integer num = (Integer) bf.e.a(packageProto, packageModuleName);
        this.f24911h = (num == null || (string = nameResolver.getString(num.intValue())) == null) ? "main" : string;
    }

    @Override // fe.g1
    public h1 a() {
        h1 NO_SOURCE_FILE = h1.f9484a;
        kotlin.jvm.internal.t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
        return NO_SOURCE_FILE;
    }

    @Override // vf.s
    public String c() {
        return "Class '" + d().a().a() + '\'';
    }

    public final ef.b d() {
        ef.c cVarG = e().g();
        kotlin.jvm.internal.t.e(cVarG, "getPackageFqName(...)");
        return new ef.b(cVarG, h());
    }

    public of.d e() {
        return this.f24905b;
    }

    public of.d f() {
        return this.f24906c;
    }

    public final x g() {
        return this.f24910g;
    }

    public final ef.f h() {
        String strF = e().f();
        kotlin.jvm.internal.t.e(strF, "getInternalName(...)");
        ef.f fVarK = ef.f.k(kg.c0.S0(strF, '/', null, 2, null));
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        return fVarK;
    }

    public String toString() {
        return r.class.getSimpleName() + ": " + e();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public r(x kotlinClass, ze.l packageProto, bf.c nameResolver, tf.y yVar, boolean z10, vf.r abiStability) {
        kotlin.jvm.internal.t.f(kotlinClass, "kotlinClass");
        kotlin.jvm.internal.t.f(packageProto, "packageProto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(abiStability, "abiStability");
        of.d dVarB = of.d.b(kotlinClass.g());
        kotlin.jvm.internal.t.e(dVarB, "byClassId(...)");
        String strE = kotlinClass.b().e();
        of.d dVarD = null;
        if (strE != null && strE.length() > 0) {
            dVarD = of.d.d(strE);
        }
        this(dVarB, dVarD, packageProto, nameResolver, yVar, z10, abiStability, kotlinClass);
    }
}
