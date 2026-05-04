package ce;

import ef.b;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f4026c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f4027d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f4028e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f4029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ q[] f4030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ jd.a f4031h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.b f4032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ef.f f4033b;

    static {
        b.a aVar = ef.b.f8779d;
        f4026c = new q("UBYTEARRAY", 0, b.a.b(aVar, "kotlin/UByteArray", false, 2, null));
        f4027d = new q("USHORTARRAY", 1, b.a.b(aVar, "kotlin/UShortArray", false, 2, null));
        f4028e = new q("UINTARRAY", 2, b.a.b(aVar, "kotlin/UIntArray", false, 2, null));
        f4029f = new q("ULONGARRAY", 3, b.a.b(aVar, "kotlin/ULongArray", false, 2, null));
        q[] qVarArrA = a();
        f4030g = qVarArrA;
        f4031h = jd.b.a(qVarArrA);
    }

    public q(String str, int i10, ef.b bVar) {
        this.f4032a = bVar;
        this.f4033b = bVar.h();
    }

    public static final /* synthetic */ q[] a() {
        return new q[]{f4026c, f4027d, f4028e, f4029f};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f4030g.clone();
    }

    public final ef.f b() {
        return this.f4033b;
    }
}
