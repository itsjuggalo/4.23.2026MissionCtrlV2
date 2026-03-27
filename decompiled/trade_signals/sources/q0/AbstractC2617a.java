package q0;

import androidx.lifecycle.InterfaceC1161m;
import androidx.lifecycle.N;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: q0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2617a {
    public static AbstractC2617a b(InterfaceC1161m interfaceC1161m) {
        return new b(interfaceC1161m, ((N) interfaceC1161m).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void c();
}
