package o;

import android.R;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.sessions.settings.RemoteSettings;
import g.AbstractC1248a;
import g.AbstractC1252e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;
import x.AbstractC1909a;

/* JADX INFO: loaded from: classes.dex */
public class V extends P.c implements View.OnClickListener {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f13756A;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SearchManager f13757m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SearchView f13758n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SearchableInfo f13759o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Context f13760p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final WeakHashMap f13761q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f13762r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f13763s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f13764t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ColorStateList f13765u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f13766v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f13767w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f13768x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f13769y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f13770z;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f13771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f13772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f13773c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f13774d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f13775e;

        public a(View view) {
            this.f13771a = (TextView) view.findViewById(R.id.text1);
            this.f13772b = (TextView) view.findViewById(R.id.text2);
            this.f13773c = (ImageView) view.findViewById(R.id.icon1);
            this.f13774d = (ImageView) view.findViewById(R.id.icon2);
            this.f13775e = (ImageView) view.findViewById(AbstractC1252e.f11636k);
        }
    }

    public V(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f13763s = false;
        this.f13764t = 1;
        this.f13766v = -1;
        this.f13767w = -1;
        this.f13768x = -1;
        this.f13769y = -1;
        this.f13770z = -1;
        this.f13756A = -1;
        this.f13757m = (SearchManager) this.f3370e.getSystemService(FirebaseAnalytics.Event.SEARCH);
        this.f13758n = searchView;
        this.f13759o = searchableInfo;
        this.f13762r = searchView.getSuggestionCommitIconResId();
        this.f13760p = context;
        this.f13761q = weakHashMap;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    public static String w(Cursor cursor, int i4) {
        if (i4 == -1) {
            return null;
        }
        try {
            return cursor.getString(i4);
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e4);
            return null;
        }
    }

    public final void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f13761q.put(str, drawable.getConstantState());
        }
    }

    public final void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // P.a, P.b.a
    public void a(Cursor cursor) {
        if (this.f13763s) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.f13766v = cursor.getColumnIndex("suggest_text_1");
                this.f13767w = cursor.getColumnIndex("suggest_text_2");
                this.f13768x = cursor.getColumnIndex("suggest_text_2_url");
                this.f13769y = cursor.getColumnIndex("suggest_icon_1");
                this.f13770z = cursor.getColumnIndex("suggest_icon_2");
                this.f13756A = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e4) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e4);
        }
    }

    @Override // P.a, P.b.a
    public CharSequence c(Cursor cursor) {
        String strO;
        String strO2;
        if (cursor == null) {
            return null;
        }
        String strO3 = o(cursor, "suggest_intent_query");
        if (strO3 != null) {
            return strO3;
        }
        if (this.f13759o.shouldRewriteQueryFromData() && (strO2 = o(cursor, "suggest_intent_data")) != null) {
            return strO2;
        }
        if (!this.f13759o.shouldRewriteQueryFromText() || (strO = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strO;
    }

    @Override // P.b.a
    public Cursor d(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f13758n.getVisibility() == 0 && this.f13758n.getWindowVisibility() == 0) {
            try {
                Cursor cursorV = v(this.f13759o, string, 50);
                if (cursorV != null) {
                    cursorV.getCount();
                    return cursorV;
                }
            } catch (RuntimeException e4) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e4);
            }
        }
        return null;
    }

    @Override // P.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i4 = this.f13756A;
        int i5 = i4 != -1 ? cursor.getInt(i4) : 0;
        if (aVar.f13771a != null) {
            z(aVar.f13771a, w(cursor, this.f13766v));
        }
        if (aVar.f13772b != null) {
            String strW = w(cursor, this.f13768x);
            CharSequence charSequenceL = strW != null ? l(strW) : w(cursor, this.f13767w);
            if (TextUtils.isEmpty(charSequenceL)) {
                TextView textView = aVar.f13771a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f13771a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f13771a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f13771a.setMaxLines(1);
                }
            }
            z(aVar.f13772b, charSequenceL);
        }
        ImageView imageView = aVar.f13773c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f13774d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i6 = this.f13764t;
        if (i6 != 2 && (i6 != 1 || (i5 & 1) == 0)) {
            aVar.f13775e.setVisibility(8);
            return;
        }
        aVar.f13775e.setVisibility(0);
        aVar.f13775e.setTag(aVar.f13771a.getText());
        aVar.f13775e.setOnClickListener(this);
    }

    @Override // P.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View viewG = g(this.f3370e, this.f3369c, viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f13771a.setText(e4.toString());
            }
            return viewG;
        }
    }

    @Override // P.a, android.widget.Adapter
    public View getView(int i4, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i4, view, viewGroup);
        } catch (RuntimeException e4) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e4);
            View viewH = h(this.f3370e, this.f3369c, viewGroup);
            if (viewH != null) {
                ((a) viewH.getTag()).f13771a.setText(e4.toString());
            }
            return viewH;
        }
    }

    @Override // P.c, P.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewH = super.h(context, cursor, viewGroup);
        viewH.setTag(new a(viewH));
        ((ImageView) viewH.findViewById(AbstractC1252e.f11636k)).setImageResource(this.f13762r);
        return viewH;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f13761q.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence l(CharSequence charSequence) {
        if (this.f13765u == null) {
            TypedValue typedValue = new TypedValue();
            this.f3370e.getTheme().resolveAttribute(AbstractC1248a.f11559r, typedValue, true);
            this.f13765u = this.f3370e.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f13765u, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f3370e.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, UserMetadata.MAX_ROLLOUT_ASSIGNMENTS);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.w("SuggestionsAdapter", e4.toString());
            return null;
        }
    }

    public final Drawable n(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f13761q.containsKey(strFlattenToShortString)) {
            Drawable drawableM = m(componentName);
            this.f13761q.put(strFlattenToShortString, drawableM != null ? drawableM.getConstantState() : null);
            return drawableM;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f13761q.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f13760p.getResources());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        B(b());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        B(b());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f13758n.R((CharSequence) tag);
        }
    }

    public final Drawable p(Cursor cursor) {
        Drawable drawableN = n(this.f13759o.getSearchActivity());
        return drawableN != null ? drawableN : this.f3370e.getPackageManager().getDefaultActivityIcon();
    }

    public final Drawable q(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return r(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.f13760p.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    return drawableCreateFromStream;
                } catch (IOException e4) {
                    return drawableCreateFromStream;
                }
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e42) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e42);
                }
            }
        } catch (FileNotFoundException e5) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e5.getMessage());
        return null;
    }

    public Drawable r(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f3370e.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public final Drawable s(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i4 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f13760p.getPackageName() + RemoteSettings.FORWARD_SLASH_STRING + i4;
            Drawable drawableK = k(str2);
            if (drawableK != null) {
                return drawableK;
            }
            Drawable drawable = AbstractC1909a.getDrawable(this.f13760p, i4);
            A(str2, drawable);
            return drawable;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableK2 = k(str);
            if (drawableK2 != null) {
                return drawableK2;
            }
            Drawable drawableQ = q(Uri.parse(str));
            A(str, drawableQ);
            return drawableQ;
        }
    }

    public final Drawable t(Cursor cursor) {
        int i4 = this.f13769y;
        if (i4 == -1) {
            return null;
        }
        Drawable drawableS = s(cursor.getString(i4));
        return drawableS != null ? drawableS : p(cursor);
    }

    public final Drawable u(Cursor cursor) {
        int i4 = this.f13770z;
        if (i4 == -1) {
            return null;
        }
        return s(cursor.getString(i4));
    }

    public Cursor v(SearchableInfo searchableInfo, String str, int i4) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i4 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i4));
        }
        return this.f3370e.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i4) {
        this.f13764t = i4;
    }

    public final void y(ImageView imageView, Drawable drawable, int i4) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i4);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    public final void z(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
