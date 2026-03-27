package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: o.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1643i extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1638d f13855a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1642h f13856b;

    public C1643i(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C1638d c1638d = this.f13855a;
        if (c1638d != null) {
            c1638d.b();
        }
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            c1642h.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C1638d c1638d = this.f13855a;
        if (c1638d != null) {
            return c1638d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C1638d c1638d = this.f13855a;
        if (c1638d != null) {
            return c1638d.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            return c1642h.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            return c1642h.d();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f13856b.e() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C1638d c1638d = this.f13855a;
        if (c1638d != null) {
            c1638d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i4) {
        super.setBackgroundResource(i4);
        C1638d c1638d = this.f13855a;
        if (c1638d != null) {
            c1638d.g(i4);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            c1642h.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            c1642h.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i4) {
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            c1642h.g(i4);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            c1642h.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C1638d c1638d = this.f13855a;
        if (c1638d != null) {
            c1638d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C1638d c1638d = this.f13855a;
        if (c1638d != null) {
            c1638d.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            c1642h.h(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C1642h c1642h = this.f13856b;
        if (c1642h != null) {
            c1642h.i(mode);
        }
    }

    public C1643i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C1643i(Context context, AttributeSet attributeSet, int i4) {
        super(X.b(context), attributeSet, i4);
        C1638d c1638d = new C1638d(this);
        this.f13855a = c1638d;
        c1638d.e(attributeSet, i4);
        C1642h c1642h = new C1642h(this);
        this.f13856b = c1642h;
        c1642h.f(attributeSet, i4);
    }
}
