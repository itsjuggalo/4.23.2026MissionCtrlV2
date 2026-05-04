package io.flutter.plugins.firebase.database;

import cd.r;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J9\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013¨\u0006\u0015"}, d2 = {"Lio/flutter/plugins/firebase/database/FirebaseDatabaseFlutterApi;", "", "Lio/flutter/plugin/common/BinaryMessenger;", "binaryMessenger", "", "messageChannelSuffix", "<init>", "(Lio/flutter/plugin/common/BinaryMessenger;Ljava/lang/String;)V", "", "transactionKeyArg", "snapshotValueArg", "Lkotlin/Function1;", "Lcd/r;", "Lio/flutter/plugins/firebase/database/TransactionHandlerResult;", "Lcd/h0;", "callback", "callTransactionHandler", "(JLjava/lang/Object;Lpd/k;)V", "Lio/flutter/plugin/common/BinaryMessenger;", "Ljava/lang/String;", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FirebaseDatabaseFlutterApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final cd.k codec$delegate = cd.l.b(new Function0() { // from class: io.flutter.plugins.firebase.database.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return FirebaseDatabaseFlutterApi.codec_delegate$lambda$1();
        }
    });
    private final BinaryMessenger binaryMessenger;
    private final String messageChannelSuffix;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R#\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/flutter/plugins/firebase/database/FirebaseDatabaseFlutterApi$Companion;", "", "<init>", "()V", "Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lcd/k;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) FirebaseDatabaseFlutterApi.codec$delegate.getValue();
        }

        private Companion() {
        }
    }

    public FirebaseDatabaseFlutterApi(BinaryMessenger binaryMessenger, String messageChannelSuffix) {
        kotlin.jvm.internal.t.f(binaryMessenger, "binaryMessenger");
        kotlin.jvm.internal.t.f(messageChannelSuffix, "messageChannelSuffix");
        this.binaryMessenger = binaryMessenger;
        this.messageChannelSuffix = messageChannelSuffix;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void callTransactionHandler$lambda$0(pd.k kVar, String str, Object obj) {
        if (!(obj instanceof List)) {
            r.a aVar = r.f3870b;
            kVar.invoke(r.a(r.b(cd.s.a(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.createConnectionError(str)))));
            return;
        }
        List list = (List) obj;
        if (list.size() > 1) {
            r.a aVar2 = r.f3870b;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type kotlin.String");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.String");
            kVar.invoke(r.a(r.b(cd.s.a(new FlutterError((String) obj2, (String) obj3, (String) list.get(2))))));
            return;
        }
        if (list.get(0) == null) {
            r.a aVar3 = r.f3870b;
            kVar.invoke(r.a(r.b(cd.s.a(new FlutterError("null-error", "Flutter api returned null value for non-null return value.", "")))));
        } else {
            Object obj4 = list.get(0);
            kotlin.jvm.internal.t.d(obj4, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.TransactionHandlerResult");
            kVar.invoke(r.a(r.b((TransactionHandlerResult) obj4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GeneratedAndroidFirebaseDatabasePigeonCodec codec_delegate$lambda$1() {
        return new GeneratedAndroidFirebaseDatabasePigeonCodec();
    }

    public final void callTransactionHandler(long transactionKeyArg, Object snapshotValueArg, final pd.k callback) {
        String str;
        kotlin.jvm.internal.t.f(callback, "callback");
        if (this.messageChannelSuffix.length() > 0) {
            str = "." + this.messageChannelSuffix;
        } else {
            str = "";
        }
        final String str2 = "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseFlutterApi.callTransactionHandler" + str;
        new BasicMessageChannel(this.binaryMessenger, str2, INSTANCE.getCodec()).send(dd.r.n(Long.valueOf(transactionKeyArg), snapshotValueArg), new BasicMessageChannel.Reply() { // from class: io.flutter.plugins.firebase.database.a
            @Override // io.flutter.plugin.common.BasicMessageChannel.Reply
            public final void reply(Object obj) {
                FirebaseDatabaseFlutterApi.callTransactionHandler$lambda$0(callback, str2, obj);
            }
        });
    }

    public /* synthetic */ FirebaseDatabaseFlutterApi(BinaryMessenger binaryMessenger, String str, int i10, kotlin.jvm.internal.k kVar) {
        this(binaryMessenger, (i10 & 2) != 0 ? "" : str);
    }
}
