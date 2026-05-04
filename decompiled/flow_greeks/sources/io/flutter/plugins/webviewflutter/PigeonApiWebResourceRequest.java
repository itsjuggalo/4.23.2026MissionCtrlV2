package io.flutter.plugins.webviewflutter;

import android.webkit.WebResourceRequest;
import cd.r;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugin.common.BasicMessageChannel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0011\u0010\nJ%\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00122\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0013\u0010\u0014J/\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00062\u0018\u0010\u0019\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u0017\u0012\u0004\u0012\u00020\u00180\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lio/flutter/plugins/webviewflutter/PigeonApiWebResourceRequest;", "", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "pigeonRegistrar", "<init>", "(Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;)V", "Landroid/webkit/WebResourceRequest;", "pigeon_instance", "", "url", "(Landroid/webkit/WebResourceRequest;)Ljava/lang/String;", "", "isForMainFrame", "(Landroid/webkit/WebResourceRequest;)Z", "isRedirect", "(Landroid/webkit/WebResourceRequest;)Ljava/lang/Boolean;", "hasGesture", FirebaseAnalytics.Param.METHOD, "", "requestHeaders", "(Landroid/webkit/WebResourceRequest;)Ljava/util/Map;", "pigeon_instanceArg", "Lkotlin/Function1;", "Lcd/r;", "Lcd/h0;", "callback", "pigeon_newInstance", "(Landroid/webkit/WebResourceRequest;Lpd/k;)V", "Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "getPigeonRegistrar", "()Lio/flutter/plugins/webviewflutter/AndroidWebkitLibraryPigeonProxyApiRegistrar;", "webview_flutter_android_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class PigeonApiWebResourceRequest {
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public PigeonApiWebResourceRequest(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        kotlin.jvm.internal.t.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pigeon_newInstance$lambda$0(pd.k kVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(cd.s.a(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str)))));
            return;
        }
        List list = (List) obj;
        if (list.size() <= 1) {
            r.a aVar2 = r.f3870b;
            kVar.invoke(r.a(r.b(cd.h0.f3852a)));
            return;
        }
        r.a aVar3 = r.f3870b;
        Object obj2 = list.get(0);
        kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = list.get(1);
        kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.String");
        kVar.invoke(r.a(r.b(cd.s.a(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2))))));
    }

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public abstract boolean hasGesture(WebResourceRequest pigeon_instance);

    public abstract boolean isForMainFrame(WebResourceRequest pigeon_instance);

    public abstract Boolean isRedirect(WebResourceRequest pigeon_instance);

    public abstract String method(WebResourceRequest pigeon_instance);

    public final void pigeon_newInstance(WebResourceRequest pigeon_instanceArg, final pd.k callback) {
        kotlin.jvm.internal.t.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.t.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            r.a aVar = r.f3870b;
            callback.invoke(r.a(r.b(cd.s.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
            return;
        }
        if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            r.a aVar2 = r.f3870b;
            callback.invoke(r.a(r.b(cd.h0.f3852a)));
            return;
        }
        long jAddHostCreatedInstance = getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg);
        String strUrl = url(pigeon_instanceArg);
        boolean zIsForMainFrame = isForMainFrame(pigeon_instanceArg);
        Boolean boolIsRedirect = isRedirect(pigeon_instanceArg);
        boolean zHasGesture = hasGesture(pigeon_instanceArg);
        final String str = "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance";
        new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebResourceRequest.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(dd.r.n(Long.valueOf(jAddHostCreatedInstance), strUrl, Boolean.valueOf(zIsForMainFrame), boolIsRedirect, Boolean.valueOf(zHasGesture), method(pigeon_instanceArg), requestHeaders(pigeon_instanceArg)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.r3
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                PigeonApiWebResourceRequest.pigeon_newInstance$lambda$0(callback, str, obj);
            }
        });
    }

    public abstract Map<String, String> requestHeaders(WebResourceRequest pigeon_instance);

    public abstract String url(WebResourceRequest pigeon_instance);
}
