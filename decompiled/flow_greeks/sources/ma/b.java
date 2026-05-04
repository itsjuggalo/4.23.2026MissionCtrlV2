package ma;

import com.google.firebase.messaging.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f16412b = new a().a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ma.a f16413a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ma.a f16414a = null;

        public b a() {
            return new b(this.f16414a);
        }

        public a b(ma.a aVar) {
            this.f16414a = aVar;
            return this;
        }
    }

    public b(ma.a aVar) {
        this.f16413a = aVar;
    }

    public static a b() {
        return new a();
    }

    public ma.a a() {
        return this.f16413a;
    }

    public byte[] c() {
        return n0.a(this);
    }
}
