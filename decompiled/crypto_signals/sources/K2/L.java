package K2;

/* JADX INFO: loaded from: classes.dex */
public final class L {
    public V e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f857f = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f853a = "firestore.googleapis.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f854b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f855c = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f856d = 104857600;

    public final M a() {
        if (this.f854b || !this.f853a.equals("firestore.googleapis.com")) {
            return new M(this);
        }
        throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
    }

    public final void b(V v2) {
        if (this.f857f) {
            throw new IllegalStateException("Deprecated setPersistenceEnabled() or setCacheSizeBytes() is already used, remove those first.");
        }
        if (!(v2 instanceof W) && !(v2 instanceof Y)) {
            throw new IllegalArgumentException("Only MemoryCacheSettings and PersistentCacheSettings are accepted");
        }
        this.e = v2;
    }
}
