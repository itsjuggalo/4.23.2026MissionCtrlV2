package b3;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8567a;

    public r(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f8567a = list;
    }
}
