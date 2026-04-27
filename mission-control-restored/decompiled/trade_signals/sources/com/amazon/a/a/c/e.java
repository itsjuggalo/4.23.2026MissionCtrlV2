package com.amazon.a.a.c;

import com.amazon.a.a.c.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class e<EventType extends a> implements Comparator<c<EventType>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.amazon.a.a.o.c f13730a = new com.amazon.a.a.o.c("EventListenerNotificationQueue");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List<c<EventType>> f13731b = new ArrayList();

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(c<EventType> cVar, c<EventType> cVar2) {
        return cVar.b().compareTo(cVar2.b());
    }

    public void a(EventType eventtype) {
        for (c<EventType> cVar : this.f13731b) {
            if (com.amazon.a.a.o.c.f14105a) {
                f13730a.a("Notifying listener: " + cVar);
            }
            cVar.a(eventtype);
        }
    }

    public void a(c<EventType> cVar) {
        if (com.amazon.a.a.o.c.f14105a) {
            f13730a.a("Adding listener: " + cVar);
        }
        this.f13731b.add(cVar);
        Collections.sort(this.f13731b, this);
    }
}
