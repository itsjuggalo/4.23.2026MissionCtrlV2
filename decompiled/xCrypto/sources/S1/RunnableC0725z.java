package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.z, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0725z implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ V3 f5071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ A f5072b;

    public RunnableC0725z(A a4, V3 v32) {
        this.f5071a = v32;
        Objects.requireNonNull(a4);
        this.f5072b = a4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        V3 v32 = this.f5071a;
        v32.c();
        if (C0566f.a()) {
            v32.b().t(this);
            return;
        }
        A a4 = this.f5072b;
        boolean zC = a4.c();
        a4.e(0L);
        if (zC) {
            a4.a();
        }
    }
}
