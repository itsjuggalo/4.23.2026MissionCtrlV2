package u1;

import android.content.Context;
import java.io.File;

/* JADX INFO: renamed from: u1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2768c {

    /* JADX INFO: renamed from: u1.c$a */
    public interface a {
        void a(Context context, String[] strArr, String str, File file, C2769d c2769d);
    }

    /* JADX INFO: renamed from: u1.c$b */
    public interface b {
        String a(String str);

        void b(String str);

        String c(String str);

        String[] d();

        void e(String str);
    }

    /* JADX INFO: renamed from: u1.c$c, reason: collision with other inner class name */
    public interface InterfaceC0409c {
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, InterfaceC0409c interfaceC0409c) {
        new C2769d().f(context, str, str2, interfaceC0409c);
    }
}
