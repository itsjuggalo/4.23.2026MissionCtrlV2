package com.revenuecat.purchases.common.events;

import F5.AbstractC0557o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;
import r6.AbstractC2611a0;
import r6.C2618e;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class EventsRequest {
    private final List<BackendEvent> events;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {new C2618e(BackendEvent.Companion.serializer())};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return EventsRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ EventsRequest(int i7, List list, k0 k0Var) {
        if (1 != (i7 & 1)) {
            AbstractC2611a0.a(i7, 1, EventsRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.events = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EventsRequest copy$default(EventsRequest eventsRequest, List list, int i7, Object obj) {
        if ((i7 & 1) != 0) {
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
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(list, 10));
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
