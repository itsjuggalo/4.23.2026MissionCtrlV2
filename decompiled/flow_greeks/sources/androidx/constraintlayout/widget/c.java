package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import c0.h;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f1441a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1442b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f1443c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f1444d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1445e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f1446f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f1447g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f1448h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f1449i;

    public c(Context context) {
        super(context);
        this.f1441a = new int[32];
        this.f1445e = false;
        this.f1448h = null;
        this.f1449i = new HashMap();
        this.f1443c = context;
        g(null);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0 || this.f1443c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iF = f(strTrim);
        if (iF != 0) {
            this.f1449i.put(Integer.valueOf(iF), strTrim);
            b(iF);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    public final void b(int i10) {
        if (i10 == getId()) {
            return;
        }
        int i11 = this.f1442b + 1;
        int[] iArr = this.f1441a;
        if (i11 > iArr.length) {
            this.f1441a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1441a;
        int i12 = this.f1442b;
        iArr2[i12] = i10;
        this.f1442b = i12 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.f1443c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).f1367c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public final int e(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f1443c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = constraintLayout.getChildAt(i10);
            if (childAt.getId() != -1) {
                try {
                    resourceEntryName = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = null;
                }
                if (str.equals(resourceEntryName)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public final int f(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iE = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objL = constraintLayout.l(0, str);
            if (objL instanceof Integer) {
                iE = ((Integer) objL).intValue();
            }
        }
        if (iE == 0 && constraintLayout != null) {
            iE = e(constraintLayout, str);
        }
        if (iE == 0) {
            try {
                iE = f0.c.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iE == 0 ? this.f1443c.getResources().getIdentifier(str, DiagnosticsEntry.ID_KEY, this.f1443c.getPackageName()) : iE;
    }

    public void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, f0.d.f9171n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == f0.d.f9251x1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f1446f = string;
                    setIds(string);
                } else if (index == f0.d.f9259y1) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f1447g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1441a, this.f1442b);
    }

    public abstract void h(c0.e eVar, boolean z10);

    public void l(ConstraintLayout constraintLayout) {
        String str;
        int iE;
        if (isInEditMode()) {
            setIds(this.f1446f);
        }
        h hVar = this.f1444d;
        if (hVar == null) {
            return;
        }
        hVar.b();
        for (int i10 = 0; i10 < this.f1442b; i10++) {
            int i11 = this.f1441a[i10];
            View viewN = constraintLayout.n(i11);
            if (viewN == null && (iE = e(constraintLayout, (str = (String) this.f1449i.get(Integer.valueOf(i11))))) != 0) {
                this.f1441a[i10] = iE;
                this.f1449i.put(Integer.valueOf(iE), str);
                viewN = constraintLayout.n(iE);
            }
            if (viewN != null) {
                this.f1444d.a(constraintLayout.o(viewN));
            }
        }
        this.f1444d.c(constraintLayout.f1340c);
    }

    public void m() {
        if (this.f1444d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f1405v0 = (c0.e) this.f1444d;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1446f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f1447g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f1445e) {
            super.onMeasure(i10, i11);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String str) {
        this.f1446f = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f1442b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                a(str.substring(i10));
                return;
            } else {
                a(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f1447g = str;
        if (str == null) {
            return;
        }
        int i10 = 0;
        this.f1442b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i10);
            if (iIndexOf == -1) {
                c(str.substring(i10));
                return;
            } else {
                c(str.substring(i10, iIndexOf));
                i10 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1446f = null;
        this.f1442b = 0;
        for (int i10 : iArr) {
            b(i10);
        }
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        super.setTag(i10, obj);
        if (obj == null && this.f1446f == null) {
            b(i10);
        }
    }

    public void d(ConstraintLayout constraintLayout) {
    }

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public void k(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }
}
