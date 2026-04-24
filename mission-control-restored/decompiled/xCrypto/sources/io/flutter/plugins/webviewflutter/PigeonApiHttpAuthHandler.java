package io.flutter.plugins.webviewflutter;

import W2.p;
import X2.AbstractC0768o;
import android.webkit.HttpAuthHandler;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.PigeonApiHttpAuthHandler;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiHttpAuthHandler {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiHttpAuthHandler pigeonApiHttpAuthHandler, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
            try {
                listWrapError = AbstractC0768o.b(Boolean.valueOf(pigeonApiHttpAuthHandler.useHttpAuthUsernamePassword((HttpAuthHandler) obj2)));
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(PigeonApiHttpAuthHandler pigeonApiHttpAuthHandler, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
            try {
                pigeonApiHttpAuthHandler.cancel((HttpAuthHandler) obj2);
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$5$lambda$4(PigeonApiHttpAuthHandler pigeonApiHttpAuthHandler, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type android.webkit.HttpAuthHandler");
            HttpAuthHandler httpAuthHandler = (HttpAuthHandler) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
            String str = (String) obj3;
            Object obj4 = list.get(2);
            kotlin.jvm.internal.r.d(obj4, "null cannot be cast to non-null type kotlin.String");
            try {
                pigeonApiHttpAuthHandler.proceed(httpAuthHandler, str, (String) obj4);
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiHttpAuthHandler pigeonApiHttpAuthHandler) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiHttpAuthHandler == null || (pigeonRegistrar = pigeonApiHttpAuthHandler.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.useHttpAuthUsernamePassword", androidWebkitLibraryPigeonCodec);
            if (pigeonApiHttpAuthHandler != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.q0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiHttpAuthHandler.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiHttpAuthHandler, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.cancel", androidWebkitLibraryPigeonCodec);
            if (pigeonApiHttpAuthHandler != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.r0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiHttpAuthHandler.Companion.setUpMessageHandlers$lambda$3$lambda$2(pigeonApiHttpAuthHandler, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.proceed", androidWebkitLibraryPigeonCodec);
            if (pigeonApiHttpAuthHandler != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.s0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiHttpAuthHandler.Companion.setUpMessageHandlers$lambda$5$lambda$4(pigeonApiHttpAuthHandler, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
        }

        private Companion() {
        }
    }

    public PigeonApiHttpAuthHandler(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
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

    public abstract void cancel(HttpAuthHandler httpAuthHandler);

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public final void pigeon_newInstance(HttpAuthHandler pigeon_instanceArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else if (getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
            p.a aVar2 = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.E.f5463a)));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.pigeon_newInstance";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.HttpAuthHandler.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(AbstractC0768o.b(Long.valueOf(getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg))), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.p0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiHttpAuthHandler.pigeon_newInstance$lambda$0(callback, str, obj);
                }
            });
        }
    }

    public abstract void proceed(HttpAuthHandler httpAuthHandler, String str, String str2);

    public abstract boolean useHttpAuthUsernamePassword(HttpAuthHandler httpAuthHandler);
}
