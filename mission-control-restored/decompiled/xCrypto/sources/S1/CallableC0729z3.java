package S1;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: S1.z3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC0729z3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5083c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ S3 f5084d;

    public CallableC0729z3(S3 s32, String str, String str2, String str3) {
        this.f5081a = str;
        this.f5082b = str2;
        this.f5083c = str3;
        Objects.requireNonNull(s32);
        this.f5084d = s32;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        S3 s32 = this.f5084d;
        s32.e0().D();
        return s32.e0().F0().J0(this.f5081a, this.f5082b, this.f5083c);
    }
}
