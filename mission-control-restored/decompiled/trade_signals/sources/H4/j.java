package H4;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import u7.C2811d;
import u7.C2814g;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f3905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Level f3906b;

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
        public final int f3917a;

        b(int i8) {
            this.f3917a = i8;
        }

        public int a() {
            return this.f3917a;
        }
    }

    public j(Level level, Class cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    public static String l(J4.i iVar) {
        EnumMap enumMap = new EnumMap(b.class);
        for (b bVar : b.values()) {
            if (iVar.d(bVar.a())) {
                enumMap.put(bVar, Integer.valueOf(iVar.a(bVar.a())));
            }
        }
        return enumMap.toString();
    }

    public static String m(C2811d c2811d) {
        if (c2811d.s0() <= 64) {
            return c2811d.v0().r();
        }
        return c2811d.w0((int) Math.min(c2811d.s0(), 64L)).r() + "...";
    }

    public final boolean a() {
        return this.f3905a.isLoggable(this.f3906b);
    }

    public void b(a aVar, int i8, C2811d c2811d, int i9, boolean z7) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " DATA: streamId=" + i8 + " endStream=" + z7 + " length=" + i9 + " bytes=" + m(c2811d));
        }
    }

    public void c(a aVar, int i8, J4.a aVar2, C2814g c2814g) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " GO_AWAY: lastStreamId=" + i8 + " errorCode=" + aVar2 + " length=" + c2814g.R() + " bytes=" + m(new C2811d().y0(c2814g)));
        }
    }

    public void d(a aVar, int i8, List list, boolean z7) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " HEADERS: streamId=" + i8 + " headers=" + list + " endStream=" + z7);
        }
    }

    public void e(a aVar, long j8) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " PING: ack=false bytes=" + j8);
        }
    }

    public void f(a aVar, long j8) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " PING: ack=true bytes=" + j8);
        }
    }

    public void g(a aVar, int i8, int i9, List list) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " PUSH_PROMISE: streamId=" + i8 + " promisedStreamId=" + i9 + " headers=" + list);
        }
    }

    public void h(a aVar, int i8, J4.a aVar2) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " RST_STREAM: streamId=" + i8 + " errorCode=" + aVar2);
        }
    }

    public void i(a aVar, J4.i iVar) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " SETTINGS: ack=false settings=" + l(iVar));
        }
    }

    public void j(a aVar) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " SETTINGS: ack=true");
        }
    }

    public void k(a aVar, int i8, long j8) {
        if (a()) {
            this.f3905a.log(this.f3906b, aVar + " WINDOW_UPDATE: streamId=" + i8 + " windowSizeIncrement=" + j8);
        }
    }

    public j(Level level, Logger logger) {
        this.f3906b = (Level) AbstractC2848n.o(level, FirebaseAnalytics.Param.LEVEL);
        this.f3905a = (Logger) AbstractC2848n.o(logger, "logger");
    }
}
