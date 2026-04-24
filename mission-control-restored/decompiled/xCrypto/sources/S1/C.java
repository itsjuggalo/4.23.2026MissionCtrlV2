package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class C implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ F0 f3876c;

    public C(F0 f02, String str, long j4) {
        this.f3874a = str;
        this.f3875b = j4;
        Objects.requireNonNull(f02);
        this.f3876c = f02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3876c.m(this.f3874a, this.f3875b);
    }
}
