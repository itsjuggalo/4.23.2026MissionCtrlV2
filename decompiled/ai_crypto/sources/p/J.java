package p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import u.C2739d;
import u.C2740e;

/* JADX INFO: loaded from: classes.dex */
public final class J {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static J f21246i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f21248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u.g f21249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public u.h f21250c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap f21251d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f21252e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21253f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f21254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f21245h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f21247j = new a(6);

    public static class a extends C2740e {
        public a(int i7) {
            super(i7);
        }

        public static int b(int i7, PorterDuff.Mode mode) {
            return ((i7 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter c(int i7, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i7, mode)));
        }

        public PorterDuffColorFilter d(int i7, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i7, mode)), porterDuffColorFilter);
        }
    }

    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        Drawable a(J j7, Context context, int i7);

        boolean b(Context context, int i7, Drawable drawable);

        PorterDuff.Mode c(int i7);

        ColorStateList d(Context context, int i7);

        boolean e(Context context, int i7, Drawable drawable);
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

    public static synchronized J g() {
        try {
            if (f21246i == null) {
                J j7 = new J();
                f21246i = j7;
                o(j7);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f21246i;
    }

    public static synchronized PorterDuffColorFilter k(int i7, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterC;
        a aVar = f21247j;
        porterDuffColorFilterC = aVar.c(i7, mode);
        if (porterDuffColorFilterC == null) {
            porterDuffColorFilterC = new PorterDuffColorFilter(i7, mode);
            aVar.d(i7, mode, porterDuffColorFilterC);
        }
        return porterDuffColorFilterC;
    }

    public static boolean p(Drawable drawable) {
        return (drawable instanceof J0.b) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void u(Drawable drawable, P p7, int[] iArr) {
        int[] state = drawable.getState();
        if (AbstractC2334C.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z7 = p7.f21300d;
        if (z7 || p7.f21299c) {
            drawable.setColorFilter(f(z7 ? p7.f21297a : null, p7.f21299c ? p7.f21298b : f21245h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public final synchronized boolean a(Context context, long j7, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            C2739d c2739d = (C2739d) this.f21251d.get(context);
            if (c2739d == null) {
                c2739d = new C2739d();
                this.f21251d.put(context, c2739d);
            }
            c2739d.i(j7, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i7, ColorStateList colorStateList) {
        if (this.f21248a == null) {
            this.f21248a = new WeakHashMap();
        }
        u.h hVar = (u.h) this.f21248a.get(context);
        if (hVar == null) {
            hVar = new u.h();
            this.f21248a.put(context, hVar);
        }
        hVar.a(i7, colorStateList);
    }

    public final void c(Context context) {
        if (this.f21253f) {
            return;
        }
        this.f21253f = true;
        Drawable drawableI = i(context, l.b.f18274a);
        if (drawableI == null || !p(drawableI)) {
            this.f21253f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable e(Context context, int i7) {
        if (this.f21252e == null) {
            this.f21252e = new TypedValue();
        }
        TypedValue typedValue = this.f21252e;
        context.getResources().getValue(i7, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.f21254g;
        Drawable drawableA = cVar == null ? null : cVar.a(this, context, i7);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    public final synchronized Drawable h(Context context, long j7) {
        C2739d c2739d = (C2739d) this.f21251d.get(context);
        if (c2739d == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c2739d.d(j7);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c2739d.j(j7);
        }
        return null;
    }

    public synchronized Drawable i(Context context, int i7) {
        return j(context, i7, false);
    }

    public synchronized Drawable j(Context context, int i7, boolean z7) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i7);
            if (drawableQ == null) {
                drawableQ = e(context, i7);
            }
            if (drawableQ == null) {
                drawableQ = G.a.getDrawable(context, i7);
            }
            if (drawableQ != null) {
                drawableQ = t(context, i7, z7, drawableQ);
            }
            if (drawableQ != null) {
                AbstractC2334C.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    public synchronized ColorStateList l(Context context, int i7) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i7);
        if (colorStateListM == null) {
            c cVar = this.f21254g;
            colorStateListM = cVar == null ? null : cVar.d(context, i7);
            if (colorStateListM != null) {
                b(context, i7, colorStateListM);
            }
        }
        return colorStateListM;
    }

    public final ColorStateList m(Context context, int i7) {
        u.h hVar;
        WeakHashMap weakHashMap = this.f21248a;
        if (weakHashMap == null || (hVar = (u.h) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.e(i7);
    }

    public PorterDuff.Mode n(int i7) {
        c cVar = this.f21254g;
        if (cVar == null) {
            return null;
        }
        return cVar.c(i7);
    }

    public final Drawable q(Context context, int i7) {
        int next;
        u.g gVar = this.f21249b;
        if (gVar == null || gVar.isEmpty()) {
            return null;
        }
        u.h hVar = this.f21250c;
        if (hVar != null) {
            String str = (String) hVar.e(i7);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f21249b.get(str) == null)) {
                return null;
            }
        } else {
            this.f21250c = new u.h();
        }
        if (this.f21252e == null) {
            this.f21252e = new TypedValue();
        }
        TypedValue typedValue = this.f21252e;
        Resources resources = context.getResources();
        resources.getValue(i7, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i7);
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
                this.f21250c.a(i7, name);
                b bVar = (b) this.f21249b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e7) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e7);
            }
        }
        if (drawableH == null) {
            this.f21250c.a(i7, "appcompat_skip_skip");
        }
        return drawableH;
    }

    public synchronized Drawable r(Context context, b0 b0Var, int i7) {
        try {
            Drawable drawableQ = q(context, i7);
            if (drawableQ == null) {
                drawableQ = b0Var.a(i7);
            }
            if (drawableQ == null) {
                return null;
            }
            return t(context, i7, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(c cVar) {
        this.f21254g = cVar;
    }

    public final Drawable t(Context context, int i7, boolean z7, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i7);
        if (colorStateListL == null) {
            c cVar = this.f21254g;
            if ((cVar == null || !cVar.e(context, i7, drawable)) && !v(context, i7, drawable) && z7) {
                return null;
            }
            return drawable;
        }
        if (AbstractC2334C.a(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableL = J.a.l(drawable);
        J.a.i(drawableL, colorStateListL);
        PorterDuff.Mode modeN = n(i7);
        if (modeN == null) {
            return drawableL;
        }
        J.a.j(drawableL, modeN);
        return drawableL;
    }

    public boolean v(Context context, int i7, Drawable drawable) {
        c cVar = this.f21254g;
        return cVar != null && cVar.b(context, i7, drawable);
    }

    public static void o(J j7) {
    }
}
