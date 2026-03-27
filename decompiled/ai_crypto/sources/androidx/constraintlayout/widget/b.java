package androidx.constraintlayout.widget;

import B.d;
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
import z.e;
import z.h;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f7097a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7098b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f7099c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public h f7100d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f7102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View[] f7103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public HashMap f7104h;

    public b(Context context) {
        super(context);
        this.f7097a = new int[32];
        this.f7101e = false;
        this.f7103g = null;
        this.f7104h = new HashMap();
        this.f7099c = context;
        e(null);
    }

    public final void a(String str) {
        if (str == null || str.length() == 0 || this.f7099c == null) {
            return;
        }
        String strTrim = str.trim();
        if (getParent() instanceof ConstraintLayout) {
        }
        int iD = d(strTrim);
        if (iD != 0) {
            this.f7104h.put(Integer.valueOf(iD), strTrim);
            b(iD);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
    }

    public final void b(int i7) {
        if (i7 == getId()) {
            return;
        }
        int i8 = this.f7098b + 1;
        int[] iArr = this.f7097a;
        if (i8 > iArr.length) {
            this.f7097a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f7097a;
        int i9 = this.f7098b;
        iArr2[i9] = i7;
        this.f7098b = i9 + 1;
    }

    public final int c(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String resourceEntryName;
        if (str == null || constraintLayout == null || (resources = this.f7099c.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = constraintLayout.getChildAt(i7);
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

    public final int d(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int iC = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object objF = constraintLayout.f(0, str);
            if (objF instanceof Integer) {
                iC = ((Integer) objF).intValue();
            }
        }
        if (iC == 0 && constraintLayout != null) {
            iC = c(constraintLayout, str);
        }
        if (iC == 0) {
            try {
                iC = B.c.class.getField(str).getInt(null);
            } catch (Exception unused) {
            }
        }
        return iC == 0 ? this.f7099c.getResources().getIdentifier(str, DiagnosticsEntry.ID_KEY, this.f7099c.getPackageName()) : iC;
    }

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f556a1);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == d.f616k1) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f7102f = string;
                    setIds(string);
                }
            }
        }
    }

    public abstract void f(e eVar, boolean z7);

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f7097a, this.f7098b);
    }

    public void h(ConstraintLayout constraintLayout) {
    }

    public void i(ConstraintLayout constraintLayout) {
    }

    public void j(ConstraintLayout constraintLayout) {
        String str;
        int iC;
        if (isInEditMode()) {
            setIds(this.f7102f);
        }
        h hVar = this.f7100d;
        if (hVar == null) {
            return;
        }
        hVar.a();
        for (int i7 = 0; i7 < this.f7098b; i7++) {
            int i8 = this.f7097a[i7];
            View viewH = constraintLayout.h(i8);
            if (viewH == null && (iC = c(constraintLayout, (str = (String) this.f7104h.get(Integer.valueOf(i8))))) != 0) {
                this.f7097a[i7] = iC;
                this.f7104h.put(Integer.valueOf(iC), str);
                viewH = constraintLayout.h(iC);
            }
            if (viewH != null) {
                this.f7100d.b(constraintLayout.i(viewH));
            }
        }
        this.f7100d.c(constraintLayout.f6983c);
    }

    public void k() {
        if (this.f7100d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.b) {
            ((ConstraintLayout.b) layoutParams).f7058n0 = (e) this.f7100d;
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f7102f;
        if (str != null) {
            setIds(str);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i7, int i8) {
        if (this.f7101e) {
            super.onMeasure(i7, i8);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String str) {
        this.f7102f = str;
        if (str == null) {
            return;
        }
        int i7 = 0;
        this.f7098b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i7);
            if (iIndexOf == -1) {
                a(str.substring(i7));
                return;
            } else {
                a(str.substring(i7, iIndexOf));
                i7 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f7102f = null;
        this.f7098b = 0;
        for (int i7 : iArr) {
            b(i7);
        }
    }

    public b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7097a = new int[32];
        this.f7101e = false;
        this.f7103g = null;
        this.f7104h = new HashMap();
        this.f7099c = context;
        e(attributeSet);
    }
}
