package t0;

import android.os.Bundle;
import androidx.lifecycle.InterfaceC0967m;
import androidx.lifecycle.N;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import u0.AbstractC2743b;

/* JADX INFO: renamed from: t0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2648a {

    /* JADX INFO: renamed from: t0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0363a {
        AbstractC2743b a(int i7, Bundle bundle);

        void b(AbstractC2743b abstractC2743b, Object obj);

        void c(AbstractC2743b abstractC2743b);
    }

    public static AbstractC2648a b(InterfaceC0967m interfaceC0967m) {
        return new C2649b(interfaceC0967m, ((N) interfaceC0967m).f());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract AbstractC2743b c(int i7, Bundle bundle, InterfaceC0363a interfaceC0363a);

    public abstract void d();
}
