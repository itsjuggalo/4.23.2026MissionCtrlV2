package androidx.constraintlayout.widget;

import B.d;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import z.C2850a;
import z.e;

/* JADX INFO: loaded from: classes.dex */
public class Barrier extends b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f6979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C2850a f6980k;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.b
    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        this.f6980k = new C2850a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f556a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == d.f598h1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == d.f592g1) {
                    this.f6980k.K0(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == d.f604i1) {
                    this.f6980k.M0(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
        }
        this.f7100d = this.f6980k;
        k();
    }

    @Override // androidx.constraintlayout.widget.b
    public void f(e eVar, boolean z7) {
        m(eVar, this.f6978i, z7);
    }

    public int getMargin() {
        return this.f6980k.I0();
    }

    public int getType() {
        return this.f6978i;
    }

    public boolean l() {
        return this.f6980k.G0();
    }

    public final void m(e eVar, int i7, boolean z7) {
        this.f6979j = i7;
        if (z7) {
            int i8 = this.f6978i;
            if (i8 == 5) {
                this.f6979j = 1;
            } else if (i8 == 6) {
                this.f6979j = 0;
            }
        } else {
            int i9 = this.f6978i;
            if (i9 == 5) {
                this.f6979j = 0;
            } else if (i9 == 6) {
                this.f6979j = 1;
            }
        }
        if (eVar instanceof C2850a) {
            ((C2850a) eVar).L0(this.f6979j);
        }
    }

    public void setAllowsGoneWidget(boolean z7) {
        this.f6980k.K0(z7);
    }

    public void setDpMargin(int i7) {
        this.f6980k.M0((int) ((i7 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i7) {
        this.f6980k.M0(i7);
    }

    public void setType(int i7) {
        this.f6978i = i7;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
