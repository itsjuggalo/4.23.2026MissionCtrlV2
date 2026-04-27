package O5;

import q6.b;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f6215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final q f6216d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final q f6217e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final q f6218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ q[] f6219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f6220h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q6.b f6221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q6.f f6222b;

    static {
        b.a aVar = q6.b.f22655d;
        f6215c = new q("UBYTEARRAY", 0, b.a.b(aVar, "kotlin/UByteArray", false, 2, null));
        f6216d = new q("USHORTARRAY", 1, b.a.b(aVar, "kotlin/UShortArray", false, 2, null));
        f6217e = new q("UINTARRAY", 2, b.a.b(aVar, "kotlin/UIntArray", false, 2, null));
        f6218f = new q("ULONGARRAY", 3, b.a.b(aVar, "kotlin/ULongArray", false, 2, null));
        q[] qVarArrA = a();
        f6219g = qVarArrA;
        f6220h = AbstractC2875b.a(qVarArrA);
    }

    public q(String str, int i8, q6.b bVar) {
        this.f6221a = bVar;
        this.f6222b = bVar.h();
    }

    public static final /* synthetic */ q[] a() {
        return new q[]{f6215c, f6216d, f6217e, f6218f};
    }

    public static q valueOf(String str) {
        return (q) Enum.valueOf(q.class, str);
    }

    public static q[] values() {
        return (q[]) f6219g.clone();
    }

    public final q6.f b() {
        return this.f6222b;
    }
}
