package p;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class O extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f21293c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList f21294d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f21295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f21296b;

    public O(Context context) {
        super(context);
        if (!b0.c()) {
            this.f21295a = new Q(this, context.getResources());
            this.f21296b = null;
            return;
        }
        b0 b0Var = new b0(this, context.getResources());
        this.f21295a = b0Var;
        Resources.Theme themeNewTheme = b0Var.newTheme();
        this.f21296b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        if ((context instanceof O) || (context.getResources() instanceof Q) || (context.getResources() instanceof b0)) {
            return false;
        }
        return b0.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f21293c) {
            try {
                ArrayList arrayList = f21294d;
                if (arrayList == null) {
                    f21294d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f21294d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f21294d.remove(size);
                        }
                    }
                    for (int size2 = f21294d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f21294d.get(size2);
                        O o7 = weakReference2 != null ? (O) weakReference2.get() : null;
                        if (o7 != null && o7.getBaseContext() == context) {
                            return o7;
                        }
                    }
                }
                O o8 = new O(context);
                f21294d.add(new WeakReference(o8));
                return o8;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f21295a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f21295a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f21296b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i7) {
        Resources.Theme theme = this.f21296b;
        if (theme == null) {
            super.setTheme(i7);
        } else {
            theme.applyStyle(i7, true);
        }
    }
}
