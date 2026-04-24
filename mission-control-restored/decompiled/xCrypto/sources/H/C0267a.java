package H;

import I.t;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import v.AbstractC1873e;

/* JADX INFO: renamed from: H.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0267a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f545c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.AccessibilityDelegate f547b;

    /* JADX INFO: renamed from: H.a$a, reason: collision with other inner class name */
    public static final class C0022a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0267a f548a;

        public C0022a(C0267a c0267a) {
            this.f548a = c0267a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f548a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            I.w wVarB = this.f548a.b(view);
            if (wVarB != null) {
                return (AccessibilityNodeProvider) wVarB.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f548a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            I.t tVarE0 = I.t.e0(accessibilityNodeInfo);
            tVarE0.a0(E.y(view));
            tVarE0.Y(E.v(view));
            tVarE0.Z(E.g(view));
            tVarE0.c0(E.r(view));
            this.f548a.g(view, tVarE0);
            tVarE0.d(accessibilityNodeInfo.getText(), view);
            List listC = C0267a.c(view);
            for (int i4 = 0; i4 < listC.size(); i4++) {
                tVarE0.b((t.a) listC.get(i4));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f548a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f548a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i4, Bundle bundle) {
            return this.f548a.j(view, i4, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i4) {
            this.f548a.l(view, i4);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f548a.m(view, accessibilityEvent);
        }
    }

    public C0267a() {
        this(f545c);
    }

    public static List c(View view) {
        List list = (List) view.getTag(AbstractC1873e.f15129H);
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f546a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public I.w b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f546a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new I.w(accessibilityNodeProvider);
        }
        return null;
    }

    public View.AccessibilityDelegate d() {
        return this.f547b;
    }

    public final boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrN = I.t.n(view.createAccessibilityNodeInfo().getText());
            for (int i4 = 0; clickableSpanArrN != null && i4 < clickableSpanArrN.length; i4++) {
                if (clickableSpan.equals(clickableSpanArrN[i4])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f546a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, I.t tVar) {
        this.f546a.onInitializeAccessibilityNodeInfo(view, tVar.d0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f546a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f546a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i4, Bundle bundle) {
        List listC = c(view);
        boolean zPerformAccessibilityAction = false;
        int i5 = 0;
        while (true) {
            if (i5 >= listC.size()) {
                break;
            }
            t.a aVar = (t.a) listC.get(i5);
            if (aVar.a() == i4) {
                zPerformAccessibilityAction = aVar.c(view, bundle);
                break;
            }
            i5++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f546a.performAccessibilityAction(view, i4, bundle);
        }
        return (zPerformAccessibilityAction || i4 != AbstractC1873e.f15139a || bundle == null) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public final boolean k(int i4, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(AbstractC1873e.f15130I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i4)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public void l(View view, int i4) {
        this.f546a.sendAccessibilityEvent(view, i4);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f546a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0267a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f546a = accessibilityDelegate;
        this.f547b = new C0022a(this);
    }
}
