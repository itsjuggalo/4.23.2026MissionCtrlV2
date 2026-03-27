package com.revenuecat.purchases.common.events;

import F3.b;
import J3.AbstractC0325a0;
import J3.C0332e;
import J3.k0;
import X2.AbstractC0770q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class EventsRequest {
    private final List<BackendEvent> events;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {new C0332e(BackendEvent.Companion.serializer())};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return EventsRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ EventsRequest(int i4, List list, k0 k0Var) {
        if (1 != (i4 & 1)) {
            AbstractC0325a0.a(i4, 1, EventsRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.events = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventsRequest copy$default(EventsRequest eventsRequest, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            list = eventsRequest.events;
        }
        return eventsRequest.copy(list);
    }

    public final List<BackendEvent> component1$purchases_defaultsRelease() {
        return this.events;
    }

    public final EventsRequest copy(List<? extends BackendEvent> events) {
        r.f(events, "events");
        return new EventsRequest(events);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof EventsRequest) && r.b(this.events, ((EventsRequest) obj).events);
    }

    public final List<String> getCacheKey() {
        List<BackendEvent> list = this.events;
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((BackendEvent) it.next()).hashCode()));
        }
        return arrayList;
    }

    public final List<BackendEvent> getEvents$purchases_defaultsRelease() {
        return this.events;
    }

    public int hashCode() {
        return this.events.hashCode();
    }

    public String toString() {
        return "EventsRequest(events=" + this.events + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventsRequest(List<? extends BackendEvent> events) {
        r.f(events, "events");
        this.events = events;
    }
}
