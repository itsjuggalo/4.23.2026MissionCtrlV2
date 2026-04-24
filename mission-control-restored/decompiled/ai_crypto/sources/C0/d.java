package C0;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    DEX_FILES(0),
    EXTRA_DESCRIPTORS(1),
    CLASSES(2),
    METHODS(3),
    AGGREGATION_COUNT(4);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f881a;

    d(long j7) {
        this.f881a = j7;
    }

    public long b() {
        return this.f881a;
    }
}
