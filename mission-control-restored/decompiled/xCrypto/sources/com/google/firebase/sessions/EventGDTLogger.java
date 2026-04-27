package com.google.firebase.sessions;

import X0.h;
import X0.j;
import android.util.Log;
import com.google.firebase.inject.Provider;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import r3.C1756c;

/* JADX INFO: loaded from: classes.dex */
public final class EventGDTLogger implements EventGDTLoggerInterface {
    private static final String AQS_LOG_SOURCE = "FIREBASE_APPQUALITY_SESSION";
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "EventGDTLogger";
    private final Provider<j> transportFactoryProvider;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    public EventGDTLogger(Provider<j> transportFactoryProvider) {
        r.f(transportFactoryProvider, "transportFactoryProvider");
        this.transportFactoryProvider = transportFactoryProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] encode(SessionEvent sessionEvent) {
        String strEncode = SessionEvents.INSTANCE.getSESSION_EVENT_ENCODER$com_google_firebase_firebase_sessions().encode(sessionEvent);
        r.e(strEncode, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        Log.d(TAG, "Session Event Type: " + sessionEvent.getEventType().name());
        byte[] bytes = strEncode.getBytes(C1756c.f14563b);
        r.e(bytes, "getBytes(...)");
        return bytes;
    }

    @Override // com.google.firebase.sessions.EventGDTLoggerInterface
    public void log(SessionEvent sessionEvent) {
        r.f(sessionEvent, "sessionEvent");
        this.transportFactoryProvider.get().a(AQS_LOG_SOURCE, SessionEvent.class, X0.c.b("json"), new h() { // from class: com.google.firebase.sessions.a
            @Override // X0.h
            public final Object apply(Object obj) {
                return this.f10810a.encode((SessionEvent) obj);
            }
        }).a(X0.d.f(sessionEvent));
    }
}
