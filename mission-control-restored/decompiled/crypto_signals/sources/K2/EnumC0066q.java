package K2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: renamed from: K2.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class EnumC0066q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EnumC0066q f962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EnumC0066q f963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EnumC0066q f964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final EnumC0066q f965d;
    public static final /* synthetic */ EnumC0066q[] e;

    static {
        EnumC0066q enumC0066q = new EnumC0066q("NONE", 0);
        f962a = enumC0066q;
        EnumC0066q enumC0066q2 = new EnumC0066q("ESTIMATE", 1);
        f963b = enumC0066q2;
        EnumC0066q enumC0066q3 = new EnumC0066q("PREVIOUS", 2);
        f964c = enumC0066q3;
        e = new EnumC0066q[]{enumC0066q, enumC0066q2, enumC0066q3};
        f965d = enumC0066q;
    }

    public static EnumC0066q valueOf(String str) {
        return (EnumC0066q) Enum.valueOf(EnumC0066q.class, str);
    }

    public static EnumC0066q[] values() {
        return (EnumC0066q[]) e.clone();
    }
}
