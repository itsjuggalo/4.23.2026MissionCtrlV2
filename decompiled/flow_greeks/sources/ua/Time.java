package ua;

import dh.e0;
import dh.e1;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import lg.a;

/* JADX INFO: renamed from: ua.v0, reason: from toString */
/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\b\u0081\b\u0018\u0000 '2\u00020\u0001:\u0002\"&B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B3\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0004\u0010\fJ'\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b \u0010!R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010#\u001a\u0004\b&\u0010%R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010#\u001a\u0004\b\"\u0010%¨\u0006("}, d2 = {"Lua/v0;", "", "", "ms", "<init>", "(J)V", "", "seen0", "us", "seconds", "Ldh/s1;", "serializationConstructorMarker", "(IJJJLdh/s1;)V", "self", "Lch/d;", "output", "Lbh/e;", "serialDesc", "Lcd/h0;", "d", "(Lua/v0;Lch/d;Lbh/e;)V", com.amazon.a.a.h.a.f4275b, "Llg/a;", "c", "(Lua/v0;)J", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "J", "getMs", "()J", "b", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class Time {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final long ms;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final long us;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final long seconds;

    /* JADX INFO: renamed from: ua.v0$a */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a implements dh.e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f22719a;
        private static final bh.e descriptor;

        static {
            a aVar = new a();
            f22719a = aVar;
            j1 j1Var = new j1("com.google.firebase.sessions.Time", aVar, 3);
            j1Var.g("ms", false);
            j1Var.g("us", true);
            j1Var.g("seconds", true);
            descriptor = j1Var;
        }

        @Override // zg.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Time deserialize(ch.e decoder) {
            int i10;
            long jG;
            long j10;
            long j11;
            kotlin.jvm.internal.t.f(decoder, "decoder");
            bh.e eVar = descriptor;
            ch.c cVarB = decoder.b(eVar);
            if (cVarB.z()) {
                long jG2 = cVarB.g(eVar, 0);
                long jG3 = cVarB.g(eVar, 1);
                jG = cVarB.g(eVar, 2);
                i10 = 7;
                j10 = jG2;
                j11 = jG3;
            } else {
                long jG4 = 0;
                boolean z10 = true;
                int i11 = 0;
                long jG5 = 0;
                long jG6 = 0;
                while (z10) {
                    int iW = cVarB.w(eVar);
                    if (iW == -1) {
                        z10 = false;
                    } else if (iW == 0) {
                        jG5 = cVarB.g(eVar, 0);
                        i11 |= 1;
                    } else if (iW == 1) {
                        jG6 = cVarB.g(eVar, 1);
                        i11 |= 2;
                    } else {
                        if (iW != 2) {
                            throw new zg.m(iW);
                        }
                        jG4 = cVarB.g(eVar, 2);
                        i11 |= 4;
                    }
                }
                i10 = i11;
                jG = jG4;
                j10 = jG5;
                j11 = jG6;
            }
            cVarB.c(eVar);
            return new Time(i10, j10, j11, jG, null);
        }

        @Override // zg.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final void serialize(ch.f encoder, Time value) {
            kotlin.jvm.internal.t.f(encoder, "encoder");
            kotlin.jvm.internal.t.f(value, "value");
            bh.e eVar = descriptor;
            ch.d dVarB = encoder.b(eVar);
            Time.d(value, dVarB, eVar);
            dVarB.c(eVar);
        }

        @Override // dh.e0
        public final zg.b[] childSerializers() {
            dh.q0 q0Var = dh.q0.f8206a;
            return new zg.b[]{q0Var, q0Var, q0Var};
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

    /* JADX INFO: renamed from: ua.v0$b, reason: from kotlin metadata */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class Companion {
        public Companion() {
        }

        public final zg.b serializer() {
            return a.f22719a;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public /* synthetic */ Time(int i10, long j10, long j11, long j12, s1 s1Var) {
        if (1 != (i10 & 1)) {
            e1.a(i10, 1, a.f22719a.getDescriptor());
        }
        this.ms = j10;
        this.us = (i10 & 2) == 0 ? ((long) 1000) * j10 : j11;
        if ((i10 & 4) == 0) {
            this.seconds = j10 / ((long) 1000);
        } else {
            this.seconds = j12;
        }
    }

    public static final /* synthetic */ void d(Time self, ch.d output, bh.e serialDesc) {
        output.r(serialDesc, 0, self.ms);
        if (output.o(serialDesc, 1) || self.us != self.ms * ((long) 1000)) {
            output.r(serialDesc, 1, self.us);
        }
        if (!output.o(serialDesc, 2) && self.seconds == self.ms / ((long) 1000)) {
            return;
        }
        output.r(serialDesc, 2, self.seconds);
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
        kotlin.jvm.internal.t.f(time, "time");
        a.C0282a c0282a = lg.a.f15679b;
        return lg.c.t(this.ms - time.ms, lg.d.f15688d);
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

    public Time(long j10) {
        this.ms = j10;
        long j11 = 1000;
        this.us = j10 * j11;
        this.seconds = j10 / j11;
    }
}
