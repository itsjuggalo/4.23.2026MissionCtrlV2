package K2;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: K2.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0377z extends AbstractC0376y {
    @Override // K2.AbstractC0376y
    public abstract W e();

    @Override // K2.W
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC0377z c(long j4, TimeUnit timeUnit) {
        e().c(j4, timeUnit);
        return g();
    }

    @Override // K2.W
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC0377z d() {
        e().d();
        return g();
    }

    public final AbstractC0377z g() {
        return this;
    }
}
