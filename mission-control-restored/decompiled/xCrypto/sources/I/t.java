package I;

import I.y;
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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import j$.time.Duration;
import j$.time.TimeConversions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import v.AbstractC1873e;

/* JADX INFO: loaded from: classes.dex */
public class t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f773d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f775b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f776c = -1;

    public static class a {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public static final a f777A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public static final a f778B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public static final a f779C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public static final a f780D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public static final a f781E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public static final a f782F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public static final a f783G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public static final a f784H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public static final a f785I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final a f786J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public static final a f787K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public static final a f788L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public static final a f789M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public static final a f790N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public static final a f791O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public static final a f792P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public static final a f793Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public static final a f794R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public static final a f795S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public static final a f796T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public static final a f797U;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f798d = new a(1, null);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f799e = new a(2, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f800f = new a(4, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f801g = new a(8, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f802h = new a(16, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f803i = new a(32, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f804j = new a(64, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f805k = new a(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f806l = new a(256, null, y.b.class);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f807m = new a(512, null, y.b.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f808n = new a(UserMetadata.MAX_ATTRIBUTE_SIZE, null, y.c.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f809o = new a(2048, null, y.c.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f810p = new a(4096, null);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f811q = new a(UserMetadata.MAX_INTERNAL_KEY_SIZE, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f812r = new a(16384, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f813s = new a(32768, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f814t = new a(65536, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f815u = new a(131072, null, y.g.class);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f816v = new a(262144, null);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f817w = new a(524288, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f818x = new a(1048576, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f819y = new a(2097152, null, y.h.class);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f820z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class f823c;

        static {
            int i4 = Build.VERSION.SDK_INT;
            f820z = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            f777A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, y.e.class);
            f778B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            f779C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f780D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            f781E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            f782F = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            f783G = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f784H = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            f785I = new a(i4 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            f786J = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            f787K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, y.f.class);
            f788L = new a(i4 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, y.d.class);
            f789M = new a(i4 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            f790N = new a(i4 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            f791O = new a(i4 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f792P = new a(i4 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f793Q = new a(i4 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f794R = new a(i4 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f795S = new a(i4 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f796T = new a(i4 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f797U = new a(i4 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i4, CharSequence charSequence) {
            this(null, i4, charSequence, null, null);
        }

        public int a() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f821a).getId();
        }

        public CharSequence b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f821a).getLabel();
        }

        public boolean c(View view, Bundle bundle) {
            return false;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f821a;
            return obj2 == null ? aVar.f821a == null : obj2.equals(aVar.f821a);
        }

        public int hashCode() {
            Object obj = this.f821a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strH = t.h(this.f822b);
            if (strH.equals("ACTION_UNKNOWN") && b() != null) {
                strH = b().toString();
            }
            sb.append(strH);
            return sb.toString();
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i4, CharSequence charSequence, Class cls) {
            this(null, i4, charSequence, null, cls);
        }

        public a(Object obj, int i4, CharSequence charSequence, y yVar, Class cls) {
            this.f822b = i4;
            if (obj == null) {
                this.f821a = new AccessibilityNodeInfo.AccessibilityAction(i4, charSequence);
            } else {
                this.f821a = obj;
            }
            this.f823c = cls;
        }
    }

    public static class b {
        public static Object a(int i4, float f4, float f5, float f6) {
            return new AccessibilityNodeInfo.RangeInfo(i4, f4, f5, f6);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    public static class c {
        public static f a(boolean z4, int i4, int i5, int i6, int i7, boolean z5, String str, String str2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z4).setColumnIndex(i4).setRowIndex(i5).setColumnSpan(i6).setRowSpan(i7).setSelected(z5).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static t b(AccessibilityNodeInfo accessibilityNodeInfo, int i4, int i5) {
            return t.f0(accessibilityNodeInfo.getChild(i4, i5));
        }

        public static String c(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getColumnTitle();
        }

        public static String d(Object obj) {
            return ((AccessibilityNodeInfo.CollectionItemInfo) obj).getRowTitle();
        }

        public static AccessibilityNodeInfo.ExtraRenderingInfo e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        public static t f(AccessibilityNodeInfo accessibilityNodeInfo, int i4) {
            return t.f0(accessibilityNodeInfo.getParent(i4));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z4) {
            accessibilityNodeInfo.setTextSelectable(z4);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
            accessibilityNodeInfo.setUniqueId(str);
        }
    }

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

        public static long d(AccessibilityNodeInfo accessibilityNodeInfo) {
            return TimeConversions.convert(accessibilityNodeInfo.getMinDurationBetweenContentChanges()).toMillis();
        }

        public static boolean e(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.hasRequestInitialAccessibilityFocus();
        }

        public static boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isAccessibilityDataSensitive();
        }

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z4) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z4);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j4) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(TimeConversions.convert(Duration.ofMillis(j4)));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z4) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z4);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z4) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z4);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f824a;

        public e(Object obj) {
            this.f824a = obj;
        }

        public static e a(int i4, int i5, boolean z4, int i6) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i4, i5, z4, i6));
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f825a;

        public f(Object obj) {
            this.f825a = obj;
        }
    }

    public t(Object obj) {
        this.f774a = (AccessibilityNodeInfo) obj;
    }

    public static t e0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new t(accessibilityNodeInfo);
    }

    public static t f0(Object obj) {
        if (obj != null) {
            return new t(obj);
        }
        return null;
    }

    public static String h(int i4) {
        if (i4 == 1) {
            return "ACTION_FOCUS";
        }
        if (i4 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i4) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case UserMetadata.MAX_ATTRIBUTES /* 64 */:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case UserMetadata.MAX_ROLLOUT_ASSIGNMENTS /* 128 */:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case UserMetadata.MAX_ATTRIBUTE_SIZE /* 1024 */:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case UserMetadata.MAX_INTERNAL_KEY_SIZE /* 8192 */:
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
                switch (i4) {
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
                        switch (i4) {
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
                                switch (i4) {
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
        return this.f774a.getViewIdResourceName();
    }

    public final boolean B() {
        return !f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public final int C(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i4 = 0; i4 < sparseArray.size(); i4++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i4)).get())) {
                    return sparseArray.keyAt(i4);
                }
            }
        }
        int i5 = f773d;
        f773d = i5 + 1;
        return i5;
    }

    public boolean D() {
        return Build.VERSION.SDK_INT >= 34 ? d.f(this.f774a) : i(64);
    }

    public boolean E() {
        return this.f774a.isCheckable();
    }

    public boolean F() {
        return this.f774a.isChecked();
    }

    public boolean G() {
        return this.f774a.isClickable();
    }

    public boolean H() {
        return this.f774a.isContextClickable();
    }

    public boolean I() {
        return this.f774a.isEnabled();
    }

    public boolean J() {
        return this.f774a.isFocusable();
    }

    public boolean K() {
        return this.f774a.isFocused();
    }

    public boolean L() {
        return i(67108864);
    }

    public boolean M() {
        return this.f774a.isImportantForAccessibility();
    }

    public boolean N() {
        return this.f774a.isLongClickable();
    }

    public boolean O() {
        return this.f774a.isPassword();
    }

    public boolean P() {
        return this.f774a.isScrollable();
    }

    public boolean Q() {
        return this.f774a.isSelected();
    }

    public boolean R() {
        return Build.VERSION.SDK_INT >= 33 ? c.h(this.f774a) : i(8388608);
    }

    public boolean S() {
        return this.f774a.isVisibleToUser();
    }

    public boolean T(int i4, Bundle bundle) {
        return this.f774a.performAction(i4, bundle);
    }

    public final void U(View view) {
        SparseArray sparseArrayV = v(view);
        if (sparseArrayV != null) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < sparseArrayV.size(); i4++) {
                if (((WeakReference) sparseArrayV.valueAt(i4)).get() == null) {
                    arrayList.add(Integer.valueOf(i4));
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                sparseArrayV.remove(((Integer) arrayList.get(i5)).intValue());
            }
        }
    }

    public final void V(int i4, boolean z4) {
        Bundle bundleR = r();
        if (bundleR != null) {
            int i5 = bundleR.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i4);
            if (!z4) {
                i4 = 0;
            }
            bundleR.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i4 | i5);
        }
    }

    public void W(CharSequence charSequence) {
        this.f774a.setClassName(charSequence);
    }

    public void X(Object obj) {
        this.f774a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f824a);
    }

    public void Y(boolean z4) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f774a.setHeading(z4);
        } else {
            V(2, z4);
        }
    }

    public void Z(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f774a.setPaneTitle(charSequence);
        } else {
            this.f774a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public void a(int i4) {
        this.f774a.addAction(i4);
    }

    public void a0(boolean z4) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f774a.setScreenReaderFocusable(z4);
        } else {
            V(1, z4);
        }
    }

    public void b(a aVar) {
        this.f774a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f821a);
    }

    public void b0(boolean z4) {
        this.f774a.setScrollable(z4);
    }

    public final void c(ClickableSpan clickableSpan, Spanned spanned, int i4) {
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i4));
    }

    public void c0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.c(this.f774a, charSequence);
        } else {
            this.f774a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public void d(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            e();
            U(view);
            ClickableSpan[] clickableSpanArrN = n(charSequence);
            if (clickableSpanArrN == null || clickableSpanArrN.length <= 0) {
                return;
            }
            r().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", AbstractC1873e.f15139a);
            SparseArray sparseArrayT = t(view);
            for (int i4 = 0; i4 < clickableSpanArrN.length; i4++) {
                int iC = C(clickableSpanArrN[i4], sparseArrayT);
                sparseArrayT.put(iC, new WeakReference(clickableSpanArrN[i4]));
                c(clickableSpanArrN[i4], (Spanned) charSequence, iC);
            }
        }
    }

    public AccessibilityNodeInfo d0() {
        return this.f774a;
    }

    public final void e() {
        this.f774a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f774a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f774a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f774a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f774a;
        if (accessibilityNodeInfo == null) {
            if (tVar.f774a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(tVar.f774a)) {
            return false;
        }
        return this.f776c == tVar.f776c && this.f775b == tVar.f775b;
    }

    public final List f(String str) {
        ArrayList<Integer> integerArrayList = this.f774a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f774a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public List g() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f774a.getActionList();
        if (actionList == null) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i4 = 0; i4 < size; i4++) {
            arrayList.add(new a(actionList.get(i4)));
        }
        return arrayList;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f774a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public final boolean i(int i4) {
        Bundle bundleR = r();
        return bundleR != null && (bundleR.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i4) == i4;
    }

    public void j(Rect rect) {
        this.f774a.getBoundsInParent(rect);
    }

    public void k(Rect rect) {
        this.f774a.getBoundsInScreen(rect);
    }

    public void l(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f774a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f774a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public CharSequence m() {
        return this.f774a.getClassName();
    }

    public CharSequence o() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f774a) : this.f774a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public CharSequence p() {
        return this.f774a.getContentDescription();
    }

    public CharSequence q() {
        return this.f774a.getError();
    }

    public Bundle r() {
        return this.f774a.getExtras();
    }

    public int s() {
        return this.f774a.getMaxTextLength();
    }

    public final SparseArray t(View view) {
        SparseArray sparseArrayV = v(view);
        if (sparseArrayV != null) {
            return sparseArrayV;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(AbstractC1873e.f15130I, sparseArray);
        return sparseArray;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        j(rect);
        sb.append("; boundsInParent: " + rect);
        k(rect);
        sb.append("; boundsInScreen: " + rect);
        l(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(u());
        sb.append("; className: ");
        sb.append(m());
        sb.append("; text: ");
        sb.append(x());
        sb.append("; error: ");
        sb.append(q());
        sb.append("; maxTextLength: ");
        sb.append(s());
        sb.append("; stateDescription: ");
        sb.append(w());
        sb.append("; contentDescription: ");
        sb.append(p());
        sb.append("; tooltipText: ");
        sb.append(y());
        sb.append("; viewIdResName: ");
        sb.append(A());
        sb.append("; uniqueId: ");
        sb.append(z());
        sb.append("; checkable: ");
        sb.append(E());
        sb.append("; checked: ");
        sb.append(F());
        sb.append("; focusable: ");
        sb.append(J());
        sb.append("; focused: ");
        sb.append(K());
        sb.append("; selected: ");
        sb.append(Q());
        sb.append("; clickable: ");
        sb.append(G());
        sb.append("; longClickable: ");
        sb.append(N());
        sb.append("; contextClickable: ");
        sb.append(H());
        sb.append("; enabled: ");
        sb.append(I());
        sb.append("; password: ");
        sb.append(O());
        sb.append("; scrollable: " + P());
        sb.append("; containerTitle: ");
        sb.append(o());
        sb.append("; granularScrollingSupported: ");
        sb.append(L());
        sb.append("; importantForAccessibility: ");
        sb.append(M());
        sb.append("; visible: ");
        sb.append(S());
        sb.append("; isTextSelectable: ");
        sb.append(R());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(D());
        sb.append("; [");
        List listG = g();
        for (int i4 = 0; i4 < listG.size(); i4++) {
            a aVar = (a) listG.get(i4);
            String strH = h(aVar.a());
            if (strH.equals("ACTION_UNKNOWN") && aVar.b() != null) {
                strH = aVar.b().toString();
            }
            sb.append(strH);
            if (i4 != listG.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public CharSequence u() {
        return this.f774a.getPackageName();
    }

    public final SparseArray v(View view) {
        return (SparseArray) view.getTag(AbstractC1873e.f15130I);
    }

    public CharSequence w() {
        return Build.VERSION.SDK_INT >= 30 ? b.b(this.f774a) : this.f774a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public CharSequence x() {
        if (!B()) {
            return this.f774a.getText();
        }
        List listF = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listF2 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listF3 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listF4 = f("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f774a.getText(), 0, this.f774a.getText().length()));
        for (int i4 = 0; i4 < listF.size(); i4++) {
            spannableString.setSpan(new I.a(((Integer) listF4.get(i4)).intValue(), this, r().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listF.get(i4)).intValue(), ((Integer) listF2.get(i4)).intValue(), ((Integer) listF3.get(i4)).intValue());
        }
        return spannableString;
    }

    public CharSequence y() {
        return Build.VERSION.SDK_INT >= 28 ? this.f774a.getTooltipText() : this.f774a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public String z() {
        return Build.VERSION.SDK_INT >= 33 ? c.g(this.f774a) : this.f774a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public t(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f774a = accessibilityNodeInfo;
    }
}
