package S1;

import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: S1.y3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class CallableC0721y3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f5056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f5057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f5058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ S3 f5059d;

    public CallableC0721y3(S3 s32, String str, String str2, String str3) {
        this.f5056a = str;
        this.f5057b = str2;
        this.f5058c = str3;
        Objects.requireNonNull(s32);
        this.f5059d = s32;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        S3 s32 = this.f5059d;
        s32.e0().D();
        return s32.e0().F0().F0(this.f5056a, this.f5057b, this.f5058c);
    }
}
