package M2;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5334a;

    public r(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f5334a = list;
    }
}
