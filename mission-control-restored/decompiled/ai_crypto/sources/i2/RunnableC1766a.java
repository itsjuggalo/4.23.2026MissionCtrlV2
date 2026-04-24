package i2;

import java.util.Objects;

/* JADX INFO: renamed from: i2.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1766a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f15487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f15488b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ F0 f15489c;

    public RunnableC1766a(F0 f02, String str, long j7) {
        this.f15487a = str;
        this.f15488b = j7;
        Objects.requireNonNull(f02);
        this.f15489c = f02;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15489c.l(this.f15487a, this.f15488b);
    }
}
