package S1;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: S1.r3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC0665r3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ S3 f4899b;

    public CallableC0665r3(S3 s32, String str) {
        this.f4898a = str;
        Objects.requireNonNull(s32);
        this.f4899b = s32;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        S3 s32 = this.f4899b;
        s32.e0().D();
        return s32.e0().F0().E0(this.f4898a);
    }
}
