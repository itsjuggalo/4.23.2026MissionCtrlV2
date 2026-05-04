package ua;

import dh.e0;
import dh.e1;
import dh.j1;
import dh.s1;
import dh.w1;
import java.util.Map;
import kotlin.Metadata;
import ua.ProcessData;
import ua.SessionDetails;
import ua.Time;

/* JADX INFO: renamed from: ua.e0, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0081\b\u0018\u0000 .2\u00020\u0001:\u0002#\u0019B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\n\u0010\u000bBE\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J>\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0019\u0010'\u001a\u0004\b(\u0010)R%\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lua/e0;", "", "Lua/h0;", "sessionDetails", "Lua/v0;", "backgroundTime", "", "", "Lua/v;", "processDataMap", "<init>", "(Lua/h0;Lua/v0;Ljava/util/Map;)V", "", "seen0", "Ldh/s1;", "serializationConstructorMarker", "(ILua/h0;Lua/v0;Ljava/util/Map;Ldh/s1;)V", "self", "Lch/d;", "output", "Lbh/e;", "serialDesc", "Lcd/h0;", "g", "(Lua/e0;Lch/d;Lbh/e;)V", "b", "(Lua/h0;Lua/v0;Ljava/util/Map;)Lua/e0;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Lua/h0;", "f", "()Lua/h0;", "Lua/v0;", "d", "()Lua/v0;", "c", "Ljava/util/Map;", "e", "()Ljava/util/Map;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class SessionData {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zg.b[] f22572d = {null, null, new dh.m0(w1.f8244a, ProcessData.a.f22715a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final SessionDetails sessionDetails;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Time backgroundTime;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Map processDataMap;

    /* JADX INFO: renamed from: ua.e0$a */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a implements dh.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22576a;
        private static final bh.e descriptor;

        static {
            a aVar = new a();
            f22576a = aVar;
            j1 j1Var = new j1("com.google.firebase.sessions.SessionData", aVar, 3);
            j1Var.g("sessionDetails", false);
            j1Var.g("backgroundTime", true);
            j1Var.g("processDataMap", true);
            descriptor = j1Var;
        }

        @Override // zg.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SessionData deserialize(ch.e decoder) {
            int i10;
            SessionDetails sessionDetails;
            Time time;
            Map map;
            kotlin.jvm.internal.t.f(decoder, "decoder");
            bh.e eVar = descriptor;
            ch.c cVarB = decoder.b(eVar);
            zg.b[] bVarArr = SessionData.f22572d;
            SessionDetails sessionDetails2 = null;
            if (cVarB.z()) {
                SessionDetails sessionDetails3 = (SessionDetails) cVarB.h(eVar, 0, SessionDetails.a.f22586a, null);
                Time time2 = (Time) cVarB.n(eVar, 1, Time.a.f22719a, null);
                map = (Map) cVarB.n(eVar, 2, bVarArr[2], null);
                sessionDetails = sessionDetails3;
                i10 = 7;
                time = time2;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Time time3 = null;
                Map map2 = null;
                while (z10) {
                    int iW = cVarB.w(eVar);
                    if (iW == -1) {
                        z10 = false;
                    } else if (iW == 0) {
                        sessionDetails2 = (SessionDetails) cVarB.h(eVar, 0, SessionDetails.a.f22586a, sessionDetails2);
                        i11 |= 1;
                    } else if (iW == 1) {
                        time3 = (Time) cVarB.n(eVar, 1, Time.a.f22719a, time3);
                        i11 |= 2;
                    } else {
                        if (iW != 2) {
                            throw new zg.m(iW);
                        }
                        map2 = (Map) cVarB.n(eVar, 2, bVarArr[2], map2);
                        i11 |= 4;
                    }
                }
                i10 = i11;
                sessionDetails = sessionDetails2;
                time = time3;
                map = map2;
            }
            cVarB.c(eVar);
            return new SessionData(i10, sessionDetails, time, map, (s1) null);
        }

        @Override // zg.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(ch.f encoder, SessionData value) {
            kotlin.jvm.internal.t.f(encoder, "encoder");
            kotlin.jvm.internal.t.f(value, "value");
            bh.e eVar = descriptor;
            ch.d dVarB = encoder.b(eVar);
            SessionData.g(value, dVarB, eVar);
            dVarB.c(eVar);
        }

        @Override // dh.e0
        public final zg.b[] childSerializers() {
            return new zg.b[]{SessionDetails.a.f22586a, ah.a.p(Time.a.f22719a), ah.a.p(SessionData.f22572d[2])};
        }

        @Override // zg.b, zg.k, zg.a
        public final bh.e getDescriptor() {
            return descriptor;
        }

        @Override // dh.e0
        public zg.b[] typeParametersSerializers() {
            return e0.a.a(this);
        }
    }

    /* JADX INFO: renamed from: ua.e0$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class Companion {
        public Companion() {
        }

        public final zg.b serializer() {
            return a.f22576a;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public /* synthetic */ SessionData(int i10, SessionDetails sessionDetails, Time time, Map map, s1 s1Var) {
        if (1 != (i10 & 1)) {
            e1.a(i10, 1, a.f22576a.getDescriptor());
        }
        this.sessionDetails = sessionDetails;
        if ((i10 & 2) == 0) {
            this.backgroundTime = null;
        } else {
            this.backgroundTime = time;
        }
        if ((i10 & 4) == 0) {
            this.processDataMap = null;
        } else {
            this.processDataMap = map;
        }
    }

    public static /* synthetic */ SessionData c(SessionData sessionData, SessionDetails sessionDetails, Time time, Map map, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            sessionDetails = sessionData.sessionDetails;
        }
        if ((i10 & 2) != 0) {
            time = sessionData.backgroundTime;
        }
        if ((i10 & 4) != 0) {
            map = sessionData.processDataMap;
        }
        return sessionData.b(sessionDetails, time, map);
    }

    public static final /* synthetic */ void g(SessionData self, ch.d output, bh.e serialDesc) {
        zg.b[] bVarArr = f22572d;
        output.n(serialDesc, 0, SessionDetails.a.f22586a, self.sessionDetails);
        if (output.o(serialDesc, 1) || self.backgroundTime != null) {
            output.e(serialDesc, 1, Time.a.f22719a, self.backgroundTime);
        }
        if (!output.o(serialDesc, 2) && self.processDataMap == null) {
            return;
        }
        output.e(serialDesc, 2, bVarArr[2], self.processDataMap);
    }

    public final SessionData b(SessionDetails sessionDetails, Time backgroundTime, Map processDataMap) {
        kotlin.jvm.internal.t.f(sessionDetails, "sessionDetails");
        return new SessionData(sessionDetails, backgroundTime, processDataMap);
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Time getBackgroundTime() {
        return this.backgroundTime;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Map getProcessDataMap() {
        return this.processDataMap;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionData)) {
            return false;
        }
        SessionData sessionData = (SessionData) other;
        return kotlin.jvm.internal.t.b(this.sessionDetails, sessionData.sessionDetails) && kotlin.jvm.internal.t.b(this.backgroundTime, sessionData.backgroundTime) && kotlin.jvm.internal.t.b(this.processDataMap, sessionData.processDataMap);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final SessionDetails getSessionDetails() {
        return this.sessionDetails;
    }

    public int hashCode() {
        int iHashCode = this.sessionDetails.hashCode() * 31;
        Time time = this.backgroundTime;
        int iHashCode2 = (iHashCode + (time == null ? 0 : time.hashCode())) * 31;
        Map map = this.processDataMap;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SessionData(sessionDetails=" + this.sessionDetails + ", backgroundTime=" + this.backgroundTime + ", processDataMap=" + this.processDataMap + ')';
    }

    public SessionData(SessionDetails sessionDetails, Time time, Map map) {
        kotlin.jvm.internal.t.f(sessionDetails, "sessionDetails");
        this.sessionDetails = sessionDetails;
        this.backgroundTime = time;
        this.processDataMap = map;
    }

    public /* synthetic */ SessionData(SessionDetails sessionDetails, Time time, Map map, int i10, kotlin.jvm.internal.k kVar) {
        this(sessionDetails, (i10 & 2) != 0 ? null : time, (i10 & 4) != 0 ? null : map);
    }
}
