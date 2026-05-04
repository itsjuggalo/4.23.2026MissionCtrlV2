package pg;

import sg.d0;
import sg.g0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f18646a = new m(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18647b = g0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f18648c = g0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d0 f18649d = new d0("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final d0 f18650e = new d0("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d0 f18651f = new d0("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final d0 f18652g = new d0("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final d0 f18653h = new d0("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final d0 f18654i = new d0("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final d0 f18655j = new d0("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final d0 f18656k = new d0("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d0 f18657l = new d0("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final d0 f18658m = new d0("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final d0 f18659n = new d0("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d0 f18660o = new d0("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d0 f18661p = new d0("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final d0 f18662q = new d0("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final d0 f18663r = new d0("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final d0 f18664s = new d0("NO_CLOSE_CAUSE");

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends kotlin.jvm.internal.q implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f18665a = new a();

        public a() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // pd.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return o(((Number) obj).longValue(), (m) obj2);
        }

        public final m o(long j10, m mVar) {
            return f.x(j10, mVar);
        }
    }

    public static final long A(int i10) {
        if (i10 == 0) {
            return 0L;
        }
        if (i10 != Integer.MAX_VALUE) {
            return i10;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean B(ng.n nVar, Object obj, pd.p pVar) {
        Object objK = nVar.k(obj, null, pVar);
        if (objK == null) {
            return false;
        }
        nVar.p(objK);
        return true;
    }

    public static /* synthetic */ boolean C(ng.n nVar, Object obj, pd.p pVar, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            pVar = null;
        }
        return B(nVar, obj, pVar);
    }

    public static final long v(long j10, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j10;
    }

    public static final long w(long j10, int i10) {
        return (((long) i10) << 60) + j10;
    }

    public static final m x(long j10, m mVar) {
        return new m(j10, mVar, mVar.y(), 0);
    }

    public static final wd.h y() {
        return a.f18665a;
    }

    public static final d0 z() {
        return f18657l;
    }
}
