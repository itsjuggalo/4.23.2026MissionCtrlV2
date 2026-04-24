package q0;

import androidx.lifecycle.InterfaceC1161m;
import androidx.lifecycle.J;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import w.j;

/* JADX INFO: loaded from: classes.dex */
public class b extends AbstractC2617a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1161m f22506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f22507b;

    public static class a extends J {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final K.b f22508f = new C0380a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public j f22509d = new j();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f22510e = false;

        /* JADX INFO: renamed from: q0.b$a$a, reason: collision with other inner class name */
        public static class C0380a implements K.b {
            @Override // androidx.lifecycle.K.b
            public J a(Class cls) {
                return new a();
            }
        }

        public static a g(M m8) {
            return (a) new K(m8, f22508f).a(a.class);
        }

        @Override // androidx.lifecycle.J
        public void d() {
            super.d();
            if (this.f22509d.i() <= 0) {
                this.f22509d.c();
            } else {
                android.support.v4.media.session.b.a(this.f22509d.j(0));
                throw null;
            }
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f22509d.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f22509d.i() <= 0) {
                    return;
                }
                android.support.v4.media.session.b.a(this.f22509d.j(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f22509d.g(0));
                printWriter.print(": ");
                throw null;
            }
        }

        public void h() {
            if (this.f22509d.i() <= 0) {
                return;
            }
            android.support.v4.media.session.b.a(this.f22509d.j(0));
            throw null;
        }
    }

    public b(InterfaceC1161m interfaceC1161m, M m8) {
        this.f22506a = interfaceC1161m;
        this.f22507b = a.g(m8);
    }

    @Override // q0.AbstractC2617a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f22507b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // q0.AbstractC2617a
    public void c() {
        this.f22507b.h();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        S.b.a(this.f22506a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
