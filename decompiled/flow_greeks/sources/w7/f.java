package w7;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f23696c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a8.g f23697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f23698b;

    public f(a8.g gVar) {
        this.f23697a = gVar;
        this.f23698b = f23696c;
    }

    public void a() {
        this.f23698b.d();
    }

    public byte[] b() {
        return this.f23698b.c();
    }

    public String c() {
        return this.f23698b.b();
    }

    public final File d(String str) {
        return this.f23697a.q(str, "userlog");
    }

    public final void e(String str) {
        this.f23698b.a();
        this.f23698b = f23696c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    public void f(File file, int i10) {
        this.f23698b = new i(file, i10);
    }

    public void g(long j10, String str) {
        this.f23698b.e(j10, str);
    }

    public f(a8.g gVar, String str) {
        this(gVar);
        e(str);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements d {
        public b() {
        }

        @Override // w7.d
        public String b() {
            return null;
        }

        @Override // w7.d
        public byte[] c() {
            return null;
        }

        @Override // w7.d
        public void a() {
        }

        @Override // w7.d
        public void d() {
        }

        @Override // w7.d
        public void e(long j10, String str) {
        }
    }
}
