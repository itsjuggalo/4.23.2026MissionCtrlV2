package u5;

import java.util.EnumMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import w5.C2786i;
import w5.EnumC2778a;
import w6.C2792e;
import w6.C2795h;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Logger f24640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Level f24641b;

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
        public final int f24652a;

        b(int i7) {
            this.f24652a = i7;
        }

        public int a() {
            return this.f24652a;
        }
    }

    public j(Level level, Class cls) {
        this(level, Logger.getLogger(cls.getName()));
    }

    public static String l(C2786i c2786i) {
        EnumMap enumMap = new EnumMap(b.class);
        for (b bVar : b.values()) {
            if (c2786i.d(bVar.a())) {
                enumMap.put(bVar, Integer.valueOf(c2786i.a(bVar.a())));
            }
        }
        return enumMap.toString();
    }

    public static String m(C2792e c2792e) {
        if (c2792e.E0() <= 64) {
            return c2792e.F0().q();
        }
        return c2792e.G0((int) Math.min(c2792e.E0(), 64L)).q() + "...";
    }

    public final boolean a() {
        return this.f24640a.isLoggable(this.f24641b);
    }

    public void b(a aVar, int i7, C2792e c2792e, int i8, boolean z7) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " DATA: streamId=" + i7 + " endStream=" + z7 + " length=" + i8 + " bytes=" + m(c2792e));
        }
    }

    public void c(a aVar, int i7, EnumC2778a enumC2778a, C2795h c2795h) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " GO_AWAY: lastStreamId=" + i7 + " errorCode=" + enumC2778a + " length=" + c2795h.H() + " bytes=" + m(new C2792e().m(c2795h)));
        }
    }

    public void d(a aVar, int i7, List list, boolean z7) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " HEADERS: streamId=" + i7 + " headers=" + list + " endStream=" + z7);
        }
    }

    public void e(a aVar, long j7) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " PING: ack=false bytes=" + j7);
        }
    }

    public void f(a aVar, long j7) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " PING: ack=true bytes=" + j7);
        }
    }

    public void g(a aVar, int i7, int i8, List list) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " PUSH_PROMISE: streamId=" + i7 + " promisedStreamId=" + i8 + " headers=" + list);
        }
    }

    public void h(a aVar, int i7, EnumC2778a enumC2778a) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " RST_STREAM: streamId=" + i7 + " errorCode=" + enumC2778a);
        }
    }

    public void i(a aVar, C2786i c2786i) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " SETTINGS: ack=false settings=" + l(c2786i));
        }
    }

    public void j(a aVar) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " SETTINGS: ack=true");
        }
    }

    public void k(a aVar, int i7, long j7) {
        if (a()) {
            this.f24640a.log(this.f24641b, aVar + " WINDOW_UPDATE: streamId=" + i7 + " windowSizeIncrement=" + j7);
        }
    }

    public j(Level level, Logger logger) {
        this.f24641b = (Level) H2.m.o(level, "level");
        this.f24640a = (Logger) H2.m.o(logger, "logger");
    }
}
