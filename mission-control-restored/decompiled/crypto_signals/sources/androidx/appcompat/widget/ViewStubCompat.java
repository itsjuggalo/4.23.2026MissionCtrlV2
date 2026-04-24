package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import h.AbstractC0616a;
import java.lang.ref.WeakReference;
import m.W0;

/* JADX INFO: loaded from: classes.dex */
public final class ViewStubCompat extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4412a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4413b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public WeakReference f4414c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LayoutInflater f4415d;

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f4412a = 0;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0616a.f6592v, 0, 0);
        this.f4413b = typedArrayObtainStyledAttributes.getResourceId(2, -1);
        this.f4412a = typedArrayObtainStyledAttributes.getResourceId(1, 0);
        setId(typedArrayObtainStyledAttributes.getResourceId(0, -1));
        typedArrayObtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f4413b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f4415d;
    }

    public int getLayoutResource() {
        return this.f4412a;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f4413b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f4415d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f4412a = i;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        WeakReference weakReference = this.f4414c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i);
            return;
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            ViewParent parent = getParent();
            if (!(parent instanceof ViewGroup)) {
                throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
            }
            if (this.f4412a == 0) {
                throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflaterFrom = this.f4415d;
            if (layoutInflaterFrom == null) {
                layoutInflaterFrom = LayoutInflater.from(getContext());
            }
            View viewInflate = layoutInflaterFrom.inflate(this.f4412a, viewGroup, false);
            int i6 = this.f4413b;
            if (i6 != -1) {
                viewInflate.setId(i6);
            }
            int iIndexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(viewInflate, iIndexOfChild, layoutParams);
            } else {
                viewGroup.addView(viewInflate, iIndexOfChild);
            }
            this.f4414c = new WeakReference(viewInflate);
        }
    }

    public void setOnInflateListener(W0 w02) {
    }
}
