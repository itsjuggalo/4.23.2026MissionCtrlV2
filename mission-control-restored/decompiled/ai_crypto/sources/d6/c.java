package d6;

import b6.InterfaceC1085o;
import g6.F;
import g6.I;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f13467a = new j(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13468b = I.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f13469c = I.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F f13470d = new F("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final F f13471e = new F("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F f13472f = new F("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F f13473g = new F("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F f13474h = new F("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final F f13475i = new F("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F f13476j = new F("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final F f13477k = new F("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final F f13478l = new F("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final F f13479m = new F("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final F f13480n = new F("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final F f13481o = new F("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final F f13482p = new F("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final F f13483q = new F("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final F f13484r = new F("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final F f13485s = new F("NO_CLOSE_CAUSE");

    public /* synthetic */ class a extends kotlin.jvm.internal.o implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13486a = new a();

        public a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final j e(long j7, j jVar) {
            return c.x(j7, jVar);
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return e(((Number) obj).longValue(), (j) obj2);
        }
    }

    public static final long A(int i7) {
        if (i7 == 0) {
            return 0L;
        }
        if (i7 != Integer.MAX_VALUE) {
            return i7;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean B(InterfaceC1085o interfaceC1085o, Object obj, Q5.k kVar) {
        Object objE = interfaceC1085o.e(obj, null, kVar);
        if (objE == null) {
            return false;
        }
        interfaceC1085o.n(objE);
        return true;
    }

    public static /* synthetic */ boolean C(InterfaceC1085o interfaceC1085o, Object obj, Q5.k kVar, int i7, Object obj2) {
        if ((i7 & 2) != 0) {
            kVar = null;
        }
        return B(interfaceC1085o, obj, kVar);
    }

    public static final long v(long j7, boolean z7) {
        return (z7 ? 4611686018427387904L : 0L) + j7;
    }

    public static final long w(long j7, int i7) {
        return (((long) i7) << 60) + j7;
    }

    public static final j x(long j7, j jVar) {
        return new j(j7, jVar, jVar.u(), 0);
    }

    public static final X5.f y() {
        return a.f13486a;
    }

    public static final F z() {
        return f13478l;
    }
}
