package a7;

import Y6.InterfaceC1015l;
import d7.D;
import d7.G;
import kotlin.jvm.internal.AbstractC2302q;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f10198a = new m(-1, null, null, 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10199b = G.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10200c = G.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final D f10201d = new D("BUFFERED");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final D f10202e = new D("SHOULD_BUFFER");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final D f10203f = new D("S_RESUMING_BY_RCV");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final D f10204g = new D("RESUMING_BY_EB");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final D f10205h = new D("POISONED");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final D f10206i = new D("DONE_RCV");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final D f10207j = new D("INTERRUPTED_SEND");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final D f10208k = new D("INTERRUPTED_RCV");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final D f10209l = new D("CHANNEL_CLOSED");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final D f10210m = new D("SUSPEND");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final D f10211n = new D("SUSPEND_NO_WAITER");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final D f10212o = new D("FAILED");

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final D f10213p = new D("NO_RECEIVE_RESULT");

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final D f10214q = new D("CLOSE_HANDLER_CLOSED");

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final D f10215r = new D("CLOSE_HANDLER_INVOKED");

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final D f10216s = new D("NO_CLOSE_CAUSE");

    public /* synthetic */ class a extends AbstractC2302q implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f10217a = new a();

        public a() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/channels/ChannelSegment;)Lkotlinx/coroutines/channels/ChannelSegment;", 1);
        }

        @Override // B5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m(((Number) obj).longValue(), (m) obj2);
        }

        public final m m(long j8, m mVar) {
            return f.x(j8, mVar);
        }
    }

    public static final long A(int i8) {
        if (i8 == 0) {
            return 0L;
        }
        if (i8 != Integer.MAX_VALUE) {
            return i8;
        }
        return Long.MAX_VALUE;
    }

    public static final boolean B(InterfaceC1015l interfaceC1015l, Object obj, B5.p pVar) {
        Object objI = interfaceC1015l.i(obj, null, pVar);
        if (objI == null) {
            return false;
        }
        interfaceC1015l.s(objI);
        return true;
    }

    public static /* synthetic */ boolean C(InterfaceC1015l interfaceC1015l, Object obj, B5.p pVar, int i8, Object obj2) {
        if ((i8 & 2) != 0) {
            pVar = null;
        }
        return B(interfaceC1015l, obj, pVar);
    }

    public static final long v(long j8, boolean z7) {
        return (z7 ? 4611686018427387904L : 0L) + j8;
    }

    public static final long w(long j8, int i8) {
        return (((long) i8) << 60) + j8;
    }

    public static final m x(long j8, m mVar) {
        return new m(j8, mVar, mVar.y(), 0);
    }

    public static final I5.h y() {
        return a.f10217a;
    }

    public static final D z() {
        return f10209l;
    }
}
