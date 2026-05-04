package u0;

import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import u0.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f22104d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f22105a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22106b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f22107c = -1;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {
        public static final a A;
        public static final a B;
        public static final a C;
        public static final a D;
        public static final a E;
        public static final a F;
        public static final a G;
        public static final a H;
        public static final a I;
        public static final a J;
        public static final a K;
        public static final a L;
        public static final a M;
        public static final a N;
        public static final a O;
        public static final a P;
        public static final a Q;
        public static final a R;
        public static final a S;
        public static final a T;
        public static final a U;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f22108d = new a(1, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f22109e = new a(2, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f22110f = new a(4, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f22111g = new a(8, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f22112h = new a(16, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f22113i = new a(32, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f22114j = new a(64, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f22115k = new a(128, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f22116l = new a(256, null, s.b.class);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f22117m = new a(512, null, s.b.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f22118n = new a(1024, null, s.c.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f22119o = new a(2048, null, s.c.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f22120p = new a(4096, null);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f22121q = new a(8192, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f22122r = new a(16384, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f22123s = new a(32768, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f22124t = new a(65536, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f22125u = new a(131072, null, s.g.class);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f22126v = new a(262144, null);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f22127w = new a(524288, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f22128x = new a(1048576, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f22129y = new a(2097152, null, s.h.class);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f22130z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f22131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class f22133c;

        static {
            int i10 = Build.VERSION.SDK_INT;
            f22130z = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, s.e.class);
            B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            F = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            G = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            H = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            I = new a(i10 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, s.f.class);
            L = new a(i10 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, s.d.class);
            M = new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            N = new a(i10 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            O = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            P = new a(i10 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            Q = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            R = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            S = new a(i10 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            T = new a(i10 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            U = new a(i10 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i10, CharSequence charSequence) {
            this(null, i10, charSequence, null, null);
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f22131a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f22131a).getLabel();
        }

        public boolean c(View view, Bundle bundle) {
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f22131a;
            return obj2 == null ? aVar.f22131a == null : obj2.equals(aVar.f22131a);
        }

        public int hashCode() {
            Object obj = this.f22131a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AccessibilityActionCompat: ");
            String strH = p.h(this.f22132b);
            if (strH.equals("ACTION_UNKNOWN") && b() != null) {
                strH = b().toString();
            }
            sb2.append(strH);
            return sb2.toString();
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i10, CharSequence charSequence, Class cls) {
            this(null, i10, charSequence, null, cls);
        }

        public a(Object obj, int i10, CharSequence charSequence, s sVar, Class cls) {
            this.f22132b = i10;
            if (obj == null) {
                this.f22131a = new AccessibilityNodeInfo.AccessibilityAction(i10, charSequence);
            } else {
                this.f22131a = obj;
            }
            this.f22133c = cls;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {
        public static CharSequence a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c {
        public static String a(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d {
        public static AccessibilityNodeInfo.AccessibilityAction a() {
            return AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_IN_DIRECTION;
        }

        public static void b(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.getBoundsInWindow(rect);
        }

        public static CharSequence c(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getContainerTitle();
        }

        public static boolean d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f22134a;

        public e(Object obj) {
            this.f22134a = obj;
        }

        public static e a(int i10, int i11, boolean z10, int i12) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i10, i11, z10, i12));
        }
    }

    public p(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f22105a = accessibilityNodeInfo;
    }

    public static p f0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new p(accessibilityNodeInfo);
    }

    public static String h(int i10) {
        if (i10 == 1) {
            return "ACTION_FOCUS";
        }
        if (i10 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i10) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case R.id.accessibilityActionMoveWindow:
                return "ACTION_MOVE_WINDOW";
            case R.id.accessibilityActionScrollInDirection:
                return "ACTION_SCROLL_IN_DIRECTION";
            default:
                switch (i10) {
                    case R.id.accessibilityActionShowOnScreen:
                        return "ACTION_SHOW_ON_SCREEN";
                    case R.id.accessibilityActionScrollToPosition:
                        return "ACTION_SCROLL_TO_POSITION";
                    case R.id.accessibilityActionScrollUp:
                        return "ACTION_SCROLL_UP";
                    case R.id.accessibilityActionScrollLeft:
                        return "ACTION_SCROLL_LEFT";
                    case R.id.accessibilityActionScrollDown:
                        return "ACTION_SCROLL_DOWN";
                    case R.id.accessibilityActionScrollRight:
                        return "ACTION_SCROLL_RIGHT";
                    case R.id.accessibilityActionContextClick:
                        return "ACTION_CONTEXT_CLICK";
                    case R.id.accessibilityActionSetProgress:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i10) {
                            case R.id.accessibilityActionShowTooltip:
                                return "ACTION_SHOW_TOOLTIP";
                            case R.id.accessibilityActionHideTooltip:
                                return "ACTION_HIDE_TOOLTIP";
                            case R.id.accessibilityActionPageUp:
                                return "ACTION_PAGE_UP";
                            case R.id.accessibilityActionPageDown:
                                return "ACTION_PAGE_DOWN";
                            case R.id.accessibilityActionPageLeft:
                                return "ACTION_PAGE_LEFT";
                            case R.id.accessibilityActionPageRight:
                                return "ACTION_PAGE_RIGHT";
                            case R.id.accessibilityActionPressAndHold:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i10) {
                                    case R.id.accessibilityActionImeEnter:
                                        return "ACTION_IME_ENTER";
                                    case R.id.accessibilityActionDragStart:
                                        return "ACTION_DRAG_START";
                                    case R.id.accessibilityActionDragDrop:
                                        return "ACTION_DRAG_DROP";
                                    case R.id.accessibilityActionDragCancel:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    public static ClickableSpan[] n(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public String A() {
        return this.f22105a.getViewIdResourceName();
    }

    public final boolean B() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public final int C(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i10)).get())) {
                    return sparseArray.keyAt(i10);
                }
            }
        }
        int i11 = f22104d;
        f22104d = i11 + 1;
        return i11;
    }

    public boolean D() {
        return Build.VERSION.SDK_INT >= 34 ? d.d(this.f22105a) : i(64);
    }

    public boolean E() {
        return this.f22105a.isCheckable();
    }

    public boolean F() {
        return this.f22105a.isChecked();
    }

    public boolean G() {
        return this.f22105a.isClickable();
    }

    public boolean H() {
        return this.f22105a.isContextClickable();
    }

    public boolean I() {
        return this.f22105a.isEnabled();
    }

    public boolean J() {
        return this.f22105a.getExtras().getBoolean("androidx.view.accessibility.AccessibilityNodeInfoCompat.IS_REQUIRED_KEY");
    }

    public boolean K() {
        return this.f22105a.isFocusable();
    }

    public boolean L() {
        return this.f22105a.isFocused();
    }

    public boolean M() {
        return i(67108864);
    }

    public boolean N() {
        return this.f22105a.isImportantForAccessibility();
    }

    public boolean O() {
        return this.f22105a.isLongClickable();
    }

    public boolean P() {
        return this.f22105a.isPassword();
    }

    public boolean Q() {
        return this.f22105a.isScrollable();
    }

    public boolean R() {
        return this.f22105a.isSelected();
    }

    public boolean S() {
        return Build.VERSION.SDK_INT >= 33 ? c.b(this.f22105a) : i(8388608);
    }

    public boolean T() {
        return this.f22105a.isVisibleToUser();
    }

    public boolean U(int i10, Bundle bundle) {
        return this.f22105a.performAction(i10, bundle);
    }

    public final void V(View view) {
        SparseArray sparseArrayV = v(view);
        if (sparseArrayV != null) {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < sparseArrayV.size(); i10++) {
                if (((WeakReference) sparseArrayV.valueAt(i10)).get() == null) {
                    arrayList.add(Integer.valueOf(i10));
                }
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                sparseArrayV.remove(((Integer) arrayList.get(i11)).intValue());
            }
        }
    }

    public final void W(int i10, boolean z10) {
        Bundle bundleR = r();
        if (bundleR != null) {
            int i11 = bundleR.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i10);
            if (!z10) {
                i10 = 0;
            }
            bundleR.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i10 | i11);
        }
    }

    public void X(CharSequence charSequence) {
        this.f22105a.setClassName(charSequence);
    }

    public void Y(Object obj) {
        this.f22105a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f22134a);
    }

    public void Z(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f22105a.setHeading(z10);
        } else {
            W(2, z10);
        }
    }

    public void a(int i10) {
        this.f22105a.addAction(i10);
    }

    public void a0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f22105a.setPaneTitle(charSequence);
        } else {
            this.f22105a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void b(a aVar) {
        this.f22105a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f22131a);
    }

    public void b0(boolean z10) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f22105a.setScreenReaderFocusable(z10);
        } else {
            W(1, z10);
        }
    }

    public final void c(ClickableSpan clickableSpan, Spanned spanned, int i10) {
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i10));
    }

    public void c0(boolean z10) {
        this.f22105a.setScrollable(z10);
    }

    public void d(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            e();
            V(view);
            ClickableSpan[] clickableSpanArrN = n(charSequence);
            if (clickableSpanArrN == null || clickableSpanArrN.length <= 0) {
                return;
            }
            r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", g0.e.f9876a);
            SparseArray sparseArrayT = t(view);
            for (int i10 = 0; i10 < clickableSpanArrN.length; i10++) {
                int iC = C(clickableSpanArrN[i10], sparseArrayT);
                sparseArrayT.put(iC, new WeakReference(clickableSpanArrN[i10]));
                c(clickableSpanArrN[i10], (Spanned) charSequence, iC);
            }
        }
    }

    public void d0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.b(this.f22105a, charSequence);
        } else {
            this.f22105a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public final void e() {
        this.f22105a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f22105a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f22105a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f22105a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public AccessibilityNodeInfo e0() {
        return this.f22105a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f22105a;
        if (accessibilityNodeInfo == null) {
            if (pVar.f22105a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(pVar.f22105a)) {
            return false;
        }
        return this.f22107c == pVar.f22107c && this.f22106b == pVar.f22106b;
    }

    public final List f(String str) {
        ArrayList<Integer> integerArrayList = this.f22105a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f22105a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public List g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f22105a.getActionList();
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(actionList.get(i10)));
        }
        return arrayList;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f22105a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final boolean i(int i10) {
        Bundle bundleR = r();
        return bundleR != null && (bundleR.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i10) == i10;
    }

    public void j(Rect rect) {
        this.f22105a.getBoundsInParent(rect);
    }

    public void k(Rect rect) {
        this.f22105a.getBoundsInScreen(rect);
    }

    public void l(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f22105a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f22105a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public CharSequence m() {
        return this.f22105a.getClassName();
    }

    public CharSequence o() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f22105a) : this.f22105a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public CharSequence p() {
        return this.f22105a.getContentDescription();
    }

    public CharSequence q() {
        return this.f22105a.getError();
    }

    public Bundle r() {
        return this.f22105a.getExtras();
    }

    public int s() {
        return this.f22105a.getMaxTextLength();
    }

    public final SparseArray t(View view) {
        SparseArray sparseArrayV = v(view);
        if (sparseArrayV != null) {
            return sparseArrayV;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(g0.e.I, sparseArray);
        return sparseArray;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        j(rect);
        sb2.append("; boundsInParent: " + rect);
        k(rect);
        sb2.append("; boundsInScreen: " + rect);
        l(rect);
        sb2.append("; boundsInWindow: " + rect);
        sb2.append("; packageName: ");
        sb2.append(u());
        sb2.append("; className: ");
        sb2.append(m());
        sb2.append("; text: ");
        sb2.append(x());
        sb2.append("; error: ");
        sb2.append(q());
        sb2.append("; maxTextLength: ");
        sb2.append(s());
        sb2.append("; stateDescription: ");
        sb2.append(w());
        sb2.append("; contentDescription: ");
        sb2.append(p());
        sb2.append("; tooltipText: ");
        sb2.append(y());
        sb2.append("; viewIdResName: ");
        sb2.append(A());
        sb2.append("; uniqueId: ");
        sb2.append(z());
        sb2.append("; checkable: ");
        sb2.append(E());
        sb2.append("; checked: ");
        sb2.append(F());
        sb2.append("; fieldRequired: ");
        sb2.append(J());
        sb2.append("; focusable: ");
        sb2.append(K());
        sb2.append("; focused: ");
        sb2.append(L());
        sb2.append("; selected: ");
        sb2.append(R());
        sb2.append("; clickable: ");
        sb2.append(G());
        sb2.append("; longClickable: ");
        sb2.append(O());
        sb2.append("; contextClickable: ");
        sb2.append(H());
        sb2.append("; enabled: ");
        sb2.append(I());
        sb2.append("; password: ");
        sb2.append(P());
        sb2.append("; scrollable: " + Q());
        sb2.append("; containerTitle: ");
        sb2.append(o());
        sb2.append("; granularScrollingSupported: ");
        sb2.append(M());
        sb2.append("; importantForAccessibility: ");
        sb2.append(N());
        sb2.append("; visible: ");
        sb2.append(T());
        sb2.append("; isTextSelectable: ");
        sb2.append(S());
        sb2.append("; accessibilityDataSensitive: ");
        sb2.append(D());
        sb2.append("; [");
        List listG = g();
        for (int i10 = 0; i10 < listG.size(); i10++) {
            a aVar = (a) listG.get(i10);
            String strH = h(aVar.a());
            if (strH.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                strH = aVar.b().toString();
            }
            sb2.append(strH);
            if (i10 != listG.size() - 1) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public CharSequence u() {
        return this.f22105a.getPackageName();
    }

    public final SparseArray v(View view) {
        return (SparseArray) view.getTag(g0.e.I);
    }

    public CharSequence w() {
        return Build.VERSION.SDK_INT >= 30 ? b.a(this.f22105a) : this.f22105a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public CharSequence x() {
        if (!B()) {
            return this.f22105a.getText();
        }
        List listF = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listF2 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listF3 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listF4 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f22105a.getText(), 0, this.f22105a.getText().length()));
        for (int i10 = 0; i10 < listF.size(); i10++) {
            spannableString.setSpan(new u0.a(((Integer) listF4.get(i10)).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listF.get(i10)).intValue(), ((Integer) listF2.get(i10)).intValue(), ((Integer) listF3.get(i10)).intValue());
        }
        return spannableString;
    }

    public CharSequence y() {
        return Build.VERSION.SDK_INT >= 28 ? this.f22105a.getTooltipText() : this.f22105a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public String z() {
        return Build.VERSION.SDK_INT >= 33 ? c.a(this.f22105a) : this.f22105a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }
}
