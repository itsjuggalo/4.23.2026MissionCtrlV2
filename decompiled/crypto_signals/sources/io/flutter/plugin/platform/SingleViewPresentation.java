package io.flutter.plugin.platform;

import android.app.Presentation;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes.dex */
@Keep
class SingleViewPresentation extends Presentation {
    private static final String TAG = "PlatformViewsController";
    private final C0704a accessibilityEventsDelegate;
    private FrameLayout container;
    private final View.OnFocusChangeListener focusChangeListener;
    private final Context outerContext;
    private r rootView;
    private boolean startFocused;
    private final u state;
    private int viewId;

    public SingleViewPresentation(Context context, Display display, f fVar, C0704a c0704a, int i, View.OnFocusChangeListener onFocusChangeListener) {
        super(new s(context, null), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c0704a;
        this.viewId = i;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        u uVar = new u();
        this.state = uVar;
        uVar.f7211a = fVar;
        getWindow().setFlags(8, 8);
        getWindow().setType(2030);
    }

    public u detachState() {
        FrameLayout frameLayout = this.container;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        r rVar = this.rootView;
        if (rVar != null) {
            rVar.removeAllViews();
        }
        return this.state;
    }

    public f getView() {
        return this.state.f7211a;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        u uVar = this.state;
        if (uVar.f7213c == null) {
            uVar.f7213c = new q(getContext());
        }
        if (this.state.f7212b == null) {
            WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
            u uVar2 = this.state;
            uVar2.f7212b = new A(windowManager, uVar2.f7213c);
        }
        this.container = new FrameLayout(getContext());
        t tVar = new t(getContext(), this.state.f7212b, this.outerContext);
        View view = this.state.f7211a.getView();
        if (view.getContext() instanceof MutableContextWrapper) {
            ((MutableContextWrapper) view.getContext()).setBaseContext(tVar);
        } else {
            Log.w(TAG, "Unexpected platform view context for view ID " + this.viewId + "; some functionality may not work correctly. When constructing a platform view in the factory, ensure that the view returned from PlatformViewFactory#create returns the provided context from getContext(). If you are unable to associate the view with that context, consider using Hybrid Composition instead.");
        }
        this.container.addView(view);
        r rVar = new r(getContext(), this.accessibilityEventsDelegate, view);
        this.rootView = rVar;
        rVar.addView(this.container);
        this.rootView.addView(this.state.f7213c);
        view.setOnFocusChangeListener(this.focusChangeListener);
        this.rootView.setFocusableInTouchMode(true);
        if (this.startFocused) {
            view.requestFocus();
        } else {
            this.rootView.requestFocus();
        }
        setContentView(this.rootView);
    }

    public SingleViewPresentation(Context context, Display display, C0704a c0704a, u uVar, View.OnFocusChangeListener onFocusChangeListener, boolean z6) {
        super(new s(context, null), display);
        this.startFocused = false;
        this.accessibilityEventsDelegate = c0704a;
        this.state = uVar;
        this.focusChangeListener = onFocusChangeListener;
        this.outerContext = context;
        getWindow().setFlags(8, 8);
        this.startFocused = z6;
    }
}
