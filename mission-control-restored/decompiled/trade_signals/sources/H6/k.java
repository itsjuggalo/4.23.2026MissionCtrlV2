package H6;

/* JADX INFO: loaded from: classes2.dex */
public interface k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4004a = a.f4005a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4005a = new a();

        public final d a(Runnable runnable, B5.k kVar) {
            return (runnable == null || kVar == null) ? new d(null, 1, null) : new c(runnable, kVar);
        }
    }

    void lock();

    void unlock();
}
