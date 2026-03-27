package S1;

import android.os.Bundle;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public final class J3 implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n7 f4056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bundle f4057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ S3 f4058c;

    public J3(S3 s32, n7 n7Var, Bundle bundle) {
        this.f4056a = n7Var;
        this.f4057b = bundle;
        Objects.requireNonNull(s32);
        this.f4058c = s32;
    }

    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() {
        S3 s32 = this.f4058c;
        s32.e0().D();
        return s32.e0().p0(this.f4056a, this.f4057b);
    }
}
