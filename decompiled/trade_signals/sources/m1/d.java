package m1;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f21288a;

        a(boolean z7) {
            this.f21288a = z7;
        }

        public boolean b() {
            return this.f21288a;
        }
    }

    boolean a();

    void b(c cVar);

    d c();

    boolean e(c cVar);

    boolean f(c cVar);

    boolean h(c cVar);

    void k(c cVar);
}
