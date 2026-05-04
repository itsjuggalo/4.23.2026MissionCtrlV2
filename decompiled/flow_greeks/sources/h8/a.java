package h8;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f11107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f11108b;

    public a(List list, List list2) {
        if (list.size() != list2.size() - 1) {
            throw new IllegalArgumentException("Number of posts need to be n-1 for n hashes in CompoundHash");
        }
        this.f11107a = list;
        this.f11108b = list2;
    }

    public List a() {
        return Collections.unmodifiableList(this.f11108b);
    }

    public List b() {
        return Collections.unmodifiableList(this.f11107a);
    }
}
