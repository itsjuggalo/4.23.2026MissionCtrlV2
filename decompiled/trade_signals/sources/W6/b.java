package W6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f9311a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal[] f9312b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i8 = 0; i8 < 4; i8++) {
            threadLocalArr[i8] = new ThreadLocal();
        }
        f9312b = threadLocalArr;
    }

    public static final boolean a() {
        return f9311a;
    }
}
