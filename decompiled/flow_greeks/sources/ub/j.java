package ub;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f22859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Level f22860b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum a {
        INBOUND,
        OUTBOUND
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        HEADER_TABLE_SIZE(1),
        ENABLE_PUSH(2),
        MAX_CONCURRENT_STREAMS(4),
        MAX_FRAME_SIZE(5),
        MAX_HEADER_LIST_SIZE(6),
        INITIAL_WINDOW_SIZE(7);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22871a;

        b(int i10) {
            this.f22871a = i10;
        }

        public int a() {
            return this.f22871a;
        }
    }

    public j(Level level, Class cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    public static String l(hh.d dVar) {
        if (dVar.size() <= 64) {
            return dVar.g0().o();
        }
        return dVar.h0((int) Math.min(dVar.size(), 64L)).o() + "...";
    }

    public static String m(wb.i iVar) {
        EnumMap enumMap = new EnumMap(b.class);
        for (b bVar : b.values()) {
            if (iVar.d(bVar.a())) {
                enumMap.put(bVar, Integer.valueOf(iVar.a(bVar.a())));
            }
        }
        return enumMap.toString();
    }

    public final boolean a() {
        return this.f22859a.isLoggable(this.f22860b);
    }

    public void b(a aVar, int i10, hh.d dVar, int i11, boolean z10) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " DATA: streamId=" + i10 + " endStream=" + z10 + " length=" + i11 + " bytes=" + l(dVar));
        }
    }

    public void c(a aVar, int i10, wb.a aVar2, hh.g gVar) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " GO_AWAY: lastStreamId=" + i10 + " errorCode=" + aVar2 + " length=" + gVar.B() + " bytes=" + l(new hh.d().j0(gVar)));
        }
    }

    public void d(a aVar, int i10, List list, boolean z10) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " HEADERS: streamId=" + i10 + " headers=" + list + " endStream=" + z10);
        }
    }

    public void e(a aVar, long j10) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " PING: ack=false bytes=" + j10);
        }
    }

    public void f(a aVar, long j10) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " PING: ack=true bytes=" + j10);
        }
    }

    public void g(a aVar, int i10, int i11, List list) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " PUSH_PROMISE: streamId=" + i10 + " promisedStreamId=" + i11 + " headers=" + list);
        }
    }

    public void h(a aVar, int i10, wb.a aVar2) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " RST_STREAM: streamId=" + i10 + " errorCode=" + aVar2);
        }
    }

    public void i(a aVar, wb.i iVar) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " SETTINGS: ack=false settings=" + m(iVar));
        }
    }

    public void j(a aVar) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " SETTINGS: ack=true");
        }
    }

    public void k(a aVar, int i10, long j10) {
        if (a()) {
            this.f22859a.log(this.f22860b, aVar + " WINDOW_UPDATE: streamId=" + i10 + " windowSizeIncrement=" + j10);
        }
    }

    public j(Level level, Logger logger) {
        this.f22860b = (Level) p6.n.o(level, FirebaseAnalytics.Param.LEVEL);
        this.f22859a = (Logger) p6.n.o(logger, "logger");
    }
}
