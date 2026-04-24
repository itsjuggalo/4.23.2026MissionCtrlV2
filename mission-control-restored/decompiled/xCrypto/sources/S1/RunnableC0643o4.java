package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.o4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0643o4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4817a;

    public RunnableC0643o4(C0540b5 c0540b5) {
        Objects.requireNonNull(c0540b5);
        this.f4817a = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4817a.f4369r.a();
    }
}
