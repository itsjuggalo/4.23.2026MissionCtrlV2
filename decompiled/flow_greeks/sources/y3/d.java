package y3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f25221a;

        a(boolean z10) {
            this.f25221a = z10;
        }

        public boolean b() {
            return this.f25221a;
        }
    }

    void a(c cVar);

    boolean b();

    boolean c(c cVar);

    boolean e(c cVar);

    boolean f(c cVar);

    d getRoot();

    void j(c cVar);
}
