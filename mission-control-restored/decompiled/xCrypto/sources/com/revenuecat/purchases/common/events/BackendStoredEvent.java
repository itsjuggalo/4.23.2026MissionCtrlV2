package com.revenuecat.purchases.common.events;

import F3.b;
import F3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import W2.j;
import W2.k;
import W2.l;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.utils.Event;
import java.lang.annotation.Annotation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import p3.InterfaceC1716c;

/* JADX INFO: loaded from: classes.dex */
public abstract class BackendStoredEvent implements Event {
    public static final Companion Companion = new Companion(null);
    private static final j $cachedSerializer$delegate = k.a(l.f5481b, Companion.AnonymousClass1.INSTANCE);

    public static final class Companion {

        /* JADX INFO: renamed from: com.revenuecat.purchases.common.events.BackendStoredEvent$Companion$1, reason: invalid class name */
        public static final class AnonymousClass1 extends s implements Function0 {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final b invoke() {
                return new e("com.revenuecat.purchases.common.events.BackendStoredEvent", G.b(BackendStoredEvent.class), new InterfaceC1716c[]{G.b(CustomerCenter.class), G.b(Paywalls.class)}, new b[]{BackendStoredEvent$CustomerCenter$$serializer.INSTANCE, BackendStoredEvent$Paywalls$$serializer.INSTANCE}, new Annotation[0]);
            }
        }

        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private final /* synthetic */ b get$cachedSerializer() {
            return (b) BackendStoredEvent.$cachedSerializer$delegate.getValue();
        }

        public final b serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

    public static final class CustomerCenter extends BackendStoredEvent {
        public static final Companion Companion = new Companion(null);
        private final BackendEvent.CustomerCenter event;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return BackendStoredEvent$CustomerCenter$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ CustomerCenter(int i4, BackendEvent.CustomerCenter customerCenter, k0 k0Var) {
            super(i4, k0Var);
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, BackendStoredEvent$CustomerCenter$$serializer.INSTANCE.getDescriptor());
            }
            this.event = customerCenter;
        }

        public static /* synthetic */ CustomerCenter copy$default(CustomerCenter customerCenter, BackendEvent.CustomerCenter customerCenter2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                customerCenter2 = customerCenter.event;
            }
            return customerCenter.copy(customerCenter2);
        }

        public static final /* synthetic */ void write$Self(CustomerCenter customerCenter, d dVar, H3.e eVar) {
            BackendStoredEvent.write$Self(customerCenter, dVar, eVar);
            dVar.u(eVar, 0, BackendEvent$CustomerCenter$$serializer.INSTANCE, customerCenter.event);
        }

        public final BackendEvent.CustomerCenter component1() {
            return this.event;
        }

        public final CustomerCenter copy(BackendEvent.CustomerCenter event) {
            r.f(event, "event");
            return new CustomerCenter(event);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomerCenter) && r.b(this.event, ((CustomerCenter) obj).event);
        }

        public final BackendEvent.CustomerCenter getEvent() {
            return this.event;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "CustomerCenter(event=" + this.event + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomerCenter(BackendEvent.CustomerCenter event) {
            super(null);
            r.f(event, "event");
            this.event = event;
        }
    }

    public static final class Paywalls extends BackendStoredEvent {
        public static final Companion Companion = new Companion(null);
        private final BackendEvent.Paywalls event;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return BackendStoredEvent$Paywalls$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Paywalls(int i4, BackendEvent.Paywalls paywalls, k0 k0Var) {
            super(i4, k0Var);
            if (1 != (i4 & 1)) {
                AbstractC0325a0.a(i4, 1, BackendStoredEvent$Paywalls$$serializer.INSTANCE.getDescriptor());
            }
            this.event = paywalls;
        }

        public static /* synthetic */ Paywalls copy$default(Paywalls paywalls, BackendEvent.Paywalls paywalls2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                paywalls2 = paywalls.event;
            }
            return paywalls.copy(paywalls2);
        }

        public static final /* synthetic */ void write$Self(Paywalls paywalls, d dVar, H3.e eVar) {
            BackendStoredEvent.write$Self(paywalls, dVar, eVar);
            dVar.u(eVar, 0, BackendEvent$Paywalls$$serializer.INSTANCE, paywalls.event);
        }

        public final BackendEvent.Paywalls component1() {
            return this.event;
        }

        public final Paywalls copy(BackendEvent.Paywalls event) {
            r.f(event, "event");
            return new Paywalls(event);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Paywalls) && r.b(this.event, ((Paywalls) obj).event);
        }

        public final BackendEvent.Paywalls getEvent() {
            return this.event;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @Override // com.revenuecat.purchases.utils.Event
        public String toString() {
            return "Paywalls(event=" + this.event + ')';
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Paywalls(BackendEvent.Paywalls event) {
            super(null);
            r.f(event, "event");
            this.event = event;
        }
    }

    public /* synthetic */ BackendStoredEvent(AbstractC1585j abstractC1585j) {
        this();
    }

    private BackendStoredEvent() {
    }

    public /* synthetic */ BackendStoredEvent(int i4, k0 k0Var) {
    }

    public static final /* synthetic */ void write$Self(BackendStoredEvent backendStoredEvent, d dVar, H3.e eVar) {
    }
}
