package xa;

import dh.e0;
import dh.e1;
import dh.j0;
import dh.j1;
import dh.q0;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: renamed from: xa.h, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0081\b\u0018\u0000 .2\u00020\u0001:\u0002!%B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fBM\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000b\u0010\u0010J'\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u001f\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b'\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b*\u0010)\u001a\u0004\b!\u0010+R\u0019\u0010\n\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b#\u0010,\u001a\u0004\b%\u0010-¨\u0006/"}, d2 = {"Lxa/h;", "", "", "sessionsEnabled", "", "sessionSamplingRate", "", "sessionTimeoutSeconds", "cacheDurationSeconds", "", "cacheUpdatedTimeSeconds", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;)V", "seen0", "Ldh/s1;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ldh/s1;)V", "self", "Lch/d;", "output", "Lbh/e;", "serialDesc", "Lcd/h0;", "f", "(Lxa/h;Lch/d;Lbh/e;)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/Boolean;", "e", "()Ljava/lang/Boolean;", "b", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "Ljava/lang/Long;", "()Ljava/lang/Long;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    /* JADX INFO: renamed from: xa.h$a */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24751a;
        private static final bh.e descriptor;

        static {
            a aVar = new a();
            f24751a = aVar;
            j1 j1Var = new j1("com.google.firebase.sessions.settings.SessionConfigs", aVar, 5);
            j1Var.g("sessionsEnabled", false);
            j1Var.g("sessionSamplingRate", false);
            j1Var.g("sessionTimeoutSeconds", false);
            j1Var.g("cacheDurationSeconds", false);
            j1Var.g("cacheUpdatedTimeSeconds", false);
            descriptor = j1Var;
        }

        @Override // zg.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SessionConfigs deserialize(ch.e decoder) {
            int i10;
            Boolean bool;
            Double d10;
            Integer num;
            Integer num2;
            Long l10;
            t.f(decoder, "decoder");
            bh.e eVar = descriptor;
            ch.c cVarB = decoder.b(eVar);
            Boolean bool2 = null;
            if (cVarB.z()) {
                Boolean bool3 = (Boolean) cVarB.n(eVar, 0, dh.h.f8149a, null);
                Double d11 = (Double) cVarB.n(eVar, 1, dh.t.f8221a, null);
                j0 j0Var = j0.f8162a;
                Integer num3 = (Integer) cVarB.n(eVar, 2, j0Var, null);
                bool = bool3;
                num2 = (Integer) cVarB.n(eVar, 3, j0Var, null);
                l10 = (Long) cVarB.n(eVar, 4, q0.f8206a, null);
                num = num3;
                d10 = d11;
                i10 = 31;
            } else {
                boolean z10 = true;
                int i11 = 0;
                Double d12 = null;
                Integer num4 = null;
                Integer num5 = null;
                Long l11 = null;
                while (z10) {
                    int iW = cVarB.w(eVar);
                    if (iW == -1) {
                        z10 = false;
                    } else if (iW == 0) {
                        bool2 = (Boolean) cVarB.n(eVar, 0, dh.h.f8149a, bool2);
                        i11 |= 1;
                    } else if (iW == 1) {
                        d12 = (Double) cVarB.n(eVar, 1, dh.t.f8221a, d12);
                        i11 |= 2;
                    } else if (iW == 2) {
                        num4 = (Integer) cVarB.n(eVar, 2, j0.f8162a, num4);
                        i11 |= 4;
                    } else if (iW == 3) {
                        num5 = (Integer) cVarB.n(eVar, 3, j0.f8162a, num5);
                        i11 |= 8;
                    } else {
                        if (iW != 4) {
                            throw new zg.m(iW);
                        }
                        l11 = (Long) cVarB.n(eVar, 4, q0.f8206a, l11);
                        i11 |= 16;
                    }
                }
                i10 = i11;
                bool = bool2;
                d10 = d12;
                num = num4;
                num2 = num5;
                l10 = l11;
            }
            cVarB.c(eVar);
            return new SessionConfigs(i10, bool, d10, num, num2, l10, null);
        }

        @Override // zg.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(ch.f encoder, SessionConfigs value) {
            t.f(encoder, "encoder");
            t.f(value, "value");
            bh.e eVar = descriptor;
            ch.d dVarB = encoder.b(eVar);
            SessionConfigs.f(value, dVarB, eVar);
            dVarB.c(eVar);
        }

        @Override // dh.e0
        public final zg.b[] childSerializers() {
            zg.b bVarP = ah.a.p(dh.h.f8149a);
            zg.b bVarP2 = ah.a.p(dh.t.f8221a);
            j0 j0Var = j0.f8162a;
            return new zg.b[]{bVarP, bVarP2, ah.a.p(j0Var), ah.a.p(j0Var), ah.a.p(q0.f8206a)};
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

    /* JADX INFO: renamed from: xa.h$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class Companion {
        public Companion() {
        }

        public final zg.b serializer() {
            return a.f24751a;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public /* synthetic */ SessionConfigs(int i10, Boolean bool, Double d10, Integer num, Integer num2, Long l10, s1 s1Var) {
        if (31 != (i10 & 31)) {
            e1.a(i10, 31, a.f24751a.getDescriptor());
        }
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d10;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l10;
    }

    public static final /* synthetic */ void f(SessionConfigs self, ch.d output, bh.e serialDesc) {
        output.e(serialDesc, 0, dh.h.f8149a, self.sessionsEnabled);
        output.e(serialDesc, 1, dh.t.f8221a, self.sessionSamplingRate);
        j0 j0Var = j0.f8162a;
        output.e(serialDesc, 2, j0Var, self.sessionTimeoutSeconds);
        output.e(serialDesc, 3, j0Var, self.cacheDurationSeconds);
        output.e(serialDesc, 4, q0.f8206a, self.cacheUpdatedTimeSeconds);
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
        return t.b(this.sessionsEnabled, sessionConfigs.sessionsEnabled) && t.b(this.sessionSamplingRate, sessionConfigs.sessionSamplingRate) && t.b(this.sessionTimeoutSeconds, sessionConfigs.sessionTimeoutSeconds) && t.b(this.cacheDurationSeconds, sessionConfigs.cacheDurationSeconds) && t.b(this.cacheUpdatedTimeSeconds, sessionConfigs.cacheUpdatedTimeSeconds);
    }

    public int hashCode() {
        Boolean bool = this.sessionsEnabled;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d10 = this.sessionSamplingRate;
        int iHashCode2 = (iHashCode + (d10 == null ? 0 : d10.hashCode())) * 31;
        Integer num = this.sessionTimeoutSeconds;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.cacheDurationSeconds;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l10 = this.cacheUpdatedTimeSeconds;
        return iHashCode4 + (l10 != null ? l10.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.sessionsEnabled + ", sessionSamplingRate=" + this.sessionSamplingRate + ", sessionTimeoutSeconds=" + this.sessionTimeoutSeconds + ", cacheDurationSeconds=" + this.cacheDurationSeconds + ", cacheUpdatedTimeSeconds=" + this.cacheUpdatedTimeSeconds + ')';
    }

    public SessionConfigs(Boolean bool, Double d10, Integer num, Integer num2, Long l10) {
        this.sessionsEnabled = bool;
        this.sessionSamplingRate = d10;
        this.sessionTimeoutSeconds = num;
        this.cacheDurationSeconds = num2;
        this.cacheUpdatedTimeSeconds = l10;
    }
}
