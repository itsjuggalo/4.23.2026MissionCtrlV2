package okhttp3.internal.cache2;

import java.io.IOException;
import java.io.RandomAccessFile;
import okhttp3.internal.Util;
import w6.C2792e;
import w6.C2795h;
import w6.Z;
import w6.a0;

/* JADX INFO: loaded from: classes2.dex */
final class Relay {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final C2795h f20758k = C2795h.j("OkHttp cache v1\n");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final C2795h f20759l = C2795h.j("OkHttp DIRTY :(\n");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RandomAccessFile f20760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Thread f20761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Z f20762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2792e f20763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f20764e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f20765f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final C2795h f20766g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final C2792e f20767h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f20768i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f20769j;

    public class RelaySource implements Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a0 f20770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public FileOperator f20771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f20772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Relay f20773d;

        @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f20771b == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.f20771b = null;
            synchronized (this.f20773d) {
                try {
                    Relay relay = this.f20773d;
                    int i7 = relay.f20769j - 1;
                    relay.f20769j = i7;
                    if (i7 == 0) {
                        RandomAccessFile randomAccessFile2 = relay.f20760a;
                        relay.f20760a = null;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (randomAccessFile != null) {
                Util.f(randomAccessFile);
            }
        }

        @Override // w6.Z
        public a0 f() {
            return this.f20770a;
        }

        @Override // w6.Z
        public long z(C2792e c2792e, long j7) throws IOException {
            Relay relay;
            if (this.f20771b == null) {
                throw new IllegalStateException("closed");
            }
            synchronized (this.f20773d) {
                while (true) {
                    try {
                        long j8 = this.f20772c;
                        Relay relay2 = this.f20773d;
                        long j9 = relay2.f20764e;
                        if (j8 != j9) {
                            long jE0 = j9 - relay2.f20767h.E0();
                            long j10 = this.f20772c;
                            if (j10 < jE0) {
                                long jMin = Math.min(j7, j9 - j10);
                                this.f20771b.a(this.f20772c + 32, c2792e, jMin);
                                this.f20772c += jMin;
                                return jMin;
                            }
                            long jMin2 = Math.min(j7, j9 - j10);
                            this.f20773d.f20767h.K(c2792e, this.f20772c - jE0, jMin2);
                            this.f20772c += jMin2;
                            return jMin2;
                        }
                        if (relay2.f20765f) {
                            return -1L;
                        }
                        if (relay2.f20761b == null) {
                            relay2.f20761b = Thread.currentThread();
                            try {
                                Relay relay3 = this.f20773d;
                                long jZ = relay3.f20762c.z(relay3.f20763d, relay3.f20768i);
                                if (jZ == -1) {
                                    this.f20773d.a(j9);
                                    synchronized (this.f20773d) {
                                        Relay relay4 = this.f20773d;
                                        relay4.f20761b = null;
                                        relay4.notifyAll();
                                    }
                                    return -1L;
                                }
                                long jMin3 = Math.min(jZ, j7);
                                this.f20773d.f20763d.K(c2792e, 0L, jMin3);
                                this.f20772c += jMin3;
                                this.f20771b.b(j9 + 32, this.f20773d.f20763d.clone(), jZ);
                                synchronized (this.f20773d) {
                                    try {
                                        Relay relay5 = this.f20773d;
                                        relay5.f20767h.L(relay5.f20763d, jZ);
                                        long jE02 = this.f20773d.f20767h.E0();
                                        Relay relay6 = this.f20773d;
                                        if (jE02 > relay6.f20768i) {
                                            C2792e c2792e2 = relay6.f20767h;
                                            c2792e2.skip(c2792e2.E0() - this.f20773d.f20768i);
                                        }
                                        relay = this.f20773d;
                                        relay.f20764e += jZ;
                                    } finally {
                                    }
                                }
                                synchronized (relay) {
                                    Relay relay7 = this.f20773d;
                                    relay7.f20761b = null;
                                    relay7.notifyAll();
                                }
                                return jMin3;
                            } catch (Throwable th) {
                                synchronized (this.f20773d) {
                                    Relay relay8 = this.f20773d;
                                    relay8.f20761b = null;
                                    relay8.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        this.f20770a.i(relay2);
                    } finally {
                    }
                }
            }
        }
    }

    public void a(long j7) throws IOException {
        c(j7);
        this.f20760a.getChannel().force(false);
        b(f20758k, j7, this.f20766g.H());
        this.f20760a.getChannel().force(false);
        synchronized (this) {
            this.f20765f = true;
        }
        Util.f(this.f20762c);
        this.f20762c = null;
    }

    public final void b(C2795h c2795h, long j7, long j8) throws IOException {
        C2792e c2792e = new C2792e();
        c2792e.m(c2795h);
        c2792e.P0(j7);
        c2792e.P0(j8);
        if (c2792e.E0() != 32) {
            throw new IllegalArgumentException();
        }
        new FileOperator(this.f20760a.getChannel()).b(0L, c2792e, 32L);
    }

    public final void c(long j7) throws IOException {
        C2792e c2792e = new C2792e();
        c2792e.m(this.f20766g);
        new FileOperator(this.f20760a.getChannel()).b(32 + j7, c2792e, this.f20766g.H());
    }
}
