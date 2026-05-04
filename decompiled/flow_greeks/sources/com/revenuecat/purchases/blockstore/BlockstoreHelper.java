package com.revenuecat.purchases.blockstore;

import android.content.Context;
import cd.h0;
import cd.r;
import cd.s;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.blockstore.BlockstoreHelper;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.identity.IdentityManager;
import dd.o0;
import dd.q;
import gd.e;
import h5.c;
import h5.d;
import h5.e;
import h5.f;
import id.f;
import id.h;
import id.m;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import ng.c1;
import ng.n0;
import ng.t2;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0082@¢\u0006\u0004\b\u0010\u0010\u0011J,\u0010\u0015\u001a\u00020\u00142\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0013\u001a\u00020\u000eH\u0082@¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0015\u0010\u0019J\u001b\u0010\u001c\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u00142\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u001a¢\u0006\u0004\b\u001e\u0010\u001dR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010 R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010!R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010!¨\u0006#"}, d2 = {"Lcom/revenuecat/purchases/blockstore/BlockstoreHelper;", "", "Landroid/content/Context;", "applicationContext", "Lcom/revenuecat/purchases/identity/IdentityManager;", "identityManager", "Lh5/b;", "blockstoreClient", "Lng/n0;", "ioScope", "mainScope", "<init>", "(Landroid/content/Context;Lcom/revenuecat/purchases/identity/IdentityManager;Lh5/b;Lng/n0;Lng/n0;)V", "", "", "Lh5/e$a;", "getBlockstoreData", "(Lgd/e;)Ljava/lang/Object;", "blockstoreDataMap", "userId", "Lcd/h0;", "storeUserIdIfNeeded", "(Ljava/util/Map;Ljava/lang/String;Lgd/e;)Ljava/lang/Object;", "Lcom/revenuecat/purchases/CustomerInfo;", "customerInfo", "(Lcom/revenuecat/purchases/CustomerInfo;)V", "Lkotlin/Function0;", "callback", "aliasCurrentAndStoredUserIdsIfNeeded", "(Lkotlin/jvm/functions/Function0;)V", "clearUserIdBackupIfNeeded", "Lcom/revenuecat/purchases/identity/IdentityManager;", "Lh5/b;", "Lng/n0;", "Companion", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BlockstoreHelper {

    @Deprecated
    public static final int BLOCKSTORE_MAX_ENTRIES = 16;

    @Deprecated
    public static final String BLOCKSTORE_USER_ID_KEY = "com.revenuecat.purchases.app_user_id";
    private static final Companion Companion = new Companion(null);
    private final h5.b blockstoreClient;
    private final IdentityManager identityManager;
    private final n0 ioScope;
    private final n0 mainScope;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/blockstore/BlockstoreHelper$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "applicationContext", "Lh5/b;", "initializeBlockstoreClient", "(Landroid/content/Context;)Lh5/b;", "", "BLOCKSTORE_MAX_ENTRIES", "I", "", "BLOCKSTORE_USER_ID_KEY", "Ljava/lang/String;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final h5.b initializeBlockstoreClient(Context applicationContext) {
            t.f(applicationContext, "applicationContext");
            try {
                return h5.a.a(applicationContext);
            } catch (NoClassDefFoundError e10) {
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Cannot find Blockstore at runtime. Disabling automatic backups.", e10);
                return null;
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {1, 8, 0})
    @f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$1", f = "BlockstoreHelper.kt", l = {87, com.amazon.device.iap.internal.a.f4884a}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends m implements o {
        final /* synthetic */ Function0 $callback;
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, Function0 function0, e eVar) {
            super(2, eVar);
            this.$currentUserId = str;
            this.$callback = function0;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return BlockstoreHelper.this.new AnonymousClass1(this.$currentUserId, this.$callback, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x00a9, code lost:
        
            if (r8.aliasCurrentUserIdTo(r1, r7) == r0) goto L36;
         */
        @Override // id.a
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

        @Override // pd.o
        public final Object invoke(n0 n0Var, e eVar) {
            return ((AnonymousClass1) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {1, 8, 0})
    @f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1", f = "BlockstoreHelper.kt", l = {}, m = "invokeSuspend")
    public static final class C05561 extends m implements o {
        final /* synthetic */ h5.b $blockstoreClient;
        final /* synthetic */ Function0 $callback;
        final /* synthetic */ c $request;
        int label;

        /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$clearUserIdBackupIfNeeded$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "Lcd/h0;", "invoke", "(Ljava/lang/Boolean;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
        public static final class C01281 extends v implements pd.k {
            final /* synthetic */ Function0 $callback;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01281(Function0 function0) {
                super(1);
                this.$callback = function0;
            }

            @Override // pd.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Boolean) obj);
                return h0.f3852a;
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
        public C05561(h5.b bVar, c cVar, Function0 function0, e eVar) {
            super(2, eVar);
            this.$blockstoreClient = bVar;
            this.$request = cVar;
            this.$callback = function0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$2(Function0 function0, Exception exc) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Tried to clear Block store cached UserID but failed: " + exc.getMessage(), exc);
            function0.invoke();
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return new C05561(this.$blockstoreClient, this.$request, this.$callback, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            Task taskDeleteBytes = this.$blockstoreClient.deleteBytes(this.$request);
            final C01281 c01281 = new C01281(this.$callback);
            Task taskAddOnSuccessListener = taskDeleteBytes.addOnSuccessListener(new OnSuccessListener() { // from class: com.revenuecat.purchases.blockstore.a
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj2) {
                    c01281.invoke(obj2);
                }
            });
            final Function0 function0 = this.$callback;
            taskAddOnSuccessListener.addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.b
                @Override // com.google.android.gms.tasks.OnFailureListener
                public final void onFailure(Exception exc) {
                    BlockstoreHelper.C05561.invokeSuspend$lambda$2(function0, exc);
                }
            });
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, e eVar) {
            return ((C05561) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lng/n0;", "Lcd/h0;", "<anonymous>", "(Lng/n0;)V"}, k = 3, mv = {1, 8, 0})
    @f(c = "com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$1", f = "BlockstoreHelper.kt", l = {61, 67}, m = "invokeSuspend")
    public static final class C05571 extends m implements o {
        final /* synthetic */ String $currentUserId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C05571(String str, e eVar) {
            super(2, eVar);
            this.$currentUserId = str;
        }

        @Override // id.a
        public final e create(Object obj, e eVar) {
            return BlockstoreHelper.this.new C05571(this.$currentUserId, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003e, code lost:
        
            if (r1.storeUserIdIfNeeded(r6, r4, r5) == r0) goto L23;
         */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = hd.c.f()
                int r1 = r5.label
                java.lang.String r2 = "[Purchases] - ERROR"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L24
                if (r1 == r4) goto L1e
                if (r1 != r3) goto L16
                cd.s.b(r6)     // Catch: java.lang.Exception -> L14
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
                cd.s.b(r6)     // Catch: java.lang.Exception -> L22
                goto L32
            L22:
                r6 = move-exception
                goto L60
            L24:
                cd.s.b(r6)
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
                cd.h0 r6 = cd.h0.f3852a
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
                cd.h0 r6 = cd.h0.f3852a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.blockstore.BlockstoreHelper.C05571.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, e eVar) {
            return ((C05571) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public BlockstoreHelper(Context applicationContext, IdentityManager identityManager, h5.b bVar, n0 ioScope, n0 mainScope) {
        t.f(applicationContext, "applicationContext");
        t.f(identityManager, "identityManager");
        t.f(ioScope, "ioScope");
        t.f(mainScope, "mainScope");
        this.identityManager = identityManager;
        this.blockstoreClient = bVar;
        this.ioScope = ioScope;
        this.mainScope = mainScope;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(BlockstoreHelper blockstoreHelper, Function0 function0) {
        ng.k.d(blockstoreHelper.mainScope, null, null, new BlockstoreHelper$aliasCurrentAndStoredUserIdsIfNeeded$callCompletion$1(function0, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object getBlockstoreData(e eVar) throws Throwable {
        h5.b bVar = this.blockstoreClient;
        if (bVar == null) {
            return o0.h();
        }
        d dVarA = new d.a().b(true).a();
        t.e(dVarA, "Builder()\n            .s…rue)\n            .build()");
        final gd.k kVar = new gd.k(hd.b.c(eVar));
        bVar.retrieveBytes(dVarA).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new BlockstoreHelper$getBlockstoreData$2$1(kVar))).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$getBlockstoreData$2$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                t.f(it, "it");
                e eVar2 = kVar;
                r.a aVar = r.f3870b;
                eVar2.resumeWith(r.b(s.a(it)));
            }
        });
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            h.c(eVar);
        }
        return objA;
    }

    public final void aliasCurrentAndStoredUserIdsIfNeeded(Function0 callback) {
        t.f(callback, "callback");
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (IdentityManager.INSTANCE.isUserIDAnonymous(currentAppUserID)) {
            ng.k.d(this.ioScope, null, null, new AnonymousClass1(currentAppUserID, callback, null), 3, null);
        } else {
            aliasCurrentAndStoredUserIdsIfNeeded$callCompletion(this, callback);
        }
    }

    public final void clearUserIdBackupIfNeeded(Function0 callback) {
        t.f(callback, "callback");
        h5.b bVar = this.blockstoreClient;
        if (bVar == null) {
            callback.invoke();
            return;
        }
        c cVarA = new c.a().b(q.e(BLOCKSTORE_USER_ID_KEY)).a();
        t.e(cVarA, "Builder()\n            .s…EY))\n            .build()");
        ng.k.d(this.ioScope, null, null, new C05561(bVar, cVarA, callback, null), 3, null);
    }

    public final void storeUserIdIfNeeded(CustomerInfo customerInfo) {
        t.f(customerInfo, "customerInfo");
        if (this.blockstoreClient == null) {
            return;
        }
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        if (!IdentityManager.INSTANCE.isUserIDAnonymous(currentAppUserID) || customerInfo.getAllPurchasedProductIds().isEmpty()) {
            return;
        }
        ng.k.d(this.ioScope, null, null, new C05571(currentAppUserID, null), 3, null);
    }

    public /* synthetic */ BlockstoreHelper(Context context, IdentityManager identityManager, h5.b bVar, n0 n0Var, n0 n0Var2, int i10, k kVar) {
        this(context, identityManager, (i10 & 4) != 0 ? Companion.initializeBlockstoreClient(context) : bVar, (i10 & 8) != 0 ? ng.o0.a(t2.b(null, 1, null).plus(c1.b().b0(1))) : n0Var, (i10 & 16) != 0 ? ng.o0.a(t2.b(null, 1, null).plus(c1.c())) : n0Var2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object storeUserIdIfNeeded(Map<String, ? extends e.a> map, String str, gd.e eVar) throws Throwable {
        h5.b bVar = this.blockstoreClient;
        if (bVar == null) {
            return h0.f3852a;
        }
        if (map.get(BLOCKSTORE_USER_ID_KEY) != null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Block store: Not storing user id since there is one already present.");
            }
            return h0.f3852a;
        }
        if (map.size() >= 16) {
            LogLevel logLevel2 = LogLevel.DEBUG;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.d("[Purchases] - " + logLevel2.name(), "Block store: Not storing user id since block store is already full.");
            }
            return h0.f3852a;
        }
        LogLevel logLevel3 = LogLevel.DEBUG;
        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
            currentLogHandler3.d("[Purchases] - " + logLevel3.name(), "Block store: Storing UserID: " + str + " in Block store.");
        }
        f.a aVar = new f.a();
        byte[] bytes = str.getBytes(kg.c.f14857b);
        t.e(bytes, "getBytes(...)");
        h5.f fVarA = aVar.b(bytes).c(BLOCKSTORE_USER_ID_KEY).d(true).a();
        t.e(fVarA, "Builder()\n            .s…rue)\n            .build()");
        final gd.k kVar = new gd.k(hd.b.c(eVar));
        bVar.storeBytes(fVarA).addOnSuccessListener(new BlockstoreHelper$sam$com_google_android_gms_tasks_OnSuccessListener$0(new BlockstoreHelper$storeUserIdIfNeeded$6$1(kVar, str))).addOnFailureListener(new OnFailureListener() { // from class: com.revenuecat.purchases.blockstore.BlockstoreHelper$storeUserIdIfNeeded$6$2
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception it) {
                t.f(it, "it");
                gd.e eVar2 = kVar;
                r.a aVar2 = r.f3870b;
                eVar2.resumeWith(r.b(s.a(it)));
            }
        });
        Object objA = kVar.a();
        if (objA == hd.c.f()) {
            h.c(eVar);
        }
        return objA == hd.c.f() ? objA : h0.f3852a;
    }
}
