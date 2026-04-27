package w4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final P f10982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ P[] f10983b;

    static {
        P p3 = new P("INSTANCE", 0);
        f10982a = p3;
        f10983b = new P[]{p3};
    }

    public static P valueOf(String str) {
        return (P) Enum.valueOf(P.class, str);
    }

    public static P[] values() {
        return (P[]) f10983b.clone();
    }
}
