package o;

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
import k.AbstractC2263a;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static E f21737i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f21739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w.i f21740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w.j f21741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap f21742d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f21743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f21744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f21745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f21736h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f21738j = new a(6);

    public static class a extends w.h {
        public a(int i8) {
            super(i8);
        }

        public static int b(int i8, PorterDuff.Mode mode) {
            return ((i8 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter c(int i8, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i8, mode)));
        }

        public PorterDuffColorFilter d(int i8, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i8, mode)), porterDuffColorFilter);
        }
    }

    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        Drawable a(E e8, Context context, int i8);

        boolean b(Context context, int i8, Drawable drawable);

        PorterDuff.Mode c(int i8);

        ColorStateList d(Context context, int i8);

        boolean e(Context context, int i8, Drawable drawable);
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

    public static synchronized E g() {
        try {
            if (f21737i == null) {
                E e8 = new E();
                f21737i = e8;
                o(e8);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f21737i;
    }

    public static synchronized PorterDuffColorFilter k(int i8, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterC;
        a aVar = f21738j;
        porterDuffColorFilterC = aVar.c(i8, mode);
        if (porterDuffColorFilterC == null) {
            porterDuffColorFilterC = new PorterDuffColorFilter(i8, mode);
            aVar.d(i8, mode, porterDuffColorFilterC);
        }
        return porterDuffColorFilterC;
    }

    public static boolean p(Drawable drawable) {
        return (drawable instanceof D0.b) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void u(Drawable drawable, J j8, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z7 = j8.f21772d;
        if (z7 || j8.f21771c) {
            drawable.setColorFilter(f(z7 ? j8.f21769a : null, j8.f21771c ? j8.f21770b : f21736h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public final synchronized boolean a(Context context, long j8, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            w.f fVar = (w.f) this.f21742d.get(context);
            if (fVar == null) {
                fVar = new w.f();
                this.f21742d.put(context, fVar);
            }
            fVar.h(j8, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i8, ColorStateList colorStateList) {
        if (this.f21739a == null) {
            this.f21739a = new WeakHashMap();
        }
        w.j jVar = (w.j) this.f21739a.get(context);
        if (jVar == null) {
            jVar = new w.j();
            this.f21739a.put(context, jVar);
        }
        jVar.b(i8, colorStateList);
    }

    public final void c(Context context) {
        if (this.f21744f) {
            return;
        }
        this.f21744f = true;
        Drawable drawableI = i(context, AbstractC2263a.f20240a);
        if (drawableI == null || !p(drawableI)) {
            this.f21744f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable e(Context context, int i8) {
        if (this.f21743e == null) {
            this.f21743e = new TypedValue();
        }
        TypedValue typedValue = this.f21743e;
        context.getResources().getValue(i8, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.f21745g;
        Drawable drawableA = cVar == null ? null : cVar.a(this, context, i8);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    public final synchronized Drawable h(Context context, long j8) {
        w.f fVar = (w.f) this.f21742d.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) fVar.d(j8);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.i(j8);
        }
        return null;
    }

    public synchronized Drawable i(Context context, int i8) {
        return j(context, i8, false);
    }

    public synchronized Drawable j(Context context, int i8, boolean z7) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i8);
            if (drawableQ == null) {
                drawableQ = e(context, i8);
            }
            if (drawableQ == null) {
                drawableQ = I.a.e(context, i8);
            }
            if (drawableQ != null) {
                drawableQ = t(context, i8, z7, drawableQ);
            }
            if (drawableQ != null) {
                x.a(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    public synchronized ColorStateList l(Context context, int i8) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i8);
        if (colorStateListM == null) {
            c cVar = this.f21745g;
            colorStateListM = cVar == null ? null : cVar.d(context, i8);
            if (colorStateListM != null) {
                b(context, i8, colorStateListM);
            }
        }
        return colorStateListM;
    }

    public final ColorStateList m(Context context, int i8) {
        w.j jVar;
        WeakHashMap weakHashMap = this.f21739a;
        if (weakHashMap == null || (jVar = (w.j) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) jVar.e(i8);
    }

    public PorterDuff.Mode n(int i8) {
        c cVar = this.f21745g;
        if (cVar == null) {
            return null;
        }
        return cVar.c(i8);
    }

    public final Drawable q(Context context, int i8) {
        int next;
        w.i iVar = this.f21740b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        w.j jVar = this.f21741c;
        if (jVar != null) {
            String str = (String) jVar.e(i8);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f21740b.get(str) == null)) {
                return null;
            }
        } else {
            this.f21741c = new w.j();
        }
        if (this.f21743e == null) {
            this.f21743e = new TypedValue();
        }
        TypedValue typedValue = this.f21743e;
        Resources resources = context.getResources();
        resources.getValue(i8, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i8);
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
                this.f21741c.b(i8, name);
                b bVar = (b) this.f21740b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e8) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e8);
            }
        }
        if (drawableH == null) {
            this.f21741c.b(i8, "appcompat_skip_skip");
        }
        return drawableH;
    }

    public synchronized Drawable r(Context context, V v8, int i8) {
        try {
            Drawable drawableQ = q(context, i8);
            if (drawableQ == null) {
                drawableQ = v8.a(i8);
            }
            if (drawableQ == null) {
                return null;
            }
            return t(context, i8, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(c cVar) {
        this.f21745g = cVar;
    }

    public final Drawable t(Context context, int i8, boolean z7, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i8);
        if (colorStateListL != null) {
            Drawable drawableI = M.a.i(drawable.mutate());
            M.a.f(drawableI, colorStateListL);
            PorterDuff.Mode modeN = n(i8);
            if (modeN == null) {
                return drawableI;
            }
            M.a.g(drawableI, modeN);
            return drawableI;
        }
        c cVar = this.f21745g;
        if ((cVar == null || !cVar.e(context, i8, drawable)) && !v(context, i8, drawable) && z7) {
            return null;
        }
        return drawable;
    }

    public boolean v(Context context, int i8, Drawable drawable) {
        c cVar = this.f21745g;
        return cVar != null && cVar.b(context, i8, drawable);
    }

    public static void o(E e8) {
    }
}
