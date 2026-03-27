package b0;

/* JADX INFO: renamed from: b0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0375d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4819b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f4820c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4821d = -1;
    public long e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f4822f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ C0376e f4824h;

    public C0375d(C0376e c0376e, boolean z6) {
        this.f4824h = c0376e;
        this.f4818a = z6;
    }

    public final void a() {
        if (this.f4823g) {
            return;
        }
        long j4 = this.f4821d;
        C0376e c0376e = this.f4824h;
        if (j4 < 0) {
            long j6 = this.f4819b;
            if (j6 >= 0 && this.f4820c >= j6) {
                long j7 = this.e;
                if (j7 < 0) {
                    c0376e.f4831c.post(new A.b(this, 15));
                    this.f4823g = true;
                    return;
                }
                this.f4821d = j7;
            }
        }
        long j8 = this.f4821d;
        if (j8 < 0 || j8 > this.f4822f) {
            return;
        }
        c0376e.f4831c.post(new A.b(this, 15));
        this.f4823g = true;
    }

    public final synchronized boolean b(long j4, long j6) {
        boolean z6;
        try {
            long j7 = this.f4819b;
            z6 = j7 < 0 || j4 <= j7;
            if (z6) {
                this.e = j6;
            }
            this.f4820c = j4;
            a();
        } catch (Throwable th) {
            throw th;
        }
        return z6;
    }
}
