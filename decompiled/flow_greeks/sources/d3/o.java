package d3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7725a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7726b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7728b;

        public a() {
        }

        public o a() {
            if (!this.f7727a) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new o(true, this.f7728b);
        }

        public a b() {
            this.f7727a = true;
            return this;
        }

        public a c() {
            this.f7728b = true;
            return this;
        }
    }

    public o(boolean z10, boolean z11) {
        this.f7725a = z10;
        this.f7726b = z11;
    }

    public static a c() {
        return new a();
    }

    public boolean a() {
        return this.f7725a;
    }

    public boolean b() {
        return this.f7726b;
    }
}
