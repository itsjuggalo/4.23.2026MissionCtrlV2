package g4;

import W6.a;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o7.AbstractC2504f0;
import o7.C2514k0;
import o7.E;
import o7.t0;

/* JADX INFO: renamed from: g4.W, reason: case insensitive filesystem and from toString */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081\b\u0018\u0000 '2\u00020\u0001:\u0002\"&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B3\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\fJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b&\u0010%R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b\"\u0010%¨\u0006("}, d2 = {"Lg4/W;", "", "", "ms", "<init>", "(J)V", "", "seen0", "us", "seconds", "Lo7/t0;", "serializationConstructorMarker", "(IJJJLo7/t0;)V", "self", "Ln7/d;", "output", "Lm7/e;", "serialDesc", "Lo5/H;", "d", "(Lg4/W;Ln7/d;Lm7/e;)V", com.amazon.a.a.h.a.f13759b, "LW6/a;", "c", "(Lg4/W;)J", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "getMs", "()J", "b", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0})
public final /* data */ class Time {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long ms;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long us;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long seconds;

    /* JADX INFO: renamed from: g4.W$a */
    public /* synthetic */ class a implements o7.E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18127a;
        private static final m7.e descriptor;

        static {
            a aVar = new a();
            f18127a = aVar;
            C2514k0 c2514k0 = new C2514k0("com.google.firebase.sessions.Time", aVar, 3);
            c2514k0.p("ms", false);
            c2514k0.p("us", true);
            c2514k0.p("seconds", true);
            descriptor = c2514k0;
        }

        @Override // k7.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Time deserialize(n7.e decoder) {
            int i8;
            long jC;
            long j8;
            long j9;
            AbstractC2304t.f(decoder, "decoder");
            m7.e eVar = descriptor;
            n7.c cVarC = decoder.c(eVar);
            if (cVarC.w()) {
                long jC2 = cVarC.C(eVar, 0);
                long jC3 = cVarC.C(eVar, 1);
                jC = cVarC.C(eVar, 2);
                i8 = 7;
                j8 = jC2;
                j9 = jC3;
            } else {
                long jC4 = 0;
                boolean z7 = true;
                int i9 = 0;
                long jC5 = 0;
                long jC6 = 0;
                while (z7) {
                    int iE = cVarC.E(eVar);
                    if (iE == -1) {
                        z7 = false;
                    } else if (iE == 0) {
                        jC5 = cVarC.C(eVar, 0);
                        i9 |= 1;
                    } else if (iE == 1) {
                        jC6 = cVarC.C(eVar, 1);
                        i9 |= 2;
                    } else {
                        if (iE != 2) {
                            throw new k7.m(iE);
                        }
                        jC4 = cVarC.C(eVar, 2);
                        i9 |= 4;
                    }
                }
                i8 = i9;
                jC = jC4;
                j8 = jC5;
                j9 = jC6;
            }
            cVarC.d(eVar);
            return new Time(i8, j8, j9, jC, null);
        }

        @Override // k7.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(n7.f encoder, Time value) {
            AbstractC2304t.f(encoder, "encoder");
            AbstractC2304t.f(value, "value");
            m7.e eVar = descriptor;
            n7.d dVarC = encoder.c(eVar);
            Time.d(value, dVarC, eVar);
            dVarC.d(eVar);
        }

        @Override // o7.E
        public final k7.b[] childSerializers() {
            o7.Q q8 = o7.Q.f22138a;
            return new k7.b[]{q8, q8, q8};
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

    /* JADX INFO: renamed from: g4.W$b, reason: from kotlin metadata */
    public static final class Companion {
        public Companion() {
        }

        public final k7.b serializer() {
            return a.f18127a;
        }

        public /* synthetic */ Companion(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ Time(int i8, long j8, long j9, long j10, t0 t0Var) {
        if (1 != (i8 & 1)) {
            AbstractC2504f0.a(i8, 1, a.f18127a.getDescriptor());
        }
        this.ms = j8;
        this.us = (i8 & 2) == 0 ? ((long) 1000) * j8 : j9;
        if ((i8 & 4) == 0) {
            this.seconds = j8 / ((long) 1000);
        } else {
            this.seconds = j10;
        }
    }

    public static final /* synthetic */ void d(Time self, n7.d output, m7.e serialDesc) {
        output.x(serialDesc, 0, self.ms);
        if (output.q(serialDesc, 1) || self.us != self.ms * ((long) 1000)) {
            output.x(serialDesc, 1, self.us);
        }
        if (!output.q(serialDesc, 2) && self.seconds == self.ms / ((long) 1000)) {
            return;
        }
        output.x(serialDesc, 2, self.seconds);
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final long getSeconds() {
        return this.seconds;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final long getUs() {
        return this.us;
    }

    public final long c(Time time) {
        AbstractC2304t.f(time, "time");
        a.C0149a c0149a = W6.a.f9306b;
        return W6.c.t(this.ms - time.ms, W6.d.f9315d);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Time) && this.ms == ((Time) other).ms;
    }

    public int hashCode() {
        return Long.hashCode(this.ms);
    }

    public String toString() {
        return "Time(ms=" + this.ms + ')';
    }

    public Time(long j8) {
        this.ms = j8;
        long j9 = 1000;
        this.us = j8 * j9;
        this.seconds = j8 / j9;
    }
}
