package S1;

import java.util.Objects;

/* JADX INFO: renamed from: S1.u3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0689u3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f4964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f4965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ long f4966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ S3 f4967e;

    public RunnableC0689u3(S3 s32, String str, String str2, String str3, long j4) {
        this.f4963a = str;
        this.f4964b = str2;
        this.f4965c = str3;
        this.f4966d = j4;
        Objects.requireNonNull(s32);
        this.f4967e = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f4963a;
        if (str == null) {
            S3 s32 = this.f4967e;
            s32.e0().s0(this.f4964b, null);
        } else {
            C0628m5 c0628m5 = new C0628m5(this.f4965c, str, this.f4966d);
            S3 s33 = this.f4967e;
            s33.e0().s0(this.f4964b, c0628m5);
        }
    }
}
