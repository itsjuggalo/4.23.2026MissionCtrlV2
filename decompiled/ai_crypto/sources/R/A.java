package R;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class A {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f4564a;

    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final A f4565a;

        public a(A a7) {
            this.f4565a = a7;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i7) {
            x xVarB = this.f4565a.b(i7);
            if (xVarB == null) {
                return null;
            }
            return xVarB.I0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i7) {
            List listC = this.f4565a.c(str, i7);
            if (listC == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listC.size();
            for (int i8 = 0; i8 < size; i8++) {
                arrayList.add(((x) listC.get(i8)).I0());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i7) {
            x xVarD = this.f4565a.d(i7);
            if (xVarD == null) {
                return null;
            }
            return xVarD.I0();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i7, int i8, Bundle bundle) {
            return this.f4565a.f(i7, i8, bundle);
        }
    }

    public static class b extends a {
        public b(A a7) {
            super(a7);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i7, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f4565a.a(i7, x.J0(accessibilityNodeInfo), str, bundle);
        }
    }

    public A() {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4564a = new b(this);
        } else {
            this.f4564a = new a(this);
        }
    }

    public x b(int i7) {
        return null;
    }

    public List c(String str, int i7) {
        return null;
    }

    public x d(int i7) {
        return null;
    }

    public Object e() {
        return this.f4564a;
    }

    public boolean f(int i7, int i8, Bundle bundle) {
        return false;
    }

    public A(Object obj) {
        this.f4564a = obj;
    }

    public void a(int i7, x xVar, String str, Bundle bundle) {
    }
}
