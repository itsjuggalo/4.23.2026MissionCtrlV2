package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.d;
import p.S;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements d.b, h, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f6484c = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f6485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6486b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.d.b
    public boolean a(e eVar) {
        return this.f6485a.H(eVar, 0);
    }

    public int getWindowAnimations() {
        return this.f6486b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i7, long j7) {
        a((e) getAdapter().getItem(i7));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i7) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        S sT = S.t(context, attributeSet, f6484c, i7, 0);
        if (sT.q(0)) {
            setBackgroundDrawable(sT.g(0));
        }
        if (sT.q(1)) {
            setDivider(sT.g(1));
        }
        sT.u();
    }
}
