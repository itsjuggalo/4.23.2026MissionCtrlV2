package w4;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: w4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1328e implements B0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f11243a;

    public C1328e(int i) {
        switch (i) {
            case 1:
                this.f11243a = new AtomicLong();
                break;
            default:
                this.f11243a = new AtomicLong();
                break;
        }
    }

    @Override // w4.B0
    public void a() {
        this.f11243a.getAndAdd(1L);
    }
}
