package io.flutter.plugins.webviewflutter;

import android.os.Message;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.webviewflutter.PigeonApiAndroidMessage;
import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2490r;
import p5.AbstractC2594p;

/* JADX INFO: loaded from: classes.dex */
public abstract class PigeonApiAndroidMessage {
    public static final Companion Companion = new Companion(null);
    private final AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;

    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUpMessageHandlers$lambda$1$lambda$0(PigeonApiAndroidMessage pigeonApiAndroidMessage, Object obj, BasicMessageChannel.Reply reply) {
            List<Object> listWrapError;
            AbstractC2304t.f(reply, "reply");
            AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            AbstractC2304t.d(obj2, "null cannot be cast to non-null type android.os.Message");
            try {
                pigeonApiAndroidMessage.sendToTarget((Message) obj2);
                listWrapError = AbstractC2594p.e(null);
            } catch (Throwable th) {
                listWrapError = AndroidWebkitLibraryPigeonUtils.INSTANCE.wrapError(th);
            }
            reply.reply(listWrapError);
        }

        public final void setUpMessageHandlers(BinaryMessenger binaryMessenger, final PigeonApiAndroidMessage pigeonApiAndroidMessage) {
            MessageCodec<Object> androidWebkitLibraryPigeonCodec;
            AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar;
            AbstractC2304t.f(binaryMessenger, "binaryMessenger");
            if (pigeonApiAndroidMessage == null || (pigeonRegistrar = pigeonApiAndroidMessage.getPigeonRegistrar()) == null || (androidWebkitLibraryPigeonCodec = pigeonRegistrar.getCodec()) == null) {
                androidWebkitLibraryPigeonCodec = new AndroidWebkitLibraryPigeonCodec();
            }
            new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.sendToTarget", androidWebkitLibraryPigeonCodec).setMessageHandler(pigeonApiAndroidMessage != null ? new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.webviewflutter.Q
                @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                    PigeonApiAndroidMessage.Companion.setUpMessageHandlers$lambda$1$lambda$0(pigeonApiAndroidMessage, obj, reply);
                }
            } : null);
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public PigeonApiAndroidMessage(AndroidWebkitLibraryPigeonProxyApiRegistrar pigeonRegistrar) {
        AbstractC2304t.f(pigeonRegistrar, "pigeonRegistrar");
        this.pigeonRegistrar = pigeonRegistrar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pigeon_newInstance$lambda$0(B5.k kVar, String str, Object obj) {
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

    public AndroidWebkitLibraryPigeonProxyApiRegistrar getPigeonRegistrar() {
        return this.pigeonRegistrar;
    }

    public final void pigeon_newInstance(Message pigeon_instanceArg, final B5.k callback) {
        Object objA;
        AbstractC2304t.f(pigeon_instanceArg, "pigeon_instanceArg");
        AbstractC2304t.f(callback, "callback");
        if (getPigeonRegistrar().getIgnoreCallsToDart()) {
            C2490r.a aVar = C2490r.f21981b;
            objA = AbstractC2491s.a(new AndroidWebKitError("ignore-calls-error", "Calls to Dart are being ignored.", ""));
        } else {
            if (!getPigeonRegistrar().getInstanceManager().containsInstance(pigeon_instanceArg)) {
                final String str = "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance";
                new BasicMessageChannel(getPigeonRegistrar().getBinaryMessenger(), "dev.flutter.pigeon.webview_flutter_android.AndroidMessage.pigeon_newInstance", getPigeonRegistrar().getCodec()).send(AbstractC2594p.e(Long.valueOf(getPigeonRegistrar().getInstanceManager().addHostCreatedInstance(pigeon_instanceArg))), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.webviewflutter.P
                    @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
                    public final void reply(Object obj) {
                        PigeonApiAndroidMessage.pigeon_newInstance$lambda$0(callback, str, obj);
                    }
                });
                return;
            }
            C2490r.a aVar2 = C2490r.f21981b;
            objA = C2470H.f21956a;
        }
        callback.invoke(C2490r.a(C2490r.b(objA)));
    }

    public abstract void sendToTarget(Message message);
}
