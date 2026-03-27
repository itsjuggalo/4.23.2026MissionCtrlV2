package k1;

import android.util.Log;
import c1.C1124a;

/* JADX INFO: renamed from: k1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2065a {
    public static final void a(Object obj) {
        String string;
        if (C1124a.f9329e.a()) {
            if (obj == null || (string = obj.toString()) == null) {
                string = "null";
            }
            Log.i("flutter_image_compress", string);
        }
    }
}
