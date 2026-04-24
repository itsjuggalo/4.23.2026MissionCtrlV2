package j$.time;

/* JADX INFO: loaded from: classes3.dex */
abstract /* synthetic */ class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f17247a;

    static {
        int[] iArr = new int[j$.time.temporal.a.values().length];
        f17247a = iArr;
        try {
            iArr[j$.time.temporal.a.DAY_OF_MONTH.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f17247a[j$.time.temporal.a.MONTH_OF_YEAR.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
    }
}
