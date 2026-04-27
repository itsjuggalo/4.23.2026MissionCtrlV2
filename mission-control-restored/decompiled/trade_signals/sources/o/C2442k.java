package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: o.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2442k extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2435d f21845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C2441j f21846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f21847c;

    public C2442k(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        C2435d c2435d = this.f21845a;
        if (c2435d != null) {
            c2435d.b();
        }
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            c2441j.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C2435d c2435d = this.f21845a;
        if (c2435d != null) {
            return c2435d.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C2435d c2435d = this.f21845a;
        if (c2435d != null) {
            return c2435d.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            return c2441j.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            return c2441j.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f21846b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C2435d c2435d = this.f21845a;
        if (c2435d != null) {
            c2435d.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i8) {
        super.setBackgroundResource(i8);
        C2435d c2435d = this.f21845a;
        if (c2435d != null) {
            c2435d.g(i8);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            c2441j.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C2441j c2441j = this.f21846b;
        if (c2441j != null && drawable != null && !this.f21847c) {
            c2441j.h(drawable);
        }
        super.setImageDrawable(drawable);
        C2441j c2441j2 = this.f21846b;
        if (c2441j2 != null) {
            c2441j2.c();
            if (this.f21847c) {
                return;
            }
            this.f21846b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i8) {
        super.setImageLevel(i8);
        this.f21847c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i8) {
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            c2441j.i(i8);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            c2441j.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C2435d c2435d = this.f21845a;
        if (c2435d != null) {
            c2435d.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C2435d c2435d = this.f21845a;
        if (c2435d != null) {
            c2435d.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            c2441j.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C2441j c2441j = this.f21846b;
        if (c2441j != null) {
            c2441j.k(mode);
        }
    }

    public C2442k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C2442k(Context context, AttributeSet attributeSet, int i8) {
        super(I.b(context), attributeSet, i8);
        this.f21847c = false;
        H.a(this, getContext());
        C2435d c2435d = new C2435d(this);
        this.f21845a = c2435d;
        c2435d.e(attributeSet, i8);
        C2441j c2441j = new C2441j(this);
        this.f21846b = c2441j;
        c2441j.g(attributeSet, i8);
    }
}
