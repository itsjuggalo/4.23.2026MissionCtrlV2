package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f1420j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f1421k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c0.a f1422l;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.c
    public void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f1422l = new c0.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f0.d.f9171n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == f0.d.f9227u1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == f0.d.f9219t1) {
                    this.f1422l.v1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == f0.d.f9235v1) {
                    this.f1422l.x1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f1444d = this.f1422l;
        m();
    }

    public boolean getAllowsGoneWidget() {
        return this.f1422l.q1();
    }

    public int getMargin() {
        return this.f1422l.s1();
    }

    public int getType() {
        return this.f1420j;
    }

    @Override // androidx.constraintlayout.widget.c
    public void h(c0.e eVar, boolean z10) {
        n(eVar, this.f1420j, z10);
    }

    public final void n(c0.e eVar, int i10, boolean z10) {
        this.f1421k = i10;
        if (z10) {
            int i11 = this.f1420j;
            if (i11 == 5) {
                this.f1421k = 1;
            } else if (i11 == 6) {
                this.f1421k = 0;
            }
        } else {
            int i12 = this.f1420j;
            if (i12 == 5) {
                this.f1421k = 0;
            } else if (i12 == 6) {
                this.f1421k = 1;
            }
        }
        if (eVar instanceof c0.a) {
            ((c0.a) eVar).w1(this.f1421k);
        }
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f1422l.v1(z10);
    }

    public void setDpMargin(int i10) {
        this.f1422l.x1((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f1422l.x1(i10);
    }

    public void setType(int i10) {
        this.f1420j = i10;
    }
}
