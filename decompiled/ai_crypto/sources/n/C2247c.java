package n;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import h.AbstractC1663h;

/* JADX INFO: renamed from: n.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2247c extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f19007f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f19008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f19009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f19010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f19011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f19012e;

    /* JADX INFO: renamed from: n.c$a */
    public static class a {
        public static Context a(C2247c c2247c, Configuration configuration) {
            return c2247c.createConfigurationContext(configuration);
        }
    }

    public C2247c(Context context, int i7) {
        super(context);
        this.f19008a = i7;
    }

    public static boolean d(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f19007f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f19007f = configuration2;
        }
        return configuration.equals(f19007f);
    }

    public final Resources a() {
        if (this.f19012e == null) {
            Configuration configuration = this.f19011d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && d(configuration))) {
                this.f19012e = super.getResources();
            } else {
                this.f19012e = a.a(this, this.f19011d).getResources();
            }
        }
        return this.f19012e;
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public int b() {
        return this.f19008a;
    }

    public final void c() {
        boolean z7 = this.f19009b == null;
        if (z7) {
            this.f19009b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f19009b.setTo(theme);
            }
        }
        e(this.f19009b, this.f19008a, z7);
    }

    public void e(Resources.Theme theme, int i7, boolean z7) {
        theme.applyStyle(i7, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return a();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f19010c == null) {
            this.f19010c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f19010c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f19009b;
        if (theme != null) {
            return theme;
        }
        if (this.f19008a == 0) {
            this.f19008a = AbstractC1663h.f14475b;
        }
        c();
        return this.f19009b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i7) {
        if (this.f19008a != i7) {
            this.f19008a = i7;
            c();
        }
    }
}
