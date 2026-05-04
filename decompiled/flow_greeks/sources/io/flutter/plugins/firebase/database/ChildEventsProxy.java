package io.flutter.plugins.firebase.database;

import io.flutter.plugin.common.EventChannel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\r\u001a\u00020\f2\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u000f\u001a\u00020\f2\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\f2\b\b\u0001\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0012\u001a\u00020\f2\b\b\u0001\u0010\n\u001a\u00020\t2\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\f2\b\b\u0001\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lio/flutter/plugins/firebase/database/ChildEventsProxy;", "Lio/flutter/plugins/firebase/database/EventsProxy;", "Le8/a;", "Lio/flutter/plugin/common/EventChannel$EventSink;", "eventSink", "", Constants.EVENT_TYPE, "<init>", "(Lio/flutter/plugin/common/EventChannel$EventSink;Ljava/lang/String;)V", "Le8/b;", Constants.SNAPSHOT, "previousChildName", "Lcd/h0;", "onChildAdded", "(Le8/b;Ljava/lang/String;)V", "onChildChanged", "onChildRemoved", "(Le8/b;)V", "onChildMoved", "Le8/c;", "error", "onCancelled", "(Le8/c;)V", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChildEventsProxy extends EventsProxy implements e8.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChildEventsProxy(EventChannel.EventSink eventSink, String eventType) {
        super(eventSink, eventType);
        kotlin.jvm.internal.t.f(eventSink, "eventSink");
        kotlin.jvm.internal.t.f(eventType, "eventType");
    }

    @Override // e8.a
    public void onCancelled(e8.c error) {
        kotlin.jvm.internal.t.f(error, "error");
        FlutterFirebaseDatabaseException flutterFirebaseDatabaseExceptionFromDatabaseError = FlutterFirebaseDatabaseException.INSTANCE.fromDatabaseError(error);
        getEventSink().error(flutterFirebaseDatabaseExceptionFromDatabaseError.getCode(), flutterFirebaseDatabaseExceptionFromDatabaseError.getMessage(), flutterFirebaseDatabaseExceptionFromDatabaseError.getAdditionalData());
    }

    @Override // e8.a
    public void onChildAdded(e8.b snapshot, String previousChildName) {
        kotlin.jvm.internal.t.f(snapshot, "snapshot");
        sendEvent(Constants.EVENT_TYPE_CHILD_ADDED, snapshot, previousChildName);
    }

    @Override // e8.a
    public void onChildChanged(e8.b snapshot, String previousChildName) {
        kotlin.jvm.internal.t.f(snapshot, "snapshot");
        sendEvent(Constants.EVENT_TYPE_CHILD_CHANGED, snapshot, previousChildName);
    }

    @Override // e8.a
    public void onChildMoved(e8.b snapshot, String previousChildName) {
        kotlin.jvm.internal.t.f(snapshot, "snapshot");
        sendEvent(Constants.EVENT_TYPE_CHILD_MOVED, snapshot, previousChildName);
    }

    @Override // e8.a
    public void onChildRemoved(e8.b snapshot) {
        kotlin.jvm.internal.t.f(snapshot, "snapshot");
        sendEvent(Constants.EVENT_TYPE_CHILD_REMOVED, snapshot, null);
    }
}
