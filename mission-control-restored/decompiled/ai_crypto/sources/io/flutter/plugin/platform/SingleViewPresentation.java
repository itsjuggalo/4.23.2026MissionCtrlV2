package io.flutter.plugin.platform;

import android.app.AlertDialog;
import android.app.Presentation;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes2.dex */
@Keep
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final C2004a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private a rootView;
    private boolean startFocused;
    private final d state;
    private int viewId;

    public static class a extends FrameLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2004a f16713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final View f16714b;

        public a(Context context, C2004a c2004a, View view) {
            super(context);
            this.f16713a = c2004a;
            this.f16714b = view;
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public boolean requestSendAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f16713a.b(this.f16714b, view, accessibilityEvent);
        }
    }

    public static class b extends ContextWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputMethodManager f16715a;

        public b(Context context) {
            this(context, null);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Context createDisplayContext(Display display) {
            return new b(super.createDisplayContext(display), this.f16715a);
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "input_method".equals(str) ? this.f16715a : super.getSystemService(str);
        }

        public b(Context context, InputMethodManager inputMethodManager) {
            super(context);
            this.f16715a = inputMethodManager == null ? (InputMethodManager) context.getSystemService("input_method") : inputMethodManager;
        }
    }

    public static class c extends ContextWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f16716a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public WindowManager f16717b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f16718c;

        public c(Context context, c0 c0Var, Context context2) {
            super(context);
            this.f16716a = c0Var;
            this.f16718c = context2;
        }

        public final WindowManager a() {
            if (this.f16717b == null) {
                this.f16717b = this.f16716a;
            }
            return this.f16717b;
        }

        public final boolean b() {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            for (int i7 = 0; i7 < stackTrace.length && i7 < 11; i7++) {
                if (stackTrace[i7].getClassName().equals(AlertDialog.class.getCanonicalName()) && stackTrace[i7].getMethodName().equals("<init>")) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.content.ContextWrapper, android.content.Context
        public Object getSystemService(String str) {
            return "window".equals(str) ? b() ? this.f16718c.getSystemService(str) : a() : super.getSystemService(str);
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public InterfaceC2014k f16719a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c0 f16720b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S f16721c;
    }

    public SingleViewPresentation(Context context, Display display, InterfaceC2014k interfaceC2014k, C2004a c2004a, int i7, View.OnFocusChangeListener onFocusChangeListener) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c2004a;
        this.viewId = i7;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        d dVar = new d();
        this.state = dVar;
        dVar.f16719a = interfaceC2014k;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public d detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        a aVar = this.rootView;
        if (aVar != null) {
            aVar.removeAllViews();
        }
        return this.state;
    }

    public InterfaceC2014k getView() {
        return this.state.f16719a;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        if (this.state.f16721c == null) {
            this.state.f16721c = new S(getContext());
        }
        if (this.state.f16720b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            d dVar = this.state;
            dVar.f16720b = new c0(windowManager, dVar.f16721c);
        }
        this.container = new FrameLayout(getContext());
        c cVar = new c(getContext(), this.state.f16720b, this.outerContext);
        View view = this.state.f16719a.getView();
        if (view.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) view.getContext()).setBaseContext(cVar);
        } else {
            J4.b.g(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(view);
        a aVar = new a(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView = aVar;
        aVar.addView(this.container);
        this.rootView.addView(this.state.f16721c);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public SingleViewPresentation(Context context, Display display, C2004a c2004a, d dVar, View.OnFocusChangeListener onFocusChangeListener, boolean z7) {
        super(new b(context), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c2004a;
        this.state = dVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z7;
    }
}
