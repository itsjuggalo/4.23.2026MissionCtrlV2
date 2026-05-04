package r3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile boolean f19291a = true;

    public static Drawable a(Context context, int i10, Resources.Theme theme) {
        return c(context, context, i10, theme);
    }

    public static Drawable b(Context context, Context context2, int i10) {
        return c(context, context2, i10, null);
    }

    public static Drawable c(Context context, Context context2, int i10, Resources.Theme theme) {
        try {
            if (f19291a) {
                return e(context2, i10, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e10) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e10;
            }
            return i0.a.f(context2, i10);
        } catch (NoClassDefFoundError unused2) {
            f19291a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return d(context2, i10, theme);
    }

    public static Drawable d(Context context, int i10, Resources.Theme theme) {
        return k0.f.d(context.getResources(), i10, theme);
    }

    public static Drawable e(Context context, int i10, Resources.Theme theme) {
        if (theme != null) {
            m.b bVar = new m.b(context, theme);
            bVar.a(theme.getResources().getConfiguration());
            context = bVar;
        }
        return i.a.b(context, i10);
    }
}
