package m;

import android.os.Handler;
import android.widget.AbsListView;

/* JADX INFO: renamed from: m.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0812d0 implements AbsListView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractC0816f0 f8341a;

    public C0812d0(AbstractC0816f0 abstractC0816f0) {
        this.f8341a = abstractC0816f0;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            AbstractC0816f0 abstractC0816f0 = this.f8341a;
            if (abstractC0816f0.f8366z.getInputMethodMode() == 2 || abstractC0816f0.f8366z.getContentView() == null) {
                return;
            }
            Handler handler = abstractC0816f0.f8363v;
            RunnableC0810c0 runnableC0810c0 = abstractC0816f0.f8359r;
            handler.removeCallbacks(runnableC0810c0);
            runnableC0810c0.run();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i6, int i7) {
    }
}
