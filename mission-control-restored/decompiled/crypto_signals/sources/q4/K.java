package q4;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p0.p f9315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final K f9316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final K f9317d;
    public static final K e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ K[] f9318f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9319a;

    static {
        K k6 = new K("PLATFORM_ENCODED", 0, 0);
        f9316c = k6;
        K k7 = new K("JSON_ENCODED", 1, 1);
        f9317d = k7;
        K k8 = new K("UNEXPECTED_STRING", 2, 2);
        e = k8;
        K[] kArr = {k6, k7, k8};
        f9318f = kArr;
        s3.D.H(kArr);
        f9315b = new p0.p();
    }

    public K(String str, int i, int i6) {
        this.f9319a = i6;
    }

    public static K valueOf(String str) {
        return (K) Enum.valueOf(K.class, str);
    }

    public static K[] values() {
        return (K[]) f9318f.clone();
    }
}
