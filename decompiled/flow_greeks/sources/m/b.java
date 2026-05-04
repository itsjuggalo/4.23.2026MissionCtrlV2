package m;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import g.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends ContextWrapper {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Configuration f15697f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Resources.Theme f15699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LayoutInflater f15700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Configuration f15701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Resources f15702e;

    public b(Context context, Resources.Theme theme) {
        super(context);
        this.f15699b = theme;
    }

    public static boolean d(Configuration configuration) {
        if (configuration == null) {
            return true;
        }
        if (f15697f == null) {
            Configuration configuration2 = new Configuration();
            configuration2.fontScale = 0.0f;
            f15697f = configuration2;
        }
        return configuration.equals(f15697f);
    }

    public void a(Configuration configuration) {
        if (this.f15702e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f15701d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f15701d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f15702e == null) {
            Configuration configuration = this.f15701d;
            if (configuration == null || (Build.VERSION.SDK_INT >= 26 && d(configuration))) {
                this.f15702e = super.getResources();
            } else {
                this.f15702e = createConfigurationContext(this.f15701d).getResources();
            }
        }
        return this.f15702e;
    }

    public final void c() {
        boolean z10 = this.f15699b == null;
        if (z10) {
            this.f15699b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f15699b.setTo(theme);
            }
        }
        e(this.f15699b, this.f15698a, z10);
    }

    public void e(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
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
        if (this.f15700c == null) {
            this.f15700c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f15700c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f15699b;
        if (theme != null) {
            return theme;
        }
        if (this.f15698a == 0) {
            this.f15698a = h.f9761b;
        }
        c();
        return this.f15699b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f15698a != i10) {
            this.f15698a = i10;
            c();
        }
    }
}
