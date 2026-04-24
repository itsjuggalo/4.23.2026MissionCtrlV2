package t;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: renamed from: t.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1099l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IconCompat f9814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharSequence f9815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PendingIntent f9816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9817d;
    public final Bundle e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList f9818f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9819g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f9820h;
    public boolean i;

    public C1099l(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
        Bundle bundle = new Bundle();
        this.f9817d = true;
        this.f9820h = true;
        this.f9814a = iconCompat;
        this.f9815b = C1105s.b(charSequence);
        this.f9816c = pendingIntent;
        this.e = bundle;
        this.f9818f = null;
        this.f9817d = true;
        this.f9819g = 0;
        this.f9820h = true;
        this.i = false;
    }

    public final C1100m a() {
        CharSequence[] charSequenceArr;
        if (this.i && this.f9816c == null) {
            throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<d0> arrayList3 = this.f9818f;
        if (arrayList3 != null) {
            for (d0 d0Var : arrayList3) {
                if (d0Var.f9809c || (!((charSequenceArr = d0Var.f9808b) == null || charSequenceArr.length == 0) || d0Var.e.isEmpty())) {
                    arrayList2.add(d0Var);
                } else {
                    arrayList.add(d0Var);
                }
            }
        }
        return new C1100m(this.f9814a, this.f9815b, this.f9816c, this.e, arrayList2.isEmpty() ? null : (d0[]) arrayList2.toArray(new d0[arrayList2.size()]), arrayList.isEmpty() ? null : (d0[]) arrayList.toArray(new d0[arrayList.size()]), this.f9817d, this.f9819g, this.f9820h, this.i);
    }
}
