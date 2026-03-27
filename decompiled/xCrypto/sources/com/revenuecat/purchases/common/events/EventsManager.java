package com.revenuecat.purchases.common.events;

import K3.n;
import W2.E;
import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.x;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallStoredEvent;
import com.revenuecat.purchases.utils.EventsFileHelper;
import i3.k;
import i3.o;
import i3.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.F;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import q3.e;
import q3.l;

/* JADX INFO: loaded from: classes.dex */
public final class EventsManager {
    public static final Companion Companion = new Companion(null);
    public static final String EVENTS_FILE_PATH_NEW = "RevenueCat/event_store/event_store.jsonl";
    private static final int FLUSH_COUNT = 50;
    private static final String PAYWALL_EVENTS_FILE_PATH = "RevenueCat/paywall_event_store/paywall_event_store.jsonl";
    private static final UUID appSessionID;
    private static final K3.a json;
    private final UUID appSessionID$1;
    private final Dispatcher eventsDispatcher;
    private final EventsFileHelper<BackendStoredEvent> fileHelper;
    private boolean flushInProgress;
    private final IdentityManager identityManager;
    private final EventsFileHelper<PaywallStoredEvent> legacyEventsFileHelper;
    private boolean legacyFlushTriggered;
    private final p postEvents;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private static /* synthetic */ void getJson$annotations() {
        }

        public final EventsFileHelper<BackendStoredEvent> backendEvents(FileHelper fileHelper) {
            r.f(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.EVENTS_FILE_PATH_NEW, EventsManager$Companion$backendEvents$1.INSTANCE, EventsManager$Companion$backendEvents$2.INSTANCE);
        }

        public final UUID getAppSessionID$purchases_defaultsRelease() {
            return EventsManager.appSessionID;
        }

        public final EventsFileHelper<PaywallStoredEvent> paywalls(FileHelper fileHelper) {
            r.f(fileHelper, "fileHelper");
            return new EventsFileHelper<>(fileHelper, EventsManager.PAYWALL_EVENTS_FILE_PATH, EventsManager$Companion$paywalls$1.INSTANCE, new EventsManager$Companion$paywalls$2(PaywallStoredEvent.Companion));
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements Function0 {

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushEvents$1$5, reason: invalid class name */
        public static final class AnonymousClass5 extends s implements Function0 {
            final /* synthetic */ List<BackendStoredEvent> $storedEventsWithNullValues;
            final /* synthetic */ EventsManager this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushEvents$1$5$2, reason: invalid class name */
            public static final class AnonymousClass2 extends s implements Function0 {
                final /* synthetic */ List<BackendStoredEvent> $storedEventsWithNullValues;
                final /* synthetic */ EventsManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass2(EventsManager eventsManager, List<? extends BackendStoredEvent> list) {
                    super(0);
                    this.this$0 = eventsManager;
                    this.$storedEventsWithNullValues = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m119invoke();
                    return E.f5463a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m119invoke() {
                    this.this$0.fileHelper.clear(this.$storedEventsWithNullValues.size());
                    this.this$0.flushInProgress = false;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass5(EventsManager eventsManager, List<? extends BackendStoredEvent> list) {
                super(0);
                this.this$0 = eventsManager;
                this.$storedEventsWithNullValues = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m118invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m118invoke() {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "New event flush: success.");
                }
                EventsManager eventsManager = this.this$0;
                EventsManager.enqueue$default(eventsManager, null, new AnonymousClass2(eventsManager, this.$storedEventsWithNullValues), 1, null);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushEvents$1$6, reason: invalid class name */
        public static final class AnonymousClass6 extends s implements o {
            final /* synthetic */ List<BackendStoredEvent> $storedEventsWithNullValues;
            final /* synthetic */ EventsManager this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushEvents$1$6$2, reason: invalid class name */
            public static final class AnonymousClass2 extends s implements Function0 {
                final /* synthetic */ boolean $shouldMarkAsSynced;
                final /* synthetic */ List<BackendStoredEvent> $storedEventsWithNullValues;
                final /* synthetic */ EventsManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public AnonymousClass2(boolean z4, EventsManager eventsManager, List<? extends BackendStoredEvent> list) {
                    super(0);
                    this.$shouldMarkAsSynced = z4;
                    this.this$0 = eventsManager;
                    this.$storedEventsWithNullValues = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m120invoke();
                    return E.f5463a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m120invoke() {
                    if (this.$shouldMarkAsSynced) {
                        this.this$0.fileHelper.clear(this.$storedEventsWithNullValues.size());
                    }
                    this.this$0.flushInProgress = false;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass6(EventsManager eventsManager, List<? extends BackendStoredEvent> list) {
                super(2);
                this.this$0 = eventsManager;
                this.$storedEventsWithNullValues = list;
            }

            @Override // i3.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return E.f5463a;
            }

            public final void invoke(PurchasesError error, boolean z4) {
                r.f(error, "error");
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "New event flush error: " + error + b.f8816a, null);
                EventsManager eventsManager = this.this$0;
                EventsManager.enqueue$default(eventsManager, null, new AnonymousClass2(z4, eventsManager, this.$storedEventsWithNullValues), 1, null);
            }
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m117invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m117invoke() {
            if (EventsManager.this.flushInProgress) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Flush already in progress.");
                    return;
                }
                return;
            }
            EventsManager.this.flushInProgress = true;
            if (!EventsManager.this.legacyFlushTriggered) {
                EventsManager.this.legacyFlushTriggered = true;
                EventsManager.this.flushLegacyEvents();
            }
            List storedEvents = EventsManager.this.getStoredEvents();
            List listE = x.E(storedEvents);
            if (listE.isEmpty()) {
                LogLevel logLevel2 = LogLevel.VERBOSE;
                LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                    currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "No new events to sync.");
                }
                EventsManager.this.flushInProgress = false;
                return;
            }
            LogLevel logLevel3 = LogLevel.VERBOSE;
            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                currentLogHandler3.v("[Purchases] - " + logLevel3.name(), "New event flush: posting " + listE.size() + " events.");
            }
            p pVar = EventsManager.this.postEvents;
            ArrayList arrayList = new ArrayList(AbstractC0770q.q(listE, 10));
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(BackendStoredEventKt.toBackendEvent((BackendStoredEvent) it.next()));
            }
            pVar.invoke(new EventsRequest(arrayList), new AnonymousClass5(EventsManager.this, storedEvents), new AnonymousClass6(EventsManager.this, storedEvents));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushLegacyEvents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11431 extends s implements Function0 {

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushLegacyEvents$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends s implements Function0 {
            final /* synthetic */ List<PaywallStoredEvent> $storedLegacyEventsWithNullValues;
            final /* synthetic */ EventsManager this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushLegacyEvents$1$4$2, reason: invalid class name */
            public static final class AnonymousClass2 extends s implements Function0 {
                final /* synthetic */ List<PaywallStoredEvent> $storedLegacyEventsWithNullValues;
                final /* synthetic */ EventsManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(EventsManager eventsManager, List<PaywallStoredEvent> list) {
                    super(0);
                    this.this$0 = eventsManager;
                    this.$storedLegacyEventsWithNullValues = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m123invoke();
                    return E.f5463a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m123invoke() {
                    this.this$0.legacyEventsFileHelper.clear(this.$storedLegacyEventsWithNullValues.size());
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(EventsManager eventsManager, List<PaywallStoredEvent> list) {
                super(0);
                this.this$0 = eventsManager;
                this.$storedLegacyEventsWithNullValues = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m122invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m122invoke() {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "Legacy event flush: success.");
                }
                EventsManager eventsManager = this.this$0;
                EventsManager.enqueue$default(eventsManager, null, new AnonymousClass2(eventsManager, this.$storedLegacyEventsWithNullValues), 1, null);
            }
        }

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushLegacyEvents$1$5, reason: invalid class name */
        public static final class AnonymousClass5 extends s implements o {
            final /* synthetic */ List<PaywallStoredEvent> $storedLegacyEventsWithNullValues;
            final /* synthetic */ EventsManager this$0;

            /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$flushLegacyEvents$1$5$2, reason: invalid class name */
            public static final class AnonymousClass2 extends s implements Function0 {
                final /* synthetic */ boolean $shouldMarkAsSynced;
                final /* synthetic */ List<PaywallStoredEvent> $storedLegacyEventsWithNullValues;
                final /* synthetic */ EventsManager this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(boolean z4, EventsManager eventsManager, List<PaywallStoredEvent> list) {
                    super(0);
                    this.$shouldMarkAsSynced = z4;
                    this.this$0 = eventsManager;
                    this.$storedLegacyEventsWithNullValues = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m124invoke();
                    return E.f5463a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m124invoke() {
                    if (this.$shouldMarkAsSynced) {
                        this.this$0.legacyEventsFileHelper.clear(this.$storedLegacyEventsWithNullValues.size());
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass5(EventsManager eventsManager, List<PaywallStoredEvent> list) {
                super(2);
                this.this$0 = eventsManager;
                this.$storedLegacyEventsWithNullValues = list;
            }

            @Override // i3.o
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
                return E.f5463a;
            }

            public final void invoke(PurchasesError error, boolean z4) {
                r.f(error, "error");
                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Legacy event flush error: " + error + b.f8816a, null);
                EventsManager eventsManager = this.this$0;
                EventsManager.enqueue$default(eventsManager, null, new AnonymousClass2(z4, eventsManager, this.$storedLegacyEventsWithNullValues), 1, null);
            }
        }

        public C11431() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m121invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m121invoke() {
            List legacyPaywallsStoredEvents = EventsManager.this.getLegacyPaywallsStoredEvents();
            List listE = x.E(legacyPaywallsStoredEvents);
            ArrayList arrayList = new ArrayList(AbstractC0770q.q(listE, 10));
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                arrayList.add(new BackendStoredEvent.Paywalls(((PaywallStoredEvent) it.next()).toBackendEvent()));
            }
            if (listE.isEmpty()) {
                LogLevel logLevel = LogLevel.VERBOSE;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.v("[Purchases] - " + logLevel.name(), "No legacy events to sync. Skipping legacy flush.");
                    return;
                }
                return;
            }
            LogLevel logLevel2 = LogLevel.VERBOSE;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                currentLogHandler2.v("[Purchases] - " + logLevel2.name(), "Legacy event flush: posting " + arrayList.size() + " events.");
            }
            p pVar = EventsManager.this.postEvents;
            ArrayList arrayList2 = new ArrayList(AbstractC0770q.q(arrayList, 10));
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                arrayList2.add(BackendStoredEventKt.toBackendEvent((BackendStoredEvent.Paywalls) it2.next()));
            }
            pVar.invoke(new EventsRequest(arrayList2), new AnonymousClass4(EventsManager.this, legacyPaywallsStoredEvents), new AnonymousClass5(EventsManager.this, legacyPaywallsStoredEvents));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$getLegacyPaywallsStoredEvents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11441 extends s implements k {
        final /* synthetic */ F $events;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11441(F f4) {
            super(1);
            this.$events = f4;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((e) obj);
            return E.f5463a;
        }

        public final void invoke(e sequence) {
            r.f(sequence, "sequence");
            this.$events.f13410a = l.k(l.j(sequence, 50));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$getStoredEvents$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11451 extends s implements k {
        final /* synthetic */ F $events;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11451(F f4) {
            super(1);
            this.$events = f4;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((e) obj);
            return E.f5463a;
        }

        public final void invoke(e sequence) {
            r.f(sequence, "sequence");
            this.$events.f13410a = l.k(l.j(sequence, 50));
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.EventsManager$track$1, reason: invalid class name and case insensitive filesystem */
    public static final class C11461 extends s implements Function0 {
        final /* synthetic */ FeatureEvent $event;
        final /* synthetic */ EventsManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C11461(FeatureEvent featureEvent, EventsManager eventsManager) {
            super(0);
            this.$event = featureEvent;
            this.this$0 = eventsManager;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m125invoke();
            return E.f5463a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m125invoke() {
            BackendStoredEvent backendStoredEvent;
            FeatureEvent featureEvent = this.$event;
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            Config config = Config.INSTANCE;
            if (config.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), "Tracking event: " + featureEvent);
            }
            FeatureEvent featureEvent2 = this.$event;
            if (featureEvent2 instanceof PaywallEvent) {
                backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((PaywallEvent) featureEvent2, this.this$0.identityManager.getCurrentAppUserID());
            } else if (featureEvent2 instanceof CustomerCenterImpressionEvent) {
                String currentAppUserID = this.this$0.identityManager.getCurrentAppUserID();
                String string = this.this$0.appSessionID$1.toString();
                r.e(string, "appSessionID.toString()");
                backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomerCenterImpressionEvent) featureEvent2, currentAppUserID, string);
            } else if (featureEvent2 instanceof CustomerCenterSurveyOptionChosenEvent) {
                String currentAppUserID2 = this.this$0.identityManager.getCurrentAppUserID();
                String string2 = this.this$0.appSessionID$1.toString();
                r.e(string2, "appSessionID.toString()");
                backendStoredEvent = BackendStoredEventKt.toBackendStoredEvent((CustomerCenterSurveyOptionChosenEvent) featureEvent2, currentAppUserID2, string2);
            } else {
                backendStoredEvent = null;
            }
            if (backendStoredEvent != null) {
                this.this$0.fileHelper.appendEvent(backendStoredEvent);
                return;
            }
            FeatureEvent featureEvent3 = this.$event;
            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
            if (config.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler2.d("[Purchases] - " + logLevel.name(), "Backend event not implemented for: " + featureEvent3);
            }
        }
    }

    static {
        UUID uuidRandomUUID = UUID.randomUUID();
        r.e(uuidRandomUUID, "randomUUID()");
        appSessionID = uuidRandomUUID;
        json = n.b(null, EventsManager$Companion$json$1.INSTANCE, 1, null);
    }

    public EventsManager(UUID appSessionID2, EventsFileHelper<PaywallStoredEvent> legacyEventsFileHelper, EventsFileHelper<BackendStoredEvent> fileHelper, IdentityManager identityManager, Dispatcher eventsDispatcher, p postEvents) {
        r.f(appSessionID2, "appSessionID");
        r.f(legacyEventsFileHelper, "legacyEventsFileHelper");
        r.f(fileHelper, "fileHelper");
        r.f(identityManager, "identityManager");
        r.f(eventsDispatcher, "eventsDispatcher");
        r.f(postEvents, "postEvents");
        this.appSessionID$1 = appSessionID2;
        this.legacyEventsFileHelper = legacyEventsFileHelper;
        this.fileHelper = fileHelper;
        this.identityManager = identityManager;
        this.eventsDispatcher = eventsDispatcher;
        this.postEvents = postEvents;
    }

    private final void enqueue(Delay delay, final Function0 function0) {
        this.eventsDispatcher.enqueue(new Runnable() { // from class: com.revenuecat.purchases.common.events.a
            @Override // java.lang.Runnable
            public final void run() {
                EventsManager.enqueue$lambda$0(function0);
            }
        }, delay);
    }

    public static /* synthetic */ void enqueue$default(EventsManager eventsManager, Delay delay, Function0 function0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            delay = Delay.NONE;
        }
        eventsManager.enqueue(delay, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enqueue$lambda$0(Function0 command) {
        r.f(command, "$command");
        command.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void flushLegacyEvents() {
        enqueue$default(this, null, new C11431(), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<PaywallStoredEvent> getLegacyPaywallsStoredEvents() {
        F f4 = new F();
        f4.f13410a = AbstractC0769p.g();
        this.legacyEventsFileHelper.readFile(new C11441(f4));
        return (List) f4.f13410a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<BackendStoredEvent> getStoredEvents() {
        F f4 = new F();
        f4.f13410a = AbstractC0769p.g();
        this.fileHelper.readFile(new C11451(f4));
        return (List) f4.f13410a;
    }

    public final synchronized void flushEvents() {
        enqueue$default(this, null, new AnonymousClass1(), 1, null);
    }

    public final synchronized void track(FeatureEvent event) {
        r.f(event, "event");
        enqueue$default(this, null, new C11461(event, this), 1, null);
    }

    public /* synthetic */ EventsManager(UUID uuid, EventsFileHelper eventsFileHelper, EventsFileHelper eventsFileHelper2, IdentityManager identityManager, Dispatcher dispatcher, p pVar, int i4, AbstractC1585j abstractC1585j) {
        this((i4 & 1) != 0 ? appSessionID : uuid, eventsFileHelper, eventsFileHelper2, identityManager, dispatcher, pVar);
    }
}
