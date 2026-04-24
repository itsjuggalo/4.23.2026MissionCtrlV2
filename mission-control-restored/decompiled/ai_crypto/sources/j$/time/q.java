package j$.time;

/* JADX INFO: loaded from: classes3.dex */
abstract /* synthetic */ class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f17250a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f17250a = iArr;
        try {
            iArr[j$.time.temporal.a.INSTANT_SECONDS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17250a[j$.time.temporal.a.OFFSET_SECONDS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
