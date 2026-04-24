package j4;

import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o7.AbstractC2504f0;
import o7.C2507h;
import o7.C2514k0;
import o7.C2527t;
import o7.E;
import o7.J;
import o7.Q;
import o7.t0;

/* JADX INFO: renamed from: j4.h, reason: case insensitive filesystem and from toString */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0081\b\u0018\u0000 .2\u00020\u0001:\u0002!%B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000b\u0010\u0010J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b'\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b*\u0010)\u001a\u0004\b!\u0010+R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b#\u0010,\u001a\u0004\b%\u0010-¨\u0006/"}, d2 = {"Lj4/h;", "", "", "sessionsEnabled", "", "sessionSamplingRate", "", "sessionTimeoutSeconds", "cacheDurationSeconds", "", "cacheUpdatedTimeSeconds", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "seen0", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Lo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "f", "(Lj4/h;Ln7/d;Lm7/e;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "b", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "Ljava/lang/Long;", "()Ljava/lang/Long;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0})
public final /* data */ class SessionConfigs {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final Boolean sessionsEnabled;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Double sessionSamplingRate;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer sessionTimeoutSeconds;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final Integer cacheDurationSeconds;

    /* JADX INFO: renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final Long cacheUpdatedTimeSeconds;

    /* JADX INFO: renamed from: j4.h$a */
    public /* synthetic */ class a implements E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f20071a;
        private static final m7.e descriptor;

        static {
            a aVar = new a();
            f20071a = aVar;
            C2514k0 c2514k0 = new C2514k0("com.google.firebase.sessions.settings.SessionConfigs", aVar, 5);
            c2514k0.p("sessionsEnabled", false);
            c2514k0.p("sessionSamplingRate", false);
            c2514k0.p("sessionTimeoutSeconds", false);
            c2514k0.p("cacheDurationSeconds", false);
            c2514k0.p("cacheUpdatedTimeSeconds", false);
            descriptor = c2514k0;
        }

        @Override // k7.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SessionConfigs deserialize(n7.e decoder) {
            int i8;
            Boolean bool;
            Double d8;
            Integer num;
            Integer num2;
            Long l8;
            AbstractC2304t.f(decoder, "decoder");
            m7.e eVar = descriptor;
            n7.c cVarC = decoder.c(eVar);
            Boolean bool2 = null;
            if (cVarC.w()) {
                Boolean bool3 = (Boolean) cVarC.z(eVar, 0, C2507h.f22167a, null);
                Double d9 = (Double) cVarC.z(eVar, 1, C2527t.f22207a, null);
                J j8 = J.f22118a;
                Integer num3 = (Integer) cVarC.z(eVar, 2, j8, null);
                bool = bool3;
                num2 = (Integer) cVarC.z(eVar, 3, j8, null);
                l8 = (Long) cVarC.z(eVar, 4, Q.f22138a, null);
                num = num3;
                d8 = d9;
                i8 = 31;
            } else {
                boolean z7 = true;
                int i9 = 0;
                Double d10 = null;
                Integer num4 = null;
                Integer num5 = null;
                Long l9 = null;
                while (z7) {
                    int iE = cVarC.E(eVar);
                    if (iE == -1) {
                        z7 = false;
                    } else if (iE == 0) {
                        bool2 = (Boolean) cVarC.z(eVar, 0, C2507h.f22167a, bool2);
                        i9 |= 1;
                    } else if (iE == 1) {
                        d10 = (Double) cVarC.z(eVar, 1, C2527t.f22207a, d10);
                        i9 |= 2;
                    } else if (iE == 2) {
                        num4 = (Integer) cVarC.z(eVar, 2, J.f22118a, num4);
                        i9 |= 4;
                    } else if (iE == 3) {
                        num5 = (Integer) cVarC.z(eVar, 3, J.f22118a, num5);
                        i9 |= 8;
                    } else {
                        if (iE != 4) {
                            throw new k7.m(iE);
                        }
                        l9 = (Long) cVarC.z(eVar, 4, Q.f22138a, l9);
                        i9 |= 16;
                    }
                }
                i8 = i9;
                bool = bool2;
                d8 = d10;
                num = num4;
                num2 = num5;
                l8 = l9;
            }
            cVarC.d(eVar);
            return new SessionConfigs(i8, bool, d8, num, num2, l8, null);
        }

        @Override // k7.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(n7.f encoder, SessionConfigs value) {
            AbstractC2304t.f(encoder, "encoder");
            AbstractC2304t.f(value, "value");
            m7.e eVar = descriptor;
            n7.d dVarC = encoder.c(eVar);
            SessionConfigs.f(value, dVarC, eVar);
            dVarC.d(eVar);
        }

        @Override // o7.E
        public final k7.b[] childSerializers() {
            k7.b bVarP = l7.a.p(C2507h.f22167a);
            k7.b bVarP2 = l7.a.p(C2527t.f22207a);
            J j8 = J.f22118a;
            return new k7.b[]{bVarP, bVarP2, l7.a.p(j8), l7.a.p(j8), l7.a.p(Q.f22138a)};
        }

        @Override // k7.b, k7.k, k7.a
        public final m7.e getDescriptor() {
            return descriptor;
        }

        @Override // o7.E
        public k7.b[] typeParametersSerializers() {
            return E.a.a(this);
        }
    }

    /* JADX INFO: renamed from: j4.h$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final k7.b serializer() {
            return a.f20071a;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ SessionConfigs(int i8, Boolean bool, Double d8, Integer num, Integer num2, Long l8, t0 t0Var) {
        if (31 != (i8 & 31)) {
            AbstractC2504f0.a(i8, 31, a.f20071a.getDescriptor());
        }
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d8;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l8;
    }

    public static final /* synthetic */ void f(SessionConfigs self, n7.d output, m7.e serialDesc) {
        output.u(serialDesc, 0, C2507h.f22167a, self.sessionsEnabled);
        output.u(serialDesc, 1, C2527t.f22207a, self.sessionSamplingRate);
        J j8 = J.f22118a;
        output.u(serialDesc, 2, j8, self.sessionTimeoutSeconds);
        output.u(serialDesc, 3, j8, self.cacheDurationSeconds);
        output.u(serialDesc, 4, Q.f22138a, self.cacheUpdatedTimeSeconds);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final Integer getCacheDurationSeconds() {
        return this.cacheDurationSeconds;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final Long getCacheUpdatedTimeSeconds() {
        return this.cacheUpdatedTimeSeconds;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final Double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final Integer getSessionTimeoutSeconds() {
        return this.sessionTimeoutSeconds;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final Boolean getSessionsEnabled() {
        return this.sessionsEnabled;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) other;
        return AbstractC2304t.b(this.sessionsEnabled, sessionConfigs.sessionsEnabled) && AbstractC2304t.b(this.sessionSamplingRate, sessionConfigs.sessionSamplingRate) && AbstractC2304t.b(this.sessionTimeoutSeconds, sessionConfigs.sessionTimeoutSeconds) && AbstractC2304t.b(this.cacheDurationSeconds, sessionConfigs.cacheDurationSeconds) && AbstractC2304t.b(this.cacheUpdatedTimeSeconds, sessionConfigs.cacheUpdatedTimeSeconds);
    }

    public int hashCode() {
        Boolean bool = this.sessionsEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d8 = this.sessionSamplingRate;
        int iHashCode2 = (iHashCode + (d8 == null ? 0 : d8.hashCode())) * 31;
        Integer num = this.sessionTimeoutSeconds;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cacheDurationSeconds;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l8 = this.cacheUpdatedTimeSeconds;
        return iHashCode4 + (l8 != null ? l8.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.sessionsEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionTimeoutSeconds=" + this.sessionTimeoutSeconds + ", cacheDurationSeconds=" + this.cacheDurationSeconds + ", cacheUpdatedTimeSeconds=" + this.cacheUpdatedTimeSeconds + ')';
    }

    public SessionConfigs(Boolean bool, Double d8, Integer num, Integer num2, Long l8) {
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d8;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l8;
    }
}
