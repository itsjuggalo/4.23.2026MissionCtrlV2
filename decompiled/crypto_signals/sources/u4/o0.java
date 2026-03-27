package u4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o0 f10468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o0 f10469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ o0[] f10470c;

    /* JADX INFO: Fake field, exist only in values array */
    o0 EF0;

    static {
        o0 o0Var = new o0("FAKE", 0);
        o0 o0Var2 = new o0("MTLS", 1);
        f10468a = o0Var2;
        o0 o0Var3 = new o0("CUSTOM_MANAGERS", 2);
        f10469b = o0Var3;
        f10470c = new o0[]{o0Var, o0Var2, o0Var3};
    }

    public static o0 valueOf(String str) {
        return (o0) Enum.valueOf(o0.class, str);
    }

    public static o0[] values() {
        return (o0[]) f10470c.clone();
    }
}
