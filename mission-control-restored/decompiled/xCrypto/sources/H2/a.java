package H2;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dev.fluttercommunity.plus.share.a f715b;

    public a(d share, dev.fluttercommunity.plus.share.a manager) {
        r.f(share, "share");
        r.f(manager, "manager");
        this.f714a = share;
        this.f715b = manager;
    }

    public final void a(MethodCall methodCall) {
        if (!(methodCall.arguments instanceof Map)) {
            throw new IllegalArgumentException("Map arguments expected");
        }
    }

    public final void b(boolean z4, MethodChannel.Result result) {
        if (z4) {
            return;
        }
        result.success("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        r.f(call, "call");
        r.f(result, "result");
        a(call);
        this.f715b.c(result);
        try {
            if (!r.b(call.method, FirebaseAnalytics.Event.SHARE)) {
                result.notImplemented();
                return;
            }
            d dVar = this.f714a;
            Object objArguments = call.arguments();
            r.c(objArguments);
            dVar.p((Map) objArguments, true);
            b(true, result);
        } catch (Throwable th) {
            this.f715b.a();
            result.error("Share failed", th.getMessage(), th);
        }
    }
}
