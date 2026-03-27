package p;

import android.R;
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
import h.AbstractC1656a;
import h.AbstractC1660e;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class M extends Y.c implements View.OnClickListener {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final SearchView f21264l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final SearchableInfo f21265m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Context f21266n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final WeakHashMap f21267o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f21268p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f21269q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f21270r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public ColorStateList f21271s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f21272t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f21273u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f21274v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f21275w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f21276x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f21277y;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextView f21278a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextView f21279b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f21280c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f21281d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final ImageView f21282e;

        public a(View view) {
            this.f21278a = (TextView) view.findViewById(R.id.text1);
            this.f21279b = (TextView) view.findViewById(R.id.text2);
            this.f21280c = (ImageView) view.findViewById(R.id.icon1);
            this.f21281d = (ImageView) view.findViewById(R.id.icon2);
            this.f21282e = (ImageView) view.findViewById(AbstractC1660e.f14431k);
        }
    }

    public M(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f21269q = false;
        this.f21270r = 1;
        this.f21272t = -1;
        this.f21273u = -1;
        this.f21274v = -1;
        this.f21275w = -1;
        this.f21276x = -1;
        this.f21277y = -1;
        this.f21264l = searchView;
        this.f21265m = searchableInfo;
        this.f21268p = searchView.getSuggestionCommitIconResId();
        this.f21266n = context;
        this.f21267o = weakHashMap;
    }

    public static String o(Cursor cursor, String str) {
        return w(cursor, cursor.getColumnIndex(str));
    }

    public static String w(Cursor cursor, int i7) {
        if (i7 == -1) {
            return null;
        }
        try {
            return cursor.getString(i7);
        } catch (Exception e7) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e7);
            return null;
        }
    }

    public final void A(String str, Drawable drawable) {
        if (drawable != null) {
            this.f21267o.put(str, drawable.getConstantState());
        }
    }

    public final void B(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // Y.a, Y.b.a
    public void a(Cursor cursor) {
        if (this.f21269q) {
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
                this.f21272t = cursor.getColumnIndex("suggest_text_1");
                this.f21273u = cursor.getColumnIndex("suggest_text_2");
                this.f21274v = cursor.getColumnIndex("suggest_text_2_url");
                this.f21275w = cursor.getColumnIndex("suggest_icon_1");
                this.f21276x = cursor.getColumnIndex("suggest_icon_2");
                this.f21277y = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e7) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e7);
        }
    }

    @Override // Y.a, Y.b.a
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
        if (this.f21265m.shouldRewriteQueryFromData() && (strO2 = o(cursor, "suggest_intent_data")) != null) {
            return strO2;
        }
        if (!this.f21265m.shouldRewriteQueryFromText() || (strO = o(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strO;
    }

    @Override // Y.b.a
    public Cursor d(CharSequence charSequence) {
        String string = charSequence == null ? "" : charSequence.toString();
        if (this.f21264l.getVisibility() == 0 && this.f21264l.getWindowVisibility() == 0) {
            try {
                Cursor cursorV = v(this.f21265m, string, 50);
                if (cursorV != null) {
                    cursorV.getCount();
                    return cursorV;
                }
            } catch (RuntimeException e7) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e7);
            }
        }
        return null;
    }

    @Override // Y.a
    public void e(View view, Context context, Cursor cursor) {
        a aVar = (a) view.getTag();
        int i7 = this.f21277y;
        int i8 = i7 != -1 ? cursor.getInt(i7) : 0;
        if (aVar.f21278a != null) {
            z(aVar.f21278a, w(cursor, this.f21272t));
        }
        if (aVar.f21279b != null) {
            String strW = w(cursor, this.f21274v);
            CharSequence charSequenceL = strW != null ? l(strW) : w(cursor, this.f21273u);
            if (TextUtils.isEmpty(charSequenceL)) {
                TextView textView = aVar.f21278a;
                if (textView != null) {
                    textView.setSingleLine(false);
                    aVar.f21278a.setMaxLines(2);
                }
            } else {
                TextView textView2 = aVar.f21278a;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    aVar.f21278a.setMaxLines(1);
                }
            }
            z(aVar.f21279b, charSequenceL);
        }
        ImageView imageView = aVar.f21280c;
        if (imageView != null) {
            y(imageView, t(cursor), 4);
        }
        ImageView imageView2 = aVar.f21281d;
        if (imageView2 != null) {
            y(imageView2, u(cursor), 8);
        }
        int i9 = this.f21270r;
        if (i9 != 2 && (i9 != 1 || (i8 & 1) == 0)) {
            aVar.f21282e.setVisibility(8);
            return;
        }
        aVar.f21282e.setVisibility(0);
        aVar.f21282e.setTag(aVar.f21278a.getText());
        aVar.f21282e.setOnClickListener(this);
    }

    @Override // Y.a, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i7, view, viewGroup);
        } catch (RuntimeException e7) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e7);
            View viewG = g(this.f21266n, b(), viewGroup);
            if (viewG != null) {
                ((a) viewG.getTag()).f21278a.setText(e7.toString());
            }
            return viewG;
        }
    }

    @Override // Y.a, android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i7, view, viewGroup);
        } catch (RuntimeException e7) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e7);
            View viewH = h(this.f21266n, b(), viewGroup);
            if (viewH != null) {
                ((a) viewH.getTag()).f21278a.setText(e7.toString());
            }
            return viewH;
        }
    }

    @Override // Y.c, Y.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewH = super.h(context, cursor, viewGroup);
        viewH.setTag(new a(viewH));
        ((ImageView) viewH.findViewById(AbstractC1660e.f14431k)).setImageResource(this.f21268p);
        return viewH;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable k(String str) {
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f21267o.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    public final CharSequence l(CharSequence charSequence) {
        if (this.f21271s == null) {
            TypedValue typedValue = new TypedValue();
            this.f21266n.getTheme().resolveAttribute(AbstractC1656a.f14352s, typedValue, true);
            this.f21271s = this.f21266n.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f21271s, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    public final Drawable m(ComponentName componentName) {
        PackageManager packageManager = this.f21266n.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
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
        } catch (PackageManager.NameNotFoundException e7) {
            Log.w("SuggestionsAdapter", e7.toString());
            return null;
        }
    }

    public final Drawable n(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.f21267o.containsKey(strFlattenToShortString)) {
            Drawable drawableM = m(componentName);
            this.f21267o.put(strFlattenToShortString, drawableM != null ? drawableM.getConstantState() : null);
            return drawableM;
        }
        Drawable.ConstantState constantState = (Drawable.ConstantState) this.f21267o.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.f21266n.getResources());
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
            this.f21264l.T((CharSequence) tag);
        }
    }

    public final Drawable p() {
        Drawable drawableN = n(this.f21265m.getSearchActivity());
        return drawableN != null ? drawableN : this.f21266n.getPackageManager().getDefaultActivityIcon();
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
            InputStream inputStreamOpenInputStream = this.f21266n.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                return Drawable.createFromStream(inputStreamOpenInputStream, null);
            } finally {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e7) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e7);
                }
            }
        } catch (FileNotFoundException e8) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e8.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e8.getMessage());
        return null;
    }

    public Drawable r(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f21266n.getPackageManager().getResourcesForApplication(authority);
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
            int i7 = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f21266n.getPackageName() + "/" + i7;
            Drawable drawableK = k(str2);
            if (drawableK != null) {
                return drawableK;
            }
            Drawable drawable = G.a.getDrawable(this.f21266n, i7);
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
        int i7 = this.f21275w;
        if (i7 == -1) {
            return null;
        }
        Drawable drawableS = s(cursor.getString(i7));
        return drawableS != null ? drawableS : p();
    }

    public final Drawable u(Cursor cursor) {
        int i7 = this.f21276x;
        if (i7 == -1) {
            return null;
        }
        return s(cursor.getString(i7));
    }

    public Cursor v(SearchableInfo searchableInfo, String str, int i7) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query("").fragment("");
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
        if (i7 > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i7));
        }
        return this.f21266n.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    public void x(int i7) {
        this.f21270r = i7;
    }

    public final void y(ImageView imageView, Drawable drawable, int i7) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i7);
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
