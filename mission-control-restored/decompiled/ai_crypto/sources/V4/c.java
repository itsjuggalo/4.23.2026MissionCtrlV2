package V4;

import V4.b;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.b f5319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f5321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.c f5322d;

    public interface b {
        void a(Object obj);

        void b(String str, String str2, Object obj);

        void c();
    }

    /* JADX INFO: renamed from: V4.c$c, reason: collision with other inner class name */
    public final class C0093c implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f5323a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReference f5324b = new AtomicReference(null);

        /* JADX INFO: renamed from: V4.c$c$a */
        public final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final AtomicBoolean f5326a;

            public a() {
                this.f5326a = new AtomicBoolean(false);
            }

            @Override // V4.c.b
            public void a(Object obj) {
                if (this.f5326a.get() || C0093c.this.f5324b.get() != this) {
                    return;
                }
                c.this.f5319a.f(c.this.f5320b, c.this.f5321c.c(obj));
            }

            @Override // V4.c.b
            public void b(String str, String str2, Object obj) {
                if (this.f5326a.get() || C0093c.this.f5324b.get() != this) {
                    return;
                }
                c.this.f5319a.f(c.this.f5320b, c.this.f5321c.e(str, str2, obj));
            }

            @Override // V4.c.b
            public void c() {
                if (this.f5326a.getAndSet(true) || C0093c.this.f5324b.get() != this) {
                    return;
                }
                c.this.f5319a.f(c.this.f5320b, null);
            }
        }

        public C0093c(d dVar) {
            this.f5323a = dVar;
        }

        @Override // V4.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0092b interfaceC0092b) {
            i iVarB = c.this.f5321c.b(byteBuffer);
            if (iVarB.f5332a.equals("listen")) {
                d(iVarB.f5333b, interfaceC0092b);
            } else if (iVarB.f5332a.equals("cancel")) {
                c(iVarB.f5333b, interfaceC0092b);
            } else {
                interfaceC0092b.a(null);
            }
        }

        public final void c(Object obj, b.InterfaceC0092b interfaceC0092b) {
            if (((b) this.f5324b.getAndSet(null)) == null) {
                interfaceC0092b.a(c.this.f5321c.e("error", "No active stream to cancel", null));
                return;
            }
            try {
                this.f5323a.c(obj);
                interfaceC0092b.a(c.this.f5321c.c(null));
            } catch (RuntimeException e7) {
                J4.b.c("EventChannel#" + c.this.f5320b, "Failed to close event stream", e7);
                interfaceC0092b.a(c.this.f5321c.e("error", e7.getMessage(), null));
            }
        }

        public final void d(Object obj, b.InterfaceC0092b interfaceC0092b) {
            a aVar = new a();
            if (((b) this.f5324b.getAndSet(aVar)) != null) {
                try {
                    this.f5323a.c(null);
                } catch (RuntimeException e7) {
                    J4.b.c("EventChannel#" + c.this.f5320b, "Failed to close existing event stream", e7);
                }
            }
            try {
                this.f5323a.b(obj, aVar);
                interfaceC0092b.a(c.this.f5321c.c(null));
            } catch (RuntimeException e8) {
                this.f5324b.set(null);
                J4.b.c("EventChannel#" + c.this.f5320b, "Failed to open event stream", e8);
                interfaceC0092b.a(c.this.f5321c.e("error", e8.getMessage(), null));
            }
        }
    }

    public interface d {
        void b(Object obj, b bVar);

        void c(Object obj);
    }

    public c(V4.b bVar, String str) {
        this(bVar, str, p.f5347b);
    }

    public void d(d dVar) {
        if (this.f5322d != null) {
            this.f5319a.e(this.f5320b, dVar != null ? new C0093c(dVar) : null, this.f5322d);
        } else {
            this.f5319a.b(this.f5320b, dVar != null ? new C0093c(dVar) : null);
        }
    }

    public c(V4.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public c(V4.b bVar, String str, k kVar, b.c cVar) {
        this.f5319a = bVar;
        this.f5320b = str;
        this.f5321c = kVar;
        this.f5322d = cVar;
    }
}
