package O5;

import kotlin.jvm.internal.AbstractC2304t;
import q6.b;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f6223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final r f6224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final r f6225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final r f6226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ r[] f6227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f6228i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.b f6229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.f f6230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q6.b f6231c;

    static {
        b.a aVar = q6.b.f22655d;
        f6223d = new r("UBYTE", 0, b.a.b(aVar, "kotlin/UByte", false, 2, null));
        f6224e = new r("USHORT", 1, b.a.b(aVar, "kotlin/UShort", false, 2, null));
        f6225f = new r("UINT", 2, b.a.b(aVar, "kotlin/UInt", false, 2, null));
        f6226g = new r("ULONG", 3, b.a.b(aVar, "kotlin/ULong", false, 2, null));
        r[] rVarArrA = a();
        f6227h = rVarArrA;
        f6228i = AbstractC2875b.a(rVarArrA);
    }

    public r(String str, int i8, q6.b bVar) {
        this.f6229a = bVar;
        q6.f fVarH = bVar.h();
        this.f6230b = fVarH;
        q6.c cVarF = bVar.f();
        q6.f fVarL = q6.f.l(fVarH.b() + "Array");
        AbstractC2304t.e(fVarL, "identifier(...)");
        this.f6231c = new q6.b(cVarF, fVarL);
    }

    public static final /* synthetic */ r[] a() {
        return new r[]{f6223d, f6224e, f6225f, f6226g};
    }

    public static r valueOf(String str) {
        return (r) Enum.valueOf(r.class, str);
    }

    public static r[] values() {
        return (r[]) f6227h.clone();
    }

    public final q6.b b() {
        return this.f6231c;
    }

    public final q6.b g() {
        return this.f6229a;
    }

    public final q6.f i() {
        return this.f6230b;
    }
}
