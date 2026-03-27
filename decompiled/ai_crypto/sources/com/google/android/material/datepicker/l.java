package com.google.android.material.datepicker;

import android.content.Context;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class l extends BaseAdapter {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f11600e = r.i().getMaximum(4);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f11601f = (r.i().getMaximum(5) + r.i().getMaximum(7)) - 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f11602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Collection f11603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f11604c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f11605d;

    public l(k kVar, d dVar, a aVar) {
        this.f11602a = kVar;
        this.f11605d = aVar;
        this.f11603b = dVar.u();
    }

    public int a(int i7) {
        return b() + (i7 - 1);
    }

    public int b() {
        return this.f11602a.j(this.f11605d.i());
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i7) {
        if (i7 < b() || i7 > g()) {
            return null;
        }
        return Long.valueOf(this.f11602a.k(h(i7)));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.widget.TextView getView(int r6, android.view.View r7, android.view.ViewGroup r8) {
        /*
            r5 = this;
            android.content.Context r0 = r8.getContext()
            r5.e(r0)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r7 != 0) goto L1e
            android.content.Context r7 = r8.getContext()
            android.view.LayoutInflater r7 = android.view.LayoutInflater.from(r7)
            int r0 = n2.g.f19224j
            android.view.View r7 = r7.inflate(r0, r8, r1)
            r0 = r7
            android.widget.TextView r0 = (android.widget.TextView) r0
        L1e:
            int r7 = r5.b()
            int r7 = r6 - r7
            if (r7 < 0) goto L75
            com.google.android.material.datepicker.k r8 = r5.f11602a
            int r2 = r8.f11597e
            if (r7 < r2) goto L2d
            goto L75
        L2d:
            r2 = 1
            int r7 = r7 + r2
            r0.setTag(r8)
            android.content.res.Resources r8 = r0.getResources()
            android.content.res.Configuration r8 = r8.getConfiguration()
            java.util.Locale r8 = r8.locale
            java.lang.Integer r3 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r3 = new java.lang.Object[]{r3}
            java.lang.String r4 = "%d"
            java.lang.String r8 = java.lang.String.format(r8, r4, r3)
            r0.setText(r8)
            com.google.android.material.datepicker.k r8 = r5.f11602a
            long r7 = r8.k(r7)
            com.google.android.material.datepicker.k r3 = r5.f11602a
            int r3 = r3.f11595c
            com.google.android.material.datepicker.k r4 = com.google.android.material.datepicker.k.i()
            int r4 = r4.f11595c
            if (r3 != r4) goto L67
            java.lang.String r7 = com.google.android.material.datepicker.e.a(r7)
            r0.setContentDescription(r7)
            goto L6e
        L67:
            java.lang.String r7 = com.google.android.material.datepicker.e.d(r7)
            r0.setContentDescription(r7)
        L6e:
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L7d
        L75:
            r7 = 8
            r0.setVisibility(r7)
            r0.setEnabled(r1)
        L7d:
            java.lang.Long r6 = r5.getItem(r6)
            if (r6 != 0) goto L84
            return r0
        L84:
            long r6 = r6.longValue()
            r5.i(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.l.getView(int, android.view.View, android.view.ViewGroup):android.widget.TextView");
    }

    public final void e(Context context) {
        if (this.f11604c == null) {
            this.f11604c = new c(context);
        }
    }

    public final boolean f(long j7) {
        throw null;
    }

    public int g() {
        return (b() + this.f11602a.f11597e) - 1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return f11601f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return i7 / this.f11602a.f11596d;
    }

    public int h(int i7) {
        return (i7 - b()) + 1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    public final void i(TextView textView, long j7) {
        b bVar;
        if (textView == null) {
            return;
        }
        if (this.f11605d.g().t(j7)) {
            textView.setEnabled(true);
            bVar = f(j7) ? this.f11604c.f11514b : r.g().getTimeInMillis() == j7 ? this.f11604c.f11515c : this.f11604c.f11513a;
        } else {
            textView.setEnabled(false);
            bVar = this.f11604c.f11519g;
        }
        bVar.b(textView);
    }

    public final void j(MaterialCalendarGridView materialCalendarGridView, long j7) {
        if (k.h(j7).equals(this.f11602a)) {
            i((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(this.f11602a.m(j7)) - materialCalendarGridView.getFirstVisiblePosition()), j7);
        }
    }

    public void k(MaterialCalendarGridView materialCalendarGridView) {
        Iterator it = this.f11603b.iterator();
        while (it.hasNext()) {
            j(materialCalendarGridView, ((Long) it.next()).longValue());
        }
    }

    public boolean l(int i7) {
        return i7 >= b() && i7 <= g();
    }
}
