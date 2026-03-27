package M4;

import V4.b;
import io.flutter.embedding.engine.FlutterJNI;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import q5.C2566e;

/* JADX INFO: loaded from: classes2.dex */
public class c implements V4.b, M4.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f3866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f3867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f3868c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f3869d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicBoolean f3870e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map f3871f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d f3873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public WeakHashMap f3874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i f3875j;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f3876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3877b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f3878c;

        public b(ByteBuffer byteBuffer, int i7, long j7) {
            this.f3876a = byteBuffer;
            this.f3877b = i7;
            this.f3878c = j7;
        }
    }

    /* JADX INFO: renamed from: M4.c$c, reason: collision with other inner class name */
    public static class C0051c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f3879a;

        public C0051c(ExecutorService executorService) {
            this.f3879a = executorService;
        }

        @Override // M4.c.d
        public void a(Runnable runnable) {
            this.f3879a.execute(runnable);
        }
    }

    public interface d {
        void a(Runnable runnable);
    }

    public static class e implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ExecutorService f3880a = J4.a.e().b();

        @Override // M4.c.i
        public d a(b.d dVar) {
            return dVar.a() ? new h(this.f3880a) : new C0051c(this.f3880a);
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b.a f3881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f3882b;

        public f(b.a aVar, d dVar) {
            this.f3881a = aVar;
            this.f3882b = dVar;
        }
    }

    public static class g implements b.InterfaceC0092b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FlutterJNI f3883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f3884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f3885c = new AtomicBoolean(false);

        public g(FlutterJNI flutterJNI, int i7) {
            this.f3883a = flutterJNI;
            this.f3884b = i7;
        }

        @Override // V4.b.InterfaceC0092b
        public void a(ByteBuffer byteBuffer) {
            if (this.f3885c.getAndSet(true)) {
                throw new IllegalStateException("Reply already submitted");
            }
            if (byteBuffer == null) {
                this.f3883a.invokePlatformMessageEmptyResponseCallback(this.f3884b);
            } else {
                this.f3883a.invokePlatformMessageResponseCallback(this.f3884b, byteBuffer, byteBuffer.position());
            }
        }
    }

    public static class h implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f3886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentLinkedQueue f3887b = new ConcurrentLinkedQueue();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicBoolean f3888c = new AtomicBoolean(false);

        public h(ExecutorService executorService) {
            this.f3886a = executorService;
        }

        @Override // M4.c.d
        public void a(Runnable runnable) {
            this.f3887b.add(runnable);
            this.f3886a.execute(new Runnable() { // from class: M4.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f3889a.e();
                }
            });
        }

        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public final void f() {
            if (this.f3888c.compareAndSet(false, true)) {
                try {
                    Runnable runnable = (Runnable) this.f3887b.poll();
                    if (runnable != null) {
                        runnable.run();
                    }
                } finally {
                    this.f3888c.set(false);
                    if (!this.f3887b.isEmpty()) {
                        this.f3886a.execute(new Runnable() { // from class: M4.e
                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f3890a.f();
                            }
                        });
                    }
                }
            }
        }
    }

    public interface i {
        d a(b.d dVar);
    }

    public static class j implements b.c {
        public j() {
        }
    }

    public c(FlutterJNI flutterJNI, i iVar) {
        this.f3867b = new HashMap();
        this.f3868c = new HashMap();
        this.f3869d = new Object();
        this.f3870e = new AtomicBoolean(false);
        this.f3871f = new HashMap();
        this.f3872g = 1;
        this.f3873h = new M4.g();
        this.f3874i = new WeakHashMap();
        this.f3866a = flutterJNI;
        this.f3875j = iVar;
    }

    public static void k(Error error) {
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread.getUncaughtExceptionHandler() == null) {
            throw error;
        }
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, error);
    }

    @Override // V4.b
    public b.c a(b.d dVar) {
        d dVarA = this.f3875j.a(dVar);
        j jVar = new j();
        this.f3874i.put(jVar, dVarA);
        return jVar;
    }

    @Override // V4.b
    public void b(String str, b.a aVar) {
        e(str, aVar, null);
    }

    @Override // V4.b
    public void d(String str, ByteBuffer byteBuffer, b.InterfaceC0092b interfaceC0092b) {
        C2566e c2566eK = C2566e.K("DartMessenger#send on " + str);
        try {
            J4.b.f("DartMessenger", "Sending message with callback over channel '" + str + "'");
            int i7 = this.f3872g;
            this.f3872g = i7 + 1;
            if (interfaceC0092b != null) {
                this.f3871f.put(Integer.valueOf(i7), interfaceC0092b);
            }
            if (byteBuffer == null) {
                this.f3866a.dispatchEmptyPlatformMessage(str, i7);
            } else {
                this.f3866a.dispatchPlatformMessage(str, byteBuffer, byteBuffer.position(), i7);
            }
            if (c2566eK != null) {
                c2566eK.close();
            }
        } catch (Throwable th) {
            if (c2566eK != null) {
                try {
                    c2566eK.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // V4.b
    public void e(String str, b.a aVar, b.c cVar) {
        d dVar;
        if (aVar == null) {
            J4.b.f("DartMessenger", "Removing handler for channel '" + str + "'");
            synchronized (this.f3869d) {
                this.f3867b.remove(str);
            }
            return;
        }
        if (cVar != null) {
            dVar = (d) this.f3874i.get(cVar);
            if (dVar == null) {
                throw new IllegalArgumentException("Unrecognized TaskQueue, use BinaryMessenger to create your TaskQueue (ex makeBackgroundTaskQueue).");
            }
        } else {
            dVar = null;
        }
        J4.b.f("DartMessenger", "Setting handler for channel '" + str + "'");
        synchronized (this.f3869d) {
            try {
                this.f3867b.put(str, new f(aVar, dVar));
                List<b> list = (List) this.f3868c.remove(str);
                if (list == null) {
                    return;
                }
                for (b bVar : list) {
                    j(str, (f) this.f3867b.get(str), bVar.f3876a, bVar.f3877b, bVar.f3878c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // V4.b
    public void f(String str, ByteBuffer byteBuffer) {
        J4.b.f("DartMessenger", "Sending message over channel '" + str + "'");
        d(str, byteBuffer, null);
    }

    @Override // M4.f
    public void g(int i7, ByteBuffer byteBuffer) {
        J4.b.f("DartMessenger", "Received message reply from Dart.");
        b.InterfaceC0092b interfaceC0092b = (b.InterfaceC0092b) this.f3871f.remove(Integer.valueOf(i7));
        if (interfaceC0092b != null) {
            try {
                J4.b.f("DartMessenger", "Invoking registered callback for reply from Dart.");
                interfaceC0092b.a(byteBuffer);
                if (byteBuffer == null || !byteBuffer.isDirect()) {
                    return;
                }
                byteBuffer.limit(0);
            } catch (Error e7) {
                k(e7);
            } catch (Exception e8) {
                J4.b.c("DartMessenger", "Uncaught exception in binary message reply handler", e8);
            }
        }
    }

    @Override // M4.f
    public void h(String str, ByteBuffer byteBuffer, int i7, long j7) {
        f fVar;
        boolean z7;
        J4.b.f("DartMessenger", "Received message from Dart over channel '" + str + "'");
        synchronized (this.f3869d) {
            try {
                fVar = (f) this.f3867b.get(str);
                z7 = this.f3870e.get() && fVar == null;
                if (z7) {
                    if (!this.f3868c.containsKey(str)) {
                        this.f3868c.put(str, new LinkedList());
                    }
                    ((List) this.f3868c.get(str)).add(new b(byteBuffer, i7, j7));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z7) {
            return;
        }
        j(str, fVar, byteBuffer, i7, j7);
    }

    public final void j(final String str, final f fVar, final ByteBuffer byteBuffer, final int i7, final long j7) {
        d dVar = fVar != null ? fVar.f3882b : null;
        C2566e.i("PlatformChannel ScheduleHandler on " + str, i7);
        Runnable runnable = new Runnable() { // from class: M4.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f3860a.m(str, i7, fVar, byteBuffer, j7);
            }
        };
        if (dVar == null) {
            dVar = this.f3873h;
        }
        dVar.a(runnable);
    }

    public final void l(f fVar, ByteBuffer byteBuffer, int i7) {
        if (fVar == null) {
            J4.b.f("DartMessenger", "No registered handler for message. Responding to Dart with empty reply message.");
            this.f3866a.invokePlatformMessageEmptyResponseCallback(i7);
            return;
        }
        try {
            J4.b.f("DartMessenger", "Deferring to registered handler to process message.");
            fVar.f3881a.a(byteBuffer, new g(this.f3866a, i7));
        } catch (Error e7) {
            k(e7);
        } catch (Exception e8) {
            J4.b.c("DartMessenger", "Uncaught exception in binary message listener", e8);
            this.f3866a.invokePlatformMessageEmptyResponseCallback(i7);
        }
    }

    public final /* synthetic */ void m(String str, int i7, f fVar, ByteBuffer byteBuffer, long j7) {
        C2566e.H("PlatformChannel ScheduleHandler on " + str, i7);
        try {
            C2566e c2566eK = C2566e.K("DartMessenger#handleMessageFromDart on " + str);
            try {
                l(fVar, byteBuffer, i7);
                if (byteBuffer != null && byteBuffer.isDirect()) {
                    byteBuffer.limit(0);
                }
                if (c2566eK != null) {
                    c2566eK.close();
                }
            } finally {
            }
        } finally {
            this.f3866a.cleanupMessageData(j7);
        }
    }

    public c(FlutterJNI flutterJNI) {
        this(flutterJNI, new e());
    }
}
