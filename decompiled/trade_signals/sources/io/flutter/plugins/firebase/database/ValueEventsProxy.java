package io.flutter.plugins.firebase.database;

import io.flutter.plugin.common.EventChannel;

/* JADX INFO: loaded from: classes.dex */
public class ValueEventsProxy extends EventsProxy implements c3.s {
    public ValueEventsProxy(EventChannel.EventSink eventSink) {
        super(eventSink, "value");
    }

    @Override // c3.s
    public void onCancelled(c3.c cVar) {
        FlutterFirebaseDatabaseException flutterFirebaseDatabaseExceptionFromDatabaseError = FlutterFirebaseDatabaseException.fromDatabaseError(cVar);
        this.eventSink.error(flutterFirebaseDatabaseExceptionFromDatabaseError.getCode(), flutterFirebaseDatabaseExceptionFromDatabaseError.getMessage(), flutterFirebaseDatabaseExceptionFromDatabaseError.getAdditionalData());
    }

    @Override // c3.s
    public void onDataChange(c3.b bVar) {
        sendEvent("value", bVar, null);
    }
}
