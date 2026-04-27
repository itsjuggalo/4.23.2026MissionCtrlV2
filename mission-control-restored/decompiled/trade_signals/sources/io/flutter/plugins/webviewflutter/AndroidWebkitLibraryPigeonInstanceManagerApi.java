package io.flutter.plugins.webviewflutter;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.AndroidWebkitLibraryPigeonInstanceManagerApi;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2490r;
import o5.InterfaceC2483k;
import p5.AbstractC2594p;

/* JADX INFO: loaded from: classes.dex */
final class AndroidWebkitLibraryPigeonInstanceManagerApi {
    public static final Companion Companion = new Companion(null);
    private static final InterfaceC2483k codec$delegate = AbstractC2484l.a(new Function0() { // from class: io.flutter.plugins.webviewflutter.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return AndroidWebkitLibraryPigeonInstanceManagerApi.codec_delegate$lambda$1();
        }
    });
    private final BinaryMessenger binaryMessenger;

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(AndroidWebkitLibraryPigeonInstanceManager androidWebkitLibraryPigeonInstanceManager, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.Long");
            try {
                androidWebkitLibraryPigeonInstanceManager.remove(((Long) obj2).longValue());
                listWrapError = AbstractC2594p.e(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$3$lambda$2(AndroidWebkitLibraryPigeonInstanceManager androidWebkitLibraryPigeonInstanceManager, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            AbstractC2304t.f(reply, "reply");
            try {
                androidWebkitLibraryPigeonInstanceManager.clear();
                listWrapError = AbstractC2594p.e(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) AndroidWebkitLibraryPigeonInstanceManagerApi.codec$delegate.getValue();
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final AndroidWebkitLibraryPigeonInstanceManager androidWebkitLibraryPigeonInstanceManager) {
            AbstractC2304t.f(binaryMessenger, "binaryMessenger");
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

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public AndroidWebkitLibraryPigeonInstanceManagerApi(BinaryMessenger binaryMessenger) {
        AbstractC2304t.f(binaryMessenger, "binaryMessenger");
        this.binaryMessenger = binaryMessenger;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AndroidWebkitLibraryPigeonCodec codec_delegate$lambda$1() {
        return new AndroidWebkitLibraryPigeonCodec();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeStrongReference$lambda$0(B5.k kVar, String str, Object obj) {
        AndroidWebKitError androidWebKitErrorCreateConnectionError;
        Object objA;
        if (obj instanceof List) {
            List list = (List) obj;
            if (list.size() <= 1) {
                C2490r.a aVar = C2490r.f21981b;
                objA = C2470H.f21956a;
                kVar.invoke(C2490r.a(C2490r.b(objA)));
            } else {
                C2490r.a aVar2 = C2490r.f21981b;
                Object obj2 = list.get(0);
                AbstractC2304t.d(obj2, "null cannot be cast to non-null type kotlin.String");
                Object obj3 = list.get(1);
                AbstractC2304t.d(obj3, "null cannot be cast to non-null type kotlin.String");
                androidWebKitErrorCreateConnectionError = new AndroidWebKitError((String) obj2, (String) obj3, (String) list.get(2));
            }
        } else {
            C2490r.a aVar3 = C2490r.f21981b;
            androidWebKitErrorCreateConnectionError = AndroidWebkitLibraryPigeonUtils.INSTANCE.createConnectionError(str);
        }
        objA = AbstractC2491s.a(androidWebKitErrorCreateConnectionError);
        kVar.invoke(C2490r.a(C2490r.b(objA)));
    }

    public final BinaryMessenger getBinaryMessenger() {
        return this.binaryMessenger;
    }

    public final void removeStrongReference(long j8, final B5.k callback) {
        AbstractC2304t.f(callback, "callback");
        final String str = "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference";
        new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.PigeonInternalInstanceManager.removeStrongReference", Companion.getCodec()).send(AbstractC2594p.e(Long.valueOf(j8)), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.b
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                AndroidWebkitLibraryPigeonInstanceManagerApi.removeStrongReference$lambda$0(callback, str, obj);
            }
        });
    }
}
