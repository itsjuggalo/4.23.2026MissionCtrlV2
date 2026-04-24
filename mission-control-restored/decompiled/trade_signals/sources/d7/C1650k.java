package d7;

import Y6.InterfaceC1015l;
import Y6.S;
import Y6.V;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import s5.C2712j;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: d7.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1650k extends Y6.I implements V {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17053i = AtomicIntegerFieldUpdater.newUpdater(C1650k.class, "runningWorkers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ V f17054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Y6.I f17055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f17057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C1655p f17058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f17059h;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: renamed from: d7.k$a */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f17060a;

        public a(Runnable runnable) {
            this.f17060a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i8 = 0;
            while (true) {
                try {
                    this.f17060a.run();
                } catch (Throwable th) {
                    Y6.K.a(C2712j.f23116a, th);
                }
                Runnable runnableC0 = C1650k.this.C0();
                if (runnableC0 == null) {
                    return;
                }
                this.f17060a = runnableC0;
                i8++;
                if (i8 >= 16 && C1650k.this.f17055d.w0(C1650k.this)) {
                    C1650k.this.f17055d.v0(C1650k.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1650k(Y6.I i8, int i9, String str) {
        V v8 = i8 instanceof V ? (V) i8 : null;
        this.f17054c = v8 == null ? S.a() : v8;
        this.f17055d = i8;
        this.f17056e = i9;
        this.f17057f = str;
        this.f17058g = new C1655p(false);
        this.f17059h = new Object();
    }

    public final Runnable C0() {
        while (true) {
            Runnable runnable = (Runnable) this.f17058g.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f17059h) {
                f17053i.decrementAndGet(this);
                if (this.f17058g.c() == 0) {
                    return null;
                }
                f17053i.incrementAndGet(this);
            }
        }
    }

    public final boolean D0() {
        synchronized (this.f17059h) {
            if (f17053i.get(this) >= this.f17056e) {
                return false;
            }
            f17053i.incrementAndGet(this);
            return true;
        }
    }

    @Override // Y6.V
    public void U(long j8, InterfaceC1015l interfaceC1015l) {
        this.f17054c.U(j8, interfaceC1015l);
    }

    @Override // Y6.I
    public String toString() {
        String str = this.f17057f;
        if (str != null) {
            return str;
        }
        return this.f17055d + ".limitedParallelism(" + this.f17056e + ')';
    }

    @Override // Y6.I
    public void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        Runnable runnableC0;
        this.f17058g.a(runnable);
        if (f17053i.get(this) >= this.f17056e || !D0() || (runnableC0 = C0()) == null) {
            return;
        }
        this.f17055d.v0(this, new a(runnableC0));
    }

    @Override // Y6.I
    public Y6.I x0(int i8, String str) {
        AbstractC1651l.a(i8);
        return i8 >= this.f17056e ? AbstractC1651l.b(this, str) : super.x0(i8, str);
    }
}
