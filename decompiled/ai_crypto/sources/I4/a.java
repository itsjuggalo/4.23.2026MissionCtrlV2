package I4;

import V4.i;
import V4.j;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements j.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f3031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final dev.fluttercommunity.plus.share.a f3032d;

    public a(d share, dev.fluttercommunity.plus.share.a manager) {
        r.f(share, "share");
        r.f(manager, "manager");
        this.f3031c = share;
        this.f3032d = manager;
    }

    public final void a(i iVar) {
        if (!(iVar.f5333b instanceof Map)) {
            throw new IllegalArgumentException("Map arguments expected");
        }
    }

    public final void b(boolean z7, j.d dVar) {
        if (z7) {
            return;
        }
        dVar.a("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // V4.j.c
    public void onMethodCall(i call, j.d result) {
        r.f(call, "call");
        r.f(result, "result");
        a(call);
        this.f3032d.c(result);
        try {
            if (r.b(call.f5332a, "share")) {
                d dVar = this.f3031c;
                Object objB = call.b();
                r.c(objB);
                dVar.p((Map) objB, true);
                b(true, result);
            } else {
                result.c();
            }
        } catch (Throwable th) {
            this.f3032d.a();
            result.b("Share failed", th.getMessage(), th);
        }
    }
}
