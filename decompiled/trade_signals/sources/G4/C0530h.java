package G4;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: G4.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0530h implements InterfaceC0527f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f2805a = new AtomicLong();

    @Override // G4.InterfaceC0527f0
    public void a(long j8) {
        this.f2805a.getAndAdd(j8);
    }
}
