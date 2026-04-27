package h1;

import U0.l;
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
import h1.C1852g;
import java.nio.ByteBuffer;
import java.util.List;
import q1.AbstractC2628k;

/* JADX INFO: renamed from: h1.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1848c extends Drawable implements C1852g.b, Animatable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f18344a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18345b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f18346c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f18347d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f18348e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18349f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f18350g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f18351h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Paint f18352i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Rect f18353j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f18354k;

    /* JADX INFO: renamed from: h1.c$a */
    public static final class a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C1852g f18355a;

        public a(C1852g c1852g) {
            this.f18355a = c1852g;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C1848c(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public C1848c(Context context, T0.a aVar, l lVar, int i8, int i9, Bitmap bitmap) {
        this(new a(new C1852g(com.bumptech.glide.b.c(context), aVar, i8, i9, lVar, bitmap)));
    }

    @Override // h1.C1852g.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.f18349f++;
        }
        int i8 = this.f18350g;
        if (i8 == -1 || this.f18349f < i8) {
            return;
        }
        j();
        stop();
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
        return this.f18344a.f18355a.b();
    }

    public final Rect d() {
        if (this.f18353j == null) {
            this.f18353j = new Rect();
        }
        return this.f18353j;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f18347d) {
            return;
        }
        if (this.f18351h) {
            Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.f18351h = false;
        }
        canvas.drawBitmap(this.f18344a.f18355a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f18344a.f18355a.e();
    }

    public int f() {
        return this.f18344a.f18355a.f();
    }

    public int g() {
        return this.f18344a.f18355a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f18344a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f18344a.f18355a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f18344a.f18355a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final Paint h() {
        if (this.f18352i == null) {
            this.f18352i = new Paint(2);
        }
        return this.f18352i;
    }

    public int i() {
        return this.f18344a.f18355a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.f18345b;
    }

    public final void j() {
        List list = this.f18354k;
        if (list == null || list.size() <= 0) {
            return;
        }
        android.support.v4.media.session.b.a(this.f18354k.get(0));
        throw null;
    }

    public void k() {
        this.f18347d = true;
        this.f18344a.f18355a.a();
    }

    public final void l() {
        this.f18349f = 0;
    }

    public void m(l lVar, Bitmap bitmap) {
        this.f18344a.f18355a.o(lVar, bitmap);
    }

    public final void n() {
        AbstractC2628k.a(!this.f18347d, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f18344a.f18355a.f() != 1) {
            if (this.f18345b) {
                return;
            }
            this.f18345b = true;
            this.f18344a.f18355a.r(this);
        }
        invalidateSelf();
    }

    public final void o() {
        this.f18345b = false;
        this.f18344a.f18355a.s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f18351h = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        h().setAlpha(i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z7, boolean z8) {
        AbstractC2628k.a(!this.f18347d, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.f18348e = z7;
        if (!z7) {
            o();
        } else if (this.f18346c) {
            n();
        }
        return super.setVisible(z7, z8);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.f18346c = true;
        l();
        if (this.f18348e) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.f18346c = false;
        o();
    }

    public C1848c(a aVar) {
        this.f18348e = true;
        this.f18350g = -1;
        this.f18344a = (a) AbstractC2628k.d(aVar);
    }
}
