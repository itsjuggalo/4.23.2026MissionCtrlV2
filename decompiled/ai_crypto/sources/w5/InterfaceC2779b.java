package w5;

import java.io.Closeable;
import java.util.List;
import w6.C2795h;
import w6.InterfaceC2794g;

/* JADX INFO: renamed from: w5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2779b extends Closeable {

    /* JADX INFO: renamed from: w5.b$a */
    public interface a {
        void a(int i7, long j7);

        void b(boolean z7, int i7, int i8);

        void c(int i7, EnumC2778a enumC2778a);

        void d();

        void e(int i7, int i8, int i9, boolean z7);

        void f(int i7, int i8, List list);

        void g(boolean z7, boolean z8, int i7, int i8, List list, EnumC2782e enumC2782e);

        void h(int i7, EnumC2778a enumC2778a, C2795h c2795h);

        void i(boolean z7, int i7, InterfaceC2794g interfaceC2794g, int i8, int i9);

        void j(boolean z7, C2786i c2786i);
    }

    boolean x0(a aVar);
}
