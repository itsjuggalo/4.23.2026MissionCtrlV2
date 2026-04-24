package p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* JADX INFO: renamed from: p.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2352m extends ImageButton {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2343d f21386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2353n f21387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21388c;

    public C2352m(Context context, AttributeSet attributeSet, int i7) {
        super(O.b(context), attributeSet, i7);
        this.f21388c = false;
        N.a(this, getContext());
        C2343d c2343d = new C2343d(this);
        this.f21386a = c2343d;
        c2343d.e(attributeSet, i7);
        C2353n c2353n = new C2353n(this);
        this.f21387b = c2353n;
        c2353n.g(attributeSet, i7);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2343d c2343d = this.f21386a;
        if (c2343d != null) {
            c2343d.b();
        }
        C2353n c2353n = this.f21387b;
        if (c2353n != null) {
            c2353n.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2343d c2343d = this.f21386a;
        if (c2343d != null) {
            return c2343d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2343d c2343d = this.f21386a;
        if (c2343d != null) {
            return c2343d.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C2353n c2353n = this.f21387b;
        if (c2353n != null) {
            return c2353n.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C2353n c2353n = this.f21387b;
        if (c2353n != null) {
            return c2353n.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f21387b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2343d c2343d = this.f21386a;
        if (c2343d != null) {
            c2343d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i7) {
        super.setBackgroundResource(i7);
        C2343d c2343d = this.f21386a;
        if (c2343d != null) {
            c2343d.g(i7);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C2353n c2353n = this.f21387b;
        if (c2353n != null) {
            c2353n.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C2353n c2353n = this.f21387b;
        if (c2353n != null && drawable != null && !this.f21388c) {
            c2353n.h(drawable);
        }
        super.setImageDrawable(drawable);
        C2353n c2353n2 = this.f21387b;
        if (c2353n2 != null) {
            c2353n2.c();
            if (this.f21388c) {
                return;
            }
            this.f21387b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i7) {
        super.setImageLevel(i7);
        this.f21388c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i7) {
        this.f21387b.i(i7);
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C2353n c2353n = this.f21387b;
        if (c2353n != null) {
            c2353n.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2343d c2343d = this.f21386a;
        if (c2343d != null) {
            c2343d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2343d c2343d = this.f21386a;
        if (c2343d != null) {
            c2343d.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C2353n c2353n = this.f21387b;
        if (c2353n != null) {
            c2353n.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C2353n c2353n = this.f21387b;
        if (c2353n != null) {
            c2353n.k(mode);
        }
    }
}
