package R0;

/* JADX INFO: renamed from: R0.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0832p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f7015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f7016b;

    /* JADX INFO: renamed from: R0.p$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7018b;

        public a() {
        }

        public C0832p a() {
            if (!this.f7017a) {
                throw new IllegalArgumentException("Pending purchases for one-time products must be supported.");
            }
            return new C0832p(true, this.f7018b);
        }

        public a b() {
            this.f7017a = true;
            return this;
        }

        public a c() {
            this.f7018b = true;
            return this;
        }
    }

    public C0832p(boolean z7, boolean z8) {
        this.f7015a = z7;
        this.f7016b = z8;
    }

    public static a c() {
        return new a();
    }

    public boolean a() {
        return this.f7015a;
    }

    public boolean b() {
        return this.f7016b;
    }
}
