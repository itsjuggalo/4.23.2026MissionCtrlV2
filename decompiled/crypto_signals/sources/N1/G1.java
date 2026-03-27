package N1;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class G1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final G1 f1251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final G1 f1252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ G1[] f1253c;

    static {
        G1 g12 = new G1("CONSENT", 0);
        f1251a = g12;
        G1 g13 = new G1("LEGITIMATE_INTEREST", 1);
        G1 g14 = new G1("FLEXIBLE_CONSENT", 2);
        G1 g15 = new G1("FLEXIBLE_LEGITIMATE_INTEREST", 3);
        f1252b = g15;
        f1253c = new G1[]{g12, g13, g14, g15};
    }

    public static G1[] values() {
        return (G1[]) f1253c.clone();
    }
}
