package f3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: f3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1744a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17388a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f17389b;

    public C1744a(List list, List list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f17388a = list;
        this.f17389b = list2;
    }

    public List a() {
        return Collections.unmodifiableList(this.f17389b);
    }

    public List b() {
        return Collections.unmodifiableList(this.f17388a);
    }
}
