package androidx.constraintlayout.widget;

import C.h;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f10935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f10936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f10937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f10938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f10939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f10940f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f10941g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View[] f10942h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public HashMap f10943i;

    public c(Context context) {
        super(context);
        this.f10935a = new int[32];
        this.f10939e = false;
        this.f10942h = null;
        this.f10943i = new HashMap();
        this.f10937c = context;
        g(null);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0 || this.f10937c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iF = f(strTrim);
        if (iF != 0) {
            this.f10943i.put(Integer.valueOf(iF), strTrim);
            b(iF);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    public final void b(int i8) {
        if (i8 == getId()) {
            return;
        }
        int i9 = this.f10936b + 1;
        int[] iArr = this.f10935a;
        if (i9 > iArr.length) {
            this.f10935a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f10935a;
        int i10 = this.f10936b;
        iArr2[i10] = i8;
        this.f10936b = i10 + 1;
    }

    public final void c(String str) {
        if (str == null || str.length() == 0 || this.f10937c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.b) && strTrim.equals(((ConstraintLayout.b) layoutParams).f10861c0)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    b(childAt.getId());
                }
            }
        }
    }

    public void d(ConstraintLayout constraintLayout) {
    }

    public final int e(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f10937c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = constraintLayout.getChildAt(i8);
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
                iE = F.c.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iE == 0 ? this.f10937c.getResources().getIdentifier(str, DiagnosticsEntry.ID_KEY, this.f10937c.getPackageName()) : iE;
    }

    public void g(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, F.d.f1394n1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == F.d.f1474x1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f10940f = string;
                    setIds(string);
                } else if (index == F.d.f1482y1) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f10941g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f10935a, this.f10936b);
    }

    public abstract void h(C.e eVar, boolean z7);

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) {
    }

    public void k(ConstraintLayout constraintLayout) {
    }

    public void l(ConstraintLayout constraintLayout) {
        String str;
        int iE;
        if (isInEditMode()) {
            setIds(this.f10940f);
        }
        h hVar = this.f10938d;
        if (hVar == null) {
            return;
        }
        hVar.b();
        for (int i8 = 0; i8 < this.f10936b; i8++) {
            int i9 = this.f10935a[i8];
            View viewN = constraintLayout.n(i9);
            if (viewN == null && (iE = e(constraintLayout, (str = (String) this.f10943i.get(Integer.valueOf(i9))))) != 0) {
                this.f10935a[i8] = iE;
                this.f10943i.put(Integer.valueOf(iE), str);
                viewN = constraintLayout.n(iE);
            }
            if (viewN != null) {
                this.f10938d.a(constraintLayout.o(viewN));
            }
        }
        this.f10938d.c(constraintLayout.f10808c);
    }

    public void m() {
        if (this.f10938d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f10899v0 = (C.e) this.f10938d;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f10940f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f10941g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i8, int i9) {
        if (this.f10939e) {
            super.onMeasure(i8, i9);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String str) {
        this.f10940f = str;
        if (str == null) {
            return;
        }
        int i8 = 0;
        this.f10936b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i8);
            if (iIndexOf == -1) {
                a(str.substring(i8));
                return;
            } else {
                a(str.substring(i8, iIndexOf));
                i8 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f10941g = str;
        if (str == null) {
            return;
        }
        int i8 = 0;
        this.f10936b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i8);
            if (iIndexOf == -1) {
                c(str.substring(i8));
                return;
            } else {
                c(str.substring(i8, iIndexOf));
                i8 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f10940f = null;
        this.f10936b = 0;
        for (int i8 : iArr) {
            b(i8);
        }
    }

    @Override // android.view.View
    public void setTag(int i8, Object obj) {
        super.setTag(i8, obj);
        if (obj == null && this.f10940f == null) {
            b(i8);
        }
    }
}
