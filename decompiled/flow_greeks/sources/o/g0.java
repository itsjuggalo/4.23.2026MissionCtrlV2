package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class g0 extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f17268c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList f17269d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f17270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f17271b;

    public g0(Context context) {
        super(context);
        if (!s0.c()) {
            this.f17270a = new i0(this, context.getResources());
            this.f17271b = null;
            return;
        }
        s0 s0Var = new s0(this, context.getResources());
        this.f17270a = s0Var;
        Resources.Theme themeNewTheme = s0Var.newTheme();
        this.f17271b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        return ((context instanceof g0) || (context.getResources() instanceof i0) || (context.getResources() instanceof s0) || !s0.c()) ? false : true;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f17268c) {
            try {
                ArrayList arrayList = f17269d;
                if (arrayList == null) {
                    f17269d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f17269d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f17269d.remove(size);
                        }
                    }
                    for (int size2 = f17269d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f17269d.get(size2);
                        g0 g0Var = weakReference2 != null ? (g0) weakReference2.get() : null;
                        if (g0Var != null && g0Var.getBaseContext() == context) {
                            return g0Var;
                        }
                    }
                }
                g0 g0Var2 = new g0(context);
                f17269d.add(new WeakReference(g0Var2));
                return g0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f17270a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f17270a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f17271b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f17271b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
