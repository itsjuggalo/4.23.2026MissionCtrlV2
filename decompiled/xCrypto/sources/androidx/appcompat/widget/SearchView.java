package androidx.appcompat.widget;

import H.E;
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
import com.google.firebase.sessions.settings.RemoteSettings;
import g.AbstractC1248a;
import g.AbstractC1250c;
import g.AbstractC1252e;
import g.AbstractC1253f;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import m.InterfaceC1593b;
import o.AbstractC1637c;
import o.V;
import o.a0;
import o.c0;
import o.g0;

/* JADX INFO: loaded from: classes.dex */
public class SearchView extends androidx.appcompat.widget.b implements InterfaceC1593b {

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public static final k f6583o0 = new k();

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public Rect f6584A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public Rect f6585B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public int[] f6586C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public int[] f6587D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public final ImageView f6588E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public final Drawable f6589F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public final int f6590G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public final int f6591H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public final Intent f6592I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final Intent f6593J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public final CharSequence f6594K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public View.OnFocusChangeListener f6595L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public View.OnClickListener f6596M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public boolean f6597N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public boolean f6598O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public P.a f6599P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public boolean f6600Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public CharSequence f6601R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public boolean f6602S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public boolean f6603T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public int f6604U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public boolean f6605V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public CharSequence f6606W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public CharSequence f6607a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f6608b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f6609c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public SearchableInfo f6610d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public Bundle f6611e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final Runnable f6612f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Runnable f6613g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final WeakHashMap f6614h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final View.OnClickListener f6615i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public View.OnKeyListener f6616j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final TextView.OnEditorActionListener f6617k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final AdapterView.OnItemClickListener f6618l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final AdapterView.OnItemSelectedListener f6619m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public TextWatcher f6620n0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final SearchAutoComplete f6621q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final View f6622r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final View f6623s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final View f6624t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ImageView f6625u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ImageView f6626v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ImageView f6627w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final ImageView f6628x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final View f6629y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p f6630z;

    public static class SearchAutoComplete extends AbstractC1637c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public SearchView f6632f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f6633g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Runnable f6634h;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                SearchAutoComplete.this.b();
            }
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, AbstractC1248a.f11548g);
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i4 = configuration.screenWidthDp;
            int i5 = configuration.screenHeightDp;
            if (i4 >= 960 && i5 >= 720 && configuration.orientation == 2) {
                return 256;
            }
            if (i4 < 600) {
                return (i4 < 640 || i5 < 480) ? 160 : 192;
            }
            return 192;
        }

        public boolean a() {
            return TextUtils.getTrimmedLength(getText()) == 0;
        }

        public void b() {
            if (this.f6633g) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                this.f6633g = false;
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public boolean enoughToFilter() {
            return this.f6631e <= 0 || super.enoughToFilter();
        }

        @Override // o.AbstractC1637c, android.widget.TextView, android.view.View
        public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f6633g) {
                removeCallbacks(this.f6634h);
                post(this.f6634h);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onFocusChanged(boolean z4, int i4, Rect rect) {
            super.onFocusChanged(z4, i4, rect);
            this.f6632f.W();
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public boolean onKeyPreIme(int i4, KeyEvent keyEvent) {
            if (i4 == 4) {
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
                        this.f6632f.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i4, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public void onWindowFocusChanged(boolean z4) {
            super.onWindowFocusChanged(z4);
            if (z4 && this.f6632f.hasFocus() && getVisibility() == 0) {
                this.f6633g = true;
                if (SearchView.J(getContext())) {
                    SearchView.f6583o0.c(this, true);
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z4) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            if (!z4) {
                this.f6633g = false;
                removeCallbacks(this.f6634h);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f6633g = true;
                    return;
                }
                this.f6633g = false;
                removeCallbacks(this.f6634h);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.f6632f = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i4) {
            super.setThreshold(i4);
            this.f6631e = i4;
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i4) {
            super(context, attributeSet, i4);
            this.f6634h = new a();
            this.f6631e = getThreshold();
        }
    }

    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            SearchView.this.V(charSequence);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SearchView.this.c0();
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            P.a aVar = SearchView.this.f6599P;
            if (aVar instanceof V) {
                aVar.a(null);
            }
        }
    }

    public class d implements View.OnFocusChangeListener {
        public d() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z4) {
            SearchView searchView = SearchView.this;
            View.OnFocusChangeListener onFocusChangeListener = searchView.f6595L;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onFocusChange(searchView, z4);
            }
        }
    }

    public class e implements View.OnLayoutChangeListener {
        public e() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11) {
            SearchView.this.y();
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SearchView searchView = SearchView.this;
            if (view == searchView.f6625u) {
                searchView.S();
                return;
            }
            if (view == searchView.f6627w) {
                searchView.O();
                return;
            }
            if (view == searchView.f6626v) {
                searchView.T();
            } else if (view == searchView.f6628x) {
                searchView.X();
            } else if (view == searchView.f6621q) {
                searchView.E();
            }
        }
    }

    public class g implements View.OnKeyListener {
        public g() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i4, KeyEvent keyEvent) {
            SearchView searchView = SearchView.this;
            if (searchView.f6610d0 == null) {
                return false;
            }
            if (searchView.f6621q.isPopupShowing() && SearchView.this.f6621q.getListSelection() != -1) {
                return SearchView.this.U(view, i4, keyEvent);
            }
            if (SearchView.this.f6621q.a() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i4 != 66) {
                return false;
            }
            view.cancelLongPress();
            SearchView searchView2 = SearchView.this;
            searchView2.M(0, null, searchView2.f6621q.getText().toString());
            return true;
        }
    }

    public class h implements TextView.OnEditorActionListener {
        public h() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i4, KeyEvent keyEvent) {
            SearchView.this.T();
            return true;
        }
    }

    public class i implements AdapterView.OnItemClickListener {
        public i() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i4, long j4) {
            SearchView.this.P(i4, 0, null);
        }
    }

    public class j implements AdapterView.OnItemSelectedListener {
        public j() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i4, long j4) {
            SearchView.this.Q(i4);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    public static class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Method f6646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Method f6647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Method f6648c;

        public k() {
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f6646a = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f6647b = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                this.f6648c = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
        }

        public void a(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f6647b;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void b(AutoCompleteTextView autoCompleteTextView) {
            Method method = this.f6646a;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception unused) {
                }
            }
        }

        public void c(AutoCompleteTextView autoCompleteTextView, boolean z4) {
            Method method = this.f6648c;
            if (method != null) {
                try {
                    method.invoke(autoCompleteTextView, Boolean.valueOf(z4));
                } catch (Exception unused) {
                }
            }
        }
    }

    public interface l {
    }

    public interface m {
    }

    public interface n {
    }

    public static class o extends Q.a {
        public static final Parcelable.Creator<o> CREATOR = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f6649c;

        public static class a implements Parcelable.ClassLoaderCreator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel) {
                return new o(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public o createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new o(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public o[] newArray(int i4) {
                return new o[i4];
            }
        }

        public o(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f6649c + "}";
        }

        @Override // Q.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i4) {
            super.writeToParcel(parcel, i4);
            parcel.writeValue(Boolean.valueOf(this.f6649c));
        }

        public o(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f6649c = ((Boolean) parcel.readValue(null)).booleanValue();
        }
    }

    public static class p extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f6650a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f6651b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Rect f6652c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Rect f6653d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f6654e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f6655f;

        public p(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f6654e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f6651b = new Rect();
            this.f6653d = new Rect();
            this.f6652c = new Rect();
            a(rect, rect2);
            this.f6650a = view;
        }

        public void a(Rect rect, Rect rect2) {
            this.f6651b.set(rect);
            this.f6653d.set(rect);
            Rect rect3 = this.f6653d;
            int i4 = this.f6654e;
            rect3.inset(-i4, -i4);
            this.f6652c.set(rect2);
        }

        @Override // android.view.TouchDelegate
        public boolean onTouchEvent(MotionEvent motionEvent) {
            boolean z4;
            boolean z5;
            int x4 = (int) motionEvent.getX();
            int y4 = (int) motionEvent.getY();
            int action = motionEvent.getAction();
            boolean z6 = true;
            if (action != 0) {
                if (action == 1 || action == 2) {
                    z5 = this.f6655f;
                    if (z5 && !this.f6653d.contains(x4, y4)) {
                        z6 = z5;
                        z4 = false;
                    }
                } else {
                    if (action == 3) {
                        z5 = this.f6655f;
                        this.f6655f = false;
                    }
                    z4 = true;
                    z6 = false;
                }
                z6 = z5;
                z4 = true;
            } else if (this.f6651b.contains(x4, y4)) {
                this.f6655f = true;
                z4 = true;
            } else {
                z4 = true;
                z6 = false;
            }
            if (!z6) {
                return false;
            }
            if (!z4 || this.f6652c.contains(x4, y4)) {
                Rect rect = this.f6652c;
                motionEvent.setLocation(x4 - rect.left, y4 - rect.top);
            } else {
                motionEvent.setLocation(this.f6650a.getWidth() / 2, this.f6650a.getHeight() / 2);
            }
            return this.f6650a.dispatchTouchEvent(motionEvent);
        }
    }

    public SearchView(Context context) {
        this(context, null);
    }

    public static boolean J(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(AbstractC1250c.f11572e);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(AbstractC1250c.f11573f);
    }

    private void setQuery(CharSequence charSequence) {
        this.f6621q.setText(charSequence);
        this.f6621q.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public final Intent A(Cursor cursor, int i4, String str) {
        int position;
        String strO;
        try {
            String strO2 = V.o(cursor, "suggest_intent_action");
            if (strO2 == null) {
                strO2 = this.f6610d0.getSuggestIntentAction();
            }
            if (strO2 == null) {
                strO2 = "android.intent.action.SEARCH";
            }
            String str2 = strO2;
            String strO3 = V.o(cursor, "suggest_intent_data");
            if (strO3 == null) {
                strO3 = this.f6610d0.getSuggestIntentData();
            }
            if (strO3 != null && (strO = V.o(cursor, "suggest_intent_data_id")) != null) {
                strO3 = strO3 + RemoteSettings.FORWARD_SLASH_STRING + Uri.encode(strO);
            }
            return z(str2, strO3 == null ? null : Uri.parse(strO3), V.o(cursor, "suggest_intent_extra_data"), V.o(cursor, "suggest_intent_query"), i4, str);
        } catch (RuntimeException e4) {
            try {
                position = cursor.getPosition();
            } catch (RuntimeException unused) {
                position = -1;
            }
            Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e4);
            return null;
        }
    }

    public final Intent B(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1073741824);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f6611e0;
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

    public final Intent C(Intent intent, SearchableInfo searchableInfo) {
        Intent intent2 = new Intent(intent);
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        intent2.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
        return intent2;
    }

    public final void D() {
        this.f6621q.dismissDropDown();
    }

    public void E() {
        if (Build.VERSION.SDK_INT >= 29) {
            this.f6621q.refreshAutoCompleteResults();
            return;
        }
        k kVar = f6583o0;
        kVar.b(this.f6621q);
        kVar.a(this.f6621q);
    }

    public final void F(View view, Rect rect) {
        view.getLocationInWindow(this.f6586C);
        getLocationInWindow(this.f6587D);
        int[] iArr = this.f6586C;
        int i4 = iArr[1];
        int[] iArr2 = this.f6587D;
        int i5 = i4 - iArr2[1];
        int i6 = iArr[0] - iArr2[0];
        rect.set(i6, i5, view.getWidth() + i6, view.getHeight() + i5);
    }

    public final CharSequence G(CharSequence charSequence) {
        if (!this.f6597N || this.f6589F == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f6621q.getTextSize()) * 1.25d);
        this.f6589F.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f6589F), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    public final boolean H() {
        SearchableInfo searchableInfo = this.f6610d0;
        if (searchableInfo != null && searchableInfo.getVoiceSearchEnabled()) {
            Intent intent = this.f6610d0.getVoiceSearchLaunchWebSearch() ? this.f6592I : this.f6610d0.getVoiceSearchLaunchRecognizer() ? this.f6593J : null;
            if (intent != null && getContext().getPackageManager().resolveActivity(intent, 65536) != null) {
                return true;
            }
        }
        return false;
    }

    public boolean I() {
        return this.f6598O;
    }

    public final boolean K() {
        return (this.f6600Q || this.f6605V) && !I();
    }

    public final void L(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            getContext().startActivity(intent);
        } catch (RuntimeException e4) {
            Log.e("SearchView", "Failed launch activity: " + intent, e4);
        }
    }

    public void M(int i4, String str, String str2) {
        getContext().startActivity(z("android.intent.action.SEARCH", null, null, str2, i4, str));
    }

    public final boolean N(int i4, int i5, String str) {
        Cursor cursorB = this.f6599P.b();
        if (cursorB == null || !cursorB.moveToPosition(i4)) {
            return false;
        }
        L(A(cursorB, i5, str));
        return true;
    }

    public void O() {
        if (!TextUtils.isEmpty(this.f6621q.getText())) {
            this.f6621q.setText("");
            this.f6621q.requestFocus();
            this.f6621q.setImeVisibility(true);
        } else if (this.f6597N) {
            clearFocus();
            h0(true);
        }
    }

    public boolean P(int i4, int i5, String str) {
        N(i4, 0, null);
        this.f6621q.setImeVisibility(false);
        D();
        return true;
    }

    public boolean Q(int i4) {
        Z(i4);
        return true;
    }

    public void R(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void S() {
        h0(false);
        this.f6621q.requestFocus();
        this.f6621q.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f6596M;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void T() {
        Editable text = this.f6621q.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f6610d0 != null) {
            M(0, null, text.toString());
        }
        this.f6621q.setImeVisibility(false);
        D();
    }

    public boolean U(View view, int i4, KeyEvent keyEvent) {
        if (this.f6610d0 != null && this.f6599P != null && keyEvent.getAction() == 0 && keyEvent.hasNoModifiers()) {
            if (i4 == 66 || i4 == 84 || i4 == 61) {
                return P(this.f6621q.getListSelection(), 0, null);
            }
            if (i4 == 21 || i4 == 22) {
                this.f6621q.setSelection(i4 == 21 ? 0 : this.f6621q.length());
                this.f6621q.setListSelection(0);
                this.f6621q.clearListSelection();
                f6583o0.c(this.f6621q, true);
                return true;
            }
            if (i4 == 19) {
                this.f6621q.getListSelection();
                return false;
            }
        }
        return false;
    }

    public void V(CharSequence charSequence) {
        Editable text = this.f6621q.getText();
        this.f6607a0 = text;
        boolean zIsEmpty = TextUtils.isEmpty(text);
        g0(!zIsEmpty);
        i0(zIsEmpty);
        b0();
        f0();
        this.f6606W = charSequence.toString();
    }

    public void W() {
        h0(I());
        Y();
        if (this.f6621q.hasFocus()) {
            E();
        }
    }

    public void X() {
        SearchableInfo searchableInfo = this.f6610d0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (searchableInfo.getVoiceSearchLaunchWebSearch()) {
                getContext().startActivity(C(this.f6592I, searchableInfo));
            } else if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                getContext().startActivity(B(this.f6593J, searchableInfo));
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }

    public final void Y() {
        post(this.f6612f0);
    }

    public final void Z(int i4) {
        Editable text = this.f6621q.getText();
        Cursor cursorB = this.f6599P.b();
        if (cursorB == null) {
            return;
        }
        if (!cursorB.moveToPosition(i4)) {
            setQuery(text);
            return;
        }
        CharSequence charSequenceC = this.f6599P.c(cursorB);
        if (charSequenceC != null) {
            setQuery(charSequenceC);
        } else {
            setQuery(text);
        }
    }

    public void a0(CharSequence charSequence, boolean z4) {
        this.f6621q.setText(charSequence);
        if (charSequence != null) {
            SearchAutoComplete searchAutoComplete = this.f6621q;
            searchAutoComplete.setSelection(searchAutoComplete.length());
            this.f6607a0 = charSequence;
        }
        if (!z4 || TextUtils.isEmpty(charSequence)) {
            return;
        }
        T();
    }

    @Override // m.InterfaceC1593b
    public void b() {
        if (this.f6608b0) {
            return;
        }
        this.f6608b0 = true;
        int imeOptions = this.f6621q.getImeOptions();
        this.f6609c0 = imeOptions;
        this.f6621q.setImeOptions(imeOptions | 33554432);
        this.f6621q.setText("");
        setIconified(false);
    }

    public final void b0() {
        boolean zIsEmpty = TextUtils.isEmpty(this.f6621q.getText());
        this.f6627w.setVisibility(!zIsEmpty || (this.f6597N && !this.f6608b0) ? 0 : 8);
        Drawable drawable = this.f6627w.getDrawable();
        if (drawable != null) {
            drawable.setState(!zIsEmpty ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    @Override // m.InterfaceC1593b
    public void c() {
        a0("", false);
        clearFocus();
        h0(true);
        this.f6621q.setImeOptions(this.f6609c0);
        this.f6608b0 = false;
    }

    public void c0() {
        int[] iArr = this.f6621q.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f6623s.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f6624t.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void clearFocus() {
        this.f6603T = true;
        super.clearFocus();
        this.f6621q.clearFocus();
        this.f6621q.setImeVisibility(false);
        this.f6603T = false;
    }

    public final void d0() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f6621q;
        if (queryHint == null) {
            queryHint = "";
        }
        searchAutoComplete.setHint(G(queryHint));
    }

    public final void e0() {
        this.f6621q.setThreshold(this.f6610d0.getSuggestThreshold());
        this.f6621q.setImeOptions(this.f6610d0.getImeOptions());
        int inputType = this.f6610d0.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f6610d0.getSuggestAuthority() != null) {
                inputType |= 589824;
            }
        }
        this.f6621q.setInputType(inputType);
        P.a aVar = this.f6599P;
        if (aVar != null) {
            aVar.a(null);
        }
        if (this.f6610d0.getSuggestAuthority() != null) {
            V v4 = new V(getContext(), this, this.f6610d0, this.f6614h0);
            this.f6599P = v4;
            this.f6621q.setAdapter(v4);
            ((V) this.f6599P).x(this.f6602S ? 2 : 1);
        }
    }

    public final void f0() {
        this.f6624t.setVisibility((K() && (this.f6626v.getVisibility() == 0 || this.f6628x.getVisibility() == 0)) ? 0 : 8);
    }

    public final void g0(boolean z4) {
        this.f6626v.setVisibility((this.f6600Q && K() && hasFocus() && (z4 || !this.f6605V)) ? 0 : 8);
    }

    public int getImeOptions() {
        return this.f6621q.getImeOptions();
    }

    public int getInputType() {
        return this.f6621q.getInputType();
    }

    public int getMaxWidth() {
        return this.f6604U;
    }

    public CharSequence getQuery() {
        return this.f6621q.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f6601R;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f6610d0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f6594K : getContext().getText(this.f6610d0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.f6591H;
    }

    public int getSuggestionRowLayout() {
        return this.f6590G;
    }

    public P.a getSuggestionsAdapter() {
        return this.f6599P;
    }

    public final void h0(boolean z4) {
        this.f6598O = z4;
        int i4 = 8;
        int i5 = z4 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f6621q.getText());
        this.f6625u.setVisibility(i5);
        g0(!zIsEmpty);
        this.f6622r.setVisibility(z4 ? 8 : 0);
        if (this.f6588E.getDrawable() != null && !this.f6597N) {
            i4 = 0;
        }
        this.f6588E.setVisibility(i4);
        b0();
        i0(zIsEmpty);
        f0();
    }

    public final void i0(boolean z4) {
        int i4 = 8;
        if (this.f6605V && !I() && z4) {
            this.f6626v.setVisibility(8);
            i4 = 0;
        }
        this.f6628x.setVisibility(i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.f6612f0);
        post(this.f6613g0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.b, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i4, int i5, int i6, int i7) {
        super.onLayout(z4, i4, i5, i6, i7);
        if (z4) {
            F(this.f6621q, this.f6584A);
            Rect rect = this.f6585B;
            Rect rect2 = this.f6584A;
            rect.set(rect2.left, 0, rect2.right, i7 - i5);
            p pVar = this.f6630z;
            if (pVar != null) {
                pVar.a(this.f6585B, this.f6584A);
                return;
            }
            p pVar2 = new p(this.f6585B, this.f6584A, this.f6621q);
            this.f6630z = pVar2;
            setTouchDelegate(pVar2);
        }
    }

    @Override // androidx.appcompat.widget.b, android.view.View
    public void onMeasure(int i4, int i5) {
        int i6;
        if (I()) {
            super.onMeasure(i4, i5);
            return;
        }
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == Integer.MIN_VALUE) {
            int i7 = this.f6604U;
            size = i7 > 0 ? Math.min(i7, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f6604U;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i6 = this.f6604U) > 0) {
            size = Math.min(i6, size);
        }
        int mode2 = View.MeasureSpec.getMode(i5);
        int size2 = View.MeasureSpec.getSize(i5);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof o)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        o oVar = (o) parcelable;
        super.onRestoreInstanceState(oVar.a());
        h0(oVar.f6649c);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        o oVar = new o(super.onSaveInstanceState());
        oVar.f6649c = I();
        return oVar;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        Y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean requestFocus(int i4, Rect rect) {
        if (this.f6603T || !isFocusable()) {
            return false;
        }
        if (I()) {
            return super.requestFocus(i4, rect);
        }
        boolean zRequestFocus = this.f6621q.requestFocus(i4, rect);
        if (zRequestFocus) {
            h0(false);
        }
        return zRequestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f6611e0 = bundle;
    }

    public void setIconified(boolean z4) {
        if (z4) {
            O();
        } else {
            S();
        }
    }

    public void setIconifiedByDefault(boolean z4) {
        if (this.f6597N == z4) {
            return;
        }
        this.f6597N = z4;
        h0(z4);
        d0();
    }

    public void setImeOptions(int i4) {
        this.f6621q.setImeOptions(i4);
    }

    public void setInputType(int i4) {
        this.f6621q.setInputType(i4);
    }

    public void setMaxWidth(int i4) {
        this.f6604U = i4;
        requestLayout();
    }

    public void setOnCloseListener(l lVar) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f6595L = onFocusChangeListener;
    }

    public void setOnQueryTextListener(m mVar) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f6596M = onClickListener;
    }

    public void setOnSuggestionListener(n nVar) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f6601R = charSequence;
        d0();
    }

    public void setQueryRefinementEnabled(boolean z4) {
        this.f6602S = z4;
        P.a aVar = this.f6599P;
        if (aVar instanceof V) {
            ((V) aVar).x(z4 ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f6610d0 = searchableInfo;
        if (searchableInfo != null) {
            e0();
            d0();
        }
        boolean zH = H();
        this.f6605V = zH;
        if (zH) {
            this.f6621q.setPrivateImeOptions("nm");
        }
        h0(I());
    }

    public void setSubmitButtonEnabled(boolean z4) {
        this.f6600Q = z4;
        h0(I());
    }

    public void setSuggestionsAdapter(P.a aVar) {
        this.f6599P = aVar;
        this.f6621q.setAdapter(aVar);
    }

    public void y() {
        if (this.f6629y.getWidth() > 1) {
            Resources resources = getContext().getResources();
            int paddingLeft = this.f6623s.getPaddingLeft();
            Rect rect = new Rect();
            boolean zB = g0.b(this);
            int dimensionPixelSize = this.f6597N ? resources.getDimensionPixelSize(AbstractC1250c.f11570c) + resources.getDimensionPixelSize(AbstractC1250c.f11571d) : 0;
            this.f6621q.getDropDownBackground().getPadding(rect);
            this.f6621q.setDropDownHorizontalOffset(zB ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            this.f6621q.setDropDownWidth((((this.f6629y.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }

    public final Intent z(String str, Uri uri, String str2, String str3, int i4, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f6607a0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f6611e0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        if (i4 != 0) {
            intent.putExtra("action_key", i4);
            intent.putExtra("action_msg", str4);
        }
        intent.setComponent(this.f6610d0.getSearchActivity());
        return intent;
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, AbstractC1248a.f11557p);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f6584A = new Rect();
        this.f6585B = new Rect();
        this.f6586C = new int[2];
        this.f6587D = new int[2];
        this.f6612f0 = new b();
        this.f6613g0 = new c();
        this.f6614h0 = new WeakHashMap();
        f fVar = new f();
        this.f6615i0 = fVar;
        this.f6616j0 = new g();
        h hVar = new h();
        this.f6617k0 = hVar;
        i iVar = new i();
        this.f6618l0 = iVar;
        j jVar = new j();
        this.f6619m0 = jVar;
        this.f6620n0 = new a();
        a0 a0VarR = a0.r(context, attributeSet, g.i.f11688C1, i4, 0);
        LayoutInflater.from(context).inflate(a0VarR.l(g.i.f11728M1, AbstractC1253f.f11663l), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(AbstractC1252e.f11645t);
        this.f6621q = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f6622r = findViewById(AbstractC1252e.f11641p);
        View viewFindViewById = findViewById(AbstractC1252e.f11644s);
        this.f6623s = viewFindViewById;
        View viewFindViewById2 = findViewById(AbstractC1252e.f11651z);
        this.f6624t = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(AbstractC1252e.f11639n);
        this.f6625u = imageView;
        ImageView imageView2 = (ImageView) findViewById(AbstractC1252e.f11642q);
        this.f6626v = imageView2;
        ImageView imageView3 = (ImageView) findViewById(AbstractC1252e.f11640o);
        this.f6627w = imageView3;
        ImageView imageView4 = (ImageView) findViewById(AbstractC1252e.f11646u);
        this.f6628x = imageView4;
        ImageView imageView5 = (ImageView) findViewById(AbstractC1252e.f11643r);
        this.f6588E = imageView5;
        E.I(viewFindViewById, a0VarR.f(g.i.f11732N1));
        E.I(viewFindViewById2, a0VarR.f(g.i.f11748R1));
        imageView.setImageDrawable(a0VarR.f(g.i.f11744Q1));
        imageView2.setImageDrawable(a0VarR.f(g.i.f11720K1));
        imageView3.setImageDrawable(a0VarR.f(g.i.f11708H1));
        imageView4.setImageDrawable(a0VarR.f(g.i.f11756T1));
        imageView5.setImageDrawable(a0VarR.f(g.i.f11744Q1));
        this.f6589F = a0VarR.f(g.i.f11740P1);
        c0.a(imageView, getResources().getString(g.g.f11676l));
        this.f6590G = a0VarR.l(g.i.f11752S1, AbstractC1253f.f11662k);
        this.f6591H = a0VarR.l(g.i.f11712I1, 0);
        imageView.setOnClickListener(fVar);
        imageView3.setOnClickListener(fVar);
        imageView2.setOnClickListener(fVar);
        imageView4.setOnClickListener(fVar);
        searchAutoComplete.setOnClickListener(fVar);
        searchAutoComplete.addTextChangedListener(this.f6620n0);
        searchAutoComplete.setOnEditorActionListener(hVar);
        searchAutoComplete.setOnItemClickListener(iVar);
        searchAutoComplete.setOnItemSelectedListener(jVar);
        searchAutoComplete.setOnKeyListener(this.f6616j0);
        searchAutoComplete.setOnFocusChangeListener(new d());
        setIconifiedByDefault(a0VarR.a(g.i.f11724L1, true));
        int iE = a0VarR.e(g.i.f11696E1, -1);
        if (iE != -1) {
            setMaxWidth(iE);
        }
        this.f6594K = a0VarR.n(g.i.f11716J1);
        this.f6601R = a0VarR.n(g.i.f11736O1);
        int i5 = a0VarR.i(g.i.f11704G1, -1);
        if (i5 != -1) {
            setImeOptions(i5);
        }
        int i6 = a0VarR.i(g.i.f11700F1, -1);
        if (i6 != -1) {
            setInputType(i6);
        }
        setFocusable(a0VarR.a(g.i.f11692D1, true));
        a0VarR.s();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f6592I = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f6593J = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f6629y = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new e());
        }
        h0(this.f6597N);
        d0();
    }
}
