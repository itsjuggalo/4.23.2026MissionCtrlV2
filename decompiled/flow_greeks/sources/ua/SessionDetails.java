package ua;

import dh.e0;
import dh.e1;
import dh.j1;
import dh.s1;
import dh.w1;
import kotlin.Metadata;

/* JADX INFO: renamed from: ua.h0, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u0000 '2\u00020\u0001:\u0002\u001f!B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&¨\u0006("}, d2 = {"Lua/h0;", "", "", "sessionId", "firstSessionId", "", "sessionIndex", "", "sessionStartTimestampUs", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "seen0", "Ldh/s1;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;IJLdh/s1;)V", "self", "Lch/d;", "output", "Lbh/e;", "serialDesc", "Lcd/h0;", "e", "(Lua/h0;Lch/d;Lbh/e;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "c", "I", "d", "J", "()J", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class SessionDetails {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String sessionId;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String firstSessionId;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int sessionIndex;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final long sessionStartTimestampUs;

    /* JADX INFO: renamed from: ua.h0$a */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a implements dh.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22586a;
        private static final bh.e descriptor;

        static {
            a aVar = new a();
            f22586a = aVar;
            j1 j1Var = new j1("com.google.firebase.sessions.SessionDetails", aVar, 4);
            j1Var.g("sessionId", false);
            j1Var.g("firstSessionId", false);
            j1Var.g("sessionIndex", false);
            j1Var.g("sessionStartTimestampUs", false);
            descriptor = j1Var;
        }

        @Override // zg.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SessionDetails deserialize(ch.e decoder) {
            String strS;
            int i10;
            int iC;
            String str;
            long jG;
            kotlin.jvm.internal.t.f(decoder, "decoder");
            bh.e eVar = descriptor;
            ch.c cVarB = decoder.b(eVar);
            if (cVarB.z()) {
                strS = cVarB.s(eVar, 0);
                String strS2 = cVarB.s(eVar, 1);
                i10 = 15;
                iC = cVarB.C(eVar, 2);
                str = strS2;
                jG = cVarB.g(eVar, 3);
            } else {
                strS = null;
                String strS3 = null;
                boolean z10 = true;
                long jG2 = 0;
                int i11 = 0;
                int iC2 = 0;
                while (z10) {
                    int iW = cVarB.w(eVar);
                    if (iW == -1) {
                        z10 = false;
                    } else if (iW == 0) {
                        strS = cVarB.s(eVar, 0);
                        i11 |= 1;
                    } else if (iW == 1) {
                        strS3 = cVarB.s(eVar, 1);
                        i11 |= 2;
                    } else if (iW == 2) {
                        iC2 = cVarB.C(eVar, 2);
                        i11 |= 4;
                    } else {
                        if (iW != 3) {
                            throw new zg.m(iW);
                        }
                        jG2 = cVarB.g(eVar, 3);
                        i11 |= 8;
                    }
                }
                i10 = i11;
                iC = iC2;
                str = strS3;
                jG = jG2;
            }
            String str2 = strS;
            cVarB.c(eVar);
            return new SessionDetails(i10, str2, str, iC, jG, null);
        }

        @Override // zg.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(ch.f encoder, SessionDetails value) {
            kotlin.jvm.internal.t.f(encoder, "encoder");
            kotlin.jvm.internal.t.f(value, "value");
            bh.e eVar = descriptor;
            ch.d dVarB = encoder.b(eVar);
            SessionDetails.e(value, dVarB, eVar);
            dVarB.c(eVar);
        }

        @Override // dh.e0
        public final zg.b[] childSerializers() {
            w1 w1Var = w1.f8244a;
            return new zg.b[]{w1Var, w1Var, dh.j0.f8162a, dh.q0.f8206a};
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

    /* JADX INFO: renamed from: ua.h0$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class Companion {
        public Companion() {
        }

        public final zg.b serializer() {
            return a.f22586a;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public /* synthetic */ SessionDetails(int i10, String str, String str2, int i11, long j10, s1 s1Var) {
        if (15 != (i10 & 15)) {
            e1.a(i10, 15, a.f22586a.getDescriptor());
        }
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i11;
        this.sessionStartTimestampUs = j10;
    }

    public static final /* synthetic */ void e(SessionDetails self, ch.d output, bh.e serialDesc) {
        output.w(serialDesc, 0, self.sessionId);
        output.w(serialDesc, 1, self.firstSessionId);
        output.x(serialDesc, 2, self.sessionIndex);
        output.r(serialDesc, 3, self.sessionStartTimestampUs);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final String getFirstSessionId() {
        return this.firstSessionId;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getSessionIndex() {
        return this.sessionIndex;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final long getSessionStartTimestampUs() {
        return this.sessionStartTimestampUs;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) other;
        return kotlin.jvm.internal.t.b(this.sessionId, sessionDetails.sessionId) && kotlin.jvm.internal.t.b(this.firstSessionId, sessionDetails.firstSessionId) && this.sessionIndex == sessionDetails.sessionIndex && this.sessionStartTimestampUs == sessionDetails.sessionStartTimestampUs;
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 31) + this.firstSessionId.hashCode()) * 31) + Integer.hashCode(this.sessionIndex)) * 31) + Long.hashCode(this.sessionStartTimestampUs);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", sessionStartTimestampUs=" + this.sessionStartTimestampUs + ')';
    }

    public SessionDetails(String sessionId, String firstSessionId, int i10, long j10) {
        kotlin.jvm.internal.t.f(sessionId, "sessionId");
        kotlin.jvm.internal.t.f(firstSessionId, "firstSessionId");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i10;
        this.sessionStartTimestampUs = j10;
    }
}
