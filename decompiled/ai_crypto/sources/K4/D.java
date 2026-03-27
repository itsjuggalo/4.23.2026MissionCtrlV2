package K4;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.Window;
import android.view.WindowInsets;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import q5.AbstractC2569h;

/* JADX INFO: loaded from: classes2.dex */
public class D {
    public List a(Context context) {
        WindowInsets windowInsetsB = b(context);
        return windowInsetsB == null ? Collections.emptyList() : windowInsetsB.getBoundingRects(WindowInsets.Type.captionBar());
    }

    public WindowInsets b(Context context) {
        Window window;
        Activity activityE = AbstractC2569h.e(context);
        if (activityE == null || (window = activityE.getWindow()) == null) {
            return null;
        }
        return window.getDecorView().getRootWindowInsets();
    }

    public void c(Context context, FlutterRenderer.g gVar) {
        List listA = a(context);
        int iMax = gVar.f16588d;
        Iterator it = listA.iterator();
        while (it.hasNext()) {
            iMax = Math.max(iMax, ((Rect) it.next()).bottom);
        }
        gVar.f16588d = iMax;
    }
}
