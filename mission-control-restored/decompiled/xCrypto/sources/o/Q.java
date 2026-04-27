package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import k.AbstractC1565a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import u.C1853a;
import u.C1856d;
import u.C1857e;
import u.C1860h;
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public final class Q {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Q f13738i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f13740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C1853a f13741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C1860h f13742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap f13743d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f13744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f13746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f13737h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f13739j = new a(6);

    public static class a extends C1857e {
        public a(int i4) {
            super(i4);
        }

        public static int b(int i4, PorterDuff.Mode mode) {
            return ((i4 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter c(int i4, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i4, mode)));
        }

        public PorterDuffColorFilter d(int i4, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i4, mode)), porterDuffColorFilter);
        }
    }

    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        Drawable a(Q q4, Context context, int i4);

        boolean b(Context context, int i4, Drawable drawable);

        PorterDuff.Mode c(int i4);

        ColorStateList d(Context context, int i4);

        boolean e(Context context, int i4, Drawable drawable);
    }

    public static long d(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    public static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized Q g() {
        try {
            if (f13738i == null) {
                Q q4 = new Q();
                f13738i = q4;
                o(q4);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f13738i;
    }

    public static synchronized PorterDuffColorFilter k(int i4, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterC;
        a aVar = f13739j;
        porterDuffColorFilterC = aVar.c(i4, mode);
        if (porterDuffColorFilterC == null) {
            porterDuffColorFilterC = new PorterDuffColorFilter(i4, mode);
            aVar.d(i4, mode, porterDuffColorFilterC);
        }
        return porterDuffColorFilterC;
    }

    public static boolean p(Drawable drawable) {
        return (drawable instanceof s0.b) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void u(Drawable drawable, Y y4, int[] iArr) {
        if (G.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        boolean z4 = y4.f13793d;
        if (z4 || y4.f13792c) {
            drawable.setColorFilter(f(z4 ? y4.f13790a : null, y4.f13792c ? y4.f13791b : f13737h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public final synchronized boolean a(Context context, long j4, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            C1856d c1856d = (C1856d) this.f13743d.get(context);
            if (c1856d == null) {
                c1856d = new C1856d();
                this.f13743d.put(context, c1856d);
            }
            c1856d.i(j4, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i4, ColorStateList colorStateList) {
        if (this.f13740a == null) {
            this.f13740a = new WeakHashMap();
        }
        C1860h c1860h = (C1860h) this.f13740a.get(context);
        if (c1860h == null) {
            c1860h = new C1860h();
            this.f13740a.put(context, c1860h);
        }
        c1860h.a(i4, colorStateList);
    }

    public final void c(Context context) {
        if (this.f13745f) {
            return;
        }
        this.f13745f = true;
        Drawable drawableI = i(context, AbstractC1565a.f13384a);
        if (drawableI == null || !p(drawableI)) {
            this.f13745f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable e(Context context, int i4) {
        if (this.f13744e == null) {
            this.f13744e = new TypedValue();
        }
        TypedValue typedValue = this.f13744e;
        context.getResources().getValue(i4, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.f13746g;
        Drawable drawableA = cVar == null ? null : cVar.a(this, context, i4);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    public final synchronized Drawable h(Context context, long j4) {
        C1856d c1856d = (C1856d) this.f13743d.get(context);
        if (c1856d == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c1856d.e(j4);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c1856d.c(j4);
        }
        return null;
    }

    public synchronized Drawable i(Context context, int i4) {
        return j(context, i4, false);
    }

    public synchronized Drawable j(Context context, int i4, boolean z4) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i4);
            if (drawableQ == null) {
                drawableQ = e(context, i4);
            }
            if (drawableQ == null) {
                drawableQ = AbstractC1909a.getDrawable(context, i4);
            }
            if (drawableQ != null) {
                drawableQ = t(context, i4, z4, drawableQ);
            }
            if (drawableQ != null) {
                G.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    public synchronized ColorStateList l(Context context, int i4) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i4);
        if (colorStateListM == null) {
            c cVar = this.f13746g;
            colorStateListM = cVar == null ? null : cVar.d(context, i4);
            if (colorStateListM != null) {
                b(context, i4, colorStateListM);
            }
        }
        return colorStateListM;
    }

    public final ColorStateList m(Context context, int i4) {
        C1860h c1860h;
        WeakHashMap weakHashMap = this.f13740a;
        if (weakHashMap == null || (c1860h = (C1860h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) c1860h.e(i4);
    }

    public PorterDuff.Mode n(int i4) {
        c cVar = this.f13746g;
        if (cVar == null) {
            return null;
        }
        return cVar.c(i4);
    }

    public final Drawable q(Context context, int i4) {
        int next;
        C1853a c1853a = this.f13741b;
        if (c1853a == null || c1853a.isEmpty()) {
            return null;
        }
        C1860h c1860h = this.f13742c;
        if (c1860h != null) {
            String str = (String) c1860h.e(i4);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f13741b.get(str) == null)) {
                return null;
            }
        } else {
            this.f13742c = new C1860h();
        }
        if (this.f13744e == null) {
            this.f13744e = new TypedValue();
        }
        TypedValue typedValue = this.f13744e;
        Resources resources = context.getResources();
        resources.getValue(i4, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i4);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f13742c.a(i4, name);
                b bVar = (b) this.f13741b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e4) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e4);
            }
        }
        if (drawableH == null) {
            this.f13742c.a(i4, "appcompat_skip_skip");
        }
        return drawableH;
    }

    public synchronized Drawable r(Context context, f0 f0Var, int i4) {
        try {
            Drawable drawableQ = q(context, i4);
            if (drawableQ == null) {
                drawableQ = f0Var.c(i4);
            }
            if (drawableQ == null) {
                return null;
            }
            return t(context, i4, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(c cVar) {
        this.f13746g = cVar;
    }

    public final Drawable t(Context context, int i4, boolean z4, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i4);
        if (colorStateListL == null) {
            c cVar = this.f13746g;
            if ((cVar == null || !cVar.e(context, i4, drawable)) && !v(context, i4, drawable) && z4) {
                return null;
            }
            return drawable;
        }
        if (G.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableJ = A.a.j(drawable);
        A.a.g(drawableJ, colorStateListL);
        PorterDuff.Mode modeN = n(i4);
        if (modeN != null) {
            A.a.h(drawableJ, modeN);
        }
        return drawableJ;
    }

    public boolean v(Context context, int i4, Drawable drawable) {
        c cVar = this.f13746g;
        return cVar != null && cVar.b(context, i4, drawable);
    }

    public static void o(Q q4) {
    }
}
