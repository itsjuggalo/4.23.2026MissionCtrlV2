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
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c0 f17221i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakHashMap f17223a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public w.i f17224b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public w.j f17225c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap f17226d = new WeakHashMap(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TypedValue f17227e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f17228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f17229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PorterDuff.Mode f17220h = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f17222j = new a(6);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends w.h {
        public a(int i10) {
            super(i10);
        }

        public static int b(int i10, PorterDuff.Mode mode) {
            return ((i10 + 31) * 31) + mode.hashCode();
        }

        public PorterDuffColorFilter c(int i10, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i10, mode)));
        }

        public PorterDuffColorFilter d(int i10, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i10, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        Drawable a(c0 c0Var, Context context, int i10);

        boolean b(Context context, int i10, Drawable drawable);

        PorterDuff.Mode c(int i10);

        ColorStateList d(Context context, int i10);

        boolean e(Context context, int i10, Drawable drawable);
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

    public static synchronized c0 g() {
        try {
            if (f17221i == null) {
                c0 c0Var = new c0();
                f17221i = c0Var;
                o(c0Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f17221i;
    }

    public static synchronized PorterDuffColorFilter k(int i10, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterC;
        a aVar = f17222j;
        porterDuffColorFilterC = aVar.c(i10, mode);
        if (porterDuffColorFilterC == null) {
            porterDuffColorFilterC = new PorterDuffColorFilter(i10, mode);
            aVar.d(i10, mode, porterDuffColorFilterC);
        }
        return porterDuffColorFilterC;
    }

    public static boolean p(Drawable drawable) {
        return (drawable instanceof o2.b) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    public static void u(Drawable drawable, h0 h0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = h0Var.f17275d;
        if (z10 || h0Var.f17274c) {
            drawable.setColorFilter(f(z10 ? h0Var.f17272a : null, h0Var.f17274c ? h0Var.f17273b : f17220h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public final synchronized boolean a(Context context, long j10, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            w.f fVar = (w.f) this.f17226d.get(context);
            if (fVar == null) {
                fVar = new w.f();
                this.f17226d.put(context, fVar);
            }
            fVar.g(j10, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void b(Context context, int i10, ColorStateList colorStateList) {
        if (this.f17223a == null) {
            this.f17223a = new WeakHashMap();
        }
        w.j jVar = (w.j) this.f17223a.get(context);
        if (jVar == null) {
            jVar = new w.j();
            this.f17223a.put(context, jVar);
        }
        jVar.a(i10, colorStateList);
    }

    public final void c(Context context) {
        if (this.f17228f) {
            return;
        }
        this.f17228f = true;
        Drawable drawableI = i(context, k.a.f14424a);
        if (drawableI == null || !p(drawableI)) {
            this.f17228f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    public final Drawable e(Context context, int i10) {
        if (this.f17227e == null) {
            this.f17227e = new TypedValue();
        }
        TypedValue typedValue = this.f17227e;
        context.getResources().getValue(i10, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.f17229g;
        Drawable drawableA = cVar == null ? null : cVar.a(this, context, i10);
        if (drawableA != null) {
            drawableA.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableA);
        }
        return drawableA;
    }

    public final synchronized Drawable h(Context context, long j10) {
        w.f fVar = (w.f) this.f17226d.get(context);
        if (fVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) fVar.c(j10);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            fVar.h(j10);
        }
        return null;
    }

    public synchronized Drawable i(Context context, int i10) {
        return j(context, i10, false);
    }

    public synchronized Drawable j(Context context, int i10, boolean z10) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i10);
            if (drawableQ == null) {
                drawableQ = e(context, i10);
            }
            if (drawableQ == null) {
                drawableQ = i0.a.f(context, i10);
            }
            if (drawableQ != null) {
                drawableQ = t(context, i10, z10, drawableQ);
            }
            if (drawableQ != null) {
                v.a(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    public synchronized ColorStateList l(Context context, int i10) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i10);
        if (colorStateListM == null) {
            c cVar = this.f17229g;
            colorStateListM = cVar == null ? null : cVar.d(context, i10);
            if (colorStateListM != null) {
                b(context, i10, colorStateListM);
            }
        }
        return colorStateListM;
    }

    public final ColorStateList m(Context context, int i10) {
        w.j jVar;
        WeakHashMap weakHashMap = this.f17223a;
        if (weakHashMap == null || (jVar = (w.j) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) jVar.d(i10);
    }

    public PorterDuff.Mode n(int i10) {
        c cVar = this.f17229g;
        if (cVar == null) {
            return null;
        }
        return cVar.c(i10);
    }

    public final Drawable q(Context context, int i10) {
        int next;
        w.i iVar = this.f17224b;
        if (iVar == null || iVar.isEmpty()) {
            return null;
        }
        w.j jVar = this.f17225c;
        if (jVar != null) {
            String str = (String) jVar.d(i10);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f17224b.get(str) == null)) {
                return null;
            }
        } else {
            this.f17225c = new w.j();
        }
        if (this.f17227e == null) {
            this.f17227e = new TypedValue();
        }
        TypedValue typedValue = this.f17227e;
        Resources resources = context.getResources();
        resources.getValue(i10, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i10);
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
                this.f17225c.a(i10, name);
                b bVar = (b) this.f17224b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e10) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e10);
            }
        }
        if (drawableH == null) {
            this.f17225c.a(i10, "appcompat_skip_skip");
        }
        return drawableH;
    }

    public synchronized Drawable r(Context context, s0 s0Var, int i10) {
        try {
            Drawable drawableQ = q(context, i10);
            if (drawableQ == null) {
                drawableQ = s0Var.a(i10);
            }
            if (drawableQ == null) {
                return null;
            }
            return t(context, i10, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void s(c cVar) {
        this.f17229g = cVar;
    }

    public final Drawable t(Context context, int i10, boolean z10, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i10);
        if (colorStateListL != null) {
            Drawable drawableI = m0.a.i(drawable.mutate());
            m0.a.f(drawableI, colorStateListL);
            PorterDuff.Mode modeN = n(i10);
            if (modeN != null) {
                m0.a.g(drawableI, modeN);
            }
            return drawableI;
        }
        c cVar = this.f17229g;
        if ((cVar == null || !cVar.e(context, i10, drawable)) && !v(context, i10, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    public boolean v(Context context, int i10, Drawable drawable) {
        c cVar = this.f17229g;
        return cVar != null && cVar.b(context, i10, drawable);
    }

    public static void o(c0 c0Var) {
    }
}
