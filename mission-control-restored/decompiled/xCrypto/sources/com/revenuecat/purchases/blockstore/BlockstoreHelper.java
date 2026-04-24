package com.revenuecat.purchases.blockstore;

import W2.E;
import W2.p;
import W2.q;
import X2.AbstractC0768o;
import Z2.e;
import a3.AbstractC0786b;
import a3.AbstractC0787c;
import android.content.Context;
import b3.InterfaceC0868f;
import b3.h;
import b3.l;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.blockstore.BlockstoreHelper;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.identity.IdentityManager;
import i3.k;
import i3.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import r3.C1756c;
import t3.AbstractC1822k;
import t3.C1803a0;
import t3.L;
import t3.M;
import t3.S0;
import w1.AbstractC1900a;
import w1.C1902c;
import w1.C1903d;
import w1.C1904e;
import w1.InterfaceC1901b;
import w1.f;

/* JADX INFO: loaded from: classes.dex */
public final class BlockstoreHelper {

    @Deprecated
    public static final int BLOCKSTORE_MAX_ENTRIES = 16;

    @Deprecated
    public static final String BLOCKSTORE_USER_ID_KEY = "com.revenuecat.purchases.app_user_id";
    private static final Companion Companion = new Companion(null);
    private final InterfaceC1901b blockstoreClient;
    private final IdentityManager identityManager;
    private final L ioScope;
    private final L mainScope;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1", f = "BlockstoreHelper.kt", l = {75, 88}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ Function0 $callback;
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Function0 function0, e eVar) {
            super(2, eVar);
            this.$currentUserId = str;
            this.$callback = function0;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return BlockstoreHelper.this.new AnonymousClass1(this.$currentUserId, this.$callback, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a9, code lost:
        
            if (r8.aliasCurrentUserIdTo(r1, r7) == r0) goto L36;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 285
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.blockstore.BlockstoreHelper.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1", f = "BlockstoreHelper.kt", l = {}, m = "invokeSuspend")
    public static final class C11371 extends l implements o {
        final /* synthetic */ Function0 $callback;
        final /* synthetic */ C1902c $request;
        int label;

        /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01731 extends s implements k {
            final /* synthetic */ Function0 $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01731(Function0 function0) {
                super(1);
                this.$callback = function0;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return E.f5463a;
            }

            public final void invoke(Boolean bool) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store cached UserID cleared if any");
                }
                this.$callback.invoke();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11371(C1902c c1902c, Function0 function0, e eVar) {
            super(2, eVar);
            this.$request = c1902c;
            this.$callback = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(Function0 function0, Exception exc) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Tried to clear Block store cached UserID but failed: " + exc.getMessage(), exc);
            function0.invoke();
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return BlockstoreHelper.this.new C11371(this.$request, this.$callback, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0787c.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
            Task taskDeleteBytes = BlockstoreHelper.this.blockstoreClient.deleteBytes(this.$request);
            final C01731 c01731 = new C01731(this.$callback);
            Task taskAddOnSuccessListener = taskDeleteBytes.addOnSuccessListener(new OnSuccessListener() { // from class: com.revenuecat.purchases.blockstore.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj2) {
                    c01731.invoke(obj2);
                }
            });
            final Function0 function0 = this.$callback;
            taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.b
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    BlockstoreHelper.C11371.invokeSuspend$lambda$2(function0, exc);
                }
            });
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((C11371) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1", f = "BlockstoreHelper.kt", l = {49, FirestoreIndexValueWriter.INDEX_TYPE_MAP}, m = "invokeSuspend")
    public static final class C11381 extends l implements o {
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11381(String str, e eVar) {
            super(2, eVar);
            this.$currentUserId = str;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return BlockstoreHelper.this.new C11381(this.$currentUserId, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        
            if (r1.storeUserIdIfNeeded(r6, r4, r5) == r0) goto L23;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r5.label
                java.lang.String r2 = "[Purchases] - ERROR"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                W2.q.b(r6)     // Catch: java.lang.Exception -> L14
                goto L5d
            L14:
                r6 = move-exception
                goto L41
            L16:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1e:
                W2.q.b(r6)     // Catch: java.lang.Exception -> L22
                goto L32
            L22:
                r6 = move-exception
                goto L60
            L24:
                W2.q.b(r6)
                com.revenuecat.purchases.blockstore.BlockstoreHelper r6 = com.revenuecat.purchases.blockstore.BlockstoreHelper.this     // Catch: java.lang.Exception -> L22
                r5.label = r4     // Catch: java.lang.Exception -> L22
                java.lang.Object r6 = com.revenuecat.purchases.blockstore.BlockstoreHelper.access$getBlockstoreData(r6, r5)     // Catch: java.lang.Exception -> L22
                if (r6 != r0) goto L32
                goto L40
            L32:
                java.util.Map r6 = (java.util.Map) r6     // Catch: java.lang.Exception -> L22
                com.revenuecat.purchases.blockstore.BlockstoreHelper r1 = com.revenuecat.purchases.blockstore.BlockstoreHelper.this     // Catch: java.lang.Exception -> L14
                java.lang.String r4 = r5.$currentUserId     // Catch: java.lang.Exception -> L14
                r5.label = r3     // Catch: java.lang.Exception -> L14
                java.lang.Object r6 = com.revenuecat.purchases.blockstore.BlockstoreHelper.access$storeUserIdIfNeeded(r1, r6, r4, r5)     // Catch: java.lang.Exception -> L14
                if (r6 != r0) goto L5d
            L40:
                return r0
            L41:
                com.revenuecat.purchases.LogHandler r0 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Failed to store user Id in Block store: "
                r1.append(r3)
                java.lang.String r3 = r6.getMessage()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.e(r2, r1, r6)
            L5d:
                W2.E r6 = W2.E.f5463a
                return r6
            L60:
                com.revenuecat.purchases.LogHandler r0 = com.revenuecat.purchases.common.LogWrapperKt.getCurrentLogHandler()
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Failed to retrieve Block store data. Will not store userId. Error: "
                r1.append(r3)
                java.lang.String r3 = r6.getMessage()
                r1.append(r3)
                java.lang.String r1 = r1.toString()
                r0.e(r2, r1, r6)
                W2.E r6 = W2.E.f5463a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.blockstore.BlockstoreHelper.C11381.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((C11381) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public BlockstoreHelper(Context applicationContext, IdentityManager identityManager, InterfaceC1901b blockstoreClient, L ioScope, L mainScope) {
        r.f(applicationContext, "applicationContext");
        r.f(identityManager, "identityManager");
        r.f(blockstoreClient, "blockstoreClient");
        r.f(ioScope, "ioScope");
        r.f(mainScope, "mainScope");
        this.identityManager = identityManager;
        this.blockstoreClient = blockstoreClient;
        this.ioScope = ioScope;
        this.mainScope = mainScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper blockstoreHelper, Function0 function0) {
        AbstractC1822k.d(blockstoreHelper.mainScope, null, null, new BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(function0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getBlockstoreData(e eVar) throws Throwable {
        C1903d c1903dA = new C1903d.a().b(true).a();
        r.e(c1903dA, "Builder()\n            .s…rue)\n            .build()");
        final Z2.k kVar = new Z2.k(AbstractC0786b.c(eVar));
        this.blockstoreClient.retrieveBytes(c1903dA).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new BlockstoreHelper$getBlockstoreData$2$1(kVar))).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$getBlockstoreData$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                r.f(it, "it");
                e eVar2 = kVar;
                p.a aVar = p.f5487b;
                eVar2.resumeWith(p.b(q.a(it)));
            }
        });
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            h.c(eVar);
        }
        return objA;
    }

    public final void aliasCurrentAndStoredUserIdsIfNeeded(Function0 callback) {
        r.f(callback, "callback");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (IdentityManager.Companion.isUserIDAnonymous(currentAppUserID)) {
            AbstractC1822k.d(this.ioScope, null, null, new AnonymousClass1(currentAppUserID, callback, null), 3, null);
        } else {
            aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(this, callback);
        }
    }

    public final void clearUserIdBackupIfNeeded(Function0 callback) {
        r.f(callback, "callback");
        C1902c c1902cA = new C1902c.a().b(AbstractC0768o.b(BLOCKSTORE_USER_ID_KEY)).a();
        r.e(c1902cA, "Builder()\n            .s…EY))\n            .build()");
        AbstractC1822k.d(this.ioScope, null, null, new C11371(c1902cA, callback, null), 3, null);
    }

    public final void storeUserIdIfNeeded(CustomerInfo customerInfo) {
        r.f(customerInfo, "customerInfo");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (!IdentityManager.Companion.isUserIDAnonymous(currentAppUserID) || customerInfo.getAllPurchasedProductIds().isEmpty()) {
            return;
        }
        AbstractC1822k.d(this.ioScope, null, null, new C11381(currentAppUserID, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object storeUserIdIfNeeded(Map<String, ? extends C1904e.a> map, String str, e eVar) throws Throwable {
        if (map.get(BLOCKSTORE_USER_ID_KEY) != null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store: Not storing user id since there is one already present.");
            }
            return E.f5463a;
        }
        if (map.size() >= 16) {
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Block store: Not storing user id since block store is already full.");
            }
            return E.f5463a;
        }
        LogLevel logLevel3 = LogLevel.DEBUG;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Block store: Storing UserID: " + str + " in Block store.");
        }
        f.a aVar = new f.a();
        byte[] bytes = str.getBytes(C1756c.f14563b);
        r.e(bytes, "this as java.lang.String).getBytes(charset)");
        f fVarA = aVar.b(bytes).c(BLOCKSTORE_USER_ID_KEY).d(true).a();
        r.e(fVarA, "Builder()\n            .s…rue)\n            .build()");
        final Z2.k kVar = new Z2.k(AbstractC0786b.c(eVar));
        this.blockstoreClient.storeBytes(fVarA).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new BlockstoreHelper$storeUserIdIfNeeded$6$1(kVar, str))).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$6$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                r.f(it, "it");
                e eVar2 = kVar;
                p.a aVar2 = p.f5487b;
                eVar2.resumeWith(p.b(q.a(it)));
            }
        });
        Object objA = kVar.a();
        if (objA == AbstractC0787c.e()) {
            h.c(eVar);
        }
        return objA == AbstractC0787c.e() ? objA : E.f5463a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ BlockstoreHelper(Context context, IdentityManager identityManager, InterfaceC1901b interfaceC1901b, L l4, L l5, int i4, AbstractC1585j abstractC1585j) {
        if ((i4 & 4) != 0) {
            interfaceC1901b = AbstractC1900a.a(context);
            r.e(interfaceC1901b, "getClient(applicationContext)");
        }
        this(context, identityManager, interfaceC1901b, (i4 & 8) != 0 ? M.a(S0.b(null, 1, null).plus(C1803a0.b().f0(1))) : l4, (i4 & 16) != 0 ? M.a(S0.b(null, 1, null).plus(C1803a0.c())) : l5);
    }
}
