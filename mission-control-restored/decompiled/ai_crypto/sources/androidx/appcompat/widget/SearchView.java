package androidx.appcompat.widget;

import Q.N;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.TextView;
import h.AbstractC1656a;
import h.AbstractC1658c;
import h.AbstractC1660e;
import h.AbstractC1661f;
import h.AbstractC1662g;
import h.AbstractC1664i;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import n.InterfaceC2246b;
import p.AbstractC2342c;
import p.M;
import p.S;
import p.W;
import p.c0;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends androidx.appcompat.widget.b implements InterfaceC2246b {

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public static final o f6736n0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public Rect f6737A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public int[] f6738B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int[] f6739C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public final ImageView f6740D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final Drawable f6741E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final int f6742F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final int f6743G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final Intent f6744H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final Intent f6745I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final CharSequence f6746J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public View.OnFocusChangeListener f6747K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public View.OnClickListener f6748L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public boolean f6749M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f6750N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public Y.a f6751O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public boolean f6752P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public CharSequence f6753Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public boolean f6754R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f6755S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public int f6756T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public boolean f6757U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public CharSequence f6758V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public CharSequence f6759W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f6760a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f6761b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public SearchableInfo f6762c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public Bundle f6763d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Runnable f6764e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public Runnable f6765f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final WeakHashMap f6766g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final View.OnClickListener f6767h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public View.OnKeyListener f6768i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final TextView.OnEditorActionListener f6769j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f6770k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f6771l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public TextWatcher f6772m0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SearchAutoComplete f6773p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final View f6774q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f6775r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f6776s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ImageView f6777t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f6778u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f6779v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f6780w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final View f6781x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q f6782y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Rect f6783z;

    public static class SearchAutoComplete extends AbstractC2342c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6784e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SearchView f6785f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f6786g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Runnable f6787h;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.d();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, AbstractC1656a.f14340g);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i7 = configuration.screenWidthDp;
            int i8 = configuration.screenHeightDp;
            if (i7 >= 960 && i8 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i7 < 600) {
                return (i7 < 640 || i8 < 480) ? 160 : 192;
            }
            return 192;
        }

        public void b() {
            if (Build.VERSION.SDK_INT < 29) {
                SearchView.f6736n0.c(this);
                return;
            }
            k.b(this, 1);
            if (enoughToFilter()) {
                showDropDown();
            }
        }

        public boolean c() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void d() {
            if (this.f6786g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f6786g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f6784e <= 0 || super.enoughToFilter();
        }

        @Override // p.AbstractC2342c, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f6786g) {
                removeCallbacks(this.f6787h);
                post(this.f6787h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z7, int i7, Rect rect) {
            super.onFocusChanged(z7, i7, rect);
            this.f6785f.Y();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i7, KeyEvent keyEvent) {
            if (i7 == 4) {
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
                        this.f6785f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i7, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z7) {
            super.onWindowFocusChanged(z7);
            if (z7 && this.f6785f.hasFocus() && getVisibility() == 0) {
                this.f6786g = true;
                if (SearchView.L(getContext())) {
                    b();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z7) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z7) {
                this.f6786g = false;
                removeCallbacks(this.f6787h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f6786g = true;
                    return;
                }
                this.f6786g = false;
                removeCallbacks(this.f6787h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f6785f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i7) {
            super.setThreshold(i7);
            this.f6784e = i7;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i7) {
            super(context, attributeSet, i7);
            this.f6787h = new a();
            this.f6784e = getThreshold();
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i7, int i8, int i9) {
            SearchView.this.X(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.e0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Y.a aVar = SearchView.this.f6751O;
            if (aVar instanceof M) {
                aVar.a(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z7) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f6747K;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z7);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14) {
            SearchView.this.A();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f6777t) {
                searchView.U();
                return;
            }
            if (view == searchView.f6779v) {
                searchView.Q();
                return;
            }
            if (view == searchView.f6778u) {
                searchView.V();
            } else if (view == searchView.f6780w) {
                searchView.Z();
            } else if (view == searchView.f6773p) {
                searchView.G();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i7, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f6762c0 == null) {
                return false;
            }
            if (searchView.f6773p.isPopupShowing() && SearchView.this.f6773p.getListSelection() != -1) {
                return SearchView.this.W(view, i7, keyEvent);
            }
            if (SearchView.this.f6773p.c() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i7 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.O(0, null, searchView2.f6773p.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i7, KeyEvent keyEvent) {
            SearchView.this.V();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
            SearchView.this.R(i7, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i7, long j7) {
            SearchView.this.S(i7);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static class k {
        public static void a(AutoCompleteTextView autoCompleteTextView) {
            autoCompleteTextView.refreshAutoCompleteResults();
        }

        public static void b(SearchAutoComplete searchAutoComplete, int i7) {
            searchAutoComplete.setInputMethodMode(i7);
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f6799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f6800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Method f6801c;

        public o() {
            this.f6799a = null;
            this.f6800b = null;
            this.f6801c = null;
            d();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                this.f6799a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                this.f6800b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f6801c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public static void d() {
            if (Build.VERSION.SDK_INT >= 29) {
                throw new UnsupportedClassVersionError("This function can only be used for API Level < 29.");
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f6800b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f6799a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, null);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView) {
            d();
            Method method = this.f6801c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static class p extends Z.a {
        public static final Parcelable.Creator<p> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6802c;

        public class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel) {
                return new p(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public p createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new p(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public p[] newArray(int i7) {
                return new p[i7];
            }
        }

        public p(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f6802c + "}";
        }

        @Override // Z.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i7) {
            super.writeToParcel(parcel, i7);
            parcel.writeValue(Boolean.valueOf(this.f6802c));
        }

        public p(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6802c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class q extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f6803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f6804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f6805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f6806d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f6807e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6808f;

        public q(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f6807e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f6804b = new Rect();
            this.f6806d = new Rect();
            this.f6805c = new Rect();
            a(rect, rect2);
            this.f6803a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f6804b.set(rect);
            this.f6806d.set(rect);
            Rect rect3 = this.f6806d;
            int i7 = this.f6807e;
            rect3.inset(-i7, -i7);
            this.f6805c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z7;
            boolean z8;
            int x7 = (int) motionEvent.getX();
            int y7 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z9 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z8 = this.f6808f;
                    if (z8 && !this.f6806d.contains(x7, y7)) {
                        z9 = z8;
                        z7 = false;
                    }
                } else {
                    if (action == 3) {
                        z8 = this.f6808f;
                        this.f6808f = false;
                    }
                    z7 = true;
                    z9 = false;
                }
                z9 = z8;
                z7 = true;
            } else if (this.f6804b.contains(x7, y7)) {
                this.f6808f = true;
                z7 = true;
            } else {
                z7 = true;
                z9 = false;
            }
            if (!z9) {
                return false;
            }
            if (!z7 || this.f6805c.contains(x7, y7)) {
                Rect rect = this.f6805c;
                motionEvent.setLocation(x7 - rect.left, y7 - rect.top);
            } else {
                motionEvent.setLocation(this.f6803a.getWidth() / 2, this.f6803a.getHeight() / 2);
            }
            return this.f6803a.dispatchTouchEvent(motionEvent);
        }
    }

    static {
        f6736n0 = Build.VERSION.SDK_INT < 29 ? new o() : null;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public static boolean L(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(AbstractC1658c.f14365e);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(AbstractC1658c.f14366f);
    }

    private void setQuery(CharSequence charSequence) {
        this.f6773p.setText(charSequence);
        this.f6773p.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void A() {
        if (this.f6781x.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f6775r.getPaddingLeft();
            Rect rect = new Rect();
            boolean zA = c0.a(this);
            int dimensionPixelSize = this.f6749M ? resources.getDimensionPixelSize(AbstractC1658c.f14363c) + resources.getDimensionPixelSize(AbstractC1658c.f14364d) : 0;
            this.f6773p.getDropDownBackground().getPadding(rect);
            this.f6773p.setDropDownHorizontalOffset(zA ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f6773p.setDropDownWidth((((this.f6781x.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final Intent B(String str, Uri uri, String str2, String str3, int i7, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f6759W);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f6763d0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i7 != 0) {
            intent.putExtra("action_key", i7);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f6762c0.getSearchActivity());
        return intent;
    }

    public final Intent C(Cursor cursor, int i7, String str) {
        int position;
        String strO;
        try {
            String strO2 = M.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.f6762c0.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = M.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.f6762c0.getSuggestIntentData();
            }
            if (strO3 != null && (strO = M.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + "/" + Uri.encode(strO);
            }
            return B(str2, strO3 == null ? null : Uri.parse(strO3), M.o(cursor, "suggest_intent_extra_data"), M.o(cursor, "suggest_intent_query"), i7, str);
        } catch (RuntimeException e7) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e7);
            return null;
        }
    }

    public final Intent D(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f6763d0;
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

    public final Intent E(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void F() {
        this.f6773p.dismissDropDown();
    }

    public void G() {
        if (Build.VERSION.SDK_INT >= 29) {
            k.a(this.f6773p);
            return;
        }
        o oVar = f6736n0;
        oVar.b(this.f6773p);
        oVar.a(this.f6773p);
    }

    public final void H(View view, Rect rect) {
        view.getLocationInWindow(this.f6738B);
        getLocationInWindow(this.f6739C);
        int[] iArr = this.f6738B;
        int i7 = iArr[1];
        int[] iArr2 = this.f6739C;
        int i8 = i7 - iArr2[1];
        int i9 = iArr[0] - iArr2[0];
        rect.set(i9, i8, view.getWidth() + i9, view.getHeight() + i8);
    }

    public final CharSequence I(CharSequence charSequence) {
        if (!this.f6749M || this.f6741E == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f6773p.getTextSize()) * 1.25d);
        this.f6741E.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f6741E), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean J() {
        SearchableInfo searchableInfo = this.f6762c0;
        if (searchableInfo == null || !searchableInfo.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = this.f6762c0.getVoiceSearchLaunchWebSearch() ? this.f6744H : this.f6762c0.getVoiceSearchLaunchRecognizer() ? this.f6745I : null;
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    public boolean K() {
        return this.f6750N;
    }

    public final boolean M() {
        return (this.f6752P || this.f6757U) && !K();
    }

    public final void N(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e7) {
            Log.e("SearchView", "Failed launch activity: " + intent, e7);
        }
    }

    public void O(int i7, String str, String str2) {
        getContext().startActivity(B("android.intent.action.SEARCH", null, null, str2, i7, str));
    }

    public final boolean P(int i7, int i8, String str) {
        Cursor cursorB = this.f6751O.b();
        if (cursorB == null || !cursorB.moveToPosition(i7)) {
            return false;
        }
        N(C(cursorB, i8, str));
        return true;
    }

    public void Q() {
        if (!TextUtils.isEmpty(this.f6773p.getText())) {
            this.f6773p.setText("");
            this.f6773p.requestFocus();
            this.f6773p.setImeVisibility(true);
        } else if (this.f6749M) {
            clearFocus();
            j0(true);
        }
    }

    public boolean R(int i7, int i8, String str) {
        P(i7, 0, null);
        this.f6773p.setImeVisibility(false);
        F();
        return true;
    }

    public boolean S(int i7) {
        b0(i7);
        return true;
    }

    public void T(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void U() {
        j0(false);
        this.f6773p.requestFocus();
        this.f6773p.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f6748L;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void V() {
        Editable text = this.f6773p.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f6762c0 != null) {
            O(0, null, text.toString());
        }
        this.f6773p.setImeVisibility(false);
        F();
    }

    public boolean W(View view, int i7, KeyEvent keyEvent) {
        if (this.f6762c0 != null && this.f6751O != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i7 == 66 || i7 == 84 || i7 == 61) {
                return R(this.f6773p.getListSelection(), 0, null);
            }
            if (i7 == 21 || i7 == 22) {
                this.f6773p.setSelection(i7 == 21 ? 0 : this.f6773p.length());
                this.f6773p.setListSelection(0);
                this.f6773p.clearListSelection();
                this.f6773p.b();
                return true;
            }
            if (i7 == 19) {
                this.f6773p.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void X(CharSequence charSequence) {
        Editable text = this.f6773p.getText();
        this.f6759W = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        i0(!zIsEmpty);
        k0(zIsEmpty);
        d0();
        h0();
        this.f6758V = charSequence.toString();
    }

    public void Y() {
        j0(K());
        a0();
        if (this.f6773p.hasFocus()) {
            G();
        }
    }

    public void Z() {
        SearchableInfo searchableInfo = this.f6762c0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(E(this.f6744H, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(D(this.f6745I, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public final void a0() {
        post(this.f6764e0);
    }

    @Override // n.InterfaceC2246b
    public void b() {
        if (this.f6760a0) {
            return;
        }
        this.f6760a0 = true;
        int imeOptions = this.f6773p.getImeOptions();
        this.f6761b0 = imeOptions;
        this.f6773p.setImeOptions(imeOptions | 33554432);
        this.f6773p.setText("");
        setIconified(false);
    }

    public final void b0(int i7) {
        Editable text = this.f6773p.getText();
        Cursor cursorB = this.f6751O.b();
        if (cursorB == null) {
            return;
        }
        if (!cursorB.moveToPosition(i7)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceC = this.f6751O.c(cursorB);
        if (charSequenceC != null) {
            setQuery(charSequenceC);
        } else {
            setQuery(text);
        }
    }

    public void c0(CharSequence charSequence, boolean z7) {
        this.f6773p.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f6773p;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f6759W = charSequence;
        }
        if (!z7 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        V();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f6755S = true;
        super.clearFocus();
        this.f6773p.clearFocus();
        this.f6773p.setImeVisibility(false);
        this.f6755S = false;
    }

    public final void d0() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f6773p.getText());
        this.f6779v.setVisibility(!zIsEmpty || (this.f6749M && !this.f6760a0) ? 0 : 8);
        Drawable drawable = this.f6779v.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // n.InterfaceC2246b
    public void e() {
        c0("", false);
        clearFocus();
        j0(true);
        this.f6773p.setImeOptions(this.f6761b0);
        this.f6760a0 = false;
    }

    public void e0() {
        int[] iArr = this.f6773p.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f6775r.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f6776s.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void f0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f6773p;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(I(queryHint));
    }

    public final void g0() {
        this.f6773p.setThreshold(this.f6762c0.getSuggestThreshold());
        this.f6773p.setImeOptions(this.f6762c0.getImeOptions());
        int inputType = this.f6762c0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f6762c0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f6773p.setInputType(inputType);
        Y.a aVar = this.f6751O;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f6762c0.getSuggestAuthority() != null) {
            M m7 = new M(getContext(), this, this.f6762c0, this.f6766g0);
            this.f6751O = m7;
            this.f6773p.setAdapter(m7);
            ((M) this.f6751O).x(this.f6754R ? 2 : 1);
        }
    }

    public int getImeOptions() {
        return this.f6773p.getImeOptions();
    }

    public int getInputType() {
        return this.f6773p.getInputType();
    }

    public int getMaxWidth() {
        return this.f6756T;
    }

    public CharSequence getQuery() {
        return this.f6773p.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f6753Q;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f6762c0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f6746J : getContext().getText(this.f6762c0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f6743G;
    }

    public int getSuggestionRowLayout() {
        return this.f6742F;
    }

    public Y.a getSuggestionsAdapter() {
        return this.f6751O;
    }

    public final void h0() {
        this.f6776s.setVisibility((M() && (this.f6778u.getVisibility() == 0 || this.f6780w.getVisibility() == 0)) ? 0 : 8);
    }

    public final void i0(boolean z7) {
        this.f6778u.setVisibility((this.f6752P && M() && hasFocus() && (z7 || !this.f6757U)) ? 0 : 8);
    }

    public final void j0(boolean z7) {
        this.f6750N = z7;
        int i7 = 8;
        int i8 = z7 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f6773p.getText());
        this.f6777t.setVisibility(i8);
        i0(!zIsEmpty);
        this.f6774q.setVisibility(z7 ? 8 : 0);
        if (this.f6740D.getDrawable() != null && !this.f6749M) {
            i7 = 0;
        }
        this.f6740D.setVisibility(i7);
        d0();
        k0(zIsEmpty);
        h0();
    }

    public final void k0(boolean z7) {
        int i7 = 8;
        if (this.f6757U && !K() && z7) {
            this.f6778u.setVisibility(8);
            i7 = 0;
        }
        this.f6780w.setVisibility(i7);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f6764e0);
        post(this.f6765f0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z7, int i7, int i8, int i9, int i10) {
        super.onLayout(z7, i7, i8, i9, i10);
        if (z7) {
            H(this.f6773p, this.f6783z);
            Rect rect = this.f6737A;
            Rect rect2 = this.f6783z;
            rect.set(rect2.left, 0, rect2.right, i10 - i8);
            q qVar = this.f6782y;
            if (qVar != null) {
                qVar.a(this.f6737A, this.f6783z);
                return;
            }
            q qVar2 = new q(this.f6737A, this.f6783z, this.f6773p);
            this.f6782y = qVar2;
            setTouchDelegate(qVar2);
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public void onMeasure(int i7, int i8) {
        int i9;
        if (K()) {
            super.onMeasure(i7, i8);
            return;
        }
        int mode = View.MeasureSpec.getMode(i7);
        int size = View.MeasureSpec.getSize(i7);
        if (mode == Integer.MIN_VALUE) {
            int i10 = this.f6756T;
            size = i10 > 0 ? Math.min(i10, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f6756T;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i9 = this.f6756T) > 0) {
            size = Math.min(i9, size);
        }
        int mode2 = View.MeasureSpec.getMode(i8);
        int size2 = View.MeasureSpec.getSize(i8);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof p)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        p pVar = (p) parcelable;
        super.onRestoreInstanceState(pVar.a());
        j0(pVar.f6802c);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        p pVar = new p(super.onSaveInstanceState());
        pVar.f6802c = K();
        return pVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z7) {
        super.onWindowFocusChanged(z7);
        a0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i7, Rect rect) {
        if (this.f6755S || !isFocusable()) {
            return false;
        }
        if (K()) {
            return super.requestFocus(i7, rect);
        }
        boolean zRequestFocus = this.f6773p.requestFocus(i7, rect);
        if (zRequestFocus) {
            j0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f6763d0 = bundle;
    }

    public void setIconified(boolean z7) {
        if (z7) {
            Q();
        } else {
            U();
        }
    }

    public void setIconifiedByDefault(boolean z7) {
        if (this.f6749M == z7) {
            return;
        }
        this.f6749M = z7;
        j0(z7);
        f0();
    }

    public void setImeOptions(int i7) {
        this.f6773p.setImeOptions(i7);
    }

    public void setInputType(int i7) {
        this.f6773p.setInputType(i7);
    }

    public void setMaxWidth(int i7) {
        this.f6756T = i7;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f6747K = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f6748L = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f6753Q = charSequence;
        f0();
    }

    public void setQueryRefinementEnabled(boolean z7) {
        this.f6754R = z7;
        Y.a aVar = this.f6751O;
        if (aVar instanceof M) {
            ((M) aVar).x(z7 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f6762c0 = searchableInfo;
        if (searchableInfo != null) {
            g0();
            f0();
        }
        boolean zJ = J();
        this.f6757U = zJ;
        if (zJ) {
            this.f6773p.setPrivateImeOptions("nm");
        }
        j0(K());
    }

    public void setSubmitButtonEnabled(boolean z7) {
        this.f6752P = z7;
        j0(K());
    }

    public void setSuggestionsAdapter(Y.a aVar) {
        this.f6751O = aVar;
        this.f6773p.setAdapter(aVar);
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1656a.f14350q);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet, i7);
        this.f6783z = new Rect();
        this.f6737A = new Rect();
        this.f6738B = new int[2];
        this.f6739C = new int[2];
        this.f6764e0 = new b();
        this.f6765f0 = new c();
        this.f6766g0 = new WeakHashMap();
        f fVar = new f();
        this.f6767h0 = fVar;
        this.f6768i0 = new g();
        h hVar = new h();
        this.f6769j0 = hVar;
        i iVar = new i();
        this.f6770k0 = iVar;
        j jVar = new j();
        this.f6771l0 = jVar;
        this.f6772m0 = new a();
        S sT = S.t(context, attributeSet, AbstractC1664i.f14478A1, i7, 0);
        N.j0(this, context, AbstractC1664i.f14478A1, attributeSet, sT.p(), i7, 0);
        LayoutInflater.from(context).inflate(sT.m(AbstractC1664i.f14518K1, AbstractC1661f.f14458l), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(AbstractC1660e.f14440t);
        this.f6773p = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f6774q = findViewById(AbstractC1660e.f14436p);
        View viewFindViewById = findViewById(AbstractC1660e.f14439s);
        this.f6775r = viewFindViewById;
        View viewFindViewById2 = findViewById(AbstractC1660e.f14446z);
        this.f6776s = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(AbstractC1660e.f14434n);
        this.f6777t = imageView;
        ImageView imageView2 = (ImageView) findViewById(AbstractC1660e.f14437q);
        this.f6778u = imageView2;
        ImageView imageView3 = (ImageView) findViewById(AbstractC1660e.f14435o);
        this.f6779v = imageView3;
        ImageView imageView4 = (ImageView) findViewById(AbstractC1660e.f14441u);
        this.f6780w = imageView4;
        ImageView imageView5 = (ImageView) findViewById(AbstractC1660e.f14438r);
        this.f6740D = imageView5;
        N.p0(viewFindViewById, sT.g(AbstractC1664i.f14522L1));
        N.p0(viewFindViewById2, sT.g(AbstractC1664i.f14538P1));
        imageView.setImageDrawable(sT.g(AbstractC1664i.f14534O1));
        imageView2.setImageDrawable(sT.g(AbstractC1664i.f14510I1));
        imageView3.setImageDrawable(sT.g(AbstractC1664i.f14498F1));
        imageView4.setImageDrawable(sT.g(AbstractC1664i.f14546R1));
        imageView5.setImageDrawable(sT.g(AbstractC1664i.f14534O1));
        this.f6741E = sT.g(AbstractC1664i.f14530N1);
        W.a(imageView, getResources().getString(AbstractC1662g.f14473n));
        this.f6742F = sT.m(AbstractC1664i.f14542Q1, AbstractC1661f.f14457k);
        this.f6743G = sT.m(AbstractC1664i.f14502G1, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f6772m0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f6768i0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(sT.a(AbstractC1664i.f14514J1, true));
        int iF = sT.f(AbstractC1664i.f14486C1, -1);
        if (iF != -1) {
            setMaxWidth(iF);
        }
        this.f6746J = sT.o(AbstractC1664i.f14506H1);
        this.f6753Q = sT.o(AbstractC1664i.f14526M1);
        int iJ = sT.j(AbstractC1664i.f14494E1, -1);
        if (iJ != -1) {
            setImeOptions(iJ);
        }
        int iJ2 = sT.j(AbstractC1664i.f14490D1, -1);
        if (iJ2 != -1) {
            setInputType(iJ2);
        }
        setFocusable(sT.a(AbstractC1664i.f14482B1, true));
        sT.u();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f6744H = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f6745I = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f6781x = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        j0(this.f6749M);
        f0();
    }
}
