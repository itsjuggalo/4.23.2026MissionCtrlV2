package io.flutter.plugins.firebase.database;

import android.util.Log;
import io.flutter.plugin.common.EventChannel;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/flutter/plugins/firebase/database/EventStreamHandler;", "Lio/flutter/plugin/common/EventChannel$StreamHandler;", "Le8/p;", "query", "Lio/flutter/plugins/firebase/database/OnDispose;", "onDispose", "<init>", "(Le8/p;Lio/flutter/plugins/firebase/database/OnDispose;)V", "", "arguments", "Lio/flutter/plugin/common/EventChannel$EventSink;", "events", "Lcd/h0;", "onListen", "(Ljava/lang/Object;Lio/flutter/plugin/common/EventChannel$EventSink;)V", "onCancel", "(Ljava/lang/Object;)V", "Le8/p;", "Lio/flutter/plugins/firebase/database/OnDispose;", "Le8/s;", "valueEventListener", "Le8/s;", "Le8/a;", "childEventListener", "Le8/a;", "firebase_database_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EventStreamHandler implements EventChannel.StreamHandler {
    private e8.a childEventListener;
    private final OnDispose onDispose;
    private final e8.p query;
    private e8.s valueEventListener;

    public EventStreamHandler(e8.p query, OnDispose onDispose) {
        kotlin.jvm.internal.t.f(query, "query");
        kotlin.jvm.internal.t.f(onDispose, "onDispose");
        this.query = query;
        this.onDispose = onDispose;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object arguments) {
        try {
            e8.s sVar = this.valueEventListener;
            if (sVar != null) {
                this.query.D(sVar);
                this.valueEventListener = null;
            }
            e8.a aVar = this.childEventListener;
            if (aVar != null) {
                this.query.C(aVar);
                this.childEventListener = null;
            }
            this.onDispose.run();
        } catch (Exception e10) {
            Log.w("EventStreamHandler", "Error during cleanup: " + e10.getMessage());
        }
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object arguments, EventChannel.EventSink events) {
        kotlin.jvm.internal.t.d(arguments, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
        Object obj = ((Map) arguments).get(Constants.EVENT_TYPE);
        kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        if (kotlin.jvm.internal.t.b("value", str)) {
            if (events != null) {
                ValueEventsProxy valueEventsProxy = new ValueEventsProxy(events);
                this.valueEventListener = valueEventsProxy;
                e8.p pVar = this.query;
                kotlin.jvm.internal.t.c(valueEventsProxy);
                pVar.c(valueEventsProxy);
                return;
            }
            return;
        }
        if (events != null) {
            ChildEventsProxy childEventsProxy = new ChildEventsProxy(events, str);
            this.childEventListener = childEventsProxy;
            e8.p pVar2 = this.query;
            kotlin.jvm.internal.t.c(childEventsProxy);
            pVar2.a(childEventsProxy);
        }
    }
}
