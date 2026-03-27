package S1;

import android.os.Bundle;
import java.util.Objects;

/* JADX INFO: renamed from: S1.n5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0636n5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Bundle f4776a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0628m5 f4777b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0628m5 f4778c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f4779d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0691u5 f4780e;

    public RunnableC0636n5(C0691u5 c0691u5, Bundle bundle, C0628m5 c0628m5, C0628m5 c0628m52, long j4) {
        this.f4776a = bundle;
        this.f4777b = c0628m5;
        this.f4778c = c0628m52;
        this.f4779d = j4;
        Objects.requireNonNull(c0691u5);
        this.f4780e = c0691u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4780e.A(this.f4776a, this.f4777b, this.f4778c, this.f4779d);
    }
}
