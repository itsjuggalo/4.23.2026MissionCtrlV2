package S1;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class A4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f3845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3847c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f3848d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f3849e;

    public A4(C0540b5 c0540b5, AtomicReference atomicReference, String str, String str2, String str3, boolean z4) {
        this.f3845a = atomicReference;
        this.f3846b = str2;
        this.f3847c = str3;
        this.f3848d = z4;
        Objects.requireNonNull(c0540b5);
        this.f3849e = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3849e.f4245a.J().g0(this.f3845a, null, this.f3846b, this.f3847c, this.f3848d);
    }
}
