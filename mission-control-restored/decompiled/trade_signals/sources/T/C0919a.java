package T;

import U.t;
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

/* JADX INFO: renamed from: T.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0919a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f7836c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f7837a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View.AccessibilityDelegate f7838b;

    /* JADX INFO: renamed from: T.a$a, reason: collision with other inner class name */
    public static final class C0111a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0919a f7839a;

        public C0111a(C0919a c0919a) {
            this.f7839a = c0919a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f7839a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            U.w wVarB = this.f7839a.b(view);
            if (wVarB != null) {
                return (AccessibilityNodeProvider) wVarB.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f7839a.f(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            U.t tVarE0 = U.t.e0(accessibilityNodeInfo);
            tVarE0.a0(D.A(view));
            tVarE0.Y(D.y(view));
            tVarE0.Z(D.j(view));
            tVarE0.c0(D.u(view));
            this.f7839a.g(view, tVarE0);
            tVarE0.d(accessibilityNodeInfo.getText(), view);
            List listC = C0919a.c(view);
            for (int i8 = 0; i8 < listC.size(); i8++) {
                tVarE0.b((t.a) listC.get(i8));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f7839a.h(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f7839a.i(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i8, Bundle bundle) {
            return this.f7839a.j(view, i8, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i8) {
            this.f7839a.l(view, i8);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f7839a.m(view, accessibilityEvent);
        }
    }

    public C0919a() {
        this(f7836c);
    }

    public static List c(View view) {
        List list = (List) view.getTag(G.e.f1939H);
        return list == null ? Collections.emptyList() : list;
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f7837a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public U.w b(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider = this.f7837a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new U.w(accessibilityNodeProvider);
        }
        return null;
    }

    public View.AccessibilityDelegate d() {
        return this.f7838b;
    }

    public final boolean e(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrN = U.t.n(view.createAccessibilityNodeInfo().getText());
            for (int i8 = 0; clickableSpanArrN != null && i8 < clickableSpanArrN.length; i8++) {
                if (clickableSpan.equals(clickableSpanArrN[i8])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void f(View view, AccessibilityEvent accessibilityEvent) {
        this.f7837a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void g(View view, U.t tVar) {
        this.f7837a.onInitializeAccessibilityNodeInfo(view, tVar.d0());
    }

    public void h(View view, AccessibilityEvent accessibilityEvent) {
        this.f7837a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f7837a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean j(View view, int i8, Bundle bundle) {
        List listC = c(view);
        boolean zPerformAccessibilityAction = false;
        int i9 = 0;
        while (true) {
            if (i9 >= listC.size()) {
                break;
            }
            t.a aVar = (t.a) listC.get(i9);
            if (aVar.a() == i8) {
                zPerformAccessibilityAction = aVar.c(view, bundle);
                break;
            }
            i9++;
        }
        if (!zPerformAccessibilityAction) {
            zPerformAccessibilityAction = this.f7837a.performAccessibilityAction(view, i8, bundle);
        }
        return (zPerformAccessibilityAction || i8 != G.e.f1949a || bundle == null) ? zPerformAccessibilityAction : k(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public final boolean k(int i8, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(G.e.f1940I);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i8)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!e(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public void l(View view, int i8) {
        this.f7837a.sendAccessibilityEvent(view, i8);
    }

    public void m(View view, AccessibilityEvent accessibilityEvent) {
        this.f7837a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public C0919a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f7837a = accessibilityDelegate;
        this.f7838b = new C0111a(this);
    }
}
