package P;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3378j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3379k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public LayoutInflater f3380l;

    public c(Context context, int i4, Cursor cursor, boolean z4) {
        super(context, cursor, z4);
        this.f3379k = i4;
        this.f3378j = i4;
        this.f3380l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // P.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3380l.inflate(this.f3379k, viewGroup, false);
    }

    @Override // P.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f3380l.inflate(this.f3378j, viewGroup, false);
    }
}
