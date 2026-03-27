package o;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class X extends ContextWrapper {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f13786c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList f13787d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Resources f13788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Resources.Theme f13789b;

    public X(Context context) {
        super(context);
        if (!f0.b()) {
            this.f13788a = new Z(this, context.getResources());
            this.f13789b = null;
            return;
        }
        f0 f0Var = new f0(this, context.getResources());
        this.f13788a = f0Var;
        Resources.Theme themeNewTheme = f0Var.newTheme();
        this.f13789b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        return ((context instanceof X) || (context.getResources() instanceof Z) || (context.getResources() instanceof f0) || !f0.b()) ? false : true;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f13786c) {
            try {
                ArrayList arrayList = f13787d;
                if (arrayList == null) {
                    f13787d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) f13787d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f13787d.remove(size);
                        }
                    }
                    for (int size2 = f13787d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) f13787d.get(size2);
                        X x4 = weakReference2 != null ? (X) weakReference2.get() : null;
                        if (x4 != null && x4.getBaseContext() == context) {
                            return x4;
                        }
                    }
                }
                X x5 = new X(context);
                f13787d.add(new WeakReference(x5));
                return x5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f13788a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f13788a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f13789b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i4) {
        Resources.Theme theme = this.f13789b;
        if (theme == null) {
            super.setTheme(i4);
        } else {
            theme.applyStyle(i4, true);
        }
    }
}
