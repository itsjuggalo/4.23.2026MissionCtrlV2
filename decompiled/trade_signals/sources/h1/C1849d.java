package h1;

import U0.k;
import W0.v;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import q1.AbstractC2618a;

/* JADX INFO: renamed from: h1.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1849d implements k {
    @Override // U0.k
    public U0.c b(U0.h hVar) {
        return U0.c.SOURCE;
    }

    @Override // U0.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(v vVar, File file, U0.h hVar) throws Throwable {
        try {
            AbstractC2618a.f(((C1848c) vVar.get()).c(), file);
            return true;
        } catch (IOException e8) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e8);
            }
            return false;
        }
    }
}
