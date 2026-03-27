package U2;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f8110c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Y2.g f8111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f8112b;

    public f(Y2.g gVar) {
        this.f8111a = gVar;
        this.f8112b = f8110c;
    }

    public void a() {
        this.f8112b.d();
    }

    public byte[] b() {
        return this.f8112b.c();
    }

    public String c() {
        return this.f8112b.b();
    }

    public final File d(String str) {
        return this.f8111a.q(str, "userlog");
    }

    public final void e(String str) {
        this.f8112b.a();
        this.f8112b = f8110c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    public void f(File file, int i8) {
        this.f8112b = new i(file, i8);
    }

    public void g(long j8, String str) {
        this.f8112b.e(j8, str);
    }

    public f(Y2.g gVar, String str) {
        this(gVar);
        e(str);
    }

    public static final class b implements d {
        public b() {
        }

        @Override // U2.d
        public String b() {
            return null;
        }

        @Override // U2.d
        public byte[] c() {
            return null;
        }

        @Override // U2.d
        public void a() {
        }

        @Override // U2.d
        public void d() {
        }

        @Override // U2.d
        public void e(long j8, String str) {
        }
    }
}
