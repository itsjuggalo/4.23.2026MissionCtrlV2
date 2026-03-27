package io.flutter.plugins.firebase.database;

import io.flutter.plugin.common.EventChannel;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class EventsProxy {
    protected final EventChannel.EventSink eventSink;
    private final String eventType;

    public EventsProxy(EventChannel.EventSink eventSink, String str) {
        this.eventSink = eventSink;
        this.eventType = str;
    }

    public Map<String, Object> buildAdditionalParams(String str, String str2) {
        HashMap map = new HashMap();
        map.put(Constants.EVENT_TYPE, str);
        if (str2 != null) {
            map.put(Constants.PREVIOUS_CHILD_NAME, str2);
        }
        return map;
    }

    public void sendEvent(String str, c3.b bVar, String str2) {
        if (this.eventType.equals(str)) {
            this.eventSink.success(new FlutterDataSnapshotPayload(bVar).withAdditionalParams(buildAdditionalParams(str, str2)).toMap());
        }
    }
}
