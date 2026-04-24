package io.flutter.plugins.webviewflutter;

import W2.p;
import X2.AbstractC0768o;
import android.webkit.CookieManager;
import android.webkit.WebView;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.PigeonApiCookieManager;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiCookieManager {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiCookieManager pigeonApiCookieManager, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiCookieManager.getPigeonRegistrar().getInstanceManager().addDartCreatedInstance(pigeonApiCookieManager.instance(), ((Long) obj2).longValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiCookieManager pigeonApiCookieManager, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.CookieManager");
            CookieManager cookieManager = (CookieManager) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type kotlin.String");
            try {
                pigeonApiCookieManager.setCookie(cookieManager, str, (String) obj4);
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$6$lambda$5(PigeonApiCookieManager pigeonApiCookieManager, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.CookieManager");
            pigeonApiCookieManager.removeAllCookies((CookieManager) obj2, new i3.k() { // from class: io.flutter.plugins.webviewflutter.Z
                @Override // i3.k
                public final Object invoke(Object obj3) {
                    return PigeonApiCookieManager.Companion.setUpMessageHandlers$lambda$6$lambda$5$lambda$4(reply, (W2.p) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final W2.E setUpMessageHandlers$lambda$6$lambda$5$lambda$4(BasicMessageChannel.Reply reply, W2.p pVar) {
            Throwable thE = W2.p.e(pVar.j());
            if (thE != null) {
                reply.reply(AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = pVar.j();
                if (W2.p.g(objJ)) {
                    objJ = null;
                }
                reply.reply(AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapResult((Boolean) objJ));
            }
            return W2.E.f5463a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$8$lambda$7(PigeonApiCookieManager pigeonApiCookieManager, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.CookieManager");
            CookieManager cookieManager = (CookieManager) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type android.webkit.WebView");
            WebView webView = (WebView) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiCookieManager.setAcceptThirdPartyCookies(cookieManager, webView, ((Boolean) obj4).booleanValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiCookieManager pigeonApiCookieManager) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiCookieManager == null || (pigeonRegistrar = pigeonApiCookieManager.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManager.instance", androidWebkitLibraryPigeonCodec);
            if (pigeonApiCookieManager != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.a0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiCookieManager.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiCookieManager, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManager.setCookie", androidWebkitLibraryPigeonCodec);
            if (pigeonApiCookieManager != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.b0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiCookieManager.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiCookieManager, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManager.removeAllCookies", androidWebkitLibraryPigeonCodec);
            if (pigeonApiCookieManager != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.c0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiCookieManager.Companion.setUpMessageHandlers$lambda$6$lambda$5(pigeonApiCookieManager, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.CookieManager.setAcceptThirdPartyCookies", androidWebkitLibraryPigeonCodec);
            if (pigeonApiCookieManager != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.d0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiCookieManager.Companion.setUpMessageHandlers$lambda$8$lambda$7(pigeonApiCookieManager, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
        }

        private Companion() {
        }
    }

    public PigeonApiCookieManager(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
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

    public abstract CookieManager instance();

    public final void pigeon_newInstance(CookieManager pigeon_instanceArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            p.a aVar2 = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.E.f5463a)));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.CookieManager.pigeon_newInstance";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.CookieManager.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(AbstractC0768o.b(Long.valueOf(getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg))), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.Y
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiCookieManager.pigeon_newInstance$lambda$0(callback, str, obj);
                }
            });
        }
    }

    public abstract void removeAllCookies(CookieManager cookieManager, i3.k kVar);

    public abstract void setAcceptThirdPartyCookies(CookieManager cookieManager, WebView webView, boolean z4);

    public abstract void setCookie(CookieManager cookieManager, String str, String str2);
}
