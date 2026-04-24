package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10914j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f10915k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C.a f10916l;

    public a(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // androidx.constraintlayout.widget.c
    public void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        this.f10916l = new C.a();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, F.d.f1394n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == F.d.f1450u1) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == F.d.f1442t1) {
                    this.f10916l.v1(typedArrayObtainStyledAttributes.getBoolean(index, true));
                } else if (index == F.d.f1458v1) {
                    this.f10916l.x1(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f10938d = this.f10916l;
        m();
    }

    public boolean getAllowsGoneWidget() {
        return this.f10916l.q1();
    }

    public int getMargin() {
        return this.f10916l.s1();
    }

    public int getType() {
        return this.f10914j;
    }

    @Override // androidx.constraintlayout.widget.c
    public void h(C.e eVar, boolean z7) {
        n(eVar, this.f10914j, z7);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n(C.e r4, int r5, boolean r6) {
        /*
            r3 = this;
            r3.f10915k = r5
            r5 = 0
            r0 = 6
            r1 = 1
            r2 = 5
            if (r6 == 0) goto L14
            int r6 = r3.f10914j
            if (r6 != r2) goto Lf
        Lc:
            r3.f10915k = r1
            goto L1c
        Lf:
            if (r6 != r0) goto L1c
        L11:
            r3.f10915k = r5
            goto L1c
        L14:
            int r6 = r3.f10914j
            if (r6 != r2) goto L19
            goto L11
        L19:
            if (r6 != r0) goto L1c
            goto Lc
        L1c:
            boolean r5 = r4 instanceof C.a
            if (r5 == 0) goto L27
            C.a r4 = (C.a) r4
            int r5 = r3.f10915k
            r4.w1(r5)
        L27:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.a.n(C.e, int, boolean):void");
    }

    public void setAllowsGoneWidget(boolean z7) {
        this.f10916l.v1(z7);
    }

    public void setDpMargin(int i8) {
        this.f10916l.x1((int) ((i8 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i8) {
        this.f10916l.x1(i8);
    }

    public void setType(int i8) {
        this.f10914j = i8;
    }
}
