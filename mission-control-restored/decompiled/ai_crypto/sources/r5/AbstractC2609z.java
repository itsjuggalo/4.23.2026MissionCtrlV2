package r5;

import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: r5.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2609z extends AbstractC2608y {
    @Override // r5.AbstractC2608y
    public abstract W e();

    @Override // r5.W
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public AbstractC2609z c(long j7, TimeUnit timeUnit) {
        e().c(j7, timeUnit);
        return g();
    }

    @Override // r5.W
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public AbstractC2609z d() {
        e().d();
        return g();
    }

    public final AbstractC2609z g() {
        return this;
    }
}
