package m1;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: m1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2229c {

    /* JADX INFO: renamed from: m1.c$a */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, C2230d c2230d);
    }

    /* JADX INFO: renamed from: m1.c$b */
    public interface b {
        String a(String str);

        void b(String str);

        String c(String str);

        String[] d();

        void e(String str);
    }

    /* JADX INFO: renamed from: m1.c$c, reason: collision with other inner class name */
    public interface InterfaceC0310c {
    }

    /* JADX INFO: renamed from: m1.c$d */
    public interface d {
        void a(String str);
    }

    public static C2230d a(d dVar) {
        return new C2230d().h(dVar);
    }
}
