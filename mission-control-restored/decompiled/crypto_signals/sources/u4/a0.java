package u4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0 f10376a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a0 f10377b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f10378c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ a0[] f10379d;

    static {
        a0 a0Var = new a0("UNARY", 0);
        f10376a = a0Var;
        a0 a0Var2 = new a0("CLIENT_STREAMING", 1);
        a0 a0Var3 = new a0("SERVER_STREAMING", 2);
        f10377b = a0Var3;
        a0 a0Var4 = new a0("BIDI_STREAMING", 3);
        f10378c = a0Var4;
        f10379d = new a0[]{a0Var, a0Var2, a0Var3, a0Var4, new a0("UNKNOWN", 4)};
    }

    public static a0 valueOf(String str) {
        return (a0) Enum.valueOf(a0.class, str);
    }

    public static a0[] values() {
        return (a0[]) f10379d.clone();
    }
}
