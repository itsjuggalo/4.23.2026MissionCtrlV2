package io.flutter.plugins.firebase.database;

import io.flutter.plugin.common.EventChannel;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u00020\t2\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/flutter/plugins/firebase/database/ValueEventsProxy;", "Lio/flutter/plugins/firebase/database/EventsProxy;", "Le8/s;", "Lio/flutter/plugin/common/EventChannel$EventSink;", "eventSink", "<init>", "(Lio/flutter/plugin/common/EventChannel$EventSink;)V", "Le8/b;", Constants.SNAPSHOT, "Lcd/h0;", "onDataChange", "(Le8/b;)V", "Le8/c;", "error", "onCancelled", "(Le8/c;)V", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ValueEventsProxy extends EventsProxy implements e8.s {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ValueEventsProxy(EventChannel.EventSink eventSink) {
        super(eventSink, "value");
        kotlin.jvm.internal.t.f(eventSink, "eventSink");
    }

    @Override // e8.s
    public void onCancelled(e8.c error) {
        kotlin.jvm.internal.t.f(error, "error");
        FlutterFirebaseDatabaseException flutterFirebaseDatabaseExceptionFromDatabaseError = FlutterFirebaseDatabaseException.INSTANCE.fromDatabaseError(error);
        getEventSink().error(flutterFirebaseDatabaseExceptionFromDatabaseError.getCode(), flutterFirebaseDatabaseExceptionFromDatabaseError.getMessage(), flutterFirebaseDatabaseExceptionFromDatabaseError.getAdditionalData());
    }

    @Override // e8.s
    public void onDataChange(e8.b snapshot) {
        kotlin.jvm.internal.t.f(snapshot, "snapshot");
        sendEvent("value", snapshot, null);
    }
}
