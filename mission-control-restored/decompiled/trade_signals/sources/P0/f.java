package P0;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class f implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f6268b = new f();

    @Override // P0.b
    public Rect a(Activity activity) throws Exception {
        AbstractC2304t.f(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object objInvoke = obj.getClass().getDeclaredMethod("getBounds", null).invoke(obj, null);
            AbstractC2304t.d(objInvoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) objInvoke);
        } catch (Exception e8) {
            if (!(e8 instanceof NoSuchFieldException ? true : e8 instanceof NoSuchMethodException ? true : e8 instanceof IllegalAccessException ? true : e8 instanceof InvocationTargetException)) {
                throw e8;
            }
            Log.w(b.f6262a.b(), e8);
            return e.f6267b.a(activity);
        }
    }

    @Override // P0.b
    public Rect b(Context context) {
        AbstractC2304t.f(context, "context");
        return e.f6267b.b(context);
    }
}
