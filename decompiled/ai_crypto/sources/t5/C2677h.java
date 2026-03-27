package t5;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: t5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2677h implements InterfaceC2674f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f23768a = new AtomicLong();

    @Override // t5.InterfaceC2674f0
    public void a(long j7) {
        this.f23768a.getAndAdd(j7);
    }
}
