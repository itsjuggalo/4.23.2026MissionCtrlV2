package io.flutter.plugins.webviewflutter;

import W2.p;
import X2.AbstractC0768o;
import X2.AbstractC0769p;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.PigeonApiWebChromeClient;
import io.flutter.plugins.webviewflutter.WebChromeClientProxyApi;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiWebChromeClient {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            try {
                pigeonApiWebChromeClient.getPigeonRegistrar().getInstanceManager().addDartCreatedInstance(pigeonApiWebChromeClient.pigeon_defaultConstructor(), ((Long) obj2).longValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$11$lambda$10(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnJsPrompt(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnShowFileChooser(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$5$lambda$4(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnConsoleMessage(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$7$lambda$6(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnJsAlert(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$9$lambda$8(PigeonApiWebChromeClient pigeonApiWebChromeClient, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.webviewflutter.WebChromeClientProxyApi.WebChromeClientImpl");
            WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl = (WebChromeClientProxyApi.WebChromeClientImpl) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            try {
                pigeonApiWebChromeClient.setSynchronousReturnValueForOnJsConfirm(webChromeClientImpl, ((Boolean) obj3).booleanValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiWebChromeClient pigeonApiWebChromeClient) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiWebChromeClient == null || (pigeonRegistrar = pigeonApiWebChromeClient.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.pigeon_defaultConstructor", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebChromeClient != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.i1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiWebChromeClient, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnShowFileChooser", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebChromeClient != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.j1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiWebChromeClient, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnConsoleMessage", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebChromeClient != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.k1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiWebChromeClient, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsAlert", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebChromeClient != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.l1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$7$lambda$6(pigeonApiWebChromeClient, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsConfirm", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebChromeClient != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.m1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$9$lambda$8(pigeonApiWebChromeClient, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.setSynchronousReturnValueForOnJsPrompt", androidWebkitLibraryPigeonCodec);
            if (pigeonApiWebChromeClient != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.n1
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiWebChromeClient.Companion.setUpMessageHandlers$lambda$11$lambda$10(pigeonApiWebChromeClient, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
        }

        private Companion() {
        }
    }

    public PigeonApiWebChromeClient(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        kotlin.jvm.internal.r.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConsoleMessage$lambda$7(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGeolocationPermissionsHidePrompt$lambda$6(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGeolocationPermissionsShowPrompt$lambda$5(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onHideCustomView$lambda$4(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onJsAlert$lambda$8(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onJsConfirm$lambda$9(i3.k kVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            p.a aVar = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str)))));
            return;
        }
        List list = (List) obj;
        if (list.size() > 1) {
            p.a aVar2 = W2.p.f5487b;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2))))));
            return;
        }
        if (list.get(0) == null) {
            p.a aVar3 = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("null-error", "Flutter api returned null value for non-null return value.", "")))));
            return;
        }
        Object obj4 = list.get(0);
        kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type kotlin.Boolean");
        Boolean bool = (Boolean) obj4;
        bool.booleanValue();
        kVar.invoke(W2.p.a(W2.p.b(bool)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onJsPrompt$lambda$10(i3.k kVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            p.a aVar = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str)))));
            return;
        }
        List list = (List) obj;
        if (list.size() <= 1) {
            kVar.invoke(W2.p.a(W2.p.b((String) list.get(0))));
            return;
        }
        p.a aVar2 = W2.p.f5487b;
        Object obj2 = list.get(0);
        kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = list.get(1);
        kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
        kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2))))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onPermissionRequest$lambda$2(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onProgressChanged$lambda$0(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShowCustomView$lambda$3(i3.k kVar, String str, Object obj) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onShowFileChooser$lambda$1(i3.k kVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            p.a aVar = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str)))));
            return;
        }
        List list = (List) obj;
        if (list.size() > 1) {
            p.a aVar2 = W2.p.f5487b;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2))))));
            return;
        }
        if (list.get(0) == null) {
            p.a aVar3 = W2.p.f5487b;
            kVar.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("null-error", "Flutter api returned null value for non-null return value.", "")))));
        } else {
            Object obj4 = list.get(0);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            kVar.invoke(W2.p.a(W2.p.b((List) obj4)));
        }
    }

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public final void onConsoleMessage(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, ConsoleMessage messageArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(messageArg, "messageArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onConsoleMessage", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, messageArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.e1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onConsoleMessage$lambda$7(callback, str, obj);
                }
            });
        }
    }

    public final void onGeolocationPermissionsHidePrompt(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsHidePrompt", getPigeonRegistrar().getCodec()).send(AbstractC0768o.b(pigeon_instanceArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.h1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onGeolocationPermissionsHidePrompt$lambda$6(callback, str, obj);
                }
            });
        }
    }

    public final void onGeolocationPermissionsShowPrompt(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, String originArg, GeolocationPermissions.Callback callbackArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(originArg, "originArg");
        kotlin.jvm.internal.r.f(callbackArg, "callbackArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onGeolocationPermissionsShowPrompt", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, originArg, callbackArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.f1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onGeolocationPermissionsShowPrompt$lambda$5(callback, str, obj);
                }
            });
        }
    }

    public final void onHideCustomView(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onHideCustomView", getPigeonRegistrar().getCodec()).send(AbstractC0768o.b(pigeon_instanceArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.X0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onHideCustomView$lambda$4(callback, str, obj);
                }
            });
        }
    }

    public final void onJsAlert(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, String urlArg, String messageArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(webViewArg, "webViewArg");
        kotlin.jvm.internal.r.f(urlArg, "urlArg");
        kotlin.jvm.internal.r.f(messageArg, "messageArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsAlert", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, webViewArg, urlArg, messageArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.a1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onJsAlert$lambda$8(callback, str, obj);
                }
            });
        }
    }

    public final void onJsConfirm(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, String urlArg, String messageArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(webViewArg, "webViewArg");
        kotlin.jvm.internal.r.f(urlArg, "urlArg");
        kotlin.jvm.internal.r.f(messageArg, "messageArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsConfirm", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, webViewArg, urlArg, messageArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.g1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onJsConfirm$lambda$9(callback, str, obj);
                }
            });
        }
    }

    public final void onJsPrompt(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, String urlArg, String messageArg, String defaultValueArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(webViewArg, "webViewArg");
        kotlin.jvm.internal.r.f(urlArg, "urlArg");
        kotlin.jvm.internal.r.f(messageArg, "messageArg");
        kotlin.jvm.internal.r.f(defaultValueArg, "defaultValueArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onJsPrompt", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, webViewArg, urlArg, messageArg, defaultValueArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.Z0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onJsPrompt$lambda$10(callback, str, obj);
                }
            });
        }
    }

    public final void onPermissionRequest(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, PermissionRequest requestArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(requestArg, "requestArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onPermissionRequest", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, requestArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.c1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onPermissionRequest$lambda$2(callback, str, obj);
                }
            });
        }
    }

    public final void onProgressChanged(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, long j4, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(webViewArg, "webViewArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onProgressChanged", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, webViewArg, Long.valueOf(j4)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.Y0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onProgressChanged$lambda$0(callback, str, obj);
                }
            });
        }
    }

    public final void onShowCustomView(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, View viewArg, WebChromeClient.CustomViewCallback callbackArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(viewArg, "viewArg");
        kotlin.jvm.internal.r.f(callbackArg, "callbackArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowCustomView", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, viewArg, callbackArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.d1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onShowCustomView$lambda$3(callback, str, obj);
                }
            });
        }
    }

    public final void onShowFileChooser(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, WebView webViewArg, WebChromeClient.FileChooserParams paramsArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(webViewArg, "webViewArg");
        kotlin.jvm.internal.r.f(paramsArg, "paramsArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.WebChromeClient.onShowFileChooser", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, webViewArg, paramsArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.b1
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiWebChromeClient.onShowFileChooser$lambda$1(callback, str, obj);
                }
            });
        }
    }

    public abstract WebChromeClientProxyApi.WebChromeClientImpl pigeon_defaultConstructor();

    public final void pigeon_newInstance(WebChromeClientProxyApi.WebChromeClientImpl pigeon_instanceArg, i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            p.a aVar2 = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.E.f5463a)));
        } else {
            p.a aVar3 = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("new-instance-error", "Attempting to create a new Dart instance of WebChromeClient, but the class has a nonnull callback method.", "")))));
        }
    }

    public abstract void setSynchronousReturnValueForOnConsoleMessage(WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl, boolean z4);

    public abstract void setSynchronousReturnValueForOnJsAlert(WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl, boolean z4);

    public abstract void setSynchronousReturnValueForOnJsConfirm(WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl, boolean z4);

    public abstract void setSynchronousReturnValueForOnJsPrompt(WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl, boolean z4);

    public abstract void setSynchronousReturnValueForOnShowFileChooser(WebChromeClientProxyApi.WebChromeClientImpl webChromeClientImpl, boolean z4);
}
