package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.q5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0660q5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ long f4886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0691u5 f4887b;

    public RunnableC0660q5(C0691u5 c0691u5, long j4) {
        this.f4886a = j4;
        Objects.requireNonNull(c0691u5);
        this.f4887b = c0691u5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0691u5 c0691u5 = this.f4887b;
        c0691u5.f4245a.M().k(this.f4886a);
        c0691u5.f4972e = null;
    }
}
