package ng;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface m extends m2 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final pd.k f17157a;

        public a(pd.k kVar) {
            this.f17157a = kVar;
        }

        @Override // ng.m
        public void a(Throwable th) {
            this.f17157a.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + r0.a(this.f17157a) + '@' + r0.b(this) + ']';
        }
    }

    void a(Throwable th);
}
