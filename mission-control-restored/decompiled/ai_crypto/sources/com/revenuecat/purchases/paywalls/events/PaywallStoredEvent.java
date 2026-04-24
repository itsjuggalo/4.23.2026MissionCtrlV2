package com.revenuecat.purchases.paywalls.events;

import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.utils.Event;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.k0;
import s6.a;

/* JADX INFO: loaded from: classes2.dex */
public final class PaywallStoredEvent implements Event {
    public static final Companion Companion = new Companion(null);
    private static final a.C0359a json = a.f23013d;
    private final PaywallEvent event;
    private final String userID;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final PaywallStoredEvent fromString(String string) {
            r.f(string, "string");
            a.C0359a json = getJson();
            json.a();
            return (PaywallStoredEvent) json.d(PaywallStoredEvent.Companion.serializer(), string);
        }

        public final a.C0359a getJson() {
            return PaywallStoredEvent.json;
        }

        public final b serializer() {
            return PaywallStoredEvent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaywallStoredEvent(int i7, PaywallEvent paywallEvent, String str, k0 k0Var) {
        if (3 != (i7 & 3)) {
            AbstractC2611a0.a(i7, 3, PaywallStoredEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.event = paywallEvent;
        this.userID = str;
    }

    public static /* synthetic */ PaywallStoredEvent copy$default(PaywallStoredEvent paywallStoredEvent, PaywallEvent paywallEvent, String str, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            paywallEvent = paywallStoredEvent.event;
        }
        if ((i7 & 2) != 0) {
            str = paywallStoredEvent.userID;
        }
        return paywallStoredEvent.copy(paywallEvent, str);
    }

    public static final /* synthetic */ void write$Self(PaywallStoredEvent paywallStoredEvent, d dVar, e eVar) {
        dVar.x(eVar, 0, PaywallEvent$$serializer.INSTANCE, paywallStoredEvent.event);
        dVar.m(eVar, 1, paywallStoredEvent.userID);
    }

    public final PaywallEvent component1() {
        return this.event;
    }

    public final String component2() {
        return this.userID;
    }

    public final PaywallStoredEvent copy(PaywallEvent event, String userID) {
        r.f(event, "event");
        r.f(userID, "userID");
        return new PaywallStoredEvent(event, userID);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallStoredEvent)) {
            return false;
        }
        PaywallStoredEvent paywallStoredEvent = (PaywallStoredEvent) obj;
        return r.b(this.event, paywallStoredEvent.event) && r.b(this.userID, paywallStoredEvent.userID);
    }

    public final PaywallEvent getEvent() {
        return this.event;
    }

    public final String getUserID() {
        return this.userID;
    }

    public int hashCode() {
        return (this.event.hashCode() * 31) + this.userID.hashCode();
    }

    public final BackendEvent.Paywalls toBackendEvent() {
        String string = this.event.getCreationData().getId().toString();
        r.e(string, "event.creationData.id.toString()");
        String value = this.event.getType().getValue();
        String str = this.userID;
        String string2 = this.event.getData().getSessionIdentifier().toString();
        r.e(string2, "event.data.sessionIdentifier.toString()");
        return new BackendEvent.Paywalls(string, 1, value, str, string2, this.event.getData().getOfferingIdentifier(), this.event.getData().getPaywallRevision(), this.event.getCreationData().getDate().getTime(), this.event.getData().getDisplayMode(), this.event.getData().getDarkMode(), this.event.getData().getLocaleIdentifier());
    }

    @Override // com.revenuecat.purchases.utils.Event
    public String toString() {
        a.C0359a c0359a = json;
        c0359a.a();
        return c0359a.b(Companion.serializer(), this);
    }

    public PaywallStoredEvent(PaywallEvent event, String userID) {
        r.f(event, "event");
        r.f(userID, "userID");
        this.event = event;
        this.userID = userID;
    }
}
