package k;

import D.AbstractC0005e;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import java.lang.reflect.Constructor;
import l.j;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public CharSequence f7782A;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final /* synthetic */ d f7785D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Menu f7786a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7792h;
    public int i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CharSequence f7794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public CharSequence f7795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f7796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public char f7797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f7798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public char f7799p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7800q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f7801r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7802s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f7803t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f7804u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7805v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7806w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f7807x;
    public String y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public CharSequence f7808z;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public ColorStateList f7783B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public PorterDuff.Mode f7784C = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7787b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7788c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7789d = 0;
    public int e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7790f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7791g = true;

    public c(d dVar, Menu menu) {
        this.f7785D = dVar;
        this.f7786a = menu;
    }

    public final Object a(String str, Class[] clsArr, Object[] objArr) {
        try {
            Constructor<?> constructor = Class.forName(str, false, this.f7785D.f7812c.getClassLoader()).getConstructor(clsArr);
            constructor.setAccessible(true);
            return constructor.newInstance(objArr);
        } catch (Exception e) {
            Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
            return null;
        }
    }

    public final void b(MenuItem menuItem) {
        boolean z6 = false;
        menuItem.setChecked(this.f7802s).setVisible(this.f7803t).setEnabled(this.f7804u).setCheckable(this.f7801r >= 1).setTitleCondensed(this.f7795l).setIcon(this.f7796m);
        int i = this.f7805v;
        if (i >= 0) {
            menuItem.setShowAsAction(i);
        }
        String str = this.y;
        d dVar = this.f7785D;
        if (str != null) {
            if (dVar.f7812c.isRestricted()) {
                throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            }
            if (dVar.f7813d == null) {
                dVar.f7813d = d.a(dVar.f7812c);
            }
            Object obj = dVar.f7813d;
            String str2 = this.y;
            b bVar = new b();
            bVar.f7780a = obj;
            Class<?> cls = obj.getClass();
            try {
                bVar.f7781b = cls.getMethod(str2, b.f7779c);
                menuItem.setOnMenuItemClickListener(bVar);
            } catch (Exception e) {
                StringBuilder sbP = a3.d.p("Couldn't resolve menu item onClick handler ", str2, " in class ");
                sbP.append(cls.getName());
                InflateException inflateException = new InflateException(sbP.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }
        if (this.f7801r >= 2 && (menuItem instanceof j)) {
            j jVar = (j) menuItem;
            jVar.f8023x = (jVar.f8023x & (-5)) | 4;
        }
        String str3 = this.f7807x;
        if (str3 != null) {
            menuItem.setActionView((View) a(str3, d.e, dVar.f7810a));
            z6 = true;
        }
        int i6 = this.f7806w;
        if (i6 > 0) {
            if (z6) {
                Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            } else {
                menuItem.setActionView(i6);
            }
        }
        CharSequence charSequence = this.f7808z;
        boolean z7 = menuItem instanceof j;
        if (z7) {
            ((j) menuItem).c(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0005e.h(menuItem, charSequence);
        }
        CharSequence charSequence2 = this.f7782A;
        if (z7) {
            ((j) menuItem).e(charSequence2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0005e.m(menuItem, charSequence2);
        }
        char c6 = this.f7797n;
        int i7 = this.f7798o;
        if (z7) {
            ((j) menuItem).setAlphabeticShortcut(c6, i7);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0005e.g(menuItem, c6, i7);
        }
        char c7 = this.f7799p;
        int i8 = this.f7800q;
        if (z7) {
            ((j) menuItem).setNumericShortcut(c7, i8);
        } else if (Build.VERSION.SDK_INT >= 26) {
            AbstractC0005e.k(menuItem, c7, i8);
        }
        PorterDuff.Mode mode = this.f7784C;
        if (mode != null) {
            if (z7) {
                ((j) menuItem).setIconTintMode(mode);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC0005e.j(menuItem, mode);
            }
        }
        ColorStateList colorStateList = this.f7783B;
        if (colorStateList != null) {
            if (z7) {
                ((j) menuItem).setIconTintList(colorStateList);
            } else if (Build.VERSION.SDK_INT >= 26) {
                AbstractC0005e.i(menuItem, colorStateList);
            }
        }
    }
}
