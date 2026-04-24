package androidx.appcompat.widget;

import D.C;
import K4.f;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.cryptosignals.ap.android.R;
import h.AbstractC0616a;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k.InterfaceC0747a;
import m.A0;
import m.AbstractC0829m;
import m.B0;
import m.C0839r0;
import m.C0847v0;
import m.C0849w0;
import m.D0;
import m.InterfaceC0851x0;
import m.RunnableC0841s0;
import m.ViewOnFocusChangeListenerC0843t0;
import m.ViewOnLayoutChangeListenerC0845u0;
import m.Y;
import m.Z;
import m.y0;
import m.z0;
import s3.D;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends Y implements InterfaceC0747a {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final f f4292k0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public final ImageView f4293A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public final View f4294B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public B0 f4295C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final Rect f4296D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Rect f4297E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int[] f4298F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final int[] f4299G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final ImageView f4300H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final Drawable f4301I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final int f4302J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final int f4303K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public final Intent f4304L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public final Intent f4305M;
    public final CharSequence N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public View.OnFocusChangeListener f4306O;
    public View.OnClickListener P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f4307Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f4308R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public L.c f4309S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public boolean f4310T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public CharSequence f4311U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f4312V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public boolean f4313W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f4314a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f4315b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public CharSequence f4316c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f4317d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f4318e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public SearchableInfo f4319f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Bundle f4320g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final RunnableC0841s0 f4321h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final RunnableC0841s0 f4322i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final WeakHashMap f4323j0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final SearchAutoComplete f4324t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final View f4325u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f4326v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final View f4327w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f4328x;
    public final ImageView y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ImageView f4329z;

    public static class SearchAutoComplete extends AbstractC0829m {
        public int e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SearchView f4330f;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f4331k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final d f4332l;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f4332l = new d(this);
            this.e = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i = configuration.screenWidthDp;
            int i6 = configuration.screenHeightDp;
            if (i >= 960 && i6 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i < 600) {
                return (i < 640 || i6 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            f fVar = SearchView.f4292k0;
            fVar.getClass();
            f.a();
            Method method = fVar.f1014c;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.e <= 0 || super.enoughToFilter();
        }

        @Override // m.AbstractC0829m, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f4331k) {
                d dVar = this.f4332l;
                removeCallbacks(dVar);
                post(dVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z6, int i, Rect rect) {
            super.onFocusChanged(z6, i, rect);
            SearchView searchView = this.f4330f;
            searchView.u(searchView.f4308R);
            searchView.post(searchView.f4321h0);
            if (searchView.f4324t.hasFocus()) {
                searchView.j();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f4330f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z6) {
            super.onWindowFocusChanged(z6);
            if (z6 && this.f4330f.hasFocus() && getVisibility() == 0) {
                this.f4331k = true;
                Context context = getContext();
                f fVar = SearchView.f4292k0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z6) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.f4332l;
            if (!z6) {
                this.f4331k = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f4331k = true;
                    return;
                }
                this.f4331k = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f4330f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i) {
            super.setThreshold(i);
            this.e = i;
        }
    }

    static {
        f fVar = null;
        if (Build.VERSION.SDK_INT < 29) {
            f fVar2 = new f();
            fVar2.f1012a = null;
            fVar2.f1013b = null;
            fVar2.f1014c = null;
            f.a();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                fVar2.f1012a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                fVar2.f1013b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                fVar2.f1014c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            fVar = fVar2;
        }
        f4292k0 = fVar;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f4324t;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f4313W = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f4324t;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f4313W = false;
    }

    public int getImeOptions() {
        return this.f4324t.getImeOptions();
    }

    public int getInputType() {
        return this.f4324t.getInputType();
    }

    public int getMaxWidth() {
        return this.f4314a0;
    }

    public CharSequence getQuery() {
        return this.f4324t.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f4311U;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f4319f0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.N : getContext().getText(this.f4319f0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f4303K;
    }

    public int getSuggestionRowLayout() {
        return this.f4302J;
    }

    public L.c getSuggestionsAdapter() {
        return this.f4309S;
    }

    public final Intent h(Uri uri, String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f4316c0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f4320g0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f4319f0.getSearchActivity());
        return intent;
    }

    public final Intent i(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f4320g0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void j() {
        int i = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f4324t;
        if (i >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        f fVar = f4292k0;
        fVar.getClass();
        f.a();
        Method method = fVar.f1012a;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused) {
            }
        }
        fVar.getClass();
        f.a();
        Method method2 = fVar.f1013b;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, new Object[0]);
            } catch (Exception unused2) {
            }
        }
    }

    public final void k() {
        SearchAutoComplete searchAutoComplete = this.f4324t;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f4307Q) {
            clearFocus();
            u(true);
        }
    }

    public final void l(int i) {
        int position;
        String strH;
        Cursor cursor = this.f4309S.f1024c;
        if (cursor != null && cursor.moveToPosition(i)) {
            Intent intentH = null;
            try {
                int i6 = D0.f8214B;
                String strH2 = D0.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strH2 == null) {
                    strH2 = this.f4319f0.getSuggestIntentAction();
                }
                if (strH2 == null) {
                    strH2 = "android.intent.action.SEARCH";
                }
                String strH3 = D0.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strH3 == null) {
                    strH3 = this.f4319f0.getSuggestIntentData();
                }
                if (strH3 != null && (strH = D0.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strH3 = strH3 + "/" + Uri.encode(strH);
                }
                intentH = h(strH3 == null ? null : Uri.parse(strH3), strH2, D0.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), D0.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e);
            }
            if (intentH != null) {
                try {
                    getContext().startActivity(intentH);
                } catch (RuntimeException e2) {
                    Log.e("SearchView", "Failed launch activity: " + intentH, e2);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f4324t;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void m(int i) {
        Editable text = this.f4324t.getText();
        Cursor cursor = this.f4309S.f1024c;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i)) {
            setQuery(text);
            return;
        }
        String strC = this.f4309S.c(cursor);
        if (strC != null) {
            setQuery(strC);
        } else {
            setQuery(text);
        }
    }

    public final void n(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public final void o() {
        SearchAutoComplete searchAutoComplete = this.f4324t;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f4319f0 != null) {
            getContext().startActivity(h(null, "android.intent.action.SEARCH", null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f4321h0);
        post(this.f4322i0);
        super.onDetachedFromWindow();
    }

    @Override // m.Y, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z6, int i, int i6, int i7, int i8) {
        super.onLayout(z6, i, i6, i7, i8);
        if (z6) {
            int[] iArr = this.f4298F;
            SearchAutoComplete searchAutoComplete = this.f4324t;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f4299G;
            getLocationInWindow(iArr2);
            int i9 = iArr[1] - iArr2[1];
            int i10 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i10;
            int height = searchAutoComplete.getHeight() + i9;
            Rect rect = this.f4296D;
            rect.set(i10, i9, width, height);
            int i11 = rect.left;
            int i12 = rect.right;
            int i13 = i8 - i6;
            Rect rect2 = this.f4297E;
            rect2.set(i11, 0, i12, i13);
            B0 b02 = this.f4295C;
            if (b02 == null) {
                B0 b03 = new B0(rect2, rect, searchAutoComplete);
                this.f4295C = b03;
                setTouchDelegate(b03);
            } else {
                b02.f8206b.set(rect2);
                Rect rect3 = b02.f8208d;
                rect3.set(rect2);
                int i14 = -b02.e;
                rect3.inset(i14, i14);
                b02.f8207c.set(rect);
            }
        }
    }

    @Override // m.Y, android.view.View
    public final void onMeasure(int i, int i6) {
        int i7;
        if (this.f4308R) {
            super.onMeasure(i, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            int i8 = this.f4314a0;
            size = i8 > 0 ? Math.min(i8, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f4314a0;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i7 = this.f4314a0) > 0) {
            size = Math.min(i7, size);
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof A0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        A0 a02 = (A0) parcelable;
        super.onRestoreInstanceState(a02.f1052a);
        u(a02.f8198c);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        A0 a02 = new A0(super.onSaveInstanceState());
        a02.f8198c = this.f4308R;
        return a02;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z6) {
        super.onWindowFocusChanged(z6);
        post(this.f4321h0);
    }

    public final void p() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f4324t.getText());
        int i = (!zIsEmpty || (this.f4307Q && !this.f4317d0)) ? 0 : 8;
        ImageView imageView = this.f4329z;
        imageView.setVisibility(i);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void q() {
        int[] iArr = this.f4324t.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f4326v.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f4327w.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void r() {
        CharSequence queryHint = getQueryHint();
        CharSequence charSequence = queryHint;
        if (queryHint == null) {
            charSequence = "";
        }
        boolean z6 = this.f4307Q;
        SearchAutoComplete searchAutoComplete = this.f4324t;
        CharSequence charSequence2 = charSequence;
        if (z6) {
            Drawable drawable = this.f4301I;
            charSequence2 = charSequence;
            if (drawable != null) {
                int textSize = (int) (((double) searchAutoComplete.getTextSize()) * 1.25d);
                drawable.setBounds(0, 0, textSize, textSize);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
                spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
                spannableStringBuilder.append(charSequence);
                charSequence2 = spannableStringBuilder;
            }
        }
        searchAutoComplete.setHint(charSequence2);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i, Rect rect) {
        if (this.f4313W || !isFocusable()) {
            return false;
        }
        if (this.f4308R) {
            return super.requestFocus(i, rect);
        }
        boolean zRequestFocus = this.f4324t.requestFocus(i, rect);
        if (zRequestFocus) {
            u(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        this.f4327w.setVisibility(((this.f4310T || this.f4315b0) && !this.f4308R && (this.y.getVisibility() == 0 || this.f4293A.getVisibility() == 0)) ? 0 : 8);
    }

    public void setAppSearchData(Bundle bundle) {
        this.f4320g0 = bundle;
    }

    public void setIconified(boolean z6) {
        if (z6) {
            k();
            return;
        }
        u(false);
        SearchAutoComplete searchAutoComplete = this.f4324t;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.P;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z6) {
        if (this.f4307Q == z6) {
            return;
        }
        this.f4307Q = z6;
        u(z6);
        r();
    }

    public void setImeOptions(int i) {
        this.f4324t.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f4324t.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f4314a0 = i;
        requestLayout();
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f4306O = onFocusChangeListener;
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.P = onClickListener;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f4311U = charSequence;
        r();
    }

    public void setQueryRefinementEnabled(boolean z6) {
        this.f4312V = z6;
        L.c cVar = this.f4309S;
        if (cVar instanceof D0) {
            ((D0) cVar).f8224t = z6 ? 2 : 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setSearchableInfo(android.app.SearchableInfo r7) {
        /*
            r6 = this;
            r6.f4319f0 = r7
            r0 = 0
            r1 = 1
            androidx.appcompat.widget.SearchView$SearchAutoComplete r2 = r6.f4324t
            if (r7 == 0) goto L65
            int r7 = r7.getSuggestThreshold()
            r2.setThreshold(r7)
            android.app.SearchableInfo r7 = r6.f4319f0
            int r7 = r7.getImeOptions()
            r2.setImeOptions(r7)
            android.app.SearchableInfo r7 = r6.f4319f0
            int r7 = r7.getInputType()
            r3 = r7 & 15
            if (r3 != r1) goto L31
            r3 = -65537(0xfffffffffffeffff, float:NaN)
            r7 = r7 & r3
            android.app.SearchableInfo r3 = r6.f4319f0
            java.lang.String r3 = r3.getSuggestAuthority()
            if (r3 == 0) goto L31
            r3 = 589824(0x90000, float:8.2652E-40)
            r7 = r7 | r3
        L31:
            r2.setInputType(r7)
            L.c r7 = r6.f4309S
            if (r7 == 0) goto L3b
            r7.b(r0)
        L3b:
            android.app.SearchableInfo r7 = r6.f4319f0
            java.lang.String r7 = r7.getSuggestAuthority()
            if (r7 == 0) goto L62
            m.D0 r7 = new m.D0
            android.content.Context r3 = r6.getContext()
            android.app.SearchableInfo r4 = r6.f4319f0
            java.util.WeakHashMap r5 = r6.f4323j0
            r7.<init>(r3, r6, r4, r5)
            r6.f4309S = r7
            r2.setAdapter(r7)
            L.c r7 = r6.f4309S
            m.D0 r7 = (m.D0) r7
            boolean r3 = r6.f4312V
            if (r3 == 0) goto L5f
            r3 = 2
            goto L60
        L5f:
            r3 = r1
        L60:
            r7.f8224t = r3
        L62:
            r6.r()
        L65:
            android.app.SearchableInfo r7 = r6.f4319f0
            r3 = 0
            if (r7 == 0) goto L98
            boolean r7 = r7.getVoiceSearchEnabled()
            if (r7 == 0) goto L98
            android.app.SearchableInfo r7 = r6.f4319f0
            boolean r7 = r7.getVoiceSearchLaunchWebSearch()
            if (r7 == 0) goto L7b
            android.content.Intent r0 = r6.f4304L
            goto L85
        L7b:
            android.app.SearchableInfo r7 = r6.f4319f0
            boolean r7 = r7.getVoiceSearchLaunchRecognizer()
            if (r7 == 0) goto L85
            android.content.Intent r0 = r6.f4305M
        L85:
            if (r0 == 0) goto L98
            android.content.Context r7 = r6.getContext()
            android.content.pm.PackageManager r7 = r7.getPackageManager()
            r4 = 65536(0x10000, float:9.18355E-41)
            android.content.pm.ResolveInfo r7 = r7.resolveActivity(r0, r4)
            if (r7 == 0) goto L98
            goto L99
        L98:
            r1 = r3
        L99:
            r6.f4315b0 = r1
            if (r1 == 0) goto La2
            java.lang.String r7 = "nm"
            r2.setPrivateImeOptions(r7)
        La2:
            boolean r7 = r6.f4308R
            r6.u(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.SearchView.setSearchableInfo(android.app.SearchableInfo):void");
    }

    public void setSubmitButtonEnabled(boolean z6) {
        this.f4310T = z6;
        u(this.f4308R);
    }

    public void setSuggestionsAdapter(L.c cVar) {
        this.f4309S = cVar;
        this.f4324t.setAdapter(cVar);
    }

    public final void t(boolean z6) {
        boolean z7 = this.f4310T;
        this.y.setVisibility((!z7 || !(z7 || this.f4315b0) || this.f4308R || !hasFocus() || (!z6 && this.f4315b0)) ? 8 : 0);
    }

    public final void u(boolean z6) {
        this.f4308R = z6;
        int i = 8;
        int i6 = z6 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f4324t.getText());
        this.f4328x.setVisibility(i6);
        t(!zIsEmpty);
        this.f4325u.setVisibility(z6 ? 8 : 0);
        ImageView imageView = this.f4300H;
        imageView.setVisibility((imageView.getDrawable() == null || this.f4307Q) ? 8 : 0);
        p();
        if (this.f4315b0 && !this.f4308R && zIsEmpty) {
            this.y.setVisibility(8);
            i = 0;
        }
        this.f4293A.setVisibility(i);
        s();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4296D = new Rect();
        this.f4297E = new Rect();
        this.f4298F = new int[2];
        this.f4299G = new int[2];
        this.f4321h0 = new RunnableC0841s0(this, 0);
        this.f4322i0 = new RunnableC0841s0(this, 1);
        this.f4323j0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        C0847v0 c0847v0 = new C0847v0(this);
        C0849w0 c0849w0 = new C0849w0(this);
        Z z6 = new Z(this, 1);
        C0839r0 c0839r0 = new C0839r0(this);
        int[] iArr = AbstractC0616a.f6587q;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        f.d dVar = new f.d(context, typedArrayObtainStyledAttributes);
        C.c(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(9, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f4324t = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f4325u = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.f4326v = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.f4327w = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f4328x = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.y = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f4329z = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f4293A = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f4300H = imageView5;
        viewFindViewById.setBackground(dVar.G(10));
        viewFindViewById2.setBackground(dVar.G(14));
        imageView.setImageDrawable(dVar.G(13));
        imageView2.setImageDrawable(dVar.G(7));
        imageView3.setImageDrawable(dVar.G(4));
        imageView4.setImageDrawable(dVar.G(16));
        imageView5.setImageDrawable(dVar.G(13));
        this.f4301I = dVar.G(12);
        D.g0(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f4302J = typedArrayObtainStyledAttributes.getResourceId(15, R.layout.abc_search_dropdown_item_icons_2line);
        this.f4303K = typedArrayObtainStyledAttributes.getResourceId(5, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(c0839r0);
        searchAutoComplete.setOnEditorActionListener(c0847v0);
        searchAutoComplete.setOnItemClickListener(c0849w0);
        searchAutoComplete.setOnItemSelectedListener(z6);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0843t0(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes.getBoolean(8, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.N = typedArrayObtainStyledAttributes.getText(6);
        this.f4311U = typedArrayObtainStyledAttributes.getText(11);
        int i6 = typedArrayObtainStyledAttributes.getInt(3, -1);
        if (i6 != -1) {
            setImeOptions(i6);
        }
        int i7 = typedArrayObtainStyledAttributes.getInt(2, -1);
        if (i7 != -1) {
            setInputType(i7);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(0, true));
        dVar.S();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f4304L = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f4305M = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f4294B = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0845u0(this));
        }
        u(this.f4307Q);
        r();
    }

    public void setOnCloseListener(InterfaceC0851x0 interfaceC0851x0) {
    }

    public void setOnQueryTextListener(y0 y0Var) {
    }

    public void setOnSuggestionListener(z0 z0Var) {
    }
}
