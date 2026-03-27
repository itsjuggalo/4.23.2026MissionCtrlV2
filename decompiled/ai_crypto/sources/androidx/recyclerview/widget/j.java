package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.a;

/* JADX INFO: loaded from: classes.dex */
public class j extends n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f8415d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f8416e;

    public class a extends g {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g, androidx.recyclerview.widget.RecyclerView.y
        public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
            j jVar = j.this;
            int[] iArrC = jVar.c(jVar.f8423a.getLayoutManager(), view);
            int i7 = iArrC[0];
            int i8 = iArrC[1];
            int iW = w(Math.max(Math.abs(i7), Math.abs(i8)));
            if (iW > 0) {
                aVar.d(i7, i8, iW, this.f8404j);
            }
        }

        @Override // androidx.recyclerview.widget.g
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }

        @Override // androidx.recyclerview.widget.g
        public int x(int i7) {
            return Math.min(100, super.x(i7));
        }
    }

    @Override // androidx.recyclerview.widget.n
    public int[] c(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.k()) {
            iArr[0] = l(oVar, view, n(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.l()) {
            iArr[1] = l(oVar, view, p(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.n
    public g e(RecyclerView.o oVar) {
        if (oVar instanceof RecyclerView.y.b) {
            return new a(this.f8423a.getContext());
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.n
    public View g(RecyclerView.o oVar) {
        if (oVar.l()) {
            return m(oVar, p(oVar));
        }
        if (oVar.k()) {
            return m(oVar, n(oVar));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.n
    public int h(RecyclerView.o oVar, int i7, int i8) {
        i iVarO;
        int iY = oVar.Y();
        if (iY == 0 || (iVarO = o(oVar)) == null) {
            return -1;
        }
        int iJ = oVar.J();
        View view = null;
        int i9 = Integer.MAX_VALUE;
        int i10 = Integer.MIN_VALUE;
        View view2 = null;
        for (int i11 = 0; i11 < iJ; i11++) {
            View viewI = oVar.I(i11);
            if (viewI != null) {
                int iL = l(oVar, viewI, iVarO);
                if (iL <= 0 && iL > i10) {
                    view2 = viewI;
                    i10 = iL;
                }
                if (iL >= 0 && iL < i9) {
                    view = viewI;
                    i9 = iL;
                }
            }
        }
        boolean zQ = q(oVar, i7, i8);
        if (zQ && view != null) {
            return oVar.h0(view);
        }
        if (!zQ && view2 != null) {
            return oVar.h0(view2);
        }
        if (zQ) {
            view = view2;
        }
        if (view == null) {
            return -1;
        }
        int iH0 = oVar.h0(view) + (r(oVar) == zQ ? -1 : 1);
        if (iH0 < 0 || iH0 >= iY) {
            return -1;
        }
        return iH0;
    }

    public final int l(RecyclerView.o oVar, View view, i iVar) {
        return (iVar.g(view) + (iVar.e(view) / 2)) - (iVar.m() + (iVar.n() / 2));
    }

    public final View m(RecyclerView.o oVar, i iVar) {
        int iJ = oVar.J();
        View view = null;
        if (iJ == 0) {
            return null;
        }
        int iM = iVar.m() + (iVar.n() / 2);
        int i7 = a.e.API_PRIORITY_OTHER;
        for (int i8 = 0; i8 < iJ; i8++) {
            View viewI = oVar.I(i8);
            int iAbs = Math.abs((iVar.g(viewI) + (iVar.e(viewI) / 2)) - iM);
            if (iAbs < i7) {
                view = viewI;
                i7 = iAbs;
            }
        }
        return view;
    }

    public final i n(RecyclerView.o oVar) {
        i iVar = this.f8416e;
        if (iVar == null || iVar.f8412a != oVar) {
            this.f8416e = i.a(oVar);
        }
        return this.f8416e;
    }

    public final i o(RecyclerView.o oVar) {
        if (oVar.l()) {
            return p(oVar);
        }
        if (oVar.k()) {
            return n(oVar);
        }
        return null;
    }

    public final i p(RecyclerView.o oVar) {
        i iVar = this.f8415d;
        if (iVar == null || iVar.f8412a != oVar) {
            this.f8415d = i.c(oVar);
        }
        return this.f8415d;
    }

    public final boolean q(RecyclerView.o oVar, int i7, int i8) {
        return oVar.k() ? i7 > 0 : i8 > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean r(RecyclerView.o oVar) {
        PointF pointFA;
        int iY = oVar.Y();
        if (!(oVar instanceof RecyclerView.y.b) || (pointFA = ((RecyclerView.y.b) oVar).a(iY - 1)) == null) {
            return false;
        }
        return pointFA.x < 0.0f || pointFA.y < 0.0f;
    }
}
