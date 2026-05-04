package pb;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f18487a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dev.fluttercommunity.plus.share.a f18488b;

    public a(d share, dev.fluttercommunity.plus.share.a manager) {
        t.f(share, "share");
        t.f(manager, "manager");
        this.f18487a = share;
        this.f18488b = manager;
    }

    public final void a(MethodCall methodCall) {
        if (!(methodCall.arguments instanceof Map)) {
            throw new IllegalArgumentException("Map arguments expected");
        }
    }

    public final void b(boolean z10, MethodChannel.Result result) {
        if (z10) {
            return;
        }
        result.success("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        t.f(call, "call");
        t.f(result, "result");
        a(call);
        this.f18488b.c(result);
        try {
            if (!t.b(call.method, FirebaseAnalytics.Event.SHARE)) {
                result.notImplemented();
                return;
            }
            d dVar = this.f18487a;
            Object objArguments = call.arguments();
            t.c(objArguments);
            dVar.p((Map) objArguments, true);
            b(true, result);
        } catch (Throwable th) {
            this.f18488b.a();
            result.error("Share failed", th.getMessage(), th);
        }
    }
}
