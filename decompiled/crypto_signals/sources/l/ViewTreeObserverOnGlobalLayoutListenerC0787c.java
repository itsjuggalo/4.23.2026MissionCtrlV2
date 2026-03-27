package l;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;
import m.C0828l0;

/* JADX INFO: renamed from: l.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC0787c implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f7947b;

    public /* synthetic */ ViewTreeObserverOnGlobalLayoutListenerC0787c(k kVar, int i) {
        this.f7946a = i;
        this.f7947b = kVar;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f7946a) {
            case 0:
                f fVar = (f) this.f7947b;
                if (fVar.j()) {
                    ArrayList arrayList = fVar.f7962l;
                    if (arrayList.size() > 0 && !((e) arrayList.get(0)).f7950a.y) {
                        View view = fVar.f7969s;
                        if (view != null && view.isShown()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((e) it.next()).f7950a.b();
                            }
                        } else {
                            fVar.dismiss();
                        }
                        break;
                    }
                }
                break;
            default:
                s sVar = (s) this.f7947b;
                if (sVar.j()) {
                    C0828l0 c0828l0 = sVar.f8041l;
                    if (!c0828l0.y) {
                        View view2 = sVar.f8046q;
                        if (view2 != null && view2.isShown()) {
                            c0828l0.b();
                        } else {
                            sVar.dismiss();
                        }
                    }
                }
                break;
        }
    }
}
