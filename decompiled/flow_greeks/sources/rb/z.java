package rb;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z extends y {
    @Override // rb.y
    public abstract v0 e();

    @Override // rb.v0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public z c(long j10, TimeUnit timeUnit) {
        e().c(j10, timeUnit);
        return g();
    }

    @Override // rb.v0
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public z d() {
        e().d();
        return g();
    }

    public final z g() {
        return this;
    }
}
