package V0;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, V0.d dVar);
    }

    public interface b {
        String a(String str);

        void b(String str);

        String c(String str);

        String[] d();

        void e(String str);
    }

    /* JADX INFO: renamed from: V0.c$c, reason: collision with other inner class name */
    public interface InterfaceC0074c {
    }

    public interface d {
        void a(String str);
    }

    public static V0.d a(d dVar) {
        return new V0.d().h(dVar);
    }
}
