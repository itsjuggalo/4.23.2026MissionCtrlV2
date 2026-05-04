package e8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        c doTransaction(m mVar);

        void onComplete(e8.c cVar, boolean z10, e8.b bVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f8527a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public r8.n f8528b;

        public r8.n a() {
            return this.f8528b;
        }

        public boolean b() {
            return this.f8527a;
        }

        public c(boolean z10, r8.n nVar) {
            this.f8527a = z10;
            this.f8528b = nVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static c a() {
        return new c(false, null);
    }

    public static c b(m mVar) {
        return new c(true, mVar.b());
    }
}
