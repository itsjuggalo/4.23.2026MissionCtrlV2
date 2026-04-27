package i2;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: renamed from: i2.n5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC1876n5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f15935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1868m5 f15936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C1868m5 f15937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f15938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C1932u5 f15939e;

    public RunnableC1876n5(C1932u5 c1932u5, Bundle bundle, C1868m5 c1868m5, C1868m5 c1868m52, long j7) {
        this.f15935a = bundle;
        this.f15936b = c1868m5;
        this.f15937c = c1868m52;
        this.f15938d = j7;
        Objects.requireNonNull(c1932u5);
        this.f15939e = c1932u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f15939e.A(this.f15935a, this.f15936b, this.f15937c, this.f15938d);
    }
}
