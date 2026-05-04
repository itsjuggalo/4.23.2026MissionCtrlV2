package z1;

import android.os.Bundle;
import androidx.lifecycle.m;
import androidx.lifecycle.m0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: z1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface InterfaceC0478a {
        a2.b a(int i10, Bundle bundle);

        void b(a2.b bVar);

        void c(a2.b bVar, Object obj);
    }

    public static a b(m mVar) {
        return new b(mVar, ((m0) mVar).getViewModelStore());
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract a2.b c(int i10, Bundle bundle, InterfaceC0478a interfaceC0478a);

    public abstract void d();
}
