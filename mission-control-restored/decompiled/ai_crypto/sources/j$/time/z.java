package j$.time;

/* JADX INFO: loaded from: classes3.dex */
abstract /* synthetic */ class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f17302a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f17302a = iArr;
        try {
            iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17302a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
