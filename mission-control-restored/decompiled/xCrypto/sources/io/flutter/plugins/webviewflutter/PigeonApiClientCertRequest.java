package io.flutter.plugins.webviewflutter;

import W2.p;
import X2.AbstractC0768o;
import android.webkit.ClientCertRequest;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.PigeonApiClientCertRequest;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiClientCertRequest {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiClientCertRequest pigeonApiClientCertRequest, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
            try {
                pigeonApiClientCertRequest.cancel((ClientCertRequest) obj2);
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiClientCertRequest pigeonApiClientCertRequest, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
            try {
                pigeonApiClientCertRequest.ignore((ClientCertRequest) obj2);
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$5$lambda$4(PigeonApiClientCertRequest pigeonApiClientCertRequest, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.ClientCertRequest");
            ClientCertRequest clientCertRequest = (ClientCertRequest) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type java.security.PrivateKey");
            PrivateKey privateKey = (PrivateKey) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type kotlin.collections.List<java.security.cert.X509Certificate>");
            try {
                pigeonApiClientCertRequest.proceed(clientCertRequest, privateKey, (List) obj4);
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiClientCertRequest pigeonApiClientCertRequest) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiClientCertRequest == null || (pigeonRegistrar = pigeonApiClientCertRequest.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.cancel", androidWebkitLibraryPigeonCodec);
            if (pigeonApiClientCertRequest != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.U
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiClientCertRequest.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiClientCertRequest, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.ignore", androidWebkitLibraryPigeonCodec);
            if (pigeonApiClientCertRequest != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.V
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiClientCertRequest.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiClientCertRequest, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.proceed", androidWebkitLibraryPigeonCodec);
            if (pigeonApiClientCertRequest != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.W
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiClientCertRequest.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiClientCertRequest, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
        }

        private Companion() {
        }
    }

    public PigeonApiClientCertRequest(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
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

    public abstract void cancel(ClientCertRequest clientCertRequest);

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public abstract void ignore(ClientCertRequest clientCertRequest);

    public final void pigeon_newInstance(ClientCertRequest pigeon_instanceArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            p.a aVar2 = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.E.f5463a)));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.pigeon_newInstance";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.ClientCertRequest.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(AbstractC0768o.b(Long.valueOf(getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg))), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.T
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiClientCertRequest.pigeon_newInstance$lambda$0(callback, str, obj);
                }
            });
        }
    }

    public abstract void proceed(ClientCertRequest clientCertRequest, PrivateKey privateKey, List<? extends X509Certificate> list);
}
