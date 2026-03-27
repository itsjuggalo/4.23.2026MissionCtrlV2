package V4;

import V4.b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V4.b f5334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f5336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b.c f5337d;

    public final class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f5338a;

        /* JADX INFO: renamed from: V4.j$a$a, reason: collision with other inner class name */
        public class C0094a implements d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ b.InterfaceC0092b f5340a;

            public C0094a(b.InterfaceC0092b interfaceC0092b) {
                this.f5340a = interfaceC0092b;
            }

            @Override // V4.j.d
            public void a(Object obj) {
                this.f5340a.a(j.this.f5336c.c(obj));
            }

            @Override // V4.j.d
            public void b(String str, String str2, Object obj) {
                this.f5340a.a(j.this.f5336c.e(str, str2, obj));
            }

            @Override // V4.j.d
            public void c() {
                this.f5340a.a(null);
            }
        }

        public a(c cVar) {
            this.f5338a = cVar;
        }

        @Override // V4.b.a
        public void a(ByteBuffer byteBuffer, b.InterfaceC0092b interfaceC0092b) {
            try {
                this.f5338a.onMethodCall(j.this.f5336c.b(byteBuffer), new C0094a(interfaceC0092b));
            } catch (RuntimeException e7) {
                J4.b.c("MethodChannel#" + j.this.f5335b, "Failed to handle method call", e7);
                interfaceC0092b.a(j.this.f5336c.d("error", e7.getMessage(), null, J4.b.d(e7)));
            }
        }
    }

    public final class b implements b.InterfaceC0092b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f5342a;

        public b(d dVar) {
            this.f5342a = dVar;
        }

        @Override // V4.b.InterfaceC0092b
        public void a(ByteBuffer byteBuffer) {
            try {
                if (byteBuffer == null) {
                    this.f5342a.c();
                } else {
                    try {
                        this.f5342a.a(j.this.f5336c.f(byteBuffer));
                    } catch (V4.d e7) {
                        this.f5342a.b(e7.f5328a, e7.getMessage(), e7.f5329b);
                    }
                }
            } catch (RuntimeException e8) {
                J4.b.c("MethodChannel#" + j.this.f5335b, "Failed to handle method call result", e8);
            }
        }
    }

    public interface c {
        void onMethodCall(i iVar, d dVar);
    }

    public interface d {
        void a(Object obj);

        void b(String str, String str2, Object obj);

        void c();
    }

    public j(V4.b bVar, String str) {
        this(bVar, str, p.f5347b);
    }

    public void c(String str, Object obj) {
        d(str, obj, null);
    }

    public void d(String str, Object obj, d dVar) {
        this.f5334a.d(this.f5335b, this.f5336c.a(new i(str, obj)), dVar == null ? null : new b(dVar));
    }

    public void e(c cVar) {
        if (this.f5337d != null) {
            this.f5334a.e(this.f5335b, cVar != null ? new a(cVar) : null, this.f5337d);
        } else {
            this.f5334a.b(this.f5335b, cVar != null ? new a(cVar) : null);
        }
    }

    public j(V4.b bVar, String str, k kVar) {
        this(bVar, str, kVar, null);
    }

    public j(V4.b bVar, String str, k kVar, b.c cVar) {
        this.f5334a = bVar;
        this.f5335b = str;
        this.f5336c = kVar;
        this.f5337d = cVar;
    }
}
