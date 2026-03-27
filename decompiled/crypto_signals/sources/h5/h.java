package h5;

import a5.W;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class h extends W {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f6687c;

    @Override // a5.AbstractC0317y
    public final void g(I4.i iVar, Runnable runnable) {
        c cVar = this.f6687c;
        AtomicLongFieldUpdater atomicLongFieldUpdater = c.f6673l;
        cVar.f(runnable, false);
    }
}
