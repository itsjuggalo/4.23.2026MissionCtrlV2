package t3;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import c4.k;
import g3.l;
import java.nio.ByteBuffer;
import java.util.List;
import t3.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends Drawable implements g.b, Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f20687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f20688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f20689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f20690d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f20691e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20692f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20693g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f20694h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f20695i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f20696j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f20697k;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f20698a;

        public a(g gVar) {
            this.f20698a = gVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new c(this);
        }
    }

    public c(Context context, f3.a aVar, l lVar, int i10, int i11, Bitmap bitmap) {
        this(new a(new g(com.bumptech.glide.b.c(context), aVar, i10, i11, lVar, bitmap)));
    }

    @Override // t3.g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f20692f++;
        }
        int i10 = this.f20693g;
        if (i10 == -1 || this.f20692f < i10) {
            return;
        }
        stop();
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public ByteBuffer c() {
        return this.f20687a.f20698a.b();
    }

    public final Rect d() {
        if (this.f20696j == null) {
            this.f20696j = new Rect();
        }
        return this.f20696j;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f20690d) {
            return;
        }
        if (this.f20694h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f20694h = false;
        }
        canvas.drawBitmap(this.f20687a.f20698a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f20687a.f20698a.e();
    }

    public int f() {
        return this.f20687a.f20698a.f();
    }

    public int g() {
        return this.f20687a.f20698a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f20687a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f20687a.f20698a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f20687a.f20698a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final Paint h() {
        if (this.f20695i == null) {
            this.f20695i = new Paint(2);
        }
        return this.f20695i;
    }

    public int i() {
        return this.f20687a.f20698a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f20688b;
    }

    public final void j() {
        List list = this.f20697k;
        if (list == null || list.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f20697k.get(0));
        throw null;
    }

    public void k() {
        this.f20690d = true;
        this.f20687a.f20698a.a();
    }

    public final void l() {
        this.f20692f = 0;
    }

    public void m(l lVar, Bitmap bitmap) {
        this.f20687a.f20698a.o(lVar, bitmap);
    }

    public final void n() {
        k.b(!this.f20690d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f20687a.f20698a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.f20688b) {
                return;
            }
            this.f20688b = true;
            this.f20687a.f20698a.r(this);
            invalidateSelf();
        }
    }

    public final void o() {
        this.f20688b = false;
        this.f20687a.f20698a.s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f20694h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        h().setAlpha(i10);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        k.b(!this.f20690d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f20691e = z10;
        if (!z10) {
            o();
        } else if (this.f20689c) {
            n();
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f20689c = true;
        l();
        if (this.f20691e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f20689c = false;
        o();
    }

    public c(a aVar) {
        this.f20691e = true;
        this.f20693g = -1;
        this.f20687a = (a) k.e(aVar);
    }
}
