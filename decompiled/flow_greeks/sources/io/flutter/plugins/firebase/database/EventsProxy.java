package io.flutter.plugins.firebase.database;

import io.flutter.plugin.common.EventChannel;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J1\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u000f\u001a\u00020\u000e2\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\n\b\u0001\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0003\u001a\u00020\u00028\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/flutter/plugins/firebase/database/EventsProxy;", "", "Lio/flutter/plugin/common/EventChannel$EventSink;", "eventSink", "", Constants.EVENT_TYPE, "<init>", "(Lio/flutter/plugin/common/EventChannel$EventSink;Ljava/lang/String;)V", "previousChildName", "", "buildAdditionalParams", "(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;", "Le8/b;", Constants.SNAPSHOT, "Lcd/h0;", "sendEvent", "(Ljava/lang/String;Le8/b;Ljava/lang/String;)V", "Lio/flutter/plugin/common/EventChannel$EventSink;", "getEventSink", "()Lio/flutter/plugin/common/EventChannel$EventSink;", "Ljava/lang/String;", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class EventsProxy {
    private final EventChannel.EventSink eventSink;
    private final String eventType;

    public EventsProxy(EventChannel.EventSink eventSink, String eventType) {
        kotlin.jvm.internal.t.f(eventSink, "eventSink");
        kotlin.jvm.internal.t.f(eventType, "eventType");
        this.eventSink = eventSink;
        this.eventType = eventType;
    }

    public final Map<String, Object> buildAdditionalParams(String eventType, String previousChildName) {
        kotlin.jvm.internal.t.f(eventType, "eventType");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(Constants.EVENT_TYPE, eventType);
        if (previousChildName != null) {
            linkedHashMap.put(Constants.PREVIOUS_CHILD_NAME, previousChildName);
        }
        return linkedHashMap;
    }

    public final EventChannel.EventSink getEventSink() {
        return this.eventSink;
    }

    public final void sendEvent(String eventType, e8.b snapshot, String previousChildName) {
        kotlin.jvm.internal.t.f(eventType, "eventType");
        kotlin.jvm.internal.t.f(snapshot, "snapshot");
        if (kotlin.jvm.internal.t.b(this.eventType, eventType)) {
            this.eventSink.success(new FlutterDataSnapshotPayload(snapshot).withAdditionalParams(buildAdditionalParams(eventType, previousChildName)).toMap());
        }
    }
}
