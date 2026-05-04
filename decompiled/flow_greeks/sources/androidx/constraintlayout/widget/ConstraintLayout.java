package androidx.constraintlayout.widget;

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
import bb.d0;
import c0.d;
import c0.e;
import c0.f;
import c0.g;
import c0.j;
import com.google.android.gms.common.api.a;
import com.revenuecat.purchases.common.events.EventsManager;
import com.revenuecat.purchases.utils.PurchaseParamsValidator;
import d0.b;
import io.flutter.Build;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static f0.e f1337x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SparseArray f1338a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList f1339b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public f f1340c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1341d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1342e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f1343f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1344g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1345h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1346i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f1347j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f0.a f1348k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f1349l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap f1350m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f1351n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f1352o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1353p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f1354q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f1355r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f1356s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public SparseArray f1357t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public c f1358u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f1359v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f1360w;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1361a;

        static {
            int[] iArr = new int[e.b.values().length];
            f1361a = iArr;
            try {
                iArr[e.b.FIXED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1361a[e.b.WRAP_CONTENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1361a[e.b.MATCH_PARENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1361a[e.b.MATCH_CONSTRAINT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements b.InterfaceC0137b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ConstraintLayout f1412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1413b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1414c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f1415d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1416e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1417f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1418g;

        public c(ConstraintLayout constraintLayout) {
            this.f1412a = constraintLayout;
        }

        @Override // d0.b.InterfaceC0137b
        public final void a() {
            int childCount = this.f1412a.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.f1412a.getChildAt(i10);
            }
            int size = this.f1412a.f1339b.size();
            if (size > 0) {
                for (int i11 = 0; i11 < size; i11++) {
                    ((androidx.constraintlayout.widget.c) this.f1412a.f1339b.get(i11)).j(this.f1412a);
                }
            }
        }

        @Override // d0.b.InterfaceC0137b
        public final void b(c0.e eVar, b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int baseline;
            int iMax;
            int iMax2;
            int i10;
            if (eVar == null) {
                return;
            }
            if (eVar.T() == 8 && !eVar.h0()) {
                aVar.f7407e = 0;
                aVar.f7408f = 0;
                aVar.f7409g = 0;
                return;
            }
            if (eVar.I() == null) {
                return;
            }
            e.b bVar = aVar.f7403a;
            e.b bVar2 = aVar.f7404b;
            int i11 = aVar.f7405c;
            int i12 = aVar.f7406d;
            int i13 = this.f1413b + this.f1414c;
            int i14 = this.f1415d;
            View view = (View) eVar.q();
            int[] iArr = a.f1361a;
            int i15 = iArr[bVar.ordinal()];
            if (i15 == 1) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else if (i15 == 2) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1417f, i14, -2);
            } else if (i15 == 3) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1417f, i14 + eVar.z(), -1);
            } else if (i15 != 4) {
                iMakeMeasureSpec = 0;
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f1417f, i14, -2);
                boolean z10 = eVar.f3501w == 1;
                int i16 = aVar.f7412j;
                if (i16 == b.a.f7401l || i16 == b.a.f7402m) {
                    boolean z11 = view.getMeasuredHeight() == eVar.v();
                    if (aVar.f7412j == b.a.f7402m || !z10 || ((z10 && z11) || eVar.l0())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(eVar.U(), 1073741824);
                    }
                }
            }
            int i17 = iArr[bVar2.ordinal()];
            if (i17 == 1) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else if (i17 == 2) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1418g, i13, -2);
            } else if (i17 == 3) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1418g, i13 + eVar.S(), -1);
            } else if (i17 != 4) {
                iMakeMeasureSpec2 = 0;
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f1418g, i13, -2);
                boolean z12 = eVar.f3503x == 1;
                int i18 = aVar.f7412j;
                if (i18 == b.a.f7401l || i18 == b.a.f7402m) {
                    boolean z13 = view.getMeasuredWidth() == eVar.U();
                    if (aVar.f7412j == b.a.f7402m || !z12 || ((z12 && z13) || eVar.m0())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(eVar.v(), 1073741824);
                    }
                }
            }
            f fVar = (f) eVar.I();
            if (fVar != null && j.b(ConstraintLayout.this.f1346i, 256) && view.getMeasuredWidth() == eVar.U() && view.getMeasuredWidth() < fVar.U() && view.getMeasuredHeight() == eVar.v() && view.getMeasuredHeight() < fVar.v() && view.getBaseline() == eVar.n() && !eVar.k0() && d(eVar.A(), iMakeMeasureSpec, eVar.U()) && d(eVar.B(), iMakeMeasureSpec2, eVar.v())) {
                aVar.f7407e = eVar.U();
                aVar.f7408f = eVar.v();
                aVar.f7409g = eVar.n();
                return;
            }
            e.b bVar3 = e.b.MATCH_CONSTRAINT;
            boolean z14 = bVar == bVar3;
            boolean z15 = bVar2 == bVar3;
            e.b bVar4 = e.b.MATCH_PARENT;
            boolean z16 = bVar2 == bVar4 || bVar2 == e.b.FIXED;
            boolean z17 = bVar == bVar4 || bVar == e.b.FIXED;
            boolean z18 = z14 && eVar.f3464d0 > 0.0f;
            boolean z19 = z15 && eVar.f3464d0 > 0.0f;
            if (view == null) {
                return;
            }
            b bVar5 = (b) view.getLayoutParams();
            int i19 = aVar.f7412j;
            if (i19 != b.a.f7401l && i19 != b.a.f7402m && z14 && eVar.f3501w == 0 && z15 && eVar.f3503x == 0) {
                i10 = -1;
                iMax2 = 0;
                baseline = 0;
                iMax = 0;
            } else {
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                eVar.R0(iMakeMeasureSpec, iMakeMeasureSpec2);
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                baseline = view.getBaseline();
                int i20 = eVar.f3507z;
                iMax = i20 > 0 ? Math.max(i20, measuredWidth) : measuredWidth;
                int i21 = eVar.A;
                if (i21 > 0) {
                    iMax = Math.min(i21, iMax);
                }
                int i22 = eVar.C;
                iMax2 = i22 > 0 ? Math.max(i22, measuredHeight) : measuredHeight;
                boolean z20 = z17;
                int i23 = eVar.D;
                if (i23 > 0) {
                    iMax2 = Math.min(i23, iMax2);
                }
                if (!j.b(ConstraintLayout.this.f1346i, 1)) {
                    if (z18 && z16) {
                        iMax = (int) ((iMax2 * eVar.f3464d0) + 0.5f);
                    } else if (z19 && z20) {
                        iMax2 = (int) ((iMax / eVar.f3464d0) + 0.5f);
                    }
                }
                if (measuredWidth != iMax || measuredHeight != iMax2) {
                    if (measuredWidth != iMax) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax, 1073741824);
                    }
                    if (measuredHeight != iMax2) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    eVar.R0(iMakeMeasureSpec, iMakeMeasureSpec2);
                    iMax = view.getMeasuredWidth();
                    iMax2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                }
                i10 = -1;
            }
            boolean z21 = baseline != i10;
            aVar.f7411i = (iMax == aVar.f7405c && iMax2 == aVar.f7406d) ? false : true;
            if (bVar5.f1375g0) {
                z21 = true;
            }
            if (z21 && baseline != -1 && eVar.n() != baseline) {
                aVar.f7411i = true;
            }
            aVar.f7407e = iMax;
            aVar.f7408f = iMax2;
            aVar.f7410h = z21;
            aVar.f7409g = baseline;
        }

        public void c(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f1413b = i12;
            this.f1414c = i13;
            this.f1415d = i14;
            this.f1416e = i15;
            this.f1417f = i10;
            this.f1418g = i11;
        }

        public final boolean d(int i10, int i11, int i12) {
            if (i10 == i11) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i10);
            View.MeasureSpec.getSize(i10);
            int mode2 = View.MeasureSpec.getMode(i11);
            int size = View.MeasureSpec.getSize(i11);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i12 == size;
            }
            return false;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1338a = new SparseArray();
        this.f1339b = new ArrayList(4);
        this.f1340c = new f();
        this.f1341d = 0;
        this.f1342e = 0;
        this.f1343f = a.e.API_PRIORITY_OTHER;
        this.f1344g = a.e.API_PRIORITY_OTHER;
        this.f1345h = true;
        this.f1346i = 257;
        this.f1347j = null;
        this.f1348k = null;
        this.f1349l = -1;
        this.f1350m = new HashMap();
        this.f1351n = -1;
        this.f1352o = -1;
        this.f1353p = -1;
        this.f1354q = -1;
        this.f1355r = 0;
        this.f1356s = 0;
        this.f1357t = new SparseArray();
        this.f1358u = new c(this);
        this.f1359v = 0;
        this.f1360w = 0;
        p(attributeSet, 0, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        int iMax2 = Math.max(0, getPaddingStart()) + Math.max(0, getPaddingEnd());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static f0.e getSharedValues() {
        if (f1337x == null) {
            f1337x = new f0.e();
        }
        return f1337x;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList arrayList = this.f1339b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((androidx.constraintlayout.widget.c) this.f1339b.get(i10)).k(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(com.amazon.a.a.o.b.f.f4598a);
                    if (strArrSplit.length == 4) {
                        int i12 = Integer.parseInt(strArrSplit[0]);
                        int i13 = Integer.parseInt(strArrSplit[1]);
                        int i14 = Integer.parseInt(strArrSplit[2]);
                        int i15 = (int) ((i12 / 1080.0f) * width);
                        int i16 = (int) ((i13 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f10 = i15;
                        float f11 = i16;
                        float f12 = i15 + ((int) ((i14 / 1080.0f) * width));
                        canvas.drawLine(f10, f11, f12, f11, paint);
                        float f13 = i16 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f12, f11, f12, f13, paint);
                        canvas.drawLine(f12, f13, f10, f13, paint);
                        canvas.drawLine(f10, f13, f10, f11, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f10, f11, f12, f13, paint);
                        canvas.drawLine(f10, f13, f12, f11, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void forceLayout() {
        r();
        super.forceLayout();
    }

    public int getMaxHeight() {
        return this.f1344g;
    }

    public int getMaxWidth() {
        return this.f1343f;
    }

    public int getMinHeight() {
        return this.f1342e;
    }

    public int getMinWidth() {
        return this.f1341d;
    }

    public int getOptimizationLevel() {
        return this.f1340c.F1();
    }

    public String getSceneString() {
        int id2;
        StringBuilder sb2 = new StringBuilder();
        if (this.f1340c.f3485o == null) {
            int id3 = getId();
            if (id3 != -1) {
                this.f1340c.f3485o = getContext().getResources().getResourceEntryName(id3);
            } else {
                this.f1340c.f3485o = "parent";
            }
        }
        if (this.f1340c.r() == null) {
            f fVar = this.f1340c;
            fVar.z0(fVar.f3485o);
            Log.v("ConstraintLayout", " setDebugName " + this.f1340c.r());
        }
        for (c0.e eVar : this.f1340c.n1()) {
            View view = (View) eVar.q();
            if (view != null) {
                if (eVar.f3485o == null && (id2 = view.getId()) != -1) {
                    eVar.f3485o = getContext().getResources().getResourceEntryName(id2);
                }
                if (eVar.r() == null) {
                    eVar.z0(eVar.f3485o);
                    Log.v("ConstraintLayout", " setDebugName " + eVar.r());
                }
            }
        }
        this.f1340c.M(sb2);
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x017d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void i(boolean r15, android.view.View r16, c0.e r17, androidx.constraintlayout.widget.ConstraintLayout.b r18, android.util.SparseArray r19) {
        /*
            Method dump skipped, instruction units count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.i(boolean, android.view.View, c0.e, androidx.constraintlayout.widget.ConstraintLayout$b, android.util.SparseArray):void");
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public b generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    @Override // android.view.ViewGroup
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    public Object l(int i10, Object obj) {
        if (i10 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap map = this.f1350m;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return this.f1350m.get(str);
    }

    public final c0.e m(int i10) {
        if (i10 == 0) {
            return this.f1340c;
        }
        View viewFindViewById = (View) this.f1338a.get(i10);
        if (viewFindViewById == null && (viewFindViewById = findViewById(i10)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
            onViewAdded(viewFindViewById);
        }
        if (viewFindViewById == this) {
            return this.f1340c;
        }
        if (viewFindViewById == null) {
            return null;
        }
        return ((b) viewFindViewById.getLayoutParams()).f1405v0;
    }

    public View n(int i10) {
        return (View) this.f1338a.get(i10);
    }

    public final c0.e o(View view) {
        if (view == this) {
            return this.f1340c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f1405v0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof b) {
            return ((b) view.getLayoutParams()).f1405v0;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            b bVar = (b) childAt.getLayoutParams();
            c0.e eVar = bVar.f1405v0;
            if ((childAt.getVisibility() != 8 || bVar.f1377h0 || bVar.f1379i0 || bVar.f1383k0 || zIsInEditMode) && !bVar.f1381j0) {
                int iV = eVar.V();
                int iW = eVar.W();
                childAt.layout(iV, iW, eVar.U() + iV, eVar.v() + iW);
            }
        }
        int size = this.f1339b.size();
        if (size > 0) {
            for (int i15 = 0; i15 < size; i15++) {
                ((androidx.constraintlayout.widget.c) this.f1339b.get(i15)).i(this);
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1359v == i10) {
            int i12 = this.f1360w;
        }
        if (!this.f1345h) {
            int childCount = getChildCount();
            int i13 = 0;
            while (true) {
                if (i13 >= childCount) {
                    break;
                }
                if (getChildAt(i13).isLayoutRequested()) {
                    this.f1345h = true;
                    break;
                }
                i13++;
            }
        }
        this.f1359v = i10;
        this.f1360w = i11;
        this.f1340c.T1(q());
        if (this.f1345h) {
            this.f1345h = false;
            if (z()) {
                this.f1340c.V1();
            }
        }
        u(this.f1340c, this.f1346i, i10, i11);
        t(i10, i11, this.f1340c.U(), this.f1340c.v(), this.f1340c.L1(), this.f1340c.J1());
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        c0.e eVarO = o(view);
        if ((view instanceof e) && !(eVarO instanceof g)) {
            b bVar = (b) view.getLayoutParams();
            g gVar = new g();
            bVar.f1405v0 = gVar;
            bVar.f1377h0 = true;
            gVar.w1(bVar.Z);
        }
        if (view instanceof androidx.constraintlayout.widget.c) {
            androidx.constraintlayout.widget.c cVar = (androidx.constraintlayout.widget.c) view;
            cVar.m();
            ((b) view.getLayoutParams()).f1379i0 = true;
            if (!this.f1339b.contains(cVar)) {
                this.f1339b.add(cVar);
            }
        }
        this.f1338a.put(view.getId(), view);
        this.f1345h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f1338a.remove(view.getId());
        this.f1340c.p1(o(view));
        this.f1339b.remove(view);
        this.f1345h = true;
    }

    public final void p(AttributeSet attributeSet, int i10, int i11) {
        this.f1340c.y0(this);
        this.f1340c.Q1(this.f1358u);
        this.f1338a.put(getId(), this);
        this.f1347j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f0.d.f9171n1, i10, i11);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i12 = 0; i12 < indexCount; i12++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i12);
                if (index == f0.d.f9203r1) {
                    this.f1341d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1341d);
                } else if (index == f0.d.f9211s1) {
                    this.f1342e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1342e);
                } else if (index == f0.d.f9187p1) {
                    this.f1343f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1343f);
                } else if (index == f0.d.f9195q1) {
                    this.f1344g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1344g);
                } else if (index == f0.d.F2) {
                    this.f1346i = typedArrayObtainStyledAttributes.getInt(index, this.f1346i);
                } else if (index == f0.d.A1) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            s(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f1348k = null;
                        }
                    }
                } else if (index == f0.d.f9243w1) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        d dVar = new d();
                        this.f1347j = dVar;
                        dVar.h(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f1347j = null;
                    }
                    this.f1349l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f1340c.R1(this.f1346i);
    }

    public boolean q() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public final void r() {
        this.f1345h = true;
        this.f1351n = -1;
        this.f1352o = -1;
        this.f1353p = -1;
        this.f1354q = -1;
        this.f1355r = 0;
        this.f1356s = 0;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        r();
        super.requestLayout();
    }

    public void s(int i10) {
        this.f1348k = new f0.a(getContext(), this, i10);
    }

    public void setConstraintSet(d dVar) {
        this.f1347j = dVar;
    }

    @Override // android.view.View
    public void setId(int i10) {
        this.f1338a.remove(getId());
        super.setId(i10);
        this.f1338a.put(getId(), this);
    }

    public void setMaxHeight(int i10) {
        if (i10 == this.f1344g) {
            return;
        }
        this.f1344g = i10;
        requestLayout();
    }

    public void setMaxWidth(int i10) {
        if (i10 == this.f1343f) {
            return;
        }
        this.f1343f = i10;
        requestLayout();
    }

    public void setMinHeight(int i10) {
        if (i10 == this.f1342e) {
            return;
        }
        this.f1342e = i10;
        requestLayout();
    }

    public void setMinWidth(int i10) {
        if (i10 == this.f1341d) {
            return;
        }
        this.f1341d = i10;
        requestLayout();
    }

    public void setOnConstraintsChanged(f0.b bVar) {
        f0.a aVar = this.f1348k;
        if (aVar != null) {
            aVar.c(bVar);
        }
    }

    public void setOptimizationLevel(int i10) {
        this.f1346i = i10;
        this.f1340c.R1(i10);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void t(int i10, int i11, int i12, int i13, boolean z10, boolean z11) {
        c cVar = this.f1358u;
        int i14 = cVar.f1416e;
        int iResolveSizeAndState = View.resolveSizeAndState(i12 + cVar.f1415d, i10, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i13 + i14, i11, 0) & 16777215;
        int iMin = Math.min(this.f1343f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f1344g, iResolveSizeAndState2);
        if (z10) {
            iMin |= 16777216;
        }
        if (z11) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
        this.f1351n = iMin;
        this.f1352o = iMin2;
    }

    public void u(f fVar, int i10, int i11, int i12) {
        int i13;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int iMax = Math.max(0, getPaddingTop());
        int iMax2 = Math.max(0, getPaddingBottom());
        int i14 = iMax + iMax2;
        int paddingWidth = getPaddingWidth();
        this.f1358u.c(i11, i12, iMax, iMax2, paddingWidth, i14);
        int iMax3 = Math.max(0, getPaddingStart());
        int iMax4 = Math.max(0, getPaddingEnd());
        if (iMax3 > 0 || iMax4 > 0) {
            if (q()) {
                i13 = iMax4;
            }
            int i15 = size - paddingWidth;
            int i16 = size2 - i14;
            x(fVar, mode, i15, mode2, i16);
            fVar.M1(i10, mode, i15, mode2, i16, this.f1351n, this.f1352o, i13, iMax);
        }
        iMax3 = Math.max(0, getPaddingLeft());
        i13 = iMax3;
        int i152 = size - paddingWidth;
        int i162 = size2 - i14;
        x(fVar, mode, i152, mode2, i162);
        fVar.M1(i10, mode, i152, mode2, i162, this.f1351n, this.f1352o, i13, iMax);
    }

    public final void v() {
        boolean zIsInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            c0.e eVarO = o(getChildAt(i10));
            if (eVarO != null) {
                eVarO.r0();
            }
        }
        if (zIsInEditMode) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = getChildAt(i11);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    w(0, resourceName, Integer.valueOf(childAt.getId()));
                    int iIndexOf = resourceName.indexOf(47);
                    if (iIndexOf != -1) {
                        resourceName = resourceName.substring(iIndexOf + 1);
                    }
                    m(childAt.getId()).z0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.f1349l != -1) {
            for (int i12 = 0; i12 < childCount; i12++) {
                getChildAt(i12).getId();
            }
        }
        d dVar = this.f1347j;
        if (dVar != null) {
            dVar.c(this, true);
        }
        this.f1340c.q1();
        int size = this.f1339b.size();
        if (size > 0) {
            for (int i13 = 0; i13 < size; i13++) {
                ((androidx.constraintlayout.widget.c) this.f1339b.get(i13)).l(this);
            }
        }
        for (int i14 = 0; i14 < childCount; i14++) {
            getChildAt(i14);
        }
        this.f1357t.clear();
        this.f1357t.put(0, this.f1340c);
        this.f1357t.put(getId(), this.f1340c);
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            this.f1357t.put(childAt2.getId(), o(childAt2));
        }
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt3 = getChildAt(i16);
            c0.e eVarO2 = o(childAt3);
            if (eVarO2 != null) {
                b bVar = (b) childAt3.getLayoutParams();
                this.f1340c.a(eVarO2);
                i(zIsInEditMode, childAt3, eVarO2, bVar, this.f1357t);
            }
        }
    }

    public void w(int i10, Object obj, Object obj2) {
        if (i10 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.f1350m == null) {
                this.f1350m = new HashMap();
            }
            String strSubstring = (String) obj;
            int iIndexOf = strSubstring.indexOf("/");
            if (iIndexOf != -1) {
                strSubstring = strSubstring.substring(iIndexOf + 1);
            }
            this.f1350m.put(strSubstring, (Integer) obj2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e A[PHI: r2
      0x003e: PHI (r2v4 c0.e$b) = (r2v3 c0.e$b), (r2v0 c0.e$b) binds: [B:21:0x004a, B:17:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void x(c0.f r8, int r9, int r10, int r11, int r12) {
        /*
            r7 = this;
            androidx.constraintlayout.widget.ConstraintLayout$c r0 = r7.f1358u
            int r1 = r0.f1416e
            int r0 = r0.f1415d
            c0.e$b r2 = c0.e.b.FIXED
            int r3 = r7.getChildCount()
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r9 == r6) goto L2e
            if (r9 == 0) goto L23
            if (r9 == r4) goto L1a
            r9 = r2
        L18:
            r10 = r5
            goto L38
        L1a:
            int r9 = r7.f1343f
            int r9 = r9 - r0
            int r10 = java.lang.Math.min(r9, r10)
            r9 = r2
            goto L38
        L23:
            c0.e$b r9 = c0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L18
            int r10 = r7.f1341d
            int r10 = java.lang.Math.max(r5, r10)
            goto L38
        L2e:
            c0.e$b r9 = c0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L38
            int r10 = r7.f1341d
            int r10 = java.lang.Math.max(r5, r10)
        L38:
            if (r11 == r6) goto L53
            if (r11 == 0) goto L48
            if (r11 == r4) goto L40
        L3e:
            r12 = r5
            goto L5d
        L40:
            int r11 = r7.f1344g
            int r11 = r11 - r1
            int r12 = java.lang.Math.min(r11, r12)
            goto L5d
        L48:
            c0.e$b r2 = c0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L3e
            int r11 = r7.f1342e
            int r12 = java.lang.Math.max(r5, r11)
            goto L5d
        L53:
            c0.e$b r2 = c0.e.b.WRAP_CONTENT
            if (r3 != 0) goto L5d
            int r11 = r7.f1342e
            int r12 = java.lang.Math.max(r5, r11)
        L5d:
            int r11 = r8.U()
            if (r10 != r11) goto L69
            int r11 = r8.v()
            if (r12 == r11) goto L6c
        L69:
            r8.I1()
        L6c:
            r8.i1(r5)
            r8.j1(r5)
            int r11 = r7.f1343f
            int r11 = r11 - r0
            r8.T0(r11)
            int r11 = r7.f1344g
            int r11 = r11 - r1
            r8.S0(r11)
            r8.W0(r5)
            r8.V0(r5)
            r8.M0(r9)
            r8.g1(r10)
            r8.c1(r2)
            r8.I0(r12)
            int r9 = r7.f1341d
            int r9 = r9 - r0
            r8.W0(r9)
            int r9 = r7.f1342e
            int r9 = r9 - r1
            r8.V0(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.x(c0.f, int, int, int, int):void");
    }

    public final void y(c0.e eVar, b bVar, SparseArray sparseArray, int i10, d.b bVar2) {
        View view = (View) this.f1338a.get(i10);
        c0.e eVar2 = (c0.e) sparseArray.get(i10);
        if (eVar2 == null || view == null || !(view.getLayoutParams() instanceof b)) {
            return;
        }
        bVar.f1375g0 = true;
        d.b bVar3 = d.b.BASELINE;
        if (bVar2 == bVar3) {
            b bVar4 = (b) view.getLayoutParams();
            bVar4.f1375g0 = true;
            bVar4.f1405v0.H0(true);
        }
        eVar.m(bVar3).a(eVar2.m(bVar2), bVar.D, bVar.C, true);
        eVar.H0(true);
        eVar.m(d.b.TOP).p();
        eVar.m(d.b.BOTTOM).p();
    }

    public final boolean z() {
        int childCount = getChildCount();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= childCount) {
                break;
            }
            if (getChildAt(i10).isLayoutRequested()) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (z10) {
            v();
        }
        return z10;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean E;
        public boolean F;
        public float G;
        public float H;
        public String I;
        public float J;
        public int K;
        public float L;
        public float M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;
        public int T;
        public int U;
        public float V;
        public float W;
        public int X;
        public int Y;
        public int Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1362a;

        /* JADX INFO: renamed from: a0, reason: collision with root package name */
        public boolean f1363a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1364b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public boolean f1365b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f1366c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public String f1367c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f1368d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f1369d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f1370e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public boolean f1371e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1372f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public boolean f1373f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f1374g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public boolean f1375g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f1376h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public boolean f1377h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f1378i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public boolean f1379i0;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f1380j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public boolean f1381j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f1382k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public boolean f1383k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f1384l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public int f1385l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f1386m;

        /* JADX INFO: renamed from: m0, reason: collision with root package name */
        public int f1387m0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f1388n;

        /* JADX INFO: renamed from: n0, reason: collision with root package name */
        public int f1389n0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f1390o;

        /* JADX INFO: renamed from: o0, reason: collision with root package name */
        public int f1391o0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f1392p;

        /* JADX INFO: renamed from: p0, reason: collision with root package name */
        public int f1393p0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f1394q;

        /* JADX INFO: renamed from: q0, reason: collision with root package name */
        public int f1395q0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public float f1396r;

        /* JADX INFO: renamed from: r0, reason: collision with root package name */
        public float f1397r0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f1398s;

        /* JADX INFO: renamed from: s0, reason: collision with root package name */
        public int f1399s0;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f1400t;

        /* JADX INFO: renamed from: t0, reason: collision with root package name */
        public int f1401t0;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f1402u;

        /* JADX INFO: renamed from: u0, reason: collision with root package name */
        public float f1403u0;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f1404v;

        /* JADX INFO: renamed from: v0, reason: collision with root package name */
        public c0.e f1405v0;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f1406w;

        /* JADX INFO: renamed from: w0, reason: collision with root package name */
        public boolean f1407w0;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f1408x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f1409y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f1410z;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f1411a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f1411a = sparseIntArray;
                sparseIntArray.append(f0.d.f9196q2, 64);
                sparseIntArray.append(f0.d.T1, 65);
                sparseIntArray.append(f0.d.f9073c2, 8);
                sparseIntArray.append(f0.d.f9082d2, 9);
                sparseIntArray.append(f0.d.f9100f2, 10);
                sparseIntArray.append(f0.d.f9109g2, 11);
                sparseIntArray.append(f0.d.f9163m2, 12);
                sparseIntArray.append(f0.d.f9154l2, 13);
                sparseIntArray.append(f0.d.J1, 14);
                sparseIntArray.append(f0.d.I1, 15);
                sparseIntArray.append(f0.d.E1, 16);
                sparseIntArray.append(f0.d.G1, 52);
                sparseIntArray.append(f0.d.F1, 53);
                sparseIntArray.append(f0.d.K1, 2);
                sparseIntArray.append(f0.d.M1, 3);
                sparseIntArray.append(f0.d.L1, 4);
                sparseIntArray.append(f0.d.f9236v2, 49);
                sparseIntArray.append(f0.d.f9244w2, 50);
                sparseIntArray.append(f0.d.Q1, 5);
                sparseIntArray.append(f0.d.R1, 6);
                sparseIntArray.append(f0.d.S1, 7);
                sparseIntArray.append(f0.d.f9267z1, 67);
                sparseIntArray.append(f0.d.f9179o1, 1);
                sparseIntArray.append(f0.d.f9118h2, 17);
                sparseIntArray.append(f0.d.f9127i2, 18);
                sparseIntArray.append(f0.d.P1, 19);
                sparseIntArray.append(f0.d.O1, 20);
                sparseIntArray.append(f0.d.A2, 21);
                sparseIntArray.append(f0.d.D2, 22);
                sparseIntArray.append(f0.d.B2, 23);
                sparseIntArray.append(f0.d.f9260y2, 24);
                sparseIntArray.append(f0.d.C2, 25);
                sparseIntArray.append(f0.d.f9268z2, 26);
                sparseIntArray.append(f0.d.f9252x2, 55);
                sparseIntArray.append(f0.d.E2, 54);
                sparseIntArray.append(f0.d.Y1, 29);
                sparseIntArray.append(f0.d.f9172n2, 30);
                sparseIntArray.append(f0.d.N1, 44);
                sparseIntArray.append(f0.d.f9055a2, 45);
                sparseIntArray.append(f0.d.f9188p2, 46);
                sparseIntArray.append(f0.d.Z1, 47);
                sparseIntArray.append(f0.d.f9180o2, 48);
                sparseIntArray.append(f0.d.C1, 27);
                sparseIntArray.append(f0.d.B1, 28);
                sparseIntArray.append(f0.d.f9204r2, 31);
                sparseIntArray.append(f0.d.U1, 32);
                sparseIntArray.append(f0.d.f9220t2, 33);
                sparseIntArray.append(f0.d.f9212s2, 34);
                sparseIntArray.append(f0.d.f9228u2, 35);
                sparseIntArray.append(f0.d.W1, 36);
                sparseIntArray.append(f0.d.V1, 37);
                sparseIntArray.append(f0.d.X1, 38);
                sparseIntArray.append(f0.d.f9064b2, 39);
                sparseIntArray.append(f0.d.f9145k2, 40);
                sparseIntArray.append(f0.d.f9091e2, 41);
                sparseIntArray.append(f0.d.H1, 42);
                sparseIntArray.append(f0.d.D1, 43);
                sparseIntArray.append(f0.d.f9136j2, 51);
                sparseIntArray.append(f0.d.G2, 66);
            }
        }

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1362a = -1;
            this.f1364b = -1;
            this.f1366c = -1.0f;
            this.f1368d = true;
            this.f1370e = -1;
            this.f1372f = -1;
            this.f1374g = -1;
            this.f1376h = -1;
            this.f1378i = -1;
            this.f1380j = -1;
            this.f1382k = -1;
            this.f1384l = -1;
            this.f1386m = -1;
            this.f1388n = -1;
            this.f1390o = -1;
            this.f1392p = -1;
            this.f1394q = 0;
            this.f1396r = 0.0f;
            this.f1398s = -1;
            this.f1400t = -1;
            this.f1402u = -1;
            this.f1404v = -1;
            this.f1406w = Integer.MIN_VALUE;
            this.f1408x = Integer.MIN_VALUE;
            this.f1409y = Integer.MIN_VALUE;
            this.f1410z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f1363a0 = false;
            this.f1365b0 = false;
            this.f1367c0 = null;
            this.f1369d0 = 0;
            this.f1371e0 = true;
            this.f1373f0 = true;
            this.f1375g0 = false;
            this.f1377h0 = false;
            this.f1379i0 = false;
            this.f1381j0 = false;
            this.f1383k0 = false;
            this.f1385l0 = -1;
            this.f1387m0 = -1;
            this.f1389n0 = -1;
            this.f1391o0 = -1;
            this.f1393p0 = Integer.MIN_VALUE;
            this.f1395q0 = Integer.MIN_VALUE;
            this.f1397r0 = 0.5f;
            this.f1405v0 = new c0.e();
            this.f1407w0 = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f0.d.f9171n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = a.f1411a.get(index);
                switch (i11) {
                    case 1:
                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f1392p);
                        this.f1392p = resourceId;
                        if (resourceId == -1) {
                            this.f1392p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f1394q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1394q);
                        break;
                    case 4:
                        float f10 = typedArrayObtainStyledAttributes.getFloat(index, this.f1396r) % 360.0f;
                        this.f1396r = f10;
                        if (f10 < 0.0f) {
                            this.f1396r = (360.0f - f10) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f1362a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1362a);
                        break;
                    case 6:
                        this.f1364b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f1364b);
                        break;
                    case 7:
                        this.f1366c = typedArrayObtainStyledAttributes.getFloat(index, this.f1366c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1370e);
                        this.f1370e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f1370e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1372f);
                        this.f1372f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f1372f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1374g);
                        this.f1374g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f1374g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1376h);
                        this.f1376h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f1376h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1378i);
                        this.f1378i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f1378i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1380j);
                        this.f1380j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f1380j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1382k);
                        this.f1382k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f1382k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1384l);
                        this.f1384l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f1384l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1386m);
                        this.f1386m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f1386m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1398s);
                        this.f1398s = resourceId11;
                        if (resourceId11 == -1) {
                            this.f1398s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1400t);
                        this.f1400t = resourceId12;
                        if (resourceId12 == -1) {
                            this.f1400t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1402u);
                        this.f1402u = resourceId13;
                        if (resourceId13 == -1) {
                            this.f1402u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1404v);
                        this.f1404v = resourceId14;
                        if (resourceId14 == -1) {
                            this.f1404v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case Build.API_LEVELS.API_21 /* 21 */:
                        this.f1406w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1406w);
                        break;
                    case Build.API_LEVELS.API_22 /* 22 */:
                        this.f1408x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1408x);
                        break;
                    case Build.API_LEVELS.API_23 /* 23 */:
                        this.f1409y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1409y);
                        break;
                    case 24:
                        this.f1410z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f1410z);
                        break;
                    case Build.API_LEVELS.API_25 /* 25 */:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case Build.API_LEVELS.API_26 /* 26 */:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case Build.API_LEVELS.API_27 /* 27 */:
                        this.f1363a0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1363a0);
                        break;
                    case Build.API_LEVELS.API_28 /* 28 */:
                        this.f1365b0 = typedArrayObtainStyledAttributes.getBoolean(index, this.f1365b0);
                        break;
                    case Build.API_LEVELS.API_29 /* 29 */:
                        this.G = typedArrayObtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case Build.API_LEVELS.API_30 /* 30 */:
                        this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                        break;
                    case Build.API_LEVELS.API_31 /* 31 */:
                        int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.P = i12;
                        if (i12 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i13 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.Q = i13;
                        if (i13 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case Build.API_LEVELS.API_33 /* 33 */:
                        try {
                            this.R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.R);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.R) == -2) {
                                this.R = -2;
                            }
                        }
                        break;
                    case Build.API_LEVELS.API_34 /* 34 */:
                        try {
                            this.T = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.T);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.T) == -2) {
                                this.T = -2;
                            }
                        }
                        break;
                    case Build.API_LEVELS.API_35 /* 35 */:
                        this.V = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    case Build.API_LEVELS.API_36 /* 36 */:
                        try {
                            this.S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.S);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.S) == -2) {
                                this.S = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.U = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.U);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.U) == -2) {
                                this.U = -2;
                            }
                        }
                        break;
                    case 38:
                        this.W = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.W));
                        this.Q = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                d.m(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.L = typedArrayObtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 46:
                                this.M = typedArrayObtainStyledAttributes.getFloat(index, this.M);
                                break;
                            case 47:
                                this.N = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.O = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case PurchaseParamsValidator.MAX_NUMBER_OF_ADD_ON_PRODUCTS /* 49 */:
                                this.X = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                                this.Y = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.Y);
                                break;
                            case 51:
                                this.f1367c0 = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1388n);
                                this.f1388n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.f1388n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.f1390o);
                                this.f1390o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.f1390o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                }
                                break;
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i11) {
                                    case 64:
                                        d.k(this, typedArrayObtainStyledAttributes, index, 0);
                                        this.E = true;
                                        break;
                                    case 65:
                                        d.k(this, typedArrayObtainStyledAttributes, index, 1);
                                        this.F = true;
                                        break;
                                    case 66:
                                        this.f1369d0 = typedArrayObtainStyledAttributes.getInt(index, this.f1369d0);
                                        break;
                                    case 67:
                                        this.f1368d = typedArrayObtainStyledAttributes.getBoolean(index, this.f1368d);
                                        break;
                                }
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public void a() {
            this.f1377h0 = false;
            this.f1371e0 = true;
            this.f1373f0 = true;
            int i10 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i10 == -2 && this.f1363a0) {
                this.f1371e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            int i11 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i11 == -2 && this.f1365b0) {
                this.f1373f0 = false;
                if (this.Q == 0) {
                    this.Q = 1;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f1371e0 = false;
                if (i10 == 0 && this.P == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f1363a0 = true;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f1373f0 = false;
                if (i11 == 0 && this.Q == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f1365b0 = true;
                }
            }
            if (this.f1366c == -1.0f && this.f1362a == -1 && this.f1364b == -1) {
                return;
            }
            this.f1377h0 = true;
            this.f1371e0 = true;
            this.f1373f0 = true;
            if (!(this.f1405v0 instanceof g)) {
                this.f1405v0 = new g();
            }
            ((g) this.f1405v0).w1(this.Z);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instruction units count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.b.resolveLayoutDirection(int):void");
        }

        public b(int i10, int i11) {
            super(i10, i11);
            this.f1362a = -1;
            this.f1364b = -1;
            this.f1366c = -1.0f;
            this.f1368d = true;
            this.f1370e = -1;
            this.f1372f = -1;
            this.f1374g = -1;
            this.f1376h = -1;
            this.f1378i = -1;
            this.f1380j = -1;
            this.f1382k = -1;
            this.f1384l = -1;
            this.f1386m = -1;
            this.f1388n = -1;
            this.f1390o = -1;
            this.f1392p = -1;
            this.f1394q = 0;
            this.f1396r = 0.0f;
            this.f1398s = -1;
            this.f1400t = -1;
            this.f1402u = -1;
            this.f1404v = -1;
            this.f1406w = Integer.MIN_VALUE;
            this.f1408x = Integer.MIN_VALUE;
            this.f1409y = Integer.MIN_VALUE;
            this.f1410z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f1363a0 = false;
            this.f1365b0 = false;
            this.f1367c0 = null;
            this.f1369d0 = 0;
            this.f1371e0 = true;
            this.f1373f0 = true;
            this.f1375g0 = false;
            this.f1377h0 = false;
            this.f1379i0 = false;
            this.f1381j0 = false;
            this.f1383k0 = false;
            this.f1385l0 = -1;
            this.f1387m0 = -1;
            this.f1389n0 = -1;
            this.f1391o0 = -1;
            this.f1393p0 = Integer.MIN_VALUE;
            this.f1395q0 = Integer.MIN_VALUE;
            this.f1397r0 = 0.5f;
            this.f1405v0 = new c0.e();
            this.f1407w0 = false;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1362a = -1;
            this.f1364b = -1;
            this.f1366c = -1.0f;
            this.f1368d = true;
            this.f1370e = -1;
            this.f1372f = -1;
            this.f1374g = -1;
            this.f1376h = -1;
            this.f1378i = -1;
            this.f1380j = -1;
            this.f1382k = -1;
            this.f1384l = -1;
            this.f1386m = -1;
            this.f1388n = -1;
            this.f1390o = -1;
            this.f1392p = -1;
            this.f1394q = 0;
            this.f1396r = 0.0f;
            this.f1398s = -1;
            this.f1400t = -1;
            this.f1402u = -1;
            this.f1404v = -1;
            this.f1406w = Integer.MIN_VALUE;
            this.f1408x = Integer.MIN_VALUE;
            this.f1409y = Integer.MIN_VALUE;
            this.f1410z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = true;
            this.F = true;
            this.G = 0.5f;
            this.H = 0.5f;
            this.I = null;
            this.J = 0.0f;
            this.K = 1;
            this.L = -1.0f;
            this.M = -1.0f;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 0;
            this.S = 0;
            this.T = 0;
            this.U = 0;
            this.V = 1.0f;
            this.W = 1.0f;
            this.X = -1;
            this.Y = -1;
            this.Z = -1;
            this.f1363a0 = false;
            this.f1365b0 = false;
            this.f1367c0 = null;
            this.f1369d0 = 0;
            this.f1371e0 = true;
            this.f1373f0 = true;
            this.f1375g0 = false;
            this.f1377h0 = false;
            this.f1379i0 = false;
            this.f1381j0 = false;
            this.f1383k0 = false;
            this.f1385l0 = -1;
            this.f1387m0 = -1;
            this.f1389n0 = -1;
            this.f1391o0 = -1;
            this.f1393p0 = Integer.MIN_VALUE;
            this.f1395q0 = Integer.MIN_VALUE;
            this.f1397r0 = 0.5f;
            this.f1405v0 = new c0.e();
            this.f1407w0 = false;
        }
    }
}
