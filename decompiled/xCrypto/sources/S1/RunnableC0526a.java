package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0526a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f4329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ F0 f4330c;

    public RunnableC0526a(F0 f02, String str, long j4) {
        this.f4328a = str;
        this.f4329b = j4;
        Objects.requireNonNull(f02);
        this.f4330c = f02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4330c.l(this.f4328a, this.f4329b);
    }
}
