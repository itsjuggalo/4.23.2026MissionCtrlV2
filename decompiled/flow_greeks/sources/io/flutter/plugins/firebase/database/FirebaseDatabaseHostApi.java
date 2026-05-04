package io.flutter.plugins.firebase.database;

import cd.r;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugins.firebase.database.FirebaseDatabaseHostApi;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 82\u00020\u0001:\u00018J1\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\b\u0010\tJ1\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\n\u0010\tJ9\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ9\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\u0011\u0010\u0012J9\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\u0013\u0010\u000eJA\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u000f2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\u0017\u0010\u0018J;\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\u001b\u0010\u001cJ9\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u00142\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\u001e\u0010\u001cJ1\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\u001f\u0010\tJ9\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b\"\u0010#J9\u0010$\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b$\u0010#J9\u0010&\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020%2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b&\u0010'J9\u0010(\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b(\u0010#J9\u0010*\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020)2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b*\u0010+JG\u0010.\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u000f2&\u0010\u0007\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010-0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b.\u0010\u0012J9\u0010/\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b/\u0010#J9\u00100\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b0\u0010#J9\u00101\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u00020%2\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b1\u0010'J9\u00102\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00142\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b2\u0010\u001cJ9\u00104\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u0002032\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b4\u00105J9\u00106\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u0002032\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b6\u00105JG\u00107\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010!\u001a\u0002032&\u0010\u0007\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00010-0\u0005\u0012\u0004\u0012\u00020\u00060\u0004H&¢\u0006\u0004\b7\u00105¨\u00069"}, d2 = {"Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi;", "", "Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;", "app", "Lkotlin/Function1;", "Lcd/r;", "Lcd/h0;", "callback", "goOnline", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lpd/k;)V", "goOffline", "", io.flutter.plugins.firebase.analytics.Constants.ENABLED, "setPersistenceEnabled", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;ZLpd/k;)V", "", "cacheSize", "setPersistenceCacheSizeBytes", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;JLpd/k;)V", "setLoggingEnabled", "", DiagnosticsTracker.HOST_KEY, "port", "useDatabaseEmulator", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;JLpd/k;)V", Constants.PATH, "Lio/flutter/plugins/firebase/database/DatabaseReferencePlatform;", "ref", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Ljava/lang/String;Lpd/k;)V", "url", "refFromURL", "purgeOutstandingWrites", "Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;", "request", "databaseReferenceSet", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/DatabaseReferenceRequest;Lpd/k;)V", "databaseReferenceSetWithPriority", "Lio/flutter/plugins/firebase/database/UpdateRequest;", "databaseReferenceUpdate", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/UpdateRequest;Lpd/k;)V", "databaseReferenceSetPriority", "Lio/flutter/plugins/firebase/database/TransactionRequest;", "databaseReferenceRunTransaction", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/TransactionRequest;Lpd/k;)V", Constants.TRANSACTION_KEY, "", "databaseReferenceGetTransactionResult", "onDisconnectSet", "onDisconnectSetWithPriority", "onDisconnectUpdate", "onDisconnectCancel", "Lio/flutter/plugins/firebase/database/QueryRequest;", "queryObserve", "(Lio/flutter/plugins/firebase/database/DatabasePigeonFirebaseApp;Lio/flutter/plugins/firebase/database/QueryRequest;Lpd/k;)V", "queryKeepSynced", "queryGet", "Companion", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface FirebaseDatabaseHostApi {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fR#\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0013"}, d2 = {"Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi$Companion;", "", "<init>", "()V", "Lio/flutter/plugin/common/BinaryMessenger;", "binaryMessenger", "Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi;", "api", "", "messageChannelSuffix", "Lcd/h0;", "setUp", "(Lio/flutter/plugin/common/BinaryMessenger;Lio/flutter/plugins/firebase/database/FirebaseDatabaseHostApi;Ljava/lang/String;)V", "Lio/flutter/plugin/common/MessageCodec;", "codec$delegate", "Lcd/k;", "getCodec", "()Lio/flutter/plugin/common/MessageCodec;", "codec", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: codec$delegate, reason: from kotlin metadata */
        private static final cd.k codec = cd.l.b(new Function0() { // from class: io.flutter.plugins.firebase.database.q0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FirebaseDatabaseHostApi.Companion.codec_delegate$lambda$0();
            }
        });

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final GeneratedAndroidFirebaseDatabasePigeonCodec codec_delegate$lambda$0() {
            return new GeneratedAndroidFirebaseDatabasePigeonCodec();
        }

        public static /* synthetic */ void setUp$default(Companion companion, BinaryMessenger binaryMessenger, FirebaseDatabaseHostApi firebaseDatabaseHostApi, String str, int i10, Object obj) {
            if ((i10 & 4) != 0) {
                str = "";
            }
            companion.setUp(binaryMessenger, firebaseDatabaseHostApi, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$12$lambda$11(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            firebaseDatabaseHostApi.setPersistenceCacheSizeBytes((DatabasePigeonFirebaseApp) obj2, ((Long) obj3).longValue(), new pd.k() { // from class: io.flutter.plugins.firebase.database.n
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$12$lambda$11$lambda$10(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$12$lambda$11$lambda$10(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$15$lambda$14(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            firebaseDatabaseHostApi.setLoggingEnabled((DatabasePigeonFirebaseApp) obj2, ((Boolean) obj3).booleanValue(), new pd.k() { // from class: io.flutter.plugins.firebase.database.j0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$15$lambda$14$lambda$13(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$15$lambda$14$lambda$13(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$18$lambda$17(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            DatabasePigeonFirebaseApp databasePigeonFirebaseApp = (DatabasePigeonFirebaseApp) obj2;
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.String");
            Object obj4 = list.get(2);
            kotlin.jvm.internal.t.d(obj4, "null cannot be cast to non-null type kotlin.Long");
            firebaseDatabaseHostApi.useDatabaseEmulator(databasePigeonFirebaseApp, (String) obj3, ((Long) obj4).longValue(), new pd.k() { // from class: io.flutter.plugins.firebase.database.g0
                @Override // pd.k
                public final Object invoke(Object obj5) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$18$lambda$17$lambda$16(reply, (r) obj5);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$18$lambda$17$lambda$16(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$21$lambda$20(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            firebaseDatabaseHostApi.ref((DatabasePigeonFirebaseApp) obj2, (String) list.get(1), new pd.k() { // from class: io.flutter.plugins.firebase.database.s0
                @Override // pd.k
                public final Object invoke(Object obj3) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$21$lambda$20$lambda$19(reply, (r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$21$lambda$20$lambda$19(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = rVar.j();
                if (r.g(objJ)) {
                    objJ = null;
                }
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult((DatabaseReferencePlatform) objJ));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$24$lambda$23(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.String");
            firebaseDatabaseHostApi.refFromURL((DatabasePigeonFirebaseApp) obj2, (String) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.i0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$24$lambda$23$lambda$22(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$24$lambda$23$lambda$22(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = rVar.j();
                if (r.g(objJ)) {
                    objJ = null;
                }
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult((DatabaseReferencePlatform) objJ));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$27$lambda$26(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            firebaseDatabaseHostApi.purgeOutstandingWrites((DatabasePigeonFirebaseApp) obj2, new pd.k() { // from class: io.flutter.plugins.firebase.database.c0
                @Override // pd.k
                public final Object invoke(Object obj3) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$27$lambda$26$lambda$25(reply, (r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$27$lambda$26$lambda$25(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$3$lambda$2(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            firebaseDatabaseHostApi.goOnline((DatabasePigeonFirebaseApp) obj2, new pd.k() { // from class: io.flutter.plugins.firebase.database.y
                @Override // pd.k
                public final Object invoke(Object obj3) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$3$lambda$2$lambda$1(reply, (r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$3$lambda$2$lambda$1(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$30$lambda$29(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabaseReferenceRequest");
            firebaseDatabaseHostApi.databaseReferenceSet((DatabasePigeonFirebaseApp) obj2, (DatabaseReferenceRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.d0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$30$lambda$29$lambda$28(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$30$lambda$29$lambda$28(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$33$lambda$32(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabaseReferenceRequest");
            firebaseDatabaseHostApi.databaseReferenceSetWithPriority((DatabasePigeonFirebaseApp) obj2, (DatabaseReferenceRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.c
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$33$lambda$32$lambda$31(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$33$lambda$32$lambda$31(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$36$lambda$35(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.UpdateRequest");
            firebaseDatabaseHostApi.databaseReferenceUpdate((DatabasePigeonFirebaseApp) obj2, (UpdateRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.l0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$36$lambda$35$lambda$34(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$36$lambda$35$lambda$34(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$39$lambda$38(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabaseReferenceRequest");
            firebaseDatabaseHostApi.databaseReferenceSetPriority((DatabasePigeonFirebaseApp) obj2, (DatabaseReferenceRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.k0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$39$lambda$38$lambda$37(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$39$lambda$38$lambda$37(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$42$lambda$41(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.TransactionRequest");
            firebaseDatabaseHostApi.databaseReferenceRunTransaction((DatabasePigeonFirebaseApp) obj2, (TransactionRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.b0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$42$lambda$41$lambda$40(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$42$lambda$41$lambda$40(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$45$lambda$44(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Long");
            firebaseDatabaseHostApi.databaseReferenceGetTransactionResult((DatabasePigeonFirebaseApp) obj2, ((Long) obj3).longValue(), new pd.k() { // from class: io.flutter.plugins.firebase.database.z
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$45$lambda$44$lambda$43(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$45$lambda$44$lambda$43(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = rVar.j();
                if (r.g(objJ)) {
                    objJ = null;
                }
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult((Map) objJ));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$48$lambda$47(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabaseReferenceRequest");
            firebaseDatabaseHostApi.onDisconnectSet((DatabasePigeonFirebaseApp) obj2, (DatabaseReferenceRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.r0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$48$lambda$47$lambda$46(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$48$lambda$47$lambda$46(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$51$lambda$50(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabaseReferenceRequest");
            firebaseDatabaseHostApi.onDisconnectSetWithPriority((DatabasePigeonFirebaseApp) obj2, (DatabaseReferenceRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.o0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$51$lambda$50$lambda$49(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$51$lambda$50$lambda$49(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$54$lambda$53(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.UpdateRequest");
            firebaseDatabaseHostApi.onDisconnectUpdate((DatabasePigeonFirebaseApp) obj2, (UpdateRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.h0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$54$lambda$53$lambda$52(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$54$lambda$53$lambda$52(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$57$lambda$56(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.String");
            firebaseDatabaseHostApi.onDisconnectCancel((DatabasePigeonFirebaseApp) obj2, (String) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.a0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$57$lambda$56$lambda$55(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$57$lambda$56$lambda$55(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$6$lambda$5(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            Object obj2 = ((List) obj).get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            firebaseDatabaseHostApi.goOffline((DatabasePigeonFirebaseApp) obj2, new pd.k() { // from class: io.flutter.plugins.firebase.database.p0
                @Override // pd.k
                public final Object invoke(Object obj3) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$6$lambda$5$lambda$4(reply, (r) obj3);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$6$lambda$5$lambda$4(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$60$lambda$59(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.QueryRequest");
            firebaseDatabaseHostApi.queryObserve((DatabasePigeonFirebaseApp) obj2, (QueryRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.n0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$60$lambda$59$lambda$58(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$60$lambda$59$lambda$58(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = rVar.j();
                if (r.g(objJ)) {
                    objJ = null;
                }
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult((String) objJ));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$63$lambda$62(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.QueryRequest");
            firebaseDatabaseHostApi.queryKeepSynced((DatabasePigeonFirebaseApp) obj2, (QueryRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.m0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$63$lambda$62$lambda$61(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$63$lambda$62$lambda$61(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$66$lambda$65(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.QueryRequest");
            firebaseDatabaseHostApi.queryGet((DatabasePigeonFirebaseApp) obj2, (QueryRequest) obj3, new pd.k() { // from class: io.flutter.plugins.firebase.database.e0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$66$lambda$65$lambda$64(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$66$lambda$65$lambda$64(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                Object objJ = rVar.j();
                if (r.g(objJ)) {
                    objJ = null;
                }
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult((Map) objJ));
            }
            return cd.h0.f3852a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void setUp$lambda$9$lambda$8(FirebaseDatabaseHostApi firebaseDatabaseHostApi, Object obj, final BasicMessageChannel.Reply reply) {
            kotlin.jvm.internal.t.f(reply, "reply");
            kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            kotlin.jvm.internal.t.d(obj2, "null cannot be cast to non-null type io.flutter.plugins.firebase.database.DatabasePigeonFirebaseApp");
            Object obj3 = list.get(1);
            kotlin.jvm.internal.t.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
            firebaseDatabaseHostApi.setPersistenceEnabled((DatabasePigeonFirebaseApp) obj2, ((Boolean) obj3).booleanValue(), new pd.k() { // from class: io.flutter.plugins.firebase.database.f0
                @Override // pd.k
                public final Object invoke(Object obj4) {
                    return FirebaseDatabaseHostApi.Companion.setUp$lambda$9$lambda$8$lambda$7(reply, (r) obj4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final cd.h0 setUp$lambda$9$lambda$8$lambda$7(BasicMessageChannel.Reply reply, r rVar) {
            Throwable thE = r.e(rVar.j());
            if (thE != null) {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapError(thE));
            } else {
                reply.reply(GeneratedAndroidFirebaseDatabasePigeonUtils.INSTANCE.wrapResult(null));
            }
            return cd.h0.f3852a;
        }

        public final MessageCodec<Object> getCodec() {
            return (MessageCodec) codec.getValue();
        }

        public final void setUp(BinaryMessenger binaryMessenger, FirebaseDatabaseHostApi firebaseDatabaseHostApi) {
            kotlin.jvm.internal.t.f(binaryMessenger, "binaryMessenger");
            setUp$default(this, binaryMessenger, firebaseDatabaseHostApi, null, 4, null);
        }

        public final void setUp(BinaryMessenger binaryMessenger, final FirebaseDatabaseHostApi api, String messageChannelSuffix) {
            String str;
            kotlin.jvm.internal.t.f(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.t.f(messageChannelSuffix, "messageChannelSuffix");
            if (messageChannelSuffix.length() > 0) {
                str = "." + messageChannelSuffix;
            } else {
                str = "";
            }
            BasicMessageChannel basicMessageChannel = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.goOnline" + str, getCodec());
            if (api != null) {
                basicMessageChannel.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.t0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$3$lambda$2(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel2 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.goOffline" + str, getCodec());
            if (api != null) {
                basicMessageChannel2.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.l
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$6$lambda$5(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel2.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel3 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.setPersistenceEnabled" + str, getCodec());
            if (api != null) {
                basicMessageChannel3.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.p
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$9$lambda$8(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel3.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel4 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.setPersistenceCacheSizeBytes" + str, getCodec());
            if (api != null) {
                basicMessageChannel4.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.q
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$12$lambda$11(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel4.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel5 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.setLoggingEnabled" + str, getCodec());
            if (api != null) {
                basicMessageChannel5.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.s
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$15$lambda$14(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel5.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel6 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.useDatabaseEmulator" + str, getCodec());
            if (api != null) {
                basicMessageChannel6.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.t
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$18$lambda$17(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel6.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel7 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.ref" + str, getCodec());
            if (api != null) {
                basicMessageChannel7.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.u
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$21$lambda$20(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel7.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel8 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.refFromURL" + str, getCodec());
            if (api != null) {
                basicMessageChannel8.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.v
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$24$lambda$23(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel8.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel9 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.purgeOutstandingWrites" + str, getCodec());
            if (api != null) {
                basicMessageChannel9.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.w
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$27$lambda$26(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel9.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel10 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.databaseReferenceSet" + str, getCodec());
            if (api != null) {
                basicMessageChannel10.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.x
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$30$lambda$29(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel10.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel11 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.databaseReferenceSetWithPriority" + str, getCodec());
            if (api != null) {
                basicMessageChannel11.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.u0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$33$lambda$32(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel11.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel12 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.databaseReferenceUpdate" + str, getCodec());
            if (api != null) {
                basicMessageChannel12.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.v0
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$36$lambda$35(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel12.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel13 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.databaseReferenceSetPriority" + str, getCodec());
            if (api != null) {
                basicMessageChannel13.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.d
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$39$lambda$38(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel13.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel14 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.databaseReferenceRunTransaction" + str, getCodec());
            if (api != null) {
                basicMessageChannel14.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.e
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$42$lambda$41(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel14.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel15 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.databaseReferenceGetTransactionResult" + str, getCodec());
            if (api != null) {
                basicMessageChannel15.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.f
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$45$lambda$44(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel15.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel16 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.onDisconnectSet" + str, getCodec());
            if (api != null) {
                basicMessageChannel16.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.g
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$48$lambda$47(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel16.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel17 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.onDisconnectSetWithPriority" + str, getCodec());
            if (api != null) {
                basicMessageChannel17.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.h
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$51$lambda$50(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel17.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel18 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.onDisconnectUpdate" + str, getCodec());
            if (api != null) {
                basicMessageChannel18.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.i
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$54$lambda$53(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel18.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel19 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.onDisconnectCancel" + str, getCodec());
            if (api != null) {
                basicMessageChannel19.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.j
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$57$lambda$56(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel19.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel20 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.queryObserve" + str, getCodec());
            if (api != null) {
                basicMessageChannel20.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.k
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$60$lambda$59(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel20.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel21 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.queryKeepSynced" + str, getCodec());
            if (api != null) {
                basicMessageChannel21.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.m
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$63$lambda$62(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel21.setMessageHandler(null);
            }
            BasicMessageChannel basicMessageChannel22 = new BasicMessageChannel(binaryMessenger, "dev.flutter.pigeon.firebase_database_platform_interface.FirebaseDatabaseHostApi.queryGet" + str, getCodec());
            if (api != null) {
                basicMessageChannel22.setMessageHandler(new BasicMessageChannel.MessageHandler() { // from class: io.flutter.plugins.firebase.database.o
                    @Override // io.flutter.plugin.common.BasicMessageChannel.MessageHandler
                    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
                        FirebaseDatabaseHostApi.Companion.setUp$lambda$66$lambda$65(api, obj, reply);
                    }
                });
            } else {
                basicMessageChannel22.setMessageHandler(null);
            }
        }
    }

    void databaseReferenceGetTransactionResult(DatabasePigeonFirebaseApp app, long transactionKey, pd.k callback);

    void databaseReferenceRunTransaction(DatabasePigeonFirebaseApp app, TransactionRequest request, pd.k callback);

    void databaseReferenceSet(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, pd.k callback);

    void databaseReferenceSetPriority(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, pd.k callback);

    void databaseReferenceSetWithPriority(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, pd.k callback);

    void databaseReferenceUpdate(DatabasePigeonFirebaseApp app, UpdateRequest request, pd.k callback);

    void goOffline(DatabasePigeonFirebaseApp app, pd.k callback);

    void goOnline(DatabasePigeonFirebaseApp app, pd.k callback);

    void onDisconnectCancel(DatabasePigeonFirebaseApp app, String path, pd.k callback);

    void onDisconnectSet(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, pd.k callback);

    void onDisconnectSetWithPriority(DatabasePigeonFirebaseApp app, DatabaseReferenceRequest request, pd.k callback);

    void onDisconnectUpdate(DatabasePigeonFirebaseApp app, UpdateRequest request, pd.k callback);

    void purgeOutstandingWrites(DatabasePigeonFirebaseApp app, pd.k callback);

    void queryGet(DatabasePigeonFirebaseApp app, QueryRequest request, pd.k callback);

    void queryKeepSynced(DatabasePigeonFirebaseApp app, QueryRequest request, pd.k callback);

    void queryObserve(DatabasePigeonFirebaseApp app, QueryRequest request, pd.k callback);

    void ref(DatabasePigeonFirebaseApp app, String path, pd.k callback);

    void refFromURL(DatabasePigeonFirebaseApp app, String url, pd.k callback);

    void setLoggingEnabled(DatabasePigeonFirebaseApp app, boolean enabled, pd.k callback);

    void setPersistenceCacheSizeBytes(DatabasePigeonFirebaseApp app, long cacheSize, pd.k callback);

    void setPersistenceEnabled(DatabasePigeonFirebaseApp app, boolean enabled, pd.k callback);

    void useDatabaseEmulator(DatabasePigeonFirebaseApp app, String host, long port, pd.k callback);
}
