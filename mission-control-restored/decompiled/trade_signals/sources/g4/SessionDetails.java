package g4;

import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o7.AbstractC2504f0;
import o7.C2514k0;
import o7.E;
import o7.t0;
import o7.x0;

/* JADX INFO: renamed from: g4.H, reason: case insensitive filesystem and from toString */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u0000 '2\u00020\u0001:\u0002\u001f!B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b!\u0010 \u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b$\u0010&¨\u0006("}, d2 = {"Lg4/H;", "", "", "sessionId", "firstSessionId", "", "sessionIndex", "", "sessionStartTimestampUs", "<init>", "(Ljava/lang/String;Ljava/lang/String;IJ)V", "seen0", "Lo7/t0;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;IJLo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "e", "(Lg4/H;Ln7/d;Lm7/e;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "b", "c", "I", "d", "J", "()J", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0})
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

    /* JADX INFO: renamed from: g4.H$a */
    public /* synthetic */ class a implements o7.E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18031a;
        private static final m7.e descriptor;

        static {
            a aVar = new a();
            f18031a = aVar;
            C2514k0 c2514k0 = new C2514k0("com.google.firebase.sessions.SessionDetails", aVar, 4);
            c2514k0.p("sessionId", false);
            c2514k0.p("firstSessionId", false);
            c2514k0.p("sessionIndex", false);
            c2514k0.p("sessionStartTimestampUs", false);
            descriptor = c2514k0;
        }

        @Override // k7.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final SessionDetails deserialize(n7.e decoder) {
            String str;
            int i8;
            int iY;
            String str2;
            long jC;
            AbstractC2304t.f(decoder, "decoder");
            m7.e eVar = descriptor;
            n7.c cVarC = decoder.c(eVar);
            if (cVarC.w()) {
                String strJ = cVarC.j(eVar, 0);
                String strJ2 = cVarC.j(eVar, 1);
                str = strJ;
                i8 = 15;
                iY = cVarC.y(eVar, 2);
                str2 = strJ2;
                jC = cVarC.C(eVar, 3);
            } else {
                String strJ3 = null;
                String strJ4 = null;
                boolean z7 = true;
                long jC2 = 0;
                int i9 = 0;
                int iY2 = 0;
                while (z7) {
                    int iE = cVarC.E(eVar);
                    if (iE == -1) {
                        z7 = false;
                    } else if (iE == 0) {
                        strJ3 = cVarC.j(eVar, 0);
                        i9 |= 1;
                    } else if (iE == 1) {
                        strJ4 = cVarC.j(eVar, 1);
                        i9 |= 2;
                    } else if (iE == 2) {
                        iY2 = cVarC.y(eVar, 2);
                        i9 |= 4;
                    } else {
                        if (iE != 3) {
                            throw new k7.m(iE);
                        }
                        jC2 = cVarC.C(eVar, 3);
                        i9 |= 8;
                    }
                }
                str = strJ3;
                i8 = i9;
                iY = iY2;
                str2 = strJ4;
                jC = jC2;
            }
            cVarC.d(eVar);
            return new SessionDetails(i8, str, str2, iY, jC, null);
        }

        @Override // k7.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(n7.f encoder, SessionDetails value) {
            AbstractC2304t.f(encoder, "encoder");
            AbstractC2304t.f(value, "value");
            m7.e eVar = descriptor;
            n7.d dVarC = encoder.c(eVar);
            SessionDetails.e(value, dVarC, eVar);
            dVarC.d(eVar);
        }

        @Override // o7.E
        public final k7.b[] childSerializers() {
            x0 x0Var = x0.f22227a;
            return new k7.b[]{x0Var, x0Var, o7.J.f22118a, o7.Q.f22138a};
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

    /* JADX INFO: renamed from: g4.H$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final k7.b serializer() {
            return a.f18031a;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ SessionDetails(int i8, String str, String str2, int i9, long j8, t0 t0Var) {
        if (15 != (i8 & 15)) {
            AbstractC2504f0.a(i8, 15, a.f18031a.getDescriptor());
        }
        this.sessionId = str;
        this.firstSessionId = str2;
        this.sessionIndex = i9;
        this.sessionStartTimestampUs = j8;
    }

    public static final /* synthetic */ void e(SessionDetails self, n7.d output, m7.e serialDesc) {
        output.g(serialDesc, 0, self.sessionId);
        output.g(serialDesc, 1, self.firstSessionId);
        output.l(serialDesc, 2, self.sessionIndex);
        output.x(serialDesc, 3, self.sessionStartTimestampUs);
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
        return AbstractC2304t.b(this.sessionId, sessionDetails.sessionId) && AbstractC2304t.b(this.firstSessionId, sessionDetails.firstSessionId) && this.sessionIndex == sessionDetails.sessionIndex && this.sessionStartTimestampUs == sessionDetails.sessionStartTimestampUs;
    }

    public int hashCode() {
        return (((((this.sessionId.hashCode() * 31) + this.firstSessionId.hashCode()) * 31) + Integer.hashCode(this.sessionIndex)) * 31) + Long.hashCode(this.sessionStartTimestampUs);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.sessionId + ", firstSessionId=" + this.firstSessionId + ", sessionIndex=" + this.sessionIndex + ", sessionStartTimestampUs=" + this.sessionStartTimestampUs + ')';
    }

    public SessionDetails(String sessionId, String firstSessionId, int i8, long j8) {
        AbstractC2304t.f(sessionId, "sessionId");
        AbstractC2304t.f(firstSessionId, "firstSessionId");
        this.sessionId = sessionId;
        this.firstSessionId = firstSessionId;
        this.sessionIndex = i8;
        this.sessionStartTimestampUs = j8;
    }
}
