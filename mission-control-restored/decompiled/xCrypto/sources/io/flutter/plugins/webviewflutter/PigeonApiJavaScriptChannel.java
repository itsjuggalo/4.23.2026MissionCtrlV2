package io.flutter.plugins.webviewflutter;

import W2.p;
import X2.AbstractC0768o;
import X2.AbstractC0769p;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.PigeonApiJavaScriptChannel;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PigeonApiJavaScriptChannel {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiJavaScriptChannel pigeonApiJavaScriptChannel, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            long jLongValue = ((Long) obj2).longValue();
            Object obj3 = list.get(1);
            kotlin.jvm.internal.r.d(obj3, "null cannot be cast to non-null type kotlin.String");
            try {
                pigeonApiJavaScriptChannel.getPigeonRegistrar().getInstanceManager().addDartCreatedInstance(pigeonApiJavaScriptChannel.pigeon_defaultConstructor((String) obj3), jLongValue);
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiJavaScriptChannel pigeonApiJavaScriptChannel) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiJavaScriptChannel == null || (pigeonRegistrar = pigeonApiJavaScriptChannel.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.pigeon_defaultConstructor", androidWebkitLibraryPigeonCodec);
            if (pigeonApiJavaScriptChannel != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.u0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        PigeonApiJavaScriptChannel.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiJavaScriptChannel, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
        }

        private Companion() {
        }
    }

    public PigeonApiJavaScriptChannel(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        kotlin.jvm.internal.r.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void postMessage$lambda$0(i3.k kVar, String str, Object obj) {
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

    public abstract JavaScriptChannel pigeon_defaultConstructor(String str);

    public final void pigeon_newInstance(JavaScriptChannel pigeon_instanceArg, i3.k callback) {
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
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("new-instance-error", "Attempting to create a new Dart instance of JavaScriptChannel, but the class has a nonnull callback method.", "")))));
        }
    }

    public final void postMessage(JavaScriptChannel pigeon_instanceArg, String messageArg, final i3.k callback) {
        kotlin.jvm.internal.r.f(pigeon_instanceArg, "pigeon_instanceArg");
        kotlin.jvm.internal.r.f(messageArg, "messageArg");
        kotlin.jvm.internal.r.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            p.a aVar = W2.p.f5487b;
            callback.invoke(W2.p.a(W2.p.b(W2.q.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", "")))));
        } else {
            final String str = "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.postMessage";
            new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.JavaScriptChannel.postMessage", getPigeonRegistrar().getCodec()).send(AbstractC0769p.j(pigeon_instanceArg, messageArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.t0
                @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                public final void reply(Object obj) {
                    PigeonApiJavaScriptChannel.postMessage$lambda$0(callback, str, obj);
                }
            });
        }
    }
}
