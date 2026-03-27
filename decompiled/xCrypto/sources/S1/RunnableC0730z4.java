package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: S1.z4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0730z4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f5085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f5088d;

    public RunnableC0730z4(C0540b5 c0540b5, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f5085a = atomicReference;
        this.f5086b = str2;
        this.f5087c = str3;
        Objects.requireNonNull(c0540b5);
        this.f5088d = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5088d.f4245a.J().e0(this.f5085a, null, this.f5086b, this.f5087c);
    }
}
