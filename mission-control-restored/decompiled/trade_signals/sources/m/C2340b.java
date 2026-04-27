package m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import g.h;

/* JADX INFO: renamed from: m.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2340b extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f21177f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f21178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f21179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f21180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f21181d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f21182e;

    public C2340b(Context context, Resources.Theme theme) {
        super(context);
        this.f21179b = theme;
    }

    public static boolean d(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f21177f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f21177f = configuration2;
        }
        return configuration.equals(f21177f);
    }

    public void a(Configuration configuration) {
        if (this.f21182e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f21181d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f21181d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f21182e == null) {
            Configuration configuration = this.f21181d;
            this.f21182e = (configuration == null || (Build.VERSION.SDK_INT >= 26 && d(configuration))) ? super.getResources() : createConfigurationContext(this.f21181d).getResources();
        }
        return this.f21182e;
    }

    public final void c() {
        boolean z7 = this.f21179b == null;
        if (z7) {
            this.f21179b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f21179b.setTo(theme);
            }
        }
        e(this.f21179b, this.f21178a, z7);
    }

    public void e(Resources.Theme theme, int i8, boolean z7) {
        theme.applyStyle(i8, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f21180c == null) {
            this.f21180c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f21180c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f21179b;
        if (theme != null) {
            return theme;
        }
        if (this.f21178a == 0) {
            this.f21178a = h.f17771b;
        }
        c();
        return this.f21179b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i8) {
        if (this.f21178a != i8) {
            this.f21178a = i8;
            c();
        }
    }
}
