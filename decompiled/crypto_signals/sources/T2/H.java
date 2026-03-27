package T2;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final H f2917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H f2918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final H f2919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final H f2920d;
    public static final H e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ H[] f2921f;

    static {
        H h6 = new H("NoChange", 0);
        f2917a = h6;
        H h7 = new H("Added", 1);
        f2918b = h7;
        H h8 = new H("Removed", 2);
        f2919c = h8;
        H h9 = new H("Current", 3);
        f2920d = h9;
        H h10 = new H("Reset", 4);
        e = h10;
        f2921f = new H[]{h6, h7, h8, h9, h10};
    }

    public static H valueOf(String str) {
        return (H) Enum.valueOf(H.class, str);
    }

    public static H[] values() {
        return (H[]) f2921f.clone();
    }
}
