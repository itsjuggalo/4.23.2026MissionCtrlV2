package m;

import java.lang.reflect.Field;

/* JADX INFO: renamed from: m.c0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0810c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0816f0 f8340b;

    public /* synthetic */ RunnableC0810c0(AbstractC0816f0 abstractC0816f0, int i) {
        this.f8339a = i;
        this.f8340b = abstractC0816f0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0816f0 abstractC0816f0 = this.f8340b;
        switch (this.f8339a) {
            case 0:
                C0826k0 c0826k0 = abstractC0816f0.f8349c;
                if (c0826k0 != null) {
                    c0826k0.setListSelectionHidden(true);
                    c0826k0.requestLayout();
                }
                break;
            default:
                C0826k0 c0826k02 = abstractC0816f0.f8349c;
                if (c0826k02 != null) {
                    Field field = D.C.f194a;
                    if (c0826k02.isAttachedToWindow() && abstractC0816f0.f8349c.getCount() > abstractC0816f0.f8349c.getChildCount() && abstractC0816f0.f8349c.getChildCount() <= Integer.MAX_VALUE) {
                        abstractC0816f0.f8366z.setInputMethodMode(2);
                        abstractC0816f0.b();
                        break;
                    }
                }
                break;
        }
    }
}
