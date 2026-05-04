package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f17288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f17289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17290c;

    public k(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        d dVar = this.f17288a;
        if (dVar != null) {
            dVar.b();
        }
        j jVar = this.f17289b;
        if (jVar != null) {
            jVar.c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        d dVar = this.f17288a;
        if (dVar != null) {
            return dVar.c();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        d dVar = this.f17288a;
        if (dVar != null) {
            return dVar.d();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        j jVar = this.f17289b;
        if (jVar != null) {
            return jVar.d();
        }
        return null;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        j jVar = this.f17289b;
        if (jVar != null) {
            return jVar.e();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f17289b.f() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        d dVar = this.f17288a;
        if (dVar != null) {
            dVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        d dVar = this.f17288a;
        if (dVar != null) {
            dVar.g(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        j jVar = this.f17289b;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        j jVar = this.f17289b;
        if (jVar != null && drawable != null && !this.f17290c) {
            jVar.h(drawable);
        }
        super.setImageDrawable(drawable);
        j jVar2 = this.f17289b;
        if (jVar2 != null) {
            jVar2.c();
            if (this.f17290c) {
                return;
            }
            this.f17289b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i10) {
        super.setImageLevel(i10);
        this.f17290c = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        j jVar = this.f17289b;
        if (jVar != null) {
            jVar.i(i10);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        j jVar = this.f17289b;
        if (jVar != null) {
            jVar.c();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        d dVar = this.f17288a;
        if (dVar != null) {
            dVar.i(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        d dVar = this.f17288a;
        if (dVar != null) {
            dVar.j(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        j jVar = this.f17289b;
        if (jVar != null) {
            jVar.j(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        j jVar = this.f17289b;
        if (jVar != null) {
            jVar.k(mode);
        }
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public k(Context context, AttributeSet attributeSet, int i10) {
        super(g0.b(context), attributeSet, i10);
        this.f17290c = false;
        f0.a(this, getContext());
        d dVar = new d(this);
        this.f17288a = dVar;
        dVar.e(attributeSet, i10);
        j jVar = new j(this);
        this.f17289b = jVar;
        jVar.g(attributeSet, i10);
    }
}
