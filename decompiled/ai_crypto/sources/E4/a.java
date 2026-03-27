package E4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.util.Log;
import android.view.WindowManager;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {
    public static int a(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getSize(point);
        }
        int iSqrt = (int) Math.sqrt(Math.pow(point.x, 2.0d) + Math.pow(point.y, 2.0d));
        Canvas canvas = new Canvas();
        int iMin = Math.min(canvas.getMaximumBitmapWidth(), canvas.getMaximumBitmapHeight());
        if (iMin > 0) {
            iSqrt = Math.min(iSqrt, iMin);
        }
        int iB = c.b();
        if (iB > 0) {
            iSqrt = Math.min(iSqrt, iB);
        }
        Log.d("BitmapLoadUtils", "maxBitmapSize: " + iSqrt);
        return iSqrt;
    }
}
