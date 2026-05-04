package t3;

import android.util.Log;
import g3.k;
import i3.v;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d implements k {
    @Override // g3.k
    public g3.c b(g3.h hVar) {
        return g3.c.SOURCE;
    }

    @Override // g3.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(v vVar, File file, g3.h hVar) throws Throwable {
        try {
            c4.a.f(((c) vVar.get()).c(), file);
            return true;
        } catch (IOException e10) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e10);
            return false;
        }
    }
}
