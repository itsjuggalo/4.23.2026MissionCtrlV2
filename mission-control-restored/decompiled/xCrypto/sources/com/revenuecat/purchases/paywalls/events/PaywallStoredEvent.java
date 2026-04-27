package com.revenuecat.purchases.paywalls.events;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import K3.a;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.utils.Event;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallStoredEvent implements Event {
    public static final Companion Companion = new Companion(null);
    private static final a.C0033a json = a.f1326d;
    private final PaywallEvent event;
    private final String userID;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final PaywallStoredEvent fromString(String string) {
            r.f(string, "string");
            a.C0033a json = getJson();
            json.a();
            return (PaywallStoredEvent) json.d(PaywallStoredEvent.Companion.serializer(), string);
        }

        public final a.C0033a getJson() {
            return PaywallStoredEvent.json;
        }

        public final b serializer() {
            return PaywallStoredEvent$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaywallStoredEvent(int i4, PaywallEvent paywallEvent, String str, k0 k0Var) {
        if (3 != (i4 & 3)) {
            AbstractC0325a0.a(i4, 3, PaywallStoredEvent$$serializer.INSTANCE.getDescriptor());
        }
        this.event = paywallEvent;
        this.userID = str;
    }

    public static /* synthetic */ PaywallStoredEvent copy$default(PaywallStoredEvent paywallStoredEvent, PaywallEvent paywallEvent, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            paywallEvent = paywallStoredEvent.event;
        }
        if ((i4 & 2) != 0) {
            str = paywallStoredEvent.userID;
        }
        return paywallStoredEvent.copy(paywallEvent, str);
    }

    public static final /* synthetic */ void write$Self(PaywallStoredEvent paywallStoredEvent, d dVar, e eVar) {
        dVar.u(eVar, 0, PaywallEvent$$serializer.INSTANCE, paywallStoredEvent.event);
        dVar.o(eVar, 1, paywallStoredEvent.userID);
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
        a.C0033a c0033a = json;
        c0033a.a();
        return c0033a.b(Companion.serializer(), this);
    }

    public PaywallStoredEvent(PaywallEvent event, String userID) {
        r.f(event, "event");
        r.f(userID, "userID");
        this.event = event;
        this.userID = userID;
    }
}
