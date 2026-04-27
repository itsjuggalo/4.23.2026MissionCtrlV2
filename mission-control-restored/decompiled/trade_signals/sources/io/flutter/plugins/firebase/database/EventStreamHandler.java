package io.flutter.plugins.firebase.database;

import c3.InterfaceC1252a;
import io.flutter.plugin.common.EventChannel;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class EventStreamHandler implements EventChannel.StreamHandler {
    private InterfaceC1252a childEventListener;
    private final OnDispose onDispose;
    private final c3.p query;
    private c3.s valueEventListener;

    public EventStreamHandler(c3.p pVar, OnDispose onDispose) {
        this.query = pVar;
        this.onDispose = onDispose;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object obj) {
        this.onDispose.run();
        c3.s sVar = this.valueEventListener;
        if (sVar != null) {
            this.query.D(sVar);
            this.valueEventListener = null;
        }
        InterfaceC1252a interfaceC1252a = this.childEventListener;
        if (interfaceC1252a != null) {
            this.query.C(interfaceC1252a);
            this.childEventListener = null;
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object obj, EventChannel.EventSink eventSink) {
        Object obj2 = ((Map) obj).get(Constants.EVENT_TYPE);
        Objects.requireNonNull(obj2);
        String str = (String) obj2;
        if ("value".equals(str)) {
            ValueEventsProxy valueEventsProxy = new ValueEventsProxy(eventSink);
            this.valueEventListener = valueEventsProxy;
            this.query.c(valueEventsProxy);
        } else {
            ChildEventsProxy childEventsProxy = new ChildEventsProxy(eventSink, str);
            this.childEventListener = childEventsProxy;
            this.query.a(childEventsProxy);
        }
    }
}
