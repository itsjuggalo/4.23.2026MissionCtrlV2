package D;

import android.os.Bundle;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.cryptosignals.ap.android.R;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: D.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0002b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final View.AccessibilityDelegate f224c = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View.AccessibilityDelegate f225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0001a f226b;

    public C0002b() {
        this(f224c);
    }

    public void a(View view, AccessibilityEvent accessibilityEvent) {
        this.f225a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void b(View view, E.k kVar) {
        this.f225a.onInitializeAccessibilityNodeInfo(view, kVar.f363a);
    }

    public boolean c(View view, int i, Bundle bundle) {
        WeakReference weakReference;
        ClickableSpan clickableSpan;
        List list = (List) view.getTag(R.id.tag_accessibility_actions);
        if (list == null) {
            list = Collections.EMPTY_LIST;
        }
        for (int i6 = 0; i6 < list.size() && ((AccessibilityNodeInfo.AccessibilityAction) ((E.d) list.get(i6)).f360a).getId() != i; i6++) {
        }
        boolean zPerformAccessibilityAction = this.f225a.performAccessibilityAction(view, i, bundle);
        if (zPerformAccessibilityAction || i != R.id.accessibility_action_clickable_span || bundle == null) {
            return zPerformAccessibilityAction;
        }
        int i7 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i7)) != null && (clickableSpan = (ClickableSpan) weakReference.get()) != null) {
            CharSequence text = view.createAccessibilityNodeInfo().getText();
            ClickableSpan[] clickableSpanArr = text instanceof Spanned ? (ClickableSpan[]) ((Spanned) text).getSpans(0, text.length(), ClickableSpan.class) : null;
            for (int i8 = 0; clickableSpanArr != null && i8 < clickableSpanArr.length; i8++) {
                if (clickableSpan.equals(clickableSpanArr[i8])) {
                    clickableSpan.onClick(view);
                    return true;
                }
            }
        }
        return false;
    }

    public C0002b(View.AccessibilityDelegate accessibilityDelegate) {
        this.f225a = accessibilityDelegate;
        this.f226b = new C0001a(this);
    }
}
