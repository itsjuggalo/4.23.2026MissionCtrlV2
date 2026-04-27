package androidx.constraintlayout.widget;

import A.b;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.HashMap;
import k4.C2105D;
import z.d;
import z.e;
import z.f;
import z.g;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray f6981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f6982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f6983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6984d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public androidx.constraintlayout.widget.c f6990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public B.a f6991k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6992l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f6993m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f6994n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f6995o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6996p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6997q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6998r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f6999s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SparseArray f7000t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f7001u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7002v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f7003w;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7004a;

        static {
            int[] iArr = new int[e.b.values().length];
            f7004a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7004a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7004a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7004a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class c implements b.InterfaceC0000b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintLayout f7073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7074b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f7075c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7076d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7077e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7078f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7079g;

        public c(ConstraintLayout constraintLayout) {
            this.f7073a = constraintLayout;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:102:0x016b A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:110:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:113:0x019c  */
        /* JADX WARN: Removed duplicated region for block: B:115:0x01a8  */
        /* JADX WARN: Removed duplicated region for block: B:116:0x01b2  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01bf  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01c4  */
        /* JADX WARN: Removed duplicated region for block: B:123:0x01c9  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01d1  */
        /* JADX WARN: Removed duplicated region for block: B:127:0x01d6  */
        /* JADX WARN: Removed duplicated region for block: B:130:0x01db  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x01ed  */
        /* JADX WARN: Removed duplicated region for block: B:143:0x0202  */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0206  */
        /* JADX WARN: Removed duplicated region for block: B:147:0x020c  */
        /* JADX WARN: Removed duplicated region for block: B:150:0x0222  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x0224  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x022a  */
        /* JADX WARN: Removed duplicated region for block: B:158:0x0232  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x0239  */
        /* JADX WARN: Removed duplicated region for block: B:162:0x023b  */
        /* JADX WARN: Removed duplicated region for block: B:164:0x023e  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x011d  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x012e  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x0131  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x0133  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x0138  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x013f  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:88:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x014d  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0155  */
        /* JADX WARN: Removed duplicated region for block: B:96:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0160  */
        @Override // A.b.InterfaceC0000b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(z.e r20, A.b.a r21) {
            /*
                Method dump skipped, instruction units count: 595
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.c.a(z.e, A.b$a):void");
        }

        @Override // A.b.InterfaceC0000b
        public final void b() {
            int childCount = this.f7073a.getChildCount();
            for (int i7 = 0; i7 < childCount; i7++) {
                this.f7073a.getChildAt(i7);
            }
            int size = this.f7073a.f6982b.size();
            if (size > 0) {
                for (int i8 = 0; i8 < size; i8++) {
                    ((androidx.constraintlayout.widget.b) this.f7073a.f6982b.get(i8)).h(this.f7073a);
                }
            }
        }

        public void c(int i7, int i8, int i9, int i10, int i11, int i12) {
            this.f7074b = i9;
            this.f7075c = i10;
            this.f7076d = i11;
            this.f7077e = i12;
            this.f7078f = i7;
            this.f7079g = i8;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6981a = new SparseArray();
        this.f6982b = new ArrayList(4);
        this.f6983c = new f();
        this.f6984d = 0;
        this.f6985e = 0;
        this.f6986f = a.e.API_PRIORITY_OTHER;
        this.f6987g = a.e.API_PRIORITY_OTHER;
        this.f6988h = true;
        this.f6989i = 263;
        this.f6990j = null;
        this.f6991k = null;
        this.f6992l = -1;
        this.f6993m = new HashMap();
        this.f6994n = -1;
        this.f6995o = -1;
        this.f6996p = -1;
        this.f6997q = -1;
        this.f6998r = 0;
        this.f6999s = 0;
        this.f7000t = new SparseArray();
        this.f7001u = new c(this);
        this.f7002v = 0;
        this.f7003w = 0;
        j(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i7, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i7, layoutParams);
    }

    public void c(boolean z7, View view, e eVar, b bVar, SparseArray sparseArray) {
        float f7;
        e eVar2;
        e eVar3;
        e eVar4;
        e eVar5;
        int i7;
        bVar.a();
        bVar.f7060o0 = false;
        eVar.z0(view.getVisibility());
        if (bVar.f7034b0) {
            eVar.m0(true);
            eVar.z0(8);
        }
        eVar.Z(view);
        if (view instanceof androidx.constraintlayout.widget.b) {
            ((androidx.constraintlayout.widget.b) view).f(eVar, this.f6983c.V0());
        }
        if (bVar.f7030Z) {
            g gVar = (g) eVar;
            int i8 = bVar.f7052k0;
            int i9 = bVar.f7054l0;
            float f8 = bVar.f7056m0;
            if (f8 != -1.0f) {
                gVar.M0(f8);
                return;
            } else if (i8 != -1) {
                gVar.K0(i8);
                return;
            } else {
                if (i9 != -1) {
                    gVar.L0(i9);
                    return;
                }
                return;
            }
        }
        int i10 = bVar.f7038d0;
        int i11 = bVar.f7040e0;
        int i12 = bVar.f7042f0;
        int i13 = bVar.f7044g0;
        int i14 = bVar.f7046h0;
        int i15 = bVar.f7048i0;
        float f9 = bVar.f7050j0;
        int i16 = bVar.f7055m;
        if (i16 != -1) {
            e eVar6 = (e) sparseArray.get(i16);
            if (eVar6 != null) {
                eVar.i(eVar6, bVar.f7059o, bVar.f7057n);
            }
        } else {
            if (i10 != -1) {
                e eVar7 = (e) sparseArray.get(i10);
                if (eVar7 != null) {
                    d.b bVar2 = d.b.LEFT;
                    f7 = f9;
                    eVar.R(bVar2, eVar7, bVar2, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i14);
                } else {
                    f7 = f9;
                }
            } else {
                f7 = f9;
                if (i11 != -1 && (eVar2 = (e) sparseArray.get(i11)) != null) {
                    eVar.R(d.b.LEFT, eVar2, d.b.RIGHT, ((ViewGroup.MarginLayoutParams) bVar).leftMargin, i14);
                }
            }
            if (i12 != -1) {
                e eVar8 = (e) sparseArray.get(i12);
                if (eVar8 != null) {
                    eVar.R(d.b.RIGHT, eVar8, d.b.LEFT, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i15);
                }
            } else if (i13 != -1 && (eVar3 = (e) sparseArray.get(i13)) != null) {
                d.b bVar3 = d.b.RIGHT;
                eVar.R(bVar3, eVar3, bVar3, ((ViewGroup.MarginLayoutParams) bVar).rightMargin, i15);
            }
            int i17 = bVar.f7045h;
            if (i17 != -1) {
                e eVar9 = (e) sparseArray.get(i17);
                if (eVar9 != null) {
                    d.b bVar4 = d.b.TOP;
                    eVar.R(bVar4, eVar9, bVar4, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f7066u);
                }
            } else {
                int i18 = bVar.f7047i;
                if (i18 != -1 && (eVar4 = (e) sparseArray.get(i18)) != null) {
                    eVar.R(d.b.TOP, eVar4, d.b.BOTTOM, ((ViewGroup.MarginLayoutParams) bVar).topMargin, bVar.f7066u);
                }
            }
            int i19 = bVar.f7049j;
            if (i19 != -1) {
                e eVar10 = (e) sparseArray.get(i19);
                if (eVar10 != null) {
                    eVar.R(d.b.BOTTOM, eVar10, d.b.TOP, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f7068w);
                }
            } else {
                int i20 = bVar.f7051k;
                if (i20 != -1 && (eVar5 = (e) sparseArray.get(i20)) != null) {
                    d.b bVar5 = d.b.BOTTOM;
                    eVar.R(bVar5, eVar5, bVar5, ((ViewGroup.MarginLayoutParams) bVar).bottomMargin, bVar.f7068w);
                }
            }
            int i21 = bVar.f7053l;
            if (i21 != -1) {
                View view2 = (View) this.f6981a.get(i21);
                e eVar11 = (e) sparseArray.get(bVar.f7053l);
                if (eVar11 != null && view2 != null && (view2.getLayoutParams() instanceof b)) {
                    b bVar6 = (b) view2.getLayoutParams();
                    bVar.f7029Y = true;
                    bVar6.f7029Y = true;
                    d.b bVar7 = d.b.BASELINE;
                    eVar.k(bVar7).a(eVar11.k(bVar7), 0, -1, true);
                    eVar.d0(true);
                    bVar6.f7058n0.d0(true);
                    eVar.k(d.b.TOP).k();
                    eVar.k(d.b.BOTTOM).k();
                }
            }
            float f10 = f7;
            if (f10 >= 0.0f) {
                eVar.f0(f10);
            }
            float f11 = bVar.f7005A;
            if (f11 >= 0.0f) {
                eVar.t0(f11);
            }
        }
        if (z7 && ((i7 = bVar.f7021Q) != -1 || bVar.f7022R != -1)) {
            eVar.r0(i7, bVar.f7022R);
        }
        if (bVar.f7027W) {
            eVar.i0(e.b.FIXED);
            eVar.A0(((ViewGroup.MarginLayoutParams) bVar).width);
            if (((ViewGroup.MarginLayoutParams) bVar).width == -2) {
                eVar.i0(e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).width == -1) {
            if (bVar.f7024T) {
                eVar.i0(e.b.MATCH_CONSTRAINT);
            } else {
                eVar.i0(e.b.MATCH_PARENT);
            }
            eVar.k(d.b.LEFT).f25816e = ((ViewGroup.MarginLayoutParams) bVar).leftMargin;
            eVar.k(d.b.RIGHT).f25816e = ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        } else {
            eVar.i0(e.b.MATCH_CONSTRAINT);
            eVar.A0(0);
        }
        if (bVar.f7028X) {
            eVar.w0(e.b.FIXED);
            eVar.e0(((ViewGroup.MarginLayoutParams) bVar).height);
            if (((ViewGroup.MarginLayoutParams) bVar).height == -2) {
                eVar.w0(e.b.WRAP_CONTENT);
            }
        } else if (((ViewGroup.MarginLayoutParams) bVar).height == -1) {
            if (bVar.f7025U) {
                eVar.w0(e.b.MATCH_CONSTRAINT);
            } else {
                eVar.w0(e.b.MATCH_PARENT);
            }
            eVar.k(d.b.TOP).f25816e = ((ViewGroup.MarginLayoutParams) bVar).topMargin;
            eVar.k(d.b.BOTTOM).f25816e = ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        } else {
            eVar.w0(e.b.MATCH_CONSTRAINT);
            eVar.e0(0);
        }
        eVar.b0(bVar.f7006B);
        eVar.k0(bVar.f7009E);
        eVar.y0(bVar.f7010F);
        eVar.g0(bVar.f7011G);
        eVar.u0(bVar.f7012H);
        eVar.j0(bVar.f7013I, bVar.f7015K, bVar.f7017M, bVar.f7019O);
        eVar.x0(bVar.f7014J, bVar.f7016L, bVar.f7018N, bVar.f7020P);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f6982b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                ((androidx.constraintlayout.widget.b) this.f6982b.get(i7)).i(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(com.amazon.a.a.o.b.f.f9989a);
                    if (strArrSplit.length == 4) {
                        int i9 = Integer.parseInt(strArrSplit[0]);
                        int i10 = Integer.parseInt(strArrSplit[1]);
                        int i11 = Integer.parseInt(strArrSplit[2]);
                        int i12 = (int) ((i9 / 1080.0f) * width);
                        int i13 = (int) ((i10 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f7 = i12;
                        float f8 = i13;
                        float f9 = i12 + ((int) ((i11 / 1080.0f) * width));
                        canvas.drawLine(f7, f8, f9, f8, paint);
                        float f10 = i13 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f9, f8, f9, f10, paint);
                        canvas.drawLine(f9, f10, f7, f10, paint);
                        canvas.drawLine(f7, f10, f7, f8, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f7, f8, f9, f10, paint);
                        canvas.drawLine(f7, f10, f9, f8, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object f(int i7, Object obj) {
        if (i7 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.f6993m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f6993m.get(str);
    }

    @Override // android.view.View
    public void forceLayout() {
        l();
        super.forceLayout();
    }

    public final e g(int i7) {
        if (i7 == 0) {
            return this.f6983c;
        }
        View viewFindViewById = (View) this.f6981a.get(i7);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i7)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f6983c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f7058n0;
    }

    public int getMaxHeight() {
        return this.f6987g;
    }

    public int getMaxWidth() {
        return this.f6986f;
    }

    public int getMinHeight() {
        return this.f6985e;
    }

    public int getMinWidth() {
        return this.f6984d;
    }

    public int getOptimizationLevel() {
        return this.f6983c.R0();
    }

    public View h(int i7) {
        return (View) this.f6981a.get(i7);
    }

    public final e i(View view) {
        if (view == this) {
            return this.f6983c;
        }
        if (view == null) {
            return null;
        }
        return ((b) view.getLayoutParams()).f7058n0;
    }

    public final void j(AttributeSet attributeSet, int i7, int i8) {
        this.f6983c.Z(this);
        this.f6983c.a1(this.f7001u);
        this.f6981a.put(getId(), this);
        this.f6990j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, B.d.f556a1, i7, i8);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == B.d.f580e1) {
                    this.f6984d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6984d);
                } else if (index == B.d.f586f1) {
                    this.f6985e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6985e);
                } else if (index == B.d.f568c1) {
                    this.f6986f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6986f);
                } else if (index == B.d.f574d1) {
                    this.f6987g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6987g);
                } else if (index == B.d.f617k2) {
                    this.f6989i = typedArrayObtainStyledAttributes.getInt(index, this.f6989i);
                } else if (index == B.d.f622l1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            m(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f6991k = null;
                        }
                    }
                } else if (index == B.d.f610j1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
                        this.f6990j = cVar;
                        cVar.l(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f6990j = null;
                    }
                    this.f6992l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f6983c.b1(this.f6989i);
    }

    public boolean k() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public final void l() {
        this.f6988h = true;
        this.f6994n = -1;
        this.f6995o = -1;
        this.f6996p = -1;
        this.f6997q = -1;
        this.f6998r = 0;
        this.f6999s = 0;
    }

    public void m(int i7) {
        this.f6991k = new B.a(getContext(), this, i7);
    }

    public void n(int i7, int i8, int i9, int i10, boolean z7, boolean z8) {
        c cVar = this.f7001u;
        int i11 = cVar.f7077e;
        int iResolveSizeAndState = View.resolveSizeAndState(i9 + cVar.f7076d, i7, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i10 + i11, i8, 0) & 16777215;
        int iMin = Math.min(this.f6986f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f6987g, iResolveSizeAndState2);
        if (z7) {
            iMin |= 16777216;
        }
        if (z8) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f6994n = iMin;
        this.f6995o = iMin2;
    }

    public void o(f fVar, int i7, int i8, int i9) {
        int mode = View.MeasureSpec.getMode(i8);
        int size = View.MeasureSpec.getSize(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        int size2 = View.MeasureSpec.getSize(i9);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i10 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.f7001u.c(i8, i9, iMax, iMax2, paddingWidth, i10);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        int iMax5 = (iMax3 > 0 || iMax4 > 0) ? k() ? iMax4 : iMax3 : Math.max(0, getPaddingLeft());
        int i11 = size - paddingWidth;
        int i12 = size2 - i10;
        r(fVar, mode, i11, mode2, i12);
        fVar.X0(i7, mode, i11, mode2, i12, this.f6994n, this.f6995o, iMax5, iMax);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            b bVar = (b) childAt.getLayoutParams();
            e eVar = bVar.f7058n0;
            if ((childAt.getVisibility() != 8 || bVar.f7030Z || bVar.f7032a0 || bVar.f7036c0 || zIsInEditMode) && !bVar.f7034b0) {
                int iO = eVar.O();
                int iP = eVar.P();
                childAt.layout(iO, iP, eVar.N() + iO, eVar.t() + iP);
            }
        }
        int size = this.f6982b.size();
        if (size > 0) {
            for (int i12 = 0; i12 < size; i12++) {
                ((androidx.constraintlayout.widget.b) this.f6982b.get(i12)).g(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        this.f7002v = i7;
        this.f7003w = i8;
        this.f6983c.c1(k());
        if (this.f6988h) {
            this.f6988h = false;
            if (s()) {
                this.f6983c.e1();
            }
        }
        o(this.f6983c, this.f6989i, i7, i8);
        n(i7, i8, this.f6983c.N(), this.f6983c.t(), this.f6983c.W0(), this.f6983c.U0());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        e eVarI = i(view);
        if ((view instanceof Guideline) && !(eVarI instanceof g)) {
            b bVar = (b) view.getLayoutParams();
            g gVar = new g();
            bVar.f7058n0 = gVar;
            bVar.f7030Z = true;
            gVar.N0(bVar.f7023S);
        }
        if (view instanceof androidx.constraintlayout.widget.b) {
            androidx.constraintlayout.widget.b bVar2 = (androidx.constraintlayout.widget.b) view;
            bVar2.k();
            ((b) view.getLayoutParams()).f7032a0 = true;
            if (!this.f6982b.contains(bVar2)) {
                this.f6982b.add(bVar2);
            }
        }
        this.f6981a.put(view.getId(), view);
        this.f6988h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f6981a.remove(view.getId());
        this.f6983c.H0(i(view));
        this.f6982b.remove(view);
        this.f6988h = true;
    }

    public final void p() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            e eVarI = i(getChildAt(i7));
            if (eVarI != null) {
                eVarI.W();
            }
        }
        if (zIsInEditMode) {
            for (int i8 = 0; i8 < childCount; i8++) {
                View childAt = getChildAt(i8);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    q(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    g(childAt.getId()).a0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f6992l != -1) {
            for (int i9 = 0; i9 < childCount; i9++) {
                getChildAt(i9).getId();
            }
        }
        androidx.constraintlayout.widget.c cVar = this.f6990j;
        if (cVar != null) {
            cVar.d(this, true);
        }
        this.f6983c.I0();
        int size = this.f6982b.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.constraintlayout.widget.b) this.f6982b.get(i10)).j(this);
            }
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            getChildAt(i11);
        }
        this.f7000t.clear();
        this.f7000t.put(0, this.f6983c);
        this.f7000t.put(getId(), this.f6983c);
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            this.f7000t.put(childAt2.getId(), i(childAt2));
        }
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt3 = getChildAt(i13);
            e eVarI2 = i(childAt3);
            if (eVarI2 != null) {
                b bVar = (b) childAt3.getLayoutParams();
                this.f6983c.b(eVarI2);
                c(zIsInEditMode, childAt3, eVarI2, bVar, this.f7000t);
            }
        }
    }

    public void q(int i7, Object obj, Object obj2) {
        if (i7 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f6993m == null) {
                this.f6993m = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            Integer num = (Integer) obj2;
            num.intValue();
            this.f6993m.put(strSubstring, num);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 z.e$b) = (r2v3 z.e$b), (r2v0 z.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void r(z.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.f7001u
            int r1 = r0.f7077e
            int r0 = r0.f7076d
            z.e$b r2 = z.e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 0
            if (r9 == r5) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r6
            goto L38
        L1a:
            int r9 = r7.f6986f
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            z.e$b r9 = z.e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.f6984d
            int r10 = java.lang.Math.max(r6, r10)
            goto L38
        L2e:
            z.e$b r9 = z.e.b.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.f6984d
            int r10 = java.lang.Math.max(r6, r10)
        L38:
            if (r11 == r5) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r6
            goto L5d
        L40:
            int r11 = r7.f6987g
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            z.e$b r2 = z.e.b.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.f6985e
            int r12 = java.lang.Math.max(r6, r11)
            goto L5d
        L53:
            z.e$b r2 = z.e.b.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.f6985e
            int r12 = java.lang.Math.max(r6, r11)
        L5d:
            int r11 = r8.N()
            if (r10 != r11) goto L69
            int r11 = r8.t()
            if (r12 == r11) goto L6c
        L69:
            r8.T0()
        L6c:
            r8.B0(r6)
            r8.C0(r6)
            int r11 = r7.f6986f
            int r11 = r11 - r0
            r8.o0(r11)
            int r11 = r7.f6987g
            int r11 = r11 - r1
            r8.n0(r11)
            r8.q0(r6)
            r8.p0(r6)
            r8.i0(r9)
            r8.A0(r10)
            r8.w0(r2)
            r8.e0(r12)
            int r9 = r7.f6984d
            int r9 = r9 - r0
            r8.q0(r9)
            int r9 = r7.f6985e
            int r9 = r9 - r1
            r8.p0(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.r(z.f, int, int, int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        l();
        super.requestLayout();
    }

    public final boolean s() {
        int childCount = getChildCount();
        boolean z7 = false;
        int i7 = 0;
        while (true) {
            if (i7 >= childCount) {
                break;
            }
            if (getChildAt(i7).isLayoutRequested()) {
                z7 = true;
                break;
            }
            i7++;
        }
        if (z7) {
            p();
        }
        return z7;
    }

    public void setConstraintSet(androidx.constraintlayout.widget.c cVar) {
        this.f6990j = cVar;
    }

    @Override // android.view.View
    public void setId(int i7) {
        this.f6981a.remove(getId());
        super.setId(i7);
        this.f6981a.put(getId(), this);
    }

    public void setMaxHeight(int i7) {
        if (i7 == this.f6987g) {
            return;
        }
        this.f6987g = i7;
        requestLayout();
    }

    public void setMaxWidth(int i7) {
        if (i7 == this.f6986f) {
            return;
        }
        this.f6986f = i7;
        requestLayout();
    }

    public void setMinHeight(int i7) {
        if (i7 == this.f6985e) {
            return;
        }
        this.f6985e = i7;
        requestLayout();
    }

    public void setMinWidth(int i7) {
        if (i7 == this.f6984d) {
            return;
        }
        this.f6984d = i7;
        requestLayout();
    }

    public void setOnConstraintsChanged(B.b bVar) {
        B.a aVar = this.f6991k;
        if (aVar != null) {
            aVar.c(bVar);
        }
    }

    public void setOptimizationLevel(int i7) {
        this.f6989i = i7;
        this.f6983c.b1(i7);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f6981a = new SparseArray();
        this.f6982b = new ArrayList(4);
        this.f6983c = new f();
        this.f6984d = 0;
        this.f6985e = 0;
        this.f6986f = a.e.API_PRIORITY_OTHER;
        this.f6987g = a.e.API_PRIORITY_OTHER;
        this.f6988h = true;
        this.f6989i = 263;
        this.f6990j = null;
        this.f6991k = null;
        this.f6992l = -1;
        this.f6993m = new HashMap();
        this.f6994n = -1;
        this.f6995o = -1;
        this.f6996p = -1;
        this.f6997q = -1;
        this.f6998r = 0;
        this.f6999s = 0;
        this.f7000t = new SparseArray();
        this.f7001u = new c(this);
        this.f7002v = 0;
        this.f7003w = 0;
        j(attributeSet, i7, 0);
    }

    public static class b extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public float f7005A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public String f7006B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public float f7007C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f7008D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public float f7009E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public float f7010F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f7011G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f7012H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f7013I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f7014J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public int f7015K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public int f7016L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f7017M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public int f7018N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public float f7019O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public float f7020P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f7021Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f7022R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public int f7023S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public boolean f7024T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public boolean f7025U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public String f7026V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public boolean f7027W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public boolean f7028X;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public boolean f7029Y;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public boolean f7030Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7031a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f7032a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7033b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f7034b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f7035c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public boolean f7036c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f7037d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f7038d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f7039e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f7040e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f7041f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public int f7042f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f7043g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public int f7044g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f7045h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public int f7046h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f7047i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f7048i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f7049j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public float f7050j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f7051k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public int f7052k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f7053l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f7054l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f7055m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public float f7056m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f7057n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public e f7058n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f7059o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public boolean f7060o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f7061p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f7062q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f7063r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f7064s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f7065t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f7066u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f7067v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f7068w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f7069x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f7070y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f7071z;

        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f7072a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f7072a = sparseIntArray;
                sparseIntArray.append(B.d.f465K1, 8);
                sparseIntArray.append(B.d.f471L1, 9);
                sparseIntArray.append(B.d.f483N1, 10);
                sparseIntArray.append(B.d.f489O1, 11);
                sparseIntArray.append(B.d.f525U1, 12);
                sparseIntArray.append(B.d.f519T1, 13);
                sparseIntArray.append(B.d.f664s1, 14);
                sparseIntArray.append(B.d.f658r1, 15);
                sparseIntArray.append(B.d.f646p1, 16);
                sparseIntArray.append(B.d.f670t1, 2);
                sparseIntArray.append(B.d.f682v1, 3);
                sparseIntArray.append(B.d.f676u1, 4);
                sparseIntArray.append(B.d.f569c2, 49);
                sparseIntArray.append(B.d.f575d2, 50);
                sparseIntArray.append(B.d.f706z1, 5);
                sparseIntArray.append(B.d.f405A1, 6);
                sparseIntArray.append(B.d.f411B1, 7);
                sparseIntArray.append(B.d.f562b1, 1);
                sparseIntArray.append(B.d.f495P1, 17);
                sparseIntArray.append(B.d.f501Q1, 18);
                sparseIntArray.append(B.d.f700y1, 19);
                sparseIntArray.append(B.d.f694x1, 20);
                sparseIntArray.append(B.d.f593g2, 21);
                sparseIntArray.append(B.d.f611j2, 22);
                sparseIntArray.append(B.d.f599h2, 23);
                sparseIntArray.append(B.d.f581e2, 24);
                sparseIntArray.append(B.d.f605i2, 25);
                sparseIntArray.append(B.d.f587f2, 26);
                sparseIntArray.append(B.d.f441G1, 29);
                sparseIntArray.append(B.d.f531V1, 30);
                sparseIntArray.append(B.d.f688w1, 44);
                sparseIntArray.append(B.d.f453I1, 45);
                sparseIntArray.append(B.d.f541X1, 46);
                sparseIntArray.append(B.d.f447H1, 47);
                sparseIntArray.append(B.d.f536W1, 48);
                sparseIntArray.append(B.d.f634n1, 27);
                sparseIntArray.append(B.d.f628m1, 28);
                sparseIntArray.append(B.d.f546Y1, 31);
                sparseIntArray.append(B.d.f417C1, 32);
                sparseIntArray.append(B.d.f557a2, 33);
                sparseIntArray.append(B.d.f551Z1, 34);
                sparseIntArray.append(B.d.f563b2, 35);
                sparseIntArray.append(B.d.f429E1, 36);
                sparseIntArray.append(B.d.f423D1, 37);
                sparseIntArray.append(B.d.f435F1, 38);
                sparseIntArray.append(B.d.f459J1, 39);
                sparseIntArray.append(B.d.f513S1, 40);
                sparseIntArray.append(B.d.f477M1, 41);
                sparseIntArray.append(B.d.f652q1, 42);
                sparseIntArray.append(B.d.f640o1, 43);
                sparseIntArray.append(B.d.f507R1, 51);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            int i7;
            super(context, attributeSet);
            this.f7031a = -1;
            this.f7033b = -1;
            this.f7035c = -1.0f;
            this.f7037d = -1;
            this.f7039e = -1;
            this.f7041f = -1;
            this.f7043g = -1;
            this.f7045h = -1;
            this.f7047i = -1;
            this.f7049j = -1;
            this.f7051k = -1;
            this.f7053l = -1;
            this.f7055m = -1;
            this.f7057n = 0;
            this.f7059o = 0.0f;
            this.f7061p = -1;
            this.f7062q = -1;
            this.f7063r = -1;
            this.f7064s = -1;
            this.f7065t = -1;
            this.f7066u = -1;
            this.f7067v = -1;
            this.f7068w = -1;
            this.f7069x = -1;
            this.f7070y = -1;
            this.f7071z = 0.5f;
            this.f7005A = 0.5f;
            this.f7006B = null;
            this.f7007C = 0.0f;
            this.f7008D = 1;
            this.f7009E = -1.0f;
            this.f7010F = -1.0f;
            this.f7011G = 0;
            this.f7012H = 0;
            this.f7013I = 0;
            this.f7014J = 0;
            this.f7015K = 0;
            this.f7016L = 0;
            this.f7017M = 0;
            this.f7018N = 0;
            this.f7019O = 1.0f;
            this.f7020P = 1.0f;
            this.f7021Q = -1;
            this.f7022R = -1;
            this.f7023S = -1;
            this.f7024T = false;
            this.f7025U = false;
            this.f7026V = null;
            this.f7027W = true;
            this.f7028X = true;
            this.f7029Y = false;
            this.f7030Z = false;
            this.f7032a0 = false;
            this.f7034b0 = false;
            this.f7036c0 = false;
            this.f7038d0 = -1;
            this.f7040e0 = -1;
            this.f7042f0 = -1;
            this.f7044g0 = -1;
            this.f7046h0 = -1;
            this.f7048i0 = -1;
            this.f7050j0 = 0.5f;
            this.f7058n0 = new e();
            this.f7060o0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, B.d.f556a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                int i9 = a.f7072a.get(index);
                switch (i9) {
                    case 1:
                        this.f7023S = typedArrayObtainStyledAttributes.getInt(index, this.f7023S);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f7055m);
                        this.f7055m = resourceId;
                        if (resourceId == -1) {
                            this.f7055m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f7057n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7057n);
                        break;
                    case 4:
                        float f7 = typedArrayObtainStyledAttributes.getFloat(index, this.f7059o) % 360.0f;
                        this.f7059o = f7;
                        if (f7 < 0.0f) {
                            this.f7059o = (360.0f - f7) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f7031a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7031a);
                        break;
                    case 6:
                        this.f7033b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7033b);
                        break;
                    case 7:
                        this.f7035c = typedArrayObtainStyledAttributes.getFloat(index, this.f7035c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7037d);
                        this.f7037d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f7037d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case C2105D.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7039e);
                        this.f7039e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f7039e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case C2105D.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7041f);
                        this.f7041f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f7041f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7043g);
                        this.f7043g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f7043g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7045h);
                        this.f7045h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f7045h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7047i);
                        this.f7047i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f7047i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7049j);
                        this.f7049j = resourceId8;
                        if (resourceId8 == -1) {
                            this.f7049j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7051k);
                        this.f7051k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f7051k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case com.amazon.c.a.a.c.f10119g /* 16 */:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7053l);
                        this.f7053l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f7053l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case C2105D.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7061p);
                        this.f7061p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f7061p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case C2105D.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7062q);
                        this.f7062q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f7062q = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7063r);
                        this.f7063r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f7063r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f7064s);
                        this.f7064s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f7064s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.f7065t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7065t);
                        break;
                    case 22:
                        this.f7066u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7066u);
                        break;
                    case 23:
                        this.f7067v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7067v);
                        break;
                    case 24:
                        this.f7068w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7068w);
                        break;
                    case 25:
                        this.f7069x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7069x);
                        break;
                    case 26:
                        this.f7070y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7070y);
                        break;
                    case 27:
                        this.f7024T = typedArrayObtainStyledAttributes.getBoolean(index, this.f7024T);
                        break;
                    case 28:
                        this.f7025U = typedArrayObtainStyledAttributes.getBoolean(index, this.f7025U);
                        break;
                    case 29:
                        this.f7071z = typedArrayObtainStyledAttributes.getFloat(index, this.f7071z);
                        break;
                    case 30:
                        this.f7005A = typedArrayObtainStyledAttributes.getFloat(index, this.f7005A);
                        break;
                    case 31:
                        int i10 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f7013I = i10;
                        if (i10 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case com.amazon.c.a.a.c.f10120h /* 32 */:
                        int i11 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f7014J = i11;
                        if (i11 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.f7015K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7015K);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f7015K) == -2) {
                                this.f7015K = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.f7017M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7017M);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f7017M) == -2) {
                                this.f7017M = -2;
                            }
                        }
                        break;
                    case 35:
                        this.f7019O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f7019O));
                        this.f7013I = 2;
                        break;
                    case 36:
                        try {
                            this.f7016L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7016L);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f7016L) == -2) {
                                this.f7016L = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.f7018N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f7018N);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f7018N) == -2) {
                                this.f7018N = -2;
                            }
                        }
                        break;
                    case 38:
                        this.f7020P = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f7020P));
                        this.f7014J = 2;
                        break;
                    default:
                        switch (i9) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f7006B = string;
                                this.f7007C = Float.NaN;
                                this.f7008D = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f7006B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i7 = 0;
                                    } else {
                                        String strSubstring = this.f7006B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.f7008D = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.f7008D = 1;
                                        }
                                        i7 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f7006B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f7006B.substring(i7);
                                        if (strSubstring2.length() > 0) {
                                            this.f7007C = Float.parseFloat(strSubstring2);
                                        }
                                    } else {
                                        String strSubstring3 = this.f7006B.substring(i7, iIndexOf2);
                                        String strSubstring4 = this.f7006B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                            try {
                                                float f8 = Float.parseFloat(strSubstring3);
                                                float f9 = Float.parseFloat(strSubstring4);
                                                if (f8 > 0.0f && f9 > 0.0f) {
                                                    if (this.f7008D == 1) {
                                                        this.f7007C = Math.abs(f9 / f8);
                                                    } else {
                                                        this.f7007C = Math.abs(f8 / f9);
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.f7009E = typedArrayObtainStyledAttributes.getFloat(index, this.f7009E);
                                break;
                            case 46:
                                this.f7010F = typedArrayObtainStyledAttributes.getFloat(index, this.f7010F);
                                break;
                            case 47:
                                this.f7011G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f7012H = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f7021Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7021Q);
                                break;
                            case 50:
                                this.f7022R = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f7022R);
                                break;
                            case 51:
                                this.f7026V = typedArrayObtainStyledAttributes.getString(index);
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f7030Z = false;
            this.f7027W = true;
            this.f7028X = true;
            int i7 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i7 == -2 && this.f7024T) {
                this.f7027W = false;
                if (this.f7013I == 0) {
                    this.f7013I = 1;
                }
            }
            int i8 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i8 == -2 && this.f7025U) {
                this.f7028X = false;
                if (this.f7014J == 0) {
                    this.f7014J = 1;
                }
            }
            if (i7 == 0 || i7 == -1) {
                this.f7027W = false;
                if (i7 == 0 && this.f7013I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f7024T = true;
                }
            }
            if (i8 == 0 || i8 == -1) {
                this.f7028X = false;
                if (i8 == 0 && this.f7014J == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f7025U = true;
                }
            }
            if (this.f7035c == -1.0f && this.f7031a == -1 && this.f7033b == -1) {
                return;
            }
            this.f7030Z = true;
            this.f7027W = true;
            this.f7028X = true;
            if (!(this.f7058n0 instanceof g)) {
                this.f7058n0 = new g();
            }
            ((g) this.f7058n0).N0(this.f7023S);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004f  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0062  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007c  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r10) {
            /*
                Method dump skipped, instruction units count: 253
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(int i7, int i8) {
            super(i7, i8);
            this.f7031a = -1;
            this.f7033b = -1;
            this.f7035c = -1.0f;
            this.f7037d = -1;
            this.f7039e = -1;
            this.f7041f = -1;
            this.f7043g = -1;
            this.f7045h = -1;
            this.f7047i = -1;
            this.f7049j = -1;
            this.f7051k = -1;
            this.f7053l = -1;
            this.f7055m = -1;
            this.f7057n = 0;
            this.f7059o = 0.0f;
            this.f7061p = -1;
            this.f7062q = -1;
            this.f7063r = -1;
            this.f7064s = -1;
            this.f7065t = -1;
            this.f7066u = -1;
            this.f7067v = -1;
            this.f7068w = -1;
            this.f7069x = -1;
            this.f7070y = -1;
            this.f7071z = 0.5f;
            this.f7005A = 0.5f;
            this.f7006B = null;
            this.f7007C = 0.0f;
            this.f7008D = 1;
            this.f7009E = -1.0f;
            this.f7010F = -1.0f;
            this.f7011G = 0;
            this.f7012H = 0;
            this.f7013I = 0;
            this.f7014J = 0;
            this.f7015K = 0;
            this.f7016L = 0;
            this.f7017M = 0;
            this.f7018N = 0;
            this.f7019O = 1.0f;
            this.f7020P = 1.0f;
            this.f7021Q = -1;
            this.f7022R = -1;
            this.f7023S = -1;
            this.f7024T = false;
            this.f7025U = false;
            this.f7026V = null;
            this.f7027W = true;
            this.f7028X = true;
            this.f7029Y = false;
            this.f7030Z = false;
            this.f7032a0 = false;
            this.f7034b0 = false;
            this.f7036c0 = false;
            this.f7038d0 = -1;
            this.f7040e0 = -1;
            this.f7042f0 = -1;
            this.f7044g0 = -1;
            this.f7046h0 = -1;
            this.f7048i0 = -1;
            this.f7050j0 = 0.5f;
            this.f7058n0 = new e();
            this.f7060o0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f7031a = -1;
            this.f7033b = -1;
            this.f7035c = -1.0f;
            this.f7037d = -1;
            this.f7039e = -1;
            this.f7041f = -1;
            this.f7043g = -1;
            this.f7045h = -1;
            this.f7047i = -1;
            this.f7049j = -1;
            this.f7051k = -1;
            this.f7053l = -1;
            this.f7055m = -1;
            this.f7057n = 0;
            this.f7059o = 0.0f;
            this.f7061p = -1;
            this.f7062q = -1;
            this.f7063r = -1;
            this.f7064s = -1;
            this.f7065t = -1;
            this.f7066u = -1;
            this.f7067v = -1;
            this.f7068w = -1;
            this.f7069x = -1;
            this.f7070y = -1;
            this.f7071z = 0.5f;
            this.f7005A = 0.5f;
            this.f7006B = null;
            this.f7007C = 0.0f;
            this.f7008D = 1;
            this.f7009E = -1.0f;
            this.f7010F = -1.0f;
            this.f7011G = 0;
            this.f7012H = 0;
            this.f7013I = 0;
            this.f7014J = 0;
            this.f7015K = 0;
            this.f7016L = 0;
            this.f7017M = 0;
            this.f7018N = 0;
            this.f7019O = 1.0f;
            this.f7020P = 1.0f;
            this.f7021Q = -1;
            this.f7022R = -1;
            this.f7023S = -1;
            this.f7024T = false;
            this.f7025U = false;
            this.f7026V = null;
            this.f7027W = true;
            this.f7028X = true;
            this.f7029Y = false;
            this.f7030Z = false;
            this.f7032a0 = false;
            this.f7034b0 = false;
            this.f7036c0 = false;
            this.f7038d0 = -1;
            this.f7040e0 = -1;
            this.f7042f0 = -1;
            this.f7044g0 = -1;
            this.f7046h0 = -1;
            this.f7048i0 = -1;
            this.f7050j0 = 0.5f;
            this.f7058n0 = new e();
            this.f7060o0 = false;
        }
    }
}
