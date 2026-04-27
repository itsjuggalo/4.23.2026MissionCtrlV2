package io.flutter.plugins.firebase.database;

import c3.InterfaceC1252a;
import io.flutter.plugin.common.EventChannel;

/* JADX INFO: loaded from: classes.dex */
public class ChildEventsProxy extends EventsProxy implements InterfaceC1252a {
    public ChildEventsProxy(EventChannel.EventSink eventSink, String str) {
        super(eventSink, str);
    }

    @Override // c3.InterfaceC1252a
    public void onCancelled(c3.c cVar) {
        FlutterFirebaseDatabaseException flutterFirebaseDatabaseExceptionFromDatabaseError = FlutterFirebaseDatabaseException.fromDatabaseError(cVar);
        this.eventSink.error(flutterFirebaseDatabaseExceptionFromDatabaseError.getCode(), flutterFirebaseDatabaseExceptionFromDatabaseError.getMessage(), flutterFirebaseDatabaseExceptionFromDatabaseError.getAdditionalData());
    }

    @Override // c3.InterfaceC1252a
    public void onChildAdded(c3.b bVar, String str) {
        sendEvent(Constants.EVENT_TYPE_CHILD_ADDED, bVar, str);
    }

    @Override // c3.InterfaceC1252a
    public void onChildChanged(c3.b bVar, String str) {
        sendEvent(Constants.EVENT_TYPE_CHILD_CHANGED, bVar, str);
    }

    @Override // c3.InterfaceC1252a
    public void onChildMoved(c3.b bVar, String str) {
        sendEvent(Constants.EVENT_TYPE_CHILD_MOVED, bVar, str);
    }

    @Override // c3.InterfaceC1252a
    public void onChildRemoved(c3.b bVar) {
        sendEvent(Constants.EVENT_TYPE_CHILD_REMOVED, bVar, null);
    }
}
