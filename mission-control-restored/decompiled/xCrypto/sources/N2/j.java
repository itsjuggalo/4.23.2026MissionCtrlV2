package N2;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f3048a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Level f3049b;

    public enum a {
        INBOUND,
        OUTBOUND
    }

    public enum b {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f3060a;

        b(int i4) {
            this.f3060a = i4;
        }

        public int a() {
            return this.f3060a;
        }
    }

    public j(Level level, Class cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    public static String l(O3.d dVar) {
        if (dVar.i0() <= 64) {
            return dVar.j0().n();
        }
        return dVar.k0((int) Math.min(dVar.i0(), 64L)).n() + "...";
    }

    public static String m(P2.i iVar) {
        EnumMap enumMap = new EnumMap(b.class);
        for (b bVar : b.values()) {
            if (iVar.d(bVar.a())) {
                enumMap.put(bVar, Integer.valueOf(iVar.a(bVar.a())));
            }
        }
        return enumMap.toString();
    }

    public final boolean a() {
        return this.f3048a.isLoggable(this.f3049b);
    }

    public void b(a aVar, int i4, O3.d dVar, int i5, boolean z4) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " DATA: streamId=" + i4 + " endStream=" + z4 + " length=" + i5 + " bytes=" + l(dVar));
        }
    }

    public void c(a aVar, int i4, P2.a aVar2, O3.g gVar) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " GO_AWAY: lastStreamId=" + i4 + " errorCode=" + aVar2 + " length=" + gVar.v() + " bytes=" + l(new O3.d().m0(gVar)));
        }
    }

    public void d(a aVar, int i4, List list, boolean z4) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " HEADERS: streamId=" + i4 + " headers=" + list + " endStream=" + z4);
        }
    }

    public void e(a aVar, long j4) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " PING: ack=false bytes=" + j4);
        }
    }

    public void f(a aVar, long j4) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " PING: ack=true bytes=" + j4);
        }
    }

    public void g(a aVar, int i4, int i5, List list) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " PUSH_PROMISE: streamId=" + i4 + " promisedStreamId=" + i5 + " headers=" + list);
        }
    }

    public void h(a aVar, int i4, P2.a aVar2) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " RST_STREAM: streamId=" + i4 + " errorCode=" + aVar2);
        }
    }

    public void i(a aVar, P2.i iVar) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " SETTINGS: ack=false settings=" + m(iVar));
        }
    }

    public void j(a aVar) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " SETTINGS: ack=true");
        }
    }

    public void k(a aVar, int i4, long j4) {
        if (a()) {
            this.f3048a.log(this.f3049b, aVar + " WINDOW_UPDATE: streamId=" + i4 + " windowSizeIncrement=" + j4);
        }
    }

    public j(Level level, Logger logger) {
        this.f3049b = (Level) Z1.m.o(level, FirebaseAnalytics.Param.LEVEL);
        this.f3048a = (Logger) Z1.m.o(logger, "logger");
    }
}
