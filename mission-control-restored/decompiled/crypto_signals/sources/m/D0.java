package m;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import com.cryptosignals.ap.android.R;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class D0 extends L.c implements View.OnClickListener {

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final /* synthetic */ int f8214B = 0;

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public int f8215A;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f8216l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f8217m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LayoutInflater f8218n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final SearchView f8219o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SearchableInfo f8220p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Context f8221q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final WeakHashMap f8222r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f8223s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f8224t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ColorStateList f8225u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f8226v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f8227w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8228x;
    public int y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f8229z;

    public D0(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap weakHashMap) {
        int suggestionRowLayout = searchView.getSuggestionRowLayout();
        this.f1023b = true;
        this.f1024c = null;
        this.f1022a = false;
        this.f1025d = -1;
        this.e = new L.a(this);
        this.f1026f = new L.b(this, 0);
        this.f8217m = suggestionRowLayout;
        this.f8216l = suggestionRowLayout;
        this.f8218n = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f8224t = 1;
        this.f8226v = -1;
        this.f8227w = -1;
        this.f8228x = -1;
        this.y = -1;
        this.f8229z = -1;
        this.f8215A = -1;
        this.f8219o = searchView;
        this.f8220p = searchableInfo;
        this.f8223s = searchView.getSuggestionCommitIconResId();
        this.f8221q = context;
        this.f8222r = weakHashMap;
    }

    public static String h(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0131  */
    @Override // L.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.view.View r21, android.database.Cursor r22) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.D0.a(android.view.View, android.database.Cursor):void");
    }

    @Override // L.c
    public final void b(Cursor cursor) {
        try {
            super.b(cursor);
            if (cursor != null) {
                this.f8226v = cursor.getColumnIndex("suggest_text_1");
                this.f8227w = cursor.getColumnIndex("suggest_text_2");
                this.f8228x = cursor.getColumnIndex("suggest_text_2_url");
                this.y = cursor.getColumnIndex("suggest_icon_1");
                this.f8229z = cursor.getColumnIndex("suggest_icon_2");
                this.f8215A = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // L.c
    public final String c(Cursor cursor) {
        String strH;
        String strH2;
        if (cursor == null) {
            return null;
        }
        String strH3 = h(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (strH3 != null) {
            return strH3;
        }
        SearchableInfo searchableInfo = this.f8220p;
        if (searchableInfo.shouldRewriteQueryFromData() && (strH2 = h(cursor, cursor.getColumnIndex("suggest_intent_data"))) != null) {
            return strH2;
        }
        if (!searchableInfo.shouldRewriteQueryFromText() || (strH = h(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
            return null;
        }
        return strH;
    }

    @Override // L.c
    public final View d(ViewGroup viewGroup) {
        View viewInflate = this.f8218n.inflate(this.f8216l, viewGroup, false);
        viewInflate.setTag(new C0(viewInflate));
        ((ImageView) viewInflate.findViewById(R.id.edit_query)).setImageResource(this.f8223s);
        return viewInflate;
    }

    public final Drawable e(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f8221q.getPackageManager().getResourcesForApplication(authority);
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

    /* JADX WARN: Removed duplicated region for block: B:54:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable f(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m.D0.f(java.lang.String):android.graphics.drawable.Drawable");
    }

    public final Cursor g(SearchableInfo searchableInfo, String str) {
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
        builderFragment.appendQueryParameter("limit", String.valueOf(50));
        return this.f8221q.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    @Override // L.c, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewInflate = this.f8218n.inflate(this.f8217m, viewGroup, false);
            if (viewInflate != null) {
                ((C0) viewInflate.getTag()).f8210a.setText(e.toString());
            }
            return viewInflate;
        }
    }

    @Override // L.c, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewD = d(viewGroup);
            ((C0) viewD.getTag()).f8210a.setText(e.toString());
            return viewD;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        Cursor cursor = this.f1024c;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        Cursor cursor = this.f1024c;
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null) {
            extras.getBoolean("in_progress");
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f8219o.n((CharSequence) tag);
        }
    }
}
