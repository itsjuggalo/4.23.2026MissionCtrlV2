package s3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f14684a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal[] f14685b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i4 = 0; i4 < 4; i4++) {
            threadLocalArr[i4] = new ThreadLocal();
        }
        f14685b = threadLocalArr;
    }

    public static final boolean a() {
        return f14684a;
    }
}
