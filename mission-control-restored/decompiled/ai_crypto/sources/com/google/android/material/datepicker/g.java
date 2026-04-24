package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class g extends BaseAdapter {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f11522d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Calendar f11523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f11525c;

    static {
        f11522d = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public g() {
        Calendar calendarI = r.i();
        this.f11523a = calendarI;
        this.f11524b = calendarI.getMaximum(7);
        this.f11525c = calendarI.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer getItem(int i7) {
        if (i7 >= this.f11524b) {
            return null;
        }
        return Integer.valueOf(b(i7));
    }

    public final int b(int i7) {
        int i8 = i7 + this.f11525c;
        int i9 = this.f11524b;
        return i8 > i9 ? i8 - i9 : i8;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11524b;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i7) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i7, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(n2.g.f19225k, viewGroup, false);
        }
        this.f11523a.set(7, b(i7));
        textView.setText(this.f11523a.getDisplayName(7, f11522d, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(n2.h.f19241j), this.f11523a.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public g(int i7) {
        Calendar calendarI = r.i();
        this.f11523a = calendarI;
        this.f11524b = calendarI.getMaximum(7);
        this.f11525c = i7;
    }
}
