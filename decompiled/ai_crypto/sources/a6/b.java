package a6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6405a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ThreadLocal[] f6406b;

    static {
        ThreadLocal[] threadLocalArr = new ThreadLocal[4];
        for (int i7 = 0; i7 < 4; i7++) {
            threadLocalArr[i7] = new ThreadLocal();
        }
        f6406b = threadLocalArr;
    }

    public static final boolean a() {
        return f6405a;
    }
}
