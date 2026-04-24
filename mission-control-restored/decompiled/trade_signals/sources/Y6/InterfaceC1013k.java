package Y6;

/* JADX INFO: renamed from: Y6.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC1013k extends H0 {

    /* JADX INFO: renamed from: Y6.k$a */
    public static final class a implements InterfaceC1013k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final B5.k f9675a;

        public a(B5.k kVar) {
            this.f9675a = kVar;
        }

        @Override // Y6.InterfaceC1013k
        public void a(Throwable th) {
            this.f9675a.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + P.a(this.f9675a) + '@' + P.b(this) + ']';
        }
    }

    void a(Throwable th);
}
