package d4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile boolean f7826a;

        public b() {
            super();
        }

        @Override // d4.c
        public void b(boolean z10) {
            this.f7826a = z10;
        }

        @Override // d4.c
        public void c() {
            if (this.f7826a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static c a() {
        return new b();
    }

    public abstract void b(boolean z10);

    public abstract void c();

    public c() {
    }
}
