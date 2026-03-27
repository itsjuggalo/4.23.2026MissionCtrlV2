package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static int a(RecyclerView.z zVar, i iVar, View view, View view2, RecyclerView.o oVar, boolean z7) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z7) {
            return Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1;
        }
        return Math.min(iVar.n(), iVar.d(view2) - iVar.g(view));
    }

    public static int b(RecyclerView.z zVar, i iVar, View view, View view2, RecyclerView.o oVar, boolean z7, boolean z8) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z8 ? Math.max(0, (zVar.b() - Math.max(oVar.h0(view), oVar.h0(view2))) - 1) : Math.max(0, Math.min(oVar.h0(view), oVar.h0(view2)));
        if (z7) {
            return Math.round((iMax * (Math.abs(iVar.d(view2) - iVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1))) + (iVar.m() - iVar.g(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.z zVar, i iVar, View view, View view2, RecyclerView.o oVar, boolean z7) {
        if (oVar.J() == 0 || zVar.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z7) {
            return zVar.b();
        }
        return (int) (((iVar.d(view2) - iVar.g(view)) / (Math.abs(oVar.h0(view) - oVar.h0(view2)) + 1)) * zVar.b());
    }
}
