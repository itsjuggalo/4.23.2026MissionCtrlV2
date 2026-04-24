package D;

import N1.C0146y;
import android.os.Build;
import android.view.View;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: D.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0017q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f251a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f252b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f253c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f254d;

    public AbstractC0017q() {
        if (C0146y.f1867s == null) {
            C0146y.f1867s = new C0146y(17);
        }
    }

    public int a(int i) {
        if (i < this.f253c) {
            return ((ByteBuffer) this.f254d).getShort(this.f252b + i);
        }
        return 0;
    }

    public abstract Object b(View view);

    public abstract void c(View view, CharSequence charSequence);

    public void d(View view, CharSequence charSequence) {
        Object tag;
        if (Build.VERSION.SDK_INT >= this.f252b) {
            c(view, charSequence);
            return;
        }
        if (Build.VERSION.SDK_INT >= this.f252b) {
            tag = b(view);
        } else {
            tag = view.getTag(this.f251a);
            if (!((Class) this.f254d).isInstance(tag)) {
                tag = null;
            }
        }
        if (e(tag, charSequence)) {
            View.AccessibilityDelegate accessibilityDelegateA = C.a(view);
            C0002b c0002b = accessibilityDelegateA == null ? null : accessibilityDelegateA instanceof C0001a ? ((C0001a) accessibilityDelegateA).f223a : new C0002b(accessibilityDelegateA);
            if (c0002b == null) {
                c0002b = new C0002b();
            }
            C.d(view, c0002b);
            view.setTag(this.f251a, charSequence);
            C.b(view, this.f253c);
        }
    }

    public abstract boolean e(Object obj, CharSequence charSequence);
}
