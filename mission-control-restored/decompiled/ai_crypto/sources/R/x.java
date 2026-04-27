package R;

import R.C;
import android.R;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import j$.time.Duration;
import j$.time.TimeConversions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class x {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f4570d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeInfo f4571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4572b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4573c = -1;

    public static class a {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public static final a f4574A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public static final a f4575B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public static final a f4576C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public static final a f4577D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public static final a f4578E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public static final a f4579F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public static final a f4580G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public static final a f4581H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public static final a f4582I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public static final a f4583J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public static final a f4584K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public static final a f4585L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public static final a f4586M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public static final a f4587N;

        /* JADX INFO: renamed from: O, reason: collision with root package name */
        public static final a f4588O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public static final a f4589P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public static final a f4590Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public static final a f4591R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public static final a f4592S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public static final a f4593T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public static final a f4594U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public static final a f4595V;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final a f4596e = new a(1, null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f4597f = new a(2, null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f4598g = new a(4, null);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final a f4599h = new a(8, null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final a f4600i = new a(16, null);

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final a f4601j = new a(32, null);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final a f4602k = new a(64, null);

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final a f4603l = new a(128, null);

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final a f4604m = new a(256, (CharSequence) null, C.b.class);

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final a f4605n = new a(512, (CharSequence) null, C.b.class);

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final a f4606o = new a(1024, (CharSequence) null, C.c.class);

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final a f4607p = new a(2048, (CharSequence) null, C.c.class);

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final a f4608q = new a(4096, null);

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a f4609r = new a(8192, null);

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a f4610s = new a(16384, null);

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final a f4611t = new a(32768, null);

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final a f4612u = new a(65536, null);

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final a f4613v = new a(131072, (CharSequence) null, C.g.class);

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final a f4614w = new a(262144, null);

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final a f4615x = new a(524288, null);

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final a f4616y = new a(1048576, null);

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final a f4617z = new a(2097152, (CharSequence) null, C.h.class);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f4618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f4619b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Class f4620c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final C f4621d;

        static {
            int i7 = Build.VERSION.SDK_INT;
            f4574A = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, R.id.accessibilityActionShowOnScreen, null, null, null);
            f4575B = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, R.id.accessibilityActionScrollToPosition, null, null, C.e.class);
            f4576C = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, R.id.accessibilityActionScrollUp, null, null, null);
            f4577D = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, R.id.accessibilityActionScrollLeft, null, null, null);
            f4578E = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, R.id.accessibilityActionScrollDown, null, null, null);
            f4579F = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, R.id.accessibilityActionScrollRight, null, null, null);
            f4580G = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, R.id.accessibilityActionPageUp, null, null, null);
            f4581H = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, R.id.accessibilityActionPageDown, null, null, null);
            f4582I = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, R.id.accessibilityActionPageLeft, null, null, null);
            f4583J = new a(i7 >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, R.id.accessibilityActionPageRight, null, null, null);
            f4584K = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, R.id.accessibilityActionContextClick, null, null, null);
            f4585L = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, R.id.accessibilityActionSetProgress, null, null, C.f.class);
            f4586M = new a(i7 >= 26 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW : null, R.id.accessibilityActionMoveWindow, null, null, C.d.class);
            f4587N = new a(i7 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP : null, R.id.accessibilityActionShowTooltip, null, null, null);
            f4588O = new a(i7 >= 28 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP : null, R.id.accessibilityActionHideTooltip, null, null, null);
            f4589P = new a(i7 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, R.id.accessibilityActionPressAndHold, null, null, null);
            f4590Q = new a(i7 >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, R.id.accessibilityActionImeEnter, null, null, null);
            f4591R = new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START : null, R.id.accessibilityActionDragStart, null, null, null);
            f4592S = new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP : null, R.id.accessibilityActionDragDrop, null, null, null);
            f4593T = new a(i7 >= 32 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL : null, R.id.accessibilityActionDragCancel, null, null, null);
            f4594U = new a(i7 >= 33 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS : null, R.id.accessibilityActionShowTextSuggestions, null, null, null);
            f4595V = new a(i7 >= 34 ? d.a() : null, R.id.accessibilityActionScrollInDirection, null, null, null);
        }

        public a(int i7, CharSequence charSequence) {
            this(null, i7, charSequence, null, null);
        }

        public a a(CharSequence charSequence, C c7) {
            return new a(null, this.f4619b, charSequence, c7, this.f4620c);
        }

        public int b() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f4618a).getId();
        }

        public CharSequence c() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f4618a).getLabel();
        }

        public boolean d(View view, Bundle bundle) {
            if (this.f4621d == null) {
                return false;
            }
            Class cls = this.f4620c;
            if (cls != null) {
                try {
                    android.support.v4.media.session.b.a(cls.getDeclaredConstructor(null).newInstance(null));
                    throw null;
                } catch (Exception e7) {
                    Class cls2 = this.f4620c;
                    Log.e("A11yActionCompat", "Failed to execute command with argument class ViewCommandArgument: " + (cls2 == null ? "null" : cls2.getName()), e7);
                }
            }
            return this.f4621d.a(view, null);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            Object obj2 = this.f4618a;
            return obj2 == null ? aVar.f4618a == null : obj2.equals(aVar.f4618a);
        }

        public int hashCode() {
            Object obj = this.f4618a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("AccessibilityActionCompat: ");
            String strI = x.i(this.f4619b);
            if (strI.equals("ACTION_UNKNOWN") && c() != null) {
                strI = c().toString();
            }
            sb.append(strI);
            return sb.toString();
        }

        public a(int i7, CharSequence charSequence, C c7) {
            this(null, i7, charSequence, c7, null);
        }

        public a(Object obj) {
            this(obj, 0, null, null, null);
        }

        public a(int i7, CharSequence charSequence, Class cls) {
            this(null, i7, charSequence, null, cls);
        }

        public a(Object obj, int i7, CharSequence charSequence, C c7, Class cls) {
            this.f4619b = i7;
            this.f4621d = c7;
            if (obj == null) {
                this.f4618a = new AccessibilityNodeInfo.AccessibilityAction(i7, charSequence);
            } else {
                this.f4618a = obj;
            }
            this.f4620c = cls;
        }
    }

    public static class b {
        public static Object a(int i7, float f7, float f8, float f9) {
            return new AccessibilityNodeInfo.RangeInfo(i7, f7, f8, f9);
        }

        public static CharSequence b(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getStateDescription();
        }

        public static void c(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setStateDescription(charSequence);
        }
    }

    public static class c {
        public static f a(boolean z7, int i7, int i8, int i9, int i10, boolean z8, String str, String str2) {
            return new f(new AccessibilityNodeInfo.CollectionItemInfo.Builder().setHeading(z7).setColumnIndex(i7).setRowIndex(i8).setColumnSpan(i9).setRowSpan(i10).setSelected(z8).setRowTitle(str).setColumnTitle(str2).build());
        }

        public static x b(AccessibilityNodeInfo accessibilityNodeInfo, int i7, int i8) {
            return x.K0(accessibilityNodeInfo.getChild(i7, i8));
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

        public static x f(AccessibilityNodeInfo accessibilityNodeInfo, int i7) {
            return x.K0(accessibilityNodeInfo.getParent(i7));
        }

        public static String g(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getUniqueId();
        }

        public static boolean h(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, boolean z7) {
            accessibilityNodeInfo.setTextSelectable(z7);
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

        public static void g(AccessibilityNodeInfo accessibilityNodeInfo, boolean z7) {
            accessibilityNodeInfo.setAccessibilityDataSensitive(z7);
        }

        public static void h(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect) {
            accessibilityNodeInfo.setBoundsInWindow(rect);
        }

        public static void i(AccessibilityNodeInfo accessibilityNodeInfo, CharSequence charSequence) {
            accessibilityNodeInfo.setContainerTitle(charSequence);
        }

        public static void j(AccessibilityNodeInfo accessibilityNodeInfo, long j7) {
            accessibilityNodeInfo.setMinDurationBetweenContentChanges(TimeConversions.convert(Duration.ofMillis(j7)));
        }

        public static void k(AccessibilityNodeInfo accessibilityNodeInfo, View view, boolean z7) {
            accessibilityNodeInfo.setQueryFromAppProcessEnabled(view, z7);
        }

        public static void l(AccessibilityNodeInfo accessibilityNodeInfo, boolean z7) {
            accessibilityNodeInfo.setRequestInitialAccessibilityFocus(z7);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f4622a;

        public e(Object obj) {
            this.f4622a = obj;
        }

        public static e a(int i7, int i8, boolean z7, int i9) {
            return new e(AccessibilityNodeInfo.CollectionInfo.obtain(i7, i8, z7, i9));
        }
    }

    public static class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f4623a;

        public f(Object obj) {
            this.f4623a = obj;
        }

        public static f a(int i7, int i8, int i9, int i10, boolean z7, boolean z8) {
            return new f(AccessibilityNodeInfo.CollectionItemInfo.obtain(i7, i8, i9, i10, z7, z8));
        }
    }

    public x(Object obj) {
        this.f4571a = (AccessibilityNodeInfo) obj;
    }

    public static x J0(AccessibilityNodeInfo accessibilityNodeInfo) {
        return new x(accessibilityNodeInfo);
    }

    public static x K0(Object obj) {
        if (obj != null) {
            return new x(obj);
        }
        return null;
    }

    public static x X() {
        return J0(AccessibilityNodeInfo.obtain());
    }

    public static x Y(x xVar) {
        return J0(AccessibilityNodeInfo.obtain(xVar.f4571a));
    }

    public static x Z(View view) {
        return J0(AccessibilityNodeInfo.obtain(view));
    }

    public static String i(int i7) {
        if (i7 == 1) {
            return "ACTION_FOCUS";
        }
        if (i7 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i7) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case com.amazon.c.a.a.c.f10119g /* 16 */:
                return "ACTION_CLICK";
            case com.amazon.c.a.a.c.f10120h /* 32 */:
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
                switch (i7) {
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
                        switch (i7) {
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
                                switch (i7) {
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

    public static ClickableSpan[] q(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public CharSequence A() {
        if (!E()) {
            return this.f4571a.getText();
        }
        List listG = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        List listG2 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        List listG3 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        List listG4 = g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.f4571a.getText(), 0, this.f4571a.getText().length()));
        for (int i7 = 0; i7 < listG.size(); i7++) {
            spannableString.setSpan(new C0685a(((Integer) listG4.get(i7)).intValue(), this, u().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), ((Integer) listG.get(i7)).intValue(), ((Integer) listG2.get(i7)).intValue(), ((Integer) listG3.get(i7)).intValue());
        }
        return spannableString;
    }

    public void A0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4571a.setScreenReaderFocusable(z7);
        } else {
            e0(1, z7);
        }
    }

    public CharSequence B() {
        return Build.VERSION.SDK_INT >= 28 ? this.f4571a.getTooltipText() : this.f4571a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY");
    }

    public void B0(boolean z7) {
        this.f4571a.setScrollable(z7);
    }

    public String C() {
        return Build.VERSION.SDK_INT >= 33 ? c.g(this.f4571a) : this.f4571a.getExtras().getString("androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY");
    }

    public void C0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4571a.setShowingHintText(z7);
        } else {
            e0(4, z7);
        }
    }

    public String D() {
        return this.f4571a.getViewIdResourceName();
    }

    public void D0(View view, int i7) {
        this.f4573c = i7;
        this.f4571a.setSource(view, i7);
    }

    public final boolean E() {
        return !g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty();
    }

    public void E0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.c(this.f4571a, charSequence);
        } else {
            this.f4571a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
        }
    }

    public final int F(ClickableSpan clickableSpan, SparseArray sparseArray) {
        if (sparseArray != null) {
            for (int i7 = 0; i7 < sparseArray.size(); i7++) {
                if (clickableSpan.equals((ClickableSpan) ((WeakReference) sparseArray.valueAt(i7)).get())) {
                    return sparseArray.keyAt(i7);
                }
            }
        }
        int i8 = f4570d;
        f4570d = i8 + 1;
        return i8;
    }

    public void F0(CharSequence charSequence) {
        this.f4571a.setText(charSequence);
    }

    public boolean G() {
        return Build.VERSION.SDK_INT >= 34 ? d.f(this.f4571a) : k(64);
    }

    public void G0(View view) {
        this.f4571a.setTraversalAfter(view);
    }

    public boolean H() {
        return this.f4571a.isCheckable();
    }

    public void H0(boolean z7) {
        this.f4571a.setVisibleToUser(z7);
    }

    public boolean I() {
        return this.f4571a.isChecked();
    }

    public AccessibilityNodeInfo I0() {
        return this.f4571a;
    }

    public boolean J() {
        return this.f4571a.isClickable();
    }

    public boolean K() {
        return this.f4571a.isContextClickable();
    }

    public boolean L() {
        return this.f4571a.isEnabled();
    }

    public boolean M() {
        return this.f4571a.isFocusable();
    }

    public boolean N() {
        return this.f4571a.isFocused();
    }

    public boolean O() {
        return k(67108864);
    }

    public boolean P() {
        return this.f4571a.isImportantForAccessibility();
    }

    public boolean Q() {
        return this.f4571a.isLongClickable();
    }

    public boolean R() {
        return this.f4571a.isPassword();
    }

    public boolean S() {
        return this.f4571a.isScrollable();
    }

    public boolean T() {
        return this.f4571a.isSelected();
    }

    public boolean U() {
        return Build.VERSION.SDK_INT >= 26 ? this.f4571a.isShowingHintText() : k(4);
    }

    public boolean V() {
        return Build.VERSION.SDK_INT >= 33 ? c.h(this.f4571a) : k(8388608);
    }

    public boolean W() {
        return this.f4571a.isVisibleToUser();
    }

    public void a(int i7) {
        this.f4571a.addAction(i7);
    }

    public boolean a0(int i7, Bundle bundle) {
        return this.f4571a.performAction(i7, bundle);
    }

    public void b(a aVar) {
        this.f4571a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.f4618a);
    }

    public void c(View view, int i7) {
        this.f4571a.addChild(view, i7);
    }

    public final void c0(View view) {
        SparseArray sparseArrayY = y(view);
        if (sparseArrayY != null) {
            ArrayList arrayList = new ArrayList();
            for (int i7 = 0; i7 < sparseArrayY.size(); i7++) {
                if (((WeakReference) sparseArrayY.valueAt(i7)).get() == null) {
                    arrayList.add(Integer.valueOf(i7));
                }
            }
            for (int i8 = 0; i8 < arrayList.size(); i8++) {
                sparseArrayY.remove(((Integer) arrayList.get(i8)).intValue());
            }
        }
    }

    public final void d(ClickableSpan clickableSpan, Spanned spanned, int i7) {
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY").add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY").add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        g("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY").add(Integer.valueOf(i7));
    }

    public void d0(boolean z7) {
        this.f4571a.setAccessibilityFocused(z7);
    }

    public void e(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            f();
            c0(view);
            ClickableSpan[] clickableSpanArrQ = q(charSequence);
            if (clickableSpanArrQ == null || clickableSpanArrQ.length <= 0) {
                return;
            }
            u().putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY", E.e.f1515a);
            SparseArray sparseArrayW = w(view);
            for (int i7 = 0; i7 < clickableSpanArrQ.length; i7++) {
                int iF = F(clickableSpanArrQ[i7], sparseArrayW);
                sparseArrayW.put(iF, new WeakReference(clickableSpanArrQ[i7]));
                d(clickableSpanArrQ[i7], (Spanned) charSequence, iF);
            }
        }
    }

    public final void e0(int i7, boolean z7) {
        Bundle bundleU = u();
        if (bundleU != null) {
            int i8 = bundleU.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & (~i7);
            if (!z7) {
                i7 = 0;
            }
            bundleU.putInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", i7 | i8);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4571a;
        if (accessibilityNodeInfo == null) {
            if (xVar.f4571a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(xVar.f4571a)) {
            return false;
        }
        return this.f4573c == xVar.f4573c && this.f4572b == xVar.f4572b;
    }

    public final void f() {
        this.f4571a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
        this.f4571a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
        this.f4571a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
        this.f4571a.getExtras().remove("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
    }

    public void f0(Rect rect) {
        this.f4571a.setBoundsInParent(rect);
    }

    public final List g(String str) {
        ArrayList<Integer> integerArrayList = this.f4571a.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.f4571a.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    public void g0(Rect rect) {
        this.f4571a.setBoundsInScreen(rect);
    }

    public List h() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.f4571a.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i7 = 0; i7 < size; i7++) {
            arrayList.add(new a(actionList.get(i7)));
        }
        return arrayList;
    }

    public void h0(boolean z7) {
        this.f4571a.setCheckable(z7);
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f4571a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public void i0(boolean z7) {
        this.f4571a.setChecked(z7);
    }

    public int j() {
        return this.f4571a.getActions();
    }

    public void j0(CharSequence charSequence) {
        this.f4571a.setClassName(charSequence);
    }

    public final boolean k(int i7) {
        Bundle bundleU = u();
        return bundleU != null && (bundleU.getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY", 0) & i7) == i7;
    }

    public void k0(boolean z7) {
        this.f4571a.setClickable(z7);
    }

    public void l(Rect rect) {
        this.f4571a.getBoundsInParent(rect);
    }

    public void l0(Object obj) {
        this.f4571a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((e) obj).f4622a);
    }

    public void m(Rect rect) {
        this.f4571a.getBoundsInScreen(rect);
    }

    public void m0(Object obj) {
        this.f4571a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((f) obj).f4623a);
    }

    public void n(Rect rect) {
        if (Build.VERSION.SDK_INT >= 34) {
            d.b(this.f4571a, rect);
            return;
        }
        Rect rect2 = (Rect) this.f4571a.getExtras().getParcelable("androidx.view.accessibility.AccessibilityNodeInfoCompat.BOUNDS_IN_WINDOW_KEY");
        if (rect2 != null) {
            rect.set(rect2.left, rect2.top, rect2.right, rect2.bottom);
        }
    }

    public void n0(CharSequence charSequence) {
        this.f4571a.setContentDescription(charSequence);
    }

    public int o() {
        return this.f4571a.getChildCount();
    }

    public void o0(boolean z7) {
        this.f4571a.setEnabled(z7);
    }

    public CharSequence p() {
        return this.f4571a.getClassName();
    }

    public void p0(CharSequence charSequence) {
        this.f4571a.setError(charSequence);
    }

    public void q0(boolean z7) {
        this.f4571a.setFocusable(z7);
    }

    public CharSequence r() {
        return Build.VERSION.SDK_INT >= 34 ? d.c(this.f4571a) : this.f4571a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.CONTAINER_TITLE_KEY");
    }

    public void r0(boolean z7) {
        this.f4571a.setFocused(z7);
    }

    public CharSequence s() {
        return this.f4571a.getContentDescription();
    }

    public void s0(boolean z7) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4571a.setHeading(z7);
        } else {
            e0(2, z7);
        }
    }

    public CharSequence t() {
        return this.f4571a.getError();
    }

    public void t0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f4571a.setHintText(charSequence);
        } else {
            this.f4571a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY", charSequence);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        l(rect);
        sb.append("; boundsInParent: " + rect);
        m(rect);
        sb.append("; boundsInScreen: " + rect);
        n(rect);
        sb.append("; boundsInWindow: " + rect);
        sb.append("; packageName: ");
        sb.append(x());
        sb.append("; className: ");
        sb.append(p());
        sb.append("; text: ");
        sb.append(A());
        sb.append("; error: ");
        sb.append(t());
        sb.append("; maxTextLength: ");
        sb.append(v());
        sb.append("; stateDescription: ");
        sb.append(z());
        sb.append("; contentDescription: ");
        sb.append(s());
        sb.append("; tooltipText: ");
        sb.append(B());
        sb.append("; viewIdResName: ");
        sb.append(D());
        sb.append("; uniqueId: ");
        sb.append(C());
        sb.append("; checkable: ");
        sb.append(H());
        sb.append("; checked: ");
        sb.append(I());
        sb.append("; focusable: ");
        sb.append(M());
        sb.append("; focused: ");
        sb.append(N());
        sb.append("; selected: ");
        sb.append(T());
        sb.append("; clickable: ");
        sb.append(J());
        sb.append("; longClickable: ");
        sb.append(Q());
        sb.append("; contextClickable: ");
        sb.append(K());
        sb.append("; enabled: ");
        sb.append(L());
        sb.append("; password: ");
        sb.append(R());
        sb.append("; scrollable: " + S());
        sb.append("; containerTitle: ");
        sb.append(r());
        sb.append("; granularScrollingSupported: ");
        sb.append(O());
        sb.append("; importantForAccessibility: ");
        sb.append(P());
        sb.append("; visible: ");
        sb.append(W());
        sb.append("; isTextSelectable: ");
        sb.append(V());
        sb.append("; accessibilityDataSensitive: ");
        sb.append(G());
        sb.append("; [");
        List listH = h();
        for (int i7 = 0; i7 < listH.size(); i7++) {
            a aVar = (a) listH.get(i7);
            String strI = i(aVar.b());
            if (strI.equals("ACTION_UNKNOWN") && aVar.c() != null) {
                strI = aVar.c().toString();
            }
            sb.append(strI);
            if (i7 != listH.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public Bundle u() {
        return this.f4571a.getExtras();
    }

    public void u0(View view) {
        this.f4571a.setLabelFor(view);
    }

    public int v() {
        return this.f4571a.getMaxTextLength();
    }

    public void v0(int i7) {
        this.f4571a.setMaxTextLength(i7);
    }

    public final SparseArray w(View view) {
        SparseArray sparseArrayY = y(view);
        if (sparseArrayY != null) {
            return sparseArrayY;
        }
        SparseArray sparseArray = new SparseArray();
        view.setTag(E.e.f1504I, sparseArray);
        return sparseArray;
    }

    public void w0(CharSequence charSequence) {
        this.f4571a.setPackageName(charSequence);
    }

    public CharSequence x() {
        return this.f4571a.getPackageName();
    }

    public void x0(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4571a.setPaneTitle(charSequence);
        } else {
            this.f4571a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY", charSequence);
        }
    }

    public final SparseArray y(View view) {
        return (SparseArray) view.getTag(E.e.f1504I);
    }

    public void y0(View view) {
        this.f4572b = -1;
        this.f4571a.setParent(view);
    }

    public CharSequence z() {
        return Build.VERSION.SDK_INT >= 30 ? b.b(this.f4571a) : this.f4571a.getExtras().getCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY");
    }

    public void z0(View view, int i7) {
        this.f4572b = i7;
        this.f4571a.setParent(view, i7);
    }

    public x(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.f4571a = accessibilityNodeInfo;
    }

    public void b0() {
    }
}
