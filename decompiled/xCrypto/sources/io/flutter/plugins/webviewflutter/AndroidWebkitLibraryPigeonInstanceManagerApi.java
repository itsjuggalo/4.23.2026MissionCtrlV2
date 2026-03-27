package io.flutter.plugins.webviewflutter;

import W2.p;
import X2.AbstractC0768o;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonInstanceManagerApi;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
final class AndroidWebkitLibraryPigeonInstanceManagerApi {
    public static final Companion Companion = new Companion(null);
    private static final W2.j codec$delegate = W2.k.b(new Function0() { // from class: io.flutter.plugins.webviewflutter.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AndroidWebkitLibraryPigeonInstanceManagerApi.codec_delegate$lambda$1();
        }
    });
    private final BinaryMessenger binaryMessenger;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(AndroidWebkitLibraryPigeonInstanceManager androidWebkitLibraryPigeonInstanceManager, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.r.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            try {
                androidWebkitLibraryPigeonInstanceManager.remove(((Long) obj2).longValue());
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(AndroidWebkitLibraryPigeonInstanceManager androidWebkitLibraryPigeonInstanceManager, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            kotlin.jvm.internal.r.f(reply, "reply");
            try {
                androidWebkitLibraryPigeonInstanceManager.clear();
                listWrapError = AbstractC0768o.b(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) AndroidWebkitLibraryPigeonInstanceManagerApi.codec$delegate.getValue();
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final AndroidWebkitLibraryPigeonInstanceManager androidWebkitLibraryPigeonInstanceManager) {
            kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", getCodec());
            if (androidWebkitLibraryPigeonInstanceManager != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.d
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        AndroidWebkitLibraryPigeonInstanceManagerApi.Companion.setUpMessageHandlers$lambda$1$lambda$0(androidWebkitLibraryPigeonInstanceManager, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.clear", getCodec());
            if (androidWebkitLibraryPigeonInstanceManager != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.e
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        AndroidWebkitLibraryPigeonInstanceManagerApi.Companion.setUpMessageHandlers$lambda$3$lambda$2(androidWebkitLibraryPigeonInstanceManager, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
        }

        private Companion() {
        }
    }

    public AndroidWebkitLibraryPigeonInstanceManagerApi(BinaryMessenger binaryMessenger) {
        kotlin.jvm.internal.r.f(binaryMessenger, "binaryMessenger");
        this.binaryMessenger = binaryMessenger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AndroidWebkitLibraryPigeonCodec codec_delegate$lambda$1() {
        return new AndroidWebkitLibraryPigeonCodec();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeStrongReference$lambda$0(i3.k kVar, String str, Object obj) {
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

    public final BinaryMessenger getBinaryMessenger() {
        return this.binaryMessenger;
    }

    public final void removeStrongReference(long j4, final i3.k callback) {
        kotlin.jvm.internal.r.f(callback, "callback");
        final String str = "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference";
        new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", Companion.getCodec()).send(AbstractC0768o.b(Long.valueOf(j4)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.b
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                AndroidWebkitLibraryPigeonInstanceManagerApi.removeStrongReference$lambda$0(callback, str, obj);
            }
        });
    }
}
