package io.flutter.plugins.webviewflutter;

import W2.p;
import X2.AbstractC0769p;
import android.webkit.WebResourceRequest;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiWebResourceRequest {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public PigeonApiWebResourceRequest(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        kotlin.jvm.internal.r.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pigeon_newInstance$lambda$0(i3.k kVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            p.a aVar = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str)))));
            return;
        }
        List list = (List) obj;
        if (list.size() <= 1) {
            p.a aVar2 = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.E.f5463a)));
            return;
        }
        p.a aVar3 = W2.p.f5487b;
        Object obj2 = list.get(0);
        kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = list.get(1);
        kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
        kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2))))));
    }

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public abstract boolean hasGesture(WebResourceRequest webResourceRequest);

    public abstract boolean isForMainFrame(WebResourceRequest webResourceRequest);

    public abstract boolean isRedirect(WebResourceRequest webResourceRequest);

    public abstract String method(WebResourceRequest webResourceRequest);

    public final void pigeon_newInstance(WebResourceRequest pigeon_instanceArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
            return;
        }
        if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            p.a aVar2 = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.E.f5463a)));
            return;
        }
        long jAddHostCreatedInstance = getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg);
        String strUrl = url(pigeon_instanceArg);
        boolean zIsForMainFrame = isForMainFrame(pigeon_instanceArg);
        boolean zIsRedirect = isRedirect(pigeon_instanceArg);
        boolean zHasGesture = hasGesture(pigeon_instanceArg);
        final String str = "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance";
        new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(Long.valueOf(jAddHostCreatedInstance), strUrl, Boolean.valueOf(zIsForMainFrame), Boolean.valueOf(zIsRedirect), Boolean.valueOf(zHasGesture), method(pigeon_instanceArg), requestHeaders(pigeon_instanceArg)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.q1
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                PigeonApiWebResourceRequest.pigeon_newInstance$lambda$0(callback, str, obj);
            }
        });
    }

    public abstract Map<String, String> requestHeaders(WebResourceRequest webResourceRequest);

    public abstract String url(WebResourceRequest webResourceRequest);
}
