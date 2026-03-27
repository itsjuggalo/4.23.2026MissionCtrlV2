package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1966z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V3 f16230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC1741A f16231b;

    public RunnableC1966z(AbstractC1741A abstractC1741A, V3 v32) {
        this.f16230a = v32;
        Objects.requireNonNull(abstractC1741A);
        this.f16231b = abstractC1741A;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V3 v32 = this.f16230a;
        v32.c();
        if (C1806f.a()) {
            v32.b().t(this);
            return;
        }
        AbstractC1741A abstractC1741A = this.f16231b;
        boolean zC = abstractC1741A.c();
        abstractC1741A.e(0L);
        if (zC) {
            abstractC1741A.a();
        }
    }
}
