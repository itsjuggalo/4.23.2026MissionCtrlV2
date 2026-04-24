package M6;

import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f5432a = new b("FOR_SUBTYPING", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f5433b = new b("FOR_INCORPORATION", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f5434c = new b("FROM_EXPRESSION", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ b[] f5435d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ InterfaceC2874a f5436e;

    static {
        b[] bVarArrA = a();
        f5435d = bVarArrA;
        f5436e = AbstractC2875b.a(bVarArrA);
    }

    public b(String str, int i8) {
    }

    public static final /* synthetic */ b[] a() {
        return new b[]{f5432a, f5433b, f5434c};
    }

    public static b valueOf(String str) {
        return (b) Enum.valueOf(b.class, str);
    }

    public static b[] values() {
        return (b[]) f5435d.clone();
    }
}
