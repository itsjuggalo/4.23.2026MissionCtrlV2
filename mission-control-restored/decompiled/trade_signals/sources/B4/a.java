package B4;

import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class a implements MethodChannel.MethodCallHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final dev.fluttercommunity.plus.share.a f161b;

    public a(d share, dev.fluttercommunity.plus.share.a manager) {
        AbstractC2304t.f(share, "share");
        AbstractC2304t.f(manager, "manager");
        this.f160a = share;
        this.f161b = manager;
    }

    public final void a(MethodCall methodCall) {
        if (!(methodCall.arguments instanceof Map)) {
            throw new IllegalArgumentException("Map arguments expected".toString());
        }
    }

    public final void b(boolean z7, MethodChannel.Result result) {
        if (z7) {
            return;
        }
        result.success("dev.fluttercommunity.plus/share/unavailable");
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        AbstractC2304t.f(call, "call");
        AbstractC2304t.f(result, "result");
        a(call);
        this.f161b.c(result);
        try {
            if (AbstractC2304t.b(call.method, FirebaseAnalytics.Event.SHARE)) {
                d dVar = this.f160a;
                Object objArguments = call.arguments();
                AbstractC2304t.c(objArguments);
                dVar.p((Map) objArguments, true);
                b(true, result);
            } else {
                result.notImplemented();
            }
        } catch (Throwable th) {
            this.f161b.a();
            result.error("Share failed", th.getMessage(), th);
        }
    }
}
