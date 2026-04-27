package s3;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class K0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final K0 f9583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final K0 f9584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final K0 f9585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final K0 f9586d;
    public static final K0 e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ K0[] f9587f;

    static {
        K0 k02 = new K0("UPDATE", 0);
        f9583a = k02;
        K0 k03 = new K0("DELETE", 1);
        f9584b = k03;
        K0 k04 = new K0("VERIFY", 2);
        f9585c = k04;
        K0 k05 = new K0("TRANSFORM", 3);
        f9586d = k05;
        K0 k06 = new K0("OPERATION_NOT_SET", 4);
        e = k06;
        f9587f = new K0[]{k02, k03, k04, k05, k06};
    }

    public static K0 valueOf(String str) {
        return (K0) Enum.valueOf(K0.class, str);
    }

    public static K0[] values() {
        return (K0[]) f9587f.clone();
    }
}
