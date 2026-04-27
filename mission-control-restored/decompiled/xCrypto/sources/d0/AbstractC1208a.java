package d0;

import android.os.Bundle;
import androidx.lifecycle.InterfaceC0850m;
import androidx.lifecycle.N;
import e0.AbstractC1226b;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: renamed from: d0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1208a {

    /* JADX INFO: renamed from: d0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0181a {
        AbstractC1226b a(int i4, Bundle bundle);

        void b(AbstractC1226b abstractC1226b, Object obj);

        void c(AbstractC1226b abstractC1226b);
    }

    public static AbstractC1208a b(InterfaceC0850m interfaceC0850m) {
        return new C1209b(interfaceC0850m, ((N) interfaceC0850m).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract AbstractC1226b c(int i4, Bundle bundle, InterfaceC0181a interfaceC0181a);

    public abstract void d();
}
