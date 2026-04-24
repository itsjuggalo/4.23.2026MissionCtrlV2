package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.t4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0682t4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4945b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f4946c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f4947d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0540b5 f4948e;

    public RunnableC0682t4(C0540b5 c0540b5, String str, String str2, Object obj, long j4) {
        this.f4944a = str;
        this.f4945b = str2;
        this.f4946c = obj;
        this.f4947d = j4;
        Objects.requireNonNull(c0540b5);
        this.f4948e = c0540b5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4948e.B(this.f4944a, this.f4945b, this.f4946c, this.f4947d);
    }
}
