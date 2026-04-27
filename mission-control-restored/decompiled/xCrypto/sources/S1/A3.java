package S1;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class A3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f3843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ S3 f3844d;

    public A3(S3 s32, String str, String str2, String str3) {
        this.f3841a = str;
        this.f3842b = str2;
        this.f3843c = str3;
        Objects.requireNonNull(s32);
        this.f3844d = s32;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        S3 s32 = this.f3844d;
        s32.e0().D();
        return s32.e0().F0().J0(this.f3841a, this.f3842b, this.f3843c);
    }
}
