package com.yalantis.ucrop.view;

import B4.c;
import B4.d;
import B4.f;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes2.dex */
public class UCropView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public GestureCropImageView f13029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OverlayView f13030b;

    public class a implements C4.a {
        public a() {
        }

        @Override // C4.a
        public void a(float f7) {
            UCropView.this.f13030b.setTargetAspectRatio(f7);
        }
    }

    public class b implements C4.b {
        public b() {
        }

        @Override // C4.b
        public void a(RectF rectF) {
            UCropView.this.f13029a.setCropRect(rectF);
        }
    }

    public UCropView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void c() {
        this.f13029a.setCropBoundsChangeListener(new a());
        this.f13030b.setOverlayViewChangeListener(new b());
    }

    public GestureCropImageView getCropImageView() {
        return this.f13029a;
    }

    public OverlayView getOverlayView() {
        return this.f13030b;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public UCropView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        LayoutInflater.from(context).inflate(d.f766a, (ViewGroup) this, true);
        this.f13029a = (GestureCropImageView) findViewById(c.f764a);
        OverlayView overlayView = (OverlayView) findViewById(c.f765b);
        this.f13030b = overlayView;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.f797b0);
        overlayView.g(typedArrayObtainStyledAttributes);
        this.f13029a.s(typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        c();
    }
}
