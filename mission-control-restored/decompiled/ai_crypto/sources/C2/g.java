package C2;

import C2.k;
import C2.l;
import C2.m;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import java.util.BitSet;
import n2.AbstractC2252a;
import t2.AbstractC2655b;
import w2.C2774a;

/* JADX INFO: loaded from: classes.dex */
public class g extends Drawable implements n {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final String f909x = "g";

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Paint f910y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m.g[] f912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m.g[] f913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BitSet f914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Matrix f916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final RectF f919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final RectF f920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Region f921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Region f922l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public k f923m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Paint f924n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Paint f925o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final B2.a f926p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final l.b f927q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final l f928r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public PorterDuffColorFilter f929s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public PorterDuffColorFilter f930t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f931u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final RectF f932v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f933w;

    public class a implements l.b {
        public a() {
        }

        @Override // C2.l.b
        public void a(m mVar, Matrix matrix, int i7) {
            g.this.f914d.set(i7, mVar.e());
            g.this.f912b[i7] = mVar.f(matrix);
        }

        @Override // C2.l.b
        public void b(m mVar, Matrix matrix, int i7) {
            g.this.f914d.set(i7 + 4, mVar.e());
            g.this.f913c[i7] = mVar.f(matrix);
        }
    }

    public class b implements k.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f935a;

        public b(float f7) {
            this.f935a = f7;
        }

        @Override // C2.k.c
        public C2.c a(C2.c cVar) {
            return cVar instanceof i ? cVar : new C2.b(this.f935a, cVar);
        }
    }

    static {
        Paint paint = new Paint(1);
        f910y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public /* synthetic */ g(c cVar, a aVar) {
        this(cVar);
    }

    public static int P(int i7, int i8) {
        return (i7 * (i8 + (i8 >>> 7))) >>> 8;
    }

    public static g m(Context context, float f7) {
        int iC = AbstractC2655b.c(context, AbstractC2252a.f19103g, g.class.getSimpleName());
        g gVar = new g();
        gVar.K(context);
        gVar.U(ColorStateList.valueOf(iC));
        gVar.T(f7);
        return gVar;
    }

    public int A() {
        return (int) (((double) this.f911a.f955s) * Math.cos(Math.toRadians(r0.f956t)));
    }

    public k B() {
        return this.f911a.f937a;
    }

    public final float C() {
        if (J()) {
            return this.f925o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    public float D() {
        return this.f911a.f937a.r().a(u());
    }

    public float E() {
        return this.f911a.f937a.t().a(u());
    }

    public float F() {
        return this.f911a.f952p;
    }

    public float G() {
        return w() + F();
    }

    public final boolean H() {
        c cVar = this.f911a;
        int i7 = cVar.f953q;
        return i7 != 1 && cVar.f954r > 0 && (i7 == 2 || R());
    }

    public final boolean I() {
        Paint.Style style = this.f911a.f958v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    public final boolean J() {
        Paint.Style style = this.f911a.f958v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f925o.getStrokeWidth() > 0.0f;
    }

    public void K(Context context) {
        this.f911a.f938b = new C2774a(context);
        e0();
    }

    public final void L() {
        super.invalidateSelf();
    }

    public boolean M() {
        C2774a c2774a = this.f911a.f938b;
        return c2774a != null && c2774a.d();
    }

    public boolean N() {
        return this.f911a.f937a.u(u());
    }

    public final void O(Canvas canvas) {
        if (H()) {
            canvas.save();
            Q(canvas);
            if (!this.f933w) {
                n(canvas);
                canvas.restore();
                return;
            }
            int iWidth = (int) (this.f932v.width() - getBounds().width());
            int iHeight = (int) (this.f932v.height() - getBounds().height());
            if (iWidth < 0 || iHeight < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(((int) this.f932v.width()) + (this.f911a.f954r * 2) + iWidth, ((int) this.f932v.height()) + (this.f911a.f954r * 2) + iHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap);
            float f7 = (getBounds().left - this.f911a.f954r) - iWidth;
            float f8 = (getBounds().top - this.f911a.f954r) - iHeight;
            canvas2.translate(-f7, -f8);
            n(canvas2);
            canvas.drawBitmap(bitmapCreateBitmap, f7, f8, (Paint) null);
            bitmapCreateBitmap.recycle();
            canvas.restore();
        }
    }

    public final void Q(Canvas canvas) {
        canvas.translate(z(), A());
    }

    public boolean R() {
        return (N() || this.f917g.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void S(C2.c cVar) {
        setShapeAppearanceModel(this.f911a.f937a.x(cVar));
    }

    public void T(float f7) {
        c cVar = this.f911a;
        if (cVar.f951o != f7) {
            cVar.f951o = f7;
            e0();
        }
    }

    public void U(ColorStateList colorStateList) {
        c cVar = this.f911a;
        if (cVar.f940d != colorStateList) {
            cVar.f940d = colorStateList;
            onStateChange(getState());
        }
    }

    public void V(float f7) {
        c cVar = this.f911a;
        if (cVar.f947k != f7) {
            cVar.f947k = f7;
            this.f915e = true;
            invalidateSelf();
        }
    }

    public void W(int i7, int i8, int i9, int i10) {
        c cVar = this.f911a;
        if (cVar.f945i == null) {
            cVar.f945i = new Rect();
        }
        this.f911a.f945i.set(i7, i8, i9, i10);
        invalidateSelf();
    }

    public void X(float f7) {
        c cVar = this.f911a;
        if (cVar.f950n != f7) {
            cVar.f950n = f7;
            e0();
        }
    }

    public void Y(float f7, int i7) {
        b0(f7);
        a0(ColorStateList.valueOf(i7));
    }

    public void Z(float f7, ColorStateList colorStateList) {
        b0(f7);
        a0(colorStateList);
    }

    public void a0(ColorStateList colorStateList) {
        c cVar = this.f911a;
        if (cVar.f941e != colorStateList) {
            cVar.f941e = colorStateList;
            onStateChange(getState());
        }
    }

    public void b0(float f7) {
        this.f911a.f948l = f7;
        invalidateSelf();
    }

    public final boolean c0(int[] iArr) {
        boolean z7;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f911a.f940d == null || color2 == (colorForState2 = this.f911a.f940d.getColorForState(iArr, (color2 = this.f924n.getColor())))) {
            z7 = false;
        } else {
            this.f924n.setColor(colorForState2);
            z7 = true;
        }
        if (this.f911a.f941e == null || color == (colorForState = this.f911a.f941e.getColorForState(iArr, (color = this.f925o.getColor())))) {
            return z7;
        }
        this.f925o.setColor(colorForState);
        return true;
    }

    public final boolean d0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f929s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f930t;
        c cVar = this.f911a;
        this.f929s = k(cVar.f943g, cVar.f944h, this.f924n, true);
        c cVar2 = this.f911a;
        this.f930t = k(cVar2.f942f, cVar2.f944h, this.f925o, false);
        c cVar3 = this.f911a;
        if (cVar3.f957u) {
            this.f926p.d(cVar3.f943g.getColorForState(getState(), 0));
        }
        return (P.b.a(porterDuffColorFilter, this.f929s) && P.b.a(porterDuffColorFilter2, this.f930t)) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f924n.setColorFilter(this.f929s);
        int alpha = this.f924n.getAlpha();
        this.f924n.setAlpha(P(alpha, this.f911a.f949m));
        this.f925o.setColorFilter(this.f930t);
        this.f925o.setStrokeWidth(this.f911a.f948l);
        int alpha2 = this.f925o.getAlpha();
        this.f925o.setAlpha(P(alpha2, this.f911a.f949m));
        if (this.f915e) {
            i();
            g(u(), this.f917g);
            this.f915e = false;
        }
        O(canvas);
        if (I()) {
            o(canvas);
        }
        if (J()) {
            r(canvas);
        }
        this.f924n.setAlpha(alpha);
        this.f925o.setAlpha(alpha2);
    }

    public final void e0() {
        float fG = G();
        this.f911a.f954r = (int) Math.ceil(0.75f * fG);
        this.f911a.f955s = (int) Math.ceil(fG * 0.25f);
        d0();
        L();
    }

    public final PorterDuffColorFilter f(Paint paint, boolean z7) {
        if (!z7) {
            return null;
        }
        int color = paint.getColor();
        int iL = l(color);
        this.f931u = iL;
        if (iL != color) {
            return new PorterDuffColorFilter(iL, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    public final void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f911a.f946j != 1.0f) {
            this.f916f.reset();
            Matrix matrix = this.f916f;
            float f7 = this.f911a.f946j;
            matrix.setScale(f7, f7, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f916f);
        }
        path.computeBounds(this.f932v, true);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f911a.f949m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f911a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f911a.f953q == 2) {
            return;
        }
        if (N()) {
            outline.setRoundRect(getBounds(), D() * this.f911a.f947k);
            return;
        }
        g(u(), this.f917g);
        if (this.f917g.isConvex() || Build.VERSION.SDK_INT >= 29) {
            try {
                outline.setConvexPath(this.f917g);
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f911a.f945i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f921k.set(getBounds());
        g(u(), this.f917g);
        this.f922l.setPath(this.f917g, this.f921k);
        this.f921k.op(this.f922l, Region.Op.DIFFERENCE);
        return this.f921k;
    }

    public final void h(RectF rectF, Path path) {
        l lVar = this.f928r;
        c cVar = this.f911a;
        lVar.d(cVar.f937a, cVar.f947k, rectF, this.f927q, path);
    }

    public final void i() {
        k kVarY = B().y(new b(-C()));
        this.f923m = kVarY;
        this.f928r.e(kVarY, this.f911a.f947k, v(), this.f918h);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f915e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f911a.f943g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f911a.f942f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f911a.f941e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f911a.f940d) != null && colorStateList4.isStateful())));
    }

    public final PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z7) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z7) {
            colorForState = l(colorForState);
        }
        this.f931u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    public final PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z7) {
        return (colorStateList == null || mode == null) ? f(paint, z7) : j(colorStateList, mode, z7);
    }

    public int l(int i7) {
        float fG = G() + y();
        C2774a c2774a = this.f911a.f938b;
        return c2774a != null ? c2774a.c(i7, fG) : i7;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f911a = new c(this.f911a);
        return this;
    }

    public final void n(Canvas canvas) {
        if (this.f914d.cardinality() > 0) {
            Log.w(f909x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f911a.f955s != 0) {
            canvas.drawPath(this.f917g, this.f926p.c());
        }
        for (int i7 = 0; i7 < 4; i7++) {
            this.f912b[i7].a(this.f926p, this.f911a.f954r, canvas);
            this.f913c[i7].a(this.f926p, this.f911a.f954r, canvas);
        }
        if (this.f933w) {
            int iZ = z();
            int iA = A();
            canvas.translate(-iZ, -iA);
            canvas.drawPath(this.f917g, f910y);
            canvas.translate(iZ, iA);
        }
    }

    public final void o(Canvas canvas) {
        p(canvas, this.f924n, this.f917g, this.f911a.f937a, u());
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f915e = true;
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z7 = c0(iArr) || d0();
        if (z7) {
            invalidateSelf();
        }
        return z7;
    }

    public final void p(Canvas canvas, Paint paint, Path path, k kVar, RectF rectF) {
        if (!kVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float fA = kVar.t().a(rectF) * this.f911a.f947k;
            canvas.drawRoundRect(rectF, fA, fA, paint);
        }
    }

    public void q(Canvas canvas, Paint paint, Path path, RectF rectF) {
        p(canvas, paint, path, this.f911a.f937a, rectF);
    }

    public void r(Canvas canvas) {
        p(canvas, this.f925o, this.f918h, this.f923m, v());
    }

    public float s() {
        return this.f911a.f937a.j().a(u());
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i7) {
        c cVar = this.f911a;
        if (cVar.f949m != i7) {
            cVar.f949m = i7;
            L();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f911a.f939c = colorFilter;
        L();
    }

    @Override // C2.n
    public void setShapeAppearanceModel(k kVar) {
        this.f911a.f937a = kVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i7) {
        setTintList(ColorStateList.valueOf(i7));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f911a.f943g = colorStateList;
        d0();
        L();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f911a;
        if (cVar.f944h != mode) {
            cVar.f944h = mode;
            d0();
            L();
        }
    }

    public float t() {
        return this.f911a.f937a.l().a(u());
    }

    public RectF u() {
        this.f919i.set(getBounds());
        return this.f919i;
    }

    public final RectF v() {
        this.f920j.set(u());
        float fC = C();
        this.f920j.inset(fC, fC);
        return this.f920j;
    }

    public float w() {
        return this.f911a.f951o;
    }

    public ColorStateList x() {
        return this.f911a.f940d;
    }

    public float y() {
        return this.f911a.f950n;
    }

    public int z() {
        return (int) (((double) this.f911a.f955s) * Math.sin(Math.toRadians(r0.f956t)));
    }

    public g() {
        this(new k());
    }

    public g(Context context, AttributeSet attributeSet, int i7, int i8) {
        this(k.e(context, attributeSet, i7, i8).m());
    }

    public g(k kVar) {
        this(new c(kVar, null));
    }

    public g(c cVar) {
        l lVar;
        this.f912b = new m.g[4];
        this.f913c = new m.g[4];
        this.f914d = new BitSet(8);
        this.f916f = new Matrix();
        this.f917g = new Path();
        this.f918h = new Path();
        this.f919i = new RectF();
        this.f920j = new RectF();
        this.f921k = new Region();
        this.f922l = new Region();
        Paint paint = new Paint(1);
        this.f924n = paint;
        Paint paint2 = new Paint(1);
        this.f925o = paint2;
        this.f926p = new B2.a();
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            lVar = l.k();
        } else {
            lVar = new l();
        }
        this.f928r = lVar;
        this.f932v = new RectF();
        this.f933w = true;
        this.f911a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        d0();
        c0(getState());
        this.f927q = new a();
    }

    public static final class c extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public k f937a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C2774a f938b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ColorFilter f939c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ColorStateList f940d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ColorStateList f941e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public ColorStateList f942f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ColorStateList f943g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public PorterDuff.Mode f944h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Rect f945i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public float f946j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public float f947k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f948l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f949m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f950n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f951o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public float f952p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f953q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f954r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f955s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f956t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public boolean f957u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Paint.Style f958v;

        public c(k kVar, C2774a c2774a) {
            this.f940d = null;
            this.f941e = null;
            this.f942f = null;
            this.f943g = null;
            this.f944h = PorterDuff.Mode.SRC_IN;
            this.f945i = null;
            this.f946j = 1.0f;
            this.f947k = 1.0f;
            this.f949m = 255;
            this.f950n = 0.0f;
            this.f951o = 0.0f;
            this.f952p = 0.0f;
            this.f953q = 0;
            this.f954r = 0;
            this.f955s = 0;
            this.f956t = 0;
            this.f957u = false;
            this.f958v = Paint.Style.FILL_AND_STROKE;
            this.f937a = kVar;
            this.f938b = c2774a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            g gVar = new g(this, null);
            gVar.f915e = true;
            return gVar;
        }

        public c(c cVar) {
            this.f940d = null;
            this.f941e = null;
            this.f942f = null;
            this.f943g = null;
            this.f944h = PorterDuff.Mode.SRC_IN;
            this.f945i = null;
            this.f946j = 1.0f;
            this.f947k = 1.0f;
            this.f949m = 255;
            this.f950n = 0.0f;
            this.f951o = 0.0f;
            this.f952p = 0.0f;
            this.f953q = 0;
            this.f954r = 0;
            this.f955s = 0;
            this.f956t = 0;
            this.f957u = false;
            this.f958v = Paint.Style.FILL_AND_STROKE;
            this.f937a = cVar.f937a;
            this.f938b = cVar.f938b;
            this.f948l = cVar.f948l;
            this.f939c = cVar.f939c;
            this.f940d = cVar.f940d;
            this.f941e = cVar.f941e;
            this.f944h = cVar.f944h;
            this.f943g = cVar.f943g;
            this.f949m = cVar.f949m;
            this.f946j = cVar.f946j;
            this.f955s = cVar.f955s;
            this.f953q = cVar.f953q;
            this.f957u = cVar.f957u;
            this.f947k = cVar.f947k;
            this.f950n = cVar.f950n;
            this.f951o = cVar.f951o;
            this.f952p = cVar.f952p;
            this.f954r = cVar.f954r;
            this.f956t = cVar.f956t;
            this.f942f = cVar.f942f;
            this.f958v = cVar.f958v;
            if (cVar.f945i != null) {
                this.f945i = new Rect(cVar.f945i);
            }
        }
    }
}
