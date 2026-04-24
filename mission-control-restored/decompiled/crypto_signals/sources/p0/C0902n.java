package p0;

import N1.D0;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: p0.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0902n extends D0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f9044b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0902n(u uVar, int i) {
        super(uVar);
        this.f9044b = i;
    }

    @Override // N1.D0
    public final int h(View view) {
        switch (this.f9044b) {
            case 0:
                v vVar = (v) view.getLayoutParams();
                ((u) this.f1130a).getClass();
                return view.getRight() + ((v) view.getLayoutParams()).f9055a.right + ((ViewGroup.MarginLayoutParams) vVar).rightMargin;
            default:
                v vVar2 = (v) view.getLayoutParams();
                ((u) this.f1130a).getClass();
                return view.getBottom() + ((v) view.getLayoutParams()).f9055a.bottom + ((ViewGroup.MarginLayoutParams) vVar2).bottomMargin;
        }
    }

    @Override // N1.D0
    public final int i(View view) {
        switch (this.f9044b) {
            case 0:
                v vVar = (v) view.getLayoutParams();
                ((u) this.f1130a).getClass();
                return (view.getLeft() - ((v) view.getLayoutParams()).f9055a.left) - ((ViewGroup.MarginLayoutParams) vVar).leftMargin;
            default:
                v vVar2 = (v) view.getLayoutParams();
                ((u) this.f1130a).getClass();
                return (view.getTop() - ((v) view.getLayoutParams()).f9055a.top) - ((ViewGroup.MarginLayoutParams) vVar2).topMargin;
        }
    }

    @Override // N1.D0
    public final int j() {
        switch (this.f9044b) {
            case 0:
                u uVar = (u) this.f1130a;
                return uVar.f9053f - uVar.t();
            default:
                u uVar2 = (u) this.f1130a;
                return uVar2.f9054g - uVar2.r();
        }
    }

    @Override // N1.D0
    public final int k() {
        switch (this.f9044b) {
            case 0:
                return ((u) this.f1130a).s();
            default:
                return ((u) this.f1130a).u();
        }
    }

    @Override // N1.D0
    public final int l() {
        switch (this.f9044b) {
            case 0:
                u uVar = (u) this.f1130a;
                return (uVar.f9053f - uVar.s()) - uVar.t();
            default:
                u uVar2 = (u) this.f1130a;
                return (uVar2.f9054g - uVar2.u()) - uVar2.r();
        }
    }
}
