package v3;

import t3.InterfaceC1830o;
import y3.F;
import y3.I;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f15340a = new j(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f15341b = I.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f15342c = I.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final F f15343d = new F("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final F f15344e = new F("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final F f15345f = new F("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final F f15346g = new F("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F f15347h = new F("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final F f15348i = new F("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final F f15349j = new F("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final F f15350k = new F("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final F f15351l = new F("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final F f15352m = new F("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final F f15353n = new F("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final F f15354o = new F("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final F f15355p = new F("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final F f15356q = new F("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final F f15357r = new F("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final F f15358s = new F("NO_CLOSE_CAUSE");

    public /* synthetic */ class a extends kotlin.jvm.internal.o implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15359a = new a();

        public a() {
            super(2, c.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        public final j d(long j4, j jVar) {
            return c.x(j4, jVar);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return d(((Number) obj).longValue(), (j) obj2);
        }
    }

    public static final long A(int i4) {
        if (i4 == 0) {
            return 0L;
        }
        if (i4 != Integer.MAX_VALUE) {
            return i4;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean B(InterfaceC1830o interfaceC1830o, Object obj, i3.k kVar) {
        Object objO = interfaceC1830o.o(obj, null, kVar);
        if (objO == null) {
            return false;
        }
        interfaceC1830o.p(objO);
        return true;
    }

    public static /* synthetic */ boolean C(InterfaceC1830o interfaceC1830o, Object obj, i3.k kVar, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            kVar = null;
        }
        return B(interfaceC1830o, obj, kVar);
    }

    public static final long v(long j4, boolean z4) {
        return (z4 ? 4611686018427387904L : 0L) + j4;
    }

    public static final long w(long j4, int i4) {
        return (((long) i4) << 60) + j4;
    }

    public static final j x(long j4, j jVar) {
        return new j(j4, jVar, jVar.u(), 0);
    }

    public static final p3.f y() {
        return a.f15359a;
    }

    public static final F z() {
        return f15351l;
    }
}
