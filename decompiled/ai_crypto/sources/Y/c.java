package Y;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f5516i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5517j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LayoutInflater f5518k;

    public c(Context context, int i7, Cursor cursor, boolean z7) {
        super(context, cursor, z7);
        this.f5517j = i7;
        this.f5516i = i7;
        this.f5518k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // Y.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f5518k.inflate(this.f5517j, viewGroup, false);
    }

    @Override // Y.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f5518k.inflate(this.f5516i, viewGroup, false);
    }
}
