package u4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f10408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g0 f10409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ g0[] f10410c;

    static {
        g0 g0Var = new g0("NONE", 0);
        f10408a = g0Var;
        g0 g0Var2 = new g0("INTEGRITY", 1);
        g0 g0Var3 = new g0("PRIVACY_AND_INTEGRITY", 2);
        f10409b = g0Var3;
        f10410c = new g0[]{g0Var, g0Var2, g0Var3};
    }

    public static g0 valueOf(String str) {
        return (g0) Enum.valueOf(g0.class, str);
    }

    public static g0[] values() {
        return (g0[]) f10410c.clone();
    }
}
