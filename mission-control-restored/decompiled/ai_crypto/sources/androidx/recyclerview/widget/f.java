package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8398e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f8401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f8402i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8394a = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8399f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8400g = 0;

    public boolean a(RecyclerView.z zVar) {
        int i7 = this.f8396c;
        return i7 >= 0 && i7 < zVar.b();
    }

    public View b(RecyclerView.u uVar) {
        View viewO = uVar.o(this.f8396c);
        this.f8396c += this.f8397d;
        return viewO;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f8395b + ", mCurrentPosition=" + this.f8396c + ", mItemDirection=" + this.f8397d + ", mLayoutDirection=" + this.f8398e + ", mStartLine=" + this.f8399f + ", mEndLine=" + this.f8400g + '}';
    }
}
