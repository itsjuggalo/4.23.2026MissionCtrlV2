package M2;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: M2.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0422h implements InterfaceC0419f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f2217a = new AtomicLong();

    @Override // M2.InterfaceC0419f0
    public void add(long j4) {
        this.f2217a.getAndAdd(j4);
    }
}
