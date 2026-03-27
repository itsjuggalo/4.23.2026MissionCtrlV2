package com.google.firebase.sessions;

import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import java.util.Locale;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import r3.x;

/* JADX INFO: loaded from: classes.dex */
public final class SessionGenerator {
    public static final Companion Companion = new Companion(null);
    private SessionDetails currentSession;
    private final String firstSessionId;
    private int sessionIndex;
    private final TimeProvider timeProvider;
    private final UuidGenerator uuidGenerator;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final SessionGenerator getInstance() {
            return ((FirebaseSessionsComponent) FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessionsComponent.class)).getSessionGenerator();
        }

        private Companion() {
        }
    }

    public SessionGenerator(TimeProvider timeProvider, UuidGenerator uuidGenerator) {
        r.f(timeProvider, "timeProvider");
        r.f(uuidGenerator, "uuidGenerator");
        this.timeProvider = timeProvider;
        this.uuidGenerator = uuidGenerator;
        this.firstSessionId = generateSessionId();
        this.sessionIndex = -1;
    }

    private final String generateSessionId() {
        String string = this.uuidGenerator.next().toString();
        r.e(string, "uuidGenerator.next().toString()");
        String lowerCase = x.A(string, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        r.e(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final SessionDetails generateNewSession() {
        int i4 = this.sessionIndex + 1;
        this.sessionIndex = i4;
        this.currentSession = new SessionDetails(i4 == 0 ? this.firstSessionId : generateSessionId(), this.firstSessionId, this.sessionIndex, this.timeProvider.currentTimeUs());
        return getCurrentSession();
    }

    public final SessionDetails getCurrentSession() {
        SessionDetails sessionDetails = this.currentSession;
        if (sessionDetails != null) {
            return sessionDetails;
        }
        r.t("currentSession");
        return null;
    }

    public final boolean getHasGenerateSession() {
        return this.currentSession != null;
    }
}
