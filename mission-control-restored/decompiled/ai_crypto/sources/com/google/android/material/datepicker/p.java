package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public abstract class p extends LinearLayoutManager {

    public class a extends androidx.recyclerview.widget.g {
        public a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.g
        public float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    public p(Context context, int i7, boolean z7) {
        super(context, i7, z7);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void I1(RecyclerView recyclerView, RecyclerView.z zVar, int i7) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i7);
        J1(aVar);
    }
}
