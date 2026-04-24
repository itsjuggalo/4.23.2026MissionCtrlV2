package S1;

import android.util.Log;
import java.util.Objects;

/* JADX INFO: renamed from: S1.g4, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0579g4 implements InterfaceC0688u2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0658q3 f4637a;

    public C0579g4(C0587h4 c0587h4, C0658q3 c0658q3) {
        this.f4637a = c0658q3;
        Objects.requireNonNull(c0587h4);
    }

    @Override // S1.InterfaceC0688u2
    public final boolean zza() {
        return Log.isLoggable(this.f4637a.a().z(), 3);
    }
}
