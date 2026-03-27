package h4;

import java.util.ArrayList;

/* JADX INFO: renamed from: h4.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0636o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C0638q f6630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f6631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f6632d;

    public final ArrayList a() {
        ArrayList arrayList = new ArrayList(4);
        int i = this.f6629a;
        arrayList.add(i == 0 ? null : Integer.valueOf(S.i.c(i)));
        C0638q c0638q = this.f6630b;
        arrayList.add(c0638q != null ? c0638q.b() : null);
        arrayList.add(this.f6631c);
        arrayList.add(this.f6632d);
        return arrayList;
    }
}
