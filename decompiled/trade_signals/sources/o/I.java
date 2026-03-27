package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class I extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f21765c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList f21766d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f21767a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f21768b;

    public I(Context context) {
        super(context);
        if (!V.c()) {
            this.f21767a = new K(this, context.getResources());
            this.f21768b = null;
            return;
        }
        V v8 = new V(this, context.getResources());
        this.f21767a = v8;
        Resources.Theme themeNewTheme = v8.newTheme();
        this.f21768b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        if ((context instanceof I) || (context.getResources() instanceof K) || (context.getResources() instanceof V)) {
            return false;
        }
        return V.c();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f21765c) {
            try {
                ArrayList arrayList = f21766d;
                if (arrayList == null) {
                    f21766d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f21766d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f21766d.remove(size);
                        }
                    }
                    for (int size2 = f21766d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f21766d.get(size2);
                        I i8 = weakReference2 != null ? (I) weakReference2.get() : null;
                        if (i8 != null && i8.getBaseContext() == context) {
                            return i8;
                        }
                    }
                }
                I i9 = new I(context);
                f21766d.add(new WeakReference(i9));
                return i9;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f21767a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f21767a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f21768b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i8) {
        Resources.Theme theme = this.f21768b;
        if (theme == null) {
            super.setTheme(i8);
        } else {
            theme.applyStyle(i8, true);
        }
    }
}
