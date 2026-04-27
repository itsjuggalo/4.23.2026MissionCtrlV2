package j3;

import java.io.File;

/* JADX INFO: renamed from: j3.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2050f {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f17388c = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n3.g f17389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC2048d f17390b;

    public C2050f(n3.g gVar) {
        this.f17389a = gVar;
        this.f17390b = f17388c;
    }

    public void a() {
        this.f17390b.d();
    }

    public byte[] b() {
        return this.f17390b.c();
    }

    public String c() {
        return this.f17390b.b();
    }

    public final File d(String str) {
        return this.f17389a.q(str, "userlog");
    }

    public final void e(String str) {
        this.f17390b.a();
        this.f17390b = f17388c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    public void f(File file, int i7) {
        this.f17390b = new C2053i(file, i7);
    }

    public void g(long j7, String str) {
        this.f17390b.e(j7, str);
    }

    public C2050f(n3.g gVar, String str) {
        this(gVar);
        e(str);
    }

    /* JADX INFO: renamed from: j3.f$b */
    public static final class b implements InterfaceC2048d {
        public b() {
        }

        @Override // j3.InterfaceC2048d
        public String b() {
            return null;
        }

        @Override // j3.InterfaceC2048d
        public byte[] c() {
            return null;
        }

        @Override // j3.InterfaceC2048d
        public void a() {
        }

        @Override // j3.InterfaceC2048d
        public void d() {
        }

        @Override // j3.InterfaceC2048d
        public void e(long j7, String str) {
        }
    }
}
