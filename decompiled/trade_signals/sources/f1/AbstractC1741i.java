package f1;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import i.AbstractC1906a;
import m.C2340b;

/* JADX INFO: renamed from: f1.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1741i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f17381a = true;

    public static Drawable a(Context context, int i8, Resources.Theme theme) {
        return c(context, context, i8, theme);
    }

    public static Drawable b(Context context, Context context2, int i8) {
        return c(context, context2, i8, null);
    }

    public static Drawable c(Context context, Context context2, int i8, Resources.Theme theme) {
        try {
            if (f17381a) {
                return e(context2, i8, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e8) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e8;
            }
            return I.a.e(context2, i8);
        } catch (NoClassDefFoundError unused2) {
            f17381a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i8, theme);
    }

    public static Drawable d(Context context, int i8, Resources.Theme theme) {
        return K.f.d(context.getResources(), i8, theme);
    }

    public static Drawable e(Context context, int i8, Resources.Theme theme) {
        if (theme != null) {
            C2340b c2340b = new C2340b(context, theme);
            c2340b.a(theme.getResources().getConfiguration());
            context = c2340b;
        }
        return AbstractC1906a.b(context, i8);
    }
}
