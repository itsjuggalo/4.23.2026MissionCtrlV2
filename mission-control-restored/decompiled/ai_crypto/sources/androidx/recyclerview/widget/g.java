package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class g extends RecyclerView.y {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PointF f8405k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f8406l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f8408n;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f8403i = new LinearInterpolator();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f8404j = new DecelerateInterpolator();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8407m = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f8409o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f8410p = 0;

    public g(Context context) {
        this.f8406l = context.getResources().getDisplayMetrics();
    }

    public final float A() {
        if (!this.f8407m) {
            this.f8408n = v(this.f8406l);
            this.f8407m = true;
        }
        return this.f8408n;
    }

    public int B() {
        PointF pointF = this.f8405k;
        if (pointF != null) {
            float f7 = pointF.y;
            if (f7 != 0.0f) {
                return f7 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }

    public void C(RecyclerView.y.a aVar) {
        PointF pointFA = a(f());
        if (pointFA == null || (pointFA.x == 0.0f && pointFA.y == 0.0f)) {
            aVar.b(f());
            r();
            return;
        }
        i(pointFA);
        this.f8405k = pointFA;
        this.f8409o = (int) (pointFA.x * 10000.0f);
        this.f8410p = (int) (pointFA.y * 10000.0f);
        aVar.d((int) (this.f8409o * 1.2f), (int) (this.f8410p * 1.2f), (int) (x(10000) * 1.2f), this.f8403i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void l(int i7, int i8, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        if (c() == 0) {
            r();
            return;
        }
        this.f8409o = y(this.f8409o, i7);
        int iY = y(this.f8410p, i8);
        this.f8410p = iY;
        if (this.f8409o == 0 && iY == 0) {
            C(aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void m() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void n() {
        this.f8410p = 0;
        this.f8409o = 0;
        this.f8405k = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y
    public void o(View view, RecyclerView.z zVar, RecyclerView.y.a aVar) {
        int iT = t(view, z());
        int iU = u(view, B());
        int iW = w((int) Math.sqrt((iT * iT) + (iU * iU)));
        if (iW > 0) {
            aVar.d(-iT, -iU, iW, this.f8404j);
        }
    }

    public int s(int i7, int i8, int i9, int i10, int i11) {
        if (i11 == -1) {
            return i9 - i7;
        }
        if (i11 != 0) {
            if (i11 == 1) {
                return i10 - i8;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i12 = i9 - i7;
        if (i12 > 0) {
            return i12;
        }
        int i13 = i10 - i8;
        if (i13 < 0) {
            return i13;
        }
        return 0;
    }

    public int t(View view, int i7) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.k()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.Q(view) - ((ViewGroup.MarginLayoutParams) pVar).leftMargin, oVarE.T(view) + ((ViewGroup.MarginLayoutParams) pVar).rightMargin, oVarE.e0(), oVarE.o0() - oVarE.f0(), i7);
    }

    public int u(View view, int i7) {
        RecyclerView.o oVarE = e();
        if (oVarE == null || !oVarE.l()) {
            return 0;
        }
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        return s(oVarE.U(view) - ((ViewGroup.MarginLayoutParams) pVar).topMargin, oVarE.O(view) + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin, oVarE.g0(), oVarE.W() - oVarE.d0(), i7);
    }

    public float v(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int w(int i7) {
        return (int) Math.ceil(((double) x(i7)) / 0.3356d);
    }

    public int x(int i7) {
        return (int) Math.ceil(Math.abs(i7) * A());
    }

    public final int y(int i7, int i8) {
        int i9 = i7 - i8;
        if (i7 * i9 <= 0) {
            return 0;
        }
        return i9;
    }

    public int z() {
        PointF pointF = this.f8405k;
        if (pointF != null) {
            float f7 = pointF.x;
            if (f7 != 0.0f) {
                return f7 > 0.0f ? 1 : -1;
            }
        }
        return 0;
    }
}
