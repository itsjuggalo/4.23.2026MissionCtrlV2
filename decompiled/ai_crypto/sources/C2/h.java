package C2;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {
    public static d a(int i7) {
        return i7 != 0 ? i7 != 1 ? b() : new e() : new j();
    }

    public static d b() {
        return new j();
    }

    public static f c() {
        return new f();
    }

    public static void d(View view, g gVar) {
        if (gVar.M()) {
            gVar.X(y2.l.d(view));
        }
    }
}
