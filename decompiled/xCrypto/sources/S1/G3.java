package S1;

import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class G3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3966a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S3 f3968c;

    public G3(S3 s32, J j4, String str) {
        this.f3966a = j4;
        this.f3967b = str;
        Objects.requireNonNull(s32);
        this.f3968c = s32;
    }

    @Override // java.lang.Runnable
    public final void run() {
        S3 s32 = this.f3968c;
        s32.e0().D();
        s32.e0().i(this.f3966a, this.f3967b);
    }
}
