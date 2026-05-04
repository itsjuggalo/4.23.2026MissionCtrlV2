package ce;

import ef.b;
import kotlin.jvm.internal.t;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f4034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r f4035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r f4036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r f4037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ r[] f4038h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ jd.a f4039i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.b f4040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.f f4041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ef.b f4042c;

    static {
        b.a aVar = ef.b.f8779d;
        f4034d = new r("UBYTE", 0, b.a.b(aVar, "kotlin/UByte", false, 2, null));
        f4035e = new r("USHORT", 1, b.a.b(aVar, "kotlin/UShort", false, 2, null));
        f4036f = new r("UINT", 2, b.a.b(aVar, "kotlin/UInt", false, 2, null));
        f4037g = new r("ULONG", 3, b.a.b(aVar, "kotlin/ULong", false, 2, null));
        r[] rVarArrA = a();
        f4038h = rVarArrA;
        f4039i = jd.b.a(rVarArrA);
    }

    public r(String str, int i10, ef.b bVar) {
        this.f4040a = bVar;
        ef.f fVarH = bVar.h();
        this.f4041b = fVarH;
        ef.c cVarF = bVar.f();
        ef.f fVarK = ef.f.k(fVarH.b() + "Array");
        t.e(fVarK, "identifier(...)");
        this.f4042c = new ef.b(cVarF, fVarK);
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{f4034d, f4035e, f4036f, f4037g};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f4038h.clone();
    }

    public final ef.b b() {
        return this.f4042c;
    }

    public final ef.b c() {
        return this.f4040a;
    }

    public final ef.f h() {
        return this.f4041b;
    }
}
