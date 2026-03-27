package com.revenuecat.purchases.common.diagnostics;

import W2.E;
import X2.AbstractC0769p;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogWrapperKt;
import i3.k;
import i3.o;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONObject;
import q3.e;
import q3.l;

/* JADX INFO: loaded from: classes.dex */
public final class DiagnosticsSynchronizer implements DiagnosticsEventTrackerListener {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_EVENTS_TO_SYNC_PER_REQUEST = 200;
    public static final int MAX_NUMBER_POST_RETRIES = 3;
    private final Backend backend;
    private final Dispatcher diagnosticsDispatcher;
    private final DiagnosticsFileHelper diagnosticsFileHelper;
    private final DiagnosticsHelper diagnosticsHelper;
    private final DiagnosticsTracker diagnosticsTracker;
    private final AtomicBoolean isSyncing;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public static /* synthetic */ void getMAX_EVENTS_TO_SYNC_PER_REQUEST$annotations() {
        }

        public static /* synthetic */ void getMAX_NUMBER_POST_RETRIES$annotations() {
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$getEventsToSync$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ F $eventsToSync;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(F f4) {
            super(1);
            this.$eventsToSync = f4;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((e) obj);
            return E.f5463a;
        }

        public final void invoke(e sequence) {
            r.f(sequence, "sequence");
            this.$eventsToSync.f13410a = l.k(l.j(sequence, 200));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$syncDiagnosticsFileIfBigEnough$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11401 extends s implements Function0 {
        public C11401() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m100invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m100invoke() {
            if (DiagnosticsSynchronizer.this.diagnosticsFileHelper.isDiagnosticsFileBigEnoughToSync()) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "Diagnostics file is big enough to sync. Syncing it.");
                }
                DiagnosticsSynchronizer.this.syncDiagnosticsFileIfNeeded();
            }
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11411 extends s implements Function0 {

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends s implements k {
            final /* synthetic */ int $diagnosticsCount;
            final /* synthetic */ DiagnosticsSynchronizer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(DiagnosticsSynchronizer diagnosticsSynchronizer, int i4) {
                super(1);
                this.this$0 = diagnosticsSynchronizer;
                this.$diagnosticsCount = i4;
            }

            @Override // i3.k
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((JSONObject) obj);
                return E.f5463a;
            }

            public final void invoke(JSONObject it) {
                r.f(it, "it");
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "Synced diagnostics file successfully.");
                }
                this.this$0.diagnosticsHelper.clearConsecutiveNumberOfErrors();
                this.this$0.diagnosticsFileHelper.clear(this.$diagnosticsCount);
                this.this$0.isSyncing().set(false);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.diagnostics.DiagnosticsSynchronizer$syncDiagnosticsFileIfNeeded$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends s implements o {
            final /* synthetic */ DiagnosticsSynchronizer this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(DiagnosticsSynchronizer diagnosticsSynchronizer) {
                super(2);
                this.this$0 = diagnosticsSynchronizer;
            }

            @Override // i3.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return E.f5463a;
            }

            public final void invoke(PurchasesError error, boolean z4) {
                r.f(error, "error");
                if (z4) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    Config config = Config.INSTANCE;
                    if (config.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Error syncing diagnostics file: " + error + ". Will retry the next time the SDK is initialized");
                    }
                    if (this.this$0.diagnosticsHelper.increaseConsecutiveNumberOfErrors() >= 3) {
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (config.getLogLevel().compareTo(logLevel) <= 0) {
                            currentLogHandler2.v("[Purchases] - " + logLevel.name(), "Error syncing diagnostics file: " + error + ". This was the final attempt (3). Deleting diagnostics file without posting.");
                        }
                        this.this$0.diagnosticsHelper.resetDiagnosticsStatus();
                        this.this$0.diagnosticsTracker.trackMaxDiagnosticsSyncRetriesReached();
                    }
                } else {
                    LogLevel logLevel2 = LogLevel.VERBOSE;
                    LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        currentLogHandler3.v("[Purchases] - " + logLevel2.name(), "Error syncing diagnostics file: " + error + ". Deleting diagnostics file without retrying.");
                    }
                    this.this$0.diagnosticsHelper.resetDiagnosticsStatus();
                    this.this$0.diagnosticsTracker.trackClearingDiagnosticsAfterFailedSync();
                }
                this.this$0.isSyncing().set(false);
            }
        }

        public C11411() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() throws Throwable {
            m101invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m101invoke() throws Throwable {
            try {
                if (DiagnosticsSynchronizer.this.isSyncing().getAndSet(true)) {
                    LogLevel logLevel = LogLevel.VERBOSE;
                    LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        currentLogHandler.v("[Purchases] - " + logLevel.name(), "Already syncing diagnostics file.");
                        return;
                    }
                    return;
                }
                List<? extends JSONObject> eventsToSync = DiagnosticsSynchronizer.this.getEventsToSync();
                int size = eventsToSync.size();
                if (size != 0) {
                    DiagnosticsSynchronizer.this.backend.postDiagnostics(eventsToSync, new AnonymousClass3(DiagnosticsSynchronizer.this, size), new AnonymousClass4(DiagnosticsSynchronizer.this));
                    return;
                }
                LogLevel logLevel2 = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "No diagnostics to sync.");
                }
                DiagnosticsSynchronizer.this.isSyncing().set(false);
            } catch (Exception e4) {
                LogLevel logLevel3 = LogLevel.VERBOSE;
                LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                    currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "Error syncing diagnostics file: " + e4);
                }
                try {
                    DiagnosticsSynchronizer.this.diagnosticsHelper.resetDiagnosticsStatus();
                } catch (IOException e5) {
                    LogLevel logLevel4 = LogLevel.VERBOSE;
                    LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        currentLogHandler4.v("[Purchases] - " + logLevel4.name(), "Error deleting diagnostics file: " + e5);
                    }
                }
                DiagnosticsSynchronizer.this.isSyncing().set(false);
            }
        }
    }

    public DiagnosticsSynchronizer(DiagnosticsHelper diagnosticsHelper, DiagnosticsFileHelper diagnosticsFileHelper, DiagnosticsTracker diagnosticsTracker, Backend backend, Dispatcher diagnosticsDispatcher) {
        r.f(diagnosticsHelper, "diagnosticsHelper");
        r.f(diagnosticsFileHelper, "diagnosticsFileHelper");
        r.f(diagnosticsTracker, "diagnosticsTracker");
        r.f(backend, "backend");
        r.f(diagnosticsDispatcher, "diagnosticsDispatcher");
        this.diagnosticsHelper = diagnosticsHelper;
        this.diagnosticsFileHelper = diagnosticsFileHelper;
        this.diagnosticsTracker = diagnosticsTracker;
        this.backend = backend;
        this.diagnosticsDispatcher = diagnosticsDispatcher;
        this.isSyncing = new AtomicBoolean(false);
    }

    private final void enqueue(final Function0 function0) {
        Dispatcher.enqueue$default(this.diagnosticsDispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.diagnostics.a
            @Override // java.lang.Runnable
            public final void run() {
                DiagnosticsSynchronizer.enqueue$lambda$0(function0);
            }
        }, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$0(Function0 tmp0) {
        r.f(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<JSONObject> getEventsToSync() {
        F f4 = new F();
        f4.f13410a = AbstractC0769p.g();
        this.diagnosticsFileHelper.readFileAsJson(new AnonymousClass1(f4));
        return (List) f4.f13410a;
    }

    private final void syncDiagnosticsFileIfBigEnough() {
        enqueue(new C11401());
    }

    public final AtomicBoolean isSyncing() {
        return this.isSyncing;
    }

    @Override // com.revenuecat.purchases.common.diagnostics.DiagnosticsEventTrackerListener
    public void onEventTracked() {
        syncDiagnosticsFileIfBigEnough();
    }

    public final void syncDiagnosticsFileIfNeeded() {
        enqueue(new C11411());
    }
}
